package com.alexecollins.util;

/**
 * @author alexec (alex.e.c@gmail.com)
 */
public final class BinaryTrees {
	private BinaryTrees() {
	}

	public <P, T> void preOrderTraverse(BinaryTree<P, T> t, Visitor<P,T> v) {
		preOrderTraverse(t, t.root(), v);
	}

	public <P, T> void preOrderTraverse(BinaryTree<P, T> t, P p, Visitor<P,T> v) {
		v.accept(t, p);
		if (t.isInternal(p)) {
			preOrderTraverse(t, t.leftChild(p), v);
		} else {
			preOrderTraverse(t, t.rightChild(p), v);
		}
	}

	public <P, T> void postOrderTraverse(BinaryTree<P, T> t, Visitor<P,T> v) {
		postOrderTraverse(t, t.root(), v);
	}

	public <P, T> void postOrderTraverse(BinaryTree<P, T> t, P p, Visitor<P,T> v) {
		if (t.isInternal(p)) {
			preOrderTraverse(t, t.leftChild(p), v);
		} else {
			preOrderTraverse(t, t.rightChild(p), v);
		}
		v.accept(t, p);
	}

	public <P, T> void inOrderTraverse(BinaryTree<P, T> t, Visitor<P,T> v) {
		inOrderTraverse(t, t.root(), v);
	}

	public <P, T> void inOrderTraverse(BinaryTree<P, T> t, P p, Visitor<P, T> v) {
		final boolean internal = t.isInternal(p);
		if (internal) {
			preOrderTraverse(t, t.leftChild(p), v);
		}
		v.accept(t, p);
		if (internal) {
			preOrderTraverse(t, t.rightChild(p), v);
		}
	}

	public <P, T> void eulerTourTraverse(BinaryTree<P, T> t, EulerVisitor<P, T> v) {
		eulerTourTraverse(t, t.root(), v);
	}

	public <P, T> void eulerTourTraverse(BinaryTree<P, T> t, P p, EulerVisitor<P, T> v) {
		if (t.isExternal(p)) {
			v.acceptExternal(t, p);
		} else {
			v.acceptLeft(t, p);
			eulerTourTraverse(t, t.leftChild(p), v);
			v.acceptBelow(t, p);
			eulerTourTraverse(t, t.rightChild(p), v);
			v.acceptRight(t, p);
		}
	}

}
