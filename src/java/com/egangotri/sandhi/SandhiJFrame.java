package com.egangotri.sandhi;

import java.util.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;

import com.egangotri.constants.Constants;
import com.egangotri.menu.FileMenu;
import com.egangotri.menu.HelpMenu;
import com.egangotri.menu.OptionsMenu;
import com.egangotri.menu.PratyaharaMenu;
import com.egangotri.panel.EncodingPanelForSandhi;
import com.egangotri.panel.SandhiOptionsPanel;
import com.egangotri.util.*;

import java.awt.*;

/**
 * @author Chetan Pandey
 *
 */
public class SandhiJFrame extends JFrame implements ActionListener, KeyListener
{

    JMenuBar                   menubar;

    FileMenu fileMenu;
    
    OptionsMenu optionsMenu;

    HelpMenu helpMenu;
    
    PratyaharaMenu pratyaharaMenu;
    
    JLabel                     l1a, l1b, l1c, l2, plus, equal, plus1, equal1;

    JTextField                 tf1, tf2, tf3, tf4, tf5, tf6;

    JButton                    b1;

    JButton                    b2;

    JButton                    b3;

    JButton                    previous;

    JButton                    next;

    JTextArea                  tb1;

    EncodingPanelForSandhi encodingPanel;
    
    SandhiOptionsPanel sandhiOptionsPanel;

    private Vector<SandhiBean> beanVector;

    private int                vectorTracker = -1;

    static boolean             internal      = false;

    public static boolean             padanta       = false;                        // sup

    // ti~Nantam
    // padam

    public static boolean             pragrhya      = false;

    public static boolean      romanSutra    = false;

    public static final String title         = "Sandhi Engine";

    public SandhiJFrame()
    {
        super(title);
        setSize(650, 550);

        // Vector Initialization
        beanVector = new Vector<SandhiBean>();

        // menubar
        menubar = new JMenuBar();
        //
        fileMenu = new FileMenu();
        optionsMenu = new OptionsMenu();
        helpMenu = new HelpMenu("Sandhi Engine", Project.SANDHI);
        pratyaharaMenu = new PratyaharaMenu();
        
        // add menus to menubar
        menubar.add(fileMenu);
        menubar.add(optionsMenu);
        menubar.add(pratyaharaMenu);
        menubar.add(helpMenu);
        // menus end

        encodingPanel = new EncodingPanelForSandhi(this);
        sandhiOptionsPanel = new SandhiOptionsPanel();
        
        // Jpanel initialization
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p2a = new JPanel();
        JPanel p2b = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();

        Container contentPane = getContentPane();
        l1a = new JLabel("Please enter Words in");
        l1b = new JLabel("ITRANS FORMAT");
        l1c = new JLabel("only");
        l1b.setToolTipText("ITRANS FORMAT ONLY.");

        l2 = new JLabel("Notes:");

        plus = new JLabel(" + ");
        equal = new JLabel(" = ");

        tf1 = new JTextField(10);
        tf1.addKeyListener(this);

        tf2 = new JTextField(10);
        tf2.addKeyListener(this);

        tf3 = new JTextField(20);
        tf3.setEditable(false);

        plus1 = new JLabel(" + ");
        equal1 = new JLabel(" = ");
        tf4 = new JTextField(10);

        tf5 = new JTextField(10);
        tf6 = new JTextField(20);
        tf4.setEditable(false);
        tf5.setEditable(false);
        tf6.setEditable(false);
        tf1.setText("shiva");
        tf2.setText("Alaya");
        tf4.setText(EncodingUtil.convertToDVN(tf1.getText(), Constants.ITRANS));
        tf5.setText(EncodingUtil.convertToDVN(tf2.getText(), Constants.ITRANS));


        // Buttons
        b1 = new JButton("Enter");
        b1.setActionCommand("Enter");
        b1.setToolTipText("Enter two words.");

        b2 = new JButton("Clear");
        b2.setActionCommand("clear");
        b2.setToolTipText("Clear all Text Fields");

        b3 = new JButton("Exit");
        b3.setActionCommand("Exit");
        b3.setToolTipText("Quit the Application.");

        previous = new JButton("<<<");
        previous.setActionCommand("previous");
        previous.setToolTipText("Go to Previous Entry.");
        previous.setEnabled(false);

        next = new JButton(">>>");
        next.setActionCommand("next");
        next.setToolTipText("Go to Next Entry.");
        next.setEnabled(false);

        // Adding ActionListener
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        previous.addActionListener(this);
        next.addActionListener(this);

        // JTextArea
        tb1 = new JTextArea(12, 45);
        tb1.setLineWrap(true);
        tb1.setWrapStyleWord(true);
        // tb1.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // panel additions
        p1.add(previous);
        p1.add(next);
        p2.add(tf1);
        p2.add(plus);
        p2.add(tf2);
        p2.add(equal);
        p2.add(tf3);
        p2b.add(tf4);
        p2b.add(plus1);
        p2b.add(tf5);
        p2b.add(equal1);
        p2b.add(tf6);
        p3.add(b1);
        p3.add(b2);
        p3.add(b3);

        p4.add(l2);
        p5.add(new JScrollPane(tb1));

        this.setJMenuBar(menubar);

        contentPane.add(p1);
        contentPane.add(p2);
        contentPane.add(sandhiOptionsPanel);
        contentPane.add(p2b);
        contentPane.add(p3);
        contentPane.add(encodingPanel);
        contentPane.add(p4);
        contentPane.add(p5);

    }
    
    // The three events
    public void keyTyped(KeyEvent e)
    {
    }// Log.logInfo("keyTyped");

    public void keyPressed(KeyEvent e)
    {
    }// Log.logInfo("keyPressed");

    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
            setText();
        else if (e.getComponent() == this.tf1)
        {
            tf4.setText(EncodingUtil.convertToDVN(tf1.getText(), encodingPanel.getEncoding()));
        }

        else if (e.getComponent() == this.tf2)
        {
            tf5.setText(EncodingUtil.convertToDVN(tf2.getText(), encodingPanel.getEncoding()));
        }
    }


    public void actionPerformed(ActionEvent e)
    {
        if ((e.getActionCommand()).equals("Enter"))
        {
            setText();
        }

        else if ((e.getActionCommand()).equals("clear"))
        {
            clear();
        }
        
        else if ((e.getActionCommand()).equals("previous"))
        {
            // if u r trying to scroll on the firsts added element
            // and for some reason it is not disabled, then time to disable it
            if (vectorTracker <= 0) previous.setEnabled(false);

            Log.logInfo("previous -> :  vector_tracker " + vectorTracker);
            next.setEnabled(true);
            setText(beanVector.elementAt(--vectorTracker));
            if (vectorTracker <= 0) previous.setEnabled(false);

            Log.logInfo("previous -> :  vector_tracker" + vectorTracker);
        }

        else if ((e.getActionCommand()).equals("next"))
        {
            Log.logInfo("next -> :  vector_tracker" + vectorTracker);
            previous.setEnabled(true);
            setText(beanVector.elementAt(++vectorTracker));
            if (vectorTracker >= beanVector.size() - 1) next.setEnabled(false);

            Log.logInfo("next -> :  vector_tracker" + vectorTracker);
        }

        else{
            CommonActions.performActions(e.getActionCommand());
        }

    }

    public void setText()
    {
        String anta = (tf1.getText().toString()).trim();
        String adi = (tf2.getText().toString()).trim();

        // SandhiBean bean = new SandhiBean(anta,adi);
        SandhiBean bean = new SandhiBean(anta, adi, padanta, pragrhya, encodingPanel.getEncoding());
        // Set values for the Textfields and TextAreas
        tf3.setText(bean.getRomanInput3());
        tf4.setText(bean.getDvnInput1());
        tf5.setText(bean.getDvnInput2());
        tf6.setText(bean.getDvnInput3());
        tb1.setText(bean.getNotes());
        tb1.setCaretPosition(0);

        beanVector.add(bean);
        if (beanVector.size() > 1) previous.setEnabled(true);
        vectorTracker = beanVector.size() - 1;

        // Disable "next Button" if vector_tracker points to the last element
        if (vectorTracker >= beanVector.size() - 1) next.setEnabled(false);

    }

    public void setText(SandhiBean bean)
    {
        tf1.setText(bean.getRomanInput1());
        tf2.setText(bean.getRomanInput2());
        tf3.setText(bean.getRomanInput3());
        tf4.setText(bean.getDvnInput1());
        tf5.setText(bean.getDvnInput2());
        tf6.setText(bean.getDvnInput3());
        
        sandhiOptionsPanel.setPadantaCheck(bean.isPadanta());
        sandhiOptionsPanel.setPragrhyaCheck(bean.isPragrhya());
        tb1.setText(bean.getNotes());
        tb1.setCaretPosition(0);

    }

    public void clear()
    {
        sandhiOptionsPanel.setPadantaCheck(false);
        sandhiOptionsPanel.setPragrhyaCheck(false);
        clearTextFields();
        encodingPanel.setEncodingToDefault();
    }

    public void clearTextFields()
    {
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
        tf5.setText("");
        tf6.setText("");
        tb1.setText("");

    }

    public static void main(String[] args) throws IOException
    {
        SandhiJFrame san = new SandhiJFrame();
        san.setVisible(true);

    } // end of main

} // end of sandhi
