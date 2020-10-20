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
package io.opencaesar.oml.dsl.ide.diagram;

import io.opencaesar.oml.dsl.ide.diagram.OmlDiagramExpansionListener;
import io.opencaesar.oml.dsl.ide.diagram.OmlDiagramServer;
import io.opencaesar.oml.dsl.ide.diagram.OmlDiagramServerFactory;
import io.opencaesar.oml.dsl.ide.diagram.OmlDiagramViewGenerator;
import io.opencaesar.oml.dsl.ide.diagram.OmlLayoutEngine;
import io.opencaesar.oml.dsl.ide.server.codeActions.OmlCodeActionService;
import org.eclipse.sprotty.IDiagramExpansionListener;
import org.eclipse.sprotty.IDiagramServer;
import org.eclipse.sprotty.ILayoutEngine;
import org.eclipse.sprotty.xtext.DefaultDiagramModule;
import org.eclipse.sprotty.xtext.IDiagramGenerator;
import org.eclipse.sprotty.xtext.IDiagramServerFactory;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2;

@SuppressWarnings("all")
public class OmlDiagramModule extends DefaultDiagramModule {
  public Class<? extends IDiagramServer> bindIDiagramServer() {
    return OmlDiagramServer.class;
  }
  
  public Class<? extends IDiagramServerFactory> bindIDiagramServerFactory() {
    return OmlDiagramServerFactory.class;
  }
  
  public Class<? extends ILayoutEngine> bindILayoutEngine() {
    return OmlLayoutEngine.class;
  }
  
  public Class<? extends IDiagramGenerator> bindIDiagramGenerator() {
    return OmlDiagramViewGenerator.class; // Java version
   	//return OmlDiagramGenerator.class; // Xtend version
  }
  
  public Class<? extends IDiagramExpansionListener> bindIDiagramExpansionListener() {
    return OmlDiagramExpansionListener.class;
  }
  
  public Class<? extends ICodeActionService2> bindICodeActionService() {
    return OmlCodeActionService.class;
  }
  
  // The following summarizes the interface between the OML DiagramServer and the OML Theia viewer.
  // If the interface changes, for example, as a result of adding/removing/changing Oml Theia views,
  // then the OML Diagramserver code must be updated accordingly. If the view names were string constants in the code,
  // it would make this update a tedious and error-prone exercise of text search/replace.
  // With the constants below, it is safer to:
  // - rename the Java symbols using an IDE
  // - compare the Oml Theia view registrations with the constants below
  // - determine which Theia views are used in the diagram server
  
  // For the Oml Theia views and their registration by name, see:  oml-sprotty/src/di.config.ts
  
  //     configureModelElement(context, 'graph', OmlDiagram, SGraphView);
  public static String OmlDiagram_SGrapView = "graph";
  
  //     configureModelElement(context, 'node:class', OmlNode, ClassNodeView)
  public static String OmlNode_ClassNodeView = "node:class";
  
  //     configureModelElement(context, 'node:module', ModuleNode, ModuleNodeView)
  public static String ModuleNode_ModuleNodeView = "node:module";
  
  //     configureModelElement(context, 'label:text', SLabel, SLabelView)
  public static String SLabel_SLabelView = "label:text";
  
  //     configureModelElement(context, 'label:restricts', SLabel, RestrictsLabelView)
  public static String SLabel_RestrictsLabelView = "label:restricts";
  
  //     configureModelElement(context, 'label:relationship', SLabel, RelationshipLabelView)
  public static String SLabel_RelationshipLabelView = "label:relationship";
  
  //     configureModelElement(context, 'comp:comp', SCompartment, SCompartmentView)
  public static String SCompartment_SCompartmentView = "comp:comp";
  
  //     configureModelElement(context, 'comp:classHeader', SCompartment, HeaderCompartmentView)
  public static String SCompartment_HeaderCompartmentView = "comp:classHeader";
  
  //     configureModelElement(context, 'edge:straight', OmlEdge, PolylineEdgeView)
  public static String OMlEdge_PolylineEdgeView = "edge:straight";
  
  //     configureModelElement(context, 'edge:augments', OmlEdge, RelationshipArrowEdgeView)
  public static String OmlEdge_RelationshipArrowEdgeView = "edge:augments";
  
  //    configureModelElement(context, 'edge:restricts', OmlEdge, RestrictsArrowEdgeView)
  public static String OmlEdge_RestrictsArrowEdgeView = "edge:restricts";
  
}
