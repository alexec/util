package com.alexecollins.io;

import com.alexecollins.lambda.Fn;

import java.io.*;

/**
 * Simple, memory efficient file line by line iterator.
 *
 * @author alexec (alex.e.c@gmail.com)
 */
public final class Files {
	private Files() {
	}

	/**
	 * Evaluate the expression for each line.
	 */
	public static void each(final File f, final Fn<String, Void> fn) throws IOException {
		final BufferedReader in = new BufferedReader(new FileReader(f));
		try {
			String l;
			while ((l = in.readLine()) != null) {
				fn.apply(l);
			}
		} finally {
			in.close();
		}
	}

	public static void each(final String f, final Fn<String, Void> fn) throws IOException {
		each(new File(f), fn);
	}
}
