package com.alexecollins.util;

/**
 * @author alexec (alex.e.c@gmail.com)
 */
public interface Visitor<P, T> {
	void accept(Tree<P, T> t, P p);
}
