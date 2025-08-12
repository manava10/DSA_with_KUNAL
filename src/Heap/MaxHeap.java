package Heap;
public class MaxHeap{
    int[] Heap;
    int capacity;
    int size;
    MaxHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.Heap = new int[capacity];
        //So, we have initialized the Primitive DATA
    }
    private int parent(int index){
        return (index-1)/2;
    }
    private int leftChild(int index){
        return (index*2)+1;
    }
    private int rightChild(int index){
        return (index*2)+2;
    }
    private void swap(int i,int j){
        int temp = Heap[i];
        Heap[i] = Heap[j];
        Heap[j] = temp; //So, the swapping of the variable has been done.
    }
    private void ensureCapacity(){
        capacity = capacity*2;
        int[] newHeap = new int[capacity];
        for(int i=0;i<size;i++){
            newHeap[i] = Heap[i];
        }
        Heap = newHeap;
    }
    public void insert(int i){
        ensureCapacity(); //First of all we are
        Heap[size] = i;
        size++;
        heapifyUp(); //So, after inserting we have to heapify it also,
    }
    private void heapifyUp(){
        int index = size-1;
        while(index>0 && Heap[parent(index)]<Heap[index]){
            //we have to swapThem ;
            swap(parent(index),index);
            index = parent(index); // And now the new index has been changed to index of parent ;
        }
    }
    private void peek(){
        System.out.println("The element you are peeking is "+ Heap[0]); //We are just letting them peak ,and nothing else.
    }
    public int removeMax(){
        if(size==0){
            throw new IllegalStateException("The given Heap is Empty");
        }
        int max = Heap[0];
        Heap[0] = Heap[size-1];
        size--;
        HeapifyDown();
        return max;
    }
    private void HeapifyDown(){
        int index = 0;
        while(leftChild(index)<size){
            int biggestChildIndex = leftChild(index);
            if(rightChild(index)<size && Heap[biggestChildIndex]<Heap[rightChild(index)]){
                biggestChildIndex = rightChild(index);
            }
            if(Heap[index]>Heap[biggestChildIndex]){
                break;
            }
            swap(index,biggestChildIndex);
            index = biggestChildIndex;
        }
    }
    public void printHeap(){
        System.out.println("We are printing the Heap");
        for(int i=0;i<size;i++){
            System.out.println(Heap[i]+" ");
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(4);
        maxHeap.insert(11);
        maxHeap.printHeap();
        maxHeap.insert(12);
        maxHeap.printHeap();
        maxHeap.insert(13);
        maxHeap.printHeap();
        maxHeap.peek();
        maxHeap.printHeap();
    }

}