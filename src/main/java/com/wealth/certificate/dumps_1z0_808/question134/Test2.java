package com.wealth.certificate.dumps_1z0_808.question134;

public class Test2{
	public static void doChange(int... arr){
		//System.out.println("Method: "+arr[0] + ", " + arr[1] + ", " + arr[2]);
		for(int pos = 0; pos < arr.length; pos++){
			arr[pos] = arr[pos] + 1; 
		}
	}
	public static void main(String[] args){
		int[] arr = {10, 20, 30};
		doChange(arr);
		for(int x: arr){
			System.out.print(x + ", ");
		}
		doChange(arr[0], arr[1], arr[2]);
		System.out.print(arr[0] + ", " + arr[1] + ", " + arr[2]);
		
		
	}
}