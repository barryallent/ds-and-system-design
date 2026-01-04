package org.example.DataStructuresAndAlgorithm.LeetCode.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAllAnagramsInAString {
        //this function checks if both the arrays are equal
        //because for anagrams all elements should have same frequency
        boolean checkIfAnagramFormed(int[] sChars, int[] pChars) {
            for (int i = 0; i < pChars.length; i++) {
                if (sChars[i] != pChars[i]) {
                    return false;
                }
            }

            return true;
        }

        //idea is to apply sliding window
        public List<Integer> findAnagrams(String s, String p) {

            //arrays to store s and p frequencies
            int[] sChars = new int[26];
            int[] pChars = new int[26];

            //first calculate what exactly we need to form i.e. p
            for (char c : p.toCharArray()) {
                pChars[c - 'a']++;
            }

            int l = 0, r = 0, n = s.length();

            List<Integer> allAnagrams = new ArrayList<>();

            while (r < n) {

                //inc frequency
                sChars[s.charAt(r) - 'a']++;

                //if we get greater frequency then needed then this window becomes invalid
                while (sChars[s.charAt(r) - 'a'] > pChars[s.charAt(r) - 'a']) {
                    sChars[s.charAt(l) - 'a']--;
                    l++;
                }

                //this is just O(26)
                //if valid anagram formed then we store starting index
                if (checkIfAnagramFormed(sChars, pChars)) {
                    allAnagrams.add(r - p.length() + 1);
                }
                r++;
            }
            return allAnagrams;
        }
}
