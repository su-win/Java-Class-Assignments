//Written by: Su Win

package PartIV;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;


public class RollDice extends JFrame {
	
    private static final long serialVersionUID = 1L;
	private JPanel mainPanel, dicesPanel, centerPanel, dotPanel,  buttonPanel, resultPanel, bottomPanel;
	private ImagePanel img1Panel, img2Panel;
    private JLabel resultLabel, dot;
    private int dice1, dice2, result=0, totalResult = 0;
    int gridX = 5, gridY = 5; //grid size;
    boolean reachLastCell = false;
    
    ArrayList<JLabel> dots = new ArrayList<JLabel>();
    
    public RollDice() {
    	this.setTitle("Roll The Dice");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.LIGHT_GRAY);
		this.setupPanels();
		this.pack();
		this.setLocationRelativeTo(null);
		this.setSize(500,500);
		this.setResizable(false);
		this.setVisible(true);
	}
    	
    
    public void setupPanels() {
    	mainPanel = new JPanel(new BorderLayout());
    	
		//add dices Panel to the main panel
		mainPanel.add(createTopPanel(), BorderLayout.NORTH);
		
		//add center panel to the mainPanel
		mainPanel.add(createCenterPanel(), BorderLayout.CENTER);
		
		//add bottom/south panel to the mainPanel
		mainPanel.add(createBottomPanel(), BorderLayout.SOUTH);
		this.add(mainPanel);
    }

    public JPanel createTopPanel() {
    	dicesPanel = new JPanel(new GridLayout(1,2));
    	return dicesPanel;
    }
    
  //Center Panel for grid and dot
  	public JPanel createCenterPanel(){
  		
  		centerPanel = new JPanel();
      	centerPanel.setLayout(new OverlayLayout(centerPanel));

  		dotPanel = new JPanel(new GridLayout(gridX,gridY));
  		dotPanel.setOpaque(true);
  		for (int i = 0; i < 25; i++) {
  			dot = new JLabel();
  			dot.setHorizontalAlignment(JLabel.CENTER);
  			dot.setVerticalAlignment(JLabel.CENTER);
  			dot.setBorder(BorderFactory.createLineBorder(Color.blue));
  			dots.add(dot);
			dotPanel.add(dot);
  		}
  		centerPanel.add(dotPanel);
  		return centerPanel;
  	}
  
  	//Bottom Panel for result label and button
  	public JPanel createBottomPanel(){                           
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
    	
    	resultPanel = new JPanel();
    	resultLabel = new JLabel();
    	resultPanel.add(resultLabel);
    	bottomPanel.add(resultPanel);
    	
    	this.updateDice();
    	
    	buttonPanel = new JPanel();
		JButton rollButton = new JButton("Roll Dice");
		rollButton.addActionListener((e) -> {
			this.dice1 = (int)(Math.random()*6)+1; //generate random number for dice
			this.dice2 = (int)(Math.random()*6)+1;
			this.updateDice();
		});
		
		buttonPanel.add(rollButton);
		bottomPanel.add(buttonPanel);
		return bottomPanel;
	}
    
    public void updateDice() {
    	if (reachLastCell == false) {
    		//get result from rolling dice
	    	result = dice1 + dice2;
	    	resultLabel.setText("Result: " + this.result);
	    	if(result == 0) {
	    		dicesPanel.add(new ImagePanel("die1.png"));
		    	dicesPanel.add(new ImagePanel("die1.png"));
		    	dots.get(0).setText("⚫");
	    	}else {
		    	dicesPanel.removeAll();
		    	img1Panel = diceImage(dice1, 1);
		    	img2Panel = diceImage(dice2, 2);
		    	dicesPanel.add(img1Panel);
		    	dicesPanel.add(img2Panel);
		    	
		    	//add the result each time rolling dices to define the position of the dot on the grid
		    	int dotPosition = totalResult + result;
		    	
	/*The instruction said, "After you have rolled the dice enough that the dot arrives at the lower-right cell of the grid, 
	 *print “Finished!” in the panel that displays the grid. "
	 *So, we assumed that user can keep rolling the rice until it reached the lower right cell of the grid.
	 *We also assumed the game also finished when the dot arrive at the cell 24 because rolling two dices cannot get the result of 1.
	 */
		    	if(dotPosition > 24) { //if result is greater than 24, keep the dot position at the current cell and keep rolling the dice
		    		dotPosition = totalResult;
		    		reachLastCell = false;
		    	}else if(dotPosition <= 22) { //if result is <=22 , user can able to keep rolling the dice
		    		
		    		dots.get(totalResult).setText(""); //remove the previous dot on grid
		    		
		    		//keep adding the dice result to move dots on the grid
		    		totalResult = totalResult + result;
		    		
		    		//use cumulative dice result to set the location of the dot
		    		int index = totalResult; 
		    		dots.get(index).setText("⚫");
		    		
		    	}else if( dotPosition == 23 || dotPosition == 24) {
		    		dots.get(totalResult).setText(""); //remove the previous dot on grid
		    		dots.get(dotPosition).setText("⚫");
		    		
	/*In the instruction, "print “Finished!” in the panel that displays the grid."
	 *So, we remove everything from center panel and show the "Finished!"
	 */
		    		centerPanel.removeAll();
		    		JLabel finishedLabel = new JLabel("Finished!");
		    		finishedLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		    		finishedLabel.setVerticalAlignment(JLabel.CENTER);
		    		finishedLabel.setHorizontalAlignment(JLabel.CENTER);
		    		finishedLabel.setOpaque(true);
		    		centerPanel.add(finishedLabel,BorderLayout.CENTER);
		    		reachLastCell = true;
		    	}
	    	}
    	}else {
    		return;
    	}
    	
    }
    public ImagePanel diceImage(int file, int dIndex) {
    	ImagePanel img = new ImagePanel("die" + file + ".png");
    	return img;
    }

	class DiceListener extends MouseAdapter{
		private int index;
		
		public DiceListener() {
			super();
		}
		
		public DiceListener(int dice) {
			super();
			index = dice;
		}
		
		@Override
		public void mouseClicked(MouseEvent event) {
			RollDice.this.updateDice();
		}
	}
	
    public static void main(String[] args) {
    	RollDice rollDice = new RollDice();
    
    }
}