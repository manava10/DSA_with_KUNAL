class LL {
    private Node head;
    private Node tail;
    private int size;
    public LL(){
        this.size=0;
    }
    private class Node{

        private int value;
        private Node next;

        public Node(int value){
            this.value=value;
        }
    } 
    public void InsertData(int data){
        if(head==null){
            head = new Node(data);
            size++;
        }else{



        }
    } 
}
public class Main{
    public static void main(String[] args) {
        LL list = new LL();
    }
    
}