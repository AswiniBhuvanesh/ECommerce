package com.ecommerce;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;


/**
 * Class to Find number or words to the given string 
 * 
 * @author Aswini.Raveender
 *
 */
public class FindNumberOfWords {


	
	public static int findCount(String str){
		
		AtomicInteger index = new AtomicInteger();
		
		System.out.println("without map::"+Arrays.stream(str.split("\\W")).filter(s -> StringUtils.isNotBlank(s)).count());// Create Array stream

		Map<Integer, String> mp =Arrays.stream(str.split("\\W")).filter(s -> StringUtils.isNotBlank(s))
		       .collect(Collectors.toMap(s -> (Integer)index.getAndIncrement(),s -> (String)s ));
		
		return mp.size();
	}

}
