package com.hub.listener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.hub.utils.DataProviderUtils;
/**
 * <P>Class holds the method which will return parameters to the annotation</P>
 * 
 * 
 * 24-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */
public class AnnotationTransformer implements IAnnotationTransformer{

	/**
	 * This method returns the parameter to the test methods
	 */
	public void transform(ITestAnnotation annotation, Class testclass, Constructor testconstructor, Method testmethod) {
		
		/**
		 * setting the values to the dataprovider method and class
		 */
		annotation.setDataProvider("getData");
		annotation.setDataProviderClass(DataProviderUtils.class);
	}

}
