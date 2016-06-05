package com.egangotri.transliteratorAsSwing;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.PlainDocument;
import javax.swing.text.rtf.RTFEditorKit;

import com.egangotri.io.FileIO;
import com.egangotri.util.CommonActions;
import com.egangotri.constants.Constants;
import org.apache.commons.lang3.text.WordUtils;

import com.egangotri.util.EncodingUtil;
import com.egangotri.util.Log;

public class TransliteratorJFrame extends JFrame implements ActionListener, KeyListener, ClipboardOwner {

    JMenuBar menubar = new JMenuBar();

    JMenu file, help;

    JMenuItem exitItem, aboutItem;
    JMenuItem itransItem, slpItem, hkItem, velthuisItem, dvnItem, iastItem;

    JMenuItem save_1, save_2, save_3, open_1;

    JComboBox comboBox1, comboBox2, comboBox3;

    JLabel label1, label2, label3;

    JButton refreshButton, clearButton, exitButton, clipboardButton1, clipboardButton2, clipboardButton3;

    JPanel p1, p1a, p3a, p5a, p2, p3, p4, p5, p6, p6a, p7;

    JTextArea tb1, tb2, tb3;

    JCheckBox capitalize;

    static String inputEncoding = Constants.ITRANS;
    static String outputEncoding1 = Constants.UNICODE_DVN;
    static String outputEncoding2 = Constants.IAST;

    JTextPane textPane;

    boolean capitalizeIAST = false;

    public TransliteratorJFrame() {
        super("eGangotri Indic Transliterator");

        PrintWriter pw = new PrintWriter(System.out, true);
        setSize(650, 650);

        // menubar
        menubar = new JMenuBar();

        // menus
        file = new JMenu("File");
        help = new JMenu("Help");

        // JMenuItem
        save_1 = new JMenuItem("Save Input");
        save_1.setActionCommand("save_1");
        save_1.addActionListener(this);

        save_2 = new JMenuItem("Save Output-1");
        save_2.setActionCommand("save_2");
        save_2.addActionListener(this);

        save_3 = new JMenuItem("Save Output-2");
        save_3.setActionCommand("save_3");
        save_3.addActionListener(this);

        open_1 = new JMenuItem("Open File for Input");
        open_1.setActionCommand("open_1");
        open_1.addActionListener(this);

        exitItem = new JMenuItem("Exit");
        exitItem.setActionCommand("Exit");
        exitItem.addActionListener(this);

        aboutItem = new JMenuItem("About");
        aboutItem.setActionCommand("about_item");
        aboutItem.addActionListener(this);

        itransItem = new JMenuItem("ITRANS " + Constants.ENCODING_SCHEME);
        itransItem.setActionCommand("itrans_encoding");
        itransItem.addActionListener(this);

        slpItem = new JMenuItem("SLP " + Constants.ENCODING_SCHEME);
        slpItem.setActionCommand("slp_encoding");
        slpItem.addActionListener(this);

        hkItem = new JMenuItem("Harvard Kyoto " + Constants.ENCODING_SCHEME);
        hkItem.setActionCommand("hk_encoding");
        hkItem.addActionListener(this);

        velthuisItem = new JMenuItem("Velthuis " + Constants.ENCODING_SCHEME);
        velthuisItem.setActionCommand("velthuis_encoding");
        velthuisItem.addActionListener(this);

        dvnItem = new JMenuItem("Devanagari " + Constants.ENCODING_SCHEME);
        dvnItem.setActionCommand("devanagari_encoding");
        dvnItem.addActionListener(this);

        iastItem = new JMenuItem("IAST " + Constants.ENCODING_SCHEME);
        iastItem.setActionCommand("iast_encoding");
        iastItem.addActionListener(this);

        // add menuitems to menu
        file.add(open_1);
        file.add(save_1);
        file.add(save_2);
        file.add(save_3);
        file.add(exitItem);

        help.add(aboutItem);
        help.add(itransItem);
        help.add(slpItem);
        help.add(hkItem);
        help.add(velthuisItem);
        help.add(dvnItem);
        help.add(iastItem);


        // add menus to menubar
        menubar.add(file);
        menubar.add(help);
        // menus end

        // JPanel Initilization
        p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1a = new JPanel(new BorderLayout());
        p2 = new JPanel();
        p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3a = new JPanel(new BorderLayout());

        p4 = new JPanel();
        p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p5a = new JPanel(new BorderLayout());

        p6 = new JPanel();
        p6a = new JPanel();
        p7 = new JPanel();

        // JLabel Initialization
        label1 = new JLabel("Input:");
        label2 = new JLabel("Output-1");
        label3 = new JLabel("Output-2");

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

        clipboardButton1 = new JButton("Clipboard");
        clipboardButton1.setActionCommand("clipboard-1");
        clipboardButton1.setToolTipText("Clipboard Input");

        clipboardButton2 = new JButton("Clipboard");
        clipboardButton2.setActionCommand("clipboard-2");
        clipboardButton2.setToolTipText("Clipboard Output-1");


        clipboardButton3 = new JButton("Clipboard");
        clipboardButton3.setActionCommand("clipboard-3");
        clipboardButton3.setToolTipText("Clipboard Output-2");


        clearButton.addActionListener(this);
        refreshButton.addActionListener(this);
        exitButton.addActionListener(this);

        clipboardButton1.addActionListener(this);
        clipboardButton2.addActionListener(this);
        clipboardButton3.addActionListener(this);

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

        comboBox1 = new JComboBox(Constants.ENCODINGS.toArray());
        comboBox1.setActionCommand("comboBox1");
        comboBox1.setSelectedItem(Constants.ITRANS);
        comboBox1.addActionListener(this);


        comboBox2 = new JComboBox(Constants.ENCODINGS.toArray());
        comboBox2.setActionCommand("comboBox2");
        comboBox2.setSelectedItem(Constants.UNICODE_DVN);
        comboBox2.addActionListener(this);

        comboBox3 = new JComboBox(Constants.ENCODINGS.toArray());
        comboBox3.setActionCommand("comboBox3");
        comboBox3.setSelectedItem(Constants.IAST);
        comboBox3.addActionListener(this);


        /** *EXPERIMENT*** */
        textPane = new JTextPane();
        RTFEditorKit rtfkit = new RTFEditorKit();
        // HTMLEditorKit htmlkit = new HTMLEditorKit();
        textPane.setEditorKit(rtfkit); // set Kit which will read RTF Doc
        // textPane.setEditorKit(htmlkit);
        textPane.setEditable(false); // make uneditable
        textPane.setPreferredSize(new Dimension(200, 200));
        textPane.setText(""); // set

        p1.add(label1);
        p1a.add(comboBox1, BorderLayout.LINE_END);
        p1a.add(clipboardButton1, BorderLayout.LINE_START);

        p2.add(new JScrollPane(tb1));

        p3.add(label2);
        p3a.add(comboBox2, BorderLayout.LINE_END);
        p3a.add(clipboardButton2, BorderLayout.LINE_START);

        p4.add(new JScrollPane(tb2));

        p5.add(label3);
        p5a.add(comboBox3, BorderLayout.LINE_END);
        p5a.add(clipboardButton3, BorderLayout.LINE_START);

        p6.add(new JScrollPane(tb3));

        p6a.add(capitalize);
        p7.add(clearButton);
        p7.add(refreshButton);
        p7.add(exitButton);
        this.setJMenuBar(menubar);

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        contentPane.add(p1);
        contentPane.add(p1a);
        contentPane.add(p2);
        contentPane.add(p3);
        contentPane.add(p3a);
        contentPane.add(p4);
        contentPane.add(p5);
        contentPane.add(p5a);
        contentPane.add(p6);
        contentPane.add(p6a);
        contentPane.add(p7);

    }

    String input = "";

    // The three events
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        if (e.getComponent() == this.tb1) {
            setText();
        }

    }

    public void actionPerformed(ActionEvent e) {
        String actionCommand =  e.getActionCommand();
        Log.logInfo("actionCommand: " + actionCommand);
        if (actionCommand.equals("clear")) {
            clear();
            this.repaint();
        } else if (actionCommand.equals("clipboard-1")) {
            copyToClipBoard("cb1");
        } else if (actionCommand.equals("clipboard-2")) {
            copyToClipBoard("cb2");
        } else if (actionCommand.equals("clipboard-3")) {
            copyToClipBoard("cb3");
        } else if (actionCommand.equals("comboBox1")) {
            inputEncoding = comboBox1.getSelectedItem().toString();
            Log.logInfo("inputEncoding: " + inputEncoding);
            setText();
        } else if (actionCommand.equals("comboBox2")) {
            outputEncoding1 = comboBox2.getSelectedItem().toString();
            Log.logInfo("outputEncoding1: " + outputEncoding1);
            setText();
        } else if (actionCommand.equals("comboBox3")) {
            outputEncoding2 = comboBox3.getSelectedItem().toString();
            Log.logInfo("outputEncoding2: " + outputEncoding2);
            setText();
        } else if (actionCommand.equals("open")) {
            chooseFile(tb1);
        } else if (actionCommand.equals("convert")) {
            setText();
        } else if (actionCommand.equals("refresh")) {
            this.repaint();
        }

        else if (actionCommand.equals("about_item")) {
            String copyright = "Released Under MIT License. eGangotri Digital Preservation Trust\n" + "Pls. Contact egagotritrust@gmail.com for questions and suggestions.";
            JOptionPane.showMessageDialog(this, copyright, "eGangotri Indic Transliterator", JOptionPane.PLAIN_MESSAGE);
        }
        else if (actionCommand.equals("save_1")) {
            FileIO.saveText(this,tb1,p2);
        } else if (actionCommand.equals("save_2")) {
            FileIO.saveText(this,tb2,p2);
        } else if (actionCommand.equals("save_3")) {
            FileIO.saveText(this,tb3,p2);
        } else if (actionCommand.equals("open_1")) {
            chooseFile(tb1);
            setText();
        } else if (actionCommand.equals("capitalize")) {
            if (capitalize.isSelected()) {
                capitalizeIAST = true;
                tb3.setText(WordUtils.capitalizeFully(tb3.getText()));
            } else {
                capitalizeIAST = false;
                tb3.setText(WordUtils.uncapitalize(tb3.getText()));
            }
        }

        else{
            CommonActions.performActions(actionCommand);
        }

    }

    // *******************END OF FUNCTION**********************//


    public void chooseFile(JTextArea jta) {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        chooser.setFileFilter(filter);

        int option = chooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            if (chooser.getSelectedFile() != null) {
                Log.logInfo("You chose to open this file: " + chooser.getSelectedFile().getPath());
                String path = chooser.getSelectedFile().getPath();
                FileIO.readFile(new File(path), jta);
            }
        }
    }

    // *******************END OF FUNCTION**********************//

    // *******************BEGINNING OF FUNCTION********************//

    public void clear() {
        tb1.setText("");
        tb2.setText("");
        tb3.setText("");
        this.repaint();
    }

    public void copyToClipBoard(String source) {
        Clipboard clipboard;
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable content = clipboard.getContents(this);
        try {
            String data = (String) content.getTransferData(DataFlavor.stringFlavor);
            StringSelection contents;
            if ("cb1".equalsIgnoreCase(source))
                contents = new StringSelection(tb1.getText());
            else if ("cb2".equalsIgnoreCase(source))
                contents = new StringSelection(tb2.getText());
            else
                contents = new StringSelection(tb3.getText());
            clipboard.setContents(contents, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {

    }

    public void setText() {
        String userInput = tb1.getText();
        tb2.setText(EncodingUtil.convert(userInput, inputEncoding, outputEncoding1, capitalizeIAST));
        tb3.setText(EncodingUtil.convert(userInput, inputEncoding, outputEncoding2, capitalizeIAST));
        this.repaint();
    }


    public static void main(String[] args) throws IOException {
        TransliteratorJFrame u1 = new TransliteratorJFrame();
        u1.setVisible(true);

    } // end of main

}
