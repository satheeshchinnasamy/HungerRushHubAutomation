package com.hub.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/**
 * 
 * Customized annotation for Test cases
 * 24-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 * @see Testcases
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotations {
/**
 * 
 * 24-Jan-2022
 * @author satheesh.c
 * The annotations used in the test to categorize the test cases and assign it to the author
 */
	public String[] author();
	public String[] category();
}
