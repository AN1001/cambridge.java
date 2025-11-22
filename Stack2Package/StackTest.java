package Stack2Package;

public class StackTest {
    void main(){
        Stack2 testStack = new Stack2();
        testStack.push(1);testStack.push(2);testStack.push(3);
        System.out.println(testStack.getHead());
        testStack.pop();
        System.out.println(testStack.getHead());
    }
}
