package com.egangotri.pratyahara;

import com.egangotri.panel.EncodingPanelForPratyahara;
import com.egangotri.sandhi.SandhiJFrame;
import com.egangotri.transliteration.RTFDocsSwingDisplayer;
import com.egangotri.util.EncodingUtil;

import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

public class PratyahaarJFrame extends JFrame implements ActionListener, KeyListener, ItemListener
{

    JMenuBar          menubar  = new JMenuBar();

    JMenu             file, help;
    
    JMenuItem         back_item, itrans_item, about_item, slp_item,
            description;

    JLabel            l1a, l1b, l1c, l2, plus, equal, plus1, equal1;

    JTextField        tf1, tf4;

    JPanel            p1, p2, p3, p4, p5, p6, p7;

    JButton           b1;

    JButton           b2;

    JButton           b3;

    JTextArea         tb1;

    JCheckBox         markerChkBox;

    EncodingUtil encod;

    PratyaharaDecoder pratyahara;
    
    EncodingPanelForPratyahara encodingPanel;
    
    public PratyahaarJFrame()
    {
        super("Pratyahara Decoder");
        setSize(650, 550);

        // Initialization
        pratyahara = new PratyaharaDecoder();
        encod = new EncodingUtil();
        
        // menubar
        menubar = new JMenuBar();

        encodingPanel = new EncodingPanelForPratyahara(this);
        // menus
        file = new JMenu("File");
        help = new JMenu("Help");

        // menuitems
        description = new JMenuItem("Siva Sutras of Panini");
        description.setActionCommand("description");
        description.addActionListener(this);

        back_item = new JMenuItem("Back");
        back_item.setActionCommand("back");
        back_item.addActionListener(this);

        // add menuitems to menus
        file.add(back_item);
        help.add(description);

        // add menus to menubar
        menubar.add(file);
        menubar.add(help);
        // menus end

        // Panel Initialization
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        p7 = new JPanel();

        Container contentPane = getContentPane();

        // JLabels
        l1a = new JLabel("Please enter a pratyahAra");
        l2 = new JLabel("Notes:");
        plus = new JLabel(" + ");
        equal = new JLabel(" = ");

        // JTextArea
        tf1 = new JTextField(4);
        tf1.addKeyListener(this);
        tf1.setText("al");
        tf4 = new JTextField(4);
        // tf4.addKeyListener(this);
        tf4.setEditable(false);
        tf4.setText(EncodingUtil.convertRawItransToDevanagari(tf1.getText()));

        // Check Boxes
        markerChkBox = new JCheckBox("Hide Markers.");
        markerChkBox.setActionCommand("marker_chk");
        markerChkBox.setSelected(false);
        markerChkBox.setToolTipText("Do not display the 'it'-markers.");
        markerChkBox.addItemListener(this);

        // Buttons
        b1 = new JButton("Enter");
        b1.setActionCommand("Enter");
        b1.setToolTipText("Enter two words.");
        b2 = new JButton("Clear");
        b2.setActionCommand("clear");
        b2.setToolTipText("Clear all Text Fields");
        b3 = new JButton("Back");
        b3.setActionCommand("back");
        b3.setToolTipText("Quit the Application.");

        tb1 = new JTextArea(14, 45);
        tb1.setLineWrap(true);
        tb1.setWrapStyleWord(true);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // adding Components to JPanel
        p1.add(l1a);
        p2.add(tf1);
        p2.add(tf4);
        p2.add(markerChkBox);
        p5.add(b1);
        p5.add(b2);
        p5.add(b3);
        p6.add(l2);
        p7.add(new JScrollPane(tb1));

        this.setJMenuBar(menubar);

        // add panels to contentpane
        contentPane.add(p1);
        contentPane.add(p2);
        contentPane.add(encodingPanel);
        contentPane.add(p3);
        contentPane.add(p5);
        contentPane.add(p6);
        contentPane.add(p7);

        this.setVisible(true);
    }

    // *******************END OF FUNCTION**********************//
    /** ************************************************************* */

    public void itemStateChanged(ItemEvent e)
    {

        Object source = e.getItemSelectable();
        if (source == markerChkBox)
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
            {
                tb1.setText("The 'it' markers will not be displayed.");
            }
            else if (e.getStateChange() == ItemEvent.DESELECTED)
            {
                tb1.setText("The 'it' markers will be displayed.");
            }

        }
    } // end of itemStateChanged

    // The three events
    public void keyTyped(KeyEvent e)
    {
    }

    public void keyPressed(KeyEvent e)
    {
    }

    public void keyReleased(KeyEvent e)
    {
        if (e.getComponent() == this.tf1)
        {
            
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                tb1.setText(pratyahara.decodePratyahara(EncodingUtil.convertToSLP(tf1.getText().trim(), encodingPanel.getEncoding()), markerChkBox.isSelected()));
            }
            else
            {
                tf4.setText(EncodingUtil.convertToDVN(tf1.getText().trim(), encodingPanel.getEncoding()));
            }
        }

    }

    // *******************END OF FUNCTION**********************//

    // *******************BEGINNING OF FUNCTION********************//
    public void actionPerformed(ActionEvent e)
    {
        String actionCmd = e.getActionCommand();
        
        if (actionCmd.equals("Enter"))
        {
            tb1.setText(pratyahara.decodePratyahara(EncodingUtil.convertToSLP(tf1.getText().trim(), encodingPanel.getEncoding()), markerChkBox.isSelected()));
        }

        else if (actionCmd.equals("clear"))
        {
            clear();
        }

        else if (actionCmd.equals("back"))
        {
            this.dispose();
        } 

        else if (actionCmd.equals("description"))
        {
            new RTFDocsSwingDisplayer("The Siva Sutras of Panini", SandhiJFrame.DOC_PATH + "siva.rtf", "sandhi.jar");
        } 

    }

    public void clear()
    {
        encodingPanel.setEncodingToDefault();
        markerChkBox.setSelected(false);
        clearTxtFields();
    }
    
    public void clearTxtFields()
    {
        tf1.setText("");
        tf4.setText("");
        tb1.setText("");
    }

} // end of pratyahaar
