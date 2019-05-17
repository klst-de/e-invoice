package com.klst.marshaller;

public class TransformationException extends RuntimeException {

	public static final String JAXB_INSTANTIATE_ERROR = "Could not instantiate JaxB Context";
	public static final String MARSHALLING_ERROR = "Marshalling error";
	public static final String NAMESPACE_PREFIX_MAPPER_ERROR = "cannot set property namespacePrefixMapper";

	private static final long serialVersionUID = 1L;

	public TransformationException(String message) {
		super(message);
	}

	public TransformationException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
