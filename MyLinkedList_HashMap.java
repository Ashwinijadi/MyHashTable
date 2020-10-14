package com.capgemini.myhashtable;

import java.util.ArrayList;

public class MyLinkedList_HashMap<K, V> {

	private final int numBuckets;
	private int size;
	ArrayList<MyLinkedList<K>> myBucketArray;

	public MyLinkedList_HashMap() {
		this.numBuckets = 10;
		this.myBucketArray = new ArrayList<>(numBuckets);

		for (int i = 0; i < numBuckets; i++)
			this.myBucketArray.add(null);
	}

	private int getBucketIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % numBuckets;
		return index;
	}

	public V get(K key) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			return null;
		}
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		return (myMapNode == null) ? null : myMapNode.getValue();
	}

	public void add(K key, V value) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			myLinkedList = new MyLinkedList<>();
			this.myBucketArray.set(index, myLinkedList);
		}
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		if (myMapNode == null) {
			myMapNode = new MyMapNode<>(key, value);
			myLinkedList.append(myMapNode);
		} else {
			myMapNode.setValue(value);
		}
	}

	public MyMapNode<K, V> remove(K key) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			return null;
		} else {
			MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.delete(key);
			if (myMapNode == null) {
				return null;
			} else {
				myLinkedList.deleteAndReturnSizeOfList(myMapNode);
				return myMapNode;
			}
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public String toString() {
		return "MyLinkedList_HashMap List { " + numBuckets + " } ";
	}
}
