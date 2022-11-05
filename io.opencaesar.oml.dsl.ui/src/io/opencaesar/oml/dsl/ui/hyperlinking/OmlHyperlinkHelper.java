/**
 * 
 * Copyright 2019-2021 California Institute of Technology ("Caltech").
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
package io.opencaesar.oml.dsl.ui.hyperlinking;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.Inject;

import io.opencaesar.oml.Import;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.util.OmlRead;

public class OmlHyperlinkHelper extends HyperlinkHelper {

	@Inject 
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Override
	public void createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		Ontology ontology = null;
		EObject eObject = eObjectAtOffsetHelper.resolveElementAt(resource, offset);
		if (eObject instanceof Ontology) {
			ontology = (Ontology) eObject;
		} else if (eObject instanceof Import) {
			ontology = OmlRead.getImportedOntology((Import)eObject);
		}
		if (ontology != null) {
			List<INode> nodes = NodeModelUtils.findNodesForFeature(eObject,	OmlPackage.Literals.IMPORT__NAMESPACE);
			if (!nodes.isEmpty()) {
				INode node = nodes.get(0);
				ITextRegion textRegion = node.getTextRegion();
				Region region = new Region(textRegion.getOffset(), textRegion.getLength());
				createHyperlinksTo(resource, region, ontology, acceptor);
			}
			return;
		}
		super.createHyperlinksByOffset(resource, offset, acceptor);
	}
}
