package Recursion;

import java.util.Stack;

class ReverseStack{
    public static void main(String[] args) {
        //There is a stack given and we have reverse the stack by just using the recursion;
        Stack<Integer> st = new Stack<>(); //Took a stack
        //pushish some elements in stack
        for(int i=0;i<5;i++){
            st.push(i); //We are pushing the element in out  stack,
        }
        int size = st.size();
        reverseStack(st);
        //Now we will Print the stack After reversing.
        System.out.println("Printing the stack after reversal.");
        for(int i=0;i<=size;i++){
            if(!st.isEmpty()){
                System.out.println(st.pop());
            }
        }

    }
    static void reverseStack(Stack<Integer> st){
        if(st.isEmpty()){
            return ;
        }
        int a = st.pop();
        reverseStack(st);
        insertAtBottom(st,a);
    }
    static void insertAtBottom(Stack<Integer> st,int val){
        if(st.isEmpty()){
            st.push(val);
            return ;
        }
        int temp = st.pop();
        insertAtBottom(st,val);
        st.push(temp);
    }
}

//This is the correct code of Reversint the stack using