package org.example.LLD.Designs.HashMap.ScaleableHashMap;

import java.util.*;

import java.util.*;

class ConsistentHashMap {
    private SortedMap<Integer, Bucket> hashRing; // Map of hash values to buckets
    private int numberOfVirtualNodes; // Number of virtual nodes per physical bucket
    private List<Bucket> buckets; // Physical buckets

    public ConsistentHashMap(int numBuckets, int numVirtualNodes) {
        this.hashRing = new TreeMap<>();
        this.numberOfVirtualNodes = numVirtualNodes;
        this.buckets = new ArrayList<>();

        // Initialize the buckets
        for (int i = 0; i < numBuckets; i++) {
            addBucket(new Bucket());
        }
    }

    // Hash function to get consistent hash value for a given key
    private int hash(String key) {
        return key.hashCode() & 0x7fffffff; // Ensure a positive integer
    }

    // Add a physical bucket
    public void addBucket(Bucket bucket) {
        buckets.add(bucket);

        // Create virtual nodes for this bucket
        for (int i = 0; i < numberOfVirtualNodes; i++) {
            int hash = hash("Bucket-" + buckets.size() + "-VirtualNode-" + i);
            hashRing.put(hash, bucket);
        }

        redistributeKeys();
    }

    // Remove a bucket and its virtual nodes
    public void removeBucket(Bucket bucket) {
        buckets.remove(bucket);

        // Remove associated virtual nodes
        Iterator<Map.Entry<Integer, Bucket>> iterator = hashRing.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Bucket> entry = iterator.next();
            if (entry.getValue() == bucket) {
                iterator.remove();
            }
        }

        redistributeKeys();
    }

    // Redistribute keys after scaling up or down
    private void redistributeKeys() {
        // Loop through all keys in the buckets and rehash them to the appropriate bucket
        for (Bucket bucket : buckets) {
            List<String> keys = new ArrayList<>(bucket.getKeys());
            for (String key : keys) {
                Bucket newBucket = getBucketForKey(key);
                if (newBucket != bucket) {
                    bucket.removeKey(key);
                    newBucket.addKey(key);
                }
            }
        }
    }

    // Find the bucket for a given key
    private Bucket getBucketForKey(String key) {
        int hash = hash(key);

        // Find the first bucket hash that is greater than or equal to the key's hash
        SortedMap<Integer, Bucket> tailMap = hashRing.tailMap(hash);
        int bucketHash = tailMap.isEmpty() ? hashRing.firstKey() : tailMap.firstKey();
        return hashRing.get(bucketHash);
    }

    // Add a key-value pair to the correct bucket
    public void put(String key, String value) {
        Bucket bucket = getBucketForKey(key);
        bucket.addKey(value);
    }

    // Retrieve a value for a given key
    public List<String> get(String key) {
        Bucket bucket = getBucketForKey(key);
        return bucket.getKeys();
    }
}
