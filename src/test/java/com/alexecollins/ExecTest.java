package com.alexecollins;

import org.junit.Test;

import java.io.File;

import static junit.framework.Assert.assertEquals;

/**
 * @author alex.collins
 */
public class ExecTest {

	@Test
	public void testExec() throws Exception {
		assertEquals("hello\n", Exec.exec("hello".getBytes(), new File("."), "cat"));
	}
}
