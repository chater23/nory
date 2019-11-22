package ma.nory.excels;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Part;

import ma.nory.models.Fuel;
import ma.nory.service.IFuelService;
import ma.nory.util.ProcessingOnTheDate;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ImporteFuel {
	
	public static String importTasksFromExcelFile(Part part, IFuelService iFuelService) throws ParseException{
		String stringToReturn = "Succès : Importation réussite.";
	try{
		InputStream input = part.getInputStream();
		POIFSFileSystem fs = new POIFSFileSystem(input);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
    
		int nbrColl = sheet.getLastRowNum();
		SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
		
		Fuel fuel;
		
		for(int i = 1 ; i<=nbrColl;i++){
					fuel = new Fuel();
					System.out.println(sheet.getRow(i).getCell(11).toString());
					
//					String cardNumber =  sheet.getRow(i).getCell(0).toString();
//					String reportNumber = sheet.getRow(i).getCell(1).toString();
//					String mounth = sheet.getRow(i).getCell(9).toString();
//					String mounth2 = sheet.getRow(i).getCell(16).toString();
//					String year = sheet.getRow(i).getCell(15).toString();
//					String billNumber = sheet.getRow(i).getCell(17).toString();
//					
//					fuel.setCardNumber(Integer.valueOf(cardNumber.substring(0, cardNumber.indexOf("."))));
//					fuel.setReportNumber(Integer.valueOf(reportNumber.substring(0, reportNumber.indexOf("."))));
//					fuel.setDate_(ft.parse(sheet.getRow(i).getCell(2).toString().replace(".", "")));
//					fuel.setSerial(sheet.getRow(i).getCell(3).toString());
//					fuel.setKm(Float.valueOf(sheet.getRow(i).getCell(4).toString()));
//					fuel.setLiter(Float.valueOf(sheet.getRow(i).getCell(5).toString()));
//					fuel.setAmount(BigDecimal.valueOf(Long.valueOf(sheet.getRow(i).getCell(6).toString())));
//					fuel.setMntLiter(Float.valueOf(sheet.getRow(i).getCell(7).toString()));
//					fuel.setFrs(sheet.getRow(i).getCell(8).toString());
//					fuel.setMounth(Integer.valueOf(mounth.substring(0, mounth.indexOf("."))));
//					fuel.setNumber(sheet.getRow(i).getCell(10).toString());
//					fuel.setSerial22(sheet.getRow(i).getCell(11).toString());
//					fuel.setAssignment(sheet.getRow(i).getCell(12).toString());
//					fuel.setSector(sheet.getRow(i).getCell(13).toString());
//					fuel.setDepartment(sheet.getRow(i).getCell(14).toString());
//					fuel.setYear(Integer.valueOf(year.substring(0, year.indexOf("."))));
//					fuel.setMounth2(Integer.valueOf(mounth2.substring(0, mounth2.indexOf("."))));
//					fuel.setBill_number(Integer.valueOf(billNumber.substring(0, billNumber.indexOf("."))));
//					fuel.setBill_date(ft.parse(sheet.getRow(i).getCell(18).toString().replace(".", "")));
//					fuel.setHtAmount(Float.valueOf(sheet.getRow(i).getCell(19).toString()));
//					fuel.setTvBill(Float.valueOf(sheet.getRow(i).getCell(20).toString()));
//					fuel.setTvaAccounting(Float.valueOf(sheet.getRow(i).getCell(21).toString()));
//					fuel.setHtPorta(Float.valueOf(sheet.getRow(i).getCell(22).toString()));
				
					try{
//						iFuelService.saveFuel(fuel);
					}
					catch(Exception e){
						return stringToReturn = "Erreur : Les lignes importées de 1 jusqu'a "+(i-1)+", vérifier les autres lignes (Problème de Cohérence de données)";
					}
					finally{
						fuel = null;
					}
		}
	} catch (IOException ex ) {
		return "ERREUR FATALE : "+ex.getMessage();
	}
	return stringToReturn;
}
}
