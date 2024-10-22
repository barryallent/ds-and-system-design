package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

//https://leetcode.com/problems/longest-happy-string/description/
public class LongestHappyString {
    //function to find largest and second larget frequency elements
    char[] findLargestFrequencyElements(int[] elements) {
        int largestFrequency=-1;
        char largestFrequencyElement='a';
        int secondLargestFrequency=-1;
        char secondLargestFrequencyElement='a';
        for(int i=0;i<elements.length;i++) {
            if(elements[i]>largestFrequency) {
                secondLargestFrequency=largestFrequency;
                secondLargestFrequencyElement=largestFrequencyElement;
                largestFrequency=elements[i];
                largestFrequencyElement = (char) (i+'a');
            }
            else if(elements[i]>secondLargestFrequency) {
                secondLargestFrequency=elements[i];
                secondLargestFrequencyElement=(char) (i+'a');
            }
        }
        return new char[]{largestFrequencyElement, secondLargestFrequencyElement};
    }
    public String longestDiverseString(int a, int b, int c) {

        //frequency array to store frequency of a, b and c and assign initial frequency
        int[] elements = new int[3];
        elements[0]=a; elements[1]=b; elements[2]=c;

        StringBuilder ans = new StringBuilder();

        //while any of the elements frequency > 0
        while (elements[0]>0 || elements[1]>0 || elements[2]>0) {
            char[] findLargestFrequencyElements = findLargestFrequencyElements(elements);

            //if ans length is less than 2 then just add largest frequency to ans
            if(ans.length()<2) {
                ans.append(findLargestFrequencyElements[0]);
                elements[findLargestFrequencyElements[0]-'a']--;
            }

            //else find out the last 2 chars and see if they are same
            else {
                char lastChar = ans.charAt(ans.length()-1);
                char secondLastChar = ans.charAt(ans.length()-2);

                //if last 2 chars are same then add second largest frequency element
                if( lastChar == findLargestFrequencyElements[0] && secondLastChar==findLargestFrequencyElements[0]) {
                    if(elements[findLargestFrequencyElements[1]-'a']>0) {
                        ans.append(findLargestFrequencyElements[1]);
                        elements[findLargestFrequencyElements[1]-'a']--;
                    }

                    //if second largest frequency not left then return
                    else {
                        return ans.toString();
                    }
                }

                //if last 2 chars are different then just add the largest frequency element
                else {
                    ans.append(findLargestFrequencyElements[0]);
                    elements[findLargestFrequencyElements[0]-'a']--;
                }
            }
        }
        return ans.toString();
    }
}
