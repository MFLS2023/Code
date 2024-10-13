package class013_QueueStackAndCircularQueue;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    //链表实现队列
    public static class Queue1 {
        public Queue<Integer> queue = new LinkedList<>();

        //调用此方法前判断队列内是否有东西
        public boolean isEmpty() {
            return queue.isEmpty();
        }

        //向队列中添加元素val，加到尾巴上
        public void offer(int val){
            queue.offer(val);
        }

        //弹出一个元素
        public int poll(){
            return queue.poll();
        }

        //返回队列头部元素但不弹出
        public int peak(){
            return queue.peek();
        }

        //返回队列元素个数
        public int size(){
            return queue.size();
        }
    }

    //实际刷题用数组
    public static class Queue2{
        public int[]queue;
        public int l;
        public int r;

        //加入操作的总次数上限是多少
        public Queue2(int max){
            queue = new int[max];
            l=r=0;
        }

        //调用任何方法前，判断内部是否为空
        public boolean isEmpty(){
            return l==r;
        }

        public void offer(int val){
            queue[r++]=val;
        }

        public int pop(){
            return queue[l++];
        }

        public int head(){
            return queue[l];
        }

        public int tail(){
            return queue[r-1];
        }

        public int size(){
            return r-1;
        }
    }

    //链表实现栈
    public static class Stack1{
        public Stack<Integer>stack=new Stack<>();

        public boolean isEmpty(){
            return stack.isEmpty();
        }

        public void push(int val){
            stack.push(val);
        }

        public int pop(){
            return stack.pop();
        }

        public int peak(){
            return stack.peek();
        }

        public int size(){
            return stack.size();
        }
    }

    //数组实现栈
    public static class Stack2{
        public int[]stack;
        public int size;
        public Stack2(int max){
            stack=new int[max];
            size=0;
        }

        public boolean isEmpty(){
            return size==0;
        }

        public void push(int val){
            stack[size++]=val;
        }
        public int pop(){
            return stack[--size];
        }
        public int peak(){
            return stack[size-1];
        }
        public int size(){
            return size;
        }
    }

/*


    //设计循环队列
    class MyCircularQueue {
        public int[] queue;
        public int l,r,size,limit;

        public MyCircularQueue(int k) {
            queue=new int[k];
            l=r=size=0;
            limit=k;
        }

        public boolean enQueue(int value) {
            if(isFull()){
                return false;
            }else{
                queue[r]=value;
                r= r==limit-1?0:r+1;
                size++;
                return true;
            }
        }

        public boolean deQueue() {
            if(isEmpty()){
                return false;
            }else{
                l= l==limit-1?0:l+1;
                size--;
                return true;
            }
        }

        public int Front() {
            if(isEmpty()){
                return -1;
            }else{
                return queue[l];
            }
        }

        public int Rear() {
            if(isEmpty()){
                return -1;
            }else{
                int last = r==0?limit-1:r-1;
                return queue[last];

            }
        }

        public boolean isEmpty() {
            return size==0;
        }

        public boolean isFull() {
            return size==limit;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */


}
