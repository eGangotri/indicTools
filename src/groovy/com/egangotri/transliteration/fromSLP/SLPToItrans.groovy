package com.egangotri.transliteration.fromSLP

import groovy.util.logging.Slf4j
import org.apache.commons.lang3.StringUtils;
@Slf4j
public class SLPToItrans
{

public static String transform(String transformed)
	{
	
//	log.info("SLPToItrans: " + transformed  );


	transformed = StringUtils.replacePattern(transformed,"f", "6"); // if I make f == "RRi"
											//then RRi will later become NNI, 
											//hence storing in 6
	
	/***NOTE 1 ***/
	transformed = StringUtils.replacePattern(transformed,"N","5"); // N (kvargIya) -> 5 -> ~N
	/***Note 1 ***/
	
	transformed = StringUtils.replacePattern(transformed,"R","N");// confusion with .replaceAll("N","~N"), ref. note 1
														//  must be above replaceAll("f", "RRi");
	//transformed = StringUtils.replacePattern(transformed,"f", "RRi");
		
	transformed = StringUtils.replacePattern(transformed,"F","7");// same reason as above
	transformed = StringUtils.replacePattern(transformed,"x","LLi");
	transformed = StringUtils.replacePattern(transformed,"X","LLI");

	transformed = StringUtils.replacePattern(transformed,"E","ai");
	transformed = StringUtils.replacePattern(transformed,"O","au");
	transformed = StringUtils.replacePattern(transformed,"K","kh");

	transformed = StringUtils.replacePattern(transformed,"G","gh");

    transformed = StringUtils.replacePattern(transformed,"c","ch");
	transformed = StringUtils.replacePattern(transformed,"C","Ch");
	transformed = StringUtils.replacePattern(transformed,"J","jh");
	transformed = StringUtils.replacePattern(transformed,"Y","~n");

	transformed = StringUtils.replacePattern(transformed,"T","th"); // watch out!!!!
																// must be above .replaceAll("w","T")
	transformed = StringUtils.replacePattern(transformed,"D","dh");// watch out!!!!
																// must be above .replaceAll("q","D")
	transformed = StringUtils.replacePattern(transformed,"w","T");
	transformed = StringUtils.replacePattern(transformed,"W","Th");
	transformed = StringUtils.replacePattern(transformed,"q","D");
	transformed = StringUtils.replacePattern(transformed,"Q","Dh");
																	

	transformed = StringUtils.replacePattern(transformed,"P","ph");
	transformed = StringUtils.replacePattern(transformed,"B","bh");
	
	transformed = StringUtils.replacePattern(transformed,"S","sh");
	transformed = StringUtils.replacePattern(transformed,"z","Sh");
	
	
	transformed = StringUtils.replacePattern(transformed,"~",".N"); // chandrabindu
	transformed = StringUtils.replacePattern(transformed,"'", ".a");	// avagraha
	
	transformed = StringUtils.replacePattern(transformed,"5","~N"); // refer to NOTE 1, 5 -> ~N ( kavargIya )
													//must be below ...replaceAll("~",".N") otherwise confusion

				
	
	transformed = StringUtils.replacePattern(transformed,"6", "RRi");
	transformed = StringUtils.replacePattern(transformed,"7", "RRI");
	
	//log.info("SLPToItrans: transformed" +  transformed );
	return transformed; // return transformed;
	}

}
