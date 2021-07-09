package com.demo.priorityQueue;

import java.time.LocalDate;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue<LocalDate>();
        priorityQueue.add(LocalDate.of(1906,12,9));
        priorityQueue.add(LocalDate.of(1815,12,10));
        priorityQueue.add(LocalDate.of(1903,12,3));
        priorityQueue.add(LocalDate.of(1910,6,22));

        System.out.println("Iterating over elements:");
        for (Object date: priorityQueue) {
            System.out.println(date);
        }
        System.out.println("Removing element ......");
        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.remove());
        }
        System.out.println("After removing elements");
        for (Object date: priorityQueue) {
            System.out.println(date);
        }

    }
}
