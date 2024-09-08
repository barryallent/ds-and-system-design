package org.example.Extra.Questions;

//https://www.geeksforgeeks.org/problems/maximum-number-of-characters-between-any-two-same-character4552/1
public class MaxCharBetween {
    public int maxChars(String s)
    {
        //all these chars possible so 256 size
        int[] characters = new int[256];

        // Initialize all indexes as -1.
        for(int i=0;i<256;i++) {
            characters[i]=-1;
        }
        int maxDistance=-1;
        for(int i=0;i<s.length();i++) {

            //find the value of this char from the array
            int firstIndex = characters[s.charAt(i)-'0'];

            //if first occurance then store the index
            if(firstIndex==-1) {
                characters[s.charAt(i)-'0']=i;
            }
            //else calculate distance b/w this occurance and 1st and update index
            //also no need to update 1st occurance because number can occur again so we need to
            //have 1st occurance
            else {
                maxDistance=Math.max(maxDistance,i-firstIndex-1);
            }
        }
        return maxDistance;
    }
}
