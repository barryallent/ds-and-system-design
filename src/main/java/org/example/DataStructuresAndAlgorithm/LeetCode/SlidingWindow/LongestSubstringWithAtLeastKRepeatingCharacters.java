package org.example.DataStructuresAndAlgorithm.LeetCode.SlidingWindow;

//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
public class LongestSubstringWithAtLeastKRepeatingCharacters {

        //check how many distinct chars in string
        int getDistinctCharactersCount(int[] sCharsFrequency) {
            int distinctCount = 0;
            for (int i : sCharsFrequency) {
                if (i > 0)
                    distinctCount++;
            }
            return distinctCount;
        }

        //check if all frequencies are greater than k
        boolean checkIsCharactersFrequencyValid(int[] sCharsFrequency, int k) {
            for (int i : sCharsFrequency) {
                if (i > 0 && i < k) {
                    return false;
                }
            }

            return true;
        }

        public int longestSubstring(String s, int k) {

            int maxLength = 0;
            int n = s.length();

            //to improve complexity, this is smart way to calculate uniqueCharacters
            //so that for loop does not go till n
            int uniqueCharacters = 0;
            int[] sUniqueCharsCheck = new int[26];

            for (int i = 0; i < n; i++) {
                sUniqueCharsCheck[s.charAt(i) - 'a']++;
            }

            for (int i : sUniqueCharsCheck) {
                if (i > 0) {
                    uniqueCharacters++;
                }
            }

            //loop for how many distinct chars, this is the crux, this is the logic
            //for invalid window condition
            for (int i = 1; i <= uniqueCharacters; i++) {

                int[] sCharsFrequency = new int[26];

                int l = 0, r = 0;

                while (r < n) {
                    sCharsFrequency[s.charAt(r) - 'a']++;

                    //shrink window, because distinct chars allowed are i
                    while (getDistinctCharactersCount(sCharsFrequency) > i) {
                        sCharsFrequency[s.charAt(l) - 'a']--;
                        l++;
                    }

                    //check if window valid
                    if (checkIsCharactersFrequencyValid(sCharsFrequency, k)) {
                        maxLength = Math.max(maxLength, r - l + 1);
                    }
                    r++;
                }

            }

            return maxLength;
        }
}
