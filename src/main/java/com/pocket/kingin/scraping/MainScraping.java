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
		scrapMoveEn("n9", "009");
		scrapPdJa("n9");
	}
	
	private static void scrapMoveEn(String code1, String code2) {
		Document doc; 
		List<MoveScraping> moves = new ArrayList<>();
		try {
			String urlBase = "https://www.serebii.net/pokedex-dp/";
			doc = Jsoup.connect(urlBase + code2 + ".shtml").get();
			
			Elements tblDex = doc.select("table.dextable");
			Element tbl;
			Elements trs;
			Element tr;
			
			String auxCaption;
			String auxName = tblDex.get(1).child(0).child(1).child(0).text();
			boolean cont = true;
			
			for (int i = tblDex.size() - 3; i > tblDex.size() - 13 && cont; i--) {
				tbl = tblDex.get(i);
				trs = tbl.child(0).children();
				auxCaption = tbl.child(0).child(0).text();
				if (auxCaption.equals("Location")) {
					cont = false;
				} else {
					for (int j = 2; j < trs.size(); j = j + 2) {
						MoveScraping move = new MoveScraping();
						tr = trs.get(j);
						
						if (auxCaption.contains("SoulSilver Level Up")) {
							move.setMoveLrnCode("lv");
							move.setMoveName(tr.child(1).text());
							move.setLv(tr.child(0).text());
							if (move.getLv().equals("—")) {
								move.setLv("1");
							}
						} else if (auxCaption.contains("TM & HM Attacks")) {
							move.setMoveLrnCode("tm");
							move.setMoveName(tr.child(1).text());
							move.setLv("0");
						} else {
							move.setMoveName(tr.child(0).text());
							move.setLv("0");
						}
							
						if (auxCaption.contains("Move Tutor Attacks")) {
							move.setMoveLrnCode("tu");
						} else if (auxCaption.contains("Egg Moves")) {
							move.setMoveLrnCode("eg");
						} else if (auxCaption.contains("Gen")) {
							move.setMoveLrnCode("tf");
						} else if (auxCaption.contains("Pre-Evolution Moves")) {
							move.setMoveLrnCode("pr");
						}
						
						move.setPdCode(code1);
						move.setPdName(auxName);
						moves.add(move);
					}
				}
			}
		} catch (IOException e) { 
			throw new RuntimeException(e); 
		}
		
		for (MoveScraping move : moves) {
			System.out.println(move.toCsv());
		}
	}
	
	
	private static void scrapPdJa(String code) {
		Document doc; 
		PdScraping pd = new PdScraping();
		try {
			String urlBase = "https://yakkun.com/dp/zukan/";
			doc = Jsoup.connect(urlBase + code + ".htm")
					.userAgent("Mozilla")
                    .header("Accept", "text/html")
                    .header("Accept-Encoding", "gzip,deflate")
                    .header("Accept-Language", "it-IT,en;q=0.8,en-US;q=0.6,de;q=0.4,it;q=0.2,ja;q=0.2")
                    .header("Connection", "keep-alive")
                    .ignoreContentType(true)
					.get();
			
			int auxInt = -1;
			String auxStr = "";
			String[] auxStrArr;
			String[] auxBase = new String[6];
			String[] auxYiel = new String[6];
			Elements tblBasicData = doc.select("table[summary=基本データ]");
			Elements tblDetailData = doc.select("table[summary=詳細データ]");
			Element tdTamago;
			Element ulType;
			
			pd.setPdCode(code);
			pd.setPdIndex(tblBasicData.get(0).child(0).child(3).child(1).text());
			pd.setPdIndex(String.valueOf(Integer.parseInt(pd.getPdIndex())));
			pd.setPdImg(pd.getPdIndex());
			pd.setPdNameJa(tblBasicData.get(0).child(0).child(0).child(0).text());
			
			ulType = tblBasicData.get(0).child(0).child(8).child(1).child(0);
			auxInt = 0;
			for (Element li : ulType.children()) {
				auxStr = li.child(0).child(0).attr("alt");
				if (auxInt == 0) {
					pd.setType1(auxStr);
				}
				if (auxInt == 1) {
					pd.setType2(auxStr);
				}
				auxInt++;
			}
			
			for (int i = 1; i < 7; i++) {
				auxStr = tblDetailData.get(0).child(0).child(i).child(1).text();
				auxStrArr = auxStr.split(" ");
				auxBase[i-1] = auxStrArr[0];
			}		
			pd.setPdBase(auxBase);
			
			for (int i = 9; i < 15; i++) {
				auxYiel[i-9] = tblDetailData.get(0).child(0).child(i).child(1).text();	
			}
			pd.setPdYiel(auxYiel);
			
			pd.setPdCapRate(tblDetailData.get(0).child(0).child(16).child(1).text());
			pd.setPdExp(tblDetailData.get(0).child(0).child(17).child(1).text());
			pd.setPdHap(tblDetailData.get(0).child(0).child(18).child(1).text());
			pd.setExpGrp(tblDetailData.get(0).child(0).child(19).child(1).text());
			
			auxStr = tblDetailData.get(0).child(0).child(20).child(1).text();
			if (auxStr.equals("ふめい")) {
				pd.setGndrNRate("100");
			} else {
				auxInt = auxStr.indexOf("オス:");
				if (auxInt > -1) {
					pd.setGndrMRate(auxStr.substring(auxInt+3, auxInt+3+4));
				}
				auxInt = auxStr.indexOf("メス:");
				if (auxInt > -1) {
					pd.setGndrFRate(auxStr.substring(auxInt+3, auxInt+3+4));
				}
			}
			
			auxStr = tblDetailData.get(0).child(0).child(22).child(1).text();
			pd.setEggCyc(auxStr.substring(0, auxStr.length()-1));
			
			tdTamago = tblDetailData.get(0).child(0).child(23).child(1);
			if (tdTamago.childNodes().size() == 1) {
				pd.setEggGrp1(tdTamago.child(0).text()); 
			} 
			if (tdTamago.childNodes().size() == 3) {
				pd.setEggGrp1(tdTamago.child(0).text()); 
				pd.setEggGrp2(tdTamago.child(1).text()); 
			}
			
			auxInt = 0;
			for (int i = 25; i < tblDetailData.get(0).child(0).childrenSize(); i++) {
				auxStr = tblDetailData.get(0).child(0).child(i).child(0).text();
				if (auxInt == 0) {
					pd.setAbil1(auxStr);
				}
				if (auxInt == 1) {
					pd.setAbil2(auxStr);
				}
				auxInt++;
			}		
						
			System.out.println(pd.toCsv());
		} catch (IOException e) { 
			throw new RuntimeException(e); 
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
