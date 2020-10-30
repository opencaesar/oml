package io.opencaesar.oml.dsl.resource;

import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Provider;

public class OmlXtextResourceSetProvider implements Provider<XtextResourceSet> {
	
  @Override
  public XtextResourceSet get() {
    return new OmlSynchronizedXtextResourceSet();
  }
}
