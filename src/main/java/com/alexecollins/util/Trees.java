package com.alexecollins.util;


/**
 * @author alexec (alex.e.c@gmail.com)
 */
public final class Trees {
	private Trees() {
	}

	public <P, T> int depth(Tree<P, T> t, P p) {
		return t.isRoot(p) ? 0 : 1 + depth(t, t.parent(p));
	}

	public <P, T> int height(Tree<P, T> t, P p) {
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

	public <P, T> void preOrderTraverse(Tree<P, T> t, Visitor<P,T> v) {
		preOrderTraverse(t, t.root(), v);
	}

	public <P, T> void preOrderTraverse(Tree<P, T> t, P p, Visitor<P,T> v) {
		v.accept(t, p);
		for (P p1 : t.children(p)) {
			preOrderTraverse(t,p1,v);
		}
	}

	public <P, T> void postOrderTraverse(Tree<P, T> t, Visitor<P,T> v) {
		postOrderTraverse(t, t.root(), v);
	}

	public <P, T> void postOrderTraverse(Tree<P, T> t, P p, Visitor<P,T> v) {
		for (P p1 : t.children(p)) {
			postOrderTraverse(t,p1,v);
		}
		v.accept(t, p);
	}

}