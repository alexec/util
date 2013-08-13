package com.alexecollins.util;

import java.util.Collection;

/**
 * @author alexec (alex.e.c@gmail.com)
 */
public interface Tree<P, T> {

	P root();

	P parent(P p);

	Collection<P> children(P p);

	boolean isInternal(P p);

	boolean isExternal(P p);

	boolean isRoot(P p);

	int size();

	void expand(P p);

	void swap(P a, P b);

	void remove(P p);

	T replace(P a, T b);

	T element(P p);
}
