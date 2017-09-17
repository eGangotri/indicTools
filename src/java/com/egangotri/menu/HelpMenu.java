package com.egangotri.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.egangotri.transliteration.otherTransformations.RTFDocsSwingDisplayer;
import com.egangotri.util.CommonActions;
import com.egangotri.util.Project;

public class HelpMenu extends JMenu implements ActionListener
{
    JMenuItem        itransItem, aboutItem, notesItem, slpItem, hkItem, iastItem;
    
    Project project;
    
    public String aboutPro = "";
    
    public String jarFile;
    
    public HelpMenu(){
        this("", Project.SANDHI);
    }
    
    public HelpMenu(String aboutPro, Project proj){
        super("Help");
        this.aboutPro = aboutPro;
        this.project = proj;
        if(project.equals(Project.SANDHI)){
            jarFile = "sandhi.jar";
        }
        
        if(project.equals(Project.TRANSLITERATOR)){
            jarFile = "transliterator.jar";
        }
        
        aboutItem = new JMenuItem("About " + aboutPro);
        aboutItem.setActionCommand("about_item");
        aboutItem.addActionListener(this);

        itransItem = new JMenuItem("ITRANS Encoding Scheme");
        itransItem.setActionCommand("itrans_encoding");
        itransItem.addActionListener(this);

        slpItem = new JMenuItem("SLP Encoding Scheme");
        slpItem.setActionCommand("slp_encoding");
        slpItem.addActionListener(this);
        
        hkItem = new JMenuItem("HK Encoding Scheme");
        hkItem.setActionCommand("hk_encoding");
        hkItem.addActionListener(this);
        
        iastItem = new JMenuItem("IAST Encoding Scheme");
        iastItem.setActionCommand("iast_encoding");
        iastItem.addActionListener(this);

        notesItem = new JMenuItem("Notes");
        notesItem.setActionCommand("notes_item");
        notesItem.addActionListener(this);
        
        this.add(itransItem);
        this.add(slpItem);
        this.add(hkItem);
        this.add(iastItem);
        this.add(notesItem);
        this.add(aboutItem);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if ((e.getActionCommand()).equals("notes_item"))
        {
            String fileName = "Sandhi_Notes.rtf";
            if(project == Project.DICT){
                fileName = "Dictionary_Notes.rtf";
            }
            new RTFDocsSwingDisplayer("Notes on " + this.aboutPro, fileName );
        } 
        
        else if ((e.getActionCommand()).equals("about_item"))
        {
            String copyright = "\u00A9 2012 All Rights Reserved. Chetan Pandey\n" + "Pls. Contact taddhita_priya@yahoo.com for questions and suggestions.";
            JOptionPane.showMessageDialog(this, copyright, "About " + aboutPro, JOptionPane.PLAIN_MESSAGE);
        }

        else{
            CommonActions.performActions(e.getActionCommand());
        }
        
    }
}
