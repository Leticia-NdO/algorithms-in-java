import java.util.*;

//  Explanation:
//    The Karatsuba multiplication algorithm is a fast multiplication algorithm that
//  uses a divide-and-conquer approach to multiply two numbers. The basic idea behind
//  the algorithm is to split the input numbers into smaller numbers, perform some 
//  intermediate calculations, and then combine the results to obtain the final product.

public class KaratsubaMultiplication {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Hello, this is an exemple of the Karatsuba multiplication algorithm. Please, enter two numbers: \n");
        System.out.print("First number: ");
        long x = sc.nextInt();  
        System.out.print("Second number: ");  
        long y = sc.nextInt();  
        long result = karatsuba(x, y);
        System.out.println(result);
    }

/*********************** Algorithm   ***********************/
    public static long karatsuba(long x, long y) {
    // Base case: if either x or y is less than 10, multiply and return
    if (x < 10 || y < 10) {
        return x * y;
    } else {
        // Find the length of the larger input number
        int n = Math.max(Long.toString(x).length(), Long.toString(y).length()); // The size of the largest number (in terms of digits)
        // Split the input numbers into two smaller numbers of equal length
        int mid = (int) Math.floor(n / 2);  // Half of the digits of the largest number
        long power = (long) Math.pow(10, mid); // 10**n/2
        long a = x / power; // First half of the first number
        long b = x % power; // Second half of the first number
        long c = y / power; // First half of the second number
        long d = y % power; // Second half of the second number
        // Recursively compute ac, bd, and acbd
        long ac = karatsuba(a, c);
        long bd = karatsuba(b, d);
        long acbd = karatsuba(a + b, c + d) - ac - bd;
        // Compute the result using the Karatsuba formula, which is: ac * 10**n + 10**n/2 * acbd + bd
        return ac * (long) Math.pow(10, 2 * mid) + bd + acbd * power;
    }
    }
/*********************** Algorithm   ***********************/
}