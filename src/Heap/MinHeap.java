package Heap;
public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;
    MinHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }
    //private method for indexting
    private int parent(int i){
        return (i-1)/2;
    }
    private int leftChild(int i){
        return (i*2)+1;
    }
    private int rightChild(int i){
        return (i*2)+2;
    }
    private void swap(int i,int j){
        int temp = heap[i];
         heap[i] = heap[j];
         heap[j] = temp;
         //Have made this method on class Level
    }
    private void ensureCapacity(){
        if(size==capacity){
            capacity = capacity*2;
            int[] newHeap = new int[capacity];
            System.arraycopy(heap,0,newHeap,0,size);
            heap = newHeap;
            System.gc();
        }
    }
    public void insert(int value){
        ensureCapacity();
        heap[size] = value;
        size++;
        heapifyUp();
    }
    private void heapifyUp(){
        int index = size - 1;
        while(index > 0 && heap[parent(index)]>heap[index]){
            swap(parent(index),index);
            index = parent(index);
        }
    }
    public int removeInt(){
        if(size==0){
            throw new IllegalStateException("Heap is Empty");
        }
        int min = heap[0];
        heap[0] = heap[size-1];
        size -- ;
        heapifyDown();
        return min;
    }
    private void heapifyDown(){
        int index = 0;
        while(leftChild(index)<size){
            int smallerChildIndex = leftChild(index);
            if(rightChild(index)< size && heap[rightChild(index)]<heap[smallerChildIndex]){
                smallerChildIndex = (rightChild(index));
            }
            if(heap[index]<=heap[smallerChildIndex]){
                break;
            }
            swap(index,smallerChildIndex);
            index = smallerChildIndex;
        }
    }
    public void printHeap(){
        System.out.println("We are printing the Heap");
        for(int i=0;i<size;i++){
            System.out.println(heap[i]+ " ");
        }
    }
    public static void main(String[] args) {
        //I will write the maxHeap by myself , No need to worry dude, i got it and i will do it exceptionally
        MinHeap minHeap = new MinHeap(10); //Initially i have defined the capacity as 10.
        minHeap.insert(6);
        minHeap.insert(3);
        minHeap.printHeap();
        minHeap.insert(8);
        minHeap.insert(2);
        minHeap.printHeap();
        System.out.println("The removed min heap is"+minHeap.removeInt());;
        minHeap.printHeap();
    }
}