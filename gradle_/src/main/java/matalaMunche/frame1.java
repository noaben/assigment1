package matalaMunche;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JTextPane;


import java.awt.Color;
import javax.swing.DropMode;

import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Font;

public class frame1 {

	protected JFrame frame;
	private JComboBox filter1;
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
	private JCheckBox atTime;
	private JCheckBox atPlace;
	private JCheckBox atDevice;
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
	private JCheckBox kml1;
	private JTextField txtByDateddmmyyyy;
	private JTextField txtByPlacelatlonalt;
	private JTextField txtByDevice;
	private JCheckBox notAtTime;
	private JCheckBox notAtPlace;
	private JCheckBox notAtDevice;
	private JTextField txtFilterBy;
	private JComboBox not_yes;
	private JTextField textField_2;
	private JComboBox not_yes_filter1;
	private JComboBox and_or;
	private JComboBox not_yes_filter2;
	private JComboBox filter2;
	private JTextField textField_3;
	private JCheckBox at2;
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
	private JCheckBox upload_filter;
	private JCheckBox save_filter;
	private JTextField txtFilter_1;
	private JTextPane txtpnUrl;
	private JTextPane txtpnUrl_1;
	private JTextPane txtpnTable_1;
	
	/**
	 * Create the application.
	 */
	public frame1(LinkedList <Wifi> data_base, LinkedList <Wifi> data_not_filtered,ArrayList <File> folder,ArrayList <Long> folder_last_modified, ArrayList <File> combs,ArrayList <Long> combs_last_modified,ArrayList <connectSQL> sql,ArrayList <String> sql_last,String s[]) {
		initialize_and_update(data_base,data_not_filtered,folder,folder_last_modified,combs,combs_last_modified,sql,sql_last,s);
	}

	/**
	 * Initialize the contents of the frame and updating data structure by the events happening
	 */
	private  void initialize_and_update(LinkedList <Wifi> data_base,LinkedList <Wifi> data_not_filtered,ArrayList <File> folder,ArrayList <Long> folder_last_modified, ArrayList <File> combs,ArrayList <Long> combs_last_modified,ArrayList <connectSQL> sql,ArrayList <String> sql_last,String s[]) {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 850,650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		txtFilters = new JTextField();
		txtFilters.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFilters.setBackground(Color.PINK);
		txtFilters.setBounds(10, 241, 111, 20);
		txtFilters.setText("filter by 1 value");
		frame.getContentPane().add(txtFilters);
		txtFilters.setColumns(10);
		
		txtAlgorithms = new JTextField();
		txtAlgorithms.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAlgorithms.setBackground(Color.PINK);
		txtAlgorithms.setBounds(10, 471, 157, 20);
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
		txtFrom.setBounds(208, 272, 39, 20);
		frame.getContentPane().add(txtFrom);
		txtFrom.setColumns(10);
		
		txtTo = new JTextField();
		txtTo.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtTo.setText("to:");
		txtTo.setColumns(10);
		txtTo.setBounds(431, 303, 26, 20);
		frame.getContentPane().add(txtTo);
		
		textDevice= new JTextPane();
		textDevice.setBounds(208, 334, 269, 20);
		frame.getContentPane().add(textDevice);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField.setText("from:");
		textField.setColumns(10);
		textField.setBounds(208, 303, 39, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_1.setText("to:");
		textField_1.setColumns(10);
		textField_1.setBounds(431, 272, 26, 20);
		frame.getContentPane().add(textField_1);
		
		lat_1 = new JTextPane();
		lat_1.setBounds(257, 303, 48, 20);
		frame.getContentPane().add(lat_1);
		
		lon_1 = new JTextPane();
		lon_1.setBounds(315, 303, 48, 20);
		frame.getContentPane().add(lon_1);
		
		alt_1 = new JTextPane();
		alt_1.setBounds(373, 303, 48, 20);
		frame.getContentPane().add(alt_1);
		
		lat_2 = new JTextPane();
		lat_2.setBounds(467, 303, 48, 20);
		frame.getContentPane().add(lat_2);
		
		lon_2 = new JTextPane();
		lon_2.setBounds(525, 303, 48, 20);
		frame.getContentPane().add(lon_2);
		
		alt_2 = new JTextPane();
		alt_2.setBounds(583, 303, 48, 20);
		frame.getContentPane().add(alt_2);
		
		atTime = new JCheckBox("atRange");
		atTime.setBounds(662, 271, 80, 23);
		frame.getContentPane().add(atTime);
		
		atPlace = new JCheckBox("atRange");
		atPlace.setBounds(662, 302, 80, 23);
		frame.getContentPane().add(atPlace);
		
		atDevice = new JCheckBox("equals");
		atDevice.setBounds(662, 331, 66, 23);
		frame.getContentPane().add(atDevice);
		
		date_1 = new JTextPane();
		date_1.setBounds(257, 272, 62, 20);
		frame.getContentPane().add(date_1);
		
		hour_1 = new JTextPane();
		hour_1.setBounds(329, 272, 34, 20);
		frame.getContentPane().add(hour_1);
		
		date_2 = new JTextPane();
		date_2.setBounds(467, 272, 62, 20);
		frame.getContentPane().add(date_2);
		
		hour_2 = new JTextPane();
		hour_2.setBounds(539, 272, 34, 20);
		frame.getContentPane().add(hour_2);
		
		chckbxFindPlaceOf = new JCheckBox("enter MAC:");
		chckbxFindPlaceOf.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxFindPlaceOf.setBounds(10, 498, 197, 23);
		frame.getContentPane().add(chckbxFindPlaceOf);
		
		mac = new JTextPane();
		mac.setBounds(256, 498, 150, 20);
		frame.getContentPane().add(mac);
		
		chckbxDatafolder = new JCheckBox("enter WigleWifi folder:");
		chckbxDatafolder.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxDatafolder.setBounds(10, 64, 157, 23);
		frame.getContentPane().add(chckbxDatafolder);
		
		dataFolder = new JTextPane();
		dataFolder.setBounds(228, 64, 120, 20);
		frame.getContentPane().add(dataFolder);
		
		chckbxCombcsv = new JCheckBox("enter comb_csv (aaaaa.csv):");
		chckbxCombcsv.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxCombcsv.setBounds(10, 87, 212, 23);
		frame.getContentPane().add(chckbxCombcsv);
		
		chckbxErasedata = new JCheckBox("erase_data_structure");
		chckbxErasedata.setForeground(new Color(255, 0, 0));
		chckbxErasedata.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxErasedata.setBounds(10, 199, 197, 23);
		frame.getContentPane().add(chckbxErasedata);
		
		txtOutput = new JTextField();
		txtOutput.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtOutput.setBackground(Color.PINK);
		txtOutput.setText("output");
		txtOutput.setColumns(10);
		txtOutput.setBounds(373, 11, 86, 20);
		frame.getContentPane().add(txtOutput);
		
		comb_input = new JTextPane();
		comb_input.setBounds(228, 90, 120, 20);
		frame.getContentPane().add(comb_input);
		
		comb_output = new JCheckBox("export to \"comb.csv\"");
		comb_output.setFont(new Font("Tahoma", Font.BOLD, 11));
		comb_output.setBounds(373, 38, 197, 23);
		frame.getContentPane().add(comb_output);
		
		chckbxKmlfile = new JCheckBox("get_info_of_data_structure");
		chckbxKmlfile.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxKmlfile.setBounds(373, 90, 209, 23);
		frame.getContentPane().add(chckbxKmlfile);
		
		kml1 = new JCheckBox("export to \"data.kml\"");
		kml1.setFont(new Font("Tahoma", Font.BOLD, 11));
		kml1.setBounds(373, 64, 209, 23);
		frame.getContentPane().add(kml1);
		
		txtByDateddmmyyyy = new JTextField();
		txtByDateddmmyyyy.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtByDateddmmyyyy.setText("by date (dd-mm-yyyy hh:mm):");
		txtByDateddmmyyyy.setBounds(10, 272, 188, 20);
		frame.getContentPane().add(txtByDateddmmyyyy);
		txtByDateddmmyyyy.setColumns(10);
		
		txtByPlacelatlonalt = new JTextField();
		txtByPlacelatlonalt.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtByPlacelatlonalt.setText("by place(lat,lon,alt):");
		txtByPlacelatlonalt.setBounds(10, 303, 120, 20);
		frame.getContentPane().add(txtByPlacelatlonalt);
		txtByPlacelatlonalt.setColumns(10);
		
		txtByDevice = new JTextField();
		txtByDevice.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtByDevice.setText("by device:");
		txtByDevice.setBounds(10, 334, 86, 20);
		frame.getContentPane().add(txtByDevice);
		txtByDevice.setColumns(10);
		
		notAtTime = new JCheckBox("notAtRange");
		notAtTime.setBounds(744, 271, 120, 23);
		frame.getContentPane().add(notAtTime);
		
		notAtPlace = new JCheckBox("notAtRange");	
		notAtPlace.setBounds(744, 302, 97, 23);
		frame.getContentPane().add(notAtPlace);
		
		notAtDevice = new JCheckBox("notEquals");
		notAtDevice.setBounds(744, 331, 97, 23);
		frame.getContentPane().add(notAtDevice);
		
		txtFilterBy = new JTextField();
		txtFilterBy.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFilterBy.setBackground(Color.PINK);
		txtFilterBy.setText("filter by 2 values");
		txtFilterBy.setColumns(10);
		txtFilterBy.setBounds(10, 384, 111, 20);
		frame.getContentPane().add(txtFilterBy);
		
		String []filters={"","Time","Place","Device"};
		String [] yes_not1={"","yes","not"};
		String [] or_and1={"","or","and"};
		
	        filter1 = new JComboBox(filters);
		filter1.setBounds(219, 415, 86, 20);
		frame.getContentPane().add(filter1);
		
		not_yes = new JComboBox(yes_not1);
		not_yes.setBounds(10, 415, 56, 20);
		frame.getContentPane().add(not_yes);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_2.setBackground(new Color(154, 205, 50));
		textField_2.setText("(");
		textField_2.setBounds(81, 415, 15, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		not_yes_filter1 = new JComboBox(yes_not1);
		not_yes_filter1.setBounds(131, 415, 76, 20);
		frame.getContentPane().add(not_yes_filter1);
		
		and_or = new JComboBox(or_and1);
		and_or.setBounds(340, 415, 66, 20);
		frame.getContentPane().add(and_or);
		
		not_yes_filter2 = new JComboBox(yes_not1);
		not_yes_filter2.setBounds(441, 415, 74, 20);
		frame.getContentPane().add(not_yes_filter2);
		
		filter2 = new JComboBox(filters);
		filter2.setBounds(525, 415, 87, 20);
		frame.getContentPane().add(filter2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_3.setBackground(new Color(154, 205, 50));
		textField_3.setText(")");
		textField_3.setColumns(10);
		textField_3.setBounds(646, 415, 15, 20);
		frame.getContentPane().add(textField_3);
		
		at2 = new JCheckBox("filter");	    
		at2.setBounds(667, 414, 97, 23);
		frame.getContentPane().add(at2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_4.setBackground(new Color(240, 230, 140));
		textField_4.setText(")");
		textField_4.setColumns(10);
		textField_4.setBounds(622, 415, 15, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_5.setBackground(new Color(240, 230, 140));
		textField_5.setText("(");
		textField_5.setColumns(10);
		textField_5.setBounds(416, 415, 15, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_6.setBackground(new Color(240, 230, 140));
		textField_6.setText(")");
		textField_6.setColumns(10);
		textField_6.setBounds(315, 415, 15, 20);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_7.setBackground(new Color(240, 230, 140));
		textField_7.setText("(");
		textField_7.setColumns(10);
		textField_7.setBounds(106, 415, 15, 20);
		frame.getContentPane().add(textField_7);
		
		chckbxNewCheckBox_1 = new JCheckBox("enter comb_no_gps_string:");
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox_1.setBounds(10, 524, 197, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		noGPS = new JTextPane();
		noGPS .setBounds(257, 529, 564, 20);
		frame.getContentPane().add(noGPS);
		
		chckbxEnterOr = new JCheckBox("enter 1-3 pairs of MAC and signal:");
		chckbxEnterOr.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxEnterOr.setBounds(10, 550, 237, 23);
		frame.getContentPane().add(chckbxEnterOr);
		
		data1 = new JTextPane();
		data1.setBounds(153, 580, 133, 20);
		frame.getContentPane().add(data1);
		
		txtMac = new JTextField();
		txtMac.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtMac.setText("pair1 (mac1,signal1):");
		txtMac.setBounds(10, 580, 133, 20);
		frame.getContentPane().add(txtMac);
		txtMac.setColumns(10);
		
		txtPairmacsignal = new JTextField();
		txtPairmacsignal.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtPairmacsignal.setText("pair2 (mac2,signal2):");
		txtPairmacsignal.setColumns(10);
		txtPairmacsignal.setBounds(296, 580, 125, 20);
		frame.getContentPane().add(txtPairmacsignal);
		
		data2 = new JTextPane();
		data2.setBounds(438, 580, 120, 20);
		frame.getContentPane().add(data2);
		
		txtPairmacsignal_1 = new JTextField();
		txtPairmacsignal_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtPairmacsignal_1.setText("pair3 (mac3,signal3):");
		txtPairmacsignal_1.setColumns(10);
		txtPairmacsignal_1.setBounds(568, 580, 132, 20);
		frame.getContentPane().add(txtPairmacsignal_1);
		
		data3 = new JTextPane();
		data3.setBounds(710, 580, 111, 20);
		frame.getContentPane().add(data3);
		
		JCheckBox save_filter = new JCheckBox("export to \"filter.ser\"");
                save_filter.setFont(new Font("Tahoma", Font.BOLD, 11));
	        save_filter.setBounds(614, 38, 150, 23);
	        frame.getContentPane().add(save_filter);
		save_filter.setEnabled(false);
		
        	upload_filter = new JCheckBox("upload filter");
	        upload_filter.setFont(new Font("Tahoma", Font.BOLD, 11));
	        upload_filter.setEnabled(false);
		frame.getContentPane().add(upload_filter);
		upload_filter.setBounds(614, 64, 97, 23);
	        
		txtFilter_1 = new JTextField();
		txtFilter_1.setText("filter");
		txtFilter_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFilter_1.setColumns(10);
		txtFilter_1.setBackground(Color.PINK);
		txtFilter_1.setBounds(614, 11, 86, 20);
		frame.getContentPane().add(txtFilter_1);
	
		
		JTextPane IP = new JTextPane();
		IP.setBounds(371, 156, 86, 20);
		frame.getContentPane().add(IP);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setBounds(239, 156, 80, 20);
		frame.getContentPane().add(txtpnPassword);
		
		JTextPane txtpnUser = new JTextPane();
		txtpnUser.setBounds(72, 156, 66, 20);
		frame.getContentPane().add(txtpnUser);
		
		JTextPane txtpnTable = new JTextPane();
		txtpnTable.setBounds(667, 156, 80, 20);
		frame.getContentPane().add(txtpnTable);
		
		txtpnUrl = new JTextPane();
		txtpnUrl.setBounds(512, 156, 84, 20);
		frame.getContentPane().add(txtpnUrl);
		
		JCheckBox dataBase = new JCheckBox("enter SQL DB:");
		dataBase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (IP.getText().equals("") || txtpnPassword.getText().equals("") || txtpnUser.getText().equals("") || txtpnTable.getText().equals("") || txtpnUrl.getText().equals("")){
					  dataBase.setSelected(false);
					  JOptionPane.showMessageDialog(null,"please fill all the rubrics");
					  
				}
				else{
					try{
						connectSQL s=new connectSQL(IP.getText(),txtpnUrl.getText(),txtpnUser.getText(),txtpnPassword.getText(),txtpnTable.getText());
                        int size=data_base.size();
						data_base.addAll(s.getData());
						sql.add(new connectSQL(IP.getText(),txtpnUrl.getText(),txtpnUser.getText(),txtpnPassword.getText(),txtpnTable.getText()));
						sql_last.add(sql.get(sql.size()-1).lastModified());
						int sub=data_base.size()-size;
						JOptionPane.showMessageDialog(null,sub+" recording has been added to data structure");
					}
					catch (SQLException e){
						 JOptionPane.showMessageDialog(null,"invalid DB");
					}
				finally{
				  txtpnPassword.setText("");
				  txtpnUser.setText("");
				  txtpnTable.setText("") ;
				  txtpnUrl.setText("");
				  IP.setText("");
				  dataBase.setSelected(false);}
			
				}	}});

		JTextPane path1 = new JTextPane();
		path1.setText("for example: \"C:\\\\database\"");
		path1.setBounds(139, 38, 209, 20);
		frame.getContentPane().add(path1);
		
		
		dataBase.setFont(new Font("Tahoma", Font.BOLD, 11));
		dataBase.setBounds(10, 126, 111, 23);
		frame.getContentPane().add(dataBase);
		
		kml1.setEnabled(false);
		comb_output.setEnabled(false);
		
		JCheckBox path = new JCheckBox("enter source path:");
		path.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (path.isSelected()==true){
					kml1.setEnabled(true);
					comb_output.setEnabled(true);
					chckbxCombcsv.setEnabled(true);
					chckbxDatafolder.setEnabled(true);
				}
				else{
					path1.setText("");
					kml1.setEnabled(false);
					comb_output.setEnabled(false);
					chckbxCombcsv.setEnabled(false);
					chckbxDatafolder.setEnabled(false);
				}
			}
		});
		path.setFont(new Font("Tahoma", Font.BOLD, 11));
		path.setBounds(10, 38, 144, 23);
		frame.getContentPane().add(path);
		
		
		
		atTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (atTime.isSelected()==false){
					data_base.clear();
				        data_base.addAll(data_not_filtered);
				        data_not_filtered.clear();
				        JOptionPane.showMessageDialog(null,"the filter was cancelled");
				        date_1.setText(""); date_2.setText("");hour_1.setText(""); hour_2.setText("");
				        atPlace.setEnabled(true);
			                atDevice.setEnabled(true);
			                notAtTime.setEnabled(true);
			                notAtPlace.setEnabled(true);
			                notAtDevice.setEnabled(true);
			                at2.setEnabled(true);
			                s[0]="0";
					save_filter.setEnabled(false);
				        upload_filter.setEnabled(false);
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
				                 atPlace.setEnabled(false);
					         atDevice.setEnabled(false);
					         notAtTime.setEnabled(false);
					         notAtPlace.setEnabled(false);
					         notAtDevice.setEnabled(false);
					         at2.setEnabled(false);
				                 s[0]="1";
				                 s[1]="yes";
				                 s[2]="Time";
				                 s[3]=str1;
						 save_filter.setEnabled(true);
					         }
				             else{
				      	          JOptionPane.showMessageDialog(null,"please enter valid format");
				      	          atTime.setSelected(false);
				      	          date_1.setText(""); date_2.setText("");hour_1.setText(""); hour_2.setText("");
				    
				    	         }
			                    }
			                catch(Exception e1){JOptionPane.showMessageDialog(null,"please enter valid format");
			                      atTime.setSelected(false);
			                      date_1.setText(""); date_2.setText("");hour_1.setText(""); hour_2.setText("");
			                     } 
				       }
			    }
		});
		
		atPlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (atPlace.isSelected()==false){
				data_base.clear();
			        data_base.addAll(data_not_filtered);
			        data_not_filtered.clear();
			        JOptionPane.showMessageDialog(null,"the filter was cancelled");
			        lat_1.setText("");lat_2.setText("");lon_1.setText("");lon_2.setText("");alt_1.setText("");alt_2.setText("");
			        atTime.setEnabled(true);
		                atDevice.setEnabled(true);
		                notAtTime.setEnabled(true);
		                notAtPlace.setEnabled(true);
		                notAtDevice.setEnabled(true);
		                at2.setEnabled(true);
		                s[0]="0";
				save_filter.setEnabled(false);
				upload_filter.setEnabled(false);
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
		                    atTime.setEnabled(false);
		                    atDevice.setEnabled(false);
		                    notAtTime.setEnabled(false);
		                    notAtPlace.setEnabled(false);
		                    notAtDevice.setEnabled(false);
		                    at2.setEnabled(false);
		                    s[0]="1";
	                            s[1]="yes";
	                            s[2]="Place";
	                            s[3]=str;
				    save_filter.setEnabled(true);
				   
		                    }
		    			
			        catch(Exception e1){
				     JOptionPane.showMessageDialog(null,"please enter valid numbers");
		     	             lat_1.setText("");lat_2.setText("");lon_1.setText("");lon_2.setText("");alt_1.setText("");alt_2.setText("");
			             atPlace.setSelected(false);
				    }
			       }      
			  }
		});
		
		
		atDevice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (atDevice.isSelected()==false){
					data_base.clear();
				        data_base.addAll(data_not_filtered);
				        data_not_filtered.clear();
				        JOptionPane.showMessageDialog(null,"the filter was cancelled");
				        textDevice.setText("");
				        atTime.setEnabled(true);
				        atPlace.setEnabled(true);
			                notAtTime.setEnabled(true);
			                notAtPlace.setEnabled(true);
			                notAtDevice.setEnabled(true);
			                at2.setEnabled(true);
			                s[0]="0";
					save_filter.setEnabled(false);
				        upload_filter.setEnabled(false);
				       }
				else{
				       String val=(String)textDevice.getText();
				       data_not_filtered.addAll(data_base);
				       combiningData.listToCsv(data_base,"c.csv");
		                       data_base.clear();
		                       data_base.addAll(processingData.list("c.csv", "filtering", "ID", val,"yes"));
		                       JOptionPane.showMessageDialog(null,"the data was filtered");
		                       atTime.setEnabled(false);
		                       atPlace.setEnabled(false);
		                       notAtTime.setEnabled(false);
		                       notAtPlace.setEnabled(false);
		                       notAtDevice.setEnabled(false);
		                       at2.setEnabled(false);
				       s[0]="1";
	                               s[1]="yes";
	                               s[2]="ID";
	                               s[3]=val;
				       save_filter.setEnabled(true);
			              
				       }
			       }
		});
		
		chckbxFindPlaceOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		            String MAC=(String)mac.getText();
		            try{
				 if (!MAC.substring(2,3).equals(":") || !MAC.substring(5,6).equals(":") || !MAC.substring(8,9).equals(":") || !MAC.substring(11,12).equals(":") || !MAC.substring(14,15).equals(":")) 
					 JOptionPane.showMessageDialog(null,"check your input. It should be in format aa:aa:aa:aa:aa:aa");
				 else {
					 LinkedList <Wifi> data=new LinkedList <Wifi> ();
					 data.addAll(data_base);
					 combiningData.listToCsv(data,"c.csv");
					 MAC mac1=algorithms.findPlaceAlgorithm1("c.csv", MAC,5);
					 JOptionPane.showMessageDialog(null,"Lat:"+mac1.getLAT()+" Lon:"+mac1.getLON()+" Alt:"+mac1.getALT());
				     }
				 }
			    catch(StringIndexOutOfBoundsException el){
					 JOptionPane.showMessageDialog(null,"check your input. It should be in format aa:aa:aa:aa:aa:aa");}
			    finally{
					 mac.setText("");
					 chckbxFindPlaceOf.setSelected(false);				 }
		               	}  
		});
		
		chckbxDatafolder.setEnabled(false);
		chckbxDatafolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      String folder1=(String)path1.getText()+"\\"+(String)dataFolder.getText();
			      System.out.println(folder);
			      try{
				    File f = new File(folder1);            
				    File[] files = f.listFiles();   
				    int a=files.length;
				    int size1=data_base.size();
					
				    if (s[0].equals("0"))
					        data_base.addAll(combiningData.list(folder1));
				    if (s[0].equals("1")){
						combiningData.listToCsv(combiningData.list(folder1), "c.csv");
						data_not_filtered.addAll(processingData.list("c.csv", "no_filtering", s[2], s[3], s[1]));
						data_base.addAll(processingData.list("c.csv", "filtering", s[2], s[3], s[1]));
					        }
			            if (s[0].equals("2")){
						combiningData.listToCsv(combiningData.list(folder1), "c.csv");
						data_not_filtered.addAll(processingData.list("c.csv", "no_filtering", s[2], s[3], s[1]));
						data_base.addAll(processingData.list("c.csv", "filtering", s[2], s[3], s[1],s[5],s[6],s[4],s[7],s[8]));
					        }
		                    int size2=data_base.size();
				    JOptionPane.showMessageDialog(null,size2-size1+" recordings have been added to data structure");
				    folder.add(f);
				    folder_last_modified.add(f.lastModified());
			    	    }
			       catch(NullPointerException ex){
				        JOptionPane.showMessageDialog(null,"folder does not exist");}
			       finally{
				    	chckbxDatafolder.setSelected(false);
					dataFolder.setText("");
				       }
					
			        }
		});
		
		
		
		chckbxCombcsv.setEnabled(false);
		
		JTextPane txtpnUser_1 = new JTextPane();
		txtpnUser_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnUser_1.setText("user:");
		txtpnUser_1.setBounds(32, 156, 34, 20);
		frame.getContentPane().add(txtpnUser_1);
		
		JTextPane txtpnPassword_1 = new JTextPane();
		txtpnPassword_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnPassword_1.setText("password:");
		txtpnPassword_1.setBounds(158, 156, 71, 20);
		frame.getContentPane().add(txtpnPassword_1);
		
		JTextPane txtpnIp = new JTextPane();
		txtpnIp.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnIp.setText("IP:");
		txtpnIp.setBounds(342, 156, 21, 20);
		frame.getContentPane().add(txtpnIp);
		
		txtpnUrl_1 = new JTextPane();
		txtpnUrl_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnUrl_1.setText("url:");
		txtpnUrl_1.setBounds(481, 156, 26, 20);
		frame.getContentPane().add(txtpnUrl_1);
		
		txtpnTable_1 = new JTextPane();
		txtpnTable_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnTable_1.setText("table:");
		txtpnTable_1.setBounds(617, 156, 44, 20);
		frame.getContentPane().add(txtpnTable_1);
		chckbxCombcsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String source=(String)path1.getText()+"\\"+(String)comb_input.getText();
					File t=new File(source);
					int size1=data_base.size();
					if (s[0].equals("0"))
						data_base.addAll(processingData.list(source, "no_filtering", "filterBy", "requiredData","yes"));
					if (s[0].equals("1")){
						data_not_filtered.addAll(processingData.list(source, "no_filtering", s[2], s[3], s[1]));
						data_base.addAll(processingData.list(source, "filtering", s[2], s[3], s[1]));
					    }
					if (s[0].equals("2")){
						data_not_filtered.addAll(processingData.list(source, "no_filtering", s[2], s[3], s[1]));
						data_base.addAll(processingData.list(source, "filtering", s[2], s[3], s[1],s[5],s[6],s[4],s[7],s[8]));
					    }
						
		        	        int size2=data_base.size();
				        JOptionPane.showMessageDialog(null,size2-size1+" recordings have been added to data structure");
				        combs.add(t);
				        combs_last_modified.add(t.lastModified());
				    
				      }
			        catch(NullPointerException ex){
					JOptionPane.showMessageDialog(null,"file does not exist");
				      }
			        
			        finally{
			               chckbxCombcsv.setSelected(false);
			               comb_input.setText("");
				       }
		                }
			
		    });
		
		
		chckbxErasedata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_base.clear();
				folder.clear();folder_last_modified.clear(); combs.clear();combs_last_modified.clear();
				if (data_base.size()==0) JOptionPane.showMessageDialog(null,"Data structure is empty");
				chckbxErasedata.setSelected(false);
				
			}
		});
		
		comb_output.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkedList<Wifi>data1=new LinkedList <Wifi>();
				data1.addAll(data_base);
				
				if (combiningData.listToCsv(data1, (String)path1.getText()+"\\comb.csv"))
				     JOptionPane.showMessageDialog(null,"CSV file was created");
				else
			             JOptionPane.showMessageDialog(null,"CSV file was not created. reasons: wrong path/no data base");
			
			 comb_output.setSelected(false);
			}});
		
		chckbxKmlfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkedList <Wifi> data=new LinkedList<Wifi>();
				data.addAll(data_base);
				combiningData.listToCsv(data,"t.csv");
				LinkedList <Wifi> data1=new LinkedList<Wifi>();
				data1.addAll(data_base);
				LinkedList <Wifi> data2=new LinkedList<Wifi>();
				data2.addAll(processingData.listOrganized ("t.csv",data1,5,"mac.csv"));
                                String getFilter="filter: ";
                                if (atPlace.isSelected()) getFilter+=(String)lat_1.getText()+"<Lat<"+(String)lat_2.getText()+" && "+(String)lon_1.getText()+"<Lon<"+lon_2.getText()+" && "+alt_1.getText()+"<Alt<"+alt_2.getText();
                                if (notAtPlace.isSelected()) getFilter+="!("+(String)lat_1.getText()+"<Lat<"+(String)lat_2.getText()+" && "+(String)lon_1.getText()+"<Lon<"+lon_2.getText()+" && "+alt_1.getText()+"<Alt<"+alt_2.getText()+")";
                                if (atTime.isSelected()) getFilter+=(String)date_1.getText()+" "+(String)hour_1.getText()+"<Time<"+(String)date_2.getText()+" "+(String)hour_2.getText();
                                if (notAtTime.isSelected()) getFilter+="!("+(String)date_1.getText()+" "+(String)hour_1.getText()+"<Time<"+(String)date_2.getText()+" "+(String)hour_2.getText()+")";
                                if (atDevice.isSelected()) getFilter+="Device="+(String)textDevice.getText();
                                if (notAtDevice.isSelected()) getFilter+="Device!="+(String)textDevice.getText();
                                if (at2.isSelected()){
                                        if (not_yes.getSelectedItem().equals("not")) getFilter+="!(";
                                        if (not_yes_filter1.getSelectedItem().equals("not")) getFilter+="!";
                                        if (filter1.getSelectedItem().equals("Place")) getFilter+="("+(String)lat_1.getText()+"<Lat<"+(String)lat_2.getText()+" && "+(String)lon_1.getText()+"<Lon<"+lon_2.getText()+" && "+alt_1.getText()+"<Alt<"+alt_2.getText()+")";
                                        if (filter1.getSelectedItem().equals("Time")) getFilter+="("+(String)date_1.getText()+" "+(String)hour_1.getText()+"<Time<"+(String)date_2.getText()+" "+(String)hour_2.getText()+")";
                                        if (filter1.getSelectedItem().equals("Device")) getFilter+="(Device="+(String)textDevice.getText()+")";
                                   
                                        if (and_or.getSelectedItem().equals("and")) getFilter+=" && "; else getFilter+=" || ";
                                        if (not_yes_filter2.getSelectedItem().equals("not")) getFilter+=" !";
                                        if (filter2.getSelectedItem().equals("Place")) getFilter+="("+(String)lat_1.getText()+"<Lat<"+(String)lat_2.getText()+" && "+(String)lon_1.getText()+"<Lon<"+lon_2.getText()+" && "+alt_1.getText()+"<Alt<"+alt_2.getText()+")";
                                        if (filter2.getSelectedItem().equals("Time")) getFilter+="("+(String)date_1.getText()+" "+(String)hour_1.getText()+"<Time<"+(String)date_2.getText()+" "+(String)hour_2.getText()+")";
                                        if (filter2.getSelectedItem().equals("Device")) getFilter+="(Device="+(String)textDevice.getText()+")";
                                      
                                        if (not_yes.getSelectedItem().equals("not")) getFilter+=" )";
				        }
                               if (getFilter.equals("filter: ")) getFilter+="no filter has been selected";
               
                               JOptionPane.showMessageDialog(null,"number of recordings: "+data_base.size()+"  number of MAC's:"+data2.size()+"  "+getFilter);
			       chckbxKmlfile.setSelected(false);
			      }
		});
		
		kml1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkedList<Wifi>data1=new LinkedList <Wifi>();
			        data1.addAll(data_base);
			        combiningData.listToCsv(data1,"c.csv");
			  
			        try{
			        if (processingData.CSVtoKML("c.csv", (String)path1.getText()+"\\data.kml", "no_filtering", "", "",0,"b.csv","yes"))
			        	 JOptionPane.showMessageDialog(null,"KML file was created");
			        else
				         JOptionPane.showMessageDialog(null,"KML file was not created. Reason: wrong path");
			     
			        }
			        catch (NullPointerException el){ JOptionPane.showMessageDialog(null,"KML file was not created. Reason: no data base");
				}
			        finally{   kml1.setSelected(false);}}
		        });
	
		notAtTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (notAtTime.isSelected()==false){
					data_base.clear();
				        data_base.addAll(data_not_filtered);
				        data_not_filtered.clear();
				        JOptionPane.showMessageDialog(null,"the filter was cancelled");
				        atTime.setEnabled(true); atPlace.setEnabled(true); atDevice.setEnabled(true);
			                notAtPlace.setEnabled(true);
			                notAtDevice.setEnabled(true);
			                at2.setEnabled(true);
			                date_1.setText(""); date_2.setText("");hour_1.setText(""); hour_2.setText("");
			                s[0]="0";
					save_filter.setEnabled(false);
				        upload_filter.setEnabled(false);
				        }
				else{
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
					          h1=Integer.parseInt(hour1.substring(3,5)); h1=Integer.parseInt(hour2.substring(3,5));
					          String str1=date1+","+hour1+","+date2+","+hour2;
					          data_not_filtered.addAll(data_base);
				                  combiningData.listToCsv(data_base,"c.csv");
				                  data_base.clear();
				                  data_base.addAll(processingData.list("c.csv", "filtering", "Time", str1,"not"));
				                  JOptionPane.showMessageDialog(null,"the data was filtered");
				                  atTime.setEnabled(false);
						  atPlace.setEnabled(false);
						  atDevice.setEnabled(false);
					          notAtPlace.setEnabled(false);
					          notAtDevice.setEnabled(false);
					          at2.setEnabled(false);
					          s[0]="1";
				                  s[1]="not";
				                  s[2]="Time";
				                  s[3]=str1;
						  save_filter.setEnabled(true);
				                 
				                  }
				    
				              else{
				    	           JOptionPane.showMessageDialog(null,"please enter valid format");
				    	           notAtTime.setSelected(false);
				    	           date_1.setText(""); date_2.setText("");hour_1.setText(""); hour_2.setText("");
				    	           }
			                      }
			                 catch(Exception e1){
					       JOptionPane.showMessageDialog(null,"please enter valid format");
			                       notAtTime.setSelected(false);
			    	               date_1.setText(""); date_2.setText("");hour_1.setText(""); hour_2.setText("");}
				              }
			                }
		             });
		
		
		notAtPlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (notAtPlace.isSelected()==false){
					data_base.clear();
				        data_base.addAll(data_not_filtered);
				        data_not_filtered.clear();
				        JOptionPane.showMessageDialog(null,"the filter was cancelled");
				        atTime.setEnabled(true);
				        atPlace.setEnabled(true);
				        atDevice.setEnabled(true);
			                notAtTime.setEnabled(true);
			                notAtTime.setEnabled(true);
			                notAtDevice.setEnabled(true);
			                at2.setEnabled(true);
					lat_1.setText("");lat_2.setText("");lon_1.setText("");lon_2.setText("");alt_1.setText("");alt_2.setText("");
					s[0]="0";
					save_filter.setEnabled(false);
				        upload_filter.setEnabled(false);
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
			                      atTime.setEnabled(false);
				              atPlace.setEnabled(false);
				              atDevice.setEnabled(false);
			                      notAtTime.setEnabled(false);
			                      notAtDevice.setEnabled(false);
			                      at2.setEnabled(false);
			                      s[0]="1";
		                              s[1]="not";
		                              s[2]="Place";
		                              s[3]=str;
					      save_filter.setEnabled(true);
				             
					     }
			    			
				        catch(Exception e1){
					       JOptionPane.showMessageDialog(null,"please enter valid numbers");
				               notAtPlace.setSelected(false);
				               lat_1.setText("");lat_2.setText("");lon_1.setText("");lon_2.setText("");alt_1.setText("");alt_2.setText("");
				              }
				       }       
			        }
			});
			
		
		notAtDevice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (notAtDevice.isSelected()==false){
					data_base.clear();
				        data_base.addAll(data_not_filtered);
				        data_not_filtered.clear();
				        JOptionPane.showMessageDialog(null,"the filter was cancelled");
				        atTime.setEnabled(true);
				        atPlace.setEnabled(true);
				        atDevice.setEnabled(true);
			                notAtTime.setEnabled(true);
			                notAtPlace.setEnabled(true);
			                at2.setEnabled(true);
			                textDevice.setText("");
			                s[0]="0";
					save_filter.setEnabled(false);
				        upload_filter.setEnabled(false);
			               }
				else{
				       String val=(String)textDevice.getText();
				       data_not_filtered.addAll(data_base);
				       combiningData.listToCsv(data_base,"c.csv");
		                       data_base.clear();
		                       data_base.addAll(processingData.list("c.csv", "filtering", "ID", val,"yes"));
		                       JOptionPane.showMessageDialog(null,"the data was filtered");
		                       atTime.setEnabled(false);
			               atPlace.setEnabled(false);
			               atDevice.setEnabled(false);
		                       notAtTime.setEnabled(false);
		                       notAtTime.setEnabled(false);
		                       notAtPlace.setEnabled(false);
		                       at2.setEnabled(false);
		                       s[0]="1";
	                               s[1]="not";
	                               s[2]="ID";
	                               s[3]=val;
				       save_filter.setEnabled(true);
				
				      }
			      }
		});
		
		at2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String f1=(String)filter1.getSelectedItem(); String f2=(String)filter2.getSelectedItem(); String notYes=(String)not_yes.getSelectedItem();
			        String notYes1=(String)not_yes_filter1.getSelectedItem(); String notYes2=(String)not_yes_filter2.getSelectedItem(); String andOr=(String)and_or.getSelectedItem();
				
			        if (at2.isSelected()==false){//button off
				      data_base.clear(); data_base.addAll(data_not_filtered);
			              data_not_filtered.clear();
			              JOptionPane.showMessageDialog(null,"the filter was cancelled");
			              atTime.setEnabled(true); atPlace.setEnabled(true); atDevice.setEnabled(true);
		                      notAtTime.setEnabled(true); notAtPlace.setEnabled(true); notAtDevice.setEnabled(true);
		                      date_1.setText(""); date_2.setText("");hour_1.setText(""); hour_2.setText("");
		                      lat_1.setText(""); lat_2.setText("");lon_1.setText(""); lon_2.setText("");alt_1.setText(""); alt_2.setText("");
		                      textDevice.setText("");
		                      filter1.setSelectedItem("");  filter2.setSelectedItem("");not_yes.setSelectedItem("");not_yes_filter1.setSelectedItem("");not_yes_filter2.setSelectedItem("");and_or.setSelectedItem("");
			              s[0]="0";
				      save_filter.setEnabled(false);
				      upload_filter.setEnabled(false);
			              }
				
			        else if   (f1.equals("") ||  f2.equals("") || notYes.equals("") || notYes1.equals("") || notYes2.equals("") || andOr.equals("")){
			              JOptionPane.showMessageDialog(null,"please fill all rubrics");
			              at2.setSelected(false);
	                              date_1.setText(""); date_2.setText("");hour_1.setText(""); hour_2.setText("");
	                              lat_1.setText(""); lat_2.setText("");lon_1.setText(""); lon_2.setText("");alt_1.setText(""); alt_2.setText("");
	                              filter1.setSelectedItem("");  filter2.setSelectedItem("");not_yes.setSelectedItem("");not_yes_filter1.setSelectedItem("");not_yes_filter2.setSelectedItem("");and_or.setSelectedItem("");
	                              }
			
			        else {
			              s[1]=notYes1; s[4]=notYes2; s[8]=notYes; s[7]=andOr;
			 
			              if ((f1.equals("Time") && f2.equals("Place")) || (f1.equals("Place") && f2.equals("Time"))){
				                String date1,date2,hour1,hour2;
						date1=(String)date_1.getText();date2=(String)date_2.getText();
						hour1=(String)hour_1.getText();hour2=(String)hour_2.getText();
					      
						try{ 
							  if ((date1.substring(2,3).equals("-")) && (date1.substring(5,6).equals("-")) && (date2.substring(2,3).equals("-")) && (date2.substring(5,6).equals("-")) && (hour1.substring(2,3).equals(":")) && (hour2.substring(2,3).equals(":"))){
							        int d1,d2,h1,h2;
							        d1=Integer.parseInt(date1.substring(0,2)); d1=Integer.parseInt(date1.substring(3,5));
							        d1=Integer.parseInt(date1.substring(6,10));d2=Integer.parseInt(date2.substring(0,2));
							        d2=Integer.parseInt(date2.substring(3,5)); d2=Integer.parseInt(date2.substring(6,10));
							        h1=Integer.parseInt(hour1.substring(0,2)); h1=Integer.parseInt(hour2.substring(0,2));
							        h1=Integer.parseInt(hour1.substring(3,5)); h1=Integer.parseInt(hour2.substring(3,5));
							        String str1=date1+","+hour1+","+date2+","+hour2;
							        
							        double lat1,lon1,alt1,lat2,lon2,alt2;
								lat1=Double.parseDouble((String)lat_1.getText());lon1=Double.parseDouble((String)lon_1.getText());alt1=Double.parseDouble((String)alt_1.getText());
								lat2=Double.parseDouble((String)lat_2.getText());lon2=Double.parseDouble((String)lon_2.getText());alt2=Double.parseDouble((String)alt_2.getText());
								String str2=(String)lat_1.getText()+","+(String)lon_1.getText()+","+(String)alt_1.getText()+","+(String)lat_2.getText()+","+(String)lon_2.getText()+","+(String)alt_2.getText();
										
								String op1,op2;
							        if (f1.equals("Time")){
							        	s[2]="Time";
							        	s[3]=str1;
							        	s[5]="Place";
							        	s[6]=str2;
							        	op1=notYes1;
							        	op2=notYes2;
							                }
							        else{
							        	s[2]="Place";
							        	s[3]=str2;
							        	s[5]="Time";
							        	s[6]=str1;
							        	op1=notYes2;
							        	op2=notYes1;
							                }
							        data_not_filtered.addAll(data_base);
							        combiningData.listToCsv(data_base,"c.csv");
							        data_base.clear();
								data_base.addAll(processingData.list("c.csv","filtering",f1,str1,op1,f2,str2,op2, andOr,notYes));
							        JOptionPane.showMessageDialog(null,"the data was filtered");
							        atTime.setEnabled(false);
								atPlace.setEnabled(false); 
								atDevice.setEnabled(false);
							        notAtTime.setEnabled(false);
							        notAtPlace.setEnabled(false);
							        notAtDevice.setEnabled(false);
							        s[0]="2";
								save_filter.setEnabled(true);
				                             
							        }
							  else{  
								JOptionPane.showMessageDialog(null,"please enter valid format");
								at2.setSelected(false);
						                date_1.setText(""); date_2.setText("");hour_1.setText(""); hour_2.setText("");
						                lat_1.setText(""); lat_2.setText("");lon_1.setText(""); lon_2.setText("");alt_1.setText(""); alt_2.setText("");
						                filter1.setSelectedItem("");  filter2.setSelectedItem("");not_yes.setSelectedItem("");not_yes_filter1.setSelectedItem("");not_yes_filter2.setSelectedItem("");and_or.setSelectedItem("");
							       }
						          }					      
					          catch(Exception el){
						           JOptionPane.showMessageDialog(null,"please enter valid format");
						           at2.setSelected(false);
						           date_1.setText(""); date_2.setText("");hour_1.setText(""); hour_2.setText("");
						           lat_1.setText(""); lat_2.setText("");lon_1.setText(""); lon_2.setText("");alt_1.setText(""); alt_2.setText("");
						           filter1.setSelectedItem("");  filter2.setSelectedItem("");not_yes.setSelectedItem("");not_yes_filter1.setSelectedItem("");not_yes_filter2.setSelectedItem("");and_or.setSelectedItem("");
					                   }
						  }
					
				            if ((f1.equals("Place") && f2.equals("Device")) || (f1.equals("Device") && f2.equals("Place"))){
						    try{
						            double lat1,lon1,alt1,lat2,lon2,alt2;
							    lat1=Double.parseDouble((String)lat_1.getText());lon1=Double.parseDouble((String)lon_1.getText());alt1=Double.parseDouble((String)alt_1.getText());
							    lat2=Double.parseDouble((String)lat_2.getText());lon2=Double.parseDouble((String)lon_2.getText());alt2=Double.parseDouble((String)alt_2.getText());
							    String str1=(String)lat_1.getText()+","+(String)lon_1.getText()+","+(String)alt_1.getText()+","+(String)lat_2.getText()+","+(String)lon_2.getText()+","+(String)alt_2.getText();
						            String str2=(String)textDevice.getText();
						            String op1;
					        	    String op2;
							    
						            if (f1.equals("Place")){
						        	s[2]="Place";
						        	s[3]=str1;
						        	s[5]="ID";
						        	s[6]=str2;
						        	op1=notYes1;
						                op2=notYes2;
						                }
						            else{
						        	s[2]="ID";
						        	s[3]=str2;
						        	s[5]="Place";
						        	s[6]=str1;
						        	op1=notYes2;
						        	op2=notYes1;
						                }
						            data_not_filtered.addAll(data_base);
						            combiningData.listToCsv(data_base,"c.csv");
						            data_base.clear();
						            data_base.addAll(processingData.list("c.csv","filtering",f1,str1,op1,f2,str2,op2, andOr,notYes));
						            JOptionPane.showMessageDialog(null,"the data was filtered");
						            atTime.setEnabled(false);
							    atPlace.setEnabled(false);
							    atDevice.setEnabled(false);;
						            notAtTime.setEnabled(false);
						            notAtDevice.setEnabled(false);
						            notAtPlace.setEnabled(false);
						            s[0]="2";
							    save_filter.setEnabled(true);
			                                  
						           }
				                   catch(Exception el){
					                   JOptionPane.showMessageDialog(null,"please enter valid format");
					                   at2.setSelected(false);
					                   textDevice.setText("");
					                   lat_1.setText(""); lat_2.setText("");lon_1.setText(""); lon_2.setText("");alt_1.setText(""); alt_2.setText("");
					                   filter1.setSelectedItem("");  filter2.setSelectedItem("");not_yes.setSelectedItem("");not_yes_filter1.setSelectedItem("");not_yes_filter2.setSelectedItem("");and_or.setSelectedItem("");
					      
				                           }
					            }

				              if ((f1.equals("Time") && f2.equals("Device")) || (f1.equals("Device") && f2.equals("Time"))){
							    String date1,date2,hour1,hour2;
						            date1=(String)date_1.getText();date2=(String)date_2.getText();
							    hour1=(String)hour_1.getText();hour2=(String)hour_2.getText();
									
						            try{ 
                                                                if ((date1.substring(2,3).equals("-")) && (date1.substring(5,6).equals("-")) && (date2.substring(2,3).equals("-")) && (date2.substring(5,6).equals("-")) && (hour1.substring(2,3).equals(":")) && (hour2.substring(2,3).equals(":"))){
							               int d1,d2,h1,h2;
							                d1=Integer.parseInt(date1.substring(0,2)); d1=Integer.parseInt(date1.substring(3,5));
								        d1=Integer.parseInt(date1.substring(6,10));d2=Integer.parseInt(date2.substring(0,2));
								        d2=Integer.parseInt(date2.substring(3,5)); d2=Integer.parseInt(date2.substring(6,10));
								        h1=Integer.parseInt(hour1.substring(0,2)); h1=Integer.parseInt(hour2.substring(0,2));
								        h1=Integer.parseInt(hour1.substring(3,5)); h1=Integer.parseInt(hour2.substring(3,5));
								        String str1=date1+","+hour1+","+date2+","+hour2;
								        String str2=(String)textDevice.getText();
										        
								        String op1,op2;
									if (f1.equals("Time")){
									     s[2]="Time";
								             s[3]=str1;
									     s[5]="ID";
									     s[6]=str2;
									     op1=notYes1;
									     op2=notYes2;
									     }
								         else{
									     s[2]="ID";
									     s[3]=str2;
									     s[5]="Time";
									     s[6]=str1;
								             op1=notYes2;
									     op2=notYes1;
								             }
									
								         data_not_filtered.addAll(data_base);
								         combiningData.listToCsv(data_base,"c.csv");
								         data_base.clear();
						                         data_base.addAll(processingData.list("c.csv","filtering",f1,str1,op1,f2,str2,op2, andOr,notYes));
								         JOptionPane.showMessageDialog(null,"the data was filtered");
									 atTime.setEnabled(false);
									 atPlace.setEnabled(false);
									 atDevice.setEnabled(false);
								         notAtTime.setEnabled(false);
								         notAtPlace.setEnabled(false);
								         notAtDevice.setEnabled(false);
									 s[0]="2";
									 save_filter.setEnabled(true);
				                                        
								         }
								     else{  
									 JOptionPane.showMessageDialog(null,"please enter valid format");
									 at2.setSelected(false);
									 date_1.setText(""); date_2.setText("");hour_1.setText(""); hour_2.setText("");
									 textDevice.setText("");
									 filter1.setSelectedItem("");  filter2.setSelectedItem("");not_yes.setSelectedItem("");not_yes_filter1.setSelectedItem("");not_yes_filter2.setSelectedItem("");and_or.setSelectedItem("");
										 
					                                 }
							            }
							      catch(Exception el){
							            JOptionPane.showMessageDialog(null,"please enter valid format");
							            at2.setSelected(false);
							            date_1.setText(""); date_2.setText("");hour_1.setText(""); hour_2.setText("");
								    textDevice.setText("");	
								    filter1.setSelectedItem("");  filter2.setSelectedItem("");not_yes.setSelectedItem("");not_yes_filter1.setSelectedItem("");not_yes_filter2.setSelectedItem("");and_or.setSelectedItem("");
							            }
						              } 
			
			                               }
		                          }		
		               });	    
						

		
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
			     LinkedList <Wifi> data1=new LinkedList <Wifi> ();
			     data1.addAll(data_base);
			     combiningData.listToCsv(data1,"c.csv");
			     try{
			         JOptionPane.showMessageDialog(null, algorithms.findPlaceAlgorithm2("c.csv",(String)noGPS.getText(),4,10000,0.4,2));
			         }
			     catch(ArrayIndexOutOfBoundsException el){JOptionPane.showMessageDialog(null,"Please enter valid format");}
			     catch(Exception el){JOptionPane.showMessageDialog(null,"Please enter valid format");}
			     finally{
		                    noGPS.setText("");
		                    chckbxNewCheckBox_1.setSelected(false);				 }
		              } 	 
		        });
		
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
					 data1.setText("");data2.setText("");data3.setText("");
				         }
			         }
	                   }
		     });
		save_filter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 String getFilter="";
                                 if (atPlace.isSelected()) getFilter+=(String)lat_1.getText()+"<Lat<"+(String)lat_2.getText()+" && "+(String)lon_1.getText()+"<Lon<"+lon_2.getText()+" && "+alt_1.getText()+"<Alt<"+alt_2.getText();
                                 if (notAtPlace.isSelected()) getFilter+="!("+(String)lat_1.getText()+"<Lat<"+(String)lat_2.getText()+" && "+(String)lon_1.getText()+"<Lon<"+lon_2.getText()+" && "+alt_1.getText()+"<Alt<"+alt_2.getText()+")";
                                 if (atTime.isSelected()) getFilter+=(String)date_1.getText()+" "+(String)hour_1.getText()+"<Time<"+(String)date_2.getText()+" "+(String)hour_2.getText();
                                 if (notAtTime.isSelected()) getFilter+="!("+(String)date_1.getText()+" "+(String)hour_1.getText()+"<Time<"+(String)date_2.getText()+" "+(String)hour_2.getText()+")";
                                 if (atDevice.isSelected()) getFilter+="Device="+(String)textDevice.getText();
                                 if (notAtDevice.isSelected()) getFilter+="Device!="+(String)textDevice.getText();
                                 if (at2.isSelected()){
                                     if (not_yes.getSelectedItem().equals("not")) getFilter+="!(";
                                     if (not_yes_filter1.getSelectedItem().equals("not")) getFilter+=" !";
                                     if (filter1.getSelectedItem().equals("Place")) getFilter+="("+(String)lat_1.getText()+"<Lat<"+(String)lat_2.getText()+" && "+(String)lon_1.getText()+"<Lon<"+lon_2.getText()+" && "+alt_1.getText()+"<Alt<"+alt_2.getText()+")";
                                     if (filter1.getSelectedItem().equals("Time")) getFilter+="("+(String)date_1.getText()+" "+(String)hour_1.getText()+"<Time<"+(String)date_2.getText()+" "+(String)hour_2.getText()+")";
                                     if (filter1.getSelectedItem().equals("Device")) getFilter+="(Device="+(String)textDevice.getText()+")";
                                    
                                     if (and_or.getSelectedItem().equals("and")) getFilter+=" && "; else getFilter+=" || ";
                                     if (not_yes_filter2.getSelectedItem().equals("not")) getFilter+=" !";
                                     if (filter2.getSelectedItem().equals("Place")) getFilter+="("+(String)lat_1.getText()+"<Lat<"+(String)lat_2.getText()+" && "+(String)lon_1.getText()+"<Lon<"+lon_2.getText()+" && "+alt_1.getText()+"<Alt<"+alt_2.getText()+")";
                                     if (filter2.getSelectedItem().equals("Time")) getFilter+="("+(String)date_1.getText()+" "+(String)hour_1.getText()+"<Time<"+(String)date_2.getText()+" "+(String)hour_2.getText()+")";
                                     if (filter2.getSelectedItem().equals("Device")) getFilter+="(Device="+(String)textDevice.getText()+")";
                                    
                                     if (not_yes.getSelectedItem().equals("not")) getFilter+=" )";
	                             }
                
                                 String filename = (String)path1.getText()+"\\filter.ser";
                                 FileOutputStream fos = null;
                                 ObjectOutputStream out = null;
				
                                    try {
                                        fos = new FileOutputStream(filename);
                                        out = new ObjectOutputStream(fos);
                                        out.writeObject(getFilter);

                                        out.close();
                                        JOptionPane.showMessageDialog(null,"file has been created");
       
				        upload_filter.setEnabled(true);
                                  } catch (Exception ex) {
                                         ex.printStackTrace();
                    
                                         }
                                  finally{   save_filter.setSelected(false);
			          }
			}
			
		});
		
		
		upload_filter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FileInputStream fis = null;
		                ObjectInputStream in = null;
				
		                try {
		                    fis = new FileInputStream("filter.ser");
		                    in = new ObjectInputStream(fis);
		                    String filt= (String) in.readObject();
		                    in.close();
		                    JOptionPane.showMessageDialog(null,filt);
		                    } 
				catch (Exception ex) {
		                     ex.printStackTrace();
				     }
		                finally{upload_filter.setSelected(false);
				      }
			       }
			
		});
		
		
	}
}
