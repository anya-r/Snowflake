import java.util.*;

public class RecursionProbs 
{
    //2
    public double sumReciprocals(int n)
    {
        if (n == 1)
            return 1.0;
        else
            return 1.0/n + sumReciprocals(n-1);
    }

    //3 
    public int productOfEvens(int n)
    {
        if (n == 1)
            return 2;
        
        else
            return 2 * n * productOfEvens(n-1);
    }
        
        
    //5
    public String conversion(int num, int base)
    {
        if (num == 0)
            return "";
        else
            return conversion(num/base, base) + (num % base);
    }

    //6
    public int matchingDigits(int a, int b)
    {
        if (a < 10 || b < 10)
        {
            if (a >= 10)
                a = a % 10;
            if (b >= 10)
                b = b % 10;
            if (a == b)
                return 1;
            else
                return 0;
        }
        else
        {
            int x = a % 10;
            int y = b % 10;
            if (x == y)
                return 1 + matchingDigits(a/10, b/10);
            else
                return 0 + matchingDigits(a/10, b/10);

        }
    }
    
    //7
    public void doubleUp(Stack<Integer> nums)
    {
        if (nums.isEmpty())
            return;
        int temp = nums.pop();
        doubleUp(nums);
        nums.push(temp);
        nums.push(temp);
    }
    //8
    public void printThis(int n)
    {
        if (n <= 2)
        {
            if (n == 1)
                System.out.print("*");
            else if (n == 2)
                System.out.print("**");
        }
        else
        {
            System.out.print("<");
            printThis(n - 2);
            System.out.print(">"); 
        }
        
    }
    //9
    public void printNums2(int n)
    {
        if (n <= 2)
        {
            if (n == 2)
                System.out.print("11");
            else
                System.out.print("1");
        }
        else
        {
            boolean isEven = n % 2 == 0;
            if (isEven)
                System.out.print(n/2);
            else
                System.out.print((n/2) + 1);

            printNums2(n - 2);
            
            if (isEven)
                System.out.print(n/2);
            else
                System.out.print((n/2) + 1);
        }
    }


    public static void main(String[] args) 
    {
        RecursionProbs x = new RecursionProbs();
        double d = x.sumReciprocals(10);
        System.out.println(d);
        int i = x.productOfEvens(4);
        System.out.println(i);
        String str = x.conversion(1453,8);
        System.out.println(str);
        int match = x.matchingDigits(298892,7892);
        System.out.println(match);
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        x.doubleUp(stack);
        System.out.println(stack);
        x.printNums2(5);




    

    }
    
}
