package Queues;

public class QueueUse {
    public static void main(String[] args) {
//        QueueUsingArray queue = new QueueUsingArray();
//        QueueUsingLL<Integer> queue = new QueueUsingLL<>();
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();
        int[] arr = {10,20,30,40, 50, 60, 70};
        try {
            for(int i : arr){
                queue.enqueue(i);
            }
            while (!queue.isEmpty()){
                System.out.println(queue.dequeue());
            }
        }catch (Exception e){

        }

    }
}
