package me.iampjeetsingh.OOPS_1;

import java.util.Scanner;

public class ComplexNumberProblem {
    public static class ComplexNumbers {
        private int real, imaginary;

        public ComplexNumbers(int real, int imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        public void plus(ComplexNumbers other){
            this.real = this.real + other.real;
            this.imaginary = this.imaginary + other.imaginary;
        }

        public void multiply(ComplexNumbers other){
            int r = this.real, i = this.imaginary;
            this.real = r*other.real - i*other.imaginary;
            this.imaginary = r*other.imaginary + i*other.real;
        }

        public void print(){
            int im = imaginary<0 ? -1*imaginary : imaginary;
            char sign = imaginary<0 ? '-' : '+';
            System.out.println(this.real+" "+sign+" i"+im);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int real1 = s.nextInt();
        int imaginary1 = s.nextInt();

        int real2 = s.nextInt();
        int imaginary2 = s.nextInt();

        ComplexNumbers c1 = new ComplexNumbers(real1, imaginary1);
        ComplexNumbers c2 = new ComplexNumbers(real2, imaginary2);

        int choice = s.nextInt();


        if(choice == 1) {
            // Add
            c1.plus(c2);
            c1.print();
        }
        else if(choice == 2) {
            // Multiply
            c1.multiply(c2);
            c1.print();
        }
        else {
            return;
        }
    }
}
