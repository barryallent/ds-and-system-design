package org.example.LLD.Designs.HashMap;

import lombok.Data;

@Data
public class Entry<K,V> {
    private K key;
    private V value;

    Entry next;

    Entry(K key, V value) {
        this.key=key;
        this.value=value;
    }
}
