import java.util.*;

public class Assign3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        int[][] distanceMarix = new int[vertices + 1][vertices + 1];
        for (int i = 1; i <= vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                distanceMarix[i][j] = -1;
            }
        }
        System.out.print("Enter the number of edges: ");
        int edgeCount = sc.nextInt();
        System.out.println(
                "Enter the edges in the format 'u v w' where u is the source vertex, v is the destination vertex and w is the weight: ");
        for (int i = 0; i < edgeCount; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();
            distanceMarix[source][destination] = weight;
        }

        for (int i = 1; i <= vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                if (distanceMarix[i][j] == -1) {
                    distanceMarix[i][j] = (int) 1e9;
                }
                if (i == j)
                    distanceMarix[i][j] = 0;
            }
        }

        for (int k = 1; k <= vertices; k++) {
            for (int i = 1; i <= vertices; i++) {
                for (int j = 1; j <= vertices; j++) {
                    distanceMarix[i][j] = Math.min(distanceMarix[i][j],
                            distanceMarix[i][k] + distanceMarix[k][j]);
                }
            }
        }

        for (int i = 1; i <= vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                if (distanceMarix[i][j] == (int) 1e9)
                    distanceMarix[i][j] = -1;
            }
        }

        System.out.println("The shortest distances between the vertices is: ");
        for (int i = 1; i <= vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                if (distanceMarix[i][j] == -1)
                    continue;
                System.out.print("Shortest distance between " + i + " and " + j + " is: " + distanceMarix[i][j]);
                System.out.println();
            }
        }

        for (int i = 1; i <= vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
               
                System.out.print(distanceMarix[i][j]+" ");
                
            }
            System.out.println();
        }
    }
}
