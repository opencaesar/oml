/**
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
 */
package io.opencaesar.oml.dsl.ide.server.codeActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionParams;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2;

import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.util.OmlRead;

@SuppressWarnings("all")
public class OmlCodeActionService implements ICodeActionService2 {

	private static final String CREATE_CONCEPT_KIND = "sprotty.create.concept";

	@Override
	public List<Either<Command, CodeAction>> getCodeActions(ICodeActionService2.Options options) {
		if (options.getResource() != null) {
			var root = options.getResource().getContents().iterator().next();
			if (root instanceof Vocabulary)
				return createCodeActions(root, options.getCodeActionParams(), options.getDocument());
		}
		return Collections.emptyList();
	}

	private List<Either<Command, CodeAction>> createCodeActions(EObject obj, CodeActionParams params, Document document) {
		if (obj instanceof Vocabulary) {
			return _createCodeActions((Vocabulary) obj, params, document);
		}
		return Collections.emptyList();
	}

	private List<Either<Command, CodeAction>> _createCodeActions(Vocabulary vocabulary, CodeActionParams params, Document document) {
		final var result = new ArrayList<Either<Command, CodeAction>>();
		final var position = params.getRange().getEnd();
		position.setCharacter(0);
		if (matchesContext(OmlCodeActionService.CREATE_CONCEPT_KIND, params)) {
			var action = new CodeAction();
			action.setKind(CREATE_CONCEPT_KIND);
			action.setTitle("new Concept");
			String uniqueName = getNewName("concept", OmlRead.getMembers(vocabulary).stream().map(i -> i.getName()).collect(Collectors.toList()));
			action.setEdit(createInsertWorkspaceEdit(vocabulary.eResource().getURI(), position, "\nconcept "+uniqueName+"\n"));
			result.add(Either.forRight(action));
		}
		return result;
	}

	private boolean matchesContext(String kind, CodeActionParams params) {
		if (params.getContext() == null || params.getContext().getOnly() == null) {
			return true;
		} 
		return params.getContext().getOnly().stream().anyMatch(it -> kind.startsWith(it));
	}

	private WorkspaceEdit createInsertWorkspaceEdit(URI uri, Position position, String text) {
		List<TextEdit> edits = Arrays.asList(new TextEdit(new Range(position, position), text));
		Map<String, List<TextEdit>> changes = new HashMap<>();
		changes.put(uri.toString(), edits);
		WorkspaceEdit workspaceEdit = new WorkspaceEdit();
		workspaceEdit.setChanges(changes);
		return workspaceEdit;
	}

	private String getNewName(String prefix, List<String> siblings) {
		String name = prefix;
		int i = 0;
		while (siblings.contains(name)) {
			name = prefix + (++i);
		}
		return name;
	}

}
