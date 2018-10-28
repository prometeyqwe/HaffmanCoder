package ru.prometey.haffman;

import java.util.HashMap;
import java.util.Scanner;

public class HaffmanApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        System.out.println("Введите имя файла: ");
//        Haffman haffman = new Haffman(in.nextLine());
        HaffmanCoder haffmanCoder = new HaffmanCoder("file.txt");
        HaffmanDecoder haffmanDecoder = new HaffmanDecoder("1file.txt");
        HashMap<String, String> table = new HashMap<>();
        haffmanCoder.buildTableOfCodes();
        table = haffmanCoder.getTable();
//        for (HashMap.Entry entry : table.entrySet()) {
//            System.out.println("Key: " + entry.getKey() + " Value: "
//                    + entry.getValue());
//        }

        System.out.println();
        haffmanCoder.coder();
        haffmanDecoder.decod();
//        haffman.decoder();
//        Tree tree = haffman.buildTreeOfHaffman();
    }
}
