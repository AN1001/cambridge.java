package LinkedList2Package;

public class LinkedList2 {
    private LinkedListEl head;
    private int val;

    //Create a LL with one element in it
    public LinkedList2(int val) {
        this.val = val;
    }

    //Create an empty list
    public LinkedList2() {}
}

private class LinkedListEl {
    private int val;
    private LinkedListEl next;

    public LinkedListEl(int val, LinkedListEl next){
        this.val = val;
        this.next = next;
    }
}