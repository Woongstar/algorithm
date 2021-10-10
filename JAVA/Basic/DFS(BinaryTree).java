import java.io.IOException;

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data = val;
        lt=rt=null;
    }}

public class Main{

    public void DFS(Node root){
        if(root==null) return;
        else{
            DFS(root.lt);
            System.out.print(root.data + " "); /* 이 위치에 따라 전위 중위 후위 결정*/
            DFS(root.rt);
        }
    }

    Node root;
    public static void main(String []args) throws IOException{
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }
}
