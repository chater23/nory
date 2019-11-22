package ma.nory.util.generator;
	
import org.apache.log4j.Logger;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
	
public class RunData {
	
	public static void main(final String[] args) {
		Logger logger = Logger.getLogger(RunData.class);
		
		try{
			final AnnotationConfiguration config = new AnnotationConfiguration();
			config.configure();
			final SchemaExport export = new SchemaExport(config);
			export.create(false, true);
		}catch(Exception e){
			logger.info("Erreur lors de la g�n�ration de la base de donn�es");
			logger.error("Erreur : "+e);
		}
	}
	
}	
	