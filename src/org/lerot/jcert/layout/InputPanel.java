package org.lerot.jcert.layout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;

import org.lerot.jcert.InputCell;
import org.lerot.jcert.utils;

public class InputPanel extends JTextPane implements FocusListener
{
	private static final long serialVersionUID = 1L;
	private int lineheight, textwidth, textheight, columncount;

	protected Color backgroundColor;
	protected Color bordercolor = Color.green;
	protected int borderwidth = 0;
	protected FontMetrics fm;
	protected Color foregroundColor;
	protected int horizontalalignment = JLabel.CENTER;
	protected int verticalalignment = JLabel.TOP;
	protected int padding = 2, interlinedist = 2;
	protected Font pFont;
	protected Vector<String> text;
	private int datarow;
	InputCell cell;

	public Action nextFocusAction = new AbstractAction("Move Focus Forwards") {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent evt)
		{
			// System.out.println(" move forward"+((InputPanel)evt.getSource()).getText());
			((Component) evt.getSource()).transferFocus();
		}
	};

	public Action prevFocusAction = new AbstractAction("Move Focus Backwards") {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent evt)
		{
			((Component) evt.getSource()).transferFocusBackward();
		};

	};

	private int charwidth;

	public InputPanel(InputCell acell, int row, String tooltip)
	{
		super();
		cell = acell;
		datarow = row;
		Color backgroundcolor = Color.decode("#E4DCDC");
		setBackground(backgroundcolor);
		setOpaque(true);
		setForeground(Color.blue);
		setBorder(utils.setborder(Color.GRAY, 1));
		setEditable(true);
		this.setToolTipText(tooltip);
		this.addFocusListener(this);
		pFont = new Font("SansSerif", Font.PLAIN, 10);
		utils.setJTextPaneFont(this, pFont, Color.blue);
		super.setFont(pFont);
		fm = this.getFontMetrics(pFont);
		text = new Vector<String>();
		getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("TAB"),
				"helpAction");
		this.getActionMap().put("helpAction", nextFocusAction);
	}

	@Override
	public void focusGained(FocusEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e)
	{
		InputPanel ip1 = (InputPanel) e.getSource();
		String newvalue = ip1.getText();
		String oldvalue = cell.getCellValue(datarow);

		if (oldvalue != null) {
			if (!oldvalue.equals(newvalue)) {
				System.out.println(" value changed new:" + newvalue + "  old:"
						+ oldvalue);
				cell.updateValue(datarow, newvalue);
			}
		} else {
			if (newvalue != null) {
				System.out.println(" new value :" + newvalue);
				cell.updateValue(datarow, newvalue);
			}
		}
	}

	@Override
	public void setBounds(int x, int y, int width, int height)
	{
		super.setBounds(x, y, width, height);
		setTextSize();

		this.repaint();

	}

	public void setMySize(Dimension d)
	{
		setTextSize();
		int mincol = d.width / charwidth;
		int columns = mincol;
		// setColumns(mincol);
		setMinimumSize(d);
		setPreferredSize(d);
		setMaximumSize(d);
		System.out.println(" columns=" + columns + " w=" + d.width + " h="
				+ d.height + " charwidth=" + charwidth + " text=" + getText());

		// super.setSize( d);

	}

	public void setTextSize()
	{
		text.add(getText());
		lineheight = fm.getHeight() + interlinedist;
		int numberoflines = text.size();
		int maxlength = 0;
		columncount = 0;
		for (String aline : text) {
			int length = fm.stringWidth(aline);
			if (length > maxlength)
				maxlength = length;
			if (columncount < aline.length())
				columncount = aline.length();
		}
		textheight = numberoflines * lineheight;
		textwidth = maxlength;
		if (columncount > 0)
			charwidth = textwidth / columncount;
		else
			charwidth = fm.charWidth('M');
	}

}
