
import java.util.*;

public class bfs_dfs {

    public static void bfs(ArrayList<ArrayList<Integer>> ug, Queue<Integer> q, boolean[] vis) {
        if (q.isEmpty()) {
            return;
        }
        int curr = q.poll();
        System.out.println(curr);

        for (int i = 0; i < ug.get(curr).size(); i++) {
            if (!vis[ug.get(curr).get(i)]) {
                vis[ug.get(curr).get(i)] = true;
                q.add(ug.get(curr).get(i));
            }
        }

        bfs(ug, q, vis);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> ug, int node, boolean[] vis){
        System.out.println(node);
        vis[node] = true;

        for(int i = 0; i< ug.get(node).size(); i++){
            if(!vis[ug.get(node).get(i)])
            dfs(ug, ug.get(node).get(i), vis);
        }
    }

    public static void main(String arg[]) {
        int n = 5;
        ArrayList<ArrayList<Integer>> Ug = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Ug.add(new ArrayList<>());
        }

        Ug.get(0).add(1);
        Ug.get(1).add(0);

        Ug.get(0).add(2);
        Ug.get(2).add(0);

        Ug.get(1).add(3);
        Ug.get(3).add(1);

        Ug.get(1).add(4);
        Ug.get(4).add(1);

        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        vis[0] = true;
        q.add(0);

        // bfs(Ug, q, vis);
        dfs(Ug, 0, vis);
    }
}
