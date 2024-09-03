package org.example;

import org.example.component.ApplicationRunner;

import java.util.Scanner;
1
public class Main {

    public static Scanner SCANNER = new Scanner(System.in);


    public static void main(String[] args) {
        ApplicationRunner runner = new ApplicationRunner();
        runner.run();
    }


}