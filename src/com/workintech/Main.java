package com.workintech;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't node"));

        System.out.println("**************************************");

        System.out.println(checkForPalindromeFIFO("abccba"));
        System.out.println(checkForPalindromeFIFO("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindromeFIFO("I did, did I?"));
        System.out.println(checkForPalindromeFIFO("hello"));
        System.out.println(checkForPalindromeFIFO("Don't node"));
        System.out.println(checkForPalindromeFIFO("RACECAR"));

        System.out.println("**************************************************");
        System.out.println(convertDecimalToBinary(13));
        System.out.println(convertDecimalToBinary(5));
        System.out.println(convertDecimalToBinary(6));
        System.out.println(convertDecimalToBinary(75));


    }

    public static boolean checkForPalindrome(String text) {
        Stack<Character> stack = new Stack<>();


        String noPuncText = text
                .replaceAll(",","")
                .replaceAll("\\?","")
                .replaceAll("'","")
                .replaceAll(" ","");
        String lowerCase= noPuncText.toLowerCase(Locale.forLanguageTag("en-EN"));
//        System.out.println("lowercase: " + lowerCase);

        for (int i = 0; i <lowerCase.length() ; i++) {
            char c = lowerCase.charAt(i);
            stack.add(c);
        }
//        System.out.println("stack: " + stack);


        String stackString = "";

        Iterator<Character> iterator = stack.iterator();

        while (iterator.hasNext()) {
            stackString = iterator.next() + stackString;;
        }
//        System.out.println("stackString: " + stackString);



        if (stackString.equals(lowerCase)){
            return true;
        }


return false;


    }

    public static boolean checkForPalindromeFIFO(String text) {

        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();
        String lowerCase = text.toLowerCase(Locale.ENGLISH);


        for(int i = 0; i < lowerCase.length(); i++){
            char c = lowerCase.charAt(i);
            if(c >= 'a' && c <= 'z'){
                queue.addLast(c);
                stack.push(c);
            }
        }
//        System.out.println("queue: " + queue);
//        System.out.println("stack: " + stack);


        if(stack.equals(queue)){
            System.out.println("EQUAL");
            return true;
        } else{
            System.out.println("NOT EQUAL");
            return false;
        }

    }


    public static String convertDecimalToBinary(int num){
        //5
        //5 % 2 = 1    2 % 2 = 0    1 % 2 = 1
        //5 / 2 = 2    2 / 2 = 1    1 / 2 = 0

        //13
        //13 % 2 = 1   6 % 2 = 0   3 % 2 = 1  1 % 2 = 1
        //13 / 2 = 6   6 / 2 = 3   3 / 2 = 1  1 / 2 = 0

        final int base = 2;
        Stack digits = new Stack();

        while(num > 0){
            //[1, 1, 0, 1]
            digits.push(num % base);
            num = num / base;
        }

        String bits = "";
        while (!digits.isEmpty()){
            bits += digits.pop();
        }
        digits.toString();
        return bits;
    }


}