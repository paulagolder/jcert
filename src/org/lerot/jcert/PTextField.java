package org.lerot.jcert;

import java.awt.Dimension;

import javax.swing.JTextField;

public class PTextField extends JTextField
{
	private static final long serialVersionUID = 1L;

	public PTextField()
	{
		setMinimumSize(new Dimension(200, 50));
		setMaximumSize(new Dimension(200, 50));
		setFont(JCert_gui.guiMenufont);
	}

	public PTextField(String atext)
	{
		setMinimumSize(new Dimension(200, 50));
		setMaximumSize(new Dimension(200, 50));
		setFont(JCert_gui.guiMenufont);
		setText(atext);
	}

}
