/**
 *@author Brianne Coffey
 *Homework 1, problem 2
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    /**
     * For this problem, I chose to implement a solution using two heaps after we talked about them in class on Thursday.
     * The max heap holds the smaller numbers (this requires a comparator to be used so we can form a max heap) and the min heap holds the larger
     * If the size is odd, the median is the root of the max heap.
     * If the size is even, the median is the root of the min heap (ceiling).
     * In this case, inserting a new element is O(log n) and finding the median is O(1).
     */

    public Queue<Integer> minHeap;
    public Queue<Integer> maxHeap;
    public int size;

    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());
        size = 0;
    }

    public void addNumber(Integer num) {
        maxHeap.add(num);
        if (size%2 == 0) {
            if (minHeap.isEmpty()) {
                size++;
                return;
            }
            else if (maxHeap.peek() > minHeap.peek()) {
                Integer maxHeapRoot = maxHeap.poll();
                Integer minHeapRoot = minHeap.poll();
                maxHeap.add(minHeapRoot);
                minHeap.add(maxHeapRoot);
            }
        } else {
            minHeap.add(maxHeap.poll());
        }
        size++;
    }

    public Integer getMedian() {
        if (size%2 == 0) {
            return (minHeap.peek());
        }
        else{
            return (maxHeap.peek());
        }
    }

    private class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i, Integer j) {
            return j - i;
        }
    }

    public static void main(String[] args) {
        MedianFinder test = new MedianFinder();
        test.addNumber(2);
        test.addNumber(11);
        test.addNumber(8);
        test.addNumber(10);
        test.addNumber(1);
        test.addNumber(14);
        System.out.println(test.getMedian()); // should be 1

    }
}