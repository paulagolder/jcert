package org.lerot.jcert.layout;
import java.awt.Dimension;
import java.awt.LayoutManager;


public class HorizontalPanel extends jcertPanel 
{

	private static final long serialVersionUID = 1L;
	HorizontalLayout lyt;
	
	public HorizontalPanel(String name)
	{
		setName(name);
		lyt = new HorizontalLayout();
		setLayout(lyt);
		//setBorder(utils.setborder(Color.red,1));
	}

	/*public HorizontalPanel(String title, boolean titledborder)
	{
		// setAlignmentY(Component.TOP_ALIGNMENT);
		setLayout(new HorizontalLayout());
		// if(title.length()>0)
		{
			setName(title);
			if (titledborder)
				setBorder(setcborder(title));
		}
	}*/
	
	public Dimension getMinimumSize()
	{
		LayoutManager lm = this.getLayout();
		return lm.preferredLayoutSize(this);
	}
		
	
	

}
