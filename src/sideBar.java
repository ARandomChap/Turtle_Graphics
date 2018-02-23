import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class sideBar extends JPanel implements ChangeListener{
	
	GraphicsPanel Panel;
	Input2 aColor, Text, buttonpress, saveVal, userInput;
	
	JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
	JTextField sliderText = new JTextField(5);
	
	static JButton forward, backward, left, right, penup, pendown;
	static JLabel DirectionDisplay, saveState, penStatus;
	static int slidVal;

	
	sideBar(final GraphicsPanel Panel)
	{
		this.Panel = Panel;
		
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(new GridBagLayout());
		
		JPanel panel = new JPanel();
		add(panel);
		
		DirectionDisplay = new JLabel("Direction: East");
		c.gridx = 1;
		c.gridy = 12;
		c.insets = new Insets(20,0,0,0);
		add(DirectionDisplay, c);
		
		saveState = new JLabel("Save Status: false");
		c.gridx = 1;
		c.gridy = 13;
		c.insets = new Insets(0,0,0,0);
		add(saveState, c);
		
		penStatus = new JLabel("Pen Status: Down");
		c.gridx = 1;
		c.gridy = 14;
		c.insets = new Insets(0,0,0,0);
		add(penStatus, c);
		
		penup = new JButton("Pen Up");
		c.gridx = 1;
		c.gridy = 10;
		c.insets = new Insets(20,0,0,0);
		penup.setMargin(new Insets(0,23,0,22));
		add(penup, c);
		penup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	sideBar.penStatus.setText("Pen Status: Up");
            	
            	Input2.penState = true;
            	return;
            }
            
		});
		
		pendown = new JButton("Pen Down");
		c.gridx = 1;
		c.gridy = 11;
		c.insets = new Insets(0,0,0,0);
		add(pendown, c);
		pendown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	sideBar.penStatus.setText("Pen Status: Down");
            	Input2.penState = false;
            	return;
            }
            
		});
		
		JButton color = new JButton("Palette");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;      
		c.insets = new Insets(0,100,10,100);
		c.gridx = 1;
		c.gridwidth = 1;
		c.gridy = 0;
		add(color, c);
		
		color.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	Input2.aColor = JColorChooser.showDialog(sideBar.this, "Choose a Color", Input2.aColor);
            }
            
		});
		
		
		JButton black = new JButton("Black");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;      
		c.insets = new Insets(0,100,10,100);
		c.gridx = 1;
		c.gridwidth = 1;
		c.gridy = 1;
	    black.setBackground(Color.BLACK);
	    black.setForeground(Color.GRAY);
		add(black, c);
		
		black.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	Input2.aColor = Color.BLACK;
            }
            
		});
		
		JButton green = new JButton("Green");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;      
		c.insets = new Insets(0,100,10,100);
		c.gridx = 1;
		c.gridwidth = 1;
		c.gridy = 2;
		green.setBackground(Color.GREEN);
		add(green, c);
		
		green.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	Input2.aColor = Color.GREEN;
            }
            
		});
			
		JButton red = new JButton("Red");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;       
		c.insets = new Insets(0,100,30,100);  
		c.gridx = 1;       
		c.gridwidth = 1;   
		c.gridy = 3;       
		
		red.setBackground(Color.RED);
		add(red, c);
		
		red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	Input2.aColor = Color.RED;
            }
            
		});
		

		forward = new JButton("forward");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 10;       
		c.ipadx = -10;
		c.insets = new Insets(0,100,0,100);  
		c.gridx = 1;       
		c.gridwidth = 1;   
		c.gridy = 5;       
//		forward.setIcon(new ImageIcon("src\\arrowup2.png"));
		add(forward, c);
		
		forward.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	return;
            }
            
		});
		
		backward = new JButton("backward");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 10;       
		c.insets = new Insets(0,100,0,100);  
		c.gridx = 1;       
		c.gridwidth = 1;   
		c.gridy = 7;      
		add(backward, c);
		
		backward.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	return;
            }
            
		});
		right = new JButton("right");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 10;
		c.ipadx = 20;
		c.weightx = 1.0;
		c.anchor = GridBagConstraints.WEST; 
		c.insets = new Insets(0,150,0,70); 
		c.gridx = 1;  
		c.gridwidth = 1; 
		c.gridy = 6;
		add(right, c);
		
		right.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
            }
            
		});
		
		left = new JButton("left");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 10; 
		c.weightx = 1.0;
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(0,80,0,-150);
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = 6;
		add(left, c);
		
		left.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
            }
            
		});


	//Set labels at major tick marks.
	slider.setMajorTickSpacing(25);
	slider.setMinorTickSpacing(5);
	slider.setPaintTicks(true);
	slider.setPaintLabels(true);
	slider.addChangeListener(this);
	
	
	c.gridy = 8;
	c.gridx = 0;
	c.gridwidth = 2;
	c.insets = new Insets(0,40,0,30);
	add(slider, c);
	slider.setValue(50);
	
	
	c.gridy = 9;
	c.gridx = 0;
	c.insets = new Insets(0,40,0,30);
	add(sliderText, c);
	sliderText.setText("" + slider.getValue());
	
	slider.setValue(50);
	
	Input2.userInput = Integer.toString(slider.getValue());
	
	
}
	
	
public void stateChanged(ChangeEvent e) {

		slidVal = slider.getValue();
		
		sliderText.setText("" + slidVal);
		
		Input2.userInput = Integer.toString(slidVal);
	}
}
