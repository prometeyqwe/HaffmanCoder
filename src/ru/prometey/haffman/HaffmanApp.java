package ru.prometey.haffman;

public class HaffmanApp {
    public static void main(String[] args) {

        HaffmanCoder haffmanCoder = new HaffmanCoder("file.txt");
        HaffmanDecoder haffmanDecoder = new HaffmanDecoder("1file.txt");

        haffmanCoder.coder();
        haffmanDecoder.decod();

    }
}
