package com.alexecollins.util;

import java.util.*;

/**
 * A binary tree using an expensive linked-node.
 *
 * @author alexec (alex.e.c@gmail.com)
 */
public class LinkedBinaryTree<T> implements BinaryTree<BinaryTreeNode<T>, T> {
	private BinaryTreeNode<T> root = new BinaryTreeNode<T>();
	private int size = 1;

	@Override
	public BinaryTreeNode<T> leftChild(BinaryTreeNode<T> p) {
		return p.getLeft();
	}

	@Override
	public BinaryTreeNode<T> rightChild(BinaryTreeNode<T> p) {
		return p.getRight();
	}

	@Override
	public BinaryTreeNode<T> sibling(BinaryTreeNode<T> p) {
		final BinaryTreeNode<T> parent = p.getParent();
		final BinaryTreeNode<T> left = leftChild(p);
		return parent == left ? rightChild(p) : left;
	}

	@Override
	public BinaryTreeNode<T> root() {
		return root;
	}

	@Override
	public BinaryTreeNode<T> parent(BinaryTreeNode<T> p) {
		return p.getParent();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<BinaryTreeNode<T>> children(BinaryTreeNode<T> p) {
		final List<BinaryTreeNode<T>> children = new ArrayList<BinaryTreeNode<T>>(2);
		if (p.getLeft() !=null) {
			children.add(p.getLeft());
		}
		if (p.getRight() != null) {
			children.add(p.getRight());
		}
		return children;
	}

	@Override
	public boolean isInternal(BinaryTreeNode<T> p) {
		return p.getLeft() != null || p.getRight() != null;
	}

	@Override
	public boolean isExternal(BinaryTreeNode<T> p) {
		return p.getLeft() == null && p.getRight() == null;
	}

	@Override
	public boolean isRoot(BinaryTreeNode<T> p) {
		return p == root;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void expand(BinaryTreeNode<T> p) {
		if (isInternal(p)) {
			throw new IllegalArgumentException("cannot expand internal position");
		}
		p.setLeft(new BinaryTreeNode<T>(p));
		p.setRight(new BinaryTreeNode<T>(p));
		size += 2;
	}

	@Override
	public void swap(BinaryTreeNode<T> a, BinaryTreeNode<T> b) {
		final BinaryTreeNode<T> l = a.getLeft();
		final BinaryTreeNode<T> p = a.getParent();
		final BinaryTreeNode<T> r = a.getRight();
		a.setLeft(b.getLeft());
		a.setParent(b.getParent());
		a.setRight(b.getRight());
		b.setLeft(l);
		b.setParent(p);
		b.setRight(r);
	}

	@Override
	public void remove(BinaryTreeNode<T> p) {
		if (!isExternal(p)) {
			throw new UnsupportedOperationException("cannot remove non-external position");
		}
		final BinaryTreeNode<T> p1 = p.getParent();
		if (leftChild(p1) == p) {
			p1.setLeft(null);
		} else {
			p1.setRight(null);
		}
		p.setParent(null);
	}

	@Override
	public T replace(BinaryTreeNode<T> a, T b) {
		final T t1 = a.get();
		a.setElement(b);
		return t1;
	}

	@Override
	public T element(BinaryTreeNode<T> p) {
		return p.get();
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private final Queue<T> q = new LinkedList<T>();

			{
				BinaryTrees.preOrderTraverse(LinkedBinaryTree.this, new TreeVisitor<BinaryTreeNode<T>, T>() {

					@Override
					public void accept(Tree<BinaryTreeNode<T>, T> t, BinaryTreeNode<T> p) {
						q.add(t.element(p));
					}
				});
			}

			@Override
			public boolean hasNext() {
				return !q.isEmpty();
			}

			@Override
			public T next() {
				return q.remove();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}
