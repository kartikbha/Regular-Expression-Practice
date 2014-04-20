package com.reg.ex.test;

import org.junit.Assert;
import org.junit.Test;

import com.reg.ex.RegExSample;

public class RegExSampleTest {
	
	@Test
	public void extractQuotationTextTest1(){
		String questionText = RegExSample.extractQuotationText("how much is pish tegj glob glob ?");
		Assert.assertEquals("pish tegj glob glob",questionText.trim());
	}

	
	@Test
	public void extractQuotationTextTest2(){
		String questionText = RegExSample.extractQuotationText("how many Credits is glob prok silver ?");
		Assert.assertEquals("glob prok silver",questionText.trim());
	}
	
	@Test
	public void greedyIdentifierTest(){
		
		String inputTexts = RegExSample.readFile("C:/Users/Kartik/reg-ex/Regular-Expression-Practice/reg-ex/src/13chil.txt");
		RegExSample.regExPatternExecutor(inputTexts,".*\\bgood\\b.*?");
	
	}
	
	
	@Test
	public void findDateFormatMM_DD_YY(){
		
		String inputTexts = RegExSample.readFile("C:/Users/Kartik/reg-ex/Regular-Expression-Practice/reg-ex/src/dateFormats.txt");
		// not valid as it also match - 12345678.   3 & 6 on place holder .
		//RegExSample.regExPatternExecutor(inputTexts,"\\d\\d.\\d\\d.\\d\\d");
		
		// matches 23/34/23
		//RegExSample.regExPatternExecutor(inputTexts,"\\d\\d[-/]\\d\\d[-/]\\d\\d");
	}
	
	@Test
	public void IpAddressText(){
		
		String inputTexts = RegExSample.readFile("C:/Users/Kartik/reg-ex/Regular-Expression-Practice/reg-ex/src/IpAddress.txt");
		// ip address format - 255.x.x.x - forward +ve look ahead. find ips where ip does have 255 as start.
		// RegExSample.regExPatternExecutor(inputTexts,"(?=255)(\\d*).(\\d*).(\\d*).(\\d*)");
		// better way is to use  [.] instead.
		// ip address format - 255.x.x.x - forward -ve look ahead - fine ips where ip doesn't have 255 as start.
		RegExSample.regExPatternExecutor(inputTexts,"(?!255)(\\d*)[.](\\d*)[.](\\d*)[.](\\d*)");
		// ip address format - 255.x.x.x - forward -ve look ahead - fine ips where ip doesn't have 255 as start.
		//RegExSample.regExPatternExecutor(inputTexts,"(\\d*)[.](?<=255)[.](\\d*)[.](\\d*)");
		
	}
	
	@Test
	public void readTest(){
		String readText = RegExSample.readFile("C:/Users/Kartik/reg-ex/Regular-Expression-Practice/reg-ex/src/13chil.txt");
		System.out.println("read text "+ readText);
	}
	
}
