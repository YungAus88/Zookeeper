import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Zookeeper 
{
	static MyJButton start_btn = null;
	static MyJButton end_btn = null;
	static MyJButton  btns[][] = new MyJButton [8][8];
	static Icon icon[] = new Icon[7];
	
	public static void main(String[] args)
	{
		icon[0] = new ImageIcon("a.png");
		icon[1] = new ImageIcon("b.png");
		icon[2] = new ImageIcon("c.png");
		icon[3] = new ImageIcon("d.png");
		icon[4] = new ImageIcon("e.png");
		icon[5] = new ImageIcon("f.png");
		icon[6] = new ImageIcon("g.png");


		
		ActionListener act = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				if(start_btn == null)
				{
					start_btn = (MyJButton) e.getSource();
				}
				
				else
				{
					end_btn = (MyJButton) e.getSource();
				
					
					//swap
					if(Math.abs(start_btn.x - end_btn.x )<=1 && Math.abs(start_btn.y - end_btn.y )<=1)
					{
					Icon icon_temp = start_btn.getIcon();
					start_btn.setIcon(end_btn.getIcon());
					end_btn.setIcon(icon_temp);
					
					
					}
					
					
					//clear
					start_btn = end_btn = null;
					
					//search X
					for(int i = 0; i<8; i++)
					{
						for(int j = 0; j < 5;j++)
						{
							if(btns[i][j].getIcon() == btns[i][j+1].getIcon() &&
									btns[i][j+1].getIcon()== btns[i][j+2].getIcon())
							{
							btns[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE,0));
							btns[i][j+1].setBorder(BorderFactory.createLineBorder(Color.WHITE,0));
							btns[i][j+2].setBorder(BorderFactory.createLineBorder(Color.WHITE,0));
							int s1 = 0;
							
							while(s1 != 1)
							{
								s1 =1;
								for(int t = 0; t<3; t++)
								{								
									int id = (int) (Math.random()*100 % 7);
									btns[i][t].setIcon(icon[id]);
							
								}
								
								if(btns[i][j].getIcon() == btns[i+1][j].getIcon() &&
										btns[i+1][j].getIcon() == btns[i+2][j].getIcon())
								{
									s1 = 0;
								}
						
							}
							}
							
						}
						
					}
					
					//search Y
					for(int i = 0; i<5; i++)
					{
						for(int j = 0; j < 8;j++)
						{
							if(btns[i][j].getIcon() == btns[i+1][j].getIcon() &&
									btns[i+1][j].getIcon() == btns[i+2][j].getIcon())
							{
							btns[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE,0));
							btns[i+1][j].setBorder(BorderFactory.createLineBorder(Color.WHITE,0));
							btns[i+2][j].setBorder(BorderFactory.createLineBorder(Color.WHITE,0));
							int s1 = 0;
							
								while(s1 != 1)
								{
									s1 =1;
									for(int t = 0; t<3; t++)
									{								
										int id = (int) (Math.random()*100 % 7);
										btns[t][j].setIcon(icon[id]);
								
									}
									
									if(btns[i][j].getIcon() == btns[i+1][j].getIcon() &&
											btns[i+1][j].getIcon() == btns[i+2][j].getIcon())
									{
										s1 = 0;
									}
							
								}
							}
						}
					}
				}
					
					
			}
			
			
			
		};
		
		
		int rs = 0;
		
		while(rs != 1)
		{
			rs = 1;
			
			for(int i = 0; i<8; i++)
			{
				for(int j = 0; j < 8;j++)
				{
					int id = (int) (Math.random()*100 % 7);
					btns[i][j] = new MyJButton (icon[id]);
					btns[i][j].color = id;
					btns[i][j].addActionListener(act);
				}
			}
			
			for(int i = 0; i<8; i++)
			{
				for(int j = 0; j < 5;j++)
				{
					if(btns[i][j].getIcon() == btns[i][j+1].getIcon() &&
							btns[i][j+1].getIcon()== btns[i][j+2].getIcon())
					{
					   rs = 0;
					}
				}
			}
			
			//search Y
			for(int i = 0; i<5; i++)
			{
				for(int j = 0; j < 8;j++)
				{
					if(btns[i][j].getIcon() == btns[i+1][j].getIcon() &&
							btns[i+1][j].getIcon() == btns[i+2][j].getIcon())
					{
					   rs = 0;
					}
				}
			}
			
		}
		
		
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setSize(500, 300);
		
		frame.setLayout(new GridLayout(8,8));
		
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
				btns[i][j].x = j;
				btns[i][j].y = i;
				frame.add(btns[i][j]);
			}
		}
	
		
		frame.setVisible(true);
	}
	
}
