package org.example.DataStructuresAndAlgorithm.LeetCode.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/time-based-key-value-store/

//used pair instead of String to avoid the split and converting back to int complexity inside binary search
class Pair {
    int timestamp;
    String value;

    Pair(int timestamp, String value) {
        this.timestamp=timestamp;
        this.value=value;
    }
}


public class TimeBasedKeyValueStore {

    Map<String, List<Pair>> timeCache;

    public TimeBasedKeyValueStore() {
        timeCache = new HashMap<>();
    }

    //here the idea is to store a list for a key because it can contains multiple values and in the list element
    //we store both value and the timestamp, which will be used later to get, since the timestamp is always inc so array
    //is sorted
    public void set(String key, String value, int timestamp) {
        List<Pair> currentValue = timeCache.getOrDefault(key, new ArrayList<>());
        currentValue.add(new Pair(timestamp,value));
        timeCache.put(key, currentValue);
    }

    public String get(String key, int timestamp) {

        //get all the values for the key
        List<Pair> values = timeCache.getOrDefault(key, new ArrayList<>());

        int n = values.size();

        if (n == 0) {
            return "";
        }

        //applying binary search to find the index with maxTimestamp possible that is less than timestamp

        int start = 0, end = n - 1;

        int finalIndex = 0;
        boolean isFinalIndexSet = false;
        while (start <= end) {

            int mid = start + (end - start) / 2;

            int currentTimestamp = values.get(mid).timestamp;

            //if we get it shorter then we save it and try to find bigger than this
            if (currentTimestamp <= timestamp) {
                isFinalIndexSet = true;
                finalIndex = mid;
                start = mid + 1;
            }

            //if currenttimestamp is already larger then we search in left area
            else {
                end = mid - 1;
            }

        }

        return isFinalIndexSet ? values.get(finalIndex).value : "";
    }
}
