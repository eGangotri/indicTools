package com.egangotri.transliteration

import com.egangotri.constants.SLPConstants;

import java.util.ArrayList;
import java.util.Hashtable;

import com.egangotri.util.Log;


public class DvnToSLP
{
    private Hashtable<String, String> unicode;

    private Hashtable<String, String> matra;
    
    private final String halant = "\u094d"; 

    public DvnToSLP()
    {
        populateHashTable();
    }
    public void populateHashTable()
    {
        unicode = new Hashtable<String, String>();
        matra = new Hashtable<String, String>();

        matra.put( "\u093E" , "A");
        matra.put( "\u093F" , "i");
        matra.put("\u0940" , "I" );
        matra.put("\u0941" , "u"  );
        matra.put( "\u0942" ,"U" );
        matra.put( "\u0943" ,"f" );
        matra.put("\u0944" ,"F"  );
        matra.put("\u0962" ,"x"  );
        matra.put("\u0963" ,"X"  );
        matra.put("\u0947" ,"e"  );
        matra.put("\u0948" ,"E"  );
        matra.put("\u094b" ,"o"  );
        matra.put("\u094c" ,"O"  );

        
        unicode.put("\u0905" ,"a"  );
        unicode.put("\u0906" ,"A"  );
        unicode.put("\u0907" ,"i"  );
        unicode.put("\u0908" ,"I"  );
        unicode.put("\u0909" ,"u"  );
        unicode.put("\u090a" ,"U"  );
        unicode.put("\u090b" ,"f"  );
        unicode.put("\u0960" ,"F"  );
        unicode.put("\u090c" ,"x"  );
        unicode.put("\u0961" ,"X"  );
        unicode.put("\u090f" ,"e"  );
        unicode.put("\u0910" ,"E"  );
        unicode.put("\u0913" ,"o"  );
        unicode.put("\u0914" ,"O"  );
        
        unicode.put("\u0915" ,"ka"  );
        unicode.put("\u0916" ,"Ka"  );
        unicode.put("\u0917" ,"ga"  );
        unicode.put("\u0918" ,"Ga"  );
        unicode.put("\u0919" ,"Na"  );
        unicode.put("\u091a" ,"ca"  );
        unicode.put("\u091b" ,"Ca"  );
        unicode.put("\u091c" ,"ja"  );
        unicode.put("\u091d" ,"Ja"  );
        unicode.put("\u091e" ,"Ya"  );
        unicode.put("\u091f" ,"wa"  ); // Ta as in Tom
        unicode.put("\u0920" ,"Wa"  ); 
        unicode.put("\u0921" ,"qa"  ); // Da as in David
        unicode.put("\u0922" ,"Qa"  );
        unicode.put("\u0923" ,"Ra"  );
        unicode.put("\u0924" ,"ta"  ); // ta as in tamasha
        unicode.put("\u0925" ,"Ta"  ); // tha as in thanks
        unicode.put("\u0926" ,"da"  ); // da as in darvaaza
        unicode.put("\u0927" ,"Da"  ); // dha as in dhanusha
        unicode.put( "\u0928" ,"na" );
        unicode.put("\u092a" ,"pa"  );
        unicode.put( "\u092b" ,"Pa" );
        unicode.put("\u092c" ,"ba"  );
        unicode.put("\u092d" ,"Ba"  );
        unicode.put("\u092e" ,"ma"  );
        unicode.put("\u092f" ,"ya"  );
        unicode.put("\u0930" ,"ra"  );
        unicode.put("\u0932" ,"la"  );
        unicode.put( "\u0933", "La"); // the Marathi and Vedic 'L'
        unicode.put("\u0935" ,"va"  );
        unicode.put("\u0936" ,"Sa"  );
        unicode.put("\u0937" ,"za"  );
        unicode.put("\u0938" ,"sa"  );
        unicode.put("\u0939" ,"ha"  );
        unicode.put("\u0902" ,"M"  ); // anusvara
        unicode.put( "\u0903" ,"H" ); // visarga
        unicode.put( "\u0901" ,"~" ); // anunAsika - cchandra bindu using V to represent it\
        unicode.put("\u093d" ,"'"  ); // avagraha using "'"
        unicode.put( "\u0969" ,"3" ); // 3 equals to pluta

        //NOT PART OF SLP-1
        unicode.put("\u014F", "${SLPConstants.UPADHAMANIYA}");// Z equals to upadhamaniya
        unicode.put( "\u0CF1","${SLPConstants.JIHNVAMULIYA}");// V equals to jihvamuliya....but what character have u settled for jihvamuliya
        unicode.put( "\u0950","${SLPConstants.OM}"); // aum
        unicode.put( "\u0958","${SLPConstants.K_WITH_NUKTA}a"); // Urdu qaif
        unicode.put("\u0959","${SLPConstants.KH_WITH_NUKTA}a" ); //Urdu qhe
        unicode.put("\u095A","${SLPConstants.G_WITH_NUKTA}a" ); // Urdu gain
        unicode.put("\u095B","${SLPConstants.Z_WITH_NUKTA}a" ); //Urdu zal, ze, zoe
        unicode.put("\u095E","${SLPConstants.F_WITH_NUKTA}a" ); // Urdu f
        unicode.put("\u095C","${SLPConstants.D_HARD__WITH_BINDI}a" ); // Hindi 'dh' as in padh
        unicode.put( "\u095D","${SLPConstants.DH_HARD_WITH_BINDI}a"); // hindi dhh
        unicode.put("\u0926\u093C","${SLPConstants.D_SOFT_WITH_NUKTA}a" ); // Urdu dwad
        unicode.put("\u0924\u093C","${SLPConstants.T_SOFT_WITH_NUKTA}a"); // Urdu toe
        unicode.put("\u0938\u093C","${SLPConstants.S_SOFT_WITH_NUKTA}a"); // Urdu swad, se

        unicode.put("\u0966", "0");
        unicode.put("\u0967", "1");
        unicode.put("\u0968",  "2");
        unicode.put("\u0969", "3"); // 3 equals to pluta
        unicode.put("\u096A", "4");
        unicode.put("\u096B", "5");
        unicode.put("\u096C", "6");
        unicode.put("\u096D", "7");
        unicode.put("\u096E", "8");
        unicode.put("\u096F", "9");
    }

    public String transform(String dvnString)
    {
        int strLen = dvnString.length();
        ArrayList<String> shabda = new ArrayList<String>();
        String lastEntry = "";
        for (int i = 0; i < strLen; i++)
        {
            char c = dvnString.charAt(i);
            String varna = String.valueOf(c);
            
            if (unicode.containsKey(varna))
            {
                shabda.add(unicode.get(varna));
                lastEntry = unicode.get(varna);
                log.info("words now is " +  listToString(shabda));
            }
            else if (matra.containsKey(varna))
            {
                shabda.set(shabda.size() - 1, String.valueOf(lastEntry.charAt(0)));
                shabda.add(matra.get(varna));
                lastEntry = matra.get(varna);
            }
            
            else if(halant.equals(varna))
            {
                //log.info("before adding halant: lastEntry " + lastEntry + " word " + listToString(shabda) + ", size: " + shabda.size());
                shabda.set(shabda.size()-1, String.valueOf(lastEntry.charAt(0)));
                lastEntry = halant; 
                //log.info("after adding halant: lastEntry " + lastEntry + " word " + listToString(shabda) + "size: " + shabda.size());
            }
            
            else
            {
                shabda.add(varna);
                lastEntry = varna;
            }
            
        } // end of for
    
        String newString = listToString(shabda);
        //Discard the shabda array
        shabda = null;
        
        return newString; // return transformed;
    }

    public String listToString(ArrayList<String> shabda)
    {
        String s = "";
        for (String string: shabda)
        {
            s += string;
        }
        return s ;
    }


}
