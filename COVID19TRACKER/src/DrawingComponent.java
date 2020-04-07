import java.awt.Component;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JLabel;

@SuppressWarnings({ "unused", "serial" })

public class DrawingComponent extends Component {

	// COLOR
	Color ylw = new Color(230, 221, 91);
	Color blk = new Color(50, 50, 50);

	public DrawingComponent() {
	}

	public void paint(Graphics g) {

		// RED BOXES
		for (int i = 0; i < 14; i++) {
			Graphics2D g2 = (Graphics2D) g;
			g.setColor(Color.RED.brighter());
			g.fillRect(10,100,50,50);
		}

	}

}
