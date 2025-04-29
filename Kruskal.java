
import java.util.*;

public class Kruskal {

    static class node {

        int s;
        int d;
        int w;

        node(int s, int d, int w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }

    static int[] parent;
    static int[] rank;

    public static int find(int num) {
        if (parent[num] == num) {
            return num;
        }

        return parent[num] = find(parent[num]);
    }

    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py) {
            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[px] < rank[py]) {
                parent[px] = py;
            } else {
                parent[px] = py;
                rank[px]++;
            }
        }
    }

    public static int MST(ArrayList<node> edges, int v) {
        Collections.sort(edges, (a, b) -> a.w - b.w);
        parent = new int[v];
        rank = new int[v];

        for (int i = 0; i < v; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int cost = 0;
        int edge = 0;

        for (int i = 0; i < edges.size(); i++) {
            if (edge == (v - 1)) {
                return cost;
            }
            if (find(edges.get(i).s) != find(edges.get(i).d)) {
                union(edges.get(i).s, edges.get(i).d);
                cost += edges.get(i).w;
                edge++;
            }
        }
        return cost;
    }

    public static void main(String arg[]) {
        int v = 5;
        ArrayList<node> edges = new ArrayList<>();

        edges.add(new node(0, 1, 1));
        edges.add(new node(0, 4, 5));
        edges.add(new node(1, 0, 1));
        edges.add(new node(1, 4, 6));
        edges.add(new node(1, 2, 2));
        edges.add(new node(2, 1, 2));
        edges.add(new node(2, 4, 4));
        edges.add(new node(2, 3, 7));
        edges.add(new node(3, 4, 8));
        edges.add(new node(3, 2, 7));
        edges.add(new node(4, 0, 5));
        edges.add(new node(4, 1, 6));
        edges.add(new node(4, 2, 4));
        edges.add(new node(4, 3, 8));

        System.out.println(MST(edges, v));

    }
}
