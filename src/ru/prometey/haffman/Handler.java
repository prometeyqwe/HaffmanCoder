package ru.prometey.haffman;

import ru.prometey.dataStruct.Node;
import ru.prometey.dataStruct.PriorityQueue;
import ru.prometey.IO.ReaderOfFile;

import java.util.*;


public class Handler {

    private ReaderOfFile reader;
    private ArrayList<String> inputStrings;
    private char[] alphabet;
    private ru.prometey.dataStruct.PriorityQueue priorityQueue = new PriorityQueue();

    public ArrayList<String> getInputStrings() {
        return inputStrings;
    }

    Handler(String path){
        reader = new ReaderOfFile(path);
        inputStrings = reader.read();
        alphabet = new char[29];
        for (int i = 0; i < alphabet.length; i++) { //create alphabet
            alphabet[i] = (char) (i+97);
        }
        alphabet[26] = ',';
        alphabet[27] = '.';
        alphabet[28] = ' ';
    }

    public Node[] getFreqOfSym(){

        int[] output = new int[alphabet.length];
        Node[] out = new Node[alphabet.length];

        for(String s:inputStrings){
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < alphabet.length; j++) {
                    if(s.charAt(i) == alphabet[j])
                        output[j]++;
                }
            }
        }

        for(int i =0; i< alphabet.length; i++){
            out[i] = new Node(alphabet[i], output[i]);
//            System.out.println(alphabet[i] +   "    " + output[i]);
        }

        return out;
    }

}
