package com.auto.entity;

public enum EventItemValue {
	FINISHED("103");
	private String itemValue;

	private EventItemValue(String itemValue) {
		this.setItemValue(itemValue);
	}

	public String getItemValue() {
		return itemValue;
	}

	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}

}
