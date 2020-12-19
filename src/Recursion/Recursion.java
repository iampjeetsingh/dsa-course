package Recursion;

public class Recursion {

    public static int fact(int n){
        if(n==0)
            return 1;
        return n * fact(n-1);
    }

    public static int sumn(int n){
        if(n==0)
            return 0;
        return n + sumn(n-1);
    }

    public static int fib(int n){
        if(n==1 || n==2)
            return 1;
        return fib(n-1) + fib(n-2);
    }

    public static boolean isSorted(int[] arr){
        if(arr.length==1)
            return true;
        if(arr[0]>arr[1]){
            return false;
        }
        int[] smallArr = new int[arr.length-1];
        for(int i=0; i< smallArr.length; i++)
            smallArr[i] = arr[i];
        return isSorted(smallArr);
    }

    public static boolean isSortedBetter(int[] arr, int si){
        if(arr.length-1==si)
            return true;
        if(arr[si]>arr[si+1]){
            return false;
        }
        return isSortedBetter(arr, si+1);
    }

    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(sumn(10));
        System.out.println(fib(4));
        System.out.println(isSortedBetter(new int[]{1,2,3,4,5}, 0));
    }
}
