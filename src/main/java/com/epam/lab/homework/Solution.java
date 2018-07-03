package com.epam.lab.homework;

import com.epam.lab.homework.exception.WrongInputException;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Solution {

    private static final Logger log = Logger.getLogger(InputNumber.class);

    //Finding the sum of inputted digits
    private static void additionDigits(int n) {
        log.debug("Begin method");
        int sum = 0;
        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        System.out.println("Sum of inputted digits " + sum);
    }

    //Inputting numbers until user input 0. After that finding the sum and arithmetical mean of inputted number
    private static void sumNumbers() {
        System.out.println("Please input numbers and press enter:");
        int sum = 0;
        int count = 0;
        while (true) {
            Scanner input = new Scanner(System.in);
            int number = input.nextInt();
            if (number > 0) {
                sum = sum + number;
                count++;
            }
            if (number == 0) {
                System.out.println("The sum is: " + sum);
                System.out.println("Arithmetical mean is: " + sum / count);
                return;
            }
        }
    }

    // Outputs the numbers which gives residue 1,3 or 5 in dividing by 7 numbers  interval from 35 to 87
    private static void findingResidue() {
        for (int i = 35; i <= 87; i++) {
            if (i % 7 == 1 | i % 7 == 3 | i % 7 == 5) {
                System.out.println(i);
            }
        }
    }

    //Outputs the count of even digits in number.
    private static void countingEven() {
        System.out.println("Please input number to find even digits: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int evenCount = 0;
        while (n != 0) {
            int k = n % 10;
            n = n / 10;
            if (k % 2 == 0) {
                evenCount++;
            }
        }
        if (evenCount == 0) {
            System.out.println("There is no even digits in inputted numbers");
            return;
        }
        System.out.println("The count of even digits is " + evenCount);
    }

    //Output the maximum digit in number
    private static void findingMax() {
        System.out.println("Please input number to find max digit:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int maxDigit = 0;
        while (n != 0) {
            int k = n % 10;
            if (k >= maxDigit) {
                maxDigit = k;
            }
            n = n / 10;
        }
        System.out.println("Max digit is " + maxDigit);
    }

    private static void intervalFibonacci() {
        //Setting interval from 0 to 100
        System.out.println("Please enter number from 0 to 100");
        Scanner input = new Scanner(System.in);
        int firstElement = input.nextInt();
        if (firstElement > 100 | firstElement < 0) {
            System.out.println("wrong number");
            System.out.println("Please enter number from 0 to 100");
            firstElement = input.nextInt();
        }
        System.out.println("Please enter number from 0 to 100 but higher then firstone");
        int secondElement = input.nextInt();
        if (secondElement == firstElement | secondElement > 100 | secondElement < 0 | secondElement < firstElement) {
            System.out.println("wrong number");
            System.out.println("Please enter number from 0 to 100 but higher than firstone");
            secondElement = input.nextInt();
        }
        //Output odd elements in interval from the beginning to the end
        System.out.println("Odd elements: ");
        for (int i = firstElement; i <= secondElement; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
        //Output even elements in interval from the end to beginning
        System.out.println("Even elements: ");
        for (int k = secondElement; k >= firstElement; k--) {
            if (k % 2 == 0) {
                System.out.println(k);
            }
        }
        //The sum of odd and even elements
        int sumOddElements = 0;
        int sumEvenElements = 0;
        for (int i = firstElement; i <= secondElement; i++) {
            if (i % 2 != 0) {
                sumOddElements = sumOddElements + i;

            }
        }
        System.out.println("The sum of odd elements is: " + sumOddElements);
        //The sum of even elements
        for (int i = firstElement; i <= secondElement; i++) {
            if (i % 2 == 0) {
                sumEvenElements = sumEvenElements + i;
            }
        }
        System.out.println("The sum of even elements is: " + sumEvenElements);
        //Finding the max odd and even number  in interval
        int maxoddnumber;
        int maxevennumber;
        if (secondElement % 2 == 0) {
            maxevennumber = secondElement;
        } else {
            maxevennumber = secondElement - 1;
        }
        if (secondElement % 2 != 0) {
            maxoddnumber = secondElement;
        } else {
            maxoddnumber = secondElement - 1;
        }
        System.out.println("Please enter the set of Fibonacci numbers:");
        //Setting the size of Fibonacci numbers
        Scanner input4 = new Scanner(System.in);
        int size = input4.nextInt();
        int nextNumber;
        int F1 = maxoddnumber;
        int F2 = maxevennumber;
        int odd = 1;
        int even = 1;
        System.out.print(F1 + ", " + F2);
        for (int i = 2; i <= size; ++i) {
            nextNumber = F1 + F2;
            if (nextNumber % 2 == 0) {
                even++;
            }
            if (nextNumber % 2 != 0) {
                odd++;
            }
            System.out.print(", " + nextNumber);
            F1 = F2;
            F2 = nextNumber;
        }
        //Calculating percetage of odd and even numbers in Fibonacci numbers
        int oddPercent = (100 * odd) / size;
        int evenPercent = (100 * even) / size;
        System.out.println("\n" + "Percent of odd numbers: " + oddPercent + "%");
        System.out.println("Percent of even numbers: " + evenPercent + "%");
    }

    public static void main(String[] args) throws WrongInputException {
        Scanner input = new Scanner(System.in);
        InputNumber newNumber = new InputNumber();
        int i = newNumber.readOnlyIntegers(input);
        if (i < 0) {
            throw new WrongInputException();
        }
        additionDigits(i);
        sumNumbers();
        findingResidue();
        countingEven();
        findingMax();
        intervalFibonacci();
    }
}
