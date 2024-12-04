//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<String> res = new ArrayList<>();
        int n = mat.size();
        
        // Validate if the start or end is blocked
        if (n == 0 || mat.get(0).get(0) == 0 || mat.get(n - 1).get(n - 1) == 0) {
            return res;
        }
        
        // Start finding paths
        findPaths(mat, 0, 0, "", res, n);
        return res;
    }

    private void findPaths(ArrayList<ArrayList<Integer>> mat, int row, int col, String path, ArrayList<String> res, int n) {
        // Boundary and obstacle check
        if (row < 0 || col < 0 || row >= n || col >= n || mat.get(row).get(col) == 0) {
            return;
        }

        // If destination is reached, add the path to the result
        if (row == n - 1 && col == n - 1) {
            res.add(path);
            return;
        }

        // Mark the current cell as visited
        mat.get(row).set(col, 0);

        // Explore all directions in lexicographical order: D, L, R, U
        findPaths(mat, row + 1, col, path + "D", res, n); // Down
        findPaths(mat, row, col - 1, path + "L", res, n); // Left
        findPaths(mat, row, col + 1, path + "R", res, n); // Right
        findPaths(mat, row - 1, col, path + "U", res, n); // Up

        // Backtrack: Unmark the current cell
        mat.get(row).set(col, 1);
    }
}


