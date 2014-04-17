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
	
}
