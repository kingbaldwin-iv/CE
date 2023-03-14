/*
You decided to organise a dinner party at your home. Since you are an outgoing person your friend pool is very large, 
but unfortunately not all of your friends are acquainted with each other. In order for the evening to be successful and entertaining for everybody you make the following plan. 
For each guest, you write down the list of people she is a friend with. You know that the friendships are a symmetric relation, i.e. that if a person 
a is a friend of a person b then the person b is a friend of the person a.
Your plan is simple: you want to place each guest on one of the two sides of your table and furthermore, 
you want to place all her friends on the other side of the table, exactly across, so that the conversations are flowing smoothly. 
You are sure that your table is large enough, but from a first glance at your friendship lists you cannot deduce whether such a placement is possible.
Luckily, you are a fairly good programmer and decide to rely on your programming skills to check if your plan for the evening can happen. 
Moreover, if your seating plan can work out, you want to know who will be seated on the same side of the table as your best friend.
*/
import java.util.*;
class week3 {
    public static void testCase() {
        int nVertex = In.readInt();
        int nEdges = In.readInt();
        int start = In.readInt();
        Graph g = new Graph(nVertex);
        for(int i =0;i<nEdges;i++) g.addEdge(In.readInt(),In.readInt());
        int[] length = new int[nVertex];
        Queue<Integer> q = new LinkedList<Integer>();
        Arrays.fill(length,-1);
        length[start]=0;
        q.add(start);
        short c = 1;
        while(!q.isEmpty()){
          int in = q.poll();
          for(int i : g.graph.get(in)){
            if(length[i]==-1) {length[i]=length[in]+1;
            q.add(i);c++;}
            else if((length[in]+1-length[i])%2==1) {Out.println("no"); return;}
          }
        }
        if(c!=nVertex) {Out.println("no"); return;}
        for(int i = 0; i<length.length ; i++){
          if(length[i]%2==0) Out.print(i+" ");
        }
        Out.println();
    }
    static class Graph {
      public ArrayList<ArrayList<Integer>> graph;  // adjacency list of the graph
      public Graph(int n) {
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());
      }
      public void addEdge(int u, int v) {
            graph.get(u).add(v);
            graph.get(v).add(u);
      }
    }
}
