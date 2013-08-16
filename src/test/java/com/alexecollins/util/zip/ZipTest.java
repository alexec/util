package com.alexecollins.util.zip;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * @author alexec (alex.e.c@gmail.com)
 */
public class ZipTest {
	@Test
	public void testUnzip() throws Exception {
		Zip.unzip("src/test/resources/ZipTest.zip", "target");
		assertTrue(new File("target/pom.xml").exists());
	}
}
