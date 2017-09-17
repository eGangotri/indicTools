package com.egangotri.transliteration.toSLP

import org.apache.commons.lang3.StringUtils;

public class ItransToSLP
{

    public static String transform(String transformed)
    {
        transformed = StringUtils.replacePattern(transformed,"AUM", "Ω"); // omega or Ohm
        transformed = StringUtils.replacePattern(transformed,"OM", "Ω"); // Omega or Ohm
        transformed = StringUtils.replacePattern(transformed,"q", "κ"); // Greek kappa
        transformed = StringUtils.replacePattern(transformed,"K", "Κ"); // Greek Capital Kappa
        transformed = StringUtils.replacePattern(transformed,"G", "γ"); // gamma
        transformed = StringUtils.replacePattern(transformed,"z", "ζ"); // Zeta
        transformed = StringUtils.replacePattern(transformed,"J", "ζ"); // Zeta
        transformed = StringUtils.replacePattern(transformed,"f", "φ"); // phi
        transformed = StringUtils.replacePattern(transformed,"\\.Dh", "Δ"); // Capital Delta
        transformed = StringUtils.replacePattern(transformed,"\\.D", "δ"); // delta
        transformed = StringUtils.replacePattern(transformed,"\\.d", "τ"); // tau
        transformed = StringUtils.replacePattern(transformed,"\\.t", "θ"); // theta
        transformed = StringUtils.replacePattern(transformed,"\\.s", "σ"); // sigma
        // transformed = StringUtils.replacePattern(transformed,"\\.c", "ω"); //omega



        //Special Situation where you dont want the vowels to merge but remain separate entities
        transformed = StringUtils.replacePattern(transformed,"\\{a\\}", "a");
        transformed = StringUtils.replacePattern(transformed,"\\{aa\\}", "A");
        transformed = StringUtils.replacePattern(transformed,"\\{A\\}", "A");
        transformed = StringUtils.replacePattern(transformed,"\\{i\\}", "i");
        transformed = StringUtils.replacePattern(transformed,"\\{ii\\}", "I");
        transformed = StringUtils.replacePattern(transformed,"\\{I\\}", "I");
        transformed = StringUtils.replacePattern(transformed,"\\{I\\}", "I");

        transformed = StringUtils.replacePattern(transformed,"\\{u\\}", "u");
        transformed = StringUtils.replacePattern(transformed,"\\{uu\\}", "U");
        transformed = StringUtils.replacePattern(transformed,"\\{U\\}", "U");

        transformed = StringUtils.replacePattern(transformed,"\\{RRi\\}", "f");
        transformed = StringUtils.replacePattern(transformed,"\\{RRI\\}", "F");
        transformed = StringUtils.replacePattern(transformed,"\\{LLi\\}", "x");
        transformed = StringUtils.replacePattern(transformed,"\\{LLI\\}", "X");

        transformed = StringUtils.replacePattern(transformed,"\\{e\\}", "e");
        transformed = StringUtils.replacePattern(transformed,"\\{ai\\}", "E");
        transformed = StringUtils.replacePattern(transformed,"\\{o\\}", "X");
        transformed = StringUtils.replacePattern(transformed,"\\{au\\}", "X");

        //Vowels
        transformed = StringUtils.replacePattern(transformed,"RRi", "f");

        transformed = StringUtils.replacePattern(transformed,"RRI", "F");
        transformed = StringUtils.replacePattern(transformed,"LLi", "x");
        transformed = StringUtils.replacePattern(transformed,"LLI", "X");

        transformed = StringUtils.replacePattern(transformed,"ai", "E");
        transformed = StringUtils.replacePattern(transformed,"au", "O");

        //Consonants
        transformed = StringUtils.replacePattern(transformed,"kh", "K");

        transformed = StringUtils.replacePattern(transformed,"gh", "G");

        /** *NOTE 1 ** */
        // we have to convert ITRANS '~N' - SKT LIB 'N' but confuses with ITRANS
        // 'N'
        // therefore mdifying
        // transformed = StringUtils.replacePattern(transformed,"~N","N"); // watch out!!!!
        // to
        transformed = StringUtils.replacePattern(transformed,"~N", "@@"); // itrans N is fifth
        // of T-vargas,
        // hence @@
        // SKT LIB 'N' = @@, later @@ back again to 'N' at the end

        /** *Note 1 ** */
        transformed = StringUtils.replacePattern(transformed,"\\.N", "~"); // chandra-bindu...watch
        // out do not just
        // use .N use \\.N
        // must be below .replaceAll("~N","5")
        transformed = StringUtils.replacePattern(transformed,"Dh", "Q"); // must be before
        // .replaceAll("dh","D");
        transformed = StringUtils.replacePattern(transformed,"Th", "W"); // must be before
        // .replaceAll("th","T");
        // transformed = StringUtils.replacePattern(transformed,"Ch","C");
        transformed = StringUtils.replacePattern(transformed,"jh", "J");
        transformed = StringUtils.replacePattern(transformed,"~n", "Y");
        transformed = StringUtils.replacePattern(transformed,"T", "w");

        transformed = StringUtils.replacePattern(transformed,"D", "q");

        transformed = StringUtils.replacePattern(transformed,"N", "R");// confusion with
        // .replaceAll("~N","N")

        transformed = StringUtils.replacePattern(transformed,"th", "T"); // watch out!!!!
        transformed = StringUtils.replacePattern(transformed,"dh", "D");// watch out!!!!
        transformed = StringUtils.replacePattern(transformed,"ph", "P");
        transformed = StringUtils.replacePattern(transformed,"bh", "B");

        transformed = StringUtils.replacePattern(transformed,"Sh", "z");
        transformed = StringUtils.replacePattern(transformed,"sh", "S");
        transformed = StringUtils.replacePattern(transformed,"@@", "N"); // refer to NOTE 1






        // log.info("I2S after : " + transformed);
        // return transformed;
        return transformed;
    }
}
