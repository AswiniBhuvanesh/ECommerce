package com.ecommerce;

import static org.junit.Assert.assertEquals;

import org.junit.Test;




public class WordCountTest {

	@Test
	public void test() {
		assertEquals(2, FindNumberOfWords.findCount("hello world"));
		assertEquals(2, FindNumberOfWords.findCount("hello world "));
		assertEquals(3, FindNumberOfWords.findCount("hello world \r\nxyz"));
		assertEquals(6, FindNumberOfWords.findCount("hello world dsfdsfds hello  \r\nxyz 123"));
	}

}
