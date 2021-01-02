package com.metalheart.greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Имеется массив V целых чисел, состоящий из N×10^8 элементов,
 * −2 × 10^9 < Vi < 2 × 10^9.
 * Подмассивом называют непрерывное подмножество элементов массива, возможно, включающее в себя и полный массив.
 * Требуется найти наибольшую из возможных сумм всех подмассивов.
 */
public class GreedyAlgorithm1Test {

    @Test
    public void simple() {

        assertEquals(10, findMaximalSubarraysSum(10, -4, 4, 3, 3, -4, 1, 2, 1, -4, 0));
        assertEquals(-2, findMaximalSubarraysSum(-4, -2));
        assertEquals(6, findMaximalSubarraysSum(-4, -2, 1, 2, 3));
    }

    private int findMaximalSubarraysSum(int... v) {

        Integer res = null;
        Integer currentMax = null;
        ;
        boolean isBrokenSeq = true;


        if (v.length < 0) {
            throw new IllegalArgumentException();
        }

        for (int i : v) {

            if (i < 0) {
                currentMax = i;
                isBrokenSeq = true;
            } else {
                currentMax = currentMax == null || isBrokenSeq ? i : currentMax + i;
                isBrokenSeq = false;
            }

            if (res == null || res < currentMax) {
                res = currentMax;
            }
        }
        return res;
    }
}
