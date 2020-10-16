package com.metalheart;

import com.metalheart.alg.BreadthFirstSearch;
import com.metalheart.struct.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class BFSTest {

    @Test
    public void testSuccessLevel_1() {

        // arrange
        TreeNode start = new TreeNode(),
                goal = new TreeNode();

        start.add(goal);

        // act
        boolean isReachable = BreadthFirstSearch.isReachable(start, goal);

        // assert
        Assert.assertTrue(isReachable);
    }

    @Test
    public void testFailLevel_1() {

        // arrange
        TreeNode start = new TreeNode(),
                goal = new TreeNode();

        // act
        boolean isReachable = BreadthFirstSearch.isReachable(start, goal);

        // assert
        Assert.assertFalse(isReachable);
    }


    @Test
    public void testSuccessLevel_2() {

        // arrange
        TreeNode[] nodes = IntStream.range(0, 5)
                .mapToObj(i -> new TreeNode())
                .collect(Collectors.toList())
                .toArray(new TreeNode[]{});

        nodes[0].add(nodes[1]);
        nodes[0].add(nodes[2]);

        nodes[1].add(nodes[3]);
        nodes[1].add(nodes[4]);

        // act
        boolean isReachable = BreadthFirstSearch.isReachable(nodes[0], nodes[4]);

        // assert
        Assert.assertTrue(isReachable);
    }

    @Test
    public void testFailLevel_2() {


        // arrange
        TreeNode[] nodes = IntStream.range(0, 5)
                .mapToObj(i -> new TreeNode())
                .collect(Collectors.toList())
                .toArray(new TreeNode[]{});

        nodes[0].add(nodes[1]);
        nodes[0].add(nodes[2]);

        nodes[1].add(nodes[3]);

        // act
        boolean isReachable = BreadthFirstSearch.isReachable(nodes[0], nodes[4]);

        // assert
        Assert.assertFalse(isReachable);
    }

}
