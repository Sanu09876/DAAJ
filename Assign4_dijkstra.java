import java.util.Scanner;

public class Assign4 {
    int v;
    int[][] graph;

    public Assign4(int n) {

        this.v = n;
        this.graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = -1;
            }
        }
    }

    public void initializeGraph() {
        System.out.println("Before: ");
        print();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of edges: ");
        int edgeCount = sc.nextInt();
        System.out.println(
                "Enter the edges in the format 'u v w' where u is the source vertex, v is the destination vertex and w is the weight: ");
        for (int i = 0; i < edgeCount; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();
            graph[source][destination] = weight;
            graph[destination][source] = weight;
        }
        System.out.println("After: ");
        print();
    }

    private void printSolution(int[] dist) {
        System.out.println("Vertex:\t\tdistance from source:");
        for (int i = 0; i < v; i++) {
            System.out.println(i + "      \t\t     " + dist[i]);
        }
    }

    public int minDist(boolean[] visited, int[] dist) {
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] <= min) {
                min = dist[i];

                minIndex = i;
            }
        }
        // System.out.println(min+" "+minIndex);
        return minIndex;
    }

    public void dijkstra(int src) {
        boolean[] visited = new boolean[v];
        int[] dist = new int[v];

        for (int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        for (int i = 0; i < v - 1; i++) {
            int u = minDist(visited, dist);
            visited[u] = true;
            for (int j = 0; j < v; j++) {
                // System.out.println(u+" "+j);
                if (!visited[j] && graph[u][j] != -1
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][j] < dist[j]) {
                    dist[j] = graph[u][j] + dist[u];
                }
            }
        }
        printSolution(dist);
    }

    public void print() {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(graph[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();
        Assign4 a1 = new Assign4(n);
        a1.initializeGraph();
        System.out.print("Enter the source vertex: ");
        int src = sc.nextInt();
        a1.dijkstra(src);
    }
}
