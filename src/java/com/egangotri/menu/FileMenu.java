package com.egangotri.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FileMenu extends JMenu implements ActionListener
{
    JMenuItem exitItem;

    public FileMenu()
    {
        super("File");
        exitItem = new JMenuItem("Exit");
        exitItem.setActionCommand("exit_item");
        exitItem.addActionListener(this);
        exitItem.setMnemonic(java.awt.event.KeyEvent.VK_X);
        this.add(exitItem);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if ((e.getActionCommand()).equals("Exit") || (e.getActionCommand()).equals("exit_item"))
        {
            System.exit(0);
        }
    }

}
