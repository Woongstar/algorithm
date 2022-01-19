import java.io.*;
import java.util.*;
public class Main {

    static char[][] whiteBoard = new char[8][8];
    static char[][] blackBoard = new char[8][8];
    static int count = Integer.MAX_VALUE;
    public static void buildBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i % 2 == 0 || j % 2 == 0) && (i % 2 != 0 || j % 2 != 0)) {
                    whiteBoard[i][j] = 'W';
                } else {
                    whiteBoard[i][j] = 'B';
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i % 2 == 0 || j % 2 == 0) && (i % 2 != 0 || j % 2 != 0)) {
                    blackBoard[i][j] = 'B';
                } else {
                    blackBoard[i][j] = 'W';
                }
            }
        }
    }

    public static void compare(char[][] board, int x, int y){
        int temp = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i + x][j + y] != whiteBoard[i][j]) {
                    temp++;
                }
            }
        }
        count = Math.min(count, temp);

        temp = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i + x][j + y] != blackBoard[i][j]) {
                    temp++;
                }
            }
        }

        count = Math.min(count, temp);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
              board[i][j] = s.charAt(j);
            }
        }
        buildBoard();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i + 8 <= n && j + 8 <= m) {
                    compare(board, i, j);
                }
            }
        }
        System.out.println(count);
    }
}