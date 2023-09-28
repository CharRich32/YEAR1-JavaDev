
package ica;

import java.awt.*;  //  all imports that have been used
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author b1044146 - Charlie Richardson
 */

public class CenterPanel extends JPanel //  exteneds of the JPanel for the GUI
{

    public CenterPanel()
    {
        
        setBorder(new EmptyBorder(10, 10, 10, 10));  //  sets the sizxe of the empty borders 
        setLayout(new BorderLayout());
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3,3,20,20));  //  creates and sets the grid layout and size
        gridPanel.setPreferredSize(new Dimension(400,400));
        
        ImageIcon[] images = new ImageIcon[9];  //  for images to be set in an array
        
        JLabel one = new JLabel();  //  creates all the JLabels for the images to be set on 
        one.setPreferredSize(new Dimension(100,100));  //  sets the size for each of these labels on the center panel
        gridPanel.add(one);
        
        JLabel two = new JLabel();
        two.setPreferredSize(new Dimension(100,100));
        gridPanel.add(two);
       
        JLabel three = new JLabel();
        three.setPreferredSize(new Dimension(100,100));
        gridPanel.add(three);
        
        JLabel four = new JLabel();
        four.setPreferredSize(new Dimension(100,100));
        gridPanel.add(four);
        
        JLabel five = new JLabel();
        five.setPreferredSize(new Dimension(100,100));
        gridPanel.add(five);
        
        JLabel six = new JLabel();
        gridPanel.add(six);
        
        JLabel seven = new JLabel();
        gridPanel.add(seven);
        
        JLabel eight = new JLabel();
        gridPanel.add(eight);
        
        JLabel nine = new JLabel();
        gridPanel.add(nine);
        
        add(gridPanel, BorderLayout.NORTH);  //  adds the grid to the north of the panel
        
        JPanel outputPanel = new JPanel();
        outputPanel.setPreferredSize(new Dimension (400,200));
       
        add(outputPanel, BorderLayout.SOUTH);  //  adds output panel to the south 
        
        
        
    }
    
    {
        
    }
}
