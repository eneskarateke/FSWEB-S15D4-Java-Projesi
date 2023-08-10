package com.workintech;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't node"));

    }

    public static boolean checkForPalindrome(String text) {
        LinkedList<Character> stack = new LinkedList<>();


        String noPuncText = text
                .replaceAll(",","")
                .replaceAll("\\?","")
                .replaceAll("'","")
                .replaceAll(" ","");
        String lowerCase= noPuncText.toLowerCase(Locale.forLanguageTag("en-EN"));
//        System.out.println("lowercase: " + lowerCase);

        for (int i = 0; i <lowerCase.length() ; i++) {
            char c = lowerCase.charAt(i);
            stack.push(c);
        }
//        System.out.println("stack: " + stack);


        String stackString = "";

        // using iterator for traversing a linkedlist
        Iterator<Character> iterator = stack.iterator();

        while (iterator.hasNext()) {
            // appending using "+" operator
            stackString = stackString + iterator.next();
        }
//        System.out.println("stackString: " + stackString);



        if (stackString.equals(lowerCase)){
            return true;
        }


return false;


    }
}