/**
 * This class merges two heaps by choice of method.
 * The first option is to add each element from the smaller heap to the larger, one by one.
 * The second option is to append the arraylist of the smaller heap to the end of the larger one.
 * @author Brianne Coffey
 * @version 9/21/17
 */

import java.util.*;
public class MergeHeap<E extends Comparable<E>>
{

    //Adding the smaller heap directly to the larger = O(n log n)

    public Heap<E> mergeHeap1(Heap h1, Heap h2) {

        if(h1.data.size() <= h2.data.size()){
            for (int i = 0; i < h1.data.size(); i++) {
                h2.add((Comparable) h1.data.get(i));
            }
            return h2;
        }
        else
            for (int j = 0; j < h2.data.size(); j++) {
                h1.add((Comparable) h2.data.get(j));
            }
            return h1;

    }

    //Adding the smaller heap by appending the arraylist = O(n)

    public Heap<E> mergeHeap2(Heap h1, Heap h2) {

        if(h1.data.size() <= h2.data.size()){
            for (int i = 0; i < h1.data.size(); i++) {
                h2.data.add(h1.data.get(i));
            }
            h2.buildHeap();
            return h2;
        }
        else
            for (int j = 0; j < h2.data.size(); j++) {
                h1.data.add(h2.data.get(j));
            }
            h1.buildHeap();
            return h1;

    }
    public static void main(String[] args) {
        int size = 10000000;
        Random r = new Random();
        Heap<Integer> he = new Heap<Integer>(size);


        for (int i = 0; i < size; i++) {

            he.initialize(r.nextInt(size));

        }
        int size1 = 10000000;
        Heap<Integer> he1 = new Heap<Integer>(size1);


        for (int i = 0; i < size1; i++) {

            he1.initialize(r.nextInt(size1));

        }
        int size2 = 20000000;
        Heap<Integer> he2 = new Heap<Integer>(size2);


        for (int i = 0; i < size2; i++) {

            he2.initialize(r.nextInt(size2));

        }
        int size3 = 20000000;
        Heap<Integer> he3 = new Heap<Integer>(size3);


        for (int i = 0; i < size3; i++) {

            he3.initialize(r.nextInt(size3));

        }
        int size4 = 30000000;
        Heap<Integer> he4 = new Heap<Integer>(size4);


        for (int i = 0; i < size4; i++) {

            he4.initialize(r.nextInt(size4));

        }
        int size5 = 30000000;
        Heap<Integer> he5 = new Heap<Integer>(size5);


        for (int i = 0; i < size5; i++) {

            he5.initialize(r.nextInt(size5));

        }
        int size6 = 40000000;
        Heap<Integer> he6 = new Heap<Integer>(size6);


        for (int i = 0; i < size6; i++) {

            he6.initialize(r.nextInt(size6));

        }
        int size7 = 40000000;
        Heap<Integer> he7 = new Heap<Integer>(size7);


        for (int i = 0; i < size7; i++) {

            he7.initialize(r.nextInt(size7));

        }


        MergeHeap mh = new MergeHeap<>();

        long t1 = System.currentTimeMillis();

        mh.mergeHeap1(he, he1);

        long t2 = System.currentTimeMillis();
        System.out.println("Milliseconds to merge heaps with method 1: " + (t2 - t1));

        long t3 = System.currentTimeMillis();

        mh.mergeHeap2(he, he1);

        long t4 = System.currentTimeMillis();
        System.out.println("Milliseconds to merge heaps with method 2: " + (t4 - t3));

        long t5 = System.currentTimeMillis();

        mh.mergeHeap1(he2, he3);

        long t6 = System.currentTimeMillis();
        System.out.println("Milliseconds to merge heaps with method 1: " + (t6 - t5));

        long t7 = System.currentTimeMillis();

        mh.mergeHeap2(he2, he3);

        long t8 = System.currentTimeMillis();
        System.out.println("Milliseconds to merge heaps with method 2: " + (t8 - t7));

        long t9 = System.currentTimeMillis();

        mh.mergeHeap1(he4, he5);

        long t10 = System.currentTimeMillis();
        System.out.println("Milliseconds to merge heaps with method 1: " + (t10 - t9));

        long t11 = System.currentTimeMillis();

        mh.mergeHeap2(he4, he5);

        long t12 = System.currentTimeMillis();
        System.out.println("Milliseconds to merge heaps with method 2: " + (t12 - t11));

        long t13 = System.currentTimeMillis();

        mh.mergeHeap1(he6, he7);

        long t14 = System.currentTimeMillis();
        System.out.println("Milliseconds to merge heaps with method 1: " + (t14 - t13));

        long t15 = System.currentTimeMillis();

        mh.mergeHeap2(he6, he7);

        long t16 = System.currentTimeMillis();
        System.out.println("Milliseconds to merge heaps with method 2: " + (t16 - t15));




    }
}
