import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener
{
	Random random=new Random();
	JFrame frame = new JFrame();
	JPanel Title_panel=new JPanel();
	JPanel button_panel=new JPanel();
	JLabel textfield=new JLabel();
	JButton[] buttons=new JButton[9];
	//JButton replay_button = new JButton("REPLAY");
                  boolean player1_turn;	
    
	TicTacToe()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50,50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic_Tac_Toe");
		textfield.setOpaque(true);
		
		
		 
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		Title_panel.setLayout(new BorderLayout());
		Title_panel.setBounds(0, 0, 800,100);
		Title_panel.add(textfield);
		
		
		
		
		for(int i=0;i<9;i++)
		{
			
			buttons[i]=new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			
			
		}
		
		
		
		frame.add(Title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		FirstTurn();
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<9;i++)
		{
			if(e.getSource()==buttons[i])
			{
				if(player1_turn)
				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("x");
						player1_turn=false;
						textfield.setText("0 turn");
						Check();
					}
				}
				else
				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("o");
						player1_turn=true;
						textfield.setText("x turn");
						Check();
					}
				}
				
			}
			//b.addActionListener(this);
			
		}
		
	}
	public void FirstTurn()
	{
		try 
		{
			Thread.sleep(500);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0)
		{
			player1_turn=true;
			textfield.setText("x turns");
		}
		else
		{
			player1_turn=false;
			textfield.setText("o turns");
		}
			
			
	}
	public void Check()
	{
		//check o wins condition
				if((buttons[0].getText()=="o") && (buttons[1].getText()=="o") && (buttons[2].getText()=="o"))
				{
					Owins(0,1,2);
				}
				if((buttons[3].getText()=="o") && (buttons[4].getText()=="o") && (buttons[5].getText()=="o"))
				{
			       Owins(3,4,5);
				}
				if((buttons[6].getText()=="o") && (buttons[7].getText()=="o") && (buttons[8].getText()=="o"))
				{
			       Owins(6,7,8);
				}
				if((buttons[0].getText()=="o") && (buttons[3].getText()=="o") && (buttons[6].getText()=="o"))
				{
			        Owins(0,3,6);
				}
				if((buttons[1].getText()=="o") && (buttons[4].getText()=="o") && (buttons[7].getText()=="o"))
				{
			        Owins(1,4,7);
				}
				if((buttons[2].getText()=="o") && (buttons[5].getText()=="o") && (buttons[8].getText()=="o"))
				{
			        Owins(2,5,8);
				}
				if((buttons[0].getText()=="o") && (buttons[4].getText()=="o") && (buttons[8].getText()=="o"))
				{
			        Owins(0,4,8);
				}
				if((buttons[0].getText()=="o") && (buttons[4].getText()=="o") && (buttons[6].getText()=="o"))
				{
			        Owins(2,4,6);
				}
		//check x wins condition
				if((buttons[0].getText()=="x") && (buttons[1].getText()=="x") && (buttons[2].getText()=="x"))
				{
					Xwins(0,1,2);
				}
				if((buttons[3].getText()=="x") && (buttons[4].getText()=="x") && (buttons[5].getText()=="x"))
				{
			        Xwins(3,4,5);
				}
				if((buttons[6].getText()=="x") && (buttons[7].getText()=="x") && (buttons[8].getText()=="x"))
				{
			        Xwins(6,7,8);
				}
				if((buttons[0].getText()=="x") && (buttons[3].getText()=="x") && (buttons[6].getText()=="x"))
				{
			        Xwins(0,3,6);
				}
				if((buttons[1].getText()=="x") && (buttons[4].getText()=="x") && (buttons[7].getText()=="x"))
				{
			        Xwins(1,4,7);
				}
				if((buttons[2].getText()=="x") && (buttons[5].getText()=="x") && (buttons[8].getText()=="x"))
				{
			        Xwins(2,5,8);
				}
				if((buttons[0].getText()=="x") && (buttons[4].getText()=="x") && (buttons[8].getText()=="x"))
				{
			        Xwins(0,4,8);
				}
				if((buttons[2].getText()=="x") && (buttons[4].getText()=="x") && (buttons[6].getText()=="x"))
				{
			        Xwins(2,4,6);
				}
		
	}
	public void Xwins(int a,int b,int c)
	{
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		for(int i=0;i<9;i++)
		{
			buttons[i].setEnabled(false);
		}
	   
		textfield.setText(" X wins.........congratulations!!!");
	}
	public void Owins(int a,int b,int c)
	{
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++)
		{
			buttons[i].setEnabled(false);
		}
	   
		textfield.setText(" O wins.........congratulations!!!");
	}

}
