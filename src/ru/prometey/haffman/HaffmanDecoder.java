package ru.prometey.haffman;

import ru.prometey.IO.ReaderOfFile;
import ru.prometey.IO.WriterOfFile;
import ru.prometey.dataStruct.Node;
import ru.prometey.dataStruct.Tree;

import java.util.ArrayList;

public class HaffmanDecoder {

    private String[] inputData;
    private Tree tree;
    private WriterOfFile writerOfFile;
    private int j;
    private int k;

    HaffmanDecoder(String path){
        inputData = new ReaderOfFile(path).read().get(0).split("/");
        writerOfFile = new WriterOfFile("2"+path);
        tree = new Tree();
        buildTree(tree);
        j=0;
        k=0;
    }

    private void buildTree(Tree tree){
        String[] treeArr = inputData[0].split("");
        String[] symArr = inputData[1].split("");
        if(j<treeArr.length){
            if(treeArr[j].equals("0")){
                tree.setLeft(new Tree());
                j++;
                if(treeArr[j].equals("0"))
                    buildTree(tree.getLeft());
                if(treeArr[j].equals("1")) {
                    tree.setRight(new Tree());
                    j++;
                }
            }

            if(j<treeArr.length && treeArr[j].equals("0")){
                buildTree(tree.getRight());
            }

        }
    }


    private void inOrder(Tree tree){
        String[] symArr = inputData[1].split("");
        if(tree!=null){

            inOrder(tree.getLeft());
            inOrder(tree.getRight());
            if(tree.getLeft()==null && tree.getRight()==null) tree.setRoot(new Node(symArr[k++]));
        }
    }

    public void decod(){
//        for (String s: inputData) System.out.println(s);
        Tree temp = tree, temp2 = tree;
        buildTree(tree);//build tree
        inOrder(tree);//add symbols to tree

        String inputString = inputData[2];
        String outputString = "";
        System.out.println("inputString: "+inputString);
        int jj=0;
        int jjj=0;
        temp2 = temp = tree;
        while(jjj<inputString.length()){
            System.out.print(inputString.charAt(jjj));
            jjj++;
        }
        System.out.println("\nlen: " + inputString.length());
        System.out.println();

        while(jj<inputString.length()){
            if(inputString.charAt(jj)=='0'){
                temp2 = temp;
                if(temp.getLeft()!=null){
                    temp = temp.getLeft();
                    jj++;
                    if(jj==inputString.length()) outputString+=temp.getRoot().getSymbol();
                }
                else{
                    System.out.print(jj+" ");
                    outputString+=temp2.getRoot().getSymbol();
                    temp2 = temp = tree;
                }
            }
            else if(inputString.charAt(jj)=='1'){
                temp2 = temp;
                if(temp.getRight()!=null){
                    temp = temp.getRight();
                    jj++;
                    if(jj==inputString.length()) outputString+=temp.getRoot().getSymbol();
                }
                else{
                    System.out.print(jj+" ");
                    outputString+=temp2.getRoot().getSymbol();
                    temp2 = temp = tree;
                }
            }
        }

        System.out.println();
        System.out.println(outputString);





    }
}

