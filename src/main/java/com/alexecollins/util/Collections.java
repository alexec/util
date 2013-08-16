package com.alexecollins.util;

import com.alexecollins.lambda.Fn;
import com.alexecollins.lambda.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author alexec (alex.e.c@gmail.com)
 */
public final class Collections {
	private Collections() {
	}

	/**
	 * Apply fn to each element in collection.
	 */
	public static <I> void each(final Collection<I> in, final Fn<I, Void> fn) {
		if (in == null || fn == null) {
			throw new IllegalArgumentException();
		}
		for (I i : in) {
			fn.apply(i);
		}
	}

	/**
	 * Find first element in collection matching fn.
	 */
	public static <I> I find(final Collection<I> in, final Fn<I, Boolean> fn) {
		if (in == null || fn == null) {
			throw new IllegalArgumentException();
		}
		for (I t : in) {
			if (fn.apply(t)) {
				return t;
			}
		}
		return null;
	}

	/**
	 * Filter collection, keeping every element passing fn.
	 */
	public static <C extends Collection<I>, I> List<I> filter(final C in, final Fn<I, Boolean> fn) {
		if (in == null || fn == null) {
			throw new IllegalArgumentException();
		}
		final List<I> out = new ArrayList<I>(in.size());
		for (I t : in) {
			if (fn.apply(t)) {
				out.add(t);
			}
		}
		return out;
	}

	/**
	 * Map each element in the collection to a new collection.
	 */
	public static <C extends Collection<I>, I, O> List<O> map(final C in, final Fn<I, O> fn) {
		if (in == null || fn == null) {
			throw new IllegalArgumentException();
		}
		final List<O> out = new ArrayList<O>(in.size());
		for (I t : in) {
			out.add(fn.apply(t));
		}
		return out;
	}

	/**
	 * Perform reduce on collections.
	 */
	public static <C extends Collection<I>, I, O> O reduce(final C in, O seed, final Fn<Pair<I, O>, O> fn) {
		if (in == null || fn == null) {
			throw new IllegalArgumentException();
		}
		for (I i : in) {
			seed = fn.apply(Pair.<I, O>of(i, seed));
		}
		return seed;

	}
}
