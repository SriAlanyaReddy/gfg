//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java


class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Step 1: Build the adjacency list from the edge list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < E; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }
      
        // Step 2: Perform topological sort using DFS
        Stack<Integer> st = new Stack<>();
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, st, adj);
            }
        }
       
        // Step 3: Initialize distances with a large number (infinity)
        int[] distance = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[0] = 0;  // Assume 0 is the starting node
      
        // Step 4: Process each node in topological order to find the shortest path
        while (!st.isEmpty()) {
            int current = st.pop();
            
            // If current node is reachable, process its adjacent nodes
            if (distance[current] != Integer.MAX_VALUE) {
                for (Pair adjNode : adj.get(current)) {
                    int v = adjNode.first;
                    int wt = adjNode.second;
                    if (distance[current] + wt < distance[v]) {
                        distance[v] = distance[current] + wt;
                    }
                }
            }
        }
        
        // Step 5: Mark unreachable nodes with -1
        for (int i = 0; i < V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }
        
        return distance;
    }
    
    // Helper DFS function to perform topological sorting
    private static void dfs(int node, int[] visited, Stack<Integer> st, ArrayList<ArrayList<Pair>> adj) {
        visited[node] = 1;
        for (Pair adjNode : adj.get(node)) {
            if (visited[adjNode.first] == 0) {
                dfs(adjNode.first, visited, st, adj);
            }
        }
        st.push(node);
    }
}
