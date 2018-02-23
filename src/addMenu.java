	import java.awt.*;
	import java.awt.event.*;
	import java.awt.image.BufferedImage;
	import java.awt.image.RenderedImage;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.net.URL;
	
	import javax.swing.JMenu;
	import javax.swing.JMenuItem;
	import javax.swing.JOptionPane;
	import javax.swing.JCheckBoxMenuItem;
	import javax.swing.JFileChooser;
	import javax.swing.JRadioButtonMenuItem;
	import javax.imageio.ImageIO;
	import javax.swing.ButtonGroup;
	import javax.swing.JMenuBar;
	import javax.swing.KeyStroke;
	import javax.swing.ImageIcon;

	import javax.swing.JPanel;
	import javax.swing.JTextArea;
	import javax.swing.JScrollPane;
	import javax.swing.JFrame;
	import java.io.File;

	public class addMenu {
	
		GraphicsPanel Panel, image;
		Input2 saveVal, turn;
		sideBar saveState;
		
		public addMenu(GraphicsPanel Panel)
		{
			this.Panel = Panel;					// adds to current panel rather than creating a new one.
		}
		
		
	    public JMenuBar createMenuBar() {
	        JMenuBar menuBar;
	        JMenu File, Help;
	        JMenuItem New, Save, Load, Exit, About;

	        menuBar = new JMenuBar();

	        //Build the first menu.
	        File = new JMenu("File");
	        File.setMnemonic(KeyEvent.VK_F);
	        menuBar.add(File);
	        
//=========================================================\\
//		All new JMenuItems are a submenu within JMenu	   \\
//=========================================================\\
	        New = new JMenuItem("New");
	        New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, ActionEvent.ALT_MASK));	//adds listener to key f1 when ALT key is held down.
	        File.add(New);
	        New.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	if (Input2.saveVal == false){
						int option = JOptionPane.showConfirmDialog(null, "Would you like to save the changes to your Canvas?", null, JOptionPane.YES_NO_CANCEL_OPTION, 0, null);
						if( option == JOptionPane.YES_OPTION){
		                	
							JFileChooser chooser = new JFileChooser();
							int Value = chooser.showSaveDialog(null);
			                    if (Value == JFileChooser.APPROVE_OPTION) {
			                        try {
			                        	ImageIO.write(Panel.image(),"png", new File(chooser.getSelectedFile().getAbsolutePath() + ".png"));
			                        } catch (IOException e1) {
			                            e1.printStackTrace();
			                        }
		                    
		                    
			                 JOptionPane.showMessageDialog(null, "You have saved your session");
		            }
			                    
			                  if(Value == JFileChooser.CANCEL_OPTION){
			                	  return;
			                	}  
		                	
			                  Input2.saveVal = true;
			                  sideBar.saveState.setText("Save status: " + Input2.saveVal);
							
							//yes option end
		                }

			                else if(option == JOptionPane.CANCEL_OPTION){return;}
						
			                else if (option == JOptionPane.NO_OPTION){
			                	Panel.clear();
								
								GraphicsPanel.xo = 500;
								GraphicsPanel.yo = 281;
								
								Input2.turn = 0; 
								
			                	//no option end.
			                }
					}
					if(Input2.saveVal == true){
					Panel.clear();
					
					GraphicsPanel.xo = 500;
					GraphicsPanel.yo = 281;
					
					Input2.turn = 0; 
					
					Input2.saveVal = true;
					sideBar.saveState.setText("Save status: " + Input2.saveVal);
					}
	            	
	            	
	            	Panel.clear();
	            	Input2.turn = 0;
	            	
	                JOptionPane.showMessageDialog(null, "You have Created a New canvas");
	            }
	        });
	        

	        Save = new JMenuItem("Save");
	        Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, ActionEvent.ALT_MASK));
	        File.add(Save);
	        Save.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	JFileChooser chooser = new JFileChooser();
	            	
	            	int Value = chooser.showSaveDialog(null);
	                    if (Value == JFileChooser.APPROVE_OPTION) {
	                        try {
	                            ImageIO.write(Panel.image(),"png", new File(chooser.getSelectedFile().getAbsolutePath() + ".png"));
	                        } catch (IOException e1) {
	                            e1.printStackTrace();
	                        }
	                    
	                    Input2.saveVal = true;
	                    sideBar.saveState.setText("Save status: " + Input2.saveVal);
	                JOptionPane.showMessageDialog(null, "You have saved your session");
	            }
	        }});
	        

	        Load = new JMenuItem("Load");
	        Load.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, ActionEvent.ALT_MASK));
	        File.add(Load);
	        Load.addActionListener(new ActionListener() {
	        	 public void actionPerformed(ActionEvent e) {
		                	
		                	if (Input2.saveVal == false){
							int option = JOptionPane.showConfirmDialog(null, "Would you like to save the changes to your Canvas?", null, JOptionPane.YES_NO_CANCEL_OPTION, 0, null);
							if( option == JOptionPane.YES_OPTION){
			                	
								JFileChooser chooser = new JFileChooser();
								int Value = chooser.showSaveDialog(null);
				                    if (Value == JFileChooser.APPROVE_OPTION) {
				                        try {
				                        	ImageIO.write(Panel.image(),"png", new File(chooser.getSelectedFile().getAbsolutePath() + ".png"));
				                        } catch (IOException e1) {
				                            e1.printStackTrace();
				                        }
			                    
				                 JOptionPane.showMessageDialog(null, "You have saved your session");
				              }
				                    
				                  if(Value == JFileChooser.CANCEL_OPTION){
				                	  return;
				                	}  
			                	
				                Input2.saveVal = true;
				                sideBar.saveState.setText("Save status: " + Input2.saveVal);
								//yes option end
			                }

				                else if(option == JOptionPane.CANCEL_OPTION){return;}
							
				                else if (option == JOptionPane.NO_OPTION){}
						}	
	        		 
	        		 
		                	JFileChooser chooser = new JFileChooser();
							int Value = chooser.showOpenDialog(null);
			                    if (Value == JFileChooser.APPROVE_OPTION) {
			                        try {
			                        	GraphicsPanel.image = ImageIO.read(chooser.getSelectedFile());
			                            Panel.repaint();

			                            JOptionPane.showMessageDialog(null, "You have loaded an image");
			                        } catch (IOException e1) {
			                            JOptionPane.showMessageDialog(null, "File could not be found.");;
			                        }
		                  
		            }
			                    
			                  if(Value == JFileChooser.CANCEL_OPTION){
			                	  return;
			                	}  
		                	
			                Input2.saveVal = true;
			                sideBar.saveState.setText("Save status: " + Input2.saveVal);
							//yes option end
		                }
		                
	        	 });
	        
	        
	        Exit = new JMenuItem("Exit");
	        Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, ActionEvent.ALT_MASK));
	        Exit.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
	        File.add(Exit);
	        Exit.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	int option = JOptionPane.showOptionDialog(null, "Exit Program?", null, JOptionPane.YES_NO_OPTION, 0, null, null, e);
	                if( option == JOptionPane.YES_OPTION){
	                	
	                	if (Input2.saveVal == false){
						option = JOptionPane.showConfirmDialog(null, "Would you like to save the changes to your Canvas?", null, JOptionPane.YES_NO_CANCEL_OPTION, 0, null);
						if( option == JOptionPane.YES_OPTION){
		                	
							JFileChooser chooser = new JFileChooser();
							int Value = chooser.showSaveDialog(null);
			                    if (Value == JFileChooser.APPROVE_OPTION) {
			                        try {
			                            ImageIO.write(Panel.image(), "png", new File(chooser.getSelectedFile().getAbsolutePath() + chooser.getSelectedFile().getName()));
			                        } catch (IOException e1) {
			                            e1.printStackTrace();
			                        }
		                    
		                    
			                 JOptionPane.showMessageDialog(null, "You have saved your session");
		            }
			                    
			                  if(Value == JFileChooser.CANCEL_OPTION){
			                	  return;
			                	}  
		                	
			                  Input2.saveVal = true;
			                  sideBar.saveState.setText("Save status: " + Input2.saveVal);
							
							//yes option end
		                }

			                else if(option == JOptionPane.CANCEL_OPTION){return;}
						
			                else if (option == JOptionPane.NO_OPTION){
			                	Panel.clear();
								
								GraphicsPanel.xo = 500;
								GraphicsPanel.yo = 281;
								
								Input2.turn = 0; 
								
			                	//no option end.
			                }
					}	
	                	
	                	System.exit(0);	
	                }
		              
		                else{
		                	//no option
		                }
	       
	            }
	        });


//	        //Build second menu in the menu bar.
	        Help = new JMenu("Help");
	        Help.setMnemonic(KeyEvent.VK_H);
	        menuBar.add(Help);
	        
	        About = new JMenuItem("About");
	        
	        About.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, ActionEvent.ALT_MASK));
	        Help.add(About);
	        About.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent e) {
		                    
			                 JOptionPane.showMessageDialog(null, "Turtle Graphics:- "
			                 		+ "\nCreated by; Jack Chapman."
			                 		+ "\n(c)Copyright Turtle Graphics."
			                 		+ "\nAll rights reserved.");
		        }});

	        return menuBar;
	    }
	    
	}