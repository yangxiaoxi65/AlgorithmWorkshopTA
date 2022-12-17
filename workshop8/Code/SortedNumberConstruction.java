package AS2;

import java.util.ArrayList;

public class SortedNumberConstruction {

		 public static void main(String[] args) {
		        long startTime;
		        long endTime;
		        double time;
		        double ArrayListTime = 0;
		        double BSTTime = 0;
		        double AVLTime = 0;
		        double RBTreeTime = 0;
		        
		    	for (int n = 100; n <= 10000; n+=100) {			        
//			        System.out.println("n =" + n);

//		    		// Test ArrayList
//			        //Construct ArrayList
		    		
		    		for(int i = 0; i < 100; i++) {
		    			startTime = System.nanoTime();
		    			ArrayList<Integer> testData = new ArrayList<>(n);
			        	for(int j = 0 ; j < n ; j ++) {	        		
			        		testData.add(j);
			        	}
					    endTime = System.nanoTime();
					    time = (endTime - startTime);
					    ArrayListTime += time;
			        
				        // Test BST
				        //Construct BST
				        startTime = System.nanoTime();
				        
				        BST<Integer, Integer> bst = new BST<>();
				        for (Integer x: testData) {
				            bst.add(x, null);
				        }
				        endTime = System.nanoTime();
				        
				        time = (endTime - startTime);
				        BSTTime += time;

				        // Test AVL
				        //Construct AVL
				        startTime = System.nanoTime();
				        
				        AVLTree<Integer, Integer> avl = new AVLTree<>();
				        for (Integer x: testData)
				            avl.add(x, null);
				        
				        endTime = System.nanoTime();
				        
				        time = (endTime - startTime);
				        AVLTime += time;
			
				        // Test RBTree
				        //Construct RBTree
				        startTime = System.nanoTime();
				
				        RBTree<Integer, Integer> rbt = new RBTree<>();
				        for (Integer x: testData)
				            rbt.add(x, null);
				
				        endTime = System.nanoTime();
				        time = (endTime - startTime);
				        RBTreeTime += time;

			        }
			        System.out.println("Construct ArrayList: " + ArrayListTime/100 + " ns");	
			        System.out.println("Construct BST: " + BSTTime/100 + " ns");
			        System.out.println("Construct AVL: " + AVLTime/100 + " ns");
			        System.out.println("Construct RBTree: " + RBTreeTime/100 + " ns");
			        System.out.println("************************************");
//			        System.out.println(ArrayListTime/100);
//			        System.out.println(BSTTime/100);
//			        System.out.println(AVLTime/100);
//			        System.out.println(RBTreeTime/100);
			    
		    	}
		    }	
}

