package Stack2Package;

public class StackTest {
    void main(){
        Stack testStack = new Stack();
        testStack.push(1);testStack.push(2);testStack.push(3);
        System.out.println(testStack.getHead());
        testStack.pop();
        System.out.println(testStack.getHead());
    }
}
