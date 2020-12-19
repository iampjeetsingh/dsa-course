package Recursion;

public class Recursion2 {

    public static String replaceChar(String s, char a, char b){
        if(s.length()==0)
            return s;
        if(s.charAt(0)==a)
            return b + replaceChar(s.substring(1), a, b);
        return s.charAt(0) + replaceChar(s.substring(1), a, b);
    }

    public static String replacePi(String s){
        if(s.length()<=1)
            return s;
        if(s.charAt(0)=='p' && s.charAt(1)=='i'){
            return "3.14"+replacePi(s.substring(2));
        }
        return s.charAt(0)+replacePi(s.substring(1));
    }

    public static int binarySearch(int[] arr, int si, int ei, int x){
        if(si>ei){
            return -1;
        }
        int middle = (si+ei)/2;
        if(arr[middle]==x)
            return middle;
        else if(arr[middle]<x)
            return binarySearch(arr, middle+1, ei, x);
        return binarySearch(arr, si, middle-1, x);
    }

    public static void main(String[] args) {
        System.out.println(replaceChar("Hello there!",'e','a'));
        System.out.println(replacePi("4 * pi * r"));
        System.out.println(binarySearch(new int[]{1,2,3,4,5}, 0, 4, 2));
    }
}
