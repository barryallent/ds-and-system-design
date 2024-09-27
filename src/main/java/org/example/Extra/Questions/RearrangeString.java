package org.example.Extra.Questions;

import java.util.HashMap;
import java.util.Map;

class RearrangeString {

    static class Pair {
        char highestFrequenceyElement;
        char secondHighestFrequenceyElement;

        Pair(char h, char s) {
            this.highestFrequenceyElement = h;
            this.secondHighestFrequenceyElement = s;
        }
    }

    static Pair getHighFrequencyElements(String s,  Map<Character,Integer> sMap) {
        int highestFrequency = -1;
        int secondHighestFrequency = -1;
        char highestFrequenceyElement = '0';
        char secondHighestFrequenceyElement = '0';

        for(Map.Entry<Character,Integer> entry : sMap.entrySet()) {
            int freq = entry.getValue();
            if (freq > highestFrequency) {
                secondHighestFrequenceyElement = highestFrequenceyElement;
                secondHighestFrequency = highestFrequency;

                highestFrequenceyElement = entry.getKey();
                highestFrequency = freq;
            } else if (freq > secondHighestFrequency) {
                secondHighestFrequenceyElement = entry.getKey();
                secondHighestFrequency = freq;
            }
        }

        return new Pair(highestFrequenceyElement, secondHighestFrequenceyElement);
    }

    static String rearrangeCharacters(String s) {
        Map<Character,Integer> sMap = new HashMap<>();
        StringBuilder uniqueCharacter = new StringBuilder();

        for(char c : s.toCharArray()) {
            if (!sMap.containsKey(c)) {
                uniqueCharacter.append(c);
            }
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        StringBuilder rearrangedString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            Pair p = getHighFrequencyElements(s, sMap);

            // If we cannot find a valid second highest element, return ""
            if (p.highestFrequenceyElement == '0' || (i % 2 != 0 && p.secondHighestFrequenceyElement == '0')) {
                return "";
            }

            // If even index, use highest frequency element
            if (i % 2 == 0) {
                rearrangedString.append(p.highestFrequenceyElement);
                sMap.put(p.highestFrequenceyElement, sMap.getOrDefault(p.highestFrequenceyElement, 0) - 1);
            }
            // If odd index, use second highest frequency element
            else {
                rearrangedString.append(p.secondHighestFrequenceyElement);
                sMap.put(p.secondHighestFrequenceyElement, sMap.getOrDefault(p.secondHighestFrequenceyElement, 0) - 1);
            }

            // Remove elements with zero frequency
            if (sMap.get(p.highestFrequenceyElement) == 0) {
                sMap.remove(p.highestFrequenceyElement);
            }
            if (sMap.get(p.secondHighestFrequenceyElement) == 0) {
                sMap.remove(p.secondHighestFrequenceyElement);
            }
        }
        return rearrangedString.toString();
    }

    public static void main(String[] args) {
        String input = "abcd";
        String result = rearrangeCharacters(input);
        System.out.println(result);
        System.out.println("finish");
        // Output can be "ababac" or similar valid string
    }
}

