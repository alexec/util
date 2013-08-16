package com.alexecollins.io;

import com.alexecollins.lambda.Fn;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

import static junit.framework.Assert.assertEquals;

/**
 * @author alexec (alex.e.c@gmail.com)
 */
public class FilesTest {
	@Test
	public void testEachLine() throws Exception {
		final AtomicLong l = new AtomicLong();
		Files.eachLine("src/test/resources/com/alexecollins/io/test.txt", new Fn<String, Void>() {
			@Override
			public Void apply(String in) {
				l.addAndGet(Long.parseLong(in));
				return null;
			}
		});
		assertEquals(5, l.get());

	}
}
