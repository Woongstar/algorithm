package wonderLand;//7. 원더랜드(최소스패닝트리)
//        설명
//
//        원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.
//
//        원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.
//
//        아래의 그림은 그 한 예를 설명하는 그림이다.
//
//        위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시를 연결하는 방법을 찾아낸 것이다.
//
//
//        입력
//        첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.
//
//        다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
//
//        이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.
//
//
//        출력
//        모든 도시를 연결하면서 드는 최소비용을 출려한다.
//
//
//        예시 입력 1
//
//        9 12
//        1 2 12
//        1 9 25
//        2 3 10
//        2 8 17
//        2 9 8
//        3 4 18
//        3 7 55
//        4 5 44
//        5 6 60
//        5 7 38
//        7 8 35
//        8 9 15
//        예시 출력 1
//
//        196

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int v1, v2, cost;
    Edge(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob){
        return this.cost - ob.cost;
    }
}

public class WonderLandCruscal{
    static int[] group;

    public static int Find(int v){
        if(v==group[v]) return v;
        else return group[v]=Find(group[v]);
    }

    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);

        if(fa!=fb) group[fa] = fb;
    }

    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        group = new int[n+1];
        for(int i=1;i<=n;i++) group[i]=i;
        ArrayList<Edge> arr = new ArrayList<>();

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr.add(new Edge(a,b,c));
        }

        Collections.sort(arr);

        int answer = 0;
        int cnt=0;
        for(Edge ob: arr){
            if(cnt==n-1) break;
            int fv1=Find(ob.v1);
            int fv2=Find(ob.v2);

            if(fv1!=fv2){
                answer +=ob.cost;
                Union(ob.v1,ob.v2);
                cnt++;
            }
        }

        System.out.println(answer);
    }
}