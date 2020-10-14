package com.capgemini.myhashtable;

import org.junit.Assert;
import org.junit.Test;

public class MyHashMapTest {

	@Test
	public void givenSentenceAndWordsAddedToListShouldReturnWordFrequencyTest() {
		String sentence = "To be or not to be";
		MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
		String words[] = sentence.toLowerCase().split(" ");
		for (String s : words) {
			Integer value = myHashMap.get(s);
			if (value == null)
				value = 1;
			else
				value++;
			myHashMap.add(s, value);
		}
		int frequency = myHashMap.get("to");
		System.out.println(myHashMap);
		Assert.assertEquals(2, frequency);
	}

}
