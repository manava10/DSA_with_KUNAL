import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    Node root;
    BinaryTree(){
        root = null;
    }
    public void insert(int data){
        root = insertRec(root,data);
    }
    private Node insertRec(Node root,int data){
        if(root==null){
            root = new Node(data);
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        //To insert in a level order , We have to use queue, Without that we cannot.
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.left==null){
                temp.left = new Node(data);
                break;
            }else{
                queue.add(temp.left);
            }
            if(temp.right==null){
                temp.right=new Node(data);
                break;
            }else{
                queue.add(temp.right);
            }
        }
        return root;
    }
    public void printLevelOrder(){
        System.out.println("The level order traversal of the given tree is  ");
        printLevel(root);
        System.out.println();
    }
    private void printLevel(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data+" "); // This is the data of each tree Node
            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }
    }
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        bt.insert(0);
        bt.insert(2);
        bt.insert(12);
        bt.printLevelOrder();
    }
}
