package com.egangotri.transliteration

import org.apache.commons.lang3.StringUtils;

public class KrutiToeLatin
{
String transformed;

public KrutiToeLatin()
	{
		transformed = "";
	}

public String transform(String s1)
	{
		
	transformed = s1;

	transformed = StringUtils.replacePattern(transformed,"\\.a","'");   // SLP for avagraha,,,,,using from own system
										// watch out!!!! use "\\.a" not ".a"
	transformed = StringUtils.replacePattern(transformed,"RRi","f");
	
	transformed = StringUtils.replacePattern(transformed,"RRI","F");
	transformed = StringUtils.replacePattern(transformed,"LLi","x");
	transformed = StringUtils.replacePattern(transformed,"LLI","X");

	transformed = StringUtils.replacePattern(transformed,"ai","E");
	transformed = StringUtils.replacePattern(transformed,"au","O");
	transformed = StringUtils.replacePattern(transformed,"kh","K");

	transformed = StringUtils.replacePattern(transformed,"gh","G");
		
	
	/***NOTE 1 ***/
	// we have to convert ITRANS '~N' - SKT LIB 'N' but confuses with ITRANS 'N'
	//therefore mdifying
	//transformed = StringUtils.replacePattern(transformed,"~N","N"); // watch out!!!!
	// to
	transformed = StringUtils.replacePattern(transformed,"~N","5"); // itrans N is fifth of T-vargas, hence 5
	// SKT LIB 'N' = 5, later 5 back again to 'N' at the end

	/***Note 1 ***/
	transformed = StringUtils.replacePattern(transformed,"\\.N","~"); // chandra-bindu...watch out do not just use .N use \\.N
													// must be below .replaceAll("~N","5")
	transformed = StringUtils.replacePattern(transformed,"Dh","Q"); // must be before .replaceAll("dh","D");
	transformed = StringUtils.replacePattern(transformed,"Th","W"); // must be before .replaceAll("th","T");
	transformed = StringUtils.replacePattern(transformed,"Ch","C");
	transformed = StringUtils.replacePattern(transformed,"jh","J");
	transformed = StringUtils.replacePattern(transformed,"~n","Y");
	transformed = StringUtils.replacePattern(transformed,"T","w");
	
	transformed = StringUtils.replacePattern(transformed,"D","q");
	
	transformed = StringUtils.replacePattern(transformed,"N","R");// confusion with .replaceAll("~N","N")
																	
	transformed = StringUtils.replacePattern(transformed,"th","T"); // watch out!!!!
	transformed = StringUtils.replacePattern(transformed,"dh","D");// watch out!!!!
	transformed = StringUtils.replacePattern(transformed,"ph","P");
	transformed = StringUtils.replacePattern(transformed,"bh","B");
	transformed = StringUtils.replacePattern(transformed,"S","z");// must be above .replaceAll("sh","S")
																	// to avoid confusion

	transformed = StringUtils.replacePattern(transformed,"sh","S");// watchout!!!!
	


	transformed = StringUtils.replacePattern(transformed,"5","N"); // refer to NOTE 1

		
	// return transformed;
	return transformed;
	}
}
