package com.thevarunshah.swotanalysistool.backend;

public class SWOTObject {
	
	private int id;
	private String name;
	private String strengths;
	private String weaknesses;
	private String opportunities;
	private String threats;
	
	public SWOTObject(int id){
		
		this.id = id;
		this.name = "SWOT " + Integer.toString(id-100);
		this.strengths = "";
		this.weaknesses = "";
		this.opportunities = "";
		this.threats = "";
	}
	
	@Override
	public String toString(){
		return this.name;
	}
	
	public int getId(){
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStrengths() {
		return strengths;
	}

	public void setStrengths(String strengths) {
		this.strengths = strengths;
	}

	public String getWeaknesses() {
		return weaknesses;
	}

	public void setWeaknesses(String weaknesses) {
		this.weaknesses = weaknesses;
	}

	public String getOpportunities() {
		return opportunities;
	}

	public void setOpportunities(String opportunities) {
		this.opportunities = opportunities;
	}

	public String getThreats() {
		return threats;
	}

	public void setThreats(String threats) {
		this.threats = threats;
	}

}
