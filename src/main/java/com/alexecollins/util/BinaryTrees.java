package com.alexecollins.util;

/**
 * @author alexec (alex.e.c@gmail.com)
 */
public final class BinaryTrees {
	private BinaryTrees() {
	}

	public static <P, T> void preOrderTraverse(BinaryTree<P, T> t, TreeVisitor<P,T> v) {
		preOrderTraverse(t, t.root(), v);
	}

	private static  <P, T> void preOrderTraverse(BinaryTree<P, T> t, P p, TreeVisitor<P,T> v) {
		v.accept(t, p);
		if (t.isInternal(p)) {
			preOrderTraverse(t, t.leftChild(p), v);
			preOrderTraverse(t, t.rightChild(p), v);
		}
	}

	public static  <P, T> void postOrderTraverse(BinaryTree<P, T> t, TreeVisitor<P,T> v) {
		postOrderTraverse(t, t.root(), v);
	}

	private static <P, T> void postOrderTraverse(BinaryTree<P, T> t, P p, TreeVisitor<P,T> v) {
		if (t.isInternal(p)) {
			preOrderTraverse(t, t.leftChild(p), v);
			preOrderTraverse(t, t.rightChild(p), v);
		}
		v.accept(t, p);
	}

	public static  <P, T> void inOrderTraverse(BinaryTree<P, T> t, TreeVisitor<P,T> v) {
		inOrderTraverse(t, t.root(), v);
	}

	private static <P, T> void inOrderTraverse(BinaryTree<P, T> t, P p, TreeVisitor<P, T> v) {
		final boolean internal = t.isInternal(p);
		if (internal) {
			preOrderTraverse(t, t.leftChild(p), v);
		}
		v.accept(t, p);
		if (internal) {
			preOrderTraverse(t, t.rightChild(p), v);
		}
	}

	public static <P, T> void eulerTourTraverse(BinaryTree<P, T> t, EulerTreeVisitor<P, T> v) {
		eulerTourTraverse(t, t.root(), v);
	}

	private static <P, T> void eulerTourTraverse(BinaryTree<P, T> t, P p, EulerTreeVisitor<P, T> v) {
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
