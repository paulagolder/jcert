package org.lerot.jcert.layout;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.lerot.jcert.PMenuItem;
import org.lerot.jcert.certificateeditpanel;

public class Popup  extends JPopupMenu {
	    JMenuItem anItem1, anItem2, anItem3;
	    
	    
	    public Popup(String tag,certificateeditpanel certificateframeloaderpanel){
	       
	        anItem1 = new PMenuItem("New Row(before)");
	        anItem1.addActionListener(certificateframeloaderpanel);
	        anItem1.setActionCommand("NEWBEFORE:"+tag);
	        add(anItem1);
	        anItem2 = new PMenuItem("New Row");
	        anItem2.addActionListener(certificateframeloaderpanel);
	        anItem2.setActionCommand("NEWAFTER:"+tag);
	        add(anItem2);
	        anItem3 = new PMenuItem("Delete Row");
	        anItem3.addActionListener(certificateframeloaderpanel);
	        anItem3.setActionCommand("DELETE:"+tag);
	        add(anItem3);
	    }

		
	    
	    
	}

