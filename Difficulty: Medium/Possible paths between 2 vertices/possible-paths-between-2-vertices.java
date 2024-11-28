//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            String[] S1 = br.readLine().trim().split(" ");
            int source = Integer.parseInt(S1[0]);
            int destination = Integer.parseInt(S1[1]);
            Solution obj = new Solution();
            System.out.println(obj.countPaths(V, adj, source, destination));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



class Solution {
    // Function to count paths between two vertices in a directed graph.
    private int count = 0;

    public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source, int destination) {
        boolean[] visited = new boolean[V]; // Array to track visited nodes
        dfs(adj, visited, source, destination); // Start DFS from the source node
        return count;
    }

    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int current, int destination) {
        // If the current node is the destination, increment the count
        if (current == destination) {
            count++;
            return;
        }

        // Mark the current node as visited
        visited[current] = true;

        // Explore all adjacent nodes
        for (int adjNode : adj.get(current)) {
            if (!visited[adjNode]) {
                dfs(adj, visited, adjNode, destination);
            }
        }

        // Backtrack by unmarking the current node as visited
        visited[current] = false;
    }

   
}
