import java.io.IOException;

public class Reculsive {

    public void DFS(int n){
        if(n==0) return;
        else{
            System.out.println(n);
            DFS(n-1);
        }

    }

    public static void main(String []args) throws IOException{
        Reculsive T = new Reculsive();
        T.DFS(3);
    }
}

// 재귀함수에서 DFS의 호출 위치에 따라 스택 프레임에 쌓이는 함수의 순서가 바뀐다.
// DFS를 먼저 호출하면 출력함수는 스택프레임에 쌓인다.
// 따라서
//         System.out.println(n);    
//         DFS(n-1); 
//         의 값은 3 2 1

//         DFS(n-1);
//         System.out.println(n);  
//         은 1 2 3 이 된다.