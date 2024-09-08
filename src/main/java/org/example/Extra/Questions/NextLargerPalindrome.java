package org.example.Extra.Questions;


import java.util.Arrays;

public class NextLargerPalindrome {

    //function to find next permutation
    public static String nextPermutation(String nums) {
        char[] numsArray = nums.toCharArray();
        int n=numsArray.length;
        int indexToSwap1=0;
        int indexToSwap2=0;
        int numberToSwap2=Integer.MAX_VALUE;
        boolean swapFound=false;

        for(int i=n-1;i>=0;i--) {
            for(int j=i+1;j<n;j++) {
                if(numsArray[j]>numsArray[i]) {
                    if(numberToSwap2>numsArray[j]) {
                        swapFound=true;
                        indexToSwap1=i;
                        indexToSwap2=j;
                        numberToSwap2=numsArray[j];
                    }
                }
            }
            if(swapFound) {
                break;
            }
        }
        char temp=numsArray[indexToSwap1];
        numsArray[indexToSwap1] = numsArray[indexToSwap2];
        numsArray[indexToSwap2]=temp;
        if(!swapFound) {
            return "not found";
        }
        Arrays.sort(numsArray,indexToSwap1+1,n);

        StringBuilder next = new StringBuilder();
        for(char i:numsArray) {
            next.append(i);
        }
        return next.toString();
    }

    //find next larger palindrome of a palindrome string using the same digits
    static String nextLargerPalindrome(String s) {
        char[] sArray = s.toCharArray();
        int n=sArray.length;

        char[] halfS = Arrays.copyOfRange(sArray, 0, (n + 1) / 2);

        String halfNextS = nextPermutation(new String(halfS));

        if(halfNextS.equals("not found")) {
            return "not found";
        }

        char[] nextLargerPalindrome = new char[n];

        for(int i=0;i<halfNextS.length();i++) {
            nextLargerPalindrome[i]=halfNextS.charAt(i);
            nextLargerPalindrome[n-i-1]=halfNextS.charAt(i);
        }

        return new String(nextLargerPalindrome);
    }

    public static void main(String[] args) {

        String s="1234321";
        System.out.println(nextLargerPalindrome(s));

    }
}
