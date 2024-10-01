package org.example.LeetCode.LinkedList;

import java.util.*;

//https://leetcode.com/problems/lfu-cache/

//node will store key value and frequency
class Node {
    int key;
    int val;
    int frequency;
    Node prev;
    Node next;
    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.frequency = 1;
    }
}

//doubly linkedlist, function to add node at start and remove any node
class DoublyLinkedList {
    int listSize;
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.listSize = 0;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    public void addNode(Node node) {
        Node nextNode = head.next;
        node.next = nextNode;
        node.prev=head;
        head.next = node;
        nextNode.prev = node;
        listSize++;
    }
    public void removeNode(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
        listSize--;
    }
}

class LFUCache {

    //cache and also a map of frequencies, frequency map with key 1 has a doubly linkedlist which
    //contains all the nodes with frequency 1
    Map<Integer,Node> cache ;
    Map<Integer,DoublyLinkedList> frequencyMap;

    int minFrequency;
    int capacity;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        cache = new HashMap<>();
        frequencyMap = new HashMap<>();
        this.minFrequency=0;
    }

    //get the key
    public int get(int key) {
        Node node = cache.get(key);
        if(node==null) {
            return -1;
        }

        //update the frequencies, if element occur in 1 frequency map, now we need to remove and
        //add to 2 frequency map
        updateNode(node);
        return node.val;
    }

    public void put(int key, int value) {

        //if key is present the just update the node value
        //and update the node frequency map
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val=value;
            updateNode(node);
        }
        else {

            //if capacity reached then remove the tail node from lowest frequency map
            if(cache.size()==capacity) {
                DoublyLinkedList minFrequencyList = frequencyMap.get(minFrequency);
                cache.remove(minFrequencyList.tail.prev.key);
                minFrequencyList.removeNode(minFrequencyList.tail.prev);
            }

            //update min frequency because element is coming first time
            minFrequency = 1;

            //add the node in the frequency map of 1, we will add at start, since we are removing from end
            Node newNode = new Node(key, value);
            DoublyLinkedList minFrequencyList = frequencyMap.getOrDefault(1, new DoublyLinkedList());
            minFrequencyList.addNode(newNode);
            frequencyMap.put(1, minFrequencyList);
            cache.put(key, newNode);
        }
    }

    //function to update the frequency map of the node
    public void updateNode(Node node) {
        int frequency = node.frequency;

        //remove the node from current frequency map
        DoublyLinkedList frequencyList = frequencyMap.get(frequency);
        frequencyList.removeNode(node);

        //if we are at minfrequency and listsize is 0 for that, so we need to update the
        //min frequency
        if (frequency == minFrequency && frequencyList.listSize == 0) {
            minFrequency++;
        }

        //increase the node frequency, because it is get or put
        node.frequency++;

        //put the node in the new frequency map, it will add the node at start since we want LRU
        //in case of ties
        DoublyLinkedList newList = frequencyMap.getOrDefault(node.frequency, new DoublyLinkedList());
        newList.addNode(node);
        frequencyMap.put(node.frequency, newList);
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */