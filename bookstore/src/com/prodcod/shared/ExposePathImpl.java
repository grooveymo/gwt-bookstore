package com.prodcod.shared;

import java.util.HashSet;

import org.hibernate.validator.engine.ConstraintViolationImpl;
import org.hibernate.validator.engine.PathImpl;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Dummy class required to ensure that we can perform Server side validation.
 * Exposes PathImpl (hibernate class to serialization policy)
 * see: https://groups.google.com/forum/#!msg/google-web-toolkit/lSPzzdXQsCU/WammhOeIJ-4J
 * @author BruceWayne
 *
 */
public class ExposePathImpl implements IsSerializable {

	@SuppressWarnings("unused")
	private ConstraintViolationImpl<?> constraintViolationImpl;

	@SuppressWarnings("unused")
	private PathImpl pathIpml;

	@SuppressWarnings("unused")
	private HashSet<?> hashSet;

}
