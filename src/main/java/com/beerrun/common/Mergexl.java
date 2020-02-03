package com.beerrun.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfNumber;
import com.lowagie.text.pdf.PdfPage;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;
public class Mergexl {

	public static void main(String agd[]) throws IOException
	{
		OutputStream f = new FileOutputStream("C:\\Users\\technify\\Desktop\\AL\\ALreport\\out1.xls");
		List<InputStream> Allpdfpath = new ArrayList<InputStream>();
		FileInputStream fis=null;
		fis=new FileInputStream("C:\\Users\\technify\\Desktop\\AL\\ALreport\\AL_samples.xls");
		Allpdfpath.add(fis);
		fis=new FileInputStream("C:\\Users\\technify\\Desktop\\AL\\ALreport\\AL_onpermise.xls");
		Allpdfpath.add(fis);
//		fis=new FileInputStream("C:\\Users\\technify\\Desktop\\AL\\ALreport\\AL_Export.xls");
//		Allpdfpath.add(fis);
		Mergexl.mergeExcelFiles(f, Allpdfpath);
	}
	  public static void mergeExcelFiles(OutputStream file, List<InputStream> list) throws IOException {
		    HSSFWorkbook book = new HSSFWorkbook();
//		    HSSFSheet sheet = book.createSheet(file.getName());
		    HSSFSheet sheet = book.createSheet("Tax Return");
		    HSSFSheet sheet1 = book.createSheet("STOCK REPORT");
		    HSSFSheet sheet2 = book.createSheet("SALES TO WHOLESALERS");
		    HSSFSheet sheet3 = book.createSheet("ON PREMISE SALES SAMPLE TASTE");
		    HSSFSheet sheet4 = book.createSheet("OFF PREMISE SAMPLE TASTE");
		    HSSFSheet sheet5 = book.createSheet("EXPORT SALES");
		    HSSFSheet sheet6 = book.createSheet("OFF PREMISE SALES SUMMARY");
		    HSSFSheet sheet7 = book.createSheet("CHARITABLE SPECIAL EVENTS");
		    HSSFSheet sheet8 = book.createSheet("BATCH REPORT");
		    HSSFSheet sheet9 = book.createSheet("Spoilage Form");
		    HSSFSheet sheet10 = book.createSheet("Contract Beer Transfer IN");
		    HSSFSheet sheet11 = book.createSheet("Contract Beer Transfer OUT");

		    int j=0;
		    for (InputStream fin : list) 
		    {
		    	j++;
//		    	System.out.println("fin==>"+fin.toString());
		        HSSFWorkbook b = new HSSFWorkbook(fin);
		        for (int i = 0; i < b.getNumberOfSheets(); i++) 
		        {
		        	if(j==1)		        		
		        		copySheets(book, sheet, b.getSheetAt(i));
		        	if(j==2)
		        		copySheets(book, sheet1, b.getSheetAt(i));
		        	if(j==3)
		        		copySheets(book, sheet2, b.getSheetAt(i));
		        	if(j==4)
		        		copySheets(book, sheet3, b.getSheetAt(i));
		        	if(j==5)
		        		copySheets(book, sheet4, b.getSheetAt(i));
		        	if(j==6)
		        		copySheets(book, sheet5, b.getSheetAt(i));
		        	if(j==7)
		        		copySheets(book, sheet6, b.getSheetAt(i));
		        	if(j==8)
		        		copySheets(book, sheet7, b.getSheetAt(i));
		        	if(j==9)
		        		copySheets(book, sheet8, b.getSheetAt(i));
		        	if(j==10)
		        		copySheets(book, sheet9, b.getSheetAt(i));
		        	if(j==11)
		        		copySheets(book, sheet10, b.getSheetAt(i));
		        	if(j==12)
		        		copySheets(book, sheet11, b.getSheetAt(i));		        	
		        }
		      }
		    
		    try {
		      writeFile(book, file);
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		  }
		  
		  protected static void writeFile(HSSFWorkbook book, OutputStream file) throws Exception {
		    book.write(file);
		    file.close();
		  }
		  private static void copySheets(HSSFWorkbook newWorkbook, HSSFSheet newSheet, HSSFSheet sheet){     
			    copySheets(newWorkbook, newSheet, sheet, true);
			  }
		 
		  private static void copySheets(HSSFWorkbook newWorkbook, HSSFSheet newSheet, HSSFSheet sheet, boolean copyStyle){     
		    int newRownumber = newSheet.getLastRowNum() + 1;
		    int maxColumnNum = 0;     
		    Map<Integer, HSSFCellStyle> styleMap = (copyStyle) ? new HashMap<Integer, HSSFCellStyle>() : null;    
		    
		    for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {     
		      HSSFRow srcRow = sheet.getRow(i);     
		      HSSFRow destRow = newSheet.createRow(i + newRownumber);     
		      if (srcRow != null) {     
		        copyRow(newWorkbook, sheet, newSheet, srcRow, destRow, styleMap);     
		        if (srcRow.getLastCellNum() > maxColumnNum) {     
		            maxColumnNum = srcRow.getLastCellNum();     
		        }     
		      }     
		    }     
		    for (int i = 0; i <= maxColumnNum; i++) {     
		      newSheet.setColumnWidth(i, sheet.getColumnWidth(i));     
		    }     
		  }     
		  
		  public static void copyRow(HSSFWorkbook newWorkbook, HSSFSheet srcSheet, HSSFSheet destSheet, HSSFRow srcRow, HSSFRow destRow, Map<Integer, HSSFCellStyle> styleMap) {     
		    destRow.setHeight(srcRow.getHeight());
		    for (int j = srcRow.getFirstCellNum(); j <= srcRow.getLastCellNum(); j++) {     
		      HSSFCell oldCell = srcRow.getCell(j);
		      HSSFCell newCell = destRow.getCell(j);
		      if (oldCell != null) {     
		        if (newCell == null) {     
		          newCell = destRow.createCell(j);     
		        }     
		        copyCell(newWorkbook, oldCell, newCell, styleMap);
		      }     
		    }                
		  }
		  
		  public static void copyCell(HSSFWorkbook newWorkbook, HSSFCell oldCell, HSSFCell newCell, Map<Integer, HSSFCellStyle> styleMap) {      
		    if(styleMap != null) {     
		      int stHashCode = oldCell.getCellStyle().hashCode();     
		      HSSFCellStyle newCellStyle = styleMap.get(stHashCode);     
		      if(newCellStyle == null){     
		        newCellStyle = newWorkbook.createCellStyle();     
		        newCellStyle.cloneStyleFrom(oldCell.getCellStyle());     
		        styleMap.put(stHashCode, newCellStyle);     
		      }     
		      newCell.setCellStyle(newCellStyle);   
		    }     
		    switch(oldCell.getCellType()) {     
		      case HSSFCell.CELL_TYPE_STRING:     
		        newCell.setCellValue(oldCell.getRichStringCellValue());     
		        break;     
		      case HSSFCell.CELL_TYPE_NUMERIC:     
		        newCell.setCellValue(oldCell.getNumericCellValue());     
		        break;     
//		      case HSSFCell.CELL_TYPE_BLANK:     
//		        newCell.setCellType(HSSFCell.CELL_TYPE_BLANK);     
//		        break;     
		      case HSSFCell.CELL_TYPE_BOOLEAN:     
		        newCell.setCellValue(oldCell.getBooleanCellValue());     
		        break;     
		      case HSSFCell.CELL_TYPE_ERROR:     
		        newCell.setCellErrorValue(oldCell.getErrorCellValue());     
		        break;     
		      case HSSFCell.CELL_TYPE_FORMULA:     
		        newCell.setCellFormula(oldCell.getCellFormula());     
		        break;     
		      case HSSFCell.ENCODING_UNCHANGED: 
		    	  newCell.setCellStyle(oldCell.getCellStyle());
			      break;
//		      case HSSFCell.ENCODING_COMPRESSED_UNICODE: 
//		    	  newCell.setCellStyle(oldCell.getCellStyle());     
//			      break;
//		      case HSSFCell.ENCODING_UTF_16: 
//		    	  newCell.setCellStyle(oldCell.getCellStyle());    
//			      break;
		      default:     
		        break;     
		    }
		  }
		  
	public static void doMerge(List<InputStream> list, OutputStream outputStream)
          throws DocumentException, IOException {
      Document document = new Document();
      PdfWriter writer = PdfWriter.getInstance(document, outputStream);  
      document.open();
      PdfContentByte cb = writer.getDirectContent();        
      for (InputStream in : list) {
          PdfReader reader = new PdfReader(in);
          for (int i = 1; i <= reader.getNumberOfPages(); i++) {
              document.newPage();
              //import the page from source pdf
              PdfImportedPage page = writer.getImportedPage(reader, i);
              //add the page to the destination pdf
              cb.addTemplate(page, 0,0);    
          }
      }  
      outputStream.flush();
      document.close();
      outputStream.close();
  }
	
}
