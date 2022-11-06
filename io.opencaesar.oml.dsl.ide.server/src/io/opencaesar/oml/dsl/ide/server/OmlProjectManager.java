/**
 * 
 * Copyright 2019 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package io.opencaesar.oml.dsl.ide.server;

import com.google.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.ide.server.ProjectManager;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class OmlProjectManager extends ProjectManager {

	@Inject
	@Extension
	private OmlExclusionProvider omlExclusionProvider;

	@Override
	protected BuildRequest newBuildRequest(List<URI> changedFiles, List<URI> deletedFiles, List<IResourceDescription.Delta> externalDeltas, CancelIndicator cancelIndicator) {
		final BuildRequest request = super.newBuildRequest(changedFiles, deletedFiles, externalDeltas, cancelIndicator);
		final URI base = this.getBaseDir();
		final List<URI> dirtyFiles = changedFiles.stream().filter(f -> !omlExclusionProvider.isExcluded(f, base)).collect(Collectors.toList());
		request.setDirtyFiles(dirtyFiles);
		return request;
	}
}
