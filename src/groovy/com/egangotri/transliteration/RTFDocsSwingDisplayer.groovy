package com.egangotri.transliteration

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.rtf.RTFEditorKit

public class RTFDocsSwingDisplayer extends JFrame implements ActionListener {
    JButton b1, b2, b3;

    JPanel p1;

    JTextArea tb1;

    JEditorPane editorPane;

    public RTFDocsSwingDisplayer(String heading, String filename) {
        super(heading);
        setSize(650, 550);

        // Initialize String which will go into the JTextPane
        String displayMe = readFile(filename);
        // Buttons
        b1 = new JButton("Back");
        b1.setActionCommand("back");
        b1.addActionListener(this);

        // Initializing JTextPane()
        JTextPane textPane = new JTextPane();
        RTFEditorKit rtfkit = new RTFEditorKit();
        // HTMLEditorKit htmlkit = new HTMLEditorKit();
        textPane.setEditorKit(rtfkit); // set Kit which will read RTF Doc
        // textPane.setEditorKit(htmlkit);
        textPane.setEditable(false); // make uneditable
        textPane.setText(displayMe); // set the Text
        textPane.setCaretPosition(0); // set Cret position to 0

        // Panels and addition to container
        p1 = new JPanel();
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        p1.setLayout(new BoxLayout(this.p1, BoxLayout.Y_AXIS));
        p1.add(new JScrollPane(textPane));
        p1.add(b1);
        contentPane.add(p1);
        setVisible(true);

    }

    public String readFile(String fileName) {
        return this.class.getResource("/$fileName").text
        //return new File(Constants.DOC_PATH +  + fileName).text;
    }

    public void actionPerformed(ActionEvent e) {
        if ((e.getActionCommand()).equals("back")) {
            this.dispose()
        };
    }

}
