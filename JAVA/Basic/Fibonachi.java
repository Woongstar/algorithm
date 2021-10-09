import java.io.IOException;

public class Fibonachi {

//    public int DFS(int n){
//        if(n==1) return 1;
//        else if(n==2) return 2;
//        else return DFS(n-2)+DFS(n-1);
//
//    }
//피보나치수열 효율적으로 수정하기 매번마다 해당 값을 계산하기보다 배열에 해당 값을 저장하여 사용함.
//static int[] fibo;
//    public int DFS(int n){
//        if(n==1) return fibo[n]=1;
//        else if(n==2) return fibo[n]=1;
//        else return fibo[n] = DFS(n-2)+DFS(n-1);
//    }

static int[] fibo;
    public int DFS(int n){
        if(fibo[n]>0) return fibo[n];
        if(n==1) return fibo[n]=1;
        else if(n==2) return fibo[n]=1;
        else return fibo[n] = DFS(n-2)+DFS(n-1);
    }


    public static void main(String []args) throws IOException{
        Fibonachi T = new Fibonachi();
        int n = 15;
        fibo = new int[n+1];
        T.DFS(n);
        for(int i=1;i<=n;i++){
            System.out.print(fibo[i] + " ");
        }
    }
}
