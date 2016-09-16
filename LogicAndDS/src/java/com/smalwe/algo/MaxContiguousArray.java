package com.smalwe.algo;


//Kdane's Algorithm ie. DP approach
public class MaxContiguousArray {

	public static void main(String args[]){
		int[] ar = {1,2,3,-50,100, 40, -200, 1000, 45,67};
		findMaxContiguousArray(ar);
	}
	
	//DP approach
	public static void findMaxContiguousArray(int[] ar){
		int maxSI = 0;
		int maxEI = 0;
		int maxSum = 0;
		int currSI = 0;
		int currSum = 0;
		
		for(int i=0; i<ar.length; i++){
			
			if( currSum + ar[i] >= 0){
				currSum = currSum + ar[i];
				if(maxSum <= currSum){
					maxSI = currSI;
					maxSum = currSum;
					maxEI = i;
				}
			}
			if(currSum + ar[i] < 0 && i < (ar.length -1)){
				currSI = i + 1;
				currSum = 0;
			}
		}
		System.out.println("Max SI:" + maxSI);
		System.out.println("Max EI:" + maxEI);
		System.out.println("Max Sum:" + maxSum);
	}
}
