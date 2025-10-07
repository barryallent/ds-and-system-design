package org.example.DataStructuresAndAlgorithm.LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/restore-ip-addresses/description/
public class RestoreIPAddresses {
    // List to store all valid IP address combinations
    List<String> allIPs = new ArrayList<>();

    /**
     * Recursively builds all possible valid IP addresses
     *
     * @param s         The input numeric string
     * @param current   The current partially formed IP address (with dots)
     * @param i         Current index in the string 's' from where next segment starts
     * @param dotCount  Number of dots placed so far (i.e., number of segments formed)
     */
    void restoreIpAddresses(String s, String current, int i, int dotCount) {
        // Base case: If 4 segments are formed and we've used all characters
        if (dotCount == 4 && i == s.length()) {
            // Remove the trailing dot and add to final result list
            allIPs.add(current.substring(0, current.length() - 1));
        }

        // If more than 4 segments are formed, stop exploring this path
        if (dotCount > 4) {
            return;
        }

        // Try to form the next segment of 1 to 3 digits
        //eg 255123, so we can take 3 digits together at max after that we have to apply a dot
        //so we can form 2. or 25. or 255.
        for (int j = i; j < Math.min(i + 3, s.length()); j++) {

            // Take substring from current index 'i' to 'j' (inclusive)
            String part = s.substring(i, j + 1);

            // Check if:
            // 1. The number <= 255 (valid IPv4 range)
            // 2. The number has no leading zeros unless it is exactly "0"
            if (Integer.parseInt(part) <= 255 &&
                    (part.length() == 1 || s.charAt(i) != '0')) {

                // Recurse for the next segment, appending this part + "."
                // Move index to j + 1 and increase dotCount by 1
                restoreIpAddresses(s, current + part + ".", j + 1, dotCount + 1);
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        // An IPv4 address has at most 12 digits (4 parts * 3 digits)
        if (s.length() > 12) {
            return new ArrayList<>();
        }

        // Start recursive backtracking from index 0 with 0 dots placed
        restoreIpAddresses(s, "", 0, 0);

        return allIPs;
    }
}
