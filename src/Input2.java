import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


public class Input2 extends JPanel
{
	GraphicsPanel Panel;
	sideBar slidVal, DirectionDisplay, saveState, penStatus;
	
	static JTextField Text;
	static int turn = 0;
	static boolean saveVal;
	static int buttonpress = 0;
	static Color aColor = Color.BLACK;
	static boolean penState = false;
	
	static String[] direction =  {"East","North","West","South"};
	
	String input;
	static String userInput;
	String userInput2 ;
	String userInput3 ;
	String userInput4;
	boolean movement;
	private JButton draw;

	
	Input2(GraphicsPanel Panel)
	{
		this.Panel = Panel;
		
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		add(panel);
		
		Text = new JTextField(30);
		panel.add(Text);
		Text.addActionListener(new DrawListener());
		
		draw = new JButton("Draw");
		panel.add(draw);
		draw.addActionListener(new DrawListener());
		
		sideBar.forward.addActionListener(new ButtonForward());	
		
		sideBar.backward.addActionListener(new ButtonBackward());
		
		sideBar.left.addActionListener(new ButtonLeft());
		
		sideBar.right.addActionListener(new ButtonRight());
		
	}	
	
	private class ButtonForward implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {			//impliments action listener for when forward button is clicked.
			buttonpress = 1;
			
			if(penState == true){
				penupForwards();
			}
			
			else goingForwards();
			
			return;
			
		}
		
	}
	
	private class ButtonBackward implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {			//impliments action listener for when backward button is clicked.
			buttonpress = 1;
			
			if(penState == true){
				penupBackwards();
			}
			
			else goingBackwards();
		
			return;
		}
		
	}
	
	private class ButtonLeft implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {			//impliments action listener for when left button is clicked.
			buttonpress = 1;
			
			turnLeft();
		
			return;
		}
		
	}
	
	private class ButtonRight implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {			//impliments action listener for when right button is clicked.
			buttonpress = 1;
			
			turnRight();
		
			return;
		}
		
	}
	


private class DrawListener implements ActionListener {

		public void actionPerformed(ActionEvent event)
	      {
			try{
	
			Object source = event.getSource();
 
			
			input = Text.getText();
			
			if(buttonpress == 1){
				buttonpress =0;
				
				return;
			}
			
				input = input.trim();
				userInput = input.replaceAll("[A-Za-z ]", "");
				userInput2 = input.replaceAll("[ ]", "");
				userInput3 = input.replaceAll("[0-9 ]", "");
				userInput4 = input.replaceAll("[0-9]", "");
				
				Text.setText("");
				

				if(input.isEmpty()){
					if (buttonpress != 1){
					System.out.println(input);
					System.out.println("Please enter a command.");
					return;
					}
				}
				
				if (Character.isDigit(input.charAt(0)) ){
					System.out.println("You cannot start a command with a number.");
					return;
				}

				if (input.contentEquals("penup")){
					System.out.println("Pen is up");
					sideBar.penStatus.setText("Pen Status: Up");
					penState = true;
				}
				
				if (userInput2.equalsIgnoreCase("penup") || userInput2.startsWith("penup")){
					
						if(!"penup".equals(input)){
							System.out.println("This command is Incorrect, use 'penup' to lift the pen from the canvas.");
						}
				}
				
				if (input.contentEquals("pendown")){
					System.out.println("Pen is down");
					sideBar.penStatus.setText("Pen Status: Down");
					penState = false;
				}
				
				if (userInput2.equalsIgnoreCase("pendown") || userInput2.startsWith("pendown")){
					
					if(!"pendown".equals(input)){
						System.out.println("This command is Incorrect, use 'pendown' to set the pen on the canvas.");
					}
			}
				
				if (input.equals("reset")){
					if (saveVal == false){
						int option = JOptionPane.showConfirmDialog(null, "Would you like to save the changes to your Canvas?", null, JOptionPane.YES_NO_CANCEL_OPTION, 0, null);
						if( option == JOptionPane.YES_OPTION){
		                	
							JFileChooser chooser = new JFileChooser();
							int saveValue = chooser.showSaveDialog(null);
			                    if (saveValue == JFileChooser.APPROVE_OPTION) {
			                        try {
			                            ImageIO.write(Panel.image(), "png", new File(chooser.getSelectedFile().getAbsolutePath() + chooser.getSelectedFile().getName()));
			                        } catch (IOException e1) {
			                            e1.printStackTrace();
			                        }
		                    
		                    
			                 JOptionPane.showMessageDialog(null, "You have saved your session");
		            }
			                    
			                  if(saveValue == JFileChooser.CANCEL_OPTION){
			                	  return;
			                	}  
		                	
			                  saveVal = true;
							
							//yes option end
		                }

			                else if(option == JOptionPane.CANCEL_OPTION){return;}
						
			                else if (option == JOptionPane.NO_OPTION){
			                	Panel.clear();
								
								GraphicsPanel.xo = 500;
								GraphicsPanel.yo = 281;
								
								turn = 0; 
								
			                	//no option end.
			                }
					}
					if(saveVal == true){
					Panel.clear();
					
					GraphicsPanel.xo = 500;
					GraphicsPanel.yo = 281;
					
					turn = 0; 
					
					System.out.println("The Canvas has been cleared.");
					saveVal = true;
					}
			}

				if (userInput2.equalsIgnoreCase("reset") || userInput2.startsWith("reset")){
					
					if(!"reset".equals(input)){
						System.out.println("This command is Incorrect, use 'reset' to clear the canvas.");
					}
			}
					
//==============================================================================================================\\					
				
				if (input.equals("turnleft")){

					turnLeft();
				}
				
				if (userInput2.equalsIgnoreCase("turnleft") || userInput2.startsWith("turnleft")){
					
					if(!"turnleft".equals(input)){
						System.out.println("This command is Incorrect, use 'turnleft' to turn 90 degrees left.");
					}
			}
				
				
				if (input.equals("turnright")){
					
					turnRight();
				}

				if (userInput2.equalsIgnoreCase("turnright") || userInput2.startsWith("turnright")){
					
					if(!"turnright".equals(input)){
						System.out.println("This command is Incorrect, use 'turnright' to turn 90 degrees right.");
					}
			}
				
//==============================================================================================================\\
				
				if (input.equals("color")){
					
					 aColor = JColorChooser.showDialog(null, "Choose a Color", aColor);
				}
				
				if (input.equals("yellow")){
				
					aColor = Color.YELLOW;
					
					 System.out.println("You have selected: Yellow");
				}
				
				if (input.equals("red")){
					
					aColor = Color.RED;
					
					System.out.println("You have selected: Red");
				}
				
				if (input.equals("green")){
					
					aColor = Color.GREEN;
					
					System.out.println("You have selected: Green");
				}
				
				if (input.equals("black")){
					
					aColor = Color.BLACK;
					
					System.out.println("You have selected: Black");
				}
				
				if (input.equals("blue")){
					
					aColor = Color.BLUE;
					
					System.out.println("You have selected: Blue");
				}
				
					if (userInput2.equalsIgnoreCase("yellow") || userInput2.startsWith("yellow") || userInput2.equalsIgnoreCase("red") || userInput2.startsWith("red")
						|| userInput2.equalsIgnoreCase("green") || userInput2.startsWith("green") || userInput2.equalsIgnoreCase("black") || userInput2.startsWith("black")
						|| userInput2.equalsIgnoreCase("blue") || userInput2.startsWith("blue")){
					
					if(!"yellow".equals(input) && !"red".equals(input) && !"green".equals(input) && !"black".equals(input) && !"blue".equals(input)){
						System.out.println("This command is Incorrect, use '*colour*'(lowercase) to change colour.");
					}
			}		
				
//==============================================================================================================\\
//==============================================================================================================\\
				
					
					if(penState == false){ //pendown
						
						if ("backward".equalsIgnoreCase(userInput4) || !"backward".startsWith(userInput4) && "backward".equals(userInput3) || "backward ".equalsIgnoreCase(userInput4) || userInput3.equalsIgnoreCase("backward")){
							
							if(input.contains("-")){
								System.out.println("You cannot enter a negative number.");
								return;
							}
							
							 if(!"backward ".equals(userInput4)){
								
								if("backward ".equals(userInput4)){}
								
								else if(!"backward ".equals(userInput4)){
							
								System.out.println("This command is Incorrect, use 'backward' to move pen Backward.");
								return;
							}
						}
					}
												
								
						if (userInput3.equals("backward")){
						    goingBackwards();
						}
		
					
					if ("forward".equalsIgnoreCase(userInput4) || !"forward".startsWith(userInput4) && "forward".equals(userInput3) || "forward ".equalsIgnoreCase(userInput4) || userInput3.equalsIgnoreCase("forward")){
								
								if(input.contains("-")){
									System.out.println("You cannot enter a negative number.");
									return;
								}
								
								 if(!"forward ".equals(userInput4)){
									
									if("forward ".equals(userInput4)){}
									
									else if(!"forward ".equals(userInput4)){
								
									System.out.println("This command is Incorrect, use 'forward' to move pen forwards.");
									return;
								}
							}
						}
								

						if (userInput3.equals("forward")){
						    goingForwards();
						}	
						
				}
					
					if (penState == true ){ // penup
						
						if ("backward".equalsIgnoreCase(userInput4) || !"backward".startsWith(userInput4) && "backward".equals(userInput3) || "backward ".equalsIgnoreCase(userInput4) || userInput3.equalsIgnoreCase("backward")){
							
							if(input.contains("-")){
								System.out.println("You cannot enter a negative number.");
								return;
							}
							
							 if(!"backward ".equals(userInput4)){
								
								if("backward ".equals(userInput4)){}
								
								else if(!"backward ".equals(userInput4)){
							
								System.out.println("This command is Incorrect, use 'backward' to move pen Backward.");
								return;
							}
						}
					}
							
						
						if (userInput3.equals("backward")){
							penupBackwards();
						}
							
						

						if ("forward".equalsIgnoreCase(userInput4) || !"forward".startsWith(userInput4) && "forward".equals(userInput3) || "forward ".equalsIgnoreCase(userInput4) || userInput3.equalsIgnoreCase("forward")){
							
							if(input.contains("-")){
								System.out.println("You cannot enter a negative number.");
								return;
							}
							
							 if(!"forward ".equals(userInput4)){
								
								if("forward ".equals(userInput4)){}
								
								else if(!"forward ".equals(userInput4)){
							
								System.out.println("This command is Incorrect, use 'forward' to move pen forwards.");
								return;
							}
						}
					}	
													
						if (userInput3.equals("forward")){
							penupForwards();
						}		
						
				}
					if(movement == true){
						saveVal = false;
					}
						
		}catch(Exception e){
	        System.out.println("Error. There should be a number after forward/backward. e.g. 'forward 25'");
	    }

	  }

		
	}


public void turnLeft(){
				turn ++;
				turn = Math.abs(turn % 4);
				
				System.out.println("facing: " + direction[turn]);
				sideBar.DirectionDisplay.setText("Direction: " + direction[turn]);
			}

public void turnRight(){
				if (turn == 0){
					turn = 3;
				}
					
				else
				turn --;
				turn = Math.abs(turn % 4);
				
				System.out.println("facing: " + direction[turn]);
				sideBar.DirectionDisplay.setText("Direction: " + direction[turn]);
			}


public void goingBackwards() {
				System.out.println("Backward " + userInput);
				
				movement = true;
				
				if(movement == true){
					saveVal = false;
				}
				
				if (saveVal == true){
						movement = false;
				}
				
				if(userInput.isEmpty()){
					userInput = Integer.toString(sideBar.slidVal);
				}
				
				int i = Integer.parseInt(userInput);
				int distance = i;		
				switch(turn)
				{
				case 0:	
						Panel.drawLine(aColor, GraphicsPanel.xo, GraphicsPanel.yo, GraphicsPanel.xo - distance, GraphicsPanel.yo);
						GraphicsPanel.xo = GraphicsPanel.xo - distance;
						Panel.repaint();
						
						break;
						
				case 1: 
						Panel.drawLine(aColor, GraphicsPanel.xo, GraphicsPanel.yo, GraphicsPanel.xo , GraphicsPanel.yo + distance);
						GraphicsPanel.yo = GraphicsPanel.yo + distance;
						Panel.repaint();
						
						break;
						
				case 2: 
						Panel.drawLine(aColor, GraphicsPanel.xo, GraphicsPanel.yo, GraphicsPanel.xo + distance, GraphicsPanel.yo);
						GraphicsPanel.xo = GraphicsPanel.xo + distance;
						Panel.repaint();
						
						break;
		
				case 3: 
						Panel.drawLine(aColor, GraphicsPanel.xo, GraphicsPanel.yo, GraphicsPanel.xo, GraphicsPanel.yo - distance);
						GraphicsPanel.yo = GraphicsPanel.yo - distance;
						Panel.repaint();	
						
						break;
				}
				
		sideBar.saveState.setText("Save Status: " + saveVal);
		return;
		
		}
public void goingForwards() {
					System.out.println("Forward " + userInput);
					
					movement = true; 
					
					if(movement == true){
						saveVal = false;
					}
					
					if (saveVal == true){
						movement = false;
					}
					
					if(userInput.isEmpty()){
						userInput = Integer.toString(sideBar.slidVal);
					}
					
					int i = Integer.parseInt(userInput);
					int distance = i;
					switch(turn)
					{
					case 0:	
							Panel.drawLine(aColor, GraphicsPanel.xo, GraphicsPanel.yo, GraphicsPanel.xo + distance, GraphicsPanel.yo);
							GraphicsPanel.xo = GraphicsPanel.xo + distance;
							break;
					
					case 1: 
							Panel.drawLine(aColor, GraphicsPanel.xo, GraphicsPanel.yo, GraphicsPanel.xo , GraphicsPanel.yo - distance);
							GraphicsPanel.yo = GraphicsPanel.yo - distance;
							Panel.repaint();
							
							break;
							
					case 2: 
							Panel.drawLine(aColor, GraphicsPanel.xo, GraphicsPanel.yo, GraphicsPanel.xo - distance, GraphicsPanel.yo);
							GraphicsPanel.xo = GraphicsPanel.xo - distance;
							Panel.repaint();
							
							break;
			
					case 3: 
							Panel.drawLine(aColor, GraphicsPanel.xo, GraphicsPanel.yo, GraphicsPanel.xo, GraphicsPanel.yo + distance);
							GraphicsPanel.yo = GraphicsPanel.yo + distance;
							Panel.repaint();	
							
							break;
				}
			
			sideBar.saveState.setText("Save Status: " + saveVal);
			return;
			
			}

public void penupBackwards(){
					System.out.println("Backward " + userInput);
					
					movement = true;
					
					if(movement == true){
						saveVal = false;
					}
					
					if (saveVal == true){
						movement = false;
					}
					
					if(userInput.isEmpty()){
						userInput = Integer.toString(sideBar.slidVal);
					}
					
					int i = Integer.parseInt(userInput);
					int distance = i;
					switch(turn)
					{
					case 0:	
							Panel.dontDrawLine(GraphicsPanel.xo, GraphicsPanel.yo, GraphicsPanel.xo - distance, GraphicsPanel.yo);
							GraphicsPanel.xo = GraphicsPanel.xo - distance;
							Panel.repaint();
							
							break;
				
					case 1: 
							Panel.dontDrawLine(GraphicsPanel.xo, GraphicsPanel.yo, GraphicsPanel.xo , GraphicsPanel.yo + distance);
							GraphicsPanel.yo = GraphicsPanel.yo + distance;
							Panel.repaint();
							
							break;
							
					case 2: 
							Panel.dontDrawLine(GraphicsPanel.xo, GraphicsPanel.yo, GraphicsPanel.xo - distance, GraphicsPanel.yo);
							GraphicsPanel.xo = GraphicsPanel.xo + distance;
							Panel.repaint();
							
							break;
				
					case 3: 
							Panel.dontDrawLine(GraphicsPanel.xo, GraphicsPanel.yo, GraphicsPanel.xo, GraphicsPanel.yo - distance);
							GraphicsPanel.yo = GraphicsPanel.yo - distance;
							Panel.repaint();	
							
							break;
					}
				sideBar.saveState.setText("Save Status: " + saveVal);
				return;
		}

public void penupForwards(){
					System.out.println("Forward " + userInput);
					
					
					movement = true;
					
					if(movement == true){
						saveVal = false;
					}
					
					if (saveVal == true){
						movement = false;
					}
					
					if(userInput.isEmpty()){
						userInput = Integer.toString(sideBar.slidVal);
					}
					
					int i = Integer.parseInt(userInput);
					int distance = i;
					switch(turn)
					{
					case 0:
							Panel.dontDrawLine(GraphicsPanel.xo, GraphicsPanel.yo, GraphicsPanel.xo + distance, GraphicsPanel.yo);									
							GraphicsPanel.xo = GraphicsPanel.xo + distance;
							break;
					
					case 1: 
							Panel.dontDrawLine(GraphicsPanel.xo, GraphicsPanel.yo, GraphicsPanel.xo , GraphicsPanel.yo - distance);
							GraphicsPanel.yo = GraphicsPanel.yo - distance;
							Panel.repaint();
							
							break;
							
					case 2: 
							Panel.dontDrawLine(GraphicsPanel.xo, GraphicsPanel.yo, GraphicsPanel.xo - distance, GraphicsPanel.yo);
							GraphicsPanel.xo = GraphicsPanel.xo - distance;
							Panel.repaint();
							
							break;
					
					case 3: 
							Panel.dontDrawLine(GraphicsPanel.xo, GraphicsPanel.yo, GraphicsPanel.xo, GraphicsPanel.yo + distance);
							GraphicsPanel.yo = GraphicsPanel.yo + distance;
							Panel.repaint();	
							
							break;
						
					}
			sideBar.saveState.setText("Save Status: " + saveVal);
			return;
		}
}