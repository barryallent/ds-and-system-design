package org.example.DataStructuresAndAlgorithm.LeetCode.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/time-based-key-value-store/

public class TimeBasedKeyValueStore {
    Map<String, List<String>> timeCache;
    public TimeBasedKeyValueStore() {
        timeCache = new HashMap<>();
    }


    //here the idea is to store a list for a key because it can contains multiple values and in the list element
    //we store both value and the timestamp, which will be used later to get
    public void set(String key, String value, int timestamp) {
        List<String> currentValue = timeCache.getOrDefault(key,new ArrayList<>());
        currentValue.add(value+" "+timestamp);
        timeCache.put(key,currentValue);
    }

    public String get(String key, int timestamp) {

        //get all the values for the key
        List<String> values = timeCache.getOrDefault(key,new ArrayList<>());

        int n = values.size();


        //iterate in reverse order to get the maxTimestamp(according to question)
        //If that max timestamp is less than given timestamp we can simply return it otherwise we go to lower value
        //via for loop
        for(int i=0;i<n;i++) {
            String value = values.get(n-i-1);
            String valueTimestamp = value.split(" ")[1];

            try {
                if(Integer.parseInt(valueTimestamp)<=timestamp) {
                    return value.split(" ")[0];
                }
            }
            catch (Exception E) {

            }

        }

        return "";
    }
}
