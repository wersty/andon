package com.auto.service;

import java.util.List;

import com.auto.entity.EventRecord;

public interface EventRecordService {
	
	void addEventRecord(EventRecord record);
	
	void addEventRecordList(List<EventRecord> recordList);

	EventRecord getLastRecord(String itemId);
}
