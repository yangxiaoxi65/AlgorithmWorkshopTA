package AS2;

import java.util.ArrayList;
import java.util.Random;

public class SortedNumberInsertion {


	public static void main(String[] args) {
        long startTime;
        long endTime;
        double time;
        double ArrayListTime = 0;
        double BSTTime = 0;
        double AVLTime = 0;
        double RBTreeTime = 0;
        
    	for (int n = 100; n <= 10000; n+=100) {
	        Random random = new Random(n);
//	        System.out.println("n =" + n);	        
	       	        
    		// Test ArrayList
	        //Construct ArrayList
	        for(int i = 0; i < 100; i++) {
	        	ArrayList<Integer> testData = new ArrayList<>(n);
	        	Integer insertNum = random.nextInt(Integer.MAX_VALUE);
		        for(int j = 0 ; j < n ; j ++) {
		            testData.add(j);
	        	}

		      //Search ArrayList
		        startTime = System.nanoTime();
		        		        
				testData.add(insertNum);	
		        
		        endTime = System.nanoTime();
		        
		        time = (endTime - startTime);
		        ArrayListTime += time;
		        	       	        
		        // Test BST
		        //Construct BST	        
		        BST<Integer, Integer> bst = new BST<>();
		        for (Integer x: testData)
		            bst.add(x, null);
	        
	        
		        //Search BST
		        startTime = System.nanoTime();
		        
		        bst.add(insertNum,null);	
		        
		        endTime = System.nanoTime();
		        
		        time = (endTime - startTime);
		        BSTTime += time;
	              	
		        // Test AVL
		        //Construct AVL	        
		        AVLTree<Integer, Integer> avl = new AVLTree<>();
		        for (Integer x: testData)
		            avl.add(x, null);
	        
	        
		        //Search AVL
		        startTime = System.nanoTime();
		        
		        avl.add(insertNum,null);
		        
		        endTime = System.nanoTime();
		   
		        time = (endTime - startTime);
		        AVLTime += time;
	
		        // Test RBTree
		        //Construct RBTree	
		        RBTree<Integer, Integer> rbt = new RBTree<>();
		        for (Integer x: testData)
		            rbt.add(x, null);

	        
		        //Search RBTree
		        startTime = System.nanoTime();
		        
		        rbt.add(insertNum,null);
		        
		        endTime = System.nanoTime();
		   
		        time = (endTime - startTime);
		        RBTreeTime += time;		        	        		        
	        }

	        System.out.println("Search ArrayList: " + ArrayListTime/100 + " ns");
	        System.out.println("Search BST: " + BSTTime/100 + " ns");
	        System.out.println("Search AVL: " + AVLTime/100 + " ns");
	        System.out.println("Search RBTree: " + RBTreeTime/100 + " ns");
	        System.out.println("************************************");
//	        System.out.println(ArrayListTime/100);
//	        System.out.println(BSTTime/100);
//	        System.out.println(AVLTime/100);
//	        System.out.println(RBTreeTime/100);
	    }
    	
    }

}
