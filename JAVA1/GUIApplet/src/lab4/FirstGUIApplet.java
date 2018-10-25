package lab4;

import java.applet.*;
import java.awt.*;

@SuppressWarnings("serial")
public class FirstGUIApplet extends Applet{

	TextField input;
	Button square;
	Button circle;
	Label output;
	
	public void init(){
		input = new TextField(20);
		square = new Button("Green Square");
		circle = new Button("Red Circle");
		output = new Label ("Here is where results are noted");
		
		add (input);
		add (square);
		add(circle);
		add(output);	
	}
	
	public void paint(Graphics g){
		
		
	}
	public boolean action (Event e, Object o){
		Graphics g = getGraphics();
		if(e.target==square){
			g.setColor(Color.green);
			g.fillRect(20, 100, 60, 60);
			output.setText("Green Square button pushed");
		}
		
		else if(e.target==circle){
			g.setColor(Color.red);
			g.fillOval(20, 100, 60, 60);
			output.setText("Red Circle button pushed");
		}
		
		else if(e.target==input){
			
			output.setText("Input: "+input.getText());
			input.setText("");
		}

		return true;
		
	}
	
}
