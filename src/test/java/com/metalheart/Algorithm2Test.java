package com.metalheart;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

/**

 Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

 For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

 Bonus: Can you do this in one pass?

 */
public class Algorithm2Test {

    @Test
    public void simpleSolseTest() {

        Assert.assertEquals(Set.of(10, 7), solve(17, asList(10, 15, 3, 7)));
        Assert.assertEquals(Set.of(14, 3), solve(17, asList(10, 15, 3, 8, 14)));
        Assert.assertEquals(Set.of(10, 7), solve(17, asList(10, 15, 7)));
        Assert.assertEquals(Set.of(15, 3), solve(17, asList(10, 15, 3)));
        Assert.assertEquals(Set.of(10, 7), solve(17, asList(10, 7)));

    }

    /**
     * O(n^2)
     *
     * @param k
     * @param listOfNumbers
     * @return
     */
    private static Set<Integer> solve(Integer k, List<Integer> listOfNumbers) {

        int closestArg0 = 0, closestArg1 = 0, closestDiff = k;

        for (int i = 0; i < listOfNumbers.size(); i++) {
            for (int j = 0; j < listOfNumbers.size(); j++) {

                if (i == j) {
                    continue;
                }

                int arg0 = listOfNumbers.get(i);
                int arg1 = listOfNumbers.get(j);
                int sum = arg0 + arg1;
                int diff = Math.abs(k - sum);

                if (diff == 0) {

                    return Set.of(arg0, arg1);

                } else if (diff < closestDiff) {
                    closestArg0 = arg0;
                    closestArg1 = arg1;
                    closestDiff = diff;
                }
            }
        }
        return Set.of(closestArg0, closestArg1);
    }
}
