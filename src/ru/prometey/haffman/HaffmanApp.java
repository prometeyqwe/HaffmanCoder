package ru.prometey.haffman;

import java.util.HashMap;
import java.util.Scanner;

public class HaffmanApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        HaffmanCoder haffmanCoder = new HaffmanCoder("file.txt");
        HaffmanDecoder haffmanDecoder = new HaffmanDecoder("1file.txt");

        System.out.println();
        haffmanCoder.coder();
        haffmanDecoder.decod();

    }
}
