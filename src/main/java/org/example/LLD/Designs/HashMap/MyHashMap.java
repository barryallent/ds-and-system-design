package org.example.LLD.Designs.HashMap;

public class MyHashMap<K,V> {
    public static final int INITIAL_SIZE=16;
    public static final int MAXIMUM_SIZE=1<<30;
    Entry[] hashTable;

    MyHashMap() {
        hashTable=new Entry[INITIAL_SIZE];
    }
    MyHashMap(int capacity) {
        int tableSize=tableSizeFor(capacity);
        hashTable=new Entry[tableSize];
    }
    final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_SIZE) ? MAXIMUM_SIZE : n + 1;
    }

    public void put(K key, V value) {
        int hashCode = Math.abs(key.hashCode()) % hashTable.length;
        Entry node = hashTable[hashCode];
        Entry newNode=new Entry(key,value);

        if(node==null) {
            hashTable[hashCode]=newNode;
        }
        else {
            Entry previousNode=null;
            while(node!=null) {
                if(node.getKey().equals(key)) {
                    node.setValue(value);
                    return;
                }
                previousNode=node;
                node=node.next;
            }
            previousNode.next=newNode;
        }
    }

    public V get(K key) {
        int hashCode=Math.abs(key.hashCode()) % hashTable.length;
        Entry node=hashTable[hashCode];

        while(node!=null) {
            if(node.getKey().equals(key)) {
                return (V) node.getValue();
            }
            node=node.next;
        }
        return null;
    }

    public void remove(K key) {
        int hashCode = Math.abs(key.hashCode()) % hashTable.length;
        Entry node = hashTable[hashCode];
        Entry previousNode = null;

        while (node != null) {
            if (node.getKey().equals(key)) {
                if (previousNode == null) {
                    // Removing the first node in the bucket
                    hashTable[hashCode] = node.next;
                } else {
                    previousNode.next = node.next;
                }
                return; // Node found and removed, exit the function
            }
            previousNode = node;
            node = node.next;
        }
    }


}
