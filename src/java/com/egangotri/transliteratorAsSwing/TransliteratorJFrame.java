package com.egangotri.transliteratorAsSwing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.PlainDocument;
import javax.swing.text.rtf.RTFEditorKit;

import com.egangotri.util.Constants;
import org.apache.commons.lang3.text.WordUtils;

import com.egangotri.sandhi.DisplayMessage;
import com.egangotri.sandhi.SandhiJFrame;
import com.egangotri.transliteration.RTFDocsSwingDisplayer;
import com.egangotri.util.EncodingUtil;
import com.egangotri.util.Log;

public class TransliteratorJFrame extends JFrame implements ActionListener, KeyListener, ItemListener, ClipboardOwner
{

    JMenuBar menubar = new JMenuBar();

    JMenu    file, edit, help, encodingMenu;

    JMenuItem exitItem, aboutItem, notesItem;
    JMenuItem itransItem, slpItem, hkItem, velthiusItem, dvnItem, iastItem;

    JMenuItem  save_1, save_2, save_3, open_1,
            open_2, open_3;

     JMenuItem  clipboard1,
                    clipboard2, clipboard3;

    JLabel    label1, label2, label3;

    JCheckBoxMenuItem useItrans, useSLP, useHK, useVelthuis, useDevanagari, useIAST;

    JButton           refreshButton, clearButton, exitButton;

    JPanel            p1, p2, p3, p4, p5, p6, p6a, p7;

    JTextArea         tb1, tb2, tb3;
    
    JCheckBox capitalize;

    static String     encoding = EncodingUtil.ITRANS;

    JTextPane         textPane;

    boolean capitalizeIAST = false;

    public TransliteratorJFrame()
    {
        super("Devanagari Transliterator");

        PrintWriter pw = new PrintWriter(System.out, true);
        setSize(650, 650);

        // menubar
        menubar = new JMenuBar();

        // menus
        file = new JMenu("File");
        edit = new JMenu("Edit");
        encodingMenu = new JMenu("Encoding");
        help = new JMenu("Help");

        // JMenuItem
        save_1 = new JMenuItem("Save Roman Text");
        save_1.setActionCommand("save_1");
        save_1.addActionListener(this);

        save_2 = new JMenuItem("Save Devanagari Text");
        save_2.setActionCommand("save_2");
        save_2.addActionListener(this);

        save_3 = new JMenuItem("Save Extended Latin Text");
        save_3.setActionCommand("save_3");
        save_3.addActionListener(this);

        open_1 = new JMenuItem("Open Roman Text in Area 1");
        open_1.setActionCommand("open_1");
        open_1.addActionListener(this);

        open_2 = new JMenuItem("Open Devanagari Text in Area 2");
        open_2.setActionCommand("open_2");
        open_2.addActionListener(this);

        open_3 = new JMenuItem("Open Extended Latin Text in Area 3");
        open_3.setActionCommand("open_3");
        open_3.addActionListener(this);

        exitItem = new JMenuItem("Exit");
        exitItem.setActionCommand("exit_item");
        exitItem.addActionListener(this);

        clipboard1 = new JMenuItem("Copy Roman Text");
        clipboard1.setActionCommand("clipboard1");
        clipboard1.addActionListener(this);

        clipboard2 = new JMenuItem("Copy Devanagari Text");
        clipboard2.setActionCommand("clipboard2");
        clipboard2.addActionListener(this);

        clipboard3 = new JMenuItem("Copy elatin Text");
        clipboard3.setActionCommand("clipboard3");
        clipboard3.addActionListener(this);

        aboutItem = new JMenuItem("About Transliterator Program");
        aboutItem.setActionCommand("about_item");
        aboutItem.addActionListener(this);

        itransItem = new JMenuItem("ITRANS ENCODING SCHEME");
        itransItem.setActionCommand("itrans_encoding");
        itransItem.addActionListener(this);

        slpItem = new JMenuItem("SLP ENCODING SCHEME");
        slpItem.setActionCommand("slp_encoding");
        slpItem.addActionListener(this);

        hkItem = new JMenuItem("Harvard Kyoto ENCODING SCHEME");
        hkItem.setActionCommand("hk_encoding");
        hkItem.addActionListener(this);

        velthiusItem = new JMenuItem("Velthius ENCODING SCHEME");
        velthiusItem.setActionCommand("vl_encoding");
        velthiusItem.addActionListener(this);

        dvnItem = new JMenuItem("Devanagari ENCODING SCHEME");
        dvnItem.setActionCommand("dvn_encoding");
        dvnItem.addActionListener(this);

        iastItem = new JMenuItem("IAST ENCODING SCHEME");
        iastItem.setActionCommand("iast_encoding");
        iastItem.addActionListener(this);

        notesItem = new JMenuItem("Notes");
        notesItem.setActionCommand("notes_item");
        notesItem.addActionListener(this);

        // JCheckBoxMenuItems
        useItrans = new JCheckBoxMenuItem("USE ITRANS");
        useItrans.setActionCommand("useItrans");
        useItrans.setSelected(true);
        useItrans.setEnabled(false);
        useItrans.addItemListener(this);

        useSLP = new JCheckBoxMenuItem("USE SLP");
        useSLP.setActionCommand("useSLP");
        useSLP.setSelected(false);
        useSLP.addItemListener(this);

        useHK = new JCheckBoxMenuItem("USE Harvard Kyoto");
        useHK.setActionCommand("useHK");
        useHK.setSelected(false);
        useHK.addItemListener(this);
        
        useVelthuis = new JCheckBoxMenuItem("USE Velthuis");
        useVelthuis.setActionCommand("useVelthuis");
        useVelthuis.setSelected(false);
        useVelthuis.addItemListener(this);

        useDevanagari = new JCheckBoxMenuItem("USE Devanagari");
        useDevanagari.setActionCommand("useDevanagari");
        useDevanagari.setSelected(false);
        useDevanagari.addItemListener(this);

        useIAST = new JCheckBoxMenuItem("USE IAST");
        useIAST.setActionCommand("useIAST");
        useIAST.setSelected(false);
        useIAST.addItemListener(this);

        // add menuitems to menu
        file.add(open_1);
        file.add(save_1);
        file.add(save_2);
        file.add(save_3);
        // file.add(open_2);
        // file.add(open_3);
        file.add(exitItem);

        edit.add(clipboard1);
        edit.add(clipboard2);
        edit.add(clipboard3);

        encodingMenu.add(useItrans);
        encodingMenu.add(useSLP);
        encodingMenu.add(useHK);
        encodingMenu.add(useVelthuis);
        encodingMenu.add(useDevanagari);
        encodingMenu.add(useIAST);


        help.add(notesItem);
        help.add(aboutItem);
        help.add(itransItem);
        help.add(slpItem);
        help.add(hkItem);
        help.add(velthiusItem);
        help.add(dvnItem);
        help.add(iastItem);


        // add menus to menubar
        menubar.add(file);
        menubar.add(edit);
        menubar.add(encodingMenu);
        menubar.add(help);
        // menus end

        // JPanel Initilization
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        p6a = new JPanel();
        p7 = new JPanel();

        // JLabel Initialization
        label1 = new JLabel("Area 1 For Roman Input:");
        label2 = new JLabel("Area 2 For Devanagari Output:");
        label3 = new JLabel("Area 3 For Extended Latin Output:");
        
        capitalize = new JCheckBox("Capitalize Extended Latin");
        capitalize.setSelected(capitalizeIAST);
        capitalize.setActionCommand("capitalize");
        capitalize.addActionListener(this);
        
        // Buttons
        clearButton = new JButton("Clear");
        clearButton.setActionCommand("clear");
        clearButton.setToolTipText("Clear all Fields");

        refreshButton = new JButton("Refresh");
        refreshButton.setActionCommand("refresh");
        refreshButton.setToolTipText("Refesh the View");

        exitButton = new JButton("Exit");
        exitButton.setActionCommand("Exit");
        exitButton.setToolTipText("Quit the Application.");

        clipboard1.addActionListener(this);
        clipboard2.addActionListener(this);
        clipboard3.addActionListener(this);
        clearButton.addActionListener(this);
        refreshButton.addActionListener(this);
        exitButton.addActionListener(this);

        /*
         * open_button = new JButton("Open");
         * open_button.setActionCommand("open");
         * open_button.setToolTipText("Open File");
         * 
         * save_button = new JButton("Save");
         * save_button.setActionCommand("save");
         * save_button.setToolTipText("Save File.");
         * save_button.setEnabled(false);
         * 
         * saveas_button = new JButton("Save As");
         * saveas_button.setActionCommand("save_as");
         * saveas_button.setToolTipText("Save File As.");
         * 
         * 
         * open_button.addActionListener(this) ;
         * save_button.addActionListener(this) ;
         * saveas_button.addActionListener(this) ;
         */

        Container contentPane = getContentPane();
        // JTextBox
        tb1 = new JTextArea(new PlainDocument(), null, 6, 45);
        tb1.setLineWrap(true);
        tb1.setWrapStyleWord(true);
        tb1.addKeyListener(this);

        tb2 = new JTextArea(new PlainDocument(), null, 6, 45);
        tb2.setLineWrap(true);
        tb2.setWrapStyleWord(true);
        tb2.addKeyListener(this);

        tb3 = new JTextArea(new PlainDocument(), null, 6, 45);
        tb3.setLineWrap(true);
        tb3.setWrapStyleWord(true);
        tb3.addKeyListener(this);

        // Setting Fonts
        Font unicodeFont = new Font(Constants.ARIAL_UNICODE_MS, Font.PLAIN, Constants.FONT_SIZE);
        tb1.setFont(unicodeFont);
        tb2.setFont(unicodeFont);
        tb3.setFont(unicodeFont);

        /** *EXPERIMENT*** */
        textPane = new JTextPane();
        RTFEditorKit rtfkit = new RTFEditorKit();
        // HTMLEditorKit htmlkit = new HTMLEditorKit();
        textPane.setEditorKit(rtfkit); // set Kit which will read RTF Doc
        // textPane.setEditorKit(htmlkit);
        textPane.setEditable(false); // make uneditable
        textPane.setPreferredSize(new Dimension(200, 200));
        textPane.setText(""); // set
        // the
        // Text
        // textPane.setCaretPosition(0); // set Cret position to 0
        /** *EXPERIMENT*** */

        // p1.add(l1);
        // p2.add(open_button);
        // p2.add(save_button);
        // p2.add(saveas_button);
        p1.add(label1);
        p2.add(new JScrollPane(tb1));
        p3.add(label2);
        p4.add(new JScrollPane(tb2));
        p5.add(label3);
        p6.add(new JScrollPane(tb3));
        p6a.add(capitalize);
        p7.add(clearButton);
        p7.add(refreshButton);
        p7.add(exitButton);
        this.setJMenuBar(menubar);

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        contentPane.add(p1);
        contentPane.add(p2);
        contentPane.add(p3);
        contentPane.add(p4);
        contentPane.add(p5);
        contentPane.add(p6);
        contentPane.add(p6a);
        contentPane.add(p7);

        /** **Experiment**** */
        /***********************************************************************
         * try{
         * 
         * PrintStream console = System.out;
         * 
         * PrintStream out = new PrintStream( new BufferedOutputStream( new
         * FileOutputStream("test.out")));
         * 
         * System.setOut(out); /****Experiment
         **********************************************************************/
        /*
         * }
         * 
         * catch(IOException ioe) {}
         */

    }

    // *******************BEGINNING OF FUNCTION********************//
    String input = "";

    // The three events
    public void keyTyped(KeyEvent e)
    {
    }

    public void keyPressed(KeyEvent e)
    {
    }

    public void keyReleased(KeyEvent e)
    {
        if (e.getComponent() == this.tb1)
        {
            setText();
        }

    }

    public void actionPerformed(ActionEvent e)
    {
        if ((e.getActionCommand()).equals("clear"))
        {
            clear();
            this.repaint();
        }

        else if ((e.getActionCommand()).equals("Exit"))
        {
            System.exit(0);
        }

        else if ((e.getActionCommand()).equals("clipboard1"))
        {
            copyToClipBoard("cb1");
        }

        else if ((e.getActionCommand()).equals("clipboard2"))
        {
            copyToClipBoard("cb2");
        }

        else if ((e.getActionCommand()).equals("clipboard3"))
        {
            copyToClipBoard("cb3");
        }
        else if ((e.getActionCommand()).equals("open"))
        {
            chooseFile(tb1);
        }

        else if ((e.getActionCommand()).equals("save"))
        {
            // if(!CURRENT_FILE.equals(null))
            // writeFile(new File(CURRENT_FILE), tb1);
        }

        else if ((e.getActionCommand()).equals("save_as"))
        {
            saveText(tb1);
        }

        else if ((e.getActionCommand()).equals("convert"))
        {
            setText();
        }

        else if ((e.getActionCommand()).equals("refresh"))
        {
            this.repaint();
        }

        // /********MENU ITEM***********/////

        else if ((e.getActionCommand()).equals("exit_item"))
        {
            System.exit(0);
        }

        else if ((e.getActionCommand()).equals("about_item"))
        {
            String copyright = "\u00A9 2008 All Rights Reserved. Chetan Pandey\n" + "Pls. Contact taddhita_priya@yahoo.com for questions and suggestions.";

            JOptionPane.showMessageDialog(this, copyright, "About Transliterator Program", JOptionPane.PLAIN_MESSAGE);

        }

        else if ((e.getActionCommand()).equals("itrans_encoding"))
        {
            Log.logInfo("transliteration_scheme_display()");
            new RTFDocsSwingDisplayer("ITRANS ENCODING SCHEME", SandhiJFrame.DOC_PATH + "itrans.rtf", "transliterator.jar");
        }

        else if ((e.getActionCommand()).equals("slp_encoding"))
        {
            Log.logInfo("transliteration_scheme_display()");
            new RTFDocsSwingDisplayer("SLP ENCODING SCHEME", SandhiJFrame.DOC_PATH + "slp.rtf", "transliterator.jar");
        }

        else if ((e.getActionCommand()).equals("hk_encoding"))
        {
            Log.logInfo("RTFDocsSwingDisplayer for HK ENCODING DISPLAY");
            new RTFDocsSwingDisplayer("HK Encoding Scheme", SandhiJFrame.DOC_PATH + "hk.rtf", "transliterator.jar");
        }

        else if ((e.getActionCommand()).equals("notes_item"))
        {
            // new help_frame();
            new RTFDocsSwingDisplayer("Notes", "word_processor_Notes.rtf", "transliterator.jar");
        }

        // //*******MENU ITEM**********/////
        else if ((e.getActionCommand()).equals("save_1"))
        {
            saveText(tb1);
        }
        else if ((e.getActionCommand()).equals("save_2"))
        {
            saveText(tb2);
        }

        else if ((e.getActionCommand()).equals("save_3"))
        {
            saveText(tb3);
        }

        else if ((e.getActionCommand()).equals("open_1"))
        {
            chooseFile(tb1);
            setText();
        }
        else if ((e.getActionCommand()).equals("open_2"))
        {
            chooseFile(tb2);
        }

        else if ((e.getActionCommand()).equals("open_3"))
        {
            chooseFile(tb3);
        }
        
        else if ((e.getActionCommand()).equals("capitalize")){
            if(capitalize.isSelected()){
                capitalizeIAST = true;
                tb3.setText(WordUtils.capitalizeFully(tb3.getText()));
            }
            else{
                capitalizeIAST = false;
                tb3.setText(WordUtils.uncapitalize(tb3.getText()));
            }
        }

    }

    // *******************END OF FUNCTION**********************//

    public void saveText(JTextArea jta)
    {
        JFileChooser chooser = new JFileChooser();

        chooser.setMultiSelectionEnabled(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        // Ask User to choose File
        int option = chooser.showSaveDialog(this);

        Log.logInfo("JFileChooser.APPROVE_OPTION  = " + JFileChooser.APPROVE_OPTION);

        // If User chooses a to open a File
        if (option == JFileChooser.APPROVE_OPTION)
        {
            // If the User chooses a File
            if (chooser.getSelectedFile() != null)
            {
                Log.logInfo("You chose to save this file as " + chooser.getSelectedFile().getPath());

                // Complete Name of File Chosen
                String path = chooser.getSelectedFile().getAbsolutePath();
                Log.logInfo("File name chosen for saving is " + path);

                // Short Name of File Chosen
                String shortpath = chooser.getSelectedFile().getName();
                Log.logInfo("Short File name chosen for saving is " + shortpath);

                // If File doesnt end with .rtf then automatically provide it
                if (!path.endsWith(".rtf")) path += ".rtf";

                File file = new File(path);

                // If their is no File by that Name
                if (!file.exists())
                {
                    try
                    {
                        file.createNewFile();
                        writeFile(file, jta);
                        /*
                         * if(writeFile(file,jta)) { CURRENT_FILE =
                         * file.getAbsolutePath(); save_button.setEnabled(true); }
                         */
                    } // end of try

                    // Catch handles the situation when a filename entered is
                    // errorneous
                    catch (IOException ioe)
                    {
                        // ioe.printStackTrace();
                        Log.logInfo("IOException");
                        String err_msg = "The filename, directory name, or volume label syntax of file name specified \n\"" + file.getName() + "\" \n" + "in" + "\n" + "\"" + file.getParent() + "\"\nis incorrect.\nPls try again";
                        JOptionPane.showMessageDialog(jta, err_msg, "Input/Output Error", JOptionPane.ERROR_MESSAGE);
                    } // end of catch

                }// end of if (!file.exists())

                // If a File of that name exists already.
                else
                { // File Already Exists...Permission to Overwrite
                    String overwrite = "File \n\"" + file.getName() + "\" \n" + "in" + "\n\"" + file.getParent() + "\"\n will be overwritten. Continue?";

                    int resp = (new DisplayMessage()).yes_no_dialog(p2, overwrite);
                    if (resp == 0) writeFile(file, jta);
                } // end of else

            } // end of if (chooser.getSelectedFile() != null

        }

    } // end of function

    public void chooseFile(JTextArea jta)
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);

        int option = chooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION)
        {
            if (chooser.getSelectedFile() != null)
            {
                Log.logInfo("You chose to open this file: " + chooser.getSelectedFile().getPath());
                String path = chooser.getSelectedFile().getPath();
                readFile(new File(path), jta);
            }
        }
    }

    // *******************END OF FUNCTION**********************//

    // *******************BEGINNING OF FUNCTION********************//

    public void clear()
    {
        tb1.setText("");
        tb2.setText("");
        tb3.setText("");
        this.repaint();
    }

    // *******************END OF FUNCTION**********************//

    // *******************BEGINNING OF FUNCTION********************//

    public boolean readFile(File file, JTextArea jta)
    {

        FileInputStream fist = null;
        InputStreamReader isre = null;
        BufferedReader bre = null;

        try
        {
            // read a Unicode string from a file
            fist = new FileInputStream(file);

            Log.logInfo("jta == tb1 " + (jta == tb1));
            if (jta == tb1)
                isre = new InputStreamReader(fist);
            else
                isre = new InputStreamReader(fist, "UNICODE");
            bre = new BufferedReader(isre);

            Log.logInfo("getEncoding == " + isre.getEncoding());
            String txt = "";
            int filereader = 0;

            while ((filereader = fist.read()) != -1)
            {
                Log.logInfo(filereader);
                txt += (char) filereader;
            }

            OutputStreamWriter osw = new OutputStreamWriter(System.out, "Unicode");
            osw.write("\nTEST TO CHECK OSW ****\u0915****");

            jta.setText(txt);
            bre.close();
            return true;
        }

        catch (FileNotFoundException fnf)
        {
            Log.logInfo("FileNotFoundException");
            String err_msg = "Filename you entereded \n" + "\"" + file.getName() + "\"" + "\n" + "in" + "\n" + "\"" + file.getParent() + "\"" + "\nwas not found.\nPls try again";
            JOptionPane.showMessageDialog(jta, err_msg, "File Not Found Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        catch (IOException ioe)
        {
            Log.logInfo("IOException");
            String err_msg = "Input/Output Error when reading from file\n" + "\"" + file.getName() + "\"" + "\n" + "in" + "\n" + "\"" + file.getParent() + "\"" + "\nPls try again";
            JOptionPane.showMessageDialog(jta, err_msg, "Input/Output Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    // *******************END OF FUNCTION**********************//

    // *******************BEGINNING OF FUNCTION********************//

    public boolean writeFile(File file, JTextArea jta)
    {

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try
        {
            fos = new FileOutputStream(file);
            if (jta == tb1)
                osw = new OutputStreamWriter(fos);
            else
                osw = new OutputStreamWriter(fos, "Unicode");
            bw = new BufferedWriter(osw);

            String txt = jta.getText();

            OutputStreamWriter oswr = new OutputStreamWriter(System.out, "Unicode");
            oswr.write("\nTEST TO CHECK OSW *\u0915*\u0916*\u0917*\u0918*\u0919*\u0920*\u0921*");
            oswr.flush();
            for (int i = 0; i < txt.length(); i++)
            {
                // Log.logInfo(txt.charAt(i));
                oswr.write(txt.charAt(i));
                oswr.flush();
                bw.write(txt.charAt(i));
            }
            bw.flush();
            bw.close();
            return true;
        }

        catch (FileNotFoundException fnf)
        {
            Log.logInfo("FileNotFoundException");
            String err_msg = "File name you entered \"" + file.getPath() + "\" not found.\nPls try again";
            JOptionPane.showMessageDialog(jta, err_msg, "File Not Found Error", JOptionPane.ERROR_MESSAGE);
            // fnf.printStackTrace();
            return false;
        }

        catch (IOException ioe)
        {
            Log.logInfo("IOException");
            String err_msg = "File name you entered \"" + file.getPath() + "\" cannot be found.\nPls try again";
            JOptionPane.showMessageDialog(jta, err_msg, "Input/Output Error", JOptionPane.ERROR_MESSAGE);
            // ioe.printStackTrace();
            return false;
        }

    }

    // *******************END OF FUNCTION**********************//

    public void itemStateChanged(ItemEvent e)
    {

        Object source = e.getItemSelectable();
        String dialog_header = "Encoding Switch";
        String dialog = "Changing Encoding will clear all Text.\n " + "Do you want to continue?";

        if (e.getStateChange() == ItemEvent.SELECTED)
        {
            int confirmation = JOptionPane.showConfirmDialog(tb1, dialog, dialog_header, JOptionPane.OK_CANCEL_OPTION);
            Log.logInfo("confirmation: " + confirmation);
            if (source == useItrans)
            {
                if (confirmation == 0)
                {
                    clear();
                    encoding = EncodingUtil.ITRANS;
                    useItrans.setEnabled(false);
                    useSLP.setEnabled(true);
                    useHK.setEnabled(true);
                    useVelthuis.setEnabled(true);
                    useDevanagari.setEnabled(true);
                    useIAST.setEnabled(true);

                    useItrans.setSelected(true);
                    useSLP.setSelected(false);
                    useHK.setSelected(false);
                    useVelthuis.setSelected(false);
                    useDevanagari.setSelected(false);
                    useIAST.setSelected(false);
                }

                else
                {
                    useItrans.setSelected(false);
                }
            }

            else if (source == useHK)
            {
                if (confirmation == 0)
                {
                    clear();
                    encoding = EncodingUtil.HK;
                    useHK.setEnabled(false);
                    useSLP.setEnabled(true);
                    useItrans.setEnabled(true);
                    useVelthuis.setEnabled(true);
                    useDevanagari.setEnabled(true);
                    useIAST.setEnabled(true);

                    useItrans.setSelected(false);
                    useSLP.setSelected(false);
                    useHK.setSelected(true);
                    useVelthuis.setSelected(false);
                    useDevanagari.setSelected(false);
                    useIAST.setSelected(false);
                }
                else
                {
                    useHK.setSelected(false);
                }
            }

            else if (source == useSLP)
            {
                if (confirmation == 0)
                {
                    clear();
                    encoding = EncodingUtil.SLP;
                    useSLP.setEnabled(false);
                    useItrans.setEnabled(true);
                    useHK.setEnabled(true);
                    useVelthuis.setEnabled(true);
                    useDevanagari.setEnabled(true);
                    useIAST.setEnabled(true);
                    
                    useItrans.setSelected(false);
                    useSLP.setSelected(true);
                    useHK.setSelected(false);
                    useVelthuis.setSelected(false);
                    useDevanagari.setSelected(false);
                    useIAST.setSelected(false);
                }
                else
                {
                    useSLP.setSelected(false);
                }
            }
            
            else if (source == useVelthuis)
            {
                if (confirmation == 0)
                {
                    clear();
                    encoding = EncodingUtil.VELTHIUS;
                    useSLP.setEnabled(true);
                    useItrans.setEnabled(true);
                    useHK.setEnabled(true);
                    useVelthuis.setEnabled(false);
                    useDevanagari.setEnabled(true);
                    useIAST.setEnabled(true);
                    
                    useItrans.setSelected(false);
                    useSLP.setSelected(false);
                    useHK.setSelected(false);
                    useVelthuis.setSelected(true);
                    useDevanagari.setSelected(false);
                    useIAST.setSelected(false);
                }
                else
                {
                    useVelthuis.setSelected(false);
                }
            }

            else if (source == useDevanagari)
            {
                if (confirmation == 0)
                {
                    clear();
                    encoding = EncodingUtil.UNICODE_DVN;
                    useSLP.setEnabled(true);
                    useItrans.setEnabled(true);
                    useHK.setEnabled(true);
                    useVelthuis.setEnabled(true);
                    useDevanagari.setEnabled(false);
                    useIAST.setEnabled(true);

                    useItrans.setSelected(false);
                    useSLP.setSelected(false);
                    useHK.setSelected(false);
                    useVelthuis.setSelected(false);
                    useDevanagari.setSelected(true);
                    useIAST.setSelected(false);
                }
                else
                {
                    useDevanagari.setSelected(false);
                }
            }

            else if (source == useIAST)
            {
                if (confirmation == 0)
                {
                    clear();
                    encoding = EncodingUtil.IAST;
                    useSLP.setEnabled(true);
                    useItrans.setEnabled(true);
                    useHK.setEnabled(true);
                    useVelthuis.setEnabled(true);
                    useDevanagari.setEnabled(true);
                    useIAST.setEnabled(false);

                    useItrans.setSelected(false);
                    useSLP.setSelected(false);
                    useHK.setSelected(false);
                    useVelthuis.setSelected(false);
                    useDevanagari.setSelected(false);
                    useIAST.setSelected(true);
                }
                else
                {
                    useIAST.setSelected(false);
                }
            }
        }
    }// end of itemStateChanged

    public void copyToClipBoard(String source)
    {
        Clipboard clipboard;
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable content = clipboard.getContents(this);
        try
        {
            String data = (String) content.getTransferData(DataFlavor.stringFlavor);
            StringSelection contents;
            if ("cb1".equalsIgnoreCase(source))
                contents = new StringSelection(tb1.getText());
            else if ("cb2".equalsIgnoreCase(source))
                contents = new StringSelection(tb2.getText());
            else
                contents = new StringSelection(tb3.getText());
            clipboard.setContents(contents, this);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException
    {
        TransliteratorJFrame u1 = new TransliteratorJFrame();
        u1.setVisible(true);

    } // end of main

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents)
    {

    }

    public void setText()
    {
        tb2.setText(EncodingUtil.convertToDVN(tb1.getText(), encoding));
        String iast = EncodingUtil.convertToIAST(tb1.getText(), encoding);
        tb3.setText(capitalizeIAST ? WordUtils.capitalizeFully(iast) : iast);
        this.repaint();
    }
} // end of sandhi
