import javax.swing.Icon;
import javax.swing.JButton;

public class MyJButton extends JButton
{
	public MyJButton()
	{
		super();
	}
	
	public MyJButton(Icon icon) 
	{
		super(icon);
	}
	 
	public int x; //0-7
	public int y; //0-7

	public int color; //0-6
}
