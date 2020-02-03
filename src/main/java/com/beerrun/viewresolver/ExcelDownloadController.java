package com.beerrun.viewresolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.beerrun.common.ArchUtils;

@Controller
@RequestMapping(value="/excel")
public class ExcelDownloadController {

@RequestMapping(value = "/ReportsDownload", method = {RequestMethod.GET,RequestMethod.POST})
	public	ModelAndView ReportsDownloadHandler(Model model,@RequestParam Map<String, Object> input){
		//System.out.println("input==========>"+input);
		String data=ArchUtils.nullCheck((String)input.get("data"));
		String filename=ArchUtils.nullCheck((String)input.get("filename"));
		model.addAttribute("filename",filename);
		
		StringTokenizer token=new StringTokenizer("");
		token=new StringTokenizer(data,"^");
		List<List<String>> totalrow = new ArrayList<List<String>>();
		List<String> row=new ArrayList<String>();
		String[] datas={};
		totalrow = new ArrayList<List<String>>();
		while(token.hasMoreElements())
		{
			
			String tokenstring=token.nextToken();
			datas=tokenstring.split("~");
		//	System.out.println("tokenstring==>"+tokenstring);
//			objects.add(token.nextToken());
			 row=new ArrayList<String>();
			// System.out.println("Arrays.asList(datas);===>"+Arrays.asList(datas));
			 row=Arrays.asList(datas);
			 totalrow.add(row);
		}
		
		//System.out.println("totalrow===>"+totalrow);
		if(totalrow!=null && totalrow.size() > 0) {
			return  new ModelAndView("ExcelFormat", "ExcelDatas", totalrow);
		}
		return new ModelAndView();


	}

}
