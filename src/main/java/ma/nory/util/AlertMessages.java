package ma.nory.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class AlertMessages {

	public static void error(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur : "+msg, null));
	}

	public static void information(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : "+msg, null));
	}

	public static void warning(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerte : "+msg, null));
	}

	public static void fatal(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"Fatale : "+msg, null));
	}
	
	public static void growlMessage(Severity severity, String title, String message){
		FacesMessage msg = new FacesMessage(severity, title, message);
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
