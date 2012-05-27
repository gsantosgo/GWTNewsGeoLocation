package es.uem.geonames.model;

import java.util.ArrayList;


/**
 * 
 * @author gsantos
 *
 */
public class ContinentInfos {
	private int totalResultsCount;
	private ArrayList<ContinentInfo> items;

	public ArrayList<ContinentInfo> getContent() {
		return items;
	}

	public void add(ContinentInfo item) {
		items.add(item);
	}	
}
