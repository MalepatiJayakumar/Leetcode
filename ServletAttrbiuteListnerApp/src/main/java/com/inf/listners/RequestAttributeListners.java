package com.inf.listners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class RequestAttributeListners implements ServletRequestAttributeListener {

	static {
		System.out.println("RequestAttributeListners.class has been loaded");
	}
    
    public RequestAttributeListners() {
    	System.out.println("Inside RequestAttributeListners constructor , object is being intialized");
    }

	
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	System.out.println("Inside attributeRemoved in RequestAttributeListners >> "+srae.getName()+" attribute has been removed");
    }

	
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	System.out.println("Inside attributeAdded in RequestAttributeListners >> "+srae.getName()+" attribute has been added");
    }

	
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	System.out.println("Inside attributeReplaced in RequestAttributeListners >> "+srae.getName()+" attribute has been replaced");
    }
	
}

/* output
 * =======
 * 	Inside attributeReplaced in RequestAttributeListners >> org.apache.catalina.ASYNC_SUPPORTED attribute has been replaced
	Inside attributeAdded in RequestAttributeListners >> Name attribute has been added
	Inside attributeAdded in RequestAttributeListners >> Age attribute has been added
	Inside attributeAdded in RequestAttributeListners >> college attribute has been added
	Inside attributeRemoved in RequestAttributeListners >> Age attribute has been removed
	Inside attributeReplaced in RequestAttributeListners >> college attribute has been replaced
 */
