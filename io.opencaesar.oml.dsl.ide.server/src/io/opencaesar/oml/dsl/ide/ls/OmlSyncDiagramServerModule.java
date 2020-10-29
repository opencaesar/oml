package io.opencaesar.oml.dsl.ide.ls;

import org.eclipse.sprotty.IDiagramServer;
import org.eclipse.sprotty.xtext.ls.IDiagramServerManager;
import org.eclipse.sprotty.xtext.ls.SyncDiagramServerModule;

import io.opencaesar.oml.dsl.ide.diagram.OmlDiagramServer;

public class OmlSyncDiagramServerModule extends SyncDiagramServerModule {

	  public Class<? extends IDiagramServerManager> bindIDiagramServerManager() {
	    return OmlDiagramServerManager.class;
	  }
	  
	  public Class<? extends IDiagramServer> bindDiagramServer() {
		  return OmlDiagramServer.class;
	  }
}
