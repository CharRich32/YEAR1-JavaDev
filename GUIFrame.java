package ica;

import java.awt.*;  //  all imports that have been used
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author b1044146 - Charlie Richardson - Main
 */

public class GUIFrame extends JFrame implements ActionListener, MouseMotionListener, MouseListener { // use the implementations so they can be used in the class
    
    ArrayList<FurnitureItem> aCollectionAll = new ArrayList<>(); // creates array that will store the items the user inputs
  
    double totalPrice = 0; //  sets the total price to 0
     
    private final JButton addChairBTN = new JButton();  // creates the buttons for the GUI
    private final JButton addTableBTN = new JButton();
    private final JButton addDeskBTN = new JButton();
    private final JButton clearAllBTN = new JButton();
    private final JButton totalPriceBTN = new JButton();
    private final JButton saveBTN = new JButton();
    private final JButton loadBTN = new JButton();
    private final JButton summaryBTN = new JButton();
    
    JTextField FurnitureItem = new JTextField(8);   // creates the text fields for the GUI
    JTextField typeOfWood = new JTextField(8); 
    JTextField quantity = new JTextField(8);
    
    JTextArea txtArea = new JTextArea(8,20);  // creates text field for the GUI that outputs mouse listener and action listener 
    int x,y;
    
    final JPanel warning = new JPanel();
   
    public GUIFrame(){
        super("Real Office Furniture"); 
        JFrame myFrame = new JFrame("Real Office Furniture");   // creates JFrame used for the GUI
        
        myFrame.setSize(1100,900);  //  sets size of the JFrame
        myFrame.setLayout(new BorderLayout());
        
        JPanel sidePanel = new JPanel(new GridLayout(8,1)); // sets size of panel for the buttons for the GUI
        sidePanel.setOpaque(true);
        sidePanel.setPreferredSize(new Dimension(200,800));
        myFrame.add(sidePanel, BorderLayout.WEST);
        
        addChairBTN.setPreferredSize(new Dimension(150, 50));  // sets the text and the size for the buttons
        addChairBTN.setText("Add Chair");
        sidePanel.add(addChairBTN);
        
        addTableBTN.setPreferredSize(new Dimension(150, 50));
        addTableBTN.setText("Add Table");
        sidePanel.add(addTableBTN);
        
        addDeskBTN.setPreferredSize(new Dimension(150, 50));
        addDeskBTN.setText("Add Desk");
        sidePanel.add(addDeskBTN);
        
        clearAllBTN.setPreferredSize(new Dimension(150, 50));
        clearAllBTN.setText("Clear All");
        sidePanel.add(clearAllBTN);
        
        totalPriceBTN.setPreferredSize(new Dimension(150, 50));
        totalPriceBTN.setText("Total Price");
        sidePanel.add(totalPriceBTN);
        
        saveBTN.setPreferredSize(new Dimension(150, 50));
        saveBTN.setText("Save");
        sidePanel.add(saveBTN);
        
        loadBTN.setPreferredSize(new Dimension(150, 50));
        loadBTN.setText("Load");
        sidePanel.add(loadBTN);
        
        summaryBTN.setPreferredSize(new Dimension(150, 50));
        summaryBTN.setText("Summary");
        sidePanel.add(summaryBTN);
        
        CenterPanel cp = new CenterPanel();
        cp.setOpaque(true);
        cp.setPreferredSize(new Dimension(800,800));  // create center panel for the text area to be put on
        cp.add(txtArea);
        myFrame.add(cp, BorderLayout.CENTER);
       
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setResizable(false);
        myFrame.setVisible(true);     
        
        addChairBTN.addActionListener(this);

        addTableBTN.addActionListener(this);

        addDeskBTN.addActionListener(this); 
        
        clearAllBTN.addActionListener(this);   //  adds actionlistener for the buttons if pressed
        
        totalPriceBTN.addActionListener(this);
        
        saveBTN.addActionListener(this);
        
        loadBTN.addActionListener(this);
        
        summaryBTN.addActionListener(this);
       
        txtArea.addMouseListener(this);  //  adds mouselistener for the text area 

        txtArea.addMouseMotionListener(this);
    }      
    void Summary()
    {     
        aCollectionAll.forEach((Chair) -> {  //  adds the items from the array and displays them
            System.out.println("\n "+Chair.toString());
        });
    }
    
    void clearFunction()
    {
        System.out.println("Clear All Button Pressed Items Have Been Cleared");  // clear function
        totalPrice = 0;  // sets the total price to 0
        aCollectionAll.clear(); // clears items
    }
    void saveToFile()
    {
        aCollectionAll.clear();  //  trys to save the file, then errors if it cannot be complete
        aCollectionAll.forEach((singleItem) -> {
            aCollectionAll.add(singleItem);
        });
        
        try {
            FileOutputStream fos = new FileOutputStream("file1.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(aCollectionAll);
            oos.close();
            System.out.println("\n File Saved!");
        }
        catch (IOException e)  
        {
        }
    }
    
    
    
       @Override
    public void mouseEntered(MouseEvent event)  //  mouselistener when the program is ran
    {

        txtArea.setText("Mouse Entered");

    }

    @Override
    public void mousePressed(MouseEvent event)  //  mouselistener for when the mouse is pressed "either mouse button"
    {

        if (SwingUtilities.isLeftMouseButton(event)){
            txtArea.append("\nLeft Mouse Button Clicked");
        }
        if (SwingUtilities.isMiddleMouseButton(event)){
            txtArea.append("\nMiddle Mouse Button Clicked");
        }
        if (SwingUtilities.isRightMouseButton(event)){
            txtArea.append("\nRight Mouse Button Clicked");
        }
    }
    @Override
    public void mouseReleased(MouseEvent event) //  mouselistener for when the mouse is released 
    {

        txtArea.append("\nMouse released");
    }
    
       @Override
    public void mouseMoved(MouseEvent event)  //  mouselistener for when the mouse is moved at all
    {

        x = event.getX(); y = event.getY();

    }
    
     @Override
    public void mouseDragged(MouseEvent event){} //  needed for the mouselistener / mousemotionlistener to work
    
     @Override
    public void mouseExited(MouseEvent event){}
    
     @Override
    public void mouseClicked(MouseEvent event){}
 
     @Override
    public void actionPerformed(ActionEvent event){  

        if(event.getSource() == addChairBTN){  //  if statement for each button to show when they are pressed 

            System.out.println("Chair Button Pressed");
        }

        if(event.getSource() == addTableBTN){

            System.out.println("Table Button Pressed");

        }

        if(event.getSource() == addDeskBTN){

            System.out.println("Desk Button Pressed");

        }
        
        if(event.getSource() == clearAllBTN){
  
            System.out.println("Clear All Pressed");
 
        }
        
        if(event.getSource() == totalPriceBTN){

            System.out.println("Total Price Button Pressed");

        }
        
        if(event.getSource() == saveBTN){

            System.out.println("Save Button Pressed");
        }
        
        if(event.getSource() == loadBTN){

            System.out.println("Load Button Pressed");
        }
        
        if(event.getSource() == summaryBTN){

            System.out.println("Summary Button Pressed");
            
        }
    }
        public static void main(String[] args) {
        GUIFrame myFrame = new GUIFrame();        //  displays the JFrame when the program is ran
    }    
}