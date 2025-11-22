package LinkedList2Package;

public class LinkedList2 {
    private LinkedListEl head = null;

    //Create an empty list
    public LinkedList2() {}

    //Add to end of LL
    public void addEl(LinkedListEl el){
        if (this.head == null){
            //Is first element
            this.head = el;
        } else {
            LinkedListEl curHead = this.head;
            while (curHead.hasNext) {
                curHead = curHead.getNext();
            }
            curHead.setNext(el);
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
    public LinkedListEl getHead(){
        return this.head;
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

    //Get N element
    public LinkedListEl getN(int n){
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

    public boolean hasLoop(){
        //Edge cases - no elements hence no loop or one element which means no loop
        if(this.head == null || !this.head.hasNext){return false;}

        LinkedListEl fast = this.head.getNext();
        LinkedListEl slow = this.head;
        while(fast.hasNext && fast.getNext().hasNext){
            if(fast == slow){return true;}
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return false;

    }

}