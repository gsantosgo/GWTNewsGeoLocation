/*
 * Copyright 2008 Marc Wick, geonames.org
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
 *
 */
package es.uem.geonames.ws;

import org.geonames.Toponym;

import com.google.common.base.Objects;

/**
 * a GeoNames toponym
 * 
 * @author marc@geonames
 * 
 */
public class ToponymContinent extends Toponym {
	
	// <bbox><west>25.66388</west><north>81.85193</north><east>-168.98975</east><south>-10.93</south></bbox>
	private double west;
	private double north; 
	private double east; 
	private double south;	
	private double score;
	
	/** 
	 * @return the BBOX west 
	 */
	public double getWest() {
		return west;
	}
	
	/**
	 * 
	 * @param west
	 * 		the BBOX west
	 */
	public void setWest(double west) {
		this.west = west;
	}
	
	/** 
	 * @return the BBOX north 
	 */
	public double getNorth() {
		return north;
	}
	
	/**
	 * 
	 * @param north the BBOX north
	 */
	public void setNorth(double north) {
		this.north = north;
	}
	
	/**
	 * 
	 * @return the BBOX east
	 */
	public double getEast() {
		return east;
	}
	
	/**
	 * 
	 * @param east the BBOX east
	 */
	public void setEast(double east) {
		this.east = east;
	}
	
	/**
	 * 
	 * @return the BBOX south 
	 */
	public double getSouth() {
		return south;
	}
	
	/**
	 * 
	 * @param south the BBOX south 
	 */
	public void setSouth(double south) {
		this.south = south;
	}
	
	/**
	 * 
	 * @return the Score 
	 */
	public double getScore() {
		return score;
	}
	
	/**
	 * 
	 * @param score Score 
	 */
	public void setScore(double score) {
		this.score = score;
	} 

	@Override
	public String toString() {		
		return Objects.toStringHelper(this.getClass())
				.add("toponym", super.toString())
				.add("west", this.getWest()) 
				.add("north", this.getNorth())
				.add("east", this.getEast())
				.add("south", this.getSouth())
				.add("score", this.getScore())
				.toString();
	}
}
