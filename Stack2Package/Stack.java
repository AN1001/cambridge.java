package Stack2Package;
import LinkedList2Package.LinkedListEl;

public class Stack {
    private LinkedListEl head = null;

    //Querying the head
    public int getHead(){
        if(!isEmpty()) {
            return this.head.getVal();
        } else {throw new RuntimeException("Stack Empty");}
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void push(int val){
        if(this.head!=null) {
            LinkedListEl remainingStack = this.head;
            this.head = new LinkedListEl(val);
            this.head.setNext(remainingStack);
        } else {
            this.head = new LinkedListEl(val);
        }
    }

    public void pop(){
        if(this.head!=null && this.head.hasNext){
            this.head = this.head.getNext();
        } else {
            this.head = null;
        }
    }
}
