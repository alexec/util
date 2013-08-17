package com.alexecollins.util;

import com.alexecollins.lambda.Fn;
import com.alexecollins.lambda.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Simple map-reduce for Java.
 *
 * @author alexec (alex.e.c@gmail.com)
 */
public final class Iterables {
	private Iterables() {
	}

	/**
	 * Apply fn to each element in collection.
	 */
	public static <I> void each(final Iterable<I> in, final Fn<I, Void> fn) {
		for (I i : in) {
			fn.apply(i);
		}
	}

	/**
	 * Find first element in collection matching fn.
	 */
	public static <I> I find(final Iterable<I> in, final Fn<I, Boolean> fn) {
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
	public static <C extends Iterable<I>, I> Iterator<I> filter(final C in, final Fn<I, Boolean> fn) {
		return new Iterator<I>() {
			private final Iterator<I> it = in.iterator();
			private I next = null;

			@Override
			public boolean hasNext() {
				if (!it.hasNext()) {
					return false;
				}
				next = findNext();
				return next != null;
			}

			@Override
			public I next() {
				if (next != null) {
					I out = next;
					next = findNext();
					return out;
				}
				next = findNext();
				if (next == null) {
					throw new NoSuchElementException();
				}
				return next;
			}

			private I findNext() {
				while (!it.hasNext()) {
					final I n = it.next();
					if (fn.apply(n)) {
						return n;
					}
				}
				return null;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	/**
	 * Map each element in the collection to a new collection.
	 */
	public static <C extends Iterable<I>, I, O> Iterator<O> map(final C in, final Fn<I, O> fn) {
		return new Iterator<O>() {
			private final Iterator<I> it = in.iterator();

			@Override
			public boolean hasNext() {
				return it.hasNext();
			}

			@Override
			public O next() {
				return fn.apply(it.next());
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	/**
	 * Perform reduce on collections.
	 */
	public static <C extends Iterable<I>, I, O> O reduce(final C in, O seed, final Fn<Pair<I, O>, O> fn) {
		for (I i : in) {
			seed = fn.apply(Pair.<I, O>of(i, seed));
		}
		return seed;

	}

	public static <I> List<I> asList(Iterator<I> it) {
		final List<I> list = new ArrayList<I>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
}
