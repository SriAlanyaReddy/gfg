class Solution {
    static int minDiff(Node root, int K) {
        int minDiff = Integer.MAX_VALUE;

        while (root != null) {
            minDiff = Math.min(minDiff, Math.abs(root.data - K));

            if (K < root.data) {
                root = root.left;
            } else if (K > root.data) {
                root = root.right;
            } else {
                return 0; // exact match -> diff is zero
            }
        }
        return minDiff;
    }
}
