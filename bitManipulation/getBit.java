package java.bitManipulation;

import java.util.*;
public class getBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the number:");
        int n = sc.nextInt();
        System.out.println("enter the position you want to get:");
        int pos =sc.nextInt();

        int bitMask = 1<<pos;

        if((bitMask & n) == 0){
            System.out.println("the Bit is Zero.");
        }else{
            System.out.println("the Bit is One.");
        }
        sc.close();
    }
}