package io.opencaesar.oml.presentation.actions;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import io.opencaesar.oml.Import;
import io.opencaesar.oml.presentation.OmlEditorPlugin;
import io.opencaesar.oml.util.OmlRead;

public class LoadImportAction extends BaseSelectionListenerAction {
	
	public LoadImportAction() {
		super(OmlEditorPlugin.INSTANCE.getString("_UI_LoadImport_menu_item"));
	}
	
	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		Object e = selection.getFirstElement();
		return e instanceof Import;
	}

	@Override
	public void run() {
		IStructuredSelection selection = getStructuredSelection();
		Import _import = (Import) selection.getFirstElement();
		OmlRead.getImportedResource(_import);
	}
};