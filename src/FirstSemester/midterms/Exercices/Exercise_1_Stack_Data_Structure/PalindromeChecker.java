/**
 NAME: MALASAN, Edison M.
 DATE: 08/10/2024
 CLASS CODE: CS211 - 9344

 One application of the Stack Data Structure is the problem of determining whether a string is a
 palindrome or not.
 Problem:
 Write a program that will determine if a string that is entered at run time is a palindrome.
 Some examples of palindromes are:
 abbbdcdbbba
 mirrorrorrim
 nasabayabasan
 Specifications.
 -Your program should utilize a Stack data structure
 -Although you can easily solve the problem by using methods of the string class(i.e. There is
 method in the String class for getting the reversed form of a string), your program should
 assume that there is no such method. Use only the method to access a character in the string
 (charAt method) as well as the method to determine the length of the string(length method). Let
 this exercise prepare you to solve the problem using a bare programming language platform
 (i.e. a programming language that has very limited library of methods/functions)


 Present the sample output below:
 1. abbbdcdbbba
 This application helps you evaluate if a string is a palindrome or not
 Please enter the string: abbbdcdbbba
 abbbdcdbbba is a palindrome.

 2. mirrorrorrim
 This application helps you evaluate if a string is a palindrome or not
 Please enter the string: mirrorrorrim
 mirrorrorrim is a palindrome.

 3. nasabayabasan
 This application helps you evaluate if a string is a palindrome or not
 Please enter the string: nasabayabasan
 nasabayabasan is a palindrome.

 ------------------------------------

 Write the algorithm below:
 1. Input Prompt:
 The program begins by prompting the user to enter a string.
 This string can include letters, numbers, or special characters, depending on the desired use case.

 2. Push the First Half onto the Stack:
 To analyze the string, first need to focus on its first half amd calculate the midpoint of the string to identify how many characters we need to examine.
 Then enter a loop that iterates through the characters of the first half of the string. For each character encountered, we push it onto the stack.
 Then it will reverse the order of these characters, setting us up for the comparison phase.

 3. Handle the Middle Character:
 If the string has an odd length, there will be a single middle character that does not need to be compared.
 To accommodate this, we check the length of the string. If it is odd, we simply skip the middle character by adjusting our index accordingly.
 This will make sure that we only compare relevant characters from both halves.

 4. Pop and Compare:
 Now for second half, we iterate through this section of the string while simultaneously popping characters off the stack.
 For each character popped from the stack, we compare it to the corresponding character in the second half of the string.
 If the program find any mismatches during this process, we can immediately conclude that the string is not a palindrome.

 5. Last Check:
 If we successfully compare all the characters and find that they match, we also verify that the stack is empty at the end of this process.
 If both conditions are satisfied—matching characters and an empty stack—then the program will declare that the string is indeed a palindrome.


 */
package Exercise_1_Stack_Data_Structure;

import java.lang.*;
import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        PalindromeChecker myProgram;
        try {
            myProgram = new PalindromeChecker(); // create an instance of PalindromeChecker
            myProgram.run();
        } catch (Exception e) {
            e.printStackTrace(); // stack trace if an exception occurs
        }
        System.exit(0);
    } // end of main method



    public void run() throws Exception {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("This application helps you evaluate if a string is a palindrome or not");
        System.out.print("Please enter the string: ");
        String input = keyboard.nextLine();

        // call isPalindrome method to check if the string is a palindrome
        if (isPalindrome(input))
            System.out.println(input + " is a palindrome.");
        else
            System.out.println(input + " is not a palindrome.");
    } // end of run method

    // method to determine if the input string is a palindrome
    public boolean isPalindrome(String string) throws StackUnderflowException {
        MyStack<Character> stack = new MyStack<Character>(); // create a stack of characters
        int index = 0; // index to traverse the string
        Character topSymbol = null; // variable to hold the character popped from the stack

        // push the first half of the string onto the stack
        while (index < string.length() / 2) {
            stack.push(string.charAt(index)); // push character onto the stack
            index += 1; // move to the next character
        }

        // if the string length is odd, skip the middle character
        if (string.length() % 2 != 0) {
            index += 1;
        }

        // pop characters from the stack and compare them with the second half of the string
        for (; index < string.length(); index++) {
            topSymbol = stack.pop(); // pop from stack
            // compare the popped character with the current character in the string
            if (topSymbol.charValue() != string.charAt(index))
                return false; // return false and if they don't match, it's not a palindrome
        }

        // if the stack is empty and all characters matched, it's a palindrome
        if (stack.isEmpty())
            return true;
        else
            return false;
    } // end of isPalindrome method
} // end of PalindromeChecker class

