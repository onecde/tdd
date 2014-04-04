package tdd;

import java.util.ArrayList;

public class CardValidate {

	public ArrayList<Integer> doubles(ArrayList<Integer> fixArr) {

		ArrayList<Integer> newArr = new ArrayList<Integer>();
		int fixArrSize = fixArr.size();
		for(int i=0;i<fixArrSize;i++){
			if(i%2 == fixArrSize % 2){
				newArr.add(i,Integer.parseInt(fixArr.get(i)+"")*2);
				
			}else{				
				newArr.add(i,fixArr.get(i));					
			}		
		}
		return newArr;
	}

	public int getIntInArr(ArrayList<Integer> arr,int index) {
			
			return Integer.parseInt(arr.get(index)+"");
	}

	public int getSum(ArrayList<Integer> fixArr) {
		int sum=0;
		for(int i=0;i<fixArr.size();i++){
			int fixArrI = Integer.parseInt(fixArr.get(i)+"");
			if(fixArrI >= 10) fixArrI = fixArrI / 10 + fixArrI % 10;				
			sum += fixArrI; 
		}
		
		return sum;
	}
	
	public int getDoubledSum(ArrayList<Integer> fixArr) {
		ArrayList<Integer> doubledArr = doubles(fixArr);
		int sum=0;
		for(int i=0;i<doubledArr.size();i++){
			int doubledArrI = Integer.parseInt(doubledArr.get(i)+"");
			if(doubledArrI >= 10) doubledArrI = doubledArrI / 10 + doubledArrI % 10;				
			sum += doubledArrI; 
		}
		
		return sum;
	}

	public int checkSum(ArrayList<Integer> fixArr) {
//		ArrayList<Integer> doubledArr = doubles(fixArr);
//		return getSum(doubledArr)%10;

		return getDoubledSum(fixArr)%10;
	}
			
}
