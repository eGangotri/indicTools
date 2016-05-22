package com.egangotri.io

import com.egangotri.sandhi.DisplayMessage;
import com.egangotri.transliteratorAsSwing.TransliteratorJFrame;
import com.egangotri.util.Log;

import javax.swing.*
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by user on 5/22/2016.
 */
public class FileIO {
    public static boolean writeFile(File file, JTextArea jta) {
//        FileOutputStream fos = null;
//        OutputStreamWriter osw = null;
//        BufferedWriter bw = null;

        try {
//            fos = new FileOutputStream(file);
//            osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
//            bw = new BufferedWriter(osw);
//
//            OutputStreamWriter oswr = new OutputStreamWriter(System.out, StandardCharsets.UTF_8);
//            oswr.write("\nTEST TO CHECK OSW *\u0915*\u0916*\u0917*\u0918*\u0919*\u0920*\u0921*");
//            oswr.flush();
            String txt = jta.getText();
//            for (int i = 0; i < txt.length(); i++) {
//                // Log.logInfo(txt.charAt(i));
//                oswr.write(txt.charAt(i));
//                oswr.flush();
//                bw.write(txt.charAt(i));
//            }
//            bw.flush();
//            bw.close();
            file.write(txt)
            return true;
        } catch (FileNotFoundException fnf) {
            Log.logInfo("FileNotFoundException");
            String err_msg = "File name you entered \"" + file.getPath() + "\" not found.\nPls try again";
            JOptionPane.showMessageDialog(jta, err_msg, "File Not Found Error", JOptionPane.ERROR_MESSAGE);
            // fnf.printStackTrace();
            return false;
        } catch (IOException ioe) {
            Log.logInfo("IOException");
            String err_msg = "File name you entered \"" + file.getPath() + "\" cannot be found.\nPls try again";
            JOptionPane.showMessageDialog(jta, err_msg, "Input/Output Error", JOptionPane.ERROR_MESSAGE);
            // ioe.printStackTrace();
            return false;
        }

    }

    public static void saveText(TransliteratorJFrame tjf, JTextArea jta, JPanel p2) {
        JFileChooser chooser = new JFileChooser();

        chooser.setMultiSelectionEnabled(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", ".txt", "text");
        chooser.setFileFilter(filter);

        // Ask User to choose File
        int option = chooser.showSaveDialog(tjf);

        Log.logInfo("JFileChooser.APPROVE_OPTION  = " + JFileChooser.APPROVE_OPTION);

        // If User chooses a to open a File
        if (option == JFileChooser.APPROVE_OPTION) {
            // If the User chooses a File
            if (chooser.getSelectedFile() != null) {
                Log.logInfo("You chose to save this file as " + chooser.getSelectedFile().getPath());

                // Complete Name of File Chosen
                String path = chooser.getSelectedFile().getAbsolutePath();
                Log.logInfo("File name chosen for saving is " + path);

                // Short Name of File Chosen
                String shortpath = chooser.getSelectedFile().getName();
                Log.logInfo("Short File name chosen for saving is " + shortpath);

                // If File doesnt end with .rtf then automatically provide it
                if (!path.endsWith(".txt")) path += ".txt";

                File file = new File(path);

                // If their is no File by that Name
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                        FileIO.writeFile(file, jta);
                    } // end of try

                    // Catch handles the situation when a filename entered is
                    // errorneous
                    catch (IOException ioe) {
                        Log.logInfo("IOException");
                        String err_msg = "The filename, directory name, or volume label syntax of file name specified \n\"" + file.getName() + "\" \n" + "in" + "\n" + "\"" + file.getParent() + "\"\nis incorrect.\nPls try again";
                        JOptionPane.showMessageDialog(jta, err_msg, "Input/Output Error", JOptionPane.ERROR_MESSAGE);
                    } // end of catch

                }// end of if (!file.exists())

                // If a File of that name exists already.
                else { // File Already Exists...Permission to Overwrite
                    String overwrite = "File \n\"" + file.getName() + "\" \n" + "in" + "\n\"" + file.getParent() + "\"\n will be overwritten. Continue?";

                    int resp = (new DisplayMessage()).yes_no_dialog(p2, overwrite);
                    if (resp == 0) writeFile(file, jta);
                } // end of else

            } // end of if (chooser.getSelectedFile() != null

        }

    } // end of function


    public static boolean readFile(File file, JTextArea jta) {
        if (file && !file.name.endsWith(".txt")) {
            String err_msg = "File Must end with .txt\nPls try again";
            JOptionPane.showMessageDialog(jta, err_msg, "File Not Found Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            String content = file.getText()
            jta.setText(content);
            return true;
        }
        catch (UnsupportedEncodingException e) {
            Log.logInfo(e.getMessage());
            String err_msg = "UnsupportedEncodingException while reading \n" + "\"" + file.getName() + "\"" + "\n" + "in" + "\n" + "\"" + file.getParent() + "\"" + "\nPls try again";
            JOptionPane.showMessageDialog(jta, err_msg, "File Not Found Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        catch (FileNotFoundException fnf) {
            Log.logInfo("FileNotFoundException");
            String err_msg = "Filename you entered \n" + "\"" + file.getName() + "\"" + "\n" + "in" + "\n" + "\"" + file.getParent() + "\"" + "\nwas not found.\nPls try again";
            JOptionPane.showMessageDialog(jta, err_msg, "File Not Found Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (IOException ioe) {
            Log.logInfo("IOException");
            String err_msg = "Input/Output Error when reading from file\n" + "\"" + file.getName() + "\"" + "\n" + "in" + "\n" + "\"" + file.getParent() + "\"" + "\nPls try again";
            JOptionPane.showMessageDialog(jta, err_msg, "Input/Output Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

}
