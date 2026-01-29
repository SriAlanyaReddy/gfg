/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/


import java.util.*;

class Solution {

    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            Node node = curr.node;
            int hd = curr.hd;

            // overwrite value at this horizontal distance
            map.put(hd, node.data);

            if (node.left != null)
                queue.offer(new Pair(node.left, hd - 1));

            if (node.right != null)
                queue.offer(new Pair(node.right, hd + 1));
        }

        // extract result from leftmost HD to rightmost
        for (int val : map.values()) {
            res.add(val);
        }

        return res;
    }
}
