import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowFlakePanel extends JPanel
{
	public SnowFlakePanel()
	{
		super.setPreferredSize(new Dimension(400, 400));
		super.setBackground(Color.WHITE);
	}

	public void paintComponent(Graphics g)
	{
		int width  = getWidth();
		int height = getHeight();

		super.paintComponent(g);
		/*
		 * DRAWING CODE BELOW
		 */
		blizzard(g, width);
		
	}

	public void drawStar(Graphics g, int x, int y, int size)
	{
		
		if (size <= 1)
			return;
		else
		{
			for (int i = 1; i <= 6; i++)
			{
				double a = i * (2 * Math.PI) / 6;
				g.drawLine(x, y, x + (int)(size * Math.cos(a)) , y + (int)(size * Math.sin(a)));
				drawStar(g, x + (int)(size * Math.cos(a)), y + (int)(size * Math.sin(a)), size/3);
			}
			
		}
	}
	public void blizzard(Graphics g, int width)
	{
		for (int i = 0; i < 30; i++)
		{
			float red = (float) Math.random();
			float green = (float) Math.random();
			float blue = (float) Math.random();
			Color random = new Color(red, green, blue);
			g.setColor(random);

			int x = (int)(Math.random() * width);
			int y = (int)(Math.random() * width);
			int size = (int)(Math.random() * width/15);
			drawStar(g, x, y, size);

		}
	}
	
}

public class Snowflake
{
	public static void main (String[] args)
	{
		/*
		 * A frame is a container for a panel
		 * The panel is where the drawing will take place
		 */
		JFrame frame = new JFrame("Snowflake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new SnowFlakePanel());
		frame.pack();
		frame.setVisible(true);
		System.out.println();
	}
}
