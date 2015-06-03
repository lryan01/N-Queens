import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The GUI class creates the graphical user interface to be used with NQueens.
 * It passes on the number of queens to be placed and displays the locations of
 * the queens if a solution is possible or no solutions if it is not possible.
 * 
 * @author Lauren Ryan
 *
 */

public class GUI extends JFrame {
	private JTextField input;
	private JTextArea output;
	private NQueens queens;

	/**
	 * Creates the gui
	 * 
	 * @param queens passes the NQueens handle to the GUI
	 */

	public GUI(NQueens queens) {
		this.queens = queens;

		setTitle("N Queens");
		this.setMinimumSize(new Dimension(400, 300));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		input = new JTextField();
		panel.add(input, BorderLayout.NORTH);
		input.setColumns(10);
		input.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					process();
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		output = new JTextArea();
		output.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		output.setLineWrap(true);
		panel.add(output, BorderLayout.CENTER);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);

	}

	/**
	 * Takes input and creates NQueens with the given size, then selects the 
	 * input in order to allow for ease of re-entry.
	 */
	private void process() {
		output.setText("");
		int i = Integer.parseInt(input.getText());
		queens.create(i);
		input.selectAll();
	}

	/**
	 * Prints the result from running NQueens to text area
	 * 
	 * @param string
	 */

	public void println(String string) {

		output.append(string);

	}

}
