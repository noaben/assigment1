package noa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JTextPane;

import com.toedter.calendar.JCalendar;

import java.awt.Color;
import javax.swing.DropMode;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Font;

public class frame1 {

	private JFrame frame;
	private JTextField txtInputoutput;
	private JTextField txtFilters;
	private JTextField txtAlgorithms;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JTextPane textDevice;
	private JTextField textField;
	private JTextField textField_1;
	private JTextPane lat_1;
	private JTextPane lon_1;
	private JTextPane alt_1;
	private JTextPane lat_2;
	private JTextPane lon_2;
	private JTextPane alt_2;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxByPlacelatlonalt;
	private JCheckBox chckbxByDevice;
	private JTextPane date_1;
	private JTextPane hour_1;
	private JTextPane date_2;
	private JTextPane hour_2;
	private JCheckBox chckbxFindPlaceOf;
	private JTextPane mac;
	private JCheckBox chckbxDatafolder;
	private JTextPane dataFolder;
	private JCheckBox chckbxCombcsv;
	private JCheckBox chckbxErasedata;
	private JTextField txtOutput;
	private JTextPane comb_input;
	private JCheckBox comb_output;
	private JCheckBox chckbxKmlfile;
	private JCheckBox chckbxKmlfileaaaaakml;
	private JTextField txtByDateddmmyyyy;
	private JTextField txtByPlacelatlonalt;
	private JTextField txtByDevice;
	private JCheckBox dateNotatrange;
	private JCheckBox placeNotatrange;
	private JCheckBox chckbxNotequals;
	private JTextField txtFilterBy;
	private JComboBox not_yes;
	private JTextField textField_2;
	private JComboBox not_yes_filter1;
	private JComboBox and_or;
	private JComboBox not_yes_filter2;
	private JComboBox filter2;
	private JTextField textField_3;
	private JCheckBox filter_2_values;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JCheckBox chckbxNewCheckBox_1;
	private JTextPane noGPS;
	private JCheckBox chckbxEnterOr;
	private JTextPane data1;
	private JTextField txtMac;
	private JTextField txtPairmacsignal;
	private JTextPane data2;
	private JTextField txtPairmacsignal_1;
	private JTextPane data3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LinkedList <Wifi> data_base=new LinkedList <Wifi> ();
		LinkedList <Wifi> data_not_filtered=new LinkedList <Wifi> ();
	//	EventQueue.invokeLater(new Runnable() {
		//	public void run() {
			//	try {
					frame1 window = new frame1(data_base,data_not_filtered);
					window.frame.setVisible(true);
					System.out.println(data_base.size());
			//	} catch (Exception e) {
				//	e.printStackTrace();
		//		}
	//		}
		//});
	}

	/**
	 * Create the application.
	 */
	public frame1(LinkedList <Wifi> data_base, LinkedList <Wifi> data_not_filtered) {
		initialize(data_base,data_not_filtered);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(LinkedList <Wifi> data_base,LinkedList <Wifi> data_not_filtered) {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 850,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCalendar date= new JCalendar();
		txtFilters = new JTextField();
		txtFilters.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFilters.setBackground(Color.PINK);
		txtFilters.setBounds(10, 145, 111, 20);
		txtFilters.setText("filter by 1 value");
		frame.getContentPane().add(txtFilters);
		txtFilters.setColumns(10);
		
		txtAlgorithms = new JTextField();
		txtAlgorithms.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAlgorithms.setBackground(Color.PINK);
		txtAlgorithms.setBounds(10, 374, 157, 20);
		txtAlgorithms.setText("algorithms to find place");
		frame.getContentPane().add(txtAlgorithms);
		txtAlgorithms.setColumns(10);
		
		txtInputoutput = new JTextField();
		txtInputoutput.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtInputoutput.setBackground(Color.PINK);
		txtInputoutput.setBounds(10, 11, 86, 20);
		txtInputoutput.setText("input");
		frame.getContentPane().add(txtInputoutput);
		txtInputoutput.setColumns(10);
		
		txtFrom = new JTextField();
		txtFrom.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFrom.setText("from:");
		txtFrom.setBounds(208, 176, 39, 20);
		frame.getContentPane().add(txtFrom);
		txtFrom.setColumns(10);
		
		txtTo = new JTextField();
		txtTo.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtTo.setText("to:");
		txtTo.setColumns(10);
		txtTo.setBounds(431, 176, 26, 20);
		frame.getContentPane().add(txtTo);
		
		textDevice= new JTextPane();
		textDevice.setBounds(208, 238, 269, 20);
		frame.getContentPane().add(textDevice);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField.setText("from:");
		textField.setColumns(10);
		textField.setBounds(208, 207, 39, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_1.setText("to:");
		textField_1.setColumns(10);
		textField_1.setBounds(431, 207, 26, 20);
		frame.getContentPane().add(textField_1);
		
		lat_1 = new JTextPane();
		lat_1.setBounds(257, 207, 48, 20);
		frame.getContentPane().add(lat_1);
		
		lon_1 = new JTextPane();
		lon_1.setBounds(315, 207, 48, 20);
		frame.getContentPane().add(lon_1);
		
		alt_1 = new JTextPane();
		alt_1.setBounds(373, 207, 48, 20);
		frame.getContentPane().add(alt_1);
		
		lat_2 = new JTextPane();
		lat_2.setBounds(467, 207, 48, 20);
		frame.getContentPane().add(lat_2);
		
		lon_2 = new JTextPane();
		lon_2.setBounds(525, 207, 48, 20);
		frame.getContentPane().add(lon_2);
		
		alt_2 = new JTextPane();
		alt_2.setBounds(583, 207, 48, 20);
		frame.getContentPane().add(alt_2);
		
		chckbxNewCheckBox = new JCheckBox("atRange");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected()==false){
					data_base.clear();
				    data_base.addAll(data_not_filtered);
				    data_not_filtered.clear();
				    JOptionPane.showMessageDialog(null,"the filter was cancelled");
				    date_1.setText(""); date_2.setText("");hour_1.setText(""); hour_2.setText("");
				    chckbxByPlacelatlonalt.setEnabled(true);
			        chckbxByDevice.setEnabled(true);
			        dateNotatrange.setEnabled(true);
			        placeNotatrange.setEnabled(true);
			        chckbxNotequals.setEnabled(true);
			        filter_2_values.setEnabled(true);
				    }
				else{
				    String date1,date2,hour1,hour2;
				    date1=(String)date_1.getText();date2=(String)date_2.getText();
				    hour1=(String)hour_1.getText();hour2=(String)hour_2.getText();
				
				    try {
				        if ((date1.substring(2,3).equals("-")) && (date1.substring(5,6).equals("-")) && (date2.substring(2,3).equals("-")) && (date2.substring(5,6).equals("-")) && (hour1.substring(2,3).equals(":")) && (hour2.substring(2,3).equals(":"))){
					        int d1,d2,h1,h2;
					        d1=Integer.parseInt(date1.substring(0,2)); d1=Integer.parseInt(date1.substring(3,5));
					        d1=Integer.parseInt(date1.substring(6,10)); d2=Integer.parseInt(date2.substring(0,2));
					        d2=Integer.parseInt(date2.substring(3,5)); d2=Integer.parseInt(date2.substring(6,10));
					        h1=Integer.parseInt(hour1.substring(0,2));h1=Integer.parseInt(hour2.substring(0,2));h1=Integer.parseInt(hour1.substring(3,5));h1=Integer.parseInt(hour2.substring(3,5));
					        String str1=date1+","+hour1+","+date2+","+hour2;
					        data_not_filtered.addAll(data_base);
				            combiningData.listToCsv(data_base,"c.csv");
				            data_base.clear();
				            data_base.addAll(processingData.list("c.csv", "filtering", "Time", str1,"yes"));
				            JOptionPane.showMessageDialog(null,"the data was filtered");
				            chckbxByPlacelatlonalt.setEnabled(false);
					        chckbxByDevice.setEnabled(false);
					        dateNotatrange.setEnabled(false);
					        placeNotatrange.setEnabled(false);
					        chckbxNotequals.setEnabled(false);
					        filter_2_values.setEnabled(false);}
				       else{
				      	    JOptionPane.showMessageDialog(null,"please enter valid format");
				      	    chckbxNewCheckBox.setSelected(false);
				      	    date_1.setText(""); date_2.setText("");hour_1.setText(""); hour_2.setText("");
				    
				    	   }
			           }
			       catch(Exception e1){JOptionPane.showMessageDialog(null,"please enter valid format");
			       chckbxNewCheckBox.setSelected(false);
			       date_1.setText(""); date_2.setText("");hour_1.setText(""); hour_2.setText("");
			       }}}}
				
				    
			
		);
		chckbxNewCheckBox.setBounds(662, 175, 80, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		chckbxByPlacelatlonalt = new JCheckBox("atRange");
		chckbxByPlacelatlonalt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (chckbxByPlacelatlonalt.isSelected()==false){
				data_base.clear();
			    data_base.addAll(data_not_filtered);
			    data_not_filtered.clear();
			    JOptionPane.showMessageDialog(null,"the filter was cancelled");
			    lat_1.setText("");lat_2.setText("");lon_1.setText("");lon_2.setText("");alt_1.setText("");alt_2.setText("");
			    chckbxNewCheckBox.setEnabled(true);
		        chckbxByDevice.setEnabled(true);
		        dateNotatrange.setEnabled(true);
		        placeNotatrange.setEnabled(true);
		        chckbxNotequals.setEnabled(true);
		        filter_2_values.setEnabled(true);
			}
			else{
			double lat1,lon1,alt1,lat2,lon2,alt2;
			try{
				lat1=Double.parseDouble((String)lat_1.getText());lon1=Double.parseDouble((String)lon_1.getText());alt1=Double.parseDouble((String)alt_1.getText());
				lat2=Double.parseDouble((String)lat_2.getText());lon2=Double.parseDouble((String)lon_2.getText());alt2=Double.parseDouble((String)alt_2.getText());
				String str=(String)lat_1.getText()+","+(String)lon_1.getText()+","+(String)alt_1.getText()+","+(String)lat_2.getText()+","+(String)lon_2.getText()+","+(String)alt_2.getText();
				data_not_filtered.addAll(data_base);
				combiningData.listToCsv(data_base,"c.csv");
		        data_base.clear();
		        data_base.addAll(processingData.list("c.csv", "filtering", "Place", str,"yes"));
		        JOptionPane.showMessageDialog(null,"the data was filtered");
		        chckbxNewCheckBox.setEnabled(false);
		        chckbxByDevice.setEnabled(false);
		        dateNotatrange.setEnabled(false);
		        placeNotatrange.setEnabled(false);
		        chckbxNotequals.setEnabled(false);
		        filter_2_values.setEnabled(false);
		        }
		    			
			catch(Exception e1){JOptionPane.showMessageDialog(null,"please enter valid numbers");
		     	lat_1.setText("");lat_2.setText("");lon_1.setText("");lon_2.setText("");alt_1.setText("");alt_2.setText("");
			    chckbxByPlacelatlonalt.setSelected(false);}
			}}
		});
		chckbxByPlacelatlonalt.setBounds(662, 206, 80, 23);
		frame.getContentPane().add(chckbxByPlacelatlonalt);
		
		chckbxByDevice = new JCheckBox("equals");
		chckbxByDevice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxByDevice.isSelected()==false){
					data_base.clear();
				    data_base.addAll(data_not_filtered);
				    data_not_filtered.clear();
				    JOptionPane.showMessageDialog(null,"the filter was cancelled");
				    textDevice.setText("");
				    chckbxNewCheckBox.setEnabled(true);
				    chckbxByPlacelatlonalt.setEnabled(true);
			        dateNotatrange.setEnabled(true);
			        placeNotatrange.setEnabled(true);
			        chckbxNotequals.setEnabled(true);
			        filter_2_values.setEnabled(true);
				}
				else{
				String val=(String)textDevice.getText();
				data_not_filtered.addAll(data_base);
				combiningData.listToCsv(data_base,"c.csv");
		        data_base.clear();
		        data_base.addAll(processingData.list("c.csv", "filtering", "ID", val,"yes"));
		        JOptionPane.showMessageDialog(null,"the data was filtered");
		        chckbxNewCheckBox.setEnabled(false);
		        chckbxByPlacelatlonalt.setEnabled(false);
		        dateNotatrange.setEnabled(false);
		        placeNotatrange.setEnabled(false);
		        chckbxNotequals.setEnabled(false);
		        filter_2_values.setEnabled(false);}
			}
		});
		chckbxByDevice.setBounds(664, 235, 66, 23);
		frame.getContentPane().add(chckbxByDevice);
		
		date_1 = new JTextPane();
		date_1.setBounds(257, 176, 62, 20);
		frame.getContentPane().add(date_1);
		
		hour_1 = new JTextPane();
		hour_1.setBounds(329, 176, 34, 20);
		frame.getContentPane().add(hour_1);
		
		date_2 = new JTextPane();
		date_2.setBounds(467, 176, 62, 20);
		frame.getContentPane().add(date_2);
		
		hour_2 = new JTextPane();
		hour_2.setBounds(539, 176, 34, 20);
		frame.getContentPane().add(hour_2);
		
		chckbxFindPlaceOf = new JCheckBox("enter MAC:");
		chckbxFindPlaceOf.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxFindPlaceOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String MAC=(String)mac.getText();
				 if (!MAC.substring(2,3).equals(":") || !MAC.substring(5,6).equals(":") || !MAC.substring(8,9).equals(":") || !MAC.substring(11,12).equals(":") || !MAC.substring(14,15).equals(":")) 
					 JOptionPane.showMessageDialog(null,"check your input. It should be in format aa:aa:aa:aa:aa:aa");
				 else {
					 MAC mac1=algorithms.findPlaceAlgorithm1("wificsv.csv", MAC,5);
					 JOptionPane.showMessageDialog(null,"Lat:"+mac1.getLAT()+" Lon:"+mac1.getLON()+" Alt:"+mac1.getALT());
				 }
			}
		});
		chckbxFindPlaceOf.setBounds(10, 401, 197, 23);
		frame.getContentPane().add(chckbxFindPlaceOf);
		
		mac = new JTextPane();
		mac.setBounds(256, 401, 150, 20);
		frame.getContentPane().add(mac);
		
		chckbxDatafolder = new JCheckBox("enter data folder:");
		chckbxDatafolder.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxDatafolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String folder=(String)dataFolder.getText();
				try{
				    File f = new File(folder);            
					File[] files = f.listFiles();   
					int a=files.length;
					LinkedList <Wifi> data=combiningData.list(folder);
				     int size1=data_base.size();
					data_base.addAll(data);	int size2=data_base.size();
					JOptionPane.showMessageDialog(null,size2-size1+" recordings have been added to data structure");
					
			    	}
					catch(NullPointerException ex){
						 JOptionPane.showMessageDialog(null,"folder does not exist");}
				    finally{
				    	chckbxDatafolder.setSelected(false);
						dataFolder.setText("");
				    }
					
			}
		});
		
		chckbxDatafolder.setBounds(10, 38, 133, 23);
		frame.getContentPane().add(chckbxDatafolder);
		
		dataFolder = new JTextPane();
		dataFolder.setBounds(228, 38, 112, 20);
		frame.getContentPane().add(dataFolder);
		
		chckbxCombcsv = new JCheckBox("enter comb_csv (aaaaa.csv):");
		chckbxCombcsv.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxCombcsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String source=(String)comb_input.getText();
					System.out.print(source);
					LinkedList <Wifi> data=new LinkedList <Wifi>();
			    	data.addAll(processingData.list(source, "no_filtering", "filterBy", "requiredData","yes"));
			    	int size1=data_base.size();
				    data_base.addAll(data);	int size2=data_base.size();
				    JOptionPane.showMessageDialog(null,size2-size1+" recordings have been added to data structure");}
			    catch(NullPointerException ex){
					JOptionPane.showMessageDialog(null,"file does not exist");}
			        
			    finally{
			    chckbxCombcsv.setSelected(false);
			    comb_input.setText("");}
		    }
			
		});
		chckbxCombcsv.setBounds(10, 64, 212, 23);
		frame.getContentPane().add(chckbxCombcsv);
		
		chckbxErasedata = new JCheckBox("erase_data_structure");
		chckbxErasedata.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxErasedata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_base.clear();
				if (data_base.size()==0) JOptionPane.showMessageDialog(null,"Data structure is empty");
				chckbxErasedata.setSelected(false);
				
			}
		});
		chckbxErasedata.setBounds(10, 90, 197, 23);
		frame.getContentPane().add(chckbxErasedata);
		
		txtOutput = new JTextField();
		txtOutput.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtOutput.setBackground(Color.PINK);
		txtOutput.setText("output");
		txtOutput.setColumns(10);
		txtOutput.setBounds(371, 11, 86, 20);
		frame.getContentPane().add(txtOutput);
		
		comb_input = new JTextPane();
		comb_input.setBounds(228, 67, 112, 20);
		frame.getContentPane().add(comb_input);
		
		comb_output = new JCheckBox("export to \"comb.csv\"");
		comb_output.setFont(new Font("Tahoma", Font.BOLD, 11));
		comb_output.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkedList<Wifi>data1=new LinkedList <Wifi>();
				data1.addAll(data_base);
				if (combiningData.listToCsv(data1, "comb.csv"))
				     JOptionPane.showMessageDialog(null,"CSV file was created");
				else
					JOptionPane.showMessageDialog(null,"No data base. CSV file was not created");
			    comb_output.setSelected(false);
			
				
				   }});
		comb_output.setBounds(371, 38, 197, 23);
		frame.getContentPane().add(comb_output);
		
		chckbxKmlfile = new JCheckBox("get_info_of_data_structure");
		chckbxKmlfile.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxKmlfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(data_base.size());
				LinkedList <Wifi> data=new LinkedList<Wifi>();
				data.addAll(data_base);
				combiningData.listToCsv(data,"t.csv");
				LinkedList <Wifi> data1=new LinkedList<Wifi>();
				data1.addAll(data_base);
				LinkedList <Wifi> data2=new LinkedList<Wifi>();
				data2.addAll(processingData.listOrganized ("t.csv",data1,5,"mac.csv"));
				System.out.println(data.size());
				JOptionPane.showMessageDialog(null,"number of recordings:"+data_base.size()+" number of MAC's:"+data2.size());
			    chckbxKmlfile.setSelected(false);}
				 
				
			
		});
		chckbxKmlfile.setBounds(373, 90, 209, 23);
		frame.getContentPane().add(chckbxKmlfile);
		
		chckbxKmlfileaaaaakml = new JCheckBox("export to \"data.kml\"");
		chckbxKmlfileaaaaakml.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxKmlfileaaaaakml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {LinkedList<Wifi>data1=new LinkedList <Wifi>();
			data1.addAll(data_base);
			combiningData.listToCsv(data1,"c.csv");
			   if (	processingData.CSVtoKML("c.csv", "data.kml", "no_filtering", "", "",0,"b.csv","yes"))
			        	 JOptionPane.showMessageDialog(null,"KML file was created");
			  else
				    JOptionPane.showMessageDialog(null,"No data base. KML file was not created");
			chckbxKmlfileaaaaakml.setSelected(false);
				
	
			
        	}
		});
		chckbxKmlfileaaaaakml.setBounds(371, 64, 209, 23);
		frame.getContentPane().add(chckbxKmlfileaaaaakml);
		
		txtByDateddmmyyyy = new JTextField();
		txtByDateddmmyyyy.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtByDateddmmyyyy.setText("by date (dd-mm-yyyy hh:mm):");
		txtByDateddmmyyyy.setBounds(10, 176, 188, 20);
		frame.getContentPane().add(txtByDateddmmyyyy);
		txtByDateddmmyyyy.setColumns(10);
		
		txtByPlacelatlonalt = new JTextField();
		txtByPlacelatlonalt.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtByPlacelatlonalt.setText("by place(lat,lon,alt):");
		txtByPlacelatlonalt.setBounds(10, 207, 120, 20);
		frame.getContentPane().add(txtByPlacelatlonalt);
		txtByPlacelatlonalt.setColumns(10);
		
		txtByDevice = new JTextField();
		txtByDevice.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtByDevice.setText("by device:");
		txtByDevice.setBounds(10, 238, 86, 20);
		frame.getContentPane().add(txtByDevice);
		txtByDevice.setColumns(10);
		
		dateNotatrange = new JCheckBox("notAtRange");
		dateNotatrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dateNotatrange.isSelected()==false){
					data_base.clear();
				    data_base.addAll(data_not_filtered);
				    data_not_filtered.clear();
				    JOptionPane.showMessageDialog(null,"the filter was cancelled");
				    chckbxNewCheckBox.setEnabled(true);
				    chckbxByPlacelatlonalt.setEnabled(true);
				    chckbxByDevice.setEnabled(true);
			        placeNotatrange.setEnabled(true);
			        chckbxNotequals.setEnabled(true);
			        filter_2_values.setEnabled(true);
			        date_1.setText(""); date_2.setText("");hour_1.setText(""); hour_2.setText("");
				    }
				else{
				String date1,date2,hour1,hour2;
				date1=(String)date_1.getText();date2=(String)date_2.getText();
				hour1=(String)hour_1.getText();hour2=(String)hour_2.getText();
				System.out.println((date1.substring(2,3).equals("-")) && (date1.substring(5,6).equals("-")) && (date2.substring(2,3).equals("-")) && (date2.substring(5,6).equals("-")) && (hour1.substring(2,3).equals(":")) && (hour2.substring(2,3).equals(":")));
			    	try {
				       if ((date1.substring(2,3).equals("-")) && (date1.substring(5,6).equals("-")) && (date2.substring(2,3).equals("-")) && (date2.substring(5,6).equals("-")) && (hour1.substring(2,3).equals(":")) && (hour2.substring(2,3).equals(":"))){
					        int d1,d2,h1,h2;
					        d1=Integer.parseInt(date1.substring(0,2)); d1=Integer.parseInt(date1.substring(3,5));
					        d1=Integer.parseInt(date1.substring(6,10));d2=Integer.parseInt(date2.substring(0,2));
					        d2=Integer.parseInt(date2.substring(3,5)); d2=Integer.parseInt(date2.substring(6,10));
					        h1=Integer.parseInt(hour1.substring(0,2)); h1=Integer.parseInt(hour2.substring(0,2));
					        h1=Integer.parseInt(hour1.substring(3,5)); h1=Integer.parseInt(hour2.substring(3,5));
					        String str1=date1+","+hour1+","+date2+","+hour2;
					        data_not_filtered.addAll(data_base);
				            combiningData.listToCsv(data_base,"c.csv");
				            data_base.clear();
				            data_base.addAll(processingData.list("c.csv", "filtering", "Time", str1,"not"));
				            JOptionPane.showMessageDialog(null,"the data was filtered");
				            chckbxNewCheckBox.setEnabled(false);
						    chckbxByPlacelatlonalt.setEnabled(false);
						    chckbxByDevice.setEnabled(false);
					        placeNotatrange.setEnabled(false);
					        chckbxNotequals.setEnabled(false);
					        filter_2_values.setEnabled(false);
				            }
				    
				      else{
				    	  JOptionPane.showMessageDialog(null,"please enter valid format");
				    	  dateNotatrange.setSelected(false);
				    	  date_1.setText(""); date_2.setText("");hour_1.setText(""); hour_2.setText("");
				    	  }
			          }
			          catch(Exception e1){JOptionPane.showMessageDialog(null,"please enter valid format");
			          dateNotatrange.setSelected(false);
			    	  date_1.setText(""); date_2.setText("");hour_1.setText(""); hour_2.setText("");}
				     }}}
				
				    
			
		);
		dateNotatrange.setBounds(744, 175, 120, 23);
		frame.getContentPane().add(dateNotatrange);
		
		placeNotatrange = new JCheckBox("notAtRange");
		placeNotatrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (placeNotatrange.isSelected()==false){
					data_base.clear();
				    data_base.addAll(data_not_filtered);
				    data_not_filtered.clear();
				    JOptionPane.showMessageDialog(null,"the filter was cancelled");
				    chckbxNewCheckBox.setEnabled(true);
				    chckbxByPlacelatlonalt.setEnabled(true);
				    chckbxByDevice.setEnabled(true);
			        dateNotatrange.setEnabled(true);
			        dateNotatrange.setEnabled(true);
			        chckbxNotequals.setEnabled(true);
			        filter_2_values.setEnabled(true);
					lat_1.setText("");lat_2.setText("");lon_1.setText("");lon_2.setText("");alt_1.setText("");alt_2.setText("");
				}
				else{
				double lat1,lon1,alt1,lat2,lon2,alt2;
				try{
					lat1=Double.parseDouble((String)lat_1.getText());lon1=Double.parseDouble((String)lon_1.getText());alt1=Double.parseDouble((String)alt_1.getText());
					lat2=Double.parseDouble((String)lat_2.getText());lon2=Double.parseDouble((String)lon_2.getText());alt2=Double.parseDouble((String)alt_2.getText());
					String str=(String)lat_1.getText()+","+(String)lon_1.getText()+","+(String)alt_1.getText()+","+(String)lat_2.getText()+","+(String)lon_2.getText()+","+(String)alt_2.getText();
					data_not_filtered.addAll(data_base);
					combiningData.listToCsv(data_base,"c.csv");
			        data_base.clear();
			        data_base.addAll(processingData.list("c.csv", "filtering", "Place", str,"not"));
			        JOptionPane.showMessageDialog(null,"the data was filtered");
			        chckbxNewCheckBox.setEnabled(false);
				    chckbxByPlacelatlonalt.setEnabled(false);
				    chckbxByDevice.setEnabled(false);
			        dateNotatrange.setEnabled(false);
			        dateNotatrange.setEnabled(false);
			        chckbxNotequals.setEnabled(false);
			        filter_2_values.setEnabled(false);}
			    			
				catch(Exception e1){JOptionPane.showMessageDialog(null,"please enter valid numbers");
				placeNotatrange.setSelected(false);
				lat_1.setText("");lat_2.setText("");lon_1.setText("");lon_2.setText("");alt_1.setText("");alt_2.setText("");
				}
				}}
			});
			
		placeNotatrange.setBounds(744, 206, 97, 23);
		frame.getContentPane().add(placeNotatrange);
		
		chckbxNotequals = new JCheckBox("notEquals");
		chckbxNotequals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNotequals.isSelected()==false){
					data_base.clear();
				    data_base.addAll(data_not_filtered);
				    data_not_filtered.clear();
				    JOptionPane.showMessageDialog(null,"the filter was cancelled");
				    chckbxNewCheckBox.setEnabled(true);
				    chckbxByPlacelatlonalt.setEnabled(true);
				    chckbxByDevice.setEnabled(true);
			        dateNotatrange.setEnabled(true);
			        dateNotatrange.setEnabled(true);
			        placeNotatrange.setEnabled(true);
			        filter_2_values.setEnabled(true);
			        textDevice.setText("");
			        
				}
				else{
				String val=(String)textDevice.getText();
				data_not_filtered.addAll(data_base);
				combiningData.listToCsv(data_base,"c.csv");
		        data_base.clear();
		        data_base.addAll(processingData.list("c.csv", "filtering", "ID", val,"yes"));
		        JOptionPane.showMessageDialog(null,"the data was filtered");
		        chckbxNewCheckBox.setEnabled(false);
			    chckbxByPlacelatlonalt.setEnabled(false);
			    chckbxByDevice.setEnabled(false);
		        dateNotatrange.setEnabled(false);
		        dateNotatrange.setEnabled(false);
		        placeNotatrange.setEnabled(false);
		        filter_2_values.setEnabled(false);}
			}
		});
		
		chckbxNotequals.setBounds(744, 235, 97, 23);
		frame.getContentPane().add(chckbxNotequals);
		
		txtFilterBy = new JTextField();
		txtFilterBy.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFilterBy.setBackground(Color.PINK);
		txtFilterBy.setText("filter by 2 values");
		txtFilterBy.setColumns(10);
		txtFilterBy.setBounds(10, 283, 111, 20);
		frame.getContentPane().add(txtFilterBy);
		
		String []filters={"","Time","Place","Device"};
		String [] yes_not1={"","yes","not"};
		String [] or_and1={"","or","and"};
		
		JComboBox filter1 = new JComboBox(filters);
		filter1.setBounds(213, 314, 97, 20);
		frame.getContentPane().add(filter1);
		
		not_yes = new JComboBox(yes_not1);
		not_yes.setBounds(10, 314, 56, 20);
		frame.getContentPane().add(not_yes);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_2.setBackground(new Color(154, 205, 50));
		textField_2.setText("(");
		textField_2.setBounds(81, 314, 15, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		not_yes_filter1 = new JComboBox(yes_not1);
		not_yes_filter1.setBounds(131, 314, 72, 20);
		frame.getContentPane().add(not_yes_filter1);
		
		and_or = new JComboBox(or_and1);
		and_or.setBounds(340, 314, 66, 20);
		frame.getContentPane().add(and_or);
		
		not_yes_filter2 = new JComboBox(yes_not1);
		not_yes_filter2.setBounds(441, 314, 74, 20);
		frame.getContentPane().add(not_yes_filter2);
		
		filter2 = new JComboBox(filters);
		filter2.setBounds(525, 314, 87, 20);
		frame.getContentPane().add(filter2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_3.setBackground(new Color(154, 205, 50));
		textField_3.setText(")");
		textField_3.setColumns(10);
		textField_3.setBounds(647, 314, 15, 20);
		frame.getContentPane().add(textField_3);
		
		filter_2_values = new JCheckBox("filter");
		filter_2_values.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (filter_2_values.isSelected()==false){
					data_base.clear();
				    data_base.addAll(data_not_filtered);
				    data_not_filtered.clear();
				    JOptionPane.showMessageDialog(null,"the filter was cancelled");
				    chckbxNewCheckBox.setEnabled(true);
				    chckbxByPlacelatlonalt.setEnabled(true);
				    chckbxByDevice.setEnabled(true);
			        dateNotatrange.setEnabled(true);
			        dateNotatrange.setEnabled(true);
			        placeNotatrange.setEnabled(true);
			        chckbxNotequals.setEnabled(true);
				}
				else{
					String f1=(String)filter1.getSelectedItem();
					String f2=(String)filter2.getSelectedItem();
					String notYes=(String)not_yes.getSelectedItem();
				    String notYes1=(String)not_yes_filter1.getSelectedItem();
				    String notYes2=(String)not_yes_filter2.getSelectedItem();
				    String andOr=(String)and_or.getSelectedItem();
				    String dataTime="";
				    String dataID=(String)textDevice.getText();
				    String dataPlace="";
				    try{
						double lat1=Double.parseDouble((String)lat_1.getText());double lon1=Double.parseDouble((String)lon_1.getText());double alt1=Double.parseDouble((String)alt_1.getText());
						double lat2=Double.parseDouble((String)lat_2.getText());double lon2=Double.parseDouble((String)lon_2.getText());double alt2=Double.parseDouble((String)alt_2.getText());
						dataPlace+=(String)lat_1.getText()+","+(String)lon_1.getText()+","+(String)alt_1.getText()+","+(String)lat_2.getText()+","+(String)lon_2.getText()+","+(String)alt_2.getText();
						}
					catch(Exception e1){JOptionPane.showMessageDialog(null,"please enter valid numbers");
					filter_2_values.setSelected(false);
					filter1.setSelectedItem("");
					filter2.setSelectedItem("");
					not_yes.setSelectedItem("");
					not_yes_filter1.setSelectedItem("");
					not_yes_filter2.setSelectedItem("");
					and_or.setSelectedItem("");
					}
				    
				    String date1,date2,hour1,hour2;
					date1=(String)date_1.getText();date2=(String)date_2.getText();
					hour1=(String)hour_1.getText();hour2=(String)hour_2.getText();
				    try {
					    if ((date1.substring(2,3).equals("-")) && (date1.substring(5,6).equals("-")) && (date2.substring(2,3).equals("-")) && (date2.substring(5,6).equals("-")) && (hour1.substring(2,3).equals(":")) && (hour2.substring(2,3).equals(":"))){
						      int d1,d2,h1,h2;
						   
						        d1=Integer.parseInt(date1.substring(0,2)); d1=Integer.parseInt(date1.substring(3,5));
						        d1=Integer.parseInt(date1.substring(6,10));d2=Integer.parseInt(date2.substring(0,2));
						        d2=Integer.parseInt(date2.substring(3,5)); d2=Integer.parseInt(date2.substring(6,10));
						        h1=Integer.parseInt(hour1.substring(0,2)); h1=Integer.parseInt(hour2.substring(0,2));
						        h1=Integer.parseInt(hour1.substring(3,5));h1=Integer.parseInt(hour2.substring(3,5));
						        dataTime+=date1+","+hour1+","+date2+","+hour2;}
					     else{
					    	  JOptionPane.showMessageDialog(null,"please enter valid format");
					    	  filter_2_values.setSelected(false);
						      filter1.setSelectedItem("");
						      filter2.setSelectedItem("");
							  not_yes.setSelectedItem("");
							  not_yes_filter1.setSelectedItem("");
							  not_yes_filter2.setSelectedItem("");
							  and_or.setSelectedItem("");
					    	  }
				        }
				        catch(Exception e1){JOptionPane.showMessageDialog(null,"please enter valid format");
				        filter_2_values.setSelected(false);
						filter1.setSelectedItem("");
						filter2.setSelectedItem("");
						not_yes.setSelectedItem("");
						not_yes_filter1.setSelectedItem("");
						not_yes_filter2.setSelectedItem("");
						and_or.setSelectedItem("");}
					
				        data_not_filtered.addAll(data_base);
					    combiningData.listToCsv(data_base,"c.csv");
			            data_base.clear();
			            if (f1.equals("Place") && f2.equals("Time"))  data_base.addAll(processingData.list("c.csv","filtering", f1, dataPlace ,notYes1,  f2,  dataTime, notYes2,  andOr,notYes));
			            if (f1.equals("Place") && f2.equals("Device")) data_base.addAll(processingData.list("c.csv","filtering", f1, dataPlace ,notYes1,  f2,  dataID, notYes2,  andOr,notYes));
			            if (f1.equals("Time") && f2.equals("Device")) data_base.addAll(processingData.list("c.csv","filtering", f1, dataTime ,notYes1,  f2,  dataID, notYes2,  andOr,notYes));
			            if (f1.equals("Time") && f2.equals("Place")) data_base.addAll(processingData.list("c.csv","filtering", f1, dataTime ,notYes1,  f2,  dataPlace, notYes2,  andOr,notYes));
			            if (f1.equals("Device") && f2.equals("Time")) data_base.addAll(processingData.list("c.csv","filtering", f1, dataID ,notYes1,  f2,  dataTime, notYes2,  andOr,notYes));
			            if (f1.equals("Device") && f2.equals("Place")) data_base.addAll(processingData.list("c.csv","filtering", f1, dataID ,notYes1,  f2,  dataPlace, notYes2,  andOr,notYes));
			            JOptionPane.showMessageDialog(null,"data was filtered");
			            chckbxNewCheckBox.setEnabled(false);
					    chckbxByPlacelatlonalt.setEnabled(false);
					    chckbxByDevice.setEnabled(false);
				        dateNotatrange.setEnabled(false);
				        dateNotatrange.setEnabled(false);
				        placeNotatrange.setEnabled(false);
				        chckbxNotequals.setEnabled(false);
			    			
					
				}
				
			}
		});
		filter_2_values.setBounds(668, 313, 97, 23);
		frame.getContentPane().add(filter_2_values);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_4.setBackground(new Color(240, 230, 140));
		textField_4.setText(")");
		textField_4.setColumns(10);
		textField_4.setBounds(622, 314, 15, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_5.setBackground(new Color(240, 230, 140));
		textField_5.setText("(");
		textField_5.setColumns(10);
		textField_5.setBounds(416, 314, 15, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_6.setBackground(new Color(240, 230, 140));
		textField_6.setText(")");
		textField_6.setColumns(10);
		textField_6.setBounds(315, 314, 15, 20);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_7.setBackground(new Color(240, 230, 140));
		textField_7.setText("(");
		textField_7.setColumns(10);
		textField_7.setBounds(106, 314, 15, 20);
		frame.getContentPane().add(textField_7);
		
		chckbxNewCheckBox_1 = new JCheckBox("enter comb_no_gps_string:");
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			     LinkedList <Wifi> data1=new LinkedList <Wifi> ();
			     data1.addAll(data_base);
			     combiningData.listToCsv(data1,"c.csv");
			 	 JOptionPane.showMessageDialog(null, algorithms.findPlaceAlgorithm2("c.csv",(String)noGPS.getText(),4,10000,0.4,2));}
			 	 
		});
		chckbxNewCheckBox_1.setBounds(10, 427, 197, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		noGPS = new JTextPane();
		noGPS .setBounds(257, 430, 564, 20);
		frame.getContentPane().add(noGPS);
		
		chckbxEnterOr = new JCheckBox("enter 1-3 pairs of MAC and signal:");
		chckbxEnterOr.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxEnterOr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		      String d1=(String)data1.getText(); String d2=(String)data2.getText(); String d3=(String)data3.getText();
		      if (d1.equals("") && d2.equals("") && d3.equals("")) JOptionPane.showMessageDialog(null,"please enter values");
				else{
				try{
                    if (!(d1.equals(""))){
					String mac=d1.split(",")[0]; String signal=d1.split(",")[1]; int s=Integer.parseInt(signal);}
                    if (!(d2.equals(""))){
                    	String mac=d2.split(",")[0]; String signal=d2.split(",")[1];int s=Integer.parseInt(signal);}
                    if (!(d3.equals(""))){
                    	String mac=d3.split(",")[0]; String signal=d3.split(",")[1];int s=Integer.parseInt(signal);}

    				LinkedList <Wifi> data1=new LinkedList <Wifi> ();
    			    data1.addAll(data_base);
    			    combiningData.listToCsv(data1,"c.csv");
    			    JOptionPane.showMessageDialog(null,algorithms.findPlaceAlgorithm2( "c.csv",d1,d2,d3,4,10000,0.4,2));
				}
               
                catch(Exception e1){JOptionPane.showMessageDialog(null,"please enter valid format");}
		
				finally{
					chckbxEnterOr.setSelected(false);
					data1.setText("");data2.setText("");data3.setText("");}
			    }
			}
		});
		chckbxEnterOr.setBounds(10, 453, 237, 23);
		frame.getContentPane().add(chckbxEnterOr);
		
		data1 = new JTextPane();
		data1.setBounds(153, 480, 133, 20);
		frame.getContentPane().add(data1);
		
		txtMac = new JTextField();
		txtMac.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtMac.setText("pair1 (mac1,signal1):");
		txtMac.setBounds(10, 480, 133, 20);
		frame.getContentPane().add(txtMac);
		txtMac.setColumns(10);
		
		txtPairmacsignal = new JTextField();
		txtPairmacsignal.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtPairmacsignal.setText("pair2 (mac2,signal2):");
		txtPairmacsignal.setColumns(10);
		txtPairmacsignal.setBounds(296, 480, 125, 20);
		frame.getContentPane().add(txtPairmacsignal);
		
		data2 = new JTextPane();
		data2.setBounds(438, 480, 120, 20);
		frame.getContentPane().add(data2);
		
		txtPairmacsignal_1 = new JTextField();
		txtPairmacsignal_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtPairmacsignal_1.setText("pair3 (mac3,signal3):");
		txtPairmacsignal_1.setColumns(10);
		txtPairmacsignal_1.setBounds(568, 480, 132, 20);
		frame.getContentPane().add(txtPairmacsignal_1);
		
		data3 = new JTextPane();
		data3.setBounds(710, 480, 111, 20);
		frame.getContentPane().add(data3);
	}
}