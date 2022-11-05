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

import com.google.common.base.Objects;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.Vocabulary;
import io.opencaesar.oml.VocabularyStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionContext;
import org.eclipse.lsp4j.CodeActionParams;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class OmlCodeActionService implements ICodeActionService2 {
  private static final String CREATE_CONCEPT_KIND = "sprotty.create.concept";

  @Override
  public List<Either<Command, CodeAction>> getCodeActions(final ICodeActionService2.Options options) {
    List<Either<Command, CodeAction>> _xblockexpression = null;
    {
      EObject root = IterableExtensions.<EObject>head(options.getResource().getContents());
      List<Either<Command, CodeAction>> _xifexpression = null;
      if ((root instanceof Vocabulary)) {
        _xifexpression = this.createCodeActions(root, options.getCodeActionParams(), options.getDocument());
      } else {
        _xifexpression = CollectionLiterals.<Either<Command, CodeAction>>emptyList();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  private List<Either<Command, CodeAction>> _createCodeActions(final EObject element, final CodeActionParams params, final Document document) {
    return CollectionLiterals.<Either<Command, CodeAction>>emptyList();
  }

  private List<Either<Command, CodeAction>> _createCodeActions(final Vocabulary vocabulary, final CodeActionParams params, final Document document) {
    final ArrayList<Either<Command, CodeAction>> result = CollectionLiterals.<Either<Command, CodeAction>>newArrayList();
    final Position position = params.getRange().getEnd();
    position.setCharacter(0);
    boolean _matchesContext = this.matchesContext(OmlCodeActionService.CREATE_CONCEPT_KIND, params);
    if (_matchesContext) {
      CodeAction _codeAction = new CodeAction();
      final Procedure1<CodeAction> _function = (CodeAction it) -> {
        it.setKind(OmlCodeActionService.CREATE_CONCEPT_KIND);
        it.setTitle("new Concept");
        URI _uRI = vocabulary.eResource().getURI();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("    ");
        _builder.append("concept ");
        final Function1<VocabularyStatement, String> _function_1 = (VocabularyStatement el) -> {
          String _xifexpression = null;
          if ((el instanceof Member)) {
            _xifexpression = ((Member)el).getName();
          } else {
            _xifexpression = "";
          }
          return _xifexpression;
        };
        String _newName = this.getNewName("concept", ListExtensions.<VocabularyStatement, String>map(vocabulary.getOwnedStatements(), _function_1));
        _builder.append(_newName, "    ");
        _builder.append("\n", "    ");
        it.setEdit(this.createInsertWorkspaceEdit(_uRI, position, _builder.toString()));
      };
      CodeAction _doubleArrow = ObjectExtensions.<CodeAction>operator_doubleArrow(_codeAction, _function);
      result.add(Either.<Command, CodeAction>forRight(_doubleArrow));
    }
    return result;
  }

  private boolean matchesContext(final String kind, final CodeActionParams params) {
    CodeActionContext _context = params.getContext();
    List<String> _only = null;
    if (_context!=null) {
      _only=_context.getOnly();
    }
    boolean _tripleEquals = (_only == null);
    if (_tripleEquals) {
      return true;
    } else {
      final Function1<String, Boolean> _function = (String it) -> {
        return Boolean.valueOf(kind.startsWith(it));
      };
      return IterableExtensions.<String>exists(params.getContext().getOnly(), _function);
    }
  }

  private WorkspaceEdit createInsertWorkspaceEdit(final URI uri, final Position position, final String text) {
    WorkspaceEdit _workspaceEdit = new WorkspaceEdit();
    final Procedure1<WorkspaceEdit> _function = (WorkspaceEdit it) -> {
      String _string = uri.toString();
      Range _range = new Range(position, position);
      TextEdit _textEdit = new TextEdit(_range, text);
      Pair<String, List<TextEdit>> _mappedTo = Pair.<String, List<TextEdit>>of(_string, Collections.<TextEdit>unmodifiableList(CollectionLiterals.<TextEdit>newArrayList(_textEdit)));
      it.setChanges(Collections.<String, List<TextEdit>>unmodifiableMap(CollectionLiterals.<String, List<TextEdit>>newHashMap(_mappedTo)));
    };
    return ObjectExtensions.<WorkspaceEdit>operator_doubleArrow(_workspaceEdit, _function);
  }

  private String getNewName(final String prefix, final List<? extends String> siblings) {
    for (int i = 0;; i++) {
      {
        final String currentName = (prefix + Integer.valueOf(i));
        final Function1<String, Boolean> _function = (String it) -> {
          return Boolean.valueOf(Objects.equal(it, currentName));
        };
        boolean _exists = IterableExtensions.exists(siblings, _function);
        boolean _not = (!_exists);
        if (_not) {
          return currentName;
        }
      }
    }
  }

  private List<Either<Command, CodeAction>> createCodeActions(final EObject vocabulary, final CodeActionParams params, final Document document) {
    if (vocabulary instanceof Vocabulary) {
      return _createCodeActions((Vocabulary)vocabulary, params, document);
    } else if (vocabulary != null) {
      return _createCodeActions(vocabulary, params, document);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(vocabulary, params, document).toString());
    }
  }
}
