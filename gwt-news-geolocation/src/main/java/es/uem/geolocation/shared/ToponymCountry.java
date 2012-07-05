/* Copyright (c) 2012 Guillermo Santos 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.uem.geolocation.shared;

import com.google.common.base.Objects;

/**
 * a GeoNames country/continent toponym
 * 
 * Country
 *  http://api.geonames.org/countryInfo?lang=es&username=gsantosgo&style=full
 * 	http://api.geonames.org/search?fcode=PCL&fcode=PCLD&fcode=PCLF&fcode=PCLI&fcode=PCLIX&fcode=PCLS&lang=ES&username=gsantosgo&maxRows=1000&style=full
 * 
 * <geoname>
 * 	<toponymName>Kingdom of Spain</toponymName>
 * 	<name>España</name>
 * 	<lat>40</lat>
 * 	<lng>-4</lng>
 * 	<geonameId>2510769</geonameId>
 * 	<countryCode>ES</countryCode>
 * 	<countryName>España</countryName>
 * 	<fcl>A</fcl>
 * 	<fcode>PCLI</fcode>
 * 	<fclName>country, state, region,...</fclName>
 * 	<fcodeName>independent political entity</fcodeName>
 * 	<population>46505963</population>
 * 	<alternateNames>An Spainn,An Spàinn,An Spáinn,Caxtillan,Caxtillān,Epana,Epaña,Esipanye,Esipaɲi,Espaan,Espaañ,Espagne,Espaina,Espainia,Espana,Espangne,Espanha,Espania,Espanja,Espanjja,Espanya,Espanye,Espay,España,Espánjja,Espânye,Estado Espanol,Estado Español,Gispania,Hesperia,Hisipaniya,Hispaania,Hispania,Hispanio,Hispanujo,Hiszpania,Isbeyn,Ispagna,Ispana,Ispani,Ispania,Ispanija,Ispaniya,Ispanya,Ispaña,Isponijo,Kingdom of Spain,La piel de toro,Nsipani,Orileede Sipani,Orílẹ́ède Sipani,Pain,Paniora,Pāniora,Regne d'Espanya,Reino de Espana,Reino de España,Sbaen,Sepania,Sepanyol,Sepeni,Shpanija,Sipeini,Sipen,Sipeyini,Spagn,Spagna,Spagne,Spain,Spanelsko,Spania,Spania nutome,Spanielsko,Spanien,Spanija,Spanish State,Spaniska,Spanja,Spanje,Spanjolska,Spanjë,Spann,Spanya,Spanyaen,Spanyol,Spanyolorszag,Spanyolország,Spanyän,Spayn,Spen,Spena,Speonland,Spuenien,Spánia,Spánn,Spéonland,Spānija,Spēna,Spēonland,Szpansko,Szpańskô,Tay Ban Nha,Tây Ban Nha,Uhispania,Yn Spaainey,asbanya,aspanya,aspyn,eseupanya,hspanyh,i-Spain,la Madre Patria,la pell de brau,prathes spen,sangu'e,seupein,spain,spe'ina,spen,spena,speyin,speyin‍,sprd,spyn,supein,xi ban ya,yyspanya,Èspagne,İspaniya,İspanya,Španielsko,Španija,Španiska,Španjolska,Španělsko,Ισπανία,Іспанія,Гішпанія,Испани,Испания,Испониё,Шпанија,Իսպանիա,ספרד,שפאניע,أسبانيا,إسبانيا,ئىسپانىيە,ئیسپانیا,اسبانيا,اسپانيا,اسپانیا,اسپین,سپین,هسپانیه,ہspanyہ,ہسپانیہ,ܐܣܦܢܝܐ,स्पेन,স্পেন,સ્પેઇન,સ્પેન,ସ୍ପେନ୍,ஸ்பெயின்,స్పేన్,ಸ್ಪೈನ್,സ്പെയിന്‍,සපාඤඤය,ස්පාඤ්ඤය,ประเทศสเปน,สเปน,ສະເປນ,སི་པན།,སིཔཱེན,စပန,စပိန်,ესპანეთი,ስፔን,እስፓንያ,អេស្ប៉ាញ,スペイン,西班牙,스페인,에스파냐</alternateNames><elevation/><continentCode>EU</continentCode><adminCode1>00</adminCode1><adminName1/><adminCode2/><adminName2/><alternateName lang="af">Spanje</alternateName><alternateName lang="ak">Spain</alternateName><alternateName lang="am">ስፔን</alternateName><alternateName lang="an">España</alternateName><alternateName lang="ang">Spéonland</alternateName><alternateName lang="ar">أسبانيا</alternateName><alternateName lang="arc">ܐܣܦܢܝܐ</alternateName><alternateName lang="ast">España</alternateName><alternateName lang="az">İspaniya</alternateName><alternateName lang="be">Іспанія</alternateName><alternateName lang="bg">Испания</alternateName><alternateName lang="bm">Esipaɲi</alternateName><alternateName lang="bn">স্পেন</alternateName><alternateName lang="bo">སི་པན།</alternateName><alternateName lang="br">Spagn</alternateName><alternateName lang="bs">Španija</alternateName><alternateName lang="ca">Espanya</alternateName><alternateName lang="ceb">Espanya</alternateName><alternateName lang="co">Spagna</alternateName><alternateName lang="cs">Španělsko</alternateName><alternateName lang="csb">Szpańskô</alternateName><alternateName lang="cv">Испани</alternateName><alternateName lang="cy">Sbaen</alternateName><alternateName lang="da">Spanien</alternateName><alternateName lang="de">Spanien</alternateName><alternateName lang="dz">Spain</alternateName><alternateName lang="ee">Spania nutome</alternateName><alternateName lang="el">Ισπανία</alternateName><alternateName lang="en">Spain</alternateName><alternateName lang="eo">Hispanio</alternateName><alternateName lang="es">España</alternateName><alternateName lang="et">Hispaania</alternateName><alternateName lang="eu">Espainia</alternateName><alternateName lang="fa">اسپانیا</alternateName><alternateName lang="ff">Espaañ</alternateName><alternateName lang="fi">Espanja</alternateName><alternateName lang="fo">Spania</alternateName><alternateName lang="fr">Espagne</alternateName><alternateName lang="frp">Èspagne</alternateName><alternateName lang="fur">Spagne</alternateName><alternateName lang="fy">Spanje</alternateName><alternateName lang="ga">An Spáinn</alternateName><alternateName lang="gd">An Spàinn</alternateName><alternateName lang="gl">España</alternateName><alternateName lang="gn">Epaña</alternateName><alternateName lang="gu">સ્પેન</alternateName><alternateName lang="gv">Yn Spaainey</alternateName><alternateName lang="ha">Sipen</alternateName><alternateName lang="haw">Sepania</alternateName><alternateName lang="he">ספרד</alternateName><alternateName lang="hi">स्पेन</alternateName><alternateName lang="hr">Španjolska</alternateName><alternateName lang="hsb">Španiska</alternateName><alternateName lang="ht">Espay</alternateName><alternateName lang="hu">Spanyolország</alternateName><alternateName lang="hy">Իսպանիա</alternateName><alternateName lang="ia">Espania</alternateName><alternateName lang="id">Spanyol</alternateName><alternateName lang="ilo">Espania</alternateName><alternateName lang="io">Hispania</alternateName><alternateName lang="is">Spánn</alternateName><alternateName lang="it">Spagna</alternateName><alternateName lang="ja">スペイン</alternateName><alternateName lang="jbo">sangu'e</alternateName><alternateName lang="ka">ესპანეთი</alternateName><alternateName lang="ki">Hispania</alternateName><alternateName lang="kk">Испания</alternateName><alternateName lang="kl">Spania</alternateName><alternateName lang="km">អេស្ប៉ាញ</alternateName><alternateName lang="kn">ಸ್ಪೈನ್</alternateName><alternateName lang="ko">스페인</alternateName><alternateName lang="ks">Spēna</alternateName><alternateName lang="ku">ئیسپانیا</alternateName><alternateName lang="kw">Spayn</alternateName><alternateName lang="la">Hesperia</alternateName><alternateName lang="lad">Espanya</alternateName><alternateName lang="lb">Spuenien</alternateName><alternateName lang="lg">Sipeyini</alternateName><alternateName lang="li">Spanje</alternateName><alternateName lang="link">http://en.wikipedia.org/wiki/Spain</alternateName><alternateName lang="ln">Esipanye</alternateName><alternateName lang="lo">ສະເປນ</alternateName><alternateName lang="lt">Ispanija</alternateName><alternateName lang="lu">Nsipani</alternateName><alternateName lang="lv">Spānija</alternateName><alternateName lang="mg">Espaina</alternateName><alternateName lang="mi">Pāniora</alternateName><alternateName lang="mk">Шпанија</alternateName><alternateName lang="ml">സ്പെയിന്‍</alternateName><alternateName lang="mr">स्पेन</alternateName><alternateName lang="ms">Sepanyol</alternateName><alternateName lang="mt">Spanja</alternateName><alternateName lang="my">စပိန်</alternateName><alternateName lang="na">Pain</alternateName><alternateName lang="nah">Caxtillān</alternateName><alternateName lang="nb">Spania</alternateName><alternateName lang="nd">Spain</alternateName><alternateName lang="nds">Spanien</alternateName><alternateName lang="ne">स्पेन</alternateName><alternateName lang="new">स्पेन</alternateName><alternateName lang="nl">Spanje</alternateName><alternateName lang="nn">Spania</alternateName><alternateName lang="no">Spania</alternateName><alternateName lang="nrm">Espangne</alternateName><alternateName lang="oc">Espanha</alternateName><alternateName lang="or">ସ୍ପେନ୍</alternateName><alternateName lang="os">Испани</alternateName><alternateName lang="pam">Espanya</alternateName><alternateName lang="pl">Hiszpania</alternateName><alternateName lang="pms">Spagna</alternateName><alternateName lang="ps">هسپانیه</alternateName><alternateName lang="pt">Espanha</alternateName><alternateName lang="qu">Ispaña</alternateName><alternateName lang="rm">Spagna</alternateName><alternateName lang="rn">Hisipaniya</alternateName><alternateName lang="ro">Spania</alternateName><alternateName lang="ru">Испания</alternateName><alternateName lang="sc">Ispagna</alternateName><alternateName lang="scn">Spagna</alternateName><alternateName lang="sco">Spain</alternateName><alternateName lang="se">Espánjja</alternateName><alternateName lang="sg">Espânye</alternateName><alternateName lang="sh">Španija</alternateName><alternateName lang="si">ස්පාඤ්ඤය</alternateName><alternateName lang="sk">Španielsko</alternateName><alternateName lang="sl">Španija</alternateName><alternateName lang="sn">Spain</alternateName><alternateName lang="so">Isbeyn</alternateName><alternateName lang="sq">Spanjë</alternateName><alternateName lang="sr">Шпанија</alternateName><alternateName lang="st">Spain</alternateName><alternateName lang="sv">Spanien</alternateName><alternateName lang="sw">Hispania</alternateName><alternateName lang="ta">ஸ்பெயின்</alternateName><alternateName lang="te">స్పేన్</alternateName><alternateName lang="tet">España</alternateName><alternateName lang="tg">Испониё</alternateName><alternateName lang="th">ประเทศสเปน</alternateName><alternateName lang="ti">ስፔን</alternateName><alternateName lang="tl">Espanya</alternateName><alternateName lang="to">Sipeini</alternateName><alternateName lang="tpi">Spen</alternateName><alternateName lang="tr">İspanya</alternateName><alternateName lang="ty">Paniora</alternateName><alternateName lang="udm">Испания</alternateName><alternateName lang="ug">ئىسپانىيە</alternateName><alternateName lang="uk">Іспанія</alternateName><alternateName lang="ur">ہسپانیہ</alternateName><alternateName lang="vec">Spagna</alternateName><alternateName lang="vi">Tây Ban Nha</alternateName><alternateName lang="vls">Spanje</alternateName><alternateName lang="vo">Spanyän</alternateName><alternateName lang="war">Espanya</alternateName><alternateName lang="yi">שפאניע</alternateName><alternateName lang="yo">Orílẹ́ède Sipani</alternateName><alternateName lang="zh">西班牙</alternateName><alternateName lang="zu">i-Spain</alternateName>
 * 	<bbox>
 * 		<west>-18.16964</west>
 * 		<north>43.79172</north>
 * 		<east>4.31539</east>
 * 		<south>27.63882</south>
 * 	</bbox>
 * 	<score>20.445993423461914</score>
 *  </geoname> 
 * 
 * Continent 
 * 
 * http://api.geonames.org/search?fclass=L&fcode=CONT&lang=ES&username=gsantosgo&maxRows=1000&style=full
 * 
 * <geoname>
 * 	<toponymName>Europe</toponymName>
 * 	<name>Europa</name>
 * 	<lat>48.69096</lat>
 * 	<lng>9.14062</lng>
 * 	<geonameId>6255148</geonameId>
 * 	<countryCode/>
 * 	<countryName/>
 * 	<fcl>L</fcl>
 * 	<fcode>CONT</fcode>
 * 	<fclName>parks,area, ...</fclName>
 * 	<fcodeName>continent</fcodeName>
 * 	<population/>
 * 	<alternateNames>Avrupa,Chau Au,Châu Âu,Eiropa,Eropa,Eurohpa,Eurohpá,Eurooppa,Europa,Europe,Europo,Európa,Evropa,Evrópa,Ewrop,Eŭropo,an Eoraip,awrwba,ou zhou,yoroppa,yurop,yuropa,Ευρώπη,Европа,אירופה,أوروبا,यूरोप,ยุโรป,ヨーロッパ,欧洲</alternateNames>
 * 	<elevation/>
 * 	<continentCode>EU</continentCode>
 * 	<adminCode1/>
 * 	<adminName1/>
 * 	<adminCode2/>
 * 	<adminName2/>
 * 	<alternateName lang="ar">أوروبا</alternateName><alternateName lang="bg">Европа</alternateName><alternateName lang="bs">Evropa</alternateName><alternateName lang="ca">Europa</alternateName><alternateName lang="cs">Evropa</alternateName><alternateName lang="cy">Ewrop</alternateName><alternateName lang="da">Europa</alternateName><alternateName lang="de">Europa</alternateName><alternateName lang="el">Ευρώπη</alternateName><alternateName lang="en">Europe</alternateName><alternateName lang="eo">Eŭropo</alternateName><alternateName lang="es">Europa</alternateName><alternateName lang="eu">Europa</alternateName><alternateName lang="fi">Eurooppa</alternateName><alternateName lang="fr">Europe</alternateName><alternateName lang="ga">an Eoraip</alternateName><alternateName lang="he">אירופה</alternateName><alternateName lang="hi">यूरोप</alternateName><alternateName lang="hu">Európa</alternateName><alternateName lang="id">Eropa</alternateName><alternateName lang="is">Evrópa</alternateName><alternateName lang="it">Europa</alternateName><alternateName lang="ja">ヨーロッパ</alternateName><alternateName lang="la">Europa</alternateName><alternateName lang="lt">Europa</alternateName><alternateName lang="lv">Eiropa</alternateName><alternateName lang="nb">Europa</alternateName><alternateName lang="nl">Europa</alternateName><alternateName lang="no">Europa</alternateName><alternateName lang="pl">Europa</alternateName><alternateName lang="pt">Europa</alternateName><alternateName lang="ro">Europa</alternateName><alternateName lang="ru">Европа</alternateName><alternateName lang="se">Eurohpá</alternateName><alternateName lang="sv">Europa</alternateName><alternateName lang="th">ยุโรป</alternateName><alternateName lang="tr">Avrupa</alternateName><alternateName lang="vi">Châu Âu</alternateName><alternateName lang="zh">欧洲</alternateName>
 * 	<timezone dstOffset="2.0" gmtOffset="1.0">Europe/Vaduz</timezone>
 * 	<bbox>
 * 		<west>-24.54222</west>
 * 		<north>80.76416</north>
 * 		<east>41.73304</east>
 * 		<south>27.63779</south>
 * 	</bbox>
 * 	<score>154.4808349609375</score>
 * </geoname>
 * 
 * @author Guillermo Santos (gsantosgo@yahoo.es)
 */
public class ToponymCountry extends Toponym {		
	/**
	 * 
	 */
	private static final long serialVersionUID = 2185095670165939742L;
	private String isoAlpha2; //countryCode 
	private String isoNumeric;
	private String isoAlpha3;
	private String fipsCode;
	private String continentName;	
	private String capital; 
	private double areaInSqKm;  //double	
	private String currencyCode;	
	private String languages; // es-ES,ca,gl,eu,oc	
	// <west>25.66388</west><north>81.85193</north><east>-168.98975</east><south>-10.93</south>	
	private double west;
	private double north; 
	private double east; 
	private double south;	
			
	public String getIsoAlpha2() {
		return isoAlpha2;
	}

	public void setIsoAlpha2(String isoAlpha2) {
		this.isoAlpha2 = isoAlpha2;
	}

	public String getIsoNumeric() {
		return isoNumeric;
	}

	public void setIsoNumeric(String isoNumeric) {
		this.isoNumeric = isoNumeric;
	}

	public String getIsoAlpha3() {
		return isoAlpha3;
	}

	public void setIsoAlpha3(String isoAlpha3) {
		this.isoAlpha3 = isoAlpha3;
	}

	public String getFipsCode() {
		return fipsCode;
	}

	public void setFipsCode(String fipsCode) {
		this.fipsCode = fipsCode;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public double getAreaInSqKm() {
		return areaInSqKm;
	}

	public void setAreaInSqKm(double areaInSqKm) {
		this.areaInSqKm = areaInSqKm;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	/** 
	 * @return the West 
	 */
	public double getWest() {
		return west;
	}
	
	/**
	 * 
	 * @param west
	 * 		the West
	 */
	public void setWest(double west) {
		this.west = west;
	}
	
	/** 
	 * @return the North 
	 */
	public double getNorth() {
		return north;
	}
	
	/**
	 * 
	 * @param north the North
	 */
	public void setNorth(double north) {
		this.north = north;
	}
	
	/**
	 * 
	 * @return the East
	 */
	public double getEast() {
		return east;
	}
	
	/**
	 * 
	 * @param east the East
	 */
	public void setEast(double east) {
		this.east = east;
	}
	
	/**
	 * 
	 * @return the South 
	 */
	public double getSouth() {
		return south;
	}
	
	/**
	 * 
	 * @param south the South 
	 */
	public void setSouth(double south) {
		this.south = south;
	}
	
	@Override
	public String toString() {		
		return Objects.toStringHelper(this.getClass())
				.add("toponym", super.toString())				
				.add("countryName", this.getCountryName())
				.add("countryCode", this.getCountryCode())
				.add("isoAlpha2", this.getIsoAlpha2())
				.add("isoNumeric", this.getIsoNumeric())
				.add("isoAlpha3", this.getIsoAlpha3())
				.add("fipsCode", this.getFipsCode())
				.add("continentCode", this.getContinentCode())
				.add("continentName", this.getContinentName())
				.add("capital", this.getCapital())
				.add("areaInSqKm", this.getAreaInSqKm())
				.add("currencyCode", this.getCountryCode())
				.add("languages", this.getLanguages())
				.add("west", this.getWest()) 
				.add("north", this.getNorth())
				.add("east", this.getEast())
				.add("south", this.getSouth())
				.toString();
	}
}
