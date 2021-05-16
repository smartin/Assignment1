package Assignments;

public class Assign_1B_PrimeNumberFinder {

    public static void main(String[] args)
    {

// Loop A : get numbers from 1 to 100
        for (int a = 1; a <= 100; a++)
        {
// Individual conditions for 1 and 2. NB:The fundamental theorem of arithmetic implies that 1 is not a prime number.
            if (a == 1)
            {
                System.out.println(a + " *** *** *** is not a prime number.");
                continue;
            }

            if (a == 2)
            {
                System.out.println(a + " is a prime.");
                continue;
            }

// Loop B : Check if number a is a prime

            boolean isPrime = true;

            for (int b = 2; b < (a / 2) + 1; b++)
            {

                if (a % b == 0)
                {
                    isPrime = false;
                    break;
                }

            }
            if (isPrime)
            {
                System.out.println(a + " is a prime.");
            } else
            {
                System.out.println(a + " *** *** *** is not a prime number.");
            }


        }

    }
}
