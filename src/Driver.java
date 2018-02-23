import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

public class Driver {

	
	
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Draw");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JScrollPane scroll = null;
	      
	    	GraphicsPanel Panel = new GraphicsPanel();
	    	sideBar sideBar = new sideBar(Panel);
			scroll = new JScrollPane(Panel);
	        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    
	    	
	    	addMenu Panel2 = new addMenu(Panel);
	    	Input2 Panel3 = new Input2(Panel);
	    	
	    	TitledBorder border = new TitledBorder("Input");
	    	border.setTitleColor(Color.BLUE);
	    	Panel3.setBorder(border);
	    	
	    	frame.setLayout(new BorderLayout());
	      
	      
	    	frame.getContentPane().add(sideBar, BorderLayout.EAST);
	    	frame.setJMenuBar(Panel2.createMenuBar());
	    	frame.getContentPane().add(scroll, BorderLayout.CENTER);
	    	frame.getContentPane().add(Panel3, BorderLayout.PAGE_END);
	
		    
		    frame.pack();
		    frame.setVisible(true);
		}

}

