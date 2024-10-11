package org.example.LLD.Designs.HashMap.ScaleableHashMap;

public class Client {
    public static void main(String[] args) {
        ConsistentHashMap consistentHashMap = new ConsistentHashMap(3, 3);

        // Adding some keys
        consistentHashMap.put("key1", "value1");
        consistentHashMap.put("key2", "value2");
        consistentHashMap.put("key3", "value3");

        // Retrieve keys
        System.out.println(consistentHashMap.get("key1"));
        System.out.println(consistentHashMap.get("key2"));

        // Add a new bucket
        consistentHashMap.addBucket(new Bucket());

        // Remove a bucket
//        consistentHashMap.removeBucket(consistentHashMap.get("key1").get(0));
    }

}
