package org.example.LLD.Designs.HashMap;

public class Client {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>(7);
        map.put("node 1",2);
        map.put("node 2", 100);
        map.put("node 3",1000);
        map.put("node 100",200);
        System.out.println(map.get("node1"));
        System.out.println(map.get("node 3"));
        System.out.println(map.get("node 100"));
        map.remove("node 3");
        System.out.println(map.get("node 3"));
    }

}
