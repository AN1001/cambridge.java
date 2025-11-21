package LinkedList2Package;

public class LinkedList2 {
    private LinkedListEl head = null;

    //Create an empty list
    public LinkedList2() {}

    //Add to end of LL
    public void addEl(int val){
        if (this.head == null){
            //Is first element
            this.head = new LinkedListEl(val);
        } else {
            LinkedListEl curHead = this.head;
            while (curHead.hasNext) {
                curHead = curHead.getNext();
            }
            curHead.setNext(new LinkedListEl(val));
        }
    }

    //Remove last el in LL
    public void removeEl(){
        if(this.head == null) {
            throw new RuntimeException("No elements in LinkedList2 to remove");
        } else if(!this.head.hasNext) {
            this.head = null;
        } else {
            LinkedListEl penultimate = this.head;
            while (penultimate.getNext().hasNext) {
                penultimate = penultimate.getNext();
            }
            penultimate.removeNext();
        }
    }

    //Querying the head
    public int getHead(){
        return this.head.getVal();
    }

    //Get nth element
    public int getN(int n){
        return getNElement(n).getVal();
    }

    //Compute length
    public int length(){
        int cur_length = 0;
        if(this.head != null){
            LinkedListEl curEl = this.head;
            cur_length++;
            while(curEl.hasNext){
                curEl = curEl.getNext();
                cur_length++;
            }
        }
        return cur_length;
    }

    private LinkedListEl getNElement(int n){
        LinkedListEl curHead = this.head;
        while(n > 0){
            n--;
            if(curHead.hasNext) {
                curHead = curHead.getNext();
            } else {
                throw new RuntimeException("LinkedList2 index out of range");
            }
        }
        return curHead;
    }

}
class LinkedListEl {
    private int val;
    private LinkedListEl next = null;
    public boolean hasNext = false;

    public int getVal(){
        return this.val;
    }

    public void setVal(int newVal){
        this.val = newVal;
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