package Windows;



import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
import java.awt.event.MouseAdapter;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class GridLayoutExample{
	
	
	Statement stat;

	static ArrayList<String> maleNames = new ArrayList<String>();
	static ArrayList<String> femaleNames = new ArrayList<String>();
	static ArrayList<String> lastNames = new ArrayList<String>();
	ArrayList<JPanel> spot_array = new ArrayList();
	
	ArrayList<Integer> deletedPID = new ArrayList();
      
	  
	static ArrayList<Integer> pidArray = new ArrayList<Integer>();
	
	static ArrayList<Integer> daysArray = new ArrayList<Integer>();
	
	Calendar cal = Calendar.getInstance();
	int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
	

	
	boolean selected = false;
	
	int currentSelectedPID;
	
	int currentDay = 0;

    public JPanel createContentPane (){
        
    	
    	Border blackline, raisedetched, loweredetched,
        raisedbevel, loweredbevel, empty, color;

 blackline = BorderFactory.createLineBorder(Color.black);
 raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
 loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
 raisedbevel = BorderFactory.createRaisedBevelBorder();
 loweredbevel = BorderFactory.createLoweredBevelBorder();
 empty = BorderFactory.createEmptyBorder();
 
 color = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black);
 

 	    daysArray.add(dayOfMonth);
 
 
        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);
        
       
       
        
        // infoSideBar and Items...   ######################################################################################################

        
        // We create a JPanel with the GridLayout.
        JPanel infoSideBar = new JPanel();
        infoSideBar.setLayout(null);
        infoSideBar.setPreferredSize(new Dimension(320, 950));
        infoSideBar.setBackground(Color.LIGHT_GRAY);
        infoSideBar.setBounds(30, 20, 320, 970);
        infoSideBar.setBorder(loweredbevel);
        
        
       
        
        
        
        JLabel infoSideBarTitle = new JLabel("SPOT DETAILS");
        infoSideBarTitle.setOpaque(true);
        infoSideBarTitle.setPreferredSize(new Dimension(320, 20)); 
        infoSideBarTitle.setForeground(Color.WHITE);
        infoSideBarTitle.setBackground(Color.DARK_GRAY);
        infoSideBar.add(infoSideBarTitle);
        
        
        
        
        
        
        
        
        JPanel analysisSideBar = new JPanel();

        
        
     //  analysisSideBar.setLayout(null);
        analysisSideBar.setBackground(Color.LIGHT_GRAY);
        analysisSideBar.setBounds(1450, 20, 425, 970);
        analysisSideBar.setBorder(loweredbevel);
        
        
        
        
        
        
        
        
        JPanel sideBarGroupingsContainer = new JPanel();
        JPanel insertGroupingContainer = new JPanel();
        JPanel ticketContainer = new JPanel();
        
        ticketContainer.setBackground(Color.red);
        
        
        sideBarGroupingsContainer.setLayout(null);
//        insertGroupingContainer.setLayout(new GridLayout(1,1));
//        ticketContainer.setLayout(new GridLayout(1,1));
        
        
        JPanel sideBarGroupings= new JPanel();
     
        
        
        
         
        JPanel  sideBarButtonGroupings= new JPanel();
        JPanel insertGrouping = new JPanel();
        insertGrouping.setLayout(new GridLayout(0,1));
        
        JPanel ticketBox = new JPanel();
        ticketBox.setLayout(new GridLayout(0,1));
        
        
        
        insertGrouping.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        ticketBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        

        JPanel noSideBarGroupings = new JPanel();
        
        JLabel noSelection = new JLabel("No Spot Selected");
        noSideBarGroupings.add(noSelection);
        noSelection.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0));
        
        
      //  sideBarGroupings.setLayout(new BoxLayout(sideBarGroupings, BoxLayout.Y_AXIS));
        sideBarGroupings.setLayout(new GridLayout(0,1));
        sideBarGroupings.setBorder(color);
        
        sideBarButtonGroupings.setLayout(new GridLayout(0,1));
        sideBarButtonGroupings.setBorder(color);
        
        noSideBarGroupings.setLayout(new GridLayout(0,1));
        noSideBarGroupings.setBorder(color);
        
        
        JLabel p_id = new JLabel();
        JLabel st_name = new JLabel();
        JLabel st_id = new JLabel();
        JLabel st_permit_type = new JLabel();
        JLabel spot_permit_type = new JLabel();
        JLabel age = new JLabel();
        JLabel license = new JLabel();
        
       
        
        
        JPanel ButtonGroupContainers = new JPanel();

      ButtonGroupContainers.setLayout(null);
      ticketContainer.setLayout(null);
      sideBarButtonGroupings.setLayout(null);
      
      
      ticketContainer.add(ticketBox);
        
        
        infoSideBar.add(sideBarGroupingsContainer);
        infoSideBar.add(ButtonGroupContainers);
        infoSideBar.add(insertGroupingContainer);
        
        
        
        
        
        
        
        
        
       // JPanel 
        
        
        
      //  sideBarGroupingsContainer.add(sideBarGroupings);
        sideBarGroupingsContainer.add(noSideBarGroupings);
        insertGroupingContainer.add(insertGrouping);
        
        
        
        sideBarGroupings.add(p_id);
        sideBarGroupings.add(st_name);
        sideBarGroupings.add(st_id);
        sideBarGroupings.add(license);
        sideBarGroupings.add(st_permit_type);
        sideBarGroupings.add(age);
        
        
        
        
        JLabel removeSelected = new JLabel("Remove");
        JLabel addNewRandom = new JLabel("Add Random Driver");
        JLabel addUserSpecific = new JLabel("Add Specific Driver");
        
        JLabel nextDay = new JLabel("Next Day");
        
        JLabel previousDay = new JLabel("Previous Day");
        
      
        
        sideBarButtonGroupings.add(removeSelected);
        sideBarButtonGroupings.add(addNewRandom);
       // sideBarButtonGroupings.add(addUserSpecific);
        
        removeSelected.setBounds(70, 40, 150, 40);
        removeSelected.setHorizontalAlignment(SwingConstants.CENTER);
        removeSelected.setVerticalAlignment(SwingConstants.CENTER);
        removeSelected.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        addNewRandom.setBounds(70, 100, 150, 40);
        addNewRandom.setHorizontalAlignment(SwingConstants.CENTER);
        addNewRandom.setVerticalAlignment(SwingConstants.CENTER);
        addNewRandom.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        addUserSpecific.setBounds(70, 180, 150, 40);
        addUserSpecific.setHorizontalAlignment(SwingConstants.CENTER);
        addUserSpecific.setVerticalAlignment(SwingConstants.CENTER);
        addUserSpecific.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        removeSelected.setOpaque(true);
        addNewRandom.setOpaque(true);
        addUserSpecific.setOpaque(true);
        
        
        
        
        
         removeSelected.setBackground(Color.LIGHT_GRAY);
         addNewRandom.setBackground(Color.LIGHT_GRAY);
         addUserSpecific.setBackground(Color.LIGHT_GRAY);
     	
      	
     
     	removeSelected.setForeground(Color.DARK_GRAY);
      	addNewRandom.setForeground(Color.DARK_GRAY);
      	addUserSpecific.setForeground(Color.DARK_GRAY);
        
      	
      	
      	
      	
        
        
        //removeSelected.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
//        removeSelected.setBackground(Color.red);
        
        
      
//        removeSelected.setPreferedSize(100, 20);
//        removeSelected.setMaximumSize(100, 20);
//        
        
//        removeSelected.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
//        addNewRandom.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
//
//        addUserSpecific.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        
        
        ButtonGroupContainers.add(sideBarButtonGroupings);
        
        
        
        
        
        
        
//        p_id.setBorder(loweredbevel);
//	        st_name.setBorder(loweredbevel);
//	        st_id.setBorder(loweredbevel);
//	        st_permit_type.setBorder(loweredbevel);
//	        spot_permit_type.setBorder(loweredbevel);
//	        age.setBorder(loweredbevel);
//	        license.setBorder(loweredbevel);
	        
        p_id.setText("<html><font color=#0000FF><strong>Parking Spot #:</strong></font> " );
	       st_name.setText("<html><font color=#0000FF><strong>Name: </strong></font> ");
	      st_id.setText("<html><font color=#0000FF><strong>Student ID #: </strong></font> ");
	     age.setText("<html><font color=#0000FF><strong>Age: </strong></font> ");
	    license.setText("<html><font color=#0000FF><strong>License #: </strong></font> " );

	     st_permit_type.setText("<html><font color=#0000FF><strong>Student Permit Type: </strong></font> " );
	     
	     
//	     age.setOpaque(true);
//	        age.setBackground(Color.green);
	        
	       p_id.setBorder(loweredbevel);
	        st_name.setBorder(loweredbevel);
	        st_id.setBorder(loweredbevel);
	        st_permit_type.setBorder(loweredbevel);
	        spot_permit_type.setBorder(loweredbevel);
	        age.setBorder(loweredbevel);
	        license.setBorder(loweredbevel);
	        
	        
	        p_id.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
	       st_name.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
	      st_id.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
	     age.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
	    license.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
	   st_permit_type.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
	   
	   
	    
       
        
        
//        infoSideBar.add(p_id);
//        infoSideBar.add(st_name);
//        infoSideBar.add(age);
//        infoSideBar.add(st_id);
//        infoSideBar.add(st_permit_type);
//        infoSideBar.add(license);
//        infoSideBar.add(spot_permit_type);
        
        sideBarGroupings.setBackground(Color.white);
        noSideBarGroupings.setBackground(Color.white);
       // ButtonGroupContainers.setBackground(Color.red);
        
        
     
       
        
//        sideBarGroupings.setPreferredSize(new Dimension(5, 5)); 
       sideBarGroupingsContainer.setBounds(15, 20, 290, 300);
       sideBarGroupings.setBounds(0, 0, 290, 300);
       noSideBarGroupings.setBounds(0, 0, 290, 300);
       
       
       
      
       
       
       ButtonGroupContainers.setBounds(15, 350, 290, 200);
       sideBarButtonGroupings.setBounds(0, 0, 290, 200);
       
       insertGroupingContainer.setBounds(15, 575, 290, 380);
       
       //.setBounds(1450, 20, 425, 970);
       
       
            
       ticketContainer.setLayout(null);
       ticketBox.setLayout(null);
       
       analysisSideBar.setLayout(new GridLayout(0,1));
       
       JPanel graph = new JPanel();
       
       graph.setBackground(Color.red);
       
    analysisSideBar.add(graph);
    
    
    
    
    
    
    JPanel tBox = new JPanel();
    tBox.setLayout(null);
   
    
    JLabel hasTicket = new JLabel("Ticket: ");
    hasTicket.setOpaque(true);
   
    JLabel cost = new JLabel("Cost: $______ ");
    cost.setOpaque(true);
    tBox.add(hasTicket);
    
    
    hasTicket.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
   
    hasTicket.setBounds(40, 40, 200, 20);
 
    
    JLabel ticketComment = new JLabel();
    tBox.add(ticketComment);
    ticketComment.setBackground(Color.WHITE);
    
    tBox.setBackground(Color.LIGHT_GRAY);
    
    
    
 analysisSideBar.add(tBox);
    
    
      // tBox.setLayout(null);
       
       
     //  analysisSideBar.add(ticketContainer);

       
       ticketContainer.setBounds(1450, 350, 290, 200);
       
       
    
       
       tBox.setBounds(1400, 350, 290, 200);
       
       
     
       ticketContainer.setBackground(Color.black);
       sideBarButtonGroupings.setBounds(0, 0, 290, 200);
       
       insertGroupingContainer.setBounds(15, 575, 290, 380);
       
       
      // insertGrouping.setBounds(0, 0, 290, 300);
       
       
       insertGrouping.setLayout(new GridLayout(0,1));
       
       
       
       
       JTextField nameInput = new JTextField();
       JTextField stidInput = new JTextField();
       JTextField licenseInput = new JTextField();
       JTextField permitInput = new JTextField();
       JTextField ageInput = new JTextField();
       
       JLabel nameLabel = new JLabel("Name: ");
       stidInput.setPreferredSize(new Dimension(200,20));
       
       JLabel stidLabel = new JLabel("Student ID: ");
       stidInput.setPreferredSize(new Dimension(200,20));
       
       JLabel licenseLabel = new JLabel("License: ");
       licenseInput.setPreferredSize(new Dimension(200,20));
       
       JLabel permitLabel = new JLabel("Permit Type: ");
       permitInput.setPreferredSize(new Dimension(200,20));
       
       JLabel ageLabel = new JLabel("Age: ");
       ageInput.setPreferredSize(new Dimension(200,20));
       
       
      
       
       
       
       
       insertGrouping.add(nameLabel);
       insertGrouping.add(nameInput);
       
       insertGrouping.add(stidLabel);
       insertGrouping.add(stidInput);
       
       insertGrouping.add(licenseLabel);
       insertGrouping.add(licenseInput);
       
       insertGrouping.add(permitLabel);
       insertGrouping.add(permitInput);
       
       insertGrouping.add(ageLabel);
       insertGrouping.add(ageInput);
       
       insertGrouping.add(addUserSpecific);
       
       
       nameInput.setBackground(Color.LIGHT_GRAY);
       stidInput.setBackground(Color.LIGHT_GRAY);
       licenseInput.setBackground(Color.LIGHT_GRAY);
       permitInput.setBackground(Color.LIGHT_GRAY);
       ageInput.setBackground(Color.LIGHT_GRAY);
       
      
       
       
       
       
       
       // BUTTONS/CLICK EVENTS ####################################################################################################
       
       removeSelected.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
         
          	 
          	 
          	 try {
       			connection = DriverManager.getConnection("jdbc:sqlite:Parking.db");
       			Statement stat = connection.createStatement();
       			
       			
       			String sql = "SELECT p_occupied as occupied "
			       		  + "FROM spot_types "
			       		  + "WHERE p_id = " + currentSelectedPID + " ;";
			
       			ResultSet rt = stat.executeQuery(sql);
       			
       			int occupied = rt.getInt("occupied");
       			
       		//	System.out.println("Occupied " + occu);
    
       			rt.close();
       			
       		
       			
       	        if ( occupied == 1){
       	        	
       	     	removeSelected.setCursor(new Cursor(Cursor.HAND_CURSOR));
       	        	
       	        	String deleteFromParks = "DELETE FROM s_parks WHERE p_id = " + currentSelectedPID + ";";
       	        	stat.executeUpdate(deleteFromParks);
       	        	
       	        	String deleteFromPerson = "DELETE FROM person WHERE p_id = " + currentSelectedPID + ";";
       	        	stat.executeUpdate(deleteFromPerson);
       	        	
       	        	
       	        	String updateSpot_types = "UPDATE spot_types "
												+ "SET p_occupied = 0 "
												+ "WHERE p_id = " + currentSelectedPID+ ";";
       	        	stat.executeUpdate(updateSpot_types);
       	        	
       	        	
       	        	
       	        	
       	      
       	        	
       	        	sideBarGroupingsContainer.removeAll();
     	        	//sideBarGroupingsContainer.setBackground(Color.red);
     	        	sideBarGroupingsContainer.add(noSideBarGroupings);
     	        	noSelection.setText("Empty Spot");
     	        	totalGUI.repaint();

     	        	
     	        	removeSelected.setOpaque(true);
      	           removeSelected.setBackground(Color.LIGHT_GRAY);
      	           addUserSpecific.setBackground(Color.DARK_GRAY);
     	        	
     	        	addNewRandom.setOpaque(true);
     	        	addUserSpecific.setOpaque(true);
     	        	
     	        	
     	        	addNewRandom.setBackground(Color.GREEN);
     	        	addUserSpecific.setBackground(Color.GREEN);
     	        	
     	        	addNewRandom.setForeground(Color.DARK_GRAY);
     	        	addUserSpecific.setForeground(Color.DARK_GRAY);
     	        	
     	        	
     	        	
     	        	spot_array.get(currentSelectedPID - 1).setBackground(Color.GREEN);
       	        	
     	        	deletedPID.add(currentSelectedPID);
     	        	
     	        	 nameInput.setBackground(Color.LIGHT_GRAY);
           	         stidInput.setBackground(Color.LIGHT_GRAY);
           	         licenseInput.setBackground(Color.LIGHT_GRAY);
           	         permitInput.setBackground(Color.LIGHT_GRAY);
           	         ageInput.setBackground(Color.LIGHT_GRAY);
           	         
           	         
       	         totalGUI.repaint();
       	        }
       	        
       	        else
       	        {
       	        	
       	         
       	        
       	         
       	         
       	      nameInput.setBackground(Color.WHITE);
  		       stidInput.setBackground(Color.WHITE);
  		       licenseInput.setBackground(Color.WHITE);
  		       permitInput.setBackground(Color.WHITE);
  		       ageInput.setBackground(Color.WHITE);
       	         
       	        
       	         
       	        	
       	    totalGUI.repaint();

       	    System.out.println("Nothing");
       	        }
       	     
       		} catch (SQLException e1) {
       			// TODO Auto-generated catch block
       			e1.printStackTrace();
       		}
          	 
          	 
         
          	 totalGUI.repaint();
          	 
              //spot_array.get(index).setBackground(Color.red);
         
              
              
           }
       });
       
       
       
       
       
       
       
       
       
       
       
       
       addNewRandom.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
         
          	 
          	 
          	 try {
       			connection = DriverManager.getConnection("jdbc:sqlite:Parking.db");
       			Statement stat = connection.createStatement();
       			
       			
       			

       			String sql = "	SELECT p_occupied as occupied "
			       		  + "FROM spot_types "
			       		  + "WHERE p_id = " + currentSelectedPID + " ;";
			
       			ResultSet rs = stat.executeQuery(sql);
       			
       			int occupied = rs.getInt("occupied");
       			
       			
       			
       			
       			
//       			currentSelectedPID = index + 1;
//      			System.out.println(currentSelectedPID);
       			
       			System.out.println("OCCUPIED: " + occupied);
       			


      			rs.close();
       			
       			
       	        if ( occupied == 0){
       	        	
       	        	String deleteFromParks = "DELETE FROM s_parks WHERE p_id = " + currentSelectedPID + ";";
       	        	stat.executeUpdate(deleteFromParks);
       	        	
       	        	String deleteFromPerson = "DELETE FROM person WHERE p_id = " + currentSelectedPID + ";";
       	        	stat.executeUpdate(deleteFromPerson);
       	        	
       	        	
       	        	String updateSpot_types = "UPDATE spot_types "
												+ "SET p_occupied = 0 "
												+ "WHERE p_id = " + currentSelectedPID+ ";";
       	        	stat.executeUpdate(updateSpot_types);
       	        	
       	        	
       	        	
       	     	addNewRandom.setCursor(new Cursor(Cursor.HAND_CURSOR));
       	        	
       	        
       	        	
       		  insertRandomPerson(currentSelectedPID);
       	      
  			  String insertS_parks = 	"INSERT INTO s_parks(p_id, st_id, permit_type) "
									  + "SELECT p_id as p_id, st_id as st_id, permit_type as permit_type "
									  + "FROM person "
									  + "WHERE p_id = "+ currentSelectedPID + ";";
		 
  			  
  			  
  			  stat.executeUpdate(insertS_parks);
  			  
  			  
  			String updateSpot_type = "UPDATE spot_types "
					+ "SET p_occupied = 1 "
					+ "WHERE p_id = " + currentSelectedPID + ";";
  			stat.executeUpdate(updateSpot_type);
  		
  	      	
     	        	
  			removeSelected.setOpaque(true);
	           removeSelected.setBackground(Color.green);
	        	
	       	addNewRandom.setOpaque(true);
       	addUserSpecific.setOpaque(true);

       	
       	addNewRandom.setBackground(Color.LIGHT_GRAY);
       	addUserSpecific.setBackground(Color.LIGHT_GRAY);
       	
       	addNewRandom.setForeground(Color.DARK_GRAY);
       	addUserSpecific.setForeground(Color.DARK_GRAY);
       	
       	
   	
 
	        	
	        	sideBarGroupingsContainer.removeAll();
	        	sideBarGroupingsContainer.add(sideBarGroupings);
	        	
	        	

      			String sql1 = "select s_parks.p_id as p_id, name as name, sex as sex, person.st_id as st_id, s_parks.permit_type as permit_type, license as license,  phone as phone, age as age, p_occupied as p_occupied "
								+ "FROM s_parks, person, spot_types "
								+ "WHERE person.p_id = s_parks.p_id "
								+ "		 AND s_parks.p_id = "+ (currentSelectedPID) + " "
								+ "      AND spot_types.p_id = s_parks.p_id;";
      			
      			 rs = stat.executeQuery(sql1);
	        	
	        	
	        p_id.setText("<html><font color=#0000FF><strong>Parking Spot #:</strong></font> " + rs.getString("p_id"));
	       st_name.setText("<html><font color=#0000FF><strong>Name: </strong></font> " + rs.getString("name"));
	      st_id.setText("<html><font color=#0000FF><strong>Student ID #: </strong></font> " + rs.getString("st_id"));
	     age.setText("<html><font color=#0000FF><strong>Age: </strong></font> " + rs.getString("age"));
	    license.setText("<html><font color=#0000FF><strong>License #: </strong></font> " + rs.getString("license"));
	     st_permit_type.setText("<html><font color=#0000FF><strong>Student Permit Type: </strong></font> " + rs.getString("permit_type"));
	     
	     
	     nameInput.setBackground(Color.WHITE);
	       stidInput.setBackground(Color.WHITE);
	       licenseInput.setBackground(Color.WHITE);
	       permitInput.setBackground(Color.WHITE);
	       ageInput.setBackground(Color.WHITE);
 	         
 	        
	       
	    totalGUI.repaint();
	    


			rs.close();

     	        	
     	        	spot_array.get(currentSelectedPID - 1).setBackground(Color.RED);
       	        	
     	        	//deletedPID.add(currentSelectedPID);
       	         totalGUI.repaint();
       	        }
       	        
       	        else
       	        {
       	        	
       	         
       	         nameInput.setBackground(Color.LIGHT_GRAY);
       	         stidInput.setBackground(Color.LIGHT_GRAY);
       	         licenseInput.setBackground(Color.LIGHT_GRAY);
       	         permitInput.setBackground(Color.LIGHT_GRAY);
       	         ageInput.setBackground(Color.LIGHT_GRAY);
       	         
       	        
       	         
       	        	
       	    System.out.println("Nothing");

       	        }
       	     
       		} catch (SQLException e1) {
       			// TODO Auto-generated catch block
       			e1.printStackTrace();
       		}
          	 
          	 
          	
          	 totalGUI.repaint();
          	 
              //spot_array.get(index).setBackground(Color.red);
         
              
              
           }
       });
       
       
       
       
       
       
       
       addUserSpecific.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
         
          	 
          	 
          	 try {
       			connection = DriverManager.getConnection("jdbc:sqlite:Parking.db");
       			Statement stat = connection.createStatement();
       			
       			
       			

       			String sql = "	SELECT p_occupied as occupied "
			       		   + "FROM spot_types "
			       		   + "WHERE p_id = " + currentSelectedPID + " ;";
			
       			ResultSet rs = stat.executeQuery(sql);
       			
       			int occupied = rs.getInt("occupied");
       			
       			
       			
       			
       			
//       			currentSelectedPID = index + 1;
//      			System.out.println(currentSelectedPID);
       			
       			System.out.println("OCCUPIED: " + occupied);
       			


      			rs.close();
       			
       			
       	        if ( occupied == 0){
       	        	
       	        	String deleteFromParks = "DELETE FROM s_parks WHERE p_id = " + currentSelectedPID + ";";
       	        	stat.executeUpdate(deleteFromParks);
       	        	
       	        	String deleteFromPerson = "DELETE FROM person WHERE p_id = " + currentSelectedPID + ";";
       	        	stat.executeUpdate(deleteFromPerson);
       	        	
       	        	
       	        	String updateSpot_types = "UPDATE spot_types "
												+ "SET p_occupied = 0 "
												+ "WHERE p_id = " + currentSelectedPID+ ";";
       	        	stat.executeUpdate(updateSpot_types);
       	        	
       	        	
       	        	
       	     	addNewRandom.setCursor(new Cursor(Cursor.HAND_CURSOR));
       	        	
       	        
       	        	
       		  insertRandomPerson(currentSelectedPID);
       		  
       		insertCustomPerson( currentSelectedPID, Integer.parseInt(stidInput.getText()), nameInput.getText(), permitInput.getText(), licenseInput.getText(), Integer.parseInt(ageInput.getText())); 
       		  
       		  
       		  
       		stidInput.setText("");
       		nameInput.setText("");
       		permitInput.setText("");
       		licenseInput.setText("");
       		ageInput.setText("");
       		  
       		  
       		  
       		  
       		  
       	      
  			  String insertS_parks = 	"INSERT INTO s_parks(p_id, st_id, permit_type) "
									  + "SELECT p_id as p_id, st_id as st_id, permit_type as permit_type "
									  + "FROM person "
									  + "WHERE p_id = "+ currentSelectedPID + ";";
		 
  			  
  			  
  			  stat.executeUpdate(insertS_parks);
  			  
  			  
  			String updateSpot_type = "UPDATE spot_types "
					+ "SET p_occupied = 1 "
					+ "WHERE p_id = " + currentSelectedPID + ";";
  			stat.executeUpdate(updateSpot_type);
  		
  	      	
     	        	
  			removeSelected.setOpaque(true);
	           removeSelected.setBackground(Color.green);
	        	
	       	addNewRandom.setOpaque(true);
       	addUserSpecific.setOpaque(true);

       	
       	addNewRandom.setBackground(Color.LIGHT_GRAY);
       	addUserSpecific.setBackground(Color.LIGHT_GRAY);
       	
       	addNewRandom.setForeground(Color.DARK_GRAY);
       	addUserSpecific.setForeground(Color.DARK_GRAY);
       	
       	
   	
 
	        	
	        	sideBarGroupingsContainer.removeAll();
	        	sideBarGroupingsContainer.add(sideBarGroupings);
	        	
	        	

      			String sql1 = "select s_parks.p_id as p_id, name as name, sex as sex, person.st_id as st_id, s_parks.permit_type as permit_type, license as license,  phone as phone, age as age, p_occupied as p_occupied "
								+ "FROM s_parks, person, spot_types "
								+ "WHERE person.p_id = s_parks.p_id "
								+ "		 AND s_parks.p_id = "+ (currentSelectedPID) + " "
								+ "      AND spot_types.p_id = s_parks.p_id;";
      			
      			 rs = stat.executeQuery(sql1);
	        	
	        	
	        p_id.setText("<html><font color=#0000FF><strong>Parking Spot #:</strong></font> " + rs.getString("p_id"));
	       st_name.setText("<html><font color=#0000FF><strong>Name: </strong></font> " + rs.getString("name"));
	      st_id.setText("<html><font color=#0000FF><strong>Student ID #: </strong></font> " + rs.getString("st_id"));
	     age.setText("<html><font color=#0000FF><strong>Age: </strong></font> " + rs.getString("age"));
	    license.setText("<html><font color=#0000FF><strong>License #: </strong></font> " + rs.getString("license"));
	     st_permit_type.setText("<html><font color=#0000FF><strong>Student Permit Type: </strong></font> " + rs.getString("permit_type"));
	     
	     nameInput.setBackground(Color.WHITE);
	       stidInput.setBackground(Color.WHITE);
	       licenseInput.setBackground(Color.WHITE);
	       permitInput.setBackground(Color.WHITE);
	       ageInput.setBackground(Color.WHITE);
 	         
 	        
	    totalGUI.repaint();
	    


			rs.close();

     	        	
     	        	spot_array.get(currentSelectedPID - 1).setBackground(Color.RED);
     	        	
     	        	
     	        	
     	        	
       	        	
     	        	//deletedPID.add(currentSelectedPID);
       	         totalGUI.repaint();
       	        }
       	        
       	        else
       	        {
       	        	
       	         
       	         nameInput.setBackground(Color.LIGHT_GRAY);
       	         stidInput.setBackground(Color.LIGHT_GRAY);
       	         licenseInput.setBackground(Color.LIGHT_GRAY);
       	         permitInput.setBackground(Color.LIGHT_GRAY);
       	         ageInput.setBackground(Color.LIGHT_GRAY);
       	         
       	        
       	         
       	    System.out.println("Nothing");

       	        }
       	     
       		} catch (SQLException e1) {
       			// TODO Auto-generated catch block
       			e1.printStackTrace();
       		}
          	 
          	 
          	
          	 totalGUI.repaint();
          	 
              //spot_array.get(index).setBackground(Color.red);
         
              
              
           }
       });
       
       
       
       
       
       
       
       
        
        
        
        
        
        
        
        
        
       
       
       nextDay.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
         
          	 
          	 
          	 try {
       			connection = DriverManager.getConnection("jdbc:sqlite:Parking.db");
       			Statement stat = connection.createStatement();
       			
       			
       		//Populate people
       			for(int i = 0; i < 111; i++){
       				insertRandomPerson("M", Integer.toString(dayOfMonth+1));
       			}
       			
       			for(int i = 0; i < 111; i++){
       				insertRandomPerson("F",Integer.toString(dayOfMonth+1));
       			}
       			
       			
       		
       	     
       		} catch (SQLException e1) {
       			// TODO Auto-generated catch block
       			e1.printStackTrace();
       		}
          	 
          	 
         
          	 totalGUI.repaint();
          	 
              //spot_array.get(index).setBackground(Color.red);
         
              
              
           }
       });
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
   
        
        // mainBar and Items...   ######################################################################################################

        
        
        JPanel mainBar = new JPanel();
        mainBar.setBackground(Color.GRAY);
        mainBar.setBounds(375, 20, 1050, 970);
        mainBar.setBorder(loweredbevel);
        
        
        
 JPanel spotsPanel = new JPanel(new GridLayout(8,27,10,40));
        
        
        JPanel row1_2 = new JPanel(new GridLayout(2,27,10, 10));
        JPanel row3_4 = new JPanel(new GridLayout(2,27,10,10));
        JPanel row5_6 = new JPanel(new GridLayout(2,27,10,10));
        JPanel row7_8 = new JPanel(new GridLayout(2,27,10,10));
        
        
      
        
        
        // create all car spots
        
       
        for( int i = 0; i < 224; i++){
        	
        	JLabel spot_type = new JLabel("R");
        	JPanel spot = createSquareJPanel(Color.green, 25);
        	spot.setCursor(new Cursor(Cursor.HAND_CURSOR));
        	spot.add(spot_type);
        	spot_array.add(spot);
        }
        
        
        JPanel idContainer = new JPanel();
        idContainer.setLayout(null);
        
        BufferedImage id_template;
        JLabel picLabel = new JLabel();
		try {
			id_template = ImageIO.read(new File("/home/ring/WSpace/Parking Analytics/src/Images/catcard.png"));
			

			 picLabel = new JLabel(new ImageIcon(id_template));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		//mainBar.add(picLabel);
        
//        picLabel.setText(new ImageIcon(myPicture));
//        add(picLabel);
        
        
      //  System.out.println("SIZE: " + spot_array.size());
        
        for( int i = 0; i < 54; i++){
        	row1_2.add(spot_array.get(i));
        }
        
        for( int i = 54; i < 108; i++){
        	row3_4.add(spot_array.get(i));
        }
        
        
        for( int i = 108; i < 162; i++){
        	row5_6.add(spot_array.get(i));
        }
        
        for( int i = 162; i < 216; i++){
        	row7_8.add(spot_array.get(i));
        }
        
        spotsPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        
        
        spotsPanel.add(row1_2);
        spotsPanel.add(row3_4);
        spotsPanel.add(row5_6);
        spotsPanel.add(row7_8);
        
        
        JLabel label= new JLabel();
        label.setText(connect());
       // mainBar.add(label); 
      
        
      
        
     
        
        
//        
        for( int i = 0; i < 224; i++){
        	
        	int index = i;
        	 spot_array.get(i).addMouseListener(new MouseAdapter() {
                 @Override
                 public void mouseClicked(MouseEvent e) {
                	 
               
                
          				 try {
                  			connection = DriverManager.getConnection("jdbc:sqlite:Parking.db");
                  			Statement stat = connection.createStatement();
                  			ArrayList<Integer> resultArray = new ArrayList();

                  			// stat.execute("Select MAX(w_warehousekey) FROM warehouse");
                  			
                  			
                  			
                  			//currentSelectedPID
                  			
                  			currentSelectedPID = index + 1;
                  			System.out.println(currentSelectedPID);
                  			
                  			
                   			String sql1 = "	SELECT p_occupied as occupied "
            			       		  + "FROM spot_types "
            			       		  + "WHERE p_id = " + currentSelectedPID + " ;";
            			
                   			ResultSet rs = stat.executeQuery(sql1);
                   			
                   			int occupied = rs.getInt("occupied");
                   			
                
                   			rs.close();
                  			
                  			
                  			
                  			
                  			
                   			
                   			
                   			
                   			if(occupied == 0)
                   			{
                   				
                   			  
                   		       nameInput.setBackground(Color.WHITE);
                   		       stidInput.setBackground(Color.WHITE);
                   		       licenseInput.setBackground(Color.WHITE);
                   		       permitInput.setBackground(Color.WHITE);
                   		       ageInput.setBackground(Color.WHITE);
                   		       
                   		       
                   				
                   				sideBarGroupingsContainer.removeAll();
                  	        	//sideBarGroupingsContainer.setBackground(Color.red);
                  	        	sideBarGroupingsContainer.add(noSideBarGroupings);
                  	        	noSelection.setText("Empty Spot");
                  	        	totalGUI.repaint();

                  	        	
                  	        	removeSelected.setOpaque(true);
                   	           removeSelected.setBackground(Color.LIGHT_GRAY);
                   	           addUserSpecific.setBackground(Color.DARK_GRAY);
                  	        	
                  	        	addNewRandom.setOpaque(true);
                  	        	addUserSpecific.setOpaque(true);
                  	        	
                  	        	
                  	        	addNewRandom.setBackground(Color.GREEN);
                  	        	addUserSpecific.setBackground(Color.GREEN);
                  	        	
                  	        	addNewRandom.setForeground(Color.DARK_GRAY);
                  	        	addUserSpecific.setForeground(Color.DARK_GRAY);
                   				
                   				
                   				
                   				
                   				
                   			}
                   			
                   			else 
                   			{
                   				
                   				removeSelected.setOpaque(true);
                   	           removeSelected.setBackground(Color.green);
                   	        	
                   	       	addNewRandom.setOpaque(true);
               	        	addUserSpecific.setOpaque(true);
               	 
               	        	
               	        	addNewRandom.setBackground(Color.LIGHT_GRAY);
               	        	addUserSpecific.setBackground(Color.LIGHT_GRAY);
               	        	
               	        	addNewRandom.setForeground(Color.DARK_GRAY);
               	        	addUserSpecific.setForeground(Color.DARK_GRAY);
               	        	
               	        	
           	        	
           	      
                   	        	
                   	        	sideBarGroupingsContainer.removeAll();
                   	        	sideBarGroupingsContainer.add(sideBarGroupings);
                   	        	
                   	        	
                   	        	String sql = "select s_parks.p_id as p_id, name as name, sex as sex, person.st_id as st_id, s_parks.permit_type as permit_type, license as license,  phone as phone, age as age, p_occupied as p_occupied "
     									+ "FROM s_parks, person, spot_types "
     									+ "WHERE person.p_id = s_parks.p_id "
     									+ "		 AND s_parks.p_id = "+ (index + 1) + " "
     									+ "      AND spot_types.p_id = s_parks.p_id;";
                  			
//                  			
//                  			String find = "SELECT p_id "
//                  					    + "FROM person "
//                  					    + "WHERE p_id = 3;";
//     									
                  			
                  			 rs = stat.executeQuery(sql);
                  			 
                  			 
                  			 
                  		


                  			// Retrieve by column name
                  			
//                  			
//                  			 occupied = 0;
//                  			occupied = rs.getInt("p_occupied");
                   	        	
                   	        p_id.setText("<html><font color=#0000FF><strong>Parking Spot #:</strong></font> " + rs.getString("p_id"));
                   	       st_name.setText("<html><font color=#0000FF><strong>Name: </strong></font> " + rs.getString("name"));
                   	      st_id.setText("<html><font color=#0000FF><strong>Student ID #: </strong></font> " + rs.getString("st_id"));
                   	     age.setText("<html><font color=#0000FF><strong>Age: </strong></font> " + rs.getString("age"));
                   	    license.setText("<html><font color=#0000FF><strong>License #: </strong></font> " + rs.getString("license"));
                   	     st_permit_type.setText("<html><font color=#0000FF><strong>Student Permit Type: </strong></font> " + rs.getString("permit_type"));
                   	     
                   	     
                   	     
                   	     
                   	     String comp0 = 
											"SELECT count(*) as out "
											+"FROM "
										 +  "(select person.permit_type, spot_types.permit_type "
																			+ "FROM person, spot_types "
																			+ "WHERE person.p_id = spot_types.p_id "
																					 + " AND spot_types.p_id = " + (index + 1) + "); "
																					+ "AND person.permit_type <> spot_types.permit_type);";	
                   	     int out = -1;
                   	  
                       	 try {
                       		rs = stat.executeQuery(comp0);
                       		
                       		System.out.println("OUT: " + rs.getInt("out"));
                    		
                       		if(rs.getInt("out")== 0){
                       			out = -1;
        	 }
                       		else
                       		{
                       			out = 0;
                       		}
                       		
                       		System.out.println("NUM: " + rs.getInt("out"));
                       		System.out.println("NUM: " + rs.getString("out"));
                       		out = 0;

                    			}
                   			

                    		

                    		 catch (SQLException e1) {
                    			// TODO Auto-generated catch block
                    			e1.printStackTrace();
                    		}
                       	 
                       	 
                       	 if( out == -1)
                       	 {
                       		hasTicket.setText("Ticket: No");
                       	 }
                       	 else
                       	 {
                       		hasTicket.setText("Ticket: Yes");
                       	 }
                       	 
               			rs = stat.executeQuery(comp0);
               			
               			
               		//	System.out.println("NUM: " + rs.getInt(0));

                   	    
               			
//               			
//               		    if( out == -1)
//                  	     {
//                  	    	 
//                  	     }
//                  	     else
//                  	     {
//                  	    	String comp1 = "select person.permit_type as type1, spot_types.permit_type as type2 "
//   								+ "FROM person, spot_types "
//   								+ "WHERE person.p_id = spot_types.p_id "
//   										  + "AND spot_types.p_id = " + (index + 1) + " "
//   										+ "AND person.permit_type <> spot_types.permit_type;";
//                      		
//   							
//             			 
//             			
//             			rs = stat.executeQuery(comp1);
//             			
//             			
//             			if(rs.getString("type1") != rs.getString("type2"))
//             			{
//             				hasTicket.setText("Ticket: Yes");
//             			
//             				 System.out.println("ticket yes");
//             			}
//             			
//             			else
//             			{
//             				hasTicket.setText("Ticket: No");
//             				
//             				System.out.println("ticket no");
//             			}
//         	
//                  	     }
//                   	     
                   	     
                  	     
                   		
                   	     
                   	    totalGUI.repaint();
                   	    

               		


                   			}
                  			
                  			
                  			

                  			
                  			
                  			
                  			
                  			
                  			
//                  			ResultSet findRes = stat.executeQuery(find);
//                  			String exists = findRes.getString(0);
//                  			
//                  			System.out.println(exists);
                  		
                  			
                  			//System.out.println("Occupied: " + rs.getInt("p_occupied"));
                  			
                  
                  	     
                  	     
                  	
                  			
                  		
                  			
                  			

                  		} catch (SQLException e1) {
                  			// TODO Auto-generated catch block
                  			e1.printStackTrace();
                  		}
                     	 
                     	 
                         //spot_array.get(index).setBackground(Color.red);
                    
//          		
//          			
//          			else
//          			{
//          				currentSelectedPID = index + 1;
//          				System.out.println(currentSelectedPID);
//          				
//          				sideBarGroupingsContainer.removeAll();
//          	        	sideBarGroupingsContainer.setBackground(Color.red);
//          	        	sideBarGroupingsContainer.add(noSideBarGroupings);
//          	        	noSelection.setText("Empty Spot");
//          	        	totalGUI.repaint();
//
//          	        	
//          	        	removeSelected.setOpaque(true);
//           	           removeSelected.setBackground(Color.LIGHT_GRAY);
//           	           addUserSpecific.setBackground(Color.DARK_GRAY);
//          	        	
//          	        	addNewRandom.setOpaque(true);
//          	        	addUserSpecific.setOpaque(true);
//          	        	
//          	        	
//          	        	addNewRandom.setBackground(Color.GREEN);
//          	        	addUserSpecific.setBackground(Color.GREEN);
//          	        	
//          	        	addNewRandom.setForeground(Color.DARK_GRAY);
//          	        	addUserSpecific.setForeground(Color.DARK_GRAY);
//          	        	
//          	        	
//          			}
//          			
          			
          			
          			
                	 
                
                    
                    
                 }
             });
             
        }
        
        
    
       	 
       	 try {
    			connection = DriverManager.getConnection("jdbc:sqlite:Parking.db");
    			Statement stat = connection.createStatement();
    			ArrayList<Integer> resultArray = new ArrayList();

    			// stat.execute("Select MAX(w_warehousekey) FROM warehouse");

    			String sql = "select p_id as spotNum "
							+"FROM spot_types "
							+"	WHERE p_occupied = 1;";
    			
    			ResultSet rs = stat.executeQuery(sql);

    			// Retrieve by column name
    			
    			while(rs.next()){
    				
    				int spot = rs.getInt("spotNum") - 1;
    				
    				//System.out.println(spot);
    				
    				spot_array.get(spot).setBackground(Color.RED);
    				
    				
    				
    			}

    			rs.close();

    		} catch (SQLException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
       	 
      
        
        
        
        
        
        
        
        
        
        
        
        
        // analysisSideBar and Items...   ######################################################################################################

        
        
      
        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new java.awt.BorderLayout());
        
    //    JFreeChart chart = new JFreeChart()
//         ..
//        ChartPanel CP = new ChartPanel(chart);
//        .. 
//        jPanel1.add(CP,BorderLayout.CENTER);
//        jPanel1.validate();
        
        LineChart_AWT c1 = new LineChart_AWT(
        	      "School Vs Years" ,
        	      "Numer of Schools vs years");
        
        
        JFreeChart barChart = ChartFactory.createBarChart(
                "Number of Vehicles",           
                "Category",            
                "Score",            
                createDataset(),          
                PlotOrientation.VERTICAL,           
                true, true, false);
                
//             ChartPanel chartPanel = new ChartPanel( barChart );        
//             chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
//             setContentPane( chartPanel ); 
        
        
  
        
        XYSeries series = new XYSeries("asdf");
        for (int i = 0; i < 100; i++)
            series.add(i,5);
        
        
        
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        
        
        
       // JFreeChart chart = ChartFactory.createXYLineChart(null, null, null, dataset, PlotOrientation.HORIZONTAL, true, true, true);
        ChartPanel chartpanel = new ChartPanel(barChart);
        chartpanel.setDomainZoomable(true);

        graph.setLayout(new BorderLayout());
        graph.add(chartpanel, BorderLayout.NORTH);
        
        
        
       // JFreeChart chart = new JFreeChart("Cos(x) and Cos^2(x) versus x", parent);
        
     
       // ChartPanel myChart = new ChartPanel(chart);
       // myChart.setMouseWheelEnabled(true);
        
//        graph.setLayout(new java.awt.BorderLayout());
       // graph.add(myChart,BorderLayout.CENTER);
        graph.validate();
        
        
       

      
       
        totalGUI.add(infoSideBar);
       totalGUI.add(mainBar);
       totalGUI.add(analysisSideBar);
       mainBar.add(nextDay);
       mainBar.add(spotsPanel);
       
     
     
      
     
       
      
 
        totalGUI.setOpaque(true);
        return totalGUI;
    }

    public CategoryDataset createDataset() {
		// TODO Auto-generated method stub
    	
    	final String moto = "Motorcycle";        
        final String reg = "Regular";        
        final String handi = "Handicapped"; 
        final String resv = "Reserved"; 
        final String carp = "Carpool"; 
        
        
        double motNum = 0;
        double regNum = 0;
        double HandiNum = 0;
        double reservedNum = 0;
        double carpool = 0;
        
        try {
			connection = DriverManager.getConnection("jdbc:sqlite:Parking.db");
			Statement stat = connection.createStatement();
			
			 String sql = "SELECT count(*) as out "
						+ "FROM s_parks "
						+ "WHERE permit_type = 'MOTORCYCLE';";
			 ResultSet rs = stat.executeQuery(sql);
			  motNum = rs.getDouble("out");
			 
			 
			  
			  
			  String sql1 = "SELECT count(*) as out "
						+ "FROM s_parks "
						+ "WHERE s_parks.permit_type = 'REGULAR'; ";
					
			  rs = stat.executeQuery(sql1);
			  regNum = rs.getDouble("out");
			  
			  String sql2 = "SELECT count(*) as out1 "
						+ "FROM s_parks "
						+ "WHERE permit_type = 'HANDICAPPED';";
			  rs = stat.executeQuery(sql2);
			  HandiNum = rs.getInt("out1");
			  
			  String sql3 = "SELECT count(*) as out2 "
						+ "FROM s_parks "
						+ "WHERE permit_type = 'RESERVED';";
			  rs = stat.executeQuery(sql3);
			  reservedNum = rs.getInt("out2");
			  
			  String sql4 = "SELECT count(*) as out3 "
						+ "FROM s_parks "
						+ "WHERE permit_type = 'CARPOOL';";
			  rs = stat.executeQuery(sql4);
			  regNum = rs.getDouble("out3");
			 
			  
			  
			  rs.close();
			  
			  System.out.println("moto" + motNum);
			  System.out.println("reg" + regNum);
			  
			  
			 
			 
			  
			 
			 
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        
        
        final String total = "Total";        
        final String millage = "Millage";        
        final String userrating = "User Rating";        
        final String safety = "safety";        
        final DefaultCategoryDataset dataset = 
        new DefaultCategoryDataset( );  

        dataset.addValue( motNum, moto , total );  
        dataset.addValue( regNum, reg , total ); 
        dataset.addValue( HandiNum, handi , total ); 
        dataset.addValue( reservedNum, resv , total ); 
        dataset.addValue( carpool, carp , total ); 
        
        
        
//        dataset.addValue( 3.0 , fiat , userrating );        
//        dataset.addValue( 5.0 , fiat , millage ); 
//        dataset.addValue( 5.0 , fiat , safety );           
//
//        dataset.addValue( 5.0 , audi , speed );        
//        dataset.addValue( 6.0 , audi , userrating );       
//        dataset.addValue( 10.0 , audi , millage );        
//        dataset.addValue( 4.0 , audi , safety );
//
//        dataset.addValue( 4.0 , ford , speed );        
//        dataset.addValue( 2.0 , ford , userrating );        
//        dataset.addValue( 3.0 , ford , millage );        
//        dataset.addValue( 6.0 , ford , safety );               

        return dataset; 
	}

	// In this method, we create a square JPanel of a colour and set size
    // specified by the arguments.
    
    private JPanel createSquareJPanel(Color color, int size)
    {
        JPanel tempPanel = new JPanel();
        tempPanel.setBackground(color);
        tempPanel.setMinimumSize(new Dimension(size, size*2));
        tempPanel.setMaximumSize(new Dimension(size, size*2));
        tempPanel.setPreferredSize(new Dimension(size, size*2));
        return tempPanel;
    }

    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Parking Analytics");

        GridLayoutExample demo = new GridLayoutExample();
        frame.setContentPane(demo.createContentPane());
        
       frame.setPreferredSize(new Dimension(1920,1050));
       
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
   //#####################################################################################################################
    
    public static Connection connection;
    
//    public static String connect(){
//        try
//        {
//    
//          connection = DriverManager.getConnection("jdbc:sqlite:/home/jfernandez27/UCMEng_Collaboratory03/Desktop/Parkin_Analytics1/Parking.db");
//          Statement statement = connection.createStatement();
//          statement.setQueryTimeout(30);  // set timeout to 30 sec.
//          System.out.println("Connetction Estalblished");
//          
//          return "Connection Established";
//
//        }
//        catch(SQLException e)
//        {
//          // if the error message is "out of memory", 
//          // it probably means no database file is found
//          System.err.println(e.getMessage());
//          return "Connection Not Established";
//        }
//    }
    
    
    
    public static String connect() {
		// load the sqlite-JDBC driver using the current class loader
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		connection = null;
		try {
			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:Parking.db");
			Statement stat = connection.createStatement();
			stat.setQueryTimeout(30); // set timeout to 30 sec.
			  return "Connection Established";

		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			return e.getMessage();
			
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// connection close failed.
				System.err.println(e);
			}
		}
	}
    
    
    
    public static void createTables() {
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:Parking.db");
			Statement stat = connection.createStatement();
			
			String personTable = "CREATE TABLE `person` ("
								+ "`st_id` int(9) NOT NULL, "
								+ "`name` varchar(25) NOT NULL, "
								+ "`sex` varchar(6) NOT NULL, "
								+ "`p_id` int(3) NOT NULL, "
								+ "'permit_type' varchar(10) NOT NULL, "
								+ "`license` varchar(7) NOT NULL, "
								+ "`ticket` int(1) NOT NULL, "
								+ "`phone` varchar(15) NOT NULL, "
								+ "`age` int(2) NOT NULL,"
								+ "`date` date NOT NULL "
								+ "); ";

			String s_parks = "CREATE TABLE s_parks("

							+ "'p_id' int(3) NOT NULL, "
						    + "'st_id' int(9) NOT NULL, "
						    + "'permit_type' varchar(10) NOT NULL "
						    + ");";
			
			String spot_types = "CREATE TABLE spot_types("

								+ "'p_id' int(3) NOT NULL, "
								+ "'p_occupied' int(1) NOT NULL, "
								+ "'permit_type' varchar(10) NOT NULL "
								+ ");";		
			
			String taps = "CREATE TABLE taps("
							
							+ "'p_id' int(3) NOT NULL, "
							+ "'t_id' int(9) NOT NULL, "
							+ "'permit_type' varchar(10) NOT NULL "
							+ ");";
			
			
			
			String taps_parks = "CREATE TABLE taps_parks("
					
							+ "'p_id' int(3) NOT NULL, "
							+ "'t_id' int(9) NOT NULL, "
							+ "'permit_type' varchar(10) NOT NULL "
							+ ");";
			
			
			String taps_reserves = " CREATE TABLE taps_reserves("

					
									+ "'p_id' int(3) NOT NULL, "
									+ "'permit_type' varchar(10) NOT NULL, "
									+ "'startDate' DATE NOT NULL,  "
    								+ "'endDate' DATE NOT NULL "
									+ ");";
			
			
			
			String graph = "CREATE TABLE graph("
							+ "'x' decimal(3,0) NOT NULL, "
							+ "'y' decimal(3,0) NOT NULL, "
							+ "'x_label' varchar(25) NOT NULL, "
							+ "'y_label' varchar(25) NOT NULL "
							+ ");";
			
			
			String stats = "CREATE TABLE stats("
							+ "avg decimal(3,0) NOT NULL, "
							+ "avgPerDay decimal(3,0) NOT NULL, "
							+ "percentage decimal(3,0) NOT NULL, "
							+ "dates DATE NOT NULL "
							+ ");";
							
						

			


			stat.executeUpdate("drop table if exists person;");
			stat.executeUpdate(personTable);
			
			stat.executeUpdate("drop table if exists s_parks;");
			stat.executeUpdate(s_parks);
			
			stat.executeUpdate("drop table if exists spot_types;");
			stat.executeUpdate(spot_types);
			
			stat.executeUpdate("drop table if exists taps;");
			stat.executeUpdate(taps);
			
			stat.executeUpdate("drop table if exists taps_parks;");
			stat.executeUpdate(taps_parks);
			
			stat.executeUpdate("drop table if exists taps_reserves;");
			stat.executeUpdate(taps_reserves);
			
			stat.executeUpdate("drop table if exists graph;");
			stat.executeUpdate(graph);
			
			stat.executeUpdate("drop table if exists stats;");
			stat.executeUpdate(stats);
			
			
//			stat.executeUpdate("drop table if exists taps_agent;");
//			stat.executeUpdate(taps_agentTable);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    static void fillInSpotTypes(){
    	
    	try {
			connection = DriverManager.getConnection("jdbc:sqlite:Parking.db");
			Statement stat = connection.createStatement();

			// stat.execute("Select MAX(w_warehousekey) FROM warehouse");
			
			
			
			String sql;
			for(int i = 1; i < 223; i++  ){
				
				
				Random ran = new Random();
				int p_type = ran.nextInt(14) + 1;
				int p_occupied = 0;
				
				String permit_type = "REGULAR";
				
				
				if(  p_type == 1 ||   p_type == 2 ||   p_type ==3   || p_type ==4    ||p_type ==5    ||p_type ==6   || p_type ==7    ||p_type ==8    ||p_type ==9    ||p_type ==10    ||p_type ==11 )
					p_occupied = 0;
			
				
				if( p_type == 12 )
					p_occupied = 1;
					
				if( p_type == 13 )
					p_occupied = 1;
						
				if( p_type == 14 )
					p_occupied = 1;
				
				if( p_type == 15 )
					p_occupied =  1;	
				
				
				
				
				
				if(  p_type == 1 ||   p_type == 2 ||   p_type ==3   || p_type ==4    ||p_type ==5    ||p_type ==6   || p_type ==7    ||p_type ==8    ||p_type ==9    ||p_type ==10    ||p_type ==11 )
					permit_type = "REGULAR";
			
				
				if( p_type == 12 )
					permit_type = "HANDICAPPED";
					
				if( p_type == 13 )
					permit_type = "MOTORCYCLE";
						
				if( p_type == 14 )
					permit_type = "CARPOOL";
				
				if( p_type == 15 )
					permit_type = "RESERVED";
				
				
			 sql = "INSERT INTO spot_types values ('"+i+"','"+ p_occupied +"','Regular');";
			 stat.executeUpdate(sql);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	
    }
    
 static void fillInS_parks(){
	 
	 try {
			connection = DriverManager.getConnection("jdbc:sqlite:Parking.db");
			Statement stat = connection.createStatement();
			ArrayList<Integer> resultArray = new ArrayList();

			// stat.execute("Select MAX(w_warehousekey) FROM warehouse");
			
			
			  String sql1 = 	"INSERT INTO s_parks(p_id, st_id, permit_type) "
					  + "SELECT person.p_id as p_id, st_id as st_id, person.permit_type as permit_type "
					  + "FROM person, spot_types "
					  + "WHERE person.p_id = spot_types.p_id "
					  + "AND spot_types.p_occupied = 1 ;";
		 
		  stat.executeUpdate(sql1);
			

		

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 
	 
//	 ArrayList<String> innerArray = new ArrayList();
//	 
//	 ArrayList<ArrayList<String>> arrayContainer = new ArrayList();
//	 
	 
    	
    	/*try {
			connection = DriverManager.getConnection("jdbc:sqlite:Parking.db");
			Statement stat = connection.createStatement();

			// stat.execute("Select MAX(w_warehousekey) FROM warehouse");
//			
//		  String sql = 	"INSERT INTO s_parks('1', '1', 'ibibijbij') "
//					  + "SELECT p_id as p_id, st_id as st_id, permit_type as permit_type "
//					  + "FROM person;";
//		 
		//  stat.executeUpdate(sql);
			
			
 			String sql = "SELECT p_id FROM person";
						
 			
 			ResultSet rs = stat.executeQuery(sql);
		  
 			
 			
 			System.out.println("RS: " + rs.next());
 			
		  
 			//System.out.println(rs.getString(0));
 			
 			rs.close();
 			
			
//			rs = stat.executeQuery(noindexQ4);
//			while (rs.next()) {
//				System.out.println(rs.getString("completionTime"));
//				}
//				rs.close();
//			
//			
//		  
//		  
//		  while(rs.next())
//		  {
//			  innerArray.add(rs.getString("p_id"));
//			  innerArray.add(rs.getString("st_id"));
//			  innerArray.add(rs.getString("permit_type"));
//			  
//		  }
		  
		  
//		  for(int i = 0; i < innerArray.size(); i++){
//		  System.out.println("dfgasdf");
//		  }
//		  

			
			
//			for(int i = 1; i < 223; i++  ){
//			 sql = "SELECT p_id , st_id,  permit_type FROM person;";
//			 stat.execute(sql);
//			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	
  	*/
    }

	static void createNames() {

		Scanner mInput;
		Scanner fInput;

		Scanner lInput;

		try {
			mInput = new Scanner(new FileReader("male.txt"));

			while (mInput.hasNextLine()) {
				maleNames.add(mInput.nextLine());
			}

			fInput = new Scanner(new FileReader("female.txt"));

			while (fInput.hasNextLine()) {
				femaleNames.add(fInput.nextLine());
			}

			lInput = new Scanner(new FileReader("lastNames.txt"));

			while (lInput.hasNextLine()) {
				lastNames.add(lInput.nextLine());
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}
	
	
	static String randomPhoneNumber() {

		Random ran = new Random();
		int areaCode = ran.nextInt(900) + 100;
		int p1 = ran.nextInt(900) + 100;			
		int p2 = ran.nextInt(9000) + 1000;
		
		String phone = ("("+ areaCode + ") " + p1 + "-" + p2);
		
		return phone;

	}
	
	static String randomName(String gender){
		
		String name = null;
		Random ran = new Random();
		
		if(gender == "male" || gender == "Male" || gender == "M"){
			
			int firstIndex = ran.nextInt(maleNames.size()) + 0;
			int lastIndex = ran.nextInt(lastNames.size()) + 0;
			
			name = maleNames.get(firstIndex) + " " +  lastNames.get(lastIndex);
			
		}
		
		if(gender == "female" || gender == "Feale" || gender == "F") {
			
			int firstIndex = ran.nextInt(femaleNames.size()) + 0;
			int lastIndex = ran.nextInt(lastNames.size()) + 0;
			
			name = femaleNames.get(firstIndex) + " " + lastNames.get(lastIndex);
			
		}
	
		
		
		
		return name;
		
	}
	
	static int getRandomP_id(){
		Random ran = new Random();
		int p_id = ran.nextInt(222) + 1;
		
		for(int i = 0; i < pidArray.size(); i++)
		{
			if(pidArray.get(i) == p_id){
			return getRandomP_id();
			}
		}
		
		pidArray.add(p_id);
		
		return p_id;
	}
	
static void insertCustomPerson(int PID, int st_id, String name, String permit_type, String license, int age  ){
		
		
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK); 
		
		
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:Parking.db");
			Statement stat = connection.createStatement();
		
	
			


			//Student ID
			Random ran = new Random();
			//int st_id = ran.nextInt(900000000) + 100000000;
			String gender;
			
			
			int gen = ran.nextInt(1) + 1;
			
			if(gen == 1)
			{
				gender = "male";
				
			}
			else
			{
				gender = "female";
			}
			
			
			
			//System.out.println(st_id);
			
			//name
			//System.out.println(randomName("gender"));
			//System.out.println(gender);
			//String name = randomName(gender);
			
			
			
			
			//Parking ID
			
//		   String getP_id = 	"SELECT AVG(julianday(l_receiptdate) - julianday(o_orderdate)) as completionTime "
//							+ "FROM orders_noindex, lineitem_noindex "
//							+ "WHERE o_orderkey = l_orderkey;";
//		   
//		   
//		   
//		rs = stat.executeQuery(noindexQ4);
//		while (rs.next()) {
//			System.out.println(rs.getString("completionTime"));
//			}
//			rs.close();
			//int p_id = getRandomP_id();
			//System.out.println(p_id);
			
			//License
			//String license = UUID.randomUUID().toString();
			license = license.substring(0, 7).toUpperCase();
			//System.out.println(license);
			
			//Ticket
			int ticket = 0;
			
			//Phone
			String phone = randomPhoneNumber();
			
			//Age
			//int age = ran.nextInt(6) + 18;
	
	
			//String permit_type = "REGULAR";
			
			
			int p_type = ran.nextInt(14) + 1;
			
			
			if(  p_type == 1 ||   p_type == 2 ||   p_type ==3   || p_type ==4    ||p_type ==5    ||p_type ==6   || p_type ==7    ||p_type ==8    ||p_type ==9    ||p_type ==10    ||p_type ==11 )
				permit_type = "REGULAR";
		
			
			if( p_type == 12 )
				permit_type = "HANDICAPPED";
				
			if( p_type == 13 )
				permit_type = "MOTORCYCLE";
					
			if( p_type == 14 )
				permit_type = "CARPOOL";
			
			if( p_type == 15 )
				permit_type = "RESERVED";
			
			
			
			
			
			
			stat.executeUpdate("INSERT INTO person values ( " + st_id + ", '" + name + "', '" + gender + "', " + PID + ", '" + permit_type + "' " + ", '" + license + "', " + ticket + ", '" + phone + "', " + age + ", date('now') );");
			
			
			//stat.executeUpdate("INSERT INTO s_parks values ( " + p_id + ", '" + st_id + "', '" + row + "', " + col + ", '" + permit_type  + " );");
			
			//System.out.println("INSERT INTO person values ( " + st_id + ", '" + name + "', '" + gender + "', " + p_id + ", '" + license + "', " + ticket + ", '" + phone + "', " + age + " );");
			//INSERT INTO person values (154316648, 'Jal Lopes', 'M',  4 , 'A8C645E', 0 ,  '(209) 612-4513',  20 );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
static void insertRandomPerson(int PID){
		
		
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK); 
		
		
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:Parking.db");
			Statement stat = connection.createStatement();
		
	
			


			//Student ID
			Random ran = new Random();
			int st_id = ran.nextInt(900000000) + 100000000;
			String gender;
			
			
			int gen = ran.nextInt(1) + 1;
			
			if(gen == 1)
			{
				gender = "male";
				
			}
			else
			{
				gender = "female";
			}
			
			
			
			//System.out.println(st_id);
			
			//name
			//System.out.println(randomName("gender"));
			//System.out.println(gender);
			String name = randomName(gender);
			
			
			
			
			//Parking ID
			
//		   String getP_id = 	"SELECT AVG(julianday(l_receiptdate) - julianday(o_orderdate)) as completionTime "
//							+ "FROM orders_noindex, lineitem_noindex "
//							+ "WHERE o_orderkey = l_orderkey;";
//		   
//		   
//		   
//		rs = stat.executeQuery(noindexQ4);
//		while (rs.next()) {
//			System.out.println(rs.getString("completionTime"));
//			}
//			rs.close();
			//int p_id = getRandomP_id();
			//System.out.println(p_id);
			
			//License
			String license = UUID.randomUUID().toString();
			license = license.substring(0, 7).toUpperCase();
			//System.out.println(license);
			
			//Ticket
			int ticket = 0;
			
			//Phone
			String phone = randomPhoneNumber();
			
			//Age
			int age = ran.nextInt(6) + 18;
	
	
			String permit_type = "REGULAR";
			
			
			int p_type = ran.nextInt(14) + 1;
			
			
			if(  p_type == 1 ||   p_type == 2 ||   p_type ==3   || p_type ==4    ||p_type ==5    ||p_type ==6   || p_type ==7    ||p_type ==8    ||p_type ==9    ||p_type ==10    ||p_type ==11 )
				permit_type = "REGULAR";
		
			
			if( p_type == 12 )
				permit_type = "HANDICAPPED";
				
			if( p_type == 13 )
				permit_type = "MOTORCYCLE";
					
			if( p_type == 14 )
				permit_type = "CARPOOL";
			
			if( p_type == 15 )
				permit_type = "RESERVED";
			
			
			
			
			
			
			stat.executeUpdate("INSERT INTO person values ( " + st_id + ", '" + name + "', '" + gender + "', " + PID + ", '" + permit_type + "' " + ", '" + license + "', " + ticket + ", '" + phone + "', " + age + ", date('now') );");
			
			
			//stat.executeUpdate("INSERT INTO s_parks values ( " + p_id + ", '" + st_id + "', '" + row + "', " + col + ", '" + permit_type  + " );");
			
			//System.out.println("INSERT INTO person values ( " + st_id + ", '" + name + "', '" + gender + "', " + p_id + ", '" + license + "', " + ticket + ", '" + phone + "', " + age + " );");
			//INSERT INTO person values (154316648, 'Jal Lopes', 'M',  4 , 'A8C645E', 0 ,  '(209) 612-4513',  20 );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	static void insertRandomPerson(String gender){
		
		
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK); 
		
		
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:Parking.db");
			Statement stat = connection.createStatement();
		
	
			


			//Student ID
			Random ran = new Random();
			int st_id = ran.nextInt(900000000) + 100000000;
			//System.out.println(st_id);
			
			//name
			//System.out.println(randomName("gender"));
			//System.out.println(gender);
			String name = randomName(gender);
			
			
			
			
			//Parking ID
			
//		   String getP_id = 	"SELECT AVG(julianday(l_receiptdate) - julianday(o_orderdate)) as completionTime "
//							+ "FROM orders_noindex, lineitem_noindex "
//							+ "WHERE o_orderkey = l_orderkey;";
//		   
//		   
//		   
//		rs = stat.executeQuery(noindexQ4);
//		while (rs.next()) {
//			System.out.println(rs.getString("completionTime"));
//			}
//			rs.close();
			int p_id = getRandomP_id();
			//System.out.println(p_id);
			
			//License
			String license = UUID.randomUUID().toString();
			license = license.substring(0, 7).toUpperCase();
			//System.out.println(license);
			
			//Ticket
			int ticket = 0;
			
			//Phone
			String phone = randomPhoneNumber();
			
			//Age
			int age = ran.nextInt(6) + 18;
	
	
			String permit_type = "REGULAR";
			
			
			int p_type = ran.nextInt(14) + 1;
			
			
			if(  p_type == 1 ||   p_type == 2 ||   p_type ==3   || p_type ==4    ||p_type ==5    ||p_type ==6   || p_type ==7    ||p_type ==8    ||p_type ==9    ||p_type ==10    ||p_type ==11 )
				permit_type = "REGULAR";
		
			
			if( p_type == 12 )
				permit_type = "HANDICAPPED";
				
			if( p_type == 13 )
				permit_type = "MOTORCYCLE";
					
			if( p_type == 14 )
				permit_type = "CARPOOL";
			
			if( p_type == 15 )
				permit_type = "RESERVED";
			
			
			
			
			
			
			stat.executeUpdate("INSERT INTO person values ( " + st_id + ", '" + name + "', '" + gender + "', " + p_id + ", '" + permit_type + "' " + ", '" + license + "', " + ticket + ", '" + phone + "', " + age + ", date('now') );");
			
			
			//stat.executeUpdate("INSERT INTO s_parks values ( " + p_id + ", '" + st_id + "', '" + row + "', " + col + ", '" + permit_type  + " );");
			
			//System.out.println("INSERT INTO person values ( " + st_id + ", '" + name + "', '" + gender + "', " + p_id + ", '" + license + "', " + ticket + ", '" + phone + "', " + age + " );");
			//INSERT INTO person values (154316648, 'Jal Lopes', 'M',  4 , 'A8C645E', 0 ,  '(209) 612-4513',  20 );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
static void insertRandomPerson(String gender, String date){
		
		
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK); 
		
		
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:Parking.db");
			Statement stat = connection.createStatement();
		
	
			


			//Student ID
			Random ran = new Random();
			int st_id = ran.nextInt(900000000) + 100000000;
			//System.out.println(st_id);
			
			//name
			//System.out.println(randomName("gender"));
			//System.out.println(gender);
			String name = randomName(gender);
			
			
			
			
			//Parking ID
			
//		   String getP_id = 	"SELECT AVG(julianday(l_receiptdate) - julianday(o_orderdate)) as completionTime "
//							+ "FROM orders_noindex, lineitem_noindex "
//							+ "WHERE o_orderkey = l_orderkey;";
//		   
//		   
//		   
//		rs = stat.executeQuery(noindexQ4);
//		while (rs.next()) {
//			System.out.println(rs.getString("completionTime"));
//			}
//			rs.close();
			int p_id = getRandomP_id();
			//System.out.println(p_id);
			
			//License
			String license = UUID.randomUUID().toString();
			license = license.substring(0, 7).toUpperCase();
			//System.out.println(license);
			
			//Ticket
			int ticket = 0;
			
			//Phone
			String phone = randomPhoneNumber();
			
			//Age
			int age = ran.nextInt(6) + 18;
	
	
			String permit_type = "REGULAR";
			
			
			int p_type = ran.nextInt(14) + 1;
			
			
			if(  p_type == 1 ||   p_type == 2 ||   p_type ==3   || p_type ==4    ||p_type ==5    ||p_type ==6   || p_type ==7    ||p_type ==8    ||p_type ==9    ||p_type ==10    ||p_type ==11 )
				permit_type = "REGULAR";
		
			
			if( p_type == 12 )
				permit_type = "HANDICAPPED";
				
			if( p_type == 13 )
				permit_type = "MOTORCYCLE";
					
			if( p_type == 14 )
				permit_type = "CARPOOL";
			
			if( p_type == 15 )
				permit_type = "RESERVED";
			
			
			
			
			
			
			stat.executeUpdate("INSERT INTO person values ( " + st_id + ", '" + name + "', '" + gender + "', " + p_id + ", '" + permit_type + "' " + ", '" + license + "', " + ticket + ", '" + phone + "', " + age + ", " + "'2016-12-"+date+"');");
			
			
			//stat.executeUpdate("INSERT INTO s_parks values ( " + p_id + ", '" + st_id + "', '" + row + "', " + col + ", '" + permit_type  + " );");
			
			//System.out.println("INSERT INTO person values ( " + st_id + ", '" + name + "', '" + gender + "', " + p_id + ", '" + license + "', " + ticket + ", '" + phone + "', " + age + " );");
			//INSERT INTO person values (154316648, 'Jal Lopes', 'M',  4 , 'A8C645E', 0 ,  '(209) 612-4513',  20 );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Close() {

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:Parking.db");
			Statement stat = connection.createStatement();
			connection.close();
			System.out.println("");
			System.out.println("Connection Closed: ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	
	
	
	
	
	
	
    

    public static void main(String[] args) {
    	
    	
    	// 1.)
        createTables();
        
        createNames();
		
		
		//Populate people
		for(int i = 0; i < 111; i++){
			insertRandomPerson("M");
		}
		
		for(int i = 0; i < 111; i++){
			insertRandomPerson("F");
		}
		
        
        
      fillInSpotTypes();
         fillInS_parks();

    		
      
    		
    		
    		//System.out.println("Inserted 10 People");
    		
    		// Close Connection
    		//c.Close();
    		
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
                createAndShowGUI();
                connect();
                
            }
        });
    }
}