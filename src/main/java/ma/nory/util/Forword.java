package ma.nory.util;

import javax.faces.context.FacesContext;

public class Forword {
	
	public static void send(String sendTo){
		FacesContext facesContext = FacesContext.getCurrentInstance();
        	facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, sendTo+"?faces-redirect=true");
	}
}
