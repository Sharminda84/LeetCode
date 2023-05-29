package linkedlists;

public class DemoQueue {
    int queueSize,currSize;
    DNode front;
    DNode rear;

    public DemoQueue(int capacity){
        this.queueSize = capacity;
        this.currSize = 0;
        this.front = new DNode(-1);
        this.rear = new DNode(-1);
        front.next = rear;
        rear.pre = front;
    }

    public static void main(String[] args) {
        DemoQueue dq = new DemoQueue(5);
        dq.enqueue(100);
        System.out.println("Front"+dq.front() + " back:"+dq.back());
        dq.enqueue(200);
        System.out.println("Front"+dq.front() + " back:"+dq.back());
        dq.enqueue(300);
        System.out.println("Front"+dq.front() + " back:"+dq.back());
        dq.deque();
        System.out.println("Front"+dq.front() + " back:"+dq.back());
        dq.deque();
        System.out.println("Front"+dq.front() + " back:"+dq.back());
        dq.deque();
        System.out.println("Front"+dq.front() + " back:"+dq.back());
    }

    public boolean enqueue(int val){
        if(!isFull()){
            DNode node = new DNode(val);

            rear.pre.next = node;
            node.pre = rear.pre;
            node.next = rear;
            rear.pre = node;

            currSize++;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deque(){
        if(!isEmpty()){
             DNode node = front.next;
             node.next.pre = front;
             front.next = node.next;

             node.next = null;
             node.pre = null;

             currSize--;
             return true;
        } else {
            return false;
        }
    }

    public int front(){
        if(isEmpty()) return -1;
        else {
            return front.next.key;
        }
    }

    public int back(){
        if(isEmpty()) return -1;
        else {
            return rear.pre.key;
        }
    }

    public boolean isEmpty(){
        return currSize == 0;
    }

    public boolean isFull(){
        return currSize == queueSize;
    }

    public class DNode { // double linked list
        int key;
        DNode next,pre;

        public DNode(int key){
            this.key = key;
            this.next = null;
            this.pre = null;
        }
    }
}


