package unit6;

import java.util.*;
import java.lang.*;

// In the operation related to heap, it is necessary to compare the size of the elements in the heap, so Item needs extends Comparable
public class MaxHeap<Item extends Comparable> {

    protected Item[] data;
    protected int count;
    protected int capacity;

    // constructor, constructs an empty heap, which can hold the capacity of elements
    public MaxHeap(int capacity){
        data = (Item[])new Comparable[capacity+1];
        count = 0;
        this.capacity = capacity;
    }

    // constructor, creates a maximum heap from a given array
    // This process of constructing a heap has a time complexity of O(n)
    public MaxHeap(Item arr[]){

        int n = arr.length;

        data = (Item[])new Comparable[n+1];
        capacity = n;

        for( int i = 0 ; i < n ; i ++ )
            data[i+1] = arr[i];
        count = n;

        for( int i = count/2 ; i >= 1 ; i -- )
            shiftDown(i);
    }

    // Returns the number of elements in the heap
    public int size(){
        return count;
    }

    // Returns a Boolean value indicating whether the heap is empty or not
    public boolean isEmpty(){
        return count == 0;
    }

    // Insert a new element into the largest heap item
    public void insert(Item item){

        assert count + 1 <= capacity;
        data[count+1] = item;
        count ++;
        shiftUp(count);
    }

    // Get the top element of the largest heap
    public Item extractMax(){
        assert count > 0;
        Item ret = data[1];

        swap( 1 , count );
        count --;
        shiftDown(1);

        return ret;
    }

    // Get the top element of the largest heap
    public Item getMax(){
        assert( count > 0 );
        return data[1];
    }


    // Swap two elements of the heap with indexes i and j
    private void swap(int i, int j){
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    //********************
    //* Maximum Heap Core Helper Functions
    //********************
    private void shiftUp(int k){
        Item e = data[k];
        while( k > 1 && data[k/2].compareTo(e) < 0 ){
            //swap(k, k/2);
            data[k] = data[k/2];
            k /= 2;
        }
        data[k] = e;
    }

    private void shiftDown(int k){

        Item e = data[k];
        while( 2*k <= count ){
        	// In this loop, data[k] and data[j] swap positions
            int j = 2*k; 
            if( j+1 <= count && data[j+1].compareTo(data[j]) > 0 )
                j ++;
            // data[j] is the maximum of data[2*k] and data[2*k+1]

            if( e.compareTo(data[j]) >= 0 ) break;
            //swap(k, j);
            data[k] = data[j];
            k = j;
        }
        data[k] = e;
    }

}