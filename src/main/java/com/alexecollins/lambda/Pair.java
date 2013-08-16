package com.alexecollins.lambda;

/**
 * @author alexec (alex.e.c@gmail.com)
 */
public class Pair<A, B> {
	private final A a;
	private final B b;

	private Pair(A a, B b) {
		this.a = a;
		this.b = b;
	}

	public static  <A, B> Pair<A, B> of(final A a, final B b) {
		return new Pair<A, B>(a, b);
	}

	public A a() {
		return a;
	}

	public B b() {
		return b;
	}
}
