package bitmanipulation;

import java.util.Scanner;

public class SetBit {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the number:");
        int n = sc.nextInt();
        System.out.println("enter the position you make one:");
        int pos =sc.nextInt();

        int bitMask = 1<<pos;

        int n2 = bitMask | n;
        System.out.println("the new number:" + n2);
        sc.close();
     }
}
