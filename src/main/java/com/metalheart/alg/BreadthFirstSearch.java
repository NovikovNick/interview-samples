package com.metalheart.alg;

import com.metalheart.struct.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  Поиск в ширину это один из самых базовый алгоритмов обхода графа. Принцип его работы заключается в том,
 *  что поиск производится путем последовательного просмотра отдельных уровней графа.
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%9F%D0%BE%D0%B8%D1%81%D0%BA_%D0%B2_%D1%88%D0%B8%D1%80%D0%B8%D0%BD%D1%83">wiki</a>
 */
public class BreadthFirstSearch {


    public static boolean isReachable(TreeNode start, TreeNode goal) {

        List<TreeNode> visited = new LinkedList<>(); // список посещенных нод
        Queue<TreeNode> q = new ArrayDeque<>(); // очередь нод для проверки

        visited.add(start);
        q.add(start);

        while (!q.isEmpty()) {

            var n = q.poll(); // нода на проверку

            if (n == goal) {
                return true;
            }

            for (TreeNode child : n.getChildren()) {

                if (!visited.contains(child)) { // если ноду еще не посещали
                    visited.add(child);
                    q.add(child); // добавлеям на проверку
                }
            }
        }
        return false;
    }
}
