package vehinh;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DrawFrame extends JFrame {

	private JButton btnDraw;
	private JComboBox<String> cmbShapePicking, cmbColorPicking;
	private DrawPanel pnlDraw;
	private JPanel pnlChoose;
	private JCheckBox chkEmpty;

	public DrawFrame(String title) throws HeadlessException {
		super(title);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1, 2));

		this.pnlDraw = new DrawPanel();
		this.add(pnlDraw);

		this.pnlChoose = new JPanel(new FlowLayout());
		this.add(pnlChoose);

		this.btnDraw = new JButton("DRAW");
		this.btnDraw.setSize(50, 50);
		this.pnlChoose.add(btnDraw);
		this.btnDraw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pnlDraw.setShape((String) cmbShapePicking.getSelectedItem());
				pnlDraw.setColor((String) cmbColorPicking.getSelectedItem());
				pnlDraw.repaint();
			}
		});

		this.cmbShapePicking = new JComboBox<>(new String[] { "Square", "Circle", "Rectangle", "Polygon" });
		this.pnlChoose.add(cmbShapePicking);

		this.cmbColorPicking = new JComboBox<>(new String[] { "RED", "BLUE", "GREEN", "YELLOW" });
		this.pnlChoose.add(cmbColorPicking);

		this.chkEmpty = new JCheckBox("Empty");
		this.chkEmpty.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				pnlDraw.setEmpty(e.getStateChange() == 1 ? true : false);
			}
		});
		this.pnlChoose.add(chkEmpty);

		this.setVisible(true);
	}

}
