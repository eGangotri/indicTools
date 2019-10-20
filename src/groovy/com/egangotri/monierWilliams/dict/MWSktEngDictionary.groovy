package com.egangotri.monierWilliams.dict

import com.egangotri.constants.Constants
import com.egangotri.menu.FileMenu
import com.egangotri.menu.HelpMenu
import com.egangotri.menu.PratyaharaMenu
import com.egangotri.monierWilliams.vo.WordMaster
import com.egangotri.monierWilliams.db.DBUtil
import com.egangotri.monierWilliams.panel.EncodingPanelForDictionary
import com.egangotri.monierWilliams.panel.SearchTypePanel
import com.egangotri.monierWilliams.util.DictionaryBean
import com.egangotri.monierWilliams.util.DictionaryConstants
import com.egangotri.monierWilliams.util.DictionaryUtil
import com.egangotri.pratyahara.PratyahaarJFrame
import com.egangotri.transliteration.otherTransformations.RTFDocsSwingDisplayer
import com.egangotri.util.EncodingUtil
import com.egangotri.util.Log
import com.egangotri.util.Project

import javax.swing.*
import javax.swing.text.html.HTMLEditorKit
import java.awt.*
import java.awt.datatransfer.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.util.List

public class MWSktEngDictionary extends JFrame implements ActionListener, KeyListener, ClipboardOwner
{

    JMenuBar menubar       = new JMenuBar()

    FileMenu fileMenu

    PratyaharaMenu pratyaharaMenu

    HelpMenu helpMenu


    JLabel                         l1a, l1b, l1c, l2, csvLabel

    JTextField                     tf1, tf4

    JButton                        b1

    JButton                        b2

    JButton                        b3

    JButton                        previous

    JButton                        next
    
    JButton clipBoardButton

    JTextPane                      textPane

    EncodingPanelForDictionary encodingPanel

    SearchTypePanel searchTypePanel

    private Vector<DictionaryBean> beanVector

    private int                    vectorTracker = -1

    static boolean                 internal      = false

    static String                  encoding      = Constants.ITRANS

    public static boolean          romanSutra    = false

    public static final String     title         = "Monier Williams Sanskrit English Dictionary"

    public static final String     DOC_PATH      = ""

    static String DEFAULT_ENTRY = "shiva, shakti"

    public MWSktEngDictionary()
    {
        super(title)
        setSize(650, 700)

        // Vector Initialization
        beanVector = new Vector<DictionaryBean>()

        // menubar
        menubar = new JMenuBar()

        fileMenu = new FileMenu()
        pratyaharaMenu = new PratyaharaMenu()
        helpMenu = new HelpMenu("Monier Williams Skt-Eng Dictionary", Project.DICT)

        // add menus to menubar
        menubar.add(fileMenu)
        menubar.add(pratyaharaMenu)
        menubar.add(helpMenu)
        // menus end

        encodingPanel = new EncodingPanelForDictionary(this)

        searchTypePanel = new SearchTypePanel()

        // Jpanel initialization
        JPanel p1 = new JPanel()
        JPanel p2 = new JPanel()
        JPanel p3 = new JPanel()
        JPanel p4 = new JPanel()
        JPanel p5 = new JPanel()
        JPanel p6 = new JPanel()
        JPanel p7 = new JPanel()

        Container contentPane = getContentPane()
        l1a = new JLabel("Please enter Words in")
        l1b = new JLabel("ITRANS FORMAT")
        l1c = new JLabel("only")
        l1b.setToolTipText("ITRANS FORMAT ONLY.")

        l2 = new JLabel("Notes:")
        csvLabel = new JLabel("Put Comma Separated Values to get Multiple Results")
        tf1 = new JTextField(40)
        tf1.addKeyListener(this)

        Font unicodeFont = new Font(Constants.ARIAL_UNICODE_MS, Font.PLAIN, 15)
        tf1.setFont(unicodeFont)

        tf4 = new JTextField(40)
        tf4.setFont(unicodeFont)

        tf4.setEditable(false)
        tf1.setText(DEFAULT_ENTRY)
        tf4.setText(EncodingUtil.convertToDVN(tf1.getText(), Constants.ITRANS))

        // Buttons
        b1 = new JButton("Enter")
        b1.setActionCommand("Enter")
        b1.setToolTipText("Enter two words.")

        b2 = new JButton("Clear")
        b2.setActionCommand("clear")
        b2.setToolTipText("Clear all Text Fields")

        b3 = new JButton("Exit")
        b3.setActionCommand("Exit")
        b3.setToolTipText("Quit the Application.")

        clipBoardButton = new JButton("Copy")
        clipBoardButton.setActionCommand("clipboard")
        clipBoardButton.setToolTipText("Copy to Clipboard")
        clipBoardButton.setEnabled(true)

        previous = new JButton("<<<")
        previous.setActionCommand("previous")
        previous.setToolTipText("Go to Previous Entry.")
        previous.setEnabled(false)

        next = new JButton(">>>")
        next.setActionCommand("next")
        next.setToolTipText("Go to Next Entry.")
        next.setEnabled(false)

        // Adding ActionListener
        b1.addActionListener(this)
        b2.addActionListener(this)
        b3.addActionListener(this)
        previous.addActionListener(this)
        next.addActionListener(this)
        clipBoardButton.addActionListener(this);
        // JTextArea
        textPane = new JTextPane()
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit()
        textPane.setEditorKit(htmlEditorKit)
        textPane.setEditable(true)
        textPane.setPreferredSize(new Dimension(400, 250))
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS))




        // panel additions
        p1.add(previous)
        p1.add(next)
        p2.add(csvLabel)
        p3.add(tf1)
        p5.add(tf4)
        p4.add(b1)
        p4.add(b2)
        p4.add(b3)
        p4.add(clipBoardButton)

        //p6.add(l2)

        p7.add(new JScrollPane(textPane))

        this.setJMenuBar(menubar)

        contentPane.add(p1)
        contentPane.add(p2)
        contentPane.add(p3)
        contentPane.add(p5)
        contentPane.add(encodingPanel)
        contentPane.add(p4)
        contentPane.add(searchTypePanel)
        contentPane.add(p6)
        contentPane.add(p7)

    }

    // The three events
    public void keyTyped(KeyEvent e)
    {
    }

    public void keyPressed(KeyEvent e)
    {
    }
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
            setText()

        else if (e.getComponent() == this.tf1)
        {
            System.out.print(">" + encodingPanel.getEncoding())
            tf4.setText(EncodingUtil.convertToDVN(tf1.getText(), encodingPanel.getEncoding()))
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if ((e.getActionCommand()).equals("Enter"))
        {
            setText()
        }

        else if ((e.getActionCommand()).equals("clear"))
        {
            clear()
        }

        else if ((e.getActionCommand()).equals("Exit") || (e.getActionCommand()).equals("exit_item"))
        {
            System.exit(0)
        }

        else if ((e.getActionCommand()).equals("previous"))
        {
            // if u r trying to scroll on the firsts added element
            // and for some reason it is not disabled, then time to disable it
            if (vectorTracker <= 0) previous.setEnabled(false)

            Log.info("previous -> :  vector_tracker " + vectorTracker)
            next.setEnabled(true)
            setText(beanVector.elementAt(--vectorTracker))
            if (vectorTracker <= 0) previous.setEnabled(false)

            Log.info("previous -> :  vector_tracker" + vectorTracker)
        }

        else if ((e.getActionCommand()).equals("next"))
        {
            Log.info("next -> :  vector_tracker" + vectorTracker)
            previous.setEnabled(true)
            setText(beanVector.elementAt(++vectorTracker))
            if (vectorTracker >= beanVector.size() - 1) next.setEnabled(false)

            Log.info("next -> :  vector_tracker" + vectorTracker)
        }

        else if ((e.getActionCommand()).equals("about_item"))
        {
            String copyright = "\u00A9 2009 All Rights Reserved. Chetan Pandey\n" + "Pls. Contact egangotritrust@gmail.com for questions and suggestions."

            JOptionPane.showMessageDialog(this, copyright, "Monier Williams Sanskrit English Dictionary", JOptionPane.PLAIN_MESSAGE)

        }

        else if ((e.getActionCommand()).equals("itrans_encoding"))
        {
            Log.info("RTFDocsSwingDisplayer for ITRANS ENCODING DISPLAY")
            new RTFDocsSwingDisplayer("Itrans Encoding Scheme", "itrans.rtf" )
        }

        else if ((e.getActionCommand()).equals("slp_encoding"))
        {
            Log.info("RTFDocsSwingDisplayer for SLP ENCODING DISPLAY")
            new RTFDocsSwingDisplayer("SLP Encoding Scheme", DOC_PATH + "slp.rtf")
        }

        else if ((e.getActionCommand()).equals("hk_encoding"))
        {
            Log.info("RTFDocsSwingDisplayer for HK ENCODING DISPLAY")
            new RTFDocsSwingDisplayer("HK Encoding Scheme", DOC_PATH + "hk.rtf")
        }

        else if ((e.getActionCommand()).equals("ipa_encoding"))
        {
            Log.info("RTFDocsSwingDisplayer for HK ENCODING DISPLAY")
            new RTFDocsSwingDisplayer("HK Encoding Scheme", DOC_PATH + "hk.rtf")
        }

        else if ((e.getActionCommand()).equals("notes_item"))
        {
            // new help_frame()
            Log.info("*******Came in notes_item:")
            new RTFDocsSwingDisplayer("Notes on Monier Willaims Skt-Eng Dictionary", DOC_PATH + "Dictionary_Notes.rtf")
        }

        else if ((e.getActionCommand()).equals("pratyahara_item"))
        {
            new PratyahaarJFrame()
        }

        else if (e.getActionCommand().equals("clipboard")) {
            println "----"
            Clipboard clipboard;
            clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable content = clipboard.getContents(this);
            try {
                String data = (String) content.getTransferData(DataFlavor.stringFlavor);
                StringSelection contents = new StringSelection(textPane.getText());
                clipboard.setContents(contents, this);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    /**
     *
     * @param wordForSearch Must be SLP
     * @return
     */
    public List fetchMeaning(String entry){
        //DictionaryService svc = (DictionaryService) SpringUtil.getBean("DictionaryService")
        //return getDictionaryDAO().findWord(word, searchType )
        String wordForSearch = EncodingUtil.toSLP(entry, encodingPanel.getEncoding())
        Long count = DBUtil.findWordCount(wordForSearch, searchTypePanel.getSearchType())
        if(count > DictionaryConstants.DICTIONARY_MAX_RESULTS_ALLOWED){
            System.out.println("More Values than the Limit of ${DictionaryConstants.DICTIONARY_MAX_RESULTS_ALLOWED} found")
        }

        ArrayList<WordMaster> wordList = (count > 0) ? DBUtil.findWord(wordForSearch, searchTypePanel.getSearchType()) : null
        String entryInDevanagari = EncodingUtil.convertToDVN(entry, encodingPanel.getEncoding())
        String header = DictionaryUtil.createHeader(entry, entryInDevanagari , count)
        String meaning = DictionaryUtil.createBody(wordList, entry, entryInDevanagari, count)
        return [header, meaning]
    }

    public String decorateHeaderAndMeaning(String[] entries){
        List<String> meanings = []
        List<String> headers = []
        for(String en : entries) {
            List headerAndMeaning = fetchMeaning(en)
            headers << headerAndMeaning[0]
            meanings << headerAndMeaning[1] + "<br>"
        }

        StringBuffer sb = new StringBuffer()
        headers.each {
            sb.append(it)
        }
        meanings.each {
            sb.append(it)
        }

        return sb.append("<br>End of Display<br><br><br>").toString()
    }

    public void setText()
    {
        String entry = tf1.getText().trim()
        String transformedEntry = tf4.getText().trim()

        String[] entries = entry.split(",")*.trim()

        String hm = decorateHeaderAndMeaning(entries)

        //remove 2 lines below
//        ArrayList<String> xxx = svc.findSuggestions(wordForSearch, encoding)
//        Log.info(xxx.toString())

        textPane.setText(hm )
        textPane.setCaretPosition(0)

        beanVector.add(new DictionaryBean(entry, transformedEntry, encodingPanel.getEncoding(), searchTypePanel.getSearchType(), hm))
        if (beanVector.size() > 1) previous.setEnabled(true)
        vectorTracker = beanVector.size() - 1

        // Disable "next Button" if vector_tracker points to the last element
        if (vectorTracker >= beanVector.size() - 1) next.setEnabled(false)

    }

    public void setText(DictionaryBean bean)
    {
        tf1.setText(bean.getEntry())
        tf4.setText(bean.getTransformedEntry())
        textPane.setText(bean.getMeaning())
        textPane.setCaretPosition(0)
        encodingPanel.setEncodingRB(bean.getEncoding())
        searchTypePanel.setSearchTypeRB(bean.getSearchType())
    }

    public void clearTextFields()
    {
        tf1.setText("")
        tf4.setText("")
        textPane.setText("")
        //setText along will not remove the XML, print textPane.getText() to view
        textPane.setStyledDocument(new javax.swing.text.html.HTMLDocument())
    }

    public void clear()
    {
        clearTextFields()
        encodingPanel.setEncodingToDefault()
        searchTypePanel.setDefaultSearchType()
    }

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {

    }
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        println args
        MWSktEngDictionary dict = new MWSktEngDictionary()
        dict.setVisible(true)
    } // end of main
}
