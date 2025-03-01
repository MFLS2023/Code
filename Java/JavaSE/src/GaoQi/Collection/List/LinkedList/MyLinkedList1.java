package GaoQi.Collection.List.LinkedList;

public class MyLinkedList1 {

    private Node head;
    private Node tail;

    private int size;

    public void add(Object e) {
        Node node=new Node(null,null,e);
        if(head==null){
            head=node;
            tail=head;
        }else{
            node.prev=tail;
            node.next=null;
            tail.next=node;
            tail=node;
        }
        size++;
    }

    public boolean remove(int index){
        if(index<0||index>=size){
            throw new ArrayIndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
        Node temp=getNode(index);
        if(temp!=null){
            Node up=temp.prev;
            Node down=temp.next;

            if(up!=null){
                up.next=down;

            }if(down!=null){
                down.prev=up;
            }
            if(index==0){
                head=down;
            }
            if(index==size-1){
                tail=up;
            }
            size--;
        }

        return true;
    }

    public boolean insert(int index, Object e) {
        if (index < 0 || index > size) {  // 注意这里 index == size 是允许的（表示插入到尾部）
            throw new ArrayIndexOutOfBoundsException("Index:" + index + ",Size:" + size);
        }

        Node newNode = new Node(null, null, e);
        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (size == 0) {
                tail = newNode;
            }
        } else if (index == size) {
            newNode.prev = tail;
            if (tail != null) {
                tail.next = newNode;
            }
            tail = newNode;
        } else {
            Node temp = getNode(index);
            newNode.next = temp;
            newNode.prev = temp.prev;
            if (temp.prev != null) {
                temp.prev.next = newNode;
            }
            temp.prev = newNode;
        }

        size++; // 更新链表长度
        return true;
    }


    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index:" + index + ",Size:" + size);
        }
        Node temp=getNode(index);
        return temp!=null?temp.data:null;
    }

    private Node getNode(int index) {
        Node temp = head;
        if (index <= size >> 1) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }


    public String toString(){
        StringBuilder sb=new StringBuilder("[");
        Node temp=head;
        while(temp!=null){
            sb.append(temp.data+",");
            temp=temp.next;
        }

        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList1 list=new MyLinkedList1();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        System.out.println(list.get(0));
        list.insert(0,"d");
        System.out.println(list);

        list.remove(2);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);


    }


}
