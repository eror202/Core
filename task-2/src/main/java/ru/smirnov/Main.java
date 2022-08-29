package ru.smirnov;

public class Main {

    public static void main(String[] args) {
        int[] arrayForSort = new int[]{5, 6, 3, 2, 5, 1, 4, 9};


        String array = "";
        for (int i : arrayForSort) {
            array = array.concat(i + " ");
        }
        System.out.println(array + "<- заданный массив для сортировки");
        sortArray(arrayForSort);
        String sortArray = "";
        for (int i : arrayForSort) {
            sortArray = sortArray.concat(i + " ");
        }
        System.out.println(sortArray+"<-отсортированный массив");
    }



    public static int[] sortArray(int[] array) {
        for (int i = array.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}