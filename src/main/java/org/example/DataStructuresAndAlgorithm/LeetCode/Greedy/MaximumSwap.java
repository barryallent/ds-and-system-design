package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

public class MaximumSwap {
    int convertCharArrayToNumber(char[] numChars ) {
        int number=0;
        int n = numChars.length;
        for(int i=0;i<n;i++) {
            number=number+ (numChars[n-i-1] - '0')* (int) Math.pow(10, i);
        }
        return number;
    }

    public int maximumSwap(int num) {

        String numString = String.valueOf(num);
        char[] numChars = numString.toCharArray();
        int n = numString.length();
        int maxNumber=num;

        //try swapping all 2 characters and check maximum
        for(int i=0;i<n;i++) {
            char a = numChars[i];
            for(int j=i+1;j<n;j++) {
                numChars[i]=numChars[j];
                numChars[j]=a;
                int number = convertCharArrayToNumber(numChars);
                maxNumber = Math.max(maxNumber, number);

                //swap back
                char temp=numChars[i];
                numChars[i]=numChars[j];
                numChars[j]=temp;
            }
        }
        return maxNumber;
    }
}
