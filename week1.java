/*
You are given an undirected graph G on the vertex set {0,…,n−1}. 
Compute the distances of all vertices of G from a given starting vertex v using the BFS algorithm.
*/
import java.util.*;
class week1 {
    public static void testCase() {
        int n = In.readInt(); //number of vertices
        int m = In.readInt(); //number of edges
        int v = In.readInt(); //start vertex
        Graph graph = new Graph(n);
        for(int i = 0; i<m; i++) graph.addEdge(In.readInt(),In.readInt(),1);
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        int[] distances = new int[n];
        Arrays.fill(distances,Integer.MAX_VALUE);
        distances[v] = 0;
        while(!q.isEmpty()){
          int in = q.poll();
          for(int i = 0 ; i<graph.graph.get(in).size(); i++){
            if(distances[graph.graph.get(in).get(i)]==Integer.MAX_VALUE){
              distances[graph.graph.get(in).get(i)] = distances[in]+1;
              q.add(graph.graph.get(in).get(i));
            }
          }
        }
        String s = "";
        for(int i : distances){
          s += (i!=Integer.MAX_VALUE ? i : -1) + " ";
        }
        Out.println(s);
    }
}
class Graph {
    public ArrayList<ArrayList<Integer>> graph;  // adjacency list of the graph
    public Graph(int n) {
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());
    }
    public void addEdge(int u, int v, int c) {
            graph.get(u).add(v);
            graph.get(v).add(u);
    }
}
