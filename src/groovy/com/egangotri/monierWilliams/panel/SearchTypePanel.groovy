package com.egangotri.monierWilliams.panel

import com.egangotri.monierWilliams.util.DictionaryConstants

import javax.swing.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

public class SearchTypePanel extends JPanel implements ActionListener
{

    JRadioButton                   exactRB, leftRB, rightRB, allRB
    
    String       searchType = DictionaryConstants.EXACT
    
    public SearchTypePanel(){
        super()

        exactRB = new JRadioButton("Exact")
        exactRB.setSelected(true)
        exactRB.setActionCommand("exactRB")
        exactRB.addActionListener(this)

        leftRB = new JRadioButton("Left")
        leftRB.setActionCommand("leftRB")
        leftRB.addActionListener(this)

        rightRB = new JRadioButton("Right")
        rightRB.setActionCommand("rightRB")
        rightRB.addActionListener(this)

        allRB = new JRadioButton("All")
        allRB.setActionCommand("allRB")
        allRB.addActionListener(this)

        ButtonGroup buttonGroup2 = new ButtonGroup()
        buttonGroup2.add(exactRB)
        buttonGroup2.add(leftRB)
        buttonGroup2.add(rightRB)
        buttonGroup2.add(allRB)

        this.add(exactRB)
        this.add(leftRB)
        this.add(rightRB)
        this.add(allRB)
    }
    
    public void setSearchTypeRB(String searchType)
    {
        if (searchType.equals(DictionaryConstants.LEFT))
        {
            leftRB.setSelected(true)
        }
        else if (searchType.equals(DictionaryConstants.RIGHT))
        {
            rightRB.setSelected(true)
        }
        else if (searchType.equals(DictionaryConstants.ALL))
        {
            allRB.setSelected(true)
        }
        else
        {
            exactRB.setSelected(true)
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if ((e.getActionCommand()).equals("exactRB"))
        {
            searchType = DictionaryConstants.EXACT
        }

        else if ((e.getActionCommand()).equals("leftRB"))
        {
            searchType = DictionaryConstants.LEFT
        }
        else if ((e.getActionCommand()).equals("rightRB"))
        {
            searchType = DictionaryConstants.RIGHT
        }

        else if ((e.getActionCommand()).equals("allRB"))
        {
            searchType = DictionaryConstants.ALL
        }        
    }


    public void setDefaultSearchType(){
        searchType = DictionaryConstants.EXACT
        exactRB.setSelected(true)
    }
    
}
