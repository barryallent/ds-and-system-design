package org.example.LLD.Designs.HashMap.ScaleableHashMap;

import java.util.*;

class Bucket {
    private List<String> keys; // List of keys stored in this bucket

    public Bucket() {
        keys = new ArrayList<>();
    }

    public void addKey(String key) {
        keys.add(key);
    }

    public void removeKey(String key) {
        keys.remove(key);
    }

    public List<String> getKeys() {
        return keys;
    }
}
