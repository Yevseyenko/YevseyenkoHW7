package com.epam.lab.homework;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class InputNumber {
    private static final Logger log = Logger.getLogger(InputNumber.class);

    public int readOnlyIntegers(Scanner in) {
        log.debug("Start scanning");
        int n = 0;
        try {
            log.info("Message");
            n = in.nextInt();
        } catch (Exception e) {
            log.warn("Warning");
            log.error("Something failed", e);
            System.out.println("only numbers are allowed");
            in.nextLine();
            n = readOnlyIntegers(in);
        }
        return n;
    }
}
