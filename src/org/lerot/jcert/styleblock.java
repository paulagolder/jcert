package org.lerot.jcert;

import org.dom4j.Element;
import org.lerot.jcert.layout.jcertPanel;

public class styleblock extends PanelStyleObject
{

	public styleblock(DisplayObject container, Element element)
	{
		super(container);
		//container.copyFormat(this);
		// System.out.println(" creating styleblock in "+container.getName());
		loadAttributes(element);
	}

	

	public jcertPanel getDisplayObject()
	{
		return null;
	}

	@Override
	public boolean hasContent()
	{
		return false;
	}

	public void fillTemplate(Element root)
	{

	}


	@Override
	public int countDisplayObjects()
	{
		return 0;
	}


	public double getMinWidth()
	{
		return 0;
	}

	public double getMinHeight()
	{
		return 0;
	}


	public jcertPanel getPanelObject() 
	{
		return null;
	}

}