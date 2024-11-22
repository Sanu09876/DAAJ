import java.util.*;
public class KKnight {
    static int N;
    
    static boolean isSafe(int x, int y, int[][] sol) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }
    
    static void print(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean solveKT(int x,int y) {
        int sol[][] = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = -1;
            }
        }
        
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        
        sol[x][y] = 0;
        
        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("No solution");
            return false;
        } else {
            print(sol); 
        }
        
        return true;
    }
    
    static boolean solveKTUtil(int x, int y, int movei, int sol[][], int xMove[], int yMove[]) {
        if (movei == N * N) return true;
        
        for (int k = 0; k < 8; k++) {
            int next_x = x + xMove[k];
            int next_y = y + yMove[k];
            
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;  
                
                if (solveKTUtil(next_x, next_y, movei + 1, sol, xMove, yMove)) {
                    return true;
                } else {
                    sol[next_x][next_y] = -1;  
                }
            }
        }
        
        return false;  
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of chessboard");
        N = sc.nextInt();

        System.out.println("Enter the start point x");
        int x = sc.nextInt();

        System.out.println("Enter the start point y");
        int y = sc.nextInt();
        solveKT(x,y); 
        sc.close();
    }
}