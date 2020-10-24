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
package io.opencaesar.oml.dsl.ide.server.codeActions

import io.opencaesar.oml.Member
import io.opencaesar.oml.Vocabulary
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.lsp4j.CodeAction
import org.eclipse.lsp4j.CodeActionParams
import org.eclipse.lsp4j.Command
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextEdit
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2

class OmlCodeActionService implements ICodeActionService2 {
	static val CREATE_CONCEPT_KIND = 'sprotty.create.concept'

	override getCodeActions(Options options) {
		var root = options.resource.contents.head
		if (root instanceof Vocabulary)
			createCodeActions(root, options.codeActionParams, options.document)
		else
			emptyList
	}
	
	private def dispatch List<Either<Command, CodeAction>> createCodeActions(EObject element, CodeActionParams params, Document document) {
		return emptyList
	}
	
	private def dispatch List<Either<Command, CodeAction>> createCodeActions(Vocabulary vocabulary, CodeActionParams params, Document document) {
		val result = <Either<Command, CodeAction>>newArrayList
		val position = params.range.end
		position.character = 0
		if (CREATE_CONCEPT_KIND.matchesContext(params)) {
			result.add(Either.forRight(new CodeAction => [
				kind = CREATE_CONCEPT_KIND
				title = 'new Concept'
				edit = createInsertWorkspaceEdit(
					vocabulary.eResource.URI,
					position,
					'''    concept «getNewName('concept', vocabulary.ownedStatements.map[ el |
						if (el instanceof Member)
							el.name
						else
							''
					])»«'\n'»'''
				)
			]
			))
		}
		return result
	}
	
	private def matchesContext(String kind, CodeActionParams params) {
		if (params.context?.only === null) {
			return true
		} else {
			return params.context.only.exists[kind.startsWith(it)]
		}
	}
	
	private def createInsertWorkspaceEdit(URI uri, Position position, String text) {
		new WorkspaceEdit => [
			changes = #{uri.toString -> #[ new TextEdit(new Range(position, position), text) ]}
		]
	}
	
	private def String getNewName(String prefix, List<? extends String> siblings) {
		for (var i = 0;; i++) {
			val currentName = prefix + i
			if (!siblings.exists[it == currentName])
				return currentName
		}
	}
	
	
}