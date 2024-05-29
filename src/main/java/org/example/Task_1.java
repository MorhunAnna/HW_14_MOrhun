package org.example;

public class Task_1
{
        public static void main(String[] args)
        {
            final int count = 50;
            String[] strings = new String[count];

            Thread[] threads = new Thread[count];

            for (int i = 0; i < count; i++)
            {
                final int number = i;
                threads[i] = new Thread(() -> {
                    strings[number] = "Hello from thread " + number;
                });
                threads[i].start();
            }


            for (int i = 0; i < count; i++)
            {
                try
                {
                    threads[i].join();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            for (int i = count - 1; i >= 0; i--)
            {
                System.out.println(strings[i]);
            }
        }
    }

