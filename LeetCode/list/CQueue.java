import java.util.Stack;

/**
 * @ Author:dlh
 * @ Date:2020/4/28--->15:32
 * @ Description:
 */
public class CQueue {
    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        while (!stack2.isEmpty()){
            return stack2.pop();
        }
        while (!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        if(stack2.isEmpty()){
            return -1;
        }else {
            return stack2.pop();
        }
    }

}
