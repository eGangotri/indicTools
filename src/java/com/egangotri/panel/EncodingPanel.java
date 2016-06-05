package com.egangotri.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.egangotri.constants.Constants;
import com.egangotri.util.Log;

public class EncodingPanel extends JPanel implements ActionListener
{
    JRadioButton               itransRB, slpRB, hkRB, dvnRB, iastRB, velthuisRB;
    
    private String encoding = Constants.DEFAULT_ENCODING;
    
    public EncodingPanel(){
        super();
        // JRadioButtons
        itransRB = new JRadioButton(Constants.ITRANS);
        itransRB.setSelected(true);
        itransRB.setActionCommand("itransRB");
        itransRB.addActionListener(this);

        slpRB = new JRadioButton(Constants.SLP);
        slpRB.setActionCommand("slpRB");
        slpRB.addActionListener(this);

        hkRB = new JRadioButton(Constants.HK);
        hkRB.setActionCommand("hkRB");
        hkRB.addActionListener(this);

        dvnRB = new JRadioButton(Constants.UNICODE_DVN);
        dvnRB.setActionCommand("dvnRB");
        dvnRB.addActionListener(this);

        iastRB = new JRadioButton(Constants.IAST);
        iastRB.setActionCommand("iastRB");
        iastRB.addActionListener(this); 

        velthuisRB = new JRadioButton(Constants.VELTHUIS);
        velthuisRB.setActionCommand("velthuisRB");
        velthuisRB.addActionListener(this); 

        // Group the radio buttons.
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(itransRB);
        buttonGroup.add(slpRB);
        buttonGroup.add(hkRB);
        buttonGroup.add(dvnRB);
        buttonGroup.add(iastRB);
        buttonGroup.add(velthuisRB);
        
        this.add(itransRB);
        this.add(slpRB);
        this.add(hkRB);
        this.add(dvnRB);
        this.add(iastRB);;
        this.add(velthuisRB);
    }

   
    public void setEncodingRB(String encoding){
        if(encoding.equals(Constants.SLP)){
            slpRB.setSelected(true);
        }
        else if(encoding.equals(Constants.HK)){
            hkRB.setSelected(true);
        }
        else if(encoding.equals(Constants.UNICODE_DVN)){
            dvnRB.setSelected(true);
        }
        else if(encoding.equals(Constants.IAST)){
            iastRB.setSelected(true);
        }
        else if(encoding.equals(Constants.VELTHUIS)){
            iastRB.setSelected(true);
        }
        else{
            itransRB.setSelected(true);
        }
        Log.logInfo("Encoding set to " + encoding);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
      //clearTextFields();
        if ((e.getActionCommand()).equals("itransRB"))
        {
            encoding = Constants.ITRANS;
        }
        else if ((e.getActionCommand()).equals("slpRB"))
        {
            encoding = Constants.SLP;
        }
        else if ((e.getActionCommand()).equals("hkRB"))
        {
            encoding = Constants.HK;
        }
        else if ((e.getActionCommand()).equals("dvnRB"))
        {
            encoding = Constants.UNICODE_DVN;
        }
        else if ((e.getActionCommand()).equals("iastRB"))
        {
            encoding = Constants.IAST;
        }        
        else if ((e.getActionCommand()).equals("velthuisRB"))
        {
            encoding = Constants.VELTHUIS;
        }        
    }

    public String getEncoding()
    {
        return encoding;
    }


    public void setEncoding(String encoding)
    {
        this.encoding = encoding;
    }
    
    public void setEncodingToDefault(){
        encoding = Constants.DEFAULT_ENCODING;
        itransRB.setSelected(true);
    }
}
