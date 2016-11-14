package jsample.awt;

import java.awt.Button;
import java.awt.Frame;

public class MyFrame extends Frame {

	private static final long serialVersionUID = 1L;

	public MyFrame() {
		setTitle("My Frame"); // set frame title
		Button button = new Button("Click here");
		button.setBounds(110, 135, 80, 30);// set button position

		add(button);// add button into frame
		setSize(300, 300);// set frame size
		setLayout(null);// no layout manager
		// by default, the frame has a border layout

		setVisible(true); // by default frame is not visible
	}
}
