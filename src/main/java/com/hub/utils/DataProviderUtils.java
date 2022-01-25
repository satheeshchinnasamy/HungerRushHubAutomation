package com.hub.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.hub.constants.FrameworkConstants;
/**
 * <P>Class holding the method which provide the data to the test</P>
 * 25-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */
public final class DataProviderUtils {

	
	@DataProvider(parallel=true)
	public static Object[] getData(Method m) {
		String testname = m.getName();
		List<Map<String, String>> datalist =ExcelUtils.getTestDetails(FrameworkConstants.getDatasheet());
		
		List<Map<String, String>> methodlist =new ArrayList<Map<String, String>>();
		
		for(int i=0; i<datalist.size(); i++) {
			if(datalist.get(i).get("testcasename").equalsIgnoreCase(testname) &&
				datalist.get(i).get("execute").equalsIgnoreCase("yes"))	{
					methodlist.add(datalist.get(i));
				}
			}
		
		return methodlist.toArray();
	}
	
}
