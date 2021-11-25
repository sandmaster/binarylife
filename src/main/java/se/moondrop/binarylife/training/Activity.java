package se.moondrop.binarylife.training;

import org.springframework.stereotype.Component;

/**
 * Represent a training moment - example walk
 */
@Component
public class Activity {

	private String name;
	private String description = "No description";
	private double remValue;

	public Activity() {	}

	public Activity(String name, String desc, double remValue) {
		this.name = name;
		this.description = desc;
		this.remValue = remValue;
	}

	public Activity(String name, double remValue) {
		this.name = name;
		this.remValue = remValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRemValue() {
		return remValue;
	}

	public void setRemValue(double remValue) {
		this.remValue = remValue;
	}

	public String toString(){
		return name + " (" + description + ") with a rem value of " + remValue;
	}
}
