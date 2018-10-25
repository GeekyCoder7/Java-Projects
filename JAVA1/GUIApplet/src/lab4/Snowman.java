package lab4;
import java.applet.Applet;
import java.awt.*;


@SuppressWarnings("serial")
public class Snowman extends Applet {

	public void paint(Graphics page){
		String myName="Nazareth Keshishian";
		final int MID=150;
		final int TOP=50;
		setBackground(Color.cyan);
		
		page.setColor(Color.blue);
		page.fillRect(0,175,300,50);
		
		page.setColor(Color.yellow);
		page.fillOval(250,-40,80,80);
		
		page.setColor(Color.white);
		page.fillOval(MID,TOP,40,40);
		page.fillOval(MID-15,TOP+35,70,50);
		page.fillOval(MID-30,TOP+80,100,60);
		
		
		
		page.setColor(Color.red);
		page.fillOval(MID+18,TOP+50,5,5);
		page.fillOval(MID+18,TOP+40,5,5);
		
		page.setColor(Color.black);
		page.fillOval(MID+10,TOP+10,5,5);
		page.fillOval(MID+25,TOP+10,5,5);
		
		page.drawArc(MID+10,TOP+20, 20,10,10,160);
		
		page.drawLine(MID-5,TOP+60,MID-50,TOP+40);
		page.drawLine(MID+85,TOP+60,MID+55,TOP+60);
		
		page.drawLine(MID,TOP+5,MID+38,TOP+5);
		page.fillRect(MID+5,TOP-20,30,25);
		
		page.drawString(myName, 0,15);
	}
}
