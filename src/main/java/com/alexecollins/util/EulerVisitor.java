package com.alexecollins.util;

/**
 * @author alexec (alex.e.c@gmail.com)
 */
public interface EulerVisitor<P, T> {
	void acceptExternal(BinaryTree<P, T> t, P p);

	void acceptLeft(BinaryTree<P, T> t, P p);

	void acceptBelow(BinaryTree<P, T> t, P p);

	void acceptRight(BinaryTree<P, T> t, P p);
}
