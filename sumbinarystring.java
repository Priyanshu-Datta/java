// package bitmanipulation;
import java.util.*;
class Solution {
    public String addBinary(String a, String b) {
        int n1=1;
        int sum1=0;
        for(int i=a.length()-1;i>=0;i--){
            if(a.charAt(i) != '0'){
                sum1 = sum1 + n1;
            }
            n1 <<= 1;
        }
        int n2=1;
        int sum2=0;
        for(int i=b.length()-1;i>=0;i--){
            if(b.charAt(i) != '0'){
                sum2 = sum2 + n2;
            }
            n2 <<= 1;
        }
        int sum = sum1 + sum2;
        String binary = Integer.toBinaryString(sum);

        return  binary;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first binary string: ");
        String a = scanner.nextLine();

        System.out.print("Enter second binary string: ");
        String b = scanner.nextLine();

        Solution solution = new Solution();
        String result = solution.addBinary(a, b);

        System.out.println("Binary sum: " + result);
        scanner.close();
    }
}