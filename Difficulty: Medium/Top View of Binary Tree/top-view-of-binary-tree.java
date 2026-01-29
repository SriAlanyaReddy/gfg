/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
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

    public ArrayList<Integer> topView(Node root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            Node node = curr.node;
            int hd = curr.hd;

            // first node at this horizontal distance
            map.putIfAbsent(hd, node.data);

            if (node.left != null)
                queue.offer(new Pair(node.left, hd - 1));

            if (node.right != null)
                queue.offer(new Pair(node.right, hd + 1));
        }

        for (int val : map.values()) {
            res.add(val);
        }

        return res;
    }
}
