package com.epam.lab.homework.exception;

public class WrongInputException extends Exception {

    public WrongInputException() {
        super();
        System.out.println("Wrong input");
        System.exit(0);
    }
}



