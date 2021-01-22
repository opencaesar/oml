package io.opencaesar.oml.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;

class OmlCatalogManager implements Runnable {

	private static OmlCatalogManager instance = new OmlCatalogManager();

	private Thread thread;
	private boolean doStop = false;
	private WatchService watcher;
	private Map<WatchKey, File> watched;
	
	private Map<URI, Map<URI, URI>> importCache;
	private Map<URI, OmlCatalog> catalogCache;

	private OmlCatalogManager() {
		catalogCache = new HashMap<>();
		importCache = new HashMap<>();
		activate();
	}
	
	public void activate() {
		if (thread == null) {
			try {
				watcher = FileSystems.getDefault().newWatchService();
				watched = new HashMap<>();
				thread = new Thread(this, "CatalogManager");
				thread.start();
			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}

	public void deactivate() {
		try {
			doStop = true;
			thread.interrupt();
			thread = null;
			watched = null;
			watcher.close();
			cleanCache();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void cleanCache() {
		importCache.clear();
		catalogCache.clear();
	}
	
	public static OmlCatalogManager get(ResourceSet resourceSet) {
		List<Adapter> adapters = resourceSet.eAdapters();
		for (int i = 0, size = adapters.size(); i < size; ++i) {
			Object adapter = adapters.get(i);
			if (adapter instanceof Listener) {
				return instance;
			}
		}
		resourceSet.eAdapters().add(instance.new Listener());
		return instance;
	}

	protected File toFile(URI emfURI) {
		URI uri = CommonPlugin.asLocalURI(emfURI);
		return uri.isFile() ? new File(uri.toFileString()) : null;
	}

	protected URI toURI(File file) {
		return URI.createFileURI(file.getAbsolutePath());
	}

	protected List<File> getParents(File file) {
		final List<File> parents = new ArrayList<>();
		while (file.getParentFile() != null) {
			File parent = file.getParentFile();
			parents.add(parent);
			file = parent;
		}
		return parents;
	}

	public URI getResolvedUri(Resource contextResource, URI importUri) {
		URI contextURI = (contextResource != null) ? contextResource.getURI() : null;
		if (contextURI == null) {
			return null;
		}
		contextURI = contextURI.trimSegments(1);
		
		Map<URI, URI> importMap = importCache.get(contextURI);
		if (importMap == null) {
			importCache.put(contextURI, importMap = new HashMap<>());
		}
		
		if (importMap.containsKey(importUri)) {
			return importMap.get(importUri);
		}
		
		if (!catalogCache.containsKey(contextURI)) {
			findCatalogs(catalogCache, contextURI);
		}
		
		OmlCatalog catalog = catalogCache.get(contextURI);
		if (catalog == null) {
			return null;
		}

		final String resolved;
		try {
			resolved = catalog.resolveURI(importUri.toString());
			if (resolved == null) {
				importMap.put(importUri, null);
				return null;
			}
		} catch (Exception e) {
			System.err.println(e);
			importMap.put(importUri, null);
			return null;
		}

		ResourceSet rs = contextResource.getResourceSet();
		if (rs != null) {
			URIConverter converter = rs.getURIConverter();
			if (converter != null) {
				URI resolvedUri = URI.createURI(resolved+'.'+OmlConstants.OML_EXTENSION);
				if (!converter.exists(resolvedUri, null)) {
					resolvedUri = URI.createURI(resolved+'.'+OmlConstants.OMLXMI_EXTENSION);
					if (!converter.exists(resolvedUri, null)) {
						resolvedUri = URI.createURI(resolved);
					}
				}
				importMap.put(importUri, resolvedUri);
				return resolvedUri;
			}
		}
			
		URI resolvedUri = URI.createURI(resolved);
		importMap.put(importUri, resolvedUri);
		return resolvedUri;
	}
	
	protected void findCatalogs(Map<URI, OmlCatalog> catalogMap, URI folderUri) {
		final List<URI> uris = new ArrayList<>();
		OmlCatalog catalog = null;
		URI currentUri = folderUri;
		while (currentUri != null && catalog == null && currentUri.segmentCount() > 0) {
			uris.add(currentUri);
			URL catalogUrl = null;
			try {
				catalogUrl = new URL(currentUri.appendSegment("catalog.xml").toString());
			} catch (MalformedURLException e) {
				System.out.println(e);
			}
			URL catalogFileUrl = null;
			try {
				catalogFileUrl = FileLocator.toFileURL(catalogUrl);
			} catch (IOException e) {
				System.out.println(e);
			}
			try {
				if (catalogFileUrl != null && catalogFileUrl.getProtocol().equals("file")
						&& new File(catalogFileUrl.getPath()).exists()) {
					catalog = OmlCatalog.create(catalogUrl);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			if (catalog == null) {
				currentUri = currentUri.trimSegments(1);
				catalog = catalogMap.get(currentUri);
			}
		}
		final OmlCatalog finalCatalog = catalog;
		uris.forEach(uri -> catalogMap.put(uri, finalCatalog));
	}

	protected void addResource(Resource resource) {
		if (resource.getURI().isPlatformPlugin()) {
			return;
		}
		File file = toFile(resource.getURI());
		if (file == null) {
			return;
		}
		for (File parent : getParents(file)) {
			if (!watched.containsValue(parent)) {
				try {
					WatchKey key = parent.toPath().register(watcher, 
							StandardWatchEventKinds.ENTRY_CREATE,
							StandardWatchEventKinds.ENTRY_DELETE, 
							StandardWatchEventKinds.ENTRY_MODIFY);
					watched.put(key, parent);
				} catch (IOException e) {
					System.err.print(e);
				}
			} else {
				break;
			}
		}
	}

	@Override
	public void run() {
		while (!doStop) {
			WatchKey key;
			try {
				key = watcher.take();
			} catch (InterruptedException x) {
				return;
			}

			for (WatchEvent<?> event : key.pollEvents()) {
				WatchEvent.Kind<?> kind = event.kind();

				if (kind == StandardWatchEventKinds.OVERFLOW) {
					continue;
				}

				@SuppressWarnings("unchecked")
				WatchEvent<Path> ev = (WatchEvent<Path>) event;
				Path fileName = ev.context();
				File folder = watched.get(key);
				File file = folder.toPath().resolve(fileName).toFile();

				// Need a more precise way to clean the cache
				if (file.getName().equals("catalog.xml")) {
					importCache.clear();
					catalogCache.clear();
				} else if (file.exists()) {
					importCache.clear();
				}
			}

		    boolean valid = key.reset();
		    if (!valid) {
		        watched.remove(key);
		    }
		}
	}

	private class Listener extends AdapterImpl {
		@Override
		public void notifyChanged(Notification notification) {
			if (notification.getFeatureID(ResourceSet.class) == ResourceSet.RESOURCE_SET__RESOURCES) {
				switch (notification.getEventType()) {
					case Notification.RESOLVE: {
						Resource newValue = (Resource) notification.getNewValue();
						addResource(newValue);
						break;
					}
					case Notification.UNSET: {
						Object newValue = notification.getNewValue();
						if (newValue != null && newValue != Boolean.TRUE && newValue != Boolean.FALSE) {
							addResource((Resource) newValue);
						}
						break;
					}
					case Notification.SET: {
						Resource newValue = (Resource) notification.getNewValue();
						if (newValue != null) {
							addResource(newValue);
						}
						break;
					}
					case Notification.ADD: {
						Resource newValue = (Resource) notification.getNewValue();
						if (newValue != null) {
							addResource(newValue);
						}
						break;
					}
					case Notification.ADD_MANY: {
						for (Object newValue : (Collection<?>) notification.getNewValue()) {
							addResource((Resource) newValue);
						}
						break;
					}
				}
			}
		}
	}
	
}
