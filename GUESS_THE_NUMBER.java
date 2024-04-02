import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GUESS_THE_NUMBER implements ActionListener{
	int count=0;
	Random rand=new Random();
	int compnumber=rand.nextInt(100)+1;
	JFrame frame= new JFrame("GUESS_THE_NUMBER");
	JLabel uppertext=new JLabel("GUESS THE NUMBER");	
	JLabel message=new JLabel("MESSAGE BOX");
	JLabel guesstext=new JLabel("Guess a number between 1 and 100:");
	JTextField userguess=new JTextField();
	JButton resetbutton = new JButton("RESET");
    JButton guessbutton = new JButton("GUESS");
	
	GUESS_THE_NUMBER(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(530,75,600,200);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		uppertext.setBackground(Color.black);
		uppertext.setForeground(Color.white);
		uppertext.setFont(new Font("Verdana",Font.BOLD,30));
		uppertext.setHorizontalAlignment(JLabel.CENTER);
		uppertext.setOpaque(true);
		uppertext.setBounds(0,0,600,40);
		
		guesstext.setForeground(Color.black);
		guesstext.setFont(new Font("Verdana",Font.BOLD,20));
		guesstext.setHorizontalAlignment(JLabel.CENTER);
		guesstext.setBounds(0,54,465,50);
		
		userguess.setForeground(Color.black);
		userguess.setHorizontalAlignment(JLabel.CENTER);
		userguess.setFont(new Font("Verdana",Font.PLAIN,20));
		userguess.setBounds(450,62,100,40);
	
		guessbutton.addActionListener(this);
		guessbutton.setBackground(Color.black);
		guessbutton.setForeground(Color.white);
		guessbutton.setFont(new Font("Verdana",Font.BOLD,13));
		guessbutton.setBounds(450,110,100,40);
		guessbutton.setFocusable(false);
		
		message.setBackground(new Color(192,192,192));
		message.setForeground(Color.red);
		message.setFont(new Font("Verdana",Font.PLAIN,15));
		message.setHorizontalAlignment(JLabel.CENTER);
		message.setOpaque(true);
		message.setBounds(200,120,200,30);

		resetbutton.addActionListener(this);
		resetbutton.setFont(new Font("Verdana",Font.BOLD,16));
		resetbutton.setBackground(Color.black);
		resetbutton.setForeground(Color.red);
		resetbutton.setBounds(5,120,120,40);
		resetbutton.setFocusable(false);

		frame.add(uppertext);
		frame.add(guesstext);
        frame.add(userguess);
		frame.add(guessbutton);
		frame.add(resetbutton);
		frame.add(message);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {		
	        if(e.getSource()==guessbutton) {
				int usernumber=Integer.parseInt(userguess.getText());
				if((usernumber>=1)&&(usernumber<=100)) {
					count++;
				    if(compnumber==usernumber) {
					    uppertext.setText("TOTAL ATTEMPTS:"+Integer.toString(count));				
					    message.setText("CONGRATS!!!");
					    userguess.setText(null);
					    userguess.setEnabled(false);
					    guessbutton.setEnabled(false);
				    }
				    else if(compnumber<usernumber) {
					    userguess.setText(null);
					    message.setText("Try a lower number!!!");
				    }
				    else if(compnumber>usernumber) {
				    	userguess.setText(null);
					    message.setText("Try a higher number!!!");
				    }
		         }
	             else {
	            	 userguess.setText(null);
	            	 message.setText("Enter a valid number!!!");
	             }
	        }
	    }
		catch(Exception e1) {
			userguess.setText(null);
			message.setText("Enter a number!!!");
	    }  
		if(e.getSource()==resetbutton) {
			count=0;
			userguess.setEnabled(true);
			uppertext.setText("GUESS THE NUMBER");
			message.setText("MESSAGE BOX");
			guessbutton.setEnabled(true);
		}
	}

    public static void main(String[] args) {
    	GUESS_THE_NUMBER tk=new GUESS_THE_NUMBER();
	} 
}