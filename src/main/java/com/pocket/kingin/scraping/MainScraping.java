package com.pocket.kingin.scraping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.ResourceUtils;

public class MainScraping {

	public static void main(String[] args) {
		String methodName = "scrapItemEn";
		switch (methodName) {
		case "scrapItemEn": {
			scrapItemEn();
			break;
		}
		case "scrapPdJa": {
			scrapPdJa();
			break;
		}
		default:
			System.out.println(methodName);
		}

	}
	
	private static void scrapPdJa() {
		Document doc;
		List<ItemScraping> items = new ArrayList<>();
		try {
			File file = ResourceUtils.getFile("classpath:item.csv");
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				String line;
				while ((line = br.readLine()) != null) {
					String[] values = line.split(",");
					ItemScraping item = new ItemScraping();
					item.setItemCode(values[0]);
					item.setItemImg(values[1]);
					item.setItemNameEn(values[2]);
					items.add(item);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < items.size(); i++) {
			ItemScraping item = items.get(i);
			String auxStr = "";
			String[] auxArr;
			try {
				String urlBase = "";
				doc = Jsoup.connect(urlBase + item.getItemCode() + ".html").get();			
			} catch (IOException e) { 
				throw new RuntimeException(e); 
			}
		}
	}

	private static void scrapItemEn() {
		Document doc; 
		List<ItemScraping> items = new ArrayList<>();
		try {
			File file = ResourceUtils.getFile("classpath:item.csv");
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				String line;
				while ((line = br.readLine()) != null) {
					String[] values = line.split(",");
					ItemScraping item = new ItemScraping();
					item.setItemCode(values[0]);
					item.setItemImg(values[1]);
					item.setItemNameEn(values[2]);
					items.add(item);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		for (int i = 0; i < items.size(); i++) {
			ItemScraping item = items.get(i);
			String auxStr = "";
			String[] auxArr;
			try {
				String urlBase = "";
				doc = Jsoup.connect(urlBase + item.getItemCode() + ".html").get();
				Elements tables = doc.select("table.dextable");
				/*Item Type*/
				item.setItemPktCode(tables.get(1).child(0).child(1).child(1).text());
				/*Japanese Name*/
				auxStr = tables.get(1).child(0).child(1).child(2).text();
				auxArr = auxStr.split(" ");
				item.setItemNameJa(auxArr[0]);
				/*In-Depth Effect*/
				switch (item.getItemPktCode()) {
				case "Berry":
					for (int j = 0; j < tables.size(); j++) {
						Element table = tables.get(j);
						if (table.child(0).childNodeSize() == 20) {
							item.setItemDescEn(table.child(0).child(3).text());
						}
					}
					break;
				case "Mail":
				case "Miscellaneous":
				case "Key Item":
					for (int j = 0; j < tables.size(); j++) {
						Element table = tables.get(j);
						if (table.child(0).child(0).text().equals("Flavour Text")) {
							Elements trs = tables.get(j).child(0).children();
							for (int k = 0; k < trs.size(); k++) {
								Element tr = trs.get(k);	
								if (tr.child(0).text().equals("HeartGold")) {
									item.setItemDescEn(tr.child(2).text());		
								}
							}
						}
					}
					break;
				default:
					for (int j = 0; j < tables.size(); j++) {
						Element table = tables.get(j);
						if (table.child(0).child(0).text().equals("In-Depth Effect")) {
							item.setItemDescEn(table.child(0).child(1).text());		
						}
					}
					break;
				}
				item.setItemTypeCode("item");
				System.out.println(item.toCsv());
			} catch (IOException e) { 
				throw new RuntimeException(e); 
			}
		}
	}
}
