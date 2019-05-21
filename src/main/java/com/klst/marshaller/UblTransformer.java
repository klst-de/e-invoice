package com.klst.marshaller;

import java.io.InputStream;

import javax.inject.Named;
import javax.inject.Singleton;

import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;

@Named
@Singleton
public abstract class UblTransformer extends AbstactTransformer {

	// ctor
	protected UblTransformer(String contentPath, AbstactTransformer instance) {
		super(contentPath, instance);
	}
	
	@Override
	abstract String getResource();

	@Override
	abstract public <T> T toModel(InputStream xmlInputStream);

	@SuppressWarnings("restriction")
	@Override // implements abstract method
	NamespacePrefixMapper getNamespacePrefixMapper() {
		return new UblNamespacePrefixMapper();
	}
	
}


