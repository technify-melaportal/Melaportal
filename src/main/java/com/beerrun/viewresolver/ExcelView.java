package com.beerrun.viewresolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.beerrun.common.ArchUtils;

public class ExcelView extends AbstractXlsxView  {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		List<List<String>> exceldatas =  (List<List<String>>) model.get("ExcelDatas");
		exceldatas = exceldatas == null ? new ArrayList<List<String>>() : exceldatas;
		String filename= ArchUtils.nullCheck((String)model.get("filename"));
		userListExcel(filename,exceldatas, workbook, request, response);
	}
	
	private void userListExcel(String filename,List<List<String>> exceldatas , Workbook workbook, HttpServletRequest request,HttpServletResponse response) throws IOException {
	
				try
				{
				 // change the file name
		        response.setHeader("Content-Disposition", "attachment; filename=" + filename + ".xlsx");
		        
		        // create excel xls sheet
		        Sheet sheet = workbook.createSheet(filename);
		        // create header row
		        Row row =null;
		        Cell cell=null;
		        String value="";
		      
		        
		        for(int rowIndex=0;rowIndex<exceldatas.size();rowIndex++)
				{
		        	row = sheet.createRow(rowIndex);
		        	List<String> data=exceldatas.get(rowIndex);	
					for(int columnIndex=0;columnIndex<data.size();columnIndex++)
					{
						 value = data.get(columnIndex).replaceAll("\\<.*?\\>", "");
						
						 cell=row.createCell(columnIndex);
						
						 if(isDouble(value)) {
						 cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						 cell.setCellValue(Double.parseDouble(value.replaceAll(",", "")));
						 }
						else  {
						 cell.setCellType(Cell.CELL_TYPE_STRING);
						 cell.setCellValue(value);
						 }
						
						
						
					}
		        	
				}
		        
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
				
	}
	private boolean isDouble(String value) {
		try {
			
			if(value.matches(".*[a-zA-Z]+.*"))
				Double.parseDouble(value);
			
			else
				Double.parseDouble(value.replaceAll(",", ""));
			
			return true;
		}catch (NumberFormatException ne) {
			return false;
		}
		
		
	}
	
}
