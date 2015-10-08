/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksortexperiment;

import java.time.Instant;

/**
 *
 * @author Michael
 */
public class MainClass {

    public static void main(String[] args) throws InterruptedException {

        MyQuickSort qs = new MyQuickSort();
        int size = 10;
        int[] sorted = new int[size];
        int[] reverseSorted = new int[size];
        int[] switching = new int[size];

        for (int i = 0; i < size; i++) {
            sorted[i] = i;
            reverseSorted[(size - 1) - i] = i;
            if (i % 2 == 0) {
                switching[i] = i;
            } else {
                switching[size - i] = i;
            }
        }

        int iterations = 100;

        long sortedTime = 0;
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            int[] temp = sorted.clone();
            
            qs.sort(temp);
        }
        long stopTime = System.nanoTime();
        sortedTime += (stopTime - startTime);
        long avgSortedTime = sortedTime/iterations;

        long reverseSortedTime = 0;
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            int[] temp = reverseSorted.clone();
            qs.sort(temp);
        }
        stopTime = System.nanoTime();
        reverseSortedTime += (stopTime - startTime);
        long avgReverseSortedTime = reverseSortedTime/iterations;

        long switchedTime = 0;
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            int[] temp = switching.clone();
            qs.sort(temp);
        }
        stopTime = System.nanoTime();
        switchedTime = switchedTime + (stopTime - startTime);
        long avgSwitchedTime = switchedTime/iterations;

        System.out.println(String.format("Average times to sort the lists over %d iterations", iterations));
        System.out.println(String.format("The lists consist of %d elements", size));
        System.out.println("Already sorted: " + avgSortedTime + "s^-9");
        System.out.println("Reverse sorted: " + avgReverseSortedTime + "s^-9");
        System.out.println("Fixed random order: " + avgSwitchedTime + "s^-9");
    }
}
