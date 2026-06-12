import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Edge {
    int dest;
    int weight;

    Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph {
    int vertices;
    ArrayList<List<Edge>> adj;

    Graph(int vertices) {
        this.vertices = vertices;
        adj = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            //adj.set(i,(new ArrayList<>())); //accessing the innerlist->indicating each vertex's adjacency list
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int s, int d, int w, boolean directed) { //source, dest, weight
        adj.get(s).add(new Edge(d, w));
        if (!directed) {
            adj.get(d).add(new Edge(s, w));
        }
    }

    public void bfs(int source) {
        boolean[] visited=new boolean[vertices];
        Queue<Integer> que = new LinkedList<>();

        visited[source] = true;
        que.offer(source);

        while (!que.isEmpty()) {
            int cur = que.poll();
            System.out.print((char)(cur+'A') + " ");
            
            for (Edge edge : adj.get(cur)) {
                int destin = edge.dest;
                if (!visited[destin]) {
                    visited[destin] = true;
                    que.offer(destin);
                }
            }
        }


    }

    public void display() {
        for (int i = 0; i < vertices; i++) {
            //char ch = (char) (i+65);
            System.out.print((char)(i+'A') + " ");
            List<Edge> cur = adj.get(i);
            for (Edge edge : cur) {
                System.out.print((char) (edge.dest + 65) + "-->");
            }
            
            System.out.println();
        }
    }
}

public class GraphImplementation {
    public static void main(String[] args) {
        Graph g = new Graph(5);

        //for unweighted graphs give the weight for all as 1

        g.addEdge(0, 1, 7, false);
        g.addEdge(0, 4, 1, false);
        g.addEdge(1, 2, 3, false);
        g.addEdge(1, 4, 8, false);
        g.addEdge(2, 3, 6, false);
        g.addEdge(2, 4, 2, false);
        g.addEdge(4, 3, 7, false);

        g.display();
        g.bfs(0);
    
    }
}
