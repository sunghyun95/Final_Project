package upload.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import books.data.BooksDto;
import files.data.ProcessFilesDto;

public class WebCrawling {
	
	
	public List<String> booksImageCrawling(List<BooksDto> booksdto) {
		
		List<String> booksImages = new Vector<String>();
		
			if(booksdto != null) {				
				for(BooksDto dto : booksdto) {
					String bookname = dto.getBooks_name();
					String URL = "https://search.kyobobook.co.kr/web/search?vPstrKeyWord="+bookname+"&orderClick=LAG";
					Document doc;
					try {
						doc = Jsoup.connect(URL).get();
						Elements elem = doc.select("table.type_list > tbody#search_list > tr > td.image > div.cover > a > img");
						
						System.out.println(elem.toString());
						if(elem.size() > 0) {
							String src = elem.get(0).attr("src");
							
							booksImages.add(src);
						}
						
						//Elements elem2 = doc.select("input.btn_search");
						//System.out.println(elem.toString());
						///System.out.println("============================");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
		return booksImages;
	}
	
	
	
	public Map<String,List<String>> getHireList(String searchtxt){
		
		Map<String,List<String>> hirelist = new HashMap<String,List<String>>();
		
		List<String> hiresubject = new Vector<String>();
		List<String> hirehref = new Vector<String>();
		
		List<String> corpname = new Vector<String>();
		List<String> corphref = new Vector<String>();
		
		List<String> enddates = new Vector<String>();
		String URL = "http://www.saramin.co.kr/zf_user/search?search_area=main&search_done=y&search_optional_item=n&searchType=default_mysearch&searchword="+searchtxt;
		Document doc;
		try {
			doc = Jsoup.connect(URL).get();
			Elements elem = doc.select("div#recruit_info_list > div.content > div.item_recruit > div.area_job > h2.job_tit > a");
			
			for(Element e : elem)
			{
				hiresubject.add(e.attr("title"));
				hirehref.add("http://www.saramin.co.kr"+e.attr("href"));
			}
			
			Elements elem2 = doc.select("div#recruit_info_list > div.content > div.item_recruit > div.area_corp > strong.corp_name > a");
			for(Element e : elem2)
			{
				corpname.add(e.attr("title"));
				corphref.add("http://www.saramin.co.kr"+e.attr("href"));
			}
			
			Elements elem3 = doc.select("div#recruit_info_list > div.content > div.item_recruit > div.area_job > div.job_date > span.date");
			for(Element e : elem3)
			{
				enddates.add(e.text());
			}
			
			hirelist.put("hiresubject", hiresubject);
			hirelist.put("hirehref",hirehref);
			hirelist.put("corpname",corpname);
			hirelist.put("corphref",corphref);
			hirelist.put("enddates",enddates);
			
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return hirelist;
		
	}
}
