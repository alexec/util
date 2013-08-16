package com.alexecollins.lambda;

/**
 * @author alexec (alex.e.c@gmail.com)
 */
public interface Fn<I,O> {
	O apply(I in);
}
