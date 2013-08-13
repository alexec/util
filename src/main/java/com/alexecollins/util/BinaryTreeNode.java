package com.alexecollins.util;

/**
 * @author alexec (alex.e.c@gmail.com)
 */
public class BinaryTreeNode<T> {
	private T element;
	private BinaryTreeNode<T> left, right, parent;

	BinaryTreeNode() {
	}

	BinaryTreeNode(BinaryTreeNode<T> p) {
		this.parent =p;
	}

	T get() {
		return element;
	}

	BinaryTreeNode<T> getLeft() {
		return left;
	}

	BinaryTreeNode<T> getRight() {
		return right;
	}

	BinaryTreeNode<T> getParent() {
		return parent;
	}

	void setElement(T element) {
		this.element = element;
	}

	void setParent(BinaryTreeNode<T> parent) {
		this.parent = parent;
	}

	void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}
}
