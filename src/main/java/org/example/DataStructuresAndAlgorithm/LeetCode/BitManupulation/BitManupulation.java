package org.example.DataStructuresAndAlgorithm.LeetCode.BitManupulation;

public class BitManupulation {

    // Function to convert binary string to decimal by iterating from right to left
    public static int binaryToDecimal(String binaryString) {
        int powerOfTwo = 1;
        int decimal = 0;
        int n = binaryString.length();

        // Iterate over the binary string from right to left
        for (int i = 0; i < n; i++) {
            char bit = binaryString.charAt(n - i - 1); // Get the bit from the right

            // If the bit is '1', add the current power of two to the decimal result
            if (bit == '1') {
                decimal = decimal + powerOfTwo;
            }

            // Multiply powerOfTwo by 2 for the next iteration
            powerOfTwo = powerOfTwo * 2;
        }

        return decimal;
    }

    public static String decimalToBinary(int n) {
        int powerOfTwo = 1;

        StringBuilder binaryString=new StringBuilder();

        while(n>0) {
            binaryString.append(n%2);
            n=n/2;
        }

        return binaryString.reverse().toString();
    }

    public static void main(String[] args) {
        // Example binary number as a string
        String binaryString = "1101"; // binary for 11 in decimal

        // Convert binary to decimal
        int decimal = binaryToDecimal(binaryString);

        int decimal2 = 13;

        String binaryString2 = decimalToBinary(decimal2);

        System.out.println("Decimal: " + decimal2 + " in Binary: " + binaryString2);

        // Output the result
        System.out.println("Binary: " + binaryString + " in Decimal: " + decimal);
    }
}

