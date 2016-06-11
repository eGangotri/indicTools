package com.egangotri.sandhi;

import com.egangotri.util.ConsonantUtil;
import com.egangotri.util.Log;
import com.egangotri.util.VisargaUtil;
import com.egangotri.util.VowelUtil;

public class SandhiMaker
{
    private String      sandhiKrt;

    private String      sandhiNotes;

    public SandhiMaker(String p1, String p2, boolean padanta, boolean pragrhya)
    {
        sandhiNotes = "No Notes";
        sandhiKrt = combineIntoSandhi(p1, p2, padanta, pragrhya);
    }

    public String combineIntoSandhi(String anta, String adi, boolean padanta, boolean pragrhya)
    {

        Log.info(" anta == " + anta + " adi == " + adi);
        String returnString = anta + adi;

        if (anta == null || adi == null || adi.length() == 0 || anta.length() == 0) return returnString;

        try
        {

            if (VowelUtil.isAjanta(anta) && VowelUtil.isAjadi(adi))
            {
                Log.info(" Sending for Vowel Sandhi");
                VowelSandhi vowelSandhi = new VowelSandhi(anta, adi, pragrhya);
                returnString = vowelSandhi.getCombinedSandhiForm();
                sandhiNotes = vowelSandhi.getNotes();
            }

            else if (VisargaUtil.isVisarganta(anta))
            {
                Log.info(" Sending for Visarga Sandhi");
                VisargaDisplay visargaSandhi = new VisargaDisplay(anta, adi, padanta, pragrhya);
                returnString = visargaSandhi.getCombinedSandhiForm();
                sandhiNotes = visargaSandhi.getNotes();
                Log.info(" Quitting Visarga Sandhi: " + returnString);
            }

            else if (ConsonantUtil.is_halanta(anta) || ConsonantUtil.is_haladi(adi))
            {
                Log.info(" Sending for Consonant Sandhi");
                ConsonantSandhi consonantSandhi = new ConsonantSandhi(anta, adi, padanta);
                returnString = consonantSandhi.getCombinedSandhiForm();
                sandhiNotes = consonantSandhi.getNotes();
                Log.info(" Quitting Consonant Sandhi: " + returnString);
            }

            else if ((ConsonantUtil.is_halanta(anta) || VowelUtil.isAjanta(anta)) && (VowelUtil.isAjadi(adi) || ConsonantUtil.is_haladi(adi)))

            {
                Log.info(" Sending for Vowel-Consonant Sandhi");
                VisargaDisplay vs = new VisargaDisplay(anta, adi, padanta, pragrhya);
                returnString = vs.getCombinedSandhiForm();
                sandhiNotes = vs.getNotes();
            }

            Log.info("i m leaving sandhimaker.make_sandhi::::" + returnString);

        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        return returnString;

    }

    public String getSandhiCombinedForm()
    {
        return sandhiKrt;
    }

    // *******************END OF FUNCTION**********************//

    // *******************BEGINNING OF FUNCTION********************//
    public String getSandhiNotes()
    {
        return sandhiNotes;
    }

    // *******************END OF FUNCTION**********************//

} // end of class
