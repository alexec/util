package com.alexecollins.io;

import com.alexecollins.lambda.Fn;

import java.io.*;

/**
 * @author alexec (alex.e.c@gmail.com)
 */
public final class Files {
	private Files() {
	}

	/**
	 * Evaluate the expression for each line.
	 */
	public static void eachLine(final File f, final Fn<String, Void> x) throws IOException {
		final BufferedReader in = new BufferedReader(new FileReader(f));
		try {
			String l;
			while ((l = in.readLine()) != null) {
				x.apply(l);
			}
		} finally {
			in.close();
		}
	}

	public static void eachLine(final String f, final Fn<String, Void> x) throws IOException {
		eachLine(new File(f), x);
	}
}
