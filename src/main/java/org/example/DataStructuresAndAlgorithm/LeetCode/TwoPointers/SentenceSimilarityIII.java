package org.example.DataStructuresAndAlgorithm.LeetCode.TwoPointers;

//https://leetcode.com/problems/sentence-similarity-iii/description/
public class SentenceSimilarityIII {
    //there are 3 cases for sentenses to be similar,
    //1. s1= my name is, s2 = a b c my name is -> can add at beginneing of s1
    //2. s1 = my name is, s2 = my name is a b c -> can add at end of s1
    //3. s1 = my hailey, s2 = my name is hailey -> can add in b/w of s1
    //in case 1 it is match from suffix, in case 2 it is matched from prefix
    //in case 3 some match from prefix and some match from suffix in all cases
    //left pointer of s1 > right pointer of s1
    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        //ensure sentense1 is always smaller to avoid else if conditions
        if(sentence1.length()>sentence2.length()) {
            String temp=sentence1;
            sentence1 = sentence2;
            sentence2 = temp;
        }

        //convert sentense to words array
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");


        int words1LeftPointer=0;
        //try to match from prefix, keep l < shorter array length i.e words1
        while(words1LeftPointer<words1.length) {
            if(words1[words1LeftPointer].equals(words2[words1LeftPointer])) {
                words1LeftPointer++;
            }
            else {
                break;
            }
        }

        //match from suffix
        int words1RightPointer = words1.length-1;
        int words2RightPointer = words2.length-1;

        while(words1RightPointer >=0 && words1[words1RightPointer].equals(words2[words2RightPointer])) {
            words1RightPointer--;
            words2RightPointer--;
        }

        //they should cross
        return words1RightPointer<words1LeftPointer;

    }
}
