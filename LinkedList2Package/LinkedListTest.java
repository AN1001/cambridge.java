package LinkedList2Package;

class LinkedListTest {
    static void main(){
        LinkedList2 xs = new LinkedList2();
        xs.addEl(1);xs.addEl(2);xs.addEl(3);
        System.out.println(xs.length());
        System.out.println(xs.getN(0));
        xs.removeEl();
        System.out.println(xs.getHead());
    }
}