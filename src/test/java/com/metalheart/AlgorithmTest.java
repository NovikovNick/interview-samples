package com.metalheart;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AlgorithmTest {

    @Test
    public void test() {
        /**

         Given a string with repeated characters, rearrange the
         string so that no two adjacent characters are the same.
         If this is not possible, return None.
         For example, given "aaabbc", you could return "ababac".
         Given "aaab", return None.

         */

        Assert.assertEquals("ababac", solve("aaabbc"));
        Assert.assertEquals("None", solve("aaab"));
        Assert.assertEquals("None", solve("aaabbbbb"));
        Assert.assertEquals("None", solve("caaabbbbbb"));
    }

    private static String solve(String input) {

        Map<Character, Long> countByChars = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        List<Character> chars = countByChars.keySet()
                .stream()
                .sorted(Comparator.comparingLong(countByChars::get).reversed())
                .collect(Collectors.toList());

        { // check
            Character c0 = chars.get(0);
            Long c0Count = countByChars.get(c0);

            Long sumOthers = chars.stream()
                    .skip(1)
                    .mapToLong(countByChars::get)
                    .sum();

            if (c0Count - sumOthers > 1) {

                System.out.println(String.format("Unable to solve %s %s: sumOthers=%d, %s=%d",
                        input, countByChars, sumOthers, c0, c0Count));
                return "None";
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chars.size() - 1; i++) {

            Character c0 = chars.get(i);

            for (int j = i + 1; j < chars.size(); j++) {

                Character c1 = chars.get(j);

                while (countByChars.get(c0) > 0 && countByChars.get(c1) > 0) {

                    res.append(c0);
                    res.append(c1);
                    countByChars.put(c0, countByChars.get(c0) - 1);
                    countByChars.put(c1, countByChars.get(c1) - 1);
                }
            }
        }

        return res.toString();
    }
}
