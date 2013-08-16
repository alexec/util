package com.alexecollins.util;

/**
 * @author alexec (alex.e.c@gmail.com)
 */
public interface TreeVisitor<P, T> {
	void accept(Tree<P, T> t, P p);
}
