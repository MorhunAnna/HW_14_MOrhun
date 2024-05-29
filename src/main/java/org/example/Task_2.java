package org.example;

public class Task_2
{
    public static void main(String[] args)
    {
        int[] numbers = {1, 2, 22, 12, 9, 57, 74, 28, 56, 10, 6, 88, 21, 14, 8, 87, 4, 3, 29, 20, 33, 26};

        final int[] count1 = {0};
        final int[] count2 = {0};

    int middle = numbers.length / 2;

        Thread thread1 = new Thread(() -> {
            count1[0] = countPrimes(numbers, 0, middle);
        });

        Thread thread2 = new Thread(() -> {
            count2[0] = countPrimes(numbers, middle, numbers.length);
        });

    thread1.start();
    thread2.start();

    try
    {
        thread1.join();
        thread2.join();
    }
    catch (InterruptedException e)
    {
        e.printStackTrace();
    }


    System.out.println("Prime numbers 1st part: " + count1[0]);
    System.out.println("Prime numbers 2nd part: " + count2[0]);

    int totalCount = count1[0] + count2[0];
    System.out.println("Total amount of numbers: " + totalCount);
}

    private static int countPrimes(int[] numbers, int start, int end)
    {
        int count = 0;
        for (int i = start; i < end; i++)
        {
            if (isPrime(numbers[i]))
            {
                count++;
            }
        }
        return count;
    }
    private static boolean isPrime(int number) //prime or no
    {
        if (number <= 1)
        {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++)
        {
            if (number % i == 0)
            {
                return false;
            }
        }
        return true;
    }

}


