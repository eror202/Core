package ru.smirnov;

public class Main {

    public static void main(String[] args) {
        int arrayLengthX = 5;
        int arrayLengthY = 5;
        int[][] array = new int[arrayLengthX][arrayLengthY];
        addNumbersToArray(array);
        System.out.println("Двумерный массив со случайными числами");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n" + average(array,arrayLengthX, arrayLengthY) + " <- среднее значение массива");
        System.out.println(maxNumber(array) + " <- максимальное значение массива");
        System.out.println(minNumber(array) + " <- минимальное значение массива");
    }

    public static double average(int[][] array, int arrayLengthX, int arrayLengthY) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        return sum / (arrayLengthX * arrayLengthY);
    }

    public static int maxNumber(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    public static int minNumber(int[][] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
        }
        return min;
    }

    public static int[][] addNumbersToArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = randomizer();
            }
        }
        return array;
    }

    public static int randomizer() {
        Object object = new Object();
        Math.random();
        return (byte) (object.hashCode() + System.nanoTime());
    }
}