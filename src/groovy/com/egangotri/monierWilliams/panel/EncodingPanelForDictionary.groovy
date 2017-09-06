package com.egangotri.monierWilliams.panel

import com.egangotri.monierWilliams.dict.MWSktEngDictionary
import com.egangotri.panel.EncodingPanel

import java.awt.event.ActionEvent

public class EncodingPanelForDictionary extends EncodingPanel
{
    MWSktEngDictionary dict;
    public EncodingPanelForDictionary(MWSktEngDictionary dict){
        super();
        this.dict = dict;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        super.actionPerformed(e);
        dict.clearTextFields();
    }
}
