package LinkedList2Package;

public class LinkedListEl {
    private final int val;
    private LinkedListEl next = null;
    public boolean hasNext = false;

    public int getVal(){
        return this.val;
    }

    public LinkedListEl getNext(){
        return next;
    }

    public void removeNext(){
        this.hasNext = false;
        next = null;
    }

    public void setNext(LinkedListEl newNext){
        this.next = newNext;
        this.hasNext = true;
    }

    public LinkedListEl(int val){
        this.val = val;
    }
}