package LinkedList2Package;

class LinkedListTest {
    static void main(){
        LinkedList2 xs = new LinkedList2();
        xs.addEl(new LinkedListEl(1));xs.addEl(new LinkedListEl(2));xs.addEl(new LinkedListEl(3));
        System.out.println(xs.length());
        System.out.println(xs.getN(0).getVal());
        xs.removeEl();
        System.out.println(xs.getHead().getVal());
    }
}