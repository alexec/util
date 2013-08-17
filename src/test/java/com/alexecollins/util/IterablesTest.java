package com.alexecollins.util;

import com.alexecollins.lambda.Fn;
import com.alexecollins.lambda.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import static com.alexecollins.util.Iterables.*;
import static org.junit.Assert.assertEquals;

/**
 * @author alexec (alex.e.c@gmail.com)
 */
public class IterablesTest {
	@Test
	public void testEach() throws Exception {
		final AtomicLong l = new AtomicLong();
		Iterables.each(Arrays.asList(2, 3), new Fn<Integer, Void>() {
			@Override
			public Void apply(Integer in) {
				l.addAndGet(in);
				return null;
			}
		});
		assertEquals(5l, l.get());
	}

	@Test
	public void testFind() throws Exception {
		assertEquals(Integer.valueOf(2), find(Arrays.asList(2, 3), new Fn<Integer, Boolean>() {
			@Override
			public Boolean apply(Integer in) {
				return in == 2;
			}
		}));
	}

	@Test
	public void testFilter() throws Exception {
		assertEquals(Arrays.asList(2), asList(filter(Arrays.asList(2, 3), new Fn<Integer, Boolean>() {
			@Override
			public Boolean apply(Integer in) {
				return in == 2;
			}

		})));
	}

	@Test
	public void testMap() throws Exception {
		assertEquals(Arrays.asList(4, 6), asList(map(Arrays.asList(2, 3), new Fn<Integer, Integer>() {
			@Override
			public Integer apply(Integer in) {
				return in * 2;
			}
		})));
	}

	@Test
	public void testReduce() throws Exception {
		assertEquals(Integer.valueOf(10), reduce(Arrays.asList(2, 3), 5, new Fn<Pair<Integer, Integer>, Integer>() {
			@Override
			public Integer apply(Pair<Integer, Integer> in) {
				return in.a() + in.b();
			}
		}));
	}

	@Test
	public void testMapReduce() throws Exception {

		assertEquals(Integer.valueOf(15), reduce(asList(map(Arrays.asList(2, 3), new Fn<Integer, Integer>() {

			@Override
			public Integer apply(Integer in) {
				return in * 2;
			}
		})), 5, new Fn<Pair<Integer, Integer>, Integer>() {
			@Override
			public Integer apply(Pair<Integer, Integer> in) {
				return in.a() + in.b();
			}
		}));

	}
}
