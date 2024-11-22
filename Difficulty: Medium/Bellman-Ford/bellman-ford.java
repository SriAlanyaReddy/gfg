//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            // ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            int[][] edges = new int[E][3];

            int i = 0;
            for (i = 0; i < E; i++) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                // ArrayList<Integer> t1 = new ArrayList<>();
                // t1.add(u);
                // t1.add(v);
                // t1.add(w);
                // edges.add(t1);
                edges[i][0] = u;
                edges[i][1] = v;
                edges[i][2] = w;
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.bellmanFord(V, edges, S);

            for (i = 0; i < ptr.length; i++) System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*   Function to implement Bellman Ford
 *   edges: 2D array which represents the graph
 *   src: source vertex
 *   V: number of vertices
 */


class Solution {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        // Use 100000000 as a placeholder for infinity
        int inf = 100000000;
        int[] distance = new int[V];
        
        // Initialize distances to all vertices as 'infinity' (100000000)
        Arrays.fill(distance, inf);
        distance[src] = 0;

        // Relax all edges (V-1) times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int start = edge[0];
                int end = edge[1];
                int wt = edge[2];

                // If the start node has been visited and relaxing the edge improves the distance
                if (distance[start] != inf && distance[start] + wt < distance[end]) {
                    distance[end] = distance[start] + wt;
                }
            }
        }

        // Check for negative weight cycles by relaxing once more
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int wt = edge[2];

            // If we can relax an edge again, it means there's a negative weight cycle
            if (distance[start] != inf && distance[start] + wt < distance[end]) {
                return new int[]{-1};  // Return -1 if a negative cycle is detected
            }
        }

        // Return the shortest distances to all vertices
        return distance;
    }
}
