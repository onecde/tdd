package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import tdd.CardValidate;

public class cardValidateTest {
    /*
    *
    * 신용 카드상의 번호 검증을 위해 사용하는 알고리듬. 1960년대에 개발된 개방형 공식이다.
    * 원리는
    * ㉠  카드 번호의 우측 숫자부터 매 2번째 숫자마다 2를 곱하고,
    * ㉡  위 ㉠에서 2를 곱하지 않은 숫자들 중 가장 우측 수를 제외하고 (이 수는 추후 점검수로 쓰인다.) ㉠에서 나온 숫자들을 합한다
    *    (㉠에서 나온 수가 2자리 수이면 2개의 숫자를 합한다).
    *
    * ㉢ 위 ㉡에서 나온 수와 그 다음으로 큰 10단위 수와의 차이를 구한다(㉡에서 나온 수가 34이면 다음으로 큰 10단위 수 40과의 차이, 6을 구한다).
    *     ㉢에서 나온 숫자가 카드의 점검 숫자와 일치해야 한다.
    *
    * */
 
    /*
      
 	12345의 우측부터 두번째는 2,4 5%2=1이면, i%2=0인것들
 	123456의 우측부터 두번째는 1,3,5 6%2=0이면 i%2=1인것들.
    
     */
    private ArrayList<Integer>  fixArr;

	
	@Before
	public void makeFixNumberArr() {
		int [] numbers = {9,4,4,5,4,2,0,2,9,0,7,8,0,0,9,1};

		fixArr = new ArrayList<Integer>();
       
        for(Integer each :numbers){
            fixArr.add(each);
        }
		
	}
		
	@Test
	public void testDoubleEqualsEach(){			
		//DONE:㉠  카드 번호의 우측 숫자부터 매 2번째 숫자마다 2를 곱하고, 곱한값이 맞는지 확인.
		
	    ArrayList<Integer> doubledArr = new CardValidate().doubles(fixArr);
	    int fixArrSize = fixArr.size();
	    for(int i=0 ; i < fixArrSize ; i++){
	    	if(i%2 == fixArrSize % 2){
	    		assertTrue(new CardValidate().getIntInArr(doubledArr,i) == new CardValidate().getIntInArr(fixArr,i) * 2);
	    	}
	    }
	    
	}
	
	@Test
	public void testSum(){
		//DONE:  (㉠에서 나온 수가 2자리 수이면 2개의 숫자를 합한다).// {9,4,4,5,4,2,0,2,9,0,7,8,0,0,9,1}> {18,4,8,5,8,2,0,2,18,0,14,8,0,0,18,1};
					
		assertTrue( 1+8+4+8+5+8+2+0+2+1+8+0+1+4+8+0+0+1+8+1 == new CardValidate().getDoubledSum(fixArr));
		
	}
	
	@Test
	public void testCheck(){
		//DONE:  홀수열합 + 짝수열합 = 십의배수면 성공, 다른면 실패
		
		assertEquals((new CardValidate().checkSum(fixArr)+""),"0");
	
	}
}







//@Test
//public void testDoubleEquals(){
//	CardValidate cardValidate = new CardValidate();
//    ArrayList<Integer> doubledArr = cardValidate.doubles(fixArr);	    	        
//    assertTrue(cardValidate.getIntInArr(doubledArr,1) == cardValidate.getIntInArr(fixArr,1) * 2);
//}
//DONE:  ㉡위 ㉠에서 2를 곱하지 않은 숫자들과 ㉠에서 나온 숫자들을 합한다(㉠에서 나온 수가 2자리 수이면 2개의 숫자를 합한다). 합한게 맞냐?

//@Test
//public void testSumIsSum(){
//	CardValidate cardValidate = new CardValidate();
//	ArrayList<Integer> doubledArr = cardValidate.doubles(fixArr);
//	assertTrue( 9+8+4+10+4+4+0+4+9+0+7+16+0+0+9+2 == cardValidate.getSum(doubledArr));
//}

//@Test
//public void testSumConsiderDoubleDigit(){
//	//DONE:  (㉠에서 나온 수가 2자리 수이면 2개의 숫자를 합한다).// {9,4,4,5,4,2,0,2,9,0,7,8,0,0,9,1};		// {18,4,8,5,8,2,0,2,18,0,14,8,0,0,18,1};
//	CardValidate cardValidate = new CardValidate();
//	ArrayList<Integer> doubledArr = cardValidate.doubles(fixArr);	
//
//	assertTrue( 1+8+4+8+5+8+2+0+2+1+8+0+1+4+8+0+0+1+8+1 == cardValidate.getSum(doubledArr));
//}

//@Test
//public void testCheckSum(){
//	//DONE:  홀수열합 + 짝수열합 = 십의배수면 성공, 다른면 실패
//	CardValidate cardValidate = new CardValidate();
//	ArrayList<Integer> doubledArr = cardValidate.doubles(fixArr);
////	assertTrue( cardValidate.checkSum(doubledArr) == 0);
//	assertEquals((cardValidate.checkSum(doubledArr)+""),"0");
//
//}
	
