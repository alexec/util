package com.alexecollins.util;

/**
 * A binary tree, each node only has two branches.
 *
 * @author alexec (alex.e.c@gmail.com)
 */
public interface BinaryTree<P, T> extends Tree<P, T> {
	P leftChild(P p);

	P rightChild(P p);

	P sibling(P p);
}
