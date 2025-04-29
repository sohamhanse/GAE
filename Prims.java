import java.util.*;
public class Prims{
    static class node{
        int s;
        int d;
        int w;

        node(int s, int d, int w){
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int node;
        int cost;

        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }

    }

    public static int MST(ArrayList<node> g[]){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean v[] = new boolean[g.length];
        pq.add(new Pair(0,0 ));
        int cost = 0;

        while(!pq.isEmpty()){
            Pair temp = pq.remove();
            if(!v[temp.node]){
                v[temp.node] = true;
                cost += temp.cost;

                for(int i = 0 ; i< g[temp.node].size(); i++){
                    pq.add(new Pair(g[temp.node].get(i).d, g[temp.node].get(i).w)); // Adding close nodes
                }
            }

        }
        return cost;

    }
    public static void main(String Arg []){
        ArrayList<node> graph []= new ArrayList[5];

        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<node>();
        }

        graph[0].add(new node(0, 1, 10));
        graph[0].add(new node(0, 2, 15));
        graph[0].add(new node(0, 3, 30));

        graph[1].add(new node(1, 0, 10));
        graph[1].add(new node(1, 3, 40));

        graph[2].add(new node(2, 0, 15));
        graph[2].add(new node(2, 3, 50));

        graph[3].add(new node(3, 1, 40));
        graph[3].add(new node(3, 2, 50));

        int cost = MST(graph);
        System.out.println(cost);
    }    
}