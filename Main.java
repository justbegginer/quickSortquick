package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] array={2,3,6,28 , 13 , 103 , 24 , 25};
        int[] result = quickSort(array);
        for(int i : result) {
            System.out.println(i+" ");
        }
    }
    private static int[] quickSort(int[] array){
        int[] result ;
        if (array.length < 2){
            return array;
        }
        else {
            int pivot = array[0];
            List greatest = new ArrayList(),less = new ArrayList();
            for (int i = 1 ;i<array.length ; i++){
                if (array[i] > pivot){
                    greatest.add(array[i]);
                }
                else{
                    less.add(array[i]);
                }

            }
            less = arrayToList(quickSort(listToArray(less)));
            less.add(pivot);
            greatest = arrayToList(quickSort(listToArray(greatest)));
            less.addAll(greatest);
            result = listToArray(less);
        }
        return result;
    }
    private static int[] listToArray(List inputList){
        int[] resultArray = new int[inputList.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] =(int) inputList.get(0);
            inputList.remove(0);
        }
        return resultArray;
    }
    private static List arrayToList(int[] inputArray){
        List result = new ArrayList();
        for (int i : inputArray) {
            result.add(i);
        }
        return  result;
    }
}
