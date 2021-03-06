import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Point> arr = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            st= new StringTokenizer(br.readLine());
            arr.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        arr.stream().sorted(Comparator.comparing(Point::getX)).sorted(Comparator.comparing(Point::getY)).forEach(point -> System.out.println(point.x+" "+ point.y));
}}
class Point{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}