package com.alexecollins.util;

import org.junit.Test;

/**
 * @author alexec (alex.e.c@gmail.com)
 */
public class LinkedBinaryTreeTest {

	@Test
	public void test() throws Exception {


		final LinkedBinaryTree<Integer> sut = new LinkedBinaryTree<Integer>();

		int i=0        ;
		sut.replace(sut.root(), i++);
		sut.expand(sut.root());

		for (BinaryTreeNode<Integer> p : sut.children(sut.root())) {
			sut.replace(p, i++);
		}

		final TreeVisitor<BinaryTreeNode<Integer>, Integer> v = new TreeVisitor<BinaryTreeNode<Integer>, Integer>() {
			@Override
			public void accept(Tree<BinaryTreeNode<Integer>, Integer> t, BinaryTreeNode<Integer> p) {
				System.out.println(t.element(p));
			}
		};
		System.out.println("pre-order");
		Trees.preOrderTraverse(sut, v);
		System.out.println("post-order");
		Trees.postOrderTraverse(sut, v);
		System.out.println("pre-order");
		BinaryTrees.preOrderTraverse(sut, v);
		System.out.println("post-order");
		BinaryTrees.postOrderTraverse(sut, v);
		System.out.println("in-order");
		BinaryTrees.inOrderTraverse(sut, v);
		System.out.println("euler-tour");
		BinaryTrees.eulerTourTraverse(sut, new EulerTreeVisitor<BinaryTreeNode<Integer>, Integer>() {
			@Override
			public void acceptExternal(BinaryTree<BinaryTreeNode<Integer>, Integer> t, BinaryTreeNode<Integer> p) {
				System.out.println(t.element(p));
			}

			@Override
			public void acceptLeft(BinaryTree<BinaryTreeNode<Integer>, Integer> t, BinaryTreeNode<Integer> p) {
				System.out.println(t.element(p));
			}

			@Override
			public void acceptBelow(BinaryTree<BinaryTreeNode<Integer>, Integer> t, BinaryTreeNode<Integer> p) {
				System.out.println(t.element(p));
			}

			@Override
			public void acceptRight(BinaryTree<BinaryTreeNode<Integer>, Integer> t, BinaryTreeNode<Integer> p) {
				System.out.println(t.element(p));
			}
		});

		System.out.println("iterator");
		for (Integer integer : sut) {
			System.out.println(integer);
		}


	}
}
