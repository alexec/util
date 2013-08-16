package com.alexecollins.util;


/**
 * Functional methods for trees.
 *
 * @author alexec (alex.e.c@gmail.com)
 * @see java.util.Collections
 */
public final class Trees {
	private Trees() {
	}

	public static <P, T> int depth(Tree<P, T> t, P p) {
		return t.isRoot(p) ? 0 : 1 + depth(t, t.parent(p));
	}

	public static <P, T> int height(Tree<P, T> t, P p) {
		if (t.isExternal(p)) {
			return 0;
		} else {
			int h = 0;
			for (P p1 : t.children(p)) {
				h = Math.max(h, height(t, p1));
			}
			return 1 + h;
		}
	}

	public static <P, T> void preOrderTraverse(Tree<P, T> t, TreeVisitor<P,T> v) {
		preOrderTraverse(t, t.root(), v);
	}

	private static <P, T> void preOrderTraverse(Tree<P, T> t, P p, TreeVisitor<P,T> v) {
		v.accept(t, p);
		for (P p1 : t.children(p)) {
			preOrderTraverse(t,p1,v);
		}
	}

	public static <P, T> void postOrderTraverse(Tree<P, T> t, TreeVisitor<P,T> v) {
		postOrderTraverse(t, t.root(), v);
	}

	private static <P, T> void postOrderTraverse(Tree<P, T> t, P p, TreeVisitor<P,T> v) {
		for (P p1 : t.children(p)) {
			postOrderTraverse(t,p1,v);
		}
		v.accept(t, p);
	}

}