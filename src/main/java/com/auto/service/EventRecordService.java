package com.auto.service;

import java.util.List;

import com.auto.dto.DeviceData;
import com.auto.entity.EventRecord;

public interface EventRecordService {
	
	EventRecord saveEventRecord(EventRecord record);
	
	void saveEventRecordList(List<EventRecord> recordList);

	EventRecord getLastRecord(String itemId);

	List<DeviceData> eventRecordByGroup();
}
