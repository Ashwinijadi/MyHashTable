package com.capgemini.myhashtable;

import org.junit.Assert;
import org.junit.Test;

public class MyHashMapTest {

	
	@Test
	public void givenASentenceWhenWordsAreAddedToListShouldReturnWordsFrequency() {
		String sentence = "Paranoids are not paranoid because they are paranoid but"
				        + " because they keep putting themselves deliberately "
				        + "into paranoid avoidable situations";
		MyLinkedList_HashMap<String, Integer> myLinkedHashMap = new MyLinkedList_HashMap();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myLinkedHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			myLinkedHashMap.add(word, value);
		}
		int frequency = myLinkedHashMap.get("paranoid");
		Assert.assertEquals(3, frequency);
	}
}
