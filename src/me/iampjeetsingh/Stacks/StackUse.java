package me.iampjeetsingh.Stacks;

public class StackUse {
    public static void main(String[] args) {
//        StackUsingArray stack = new StackUsingArray();
        StackUsingLL<Integer> stack = new StackUsingLL<>();
        try {
            stack.push(5);
            System.out.println(stack.top());
            System.out.println(stack.size());
            stack.pop();
            System.out.println(stack.isEmpty());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
