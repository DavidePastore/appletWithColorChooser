package applet;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * This is the applet.
 * @author <a reef="https://github.com/DavidePastore">DavidePastore</a>
 *
 */
public class MyApplet extends JApplet implements ActionListener, MouseListener{
	
	private JPanel panel = new JPanel();
	private JLabel label;
	
	/**
	 * Here the applet is being initialized.
	 */
	public void init(){
		label = new JLabel("Zero Pingas", JLabel.CENTER);
		label.setFont(new Font("Arial", Font.PLAIN, 30));
		addMouseListener(this);
		
		//Create the radio buttons for the colors
		JRadioButton blackButton = new JRadioButton("Black");
		blackButton.setForeground(Color.BLACK);
        blackButton.setActionCommand("Black");
        blackButton.setSelected(true);
		
        JRadioButton blueButton = new JRadioButton("Blue");
        blueButton.setForeground(Color.BLUE);
        blueButton.setActionCommand("Blue");

        JRadioButton redButton = new JRadioButton("Red");
        redButton.setForeground(Color.RED);
        redButton.setActionCommand("Red");

        JRadioButton yellowButton = new JRadioButton("Yellow");
        yellowButton.setForeground(Color.YELLOW);
        yellowButton.setActionCommand("Yellow");

        JRadioButton pinkButton = new JRadioButton("Pink");
        pinkButton.setForeground(Color.PINK);
        pinkButton.setActionCommand("Pink");
        
        //Put the radio buttons in a column in a panel.
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(blackButton);
        radioPanel.add(blueButton);
        radioPanel.add(redButton);
        radioPanel.add(yellowButton);
        radioPanel.add(pinkButton);
        
        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(blackButton);
        group.add(blueButton);
        group.add(redButton);
        group.add(yellowButton);
        group.add(pinkButton);
 
        //Register a listener for the radio buttons.
        blackButton.addActionListener(this);
        blueButton.addActionListener(this);
        redButton.addActionListener(this);
        yellowButton.addActionListener(this);
        pinkButton.addActionListener(this);
		
		
		//Disponiamo gli elementi all'interno del pannello
		panel.setLayout(new BorderLayout());
		panel.add(label, BorderLayout.NORTH);
		//panel.add(radioPanel, BorderLayout.LINE_START);
		panel.add(new ColorPanel(), BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.CENTER);
	}

	/**
	 * Standard method called for the paint of the component.
	 */
	public void paint(Graphics g) {
		super.paintComponents(g);
	}

	/**
	 * Action performed when you click a button.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		switch(actionCommand){
		case "Black":
			label.setForeground(Color.BLACK);
			break;
		case "Blue":
			label.setForeground(Color.BLUE);
			break;
		case "Red":
			label.setForeground(Color.RED);
			break;
		case "Yellow":
			label.setForeground(Color.YELLOW);
			break;
		case "Pink":
			label.setForeground(Color.PINK);
			break;
		default:
			break;
		}
		
	}

	/**
	 * Action performed when you click the mouse in the ColorPanel.
	 */
	@Override
	public void mouseClicked(MouseEvent event) {
		Robot robot;
		Color color;
		try {
			robot = new Robot();
			color = robot.getPixelColor(event.getX(), event.getY());
			System.out.println("Colore scelto: "+color);
			label.setForeground(color);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method is not used but it is essential for the interface MouseListener.
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * This method is not used but it is essential for the interface MouseListener.
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * This method is not used but it is essential for the interface MouseListener.
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
