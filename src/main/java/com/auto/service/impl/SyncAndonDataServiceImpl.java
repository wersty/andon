package com.auto.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javafish.clients.opc.JOpc;
import javafish.clients.opc.component.OpcGroup;
import javafish.clients.opc.component.OpcItem;
import javafish.clients.opc.exception.CoInitializeException;
import javafish.clients.opc.exception.ConnectivityException;
import javafish.clients.opc.property.PropertyLoader;

import com.auto.entity.EventRecord;
import com.auto.manager.JOpcManager;
import com.auto.service.EventRecordService;
import com.auto.service.SyncAndonDataService;

@Service
@Transactional
public class SyncAndonDataServiceImpl implements SyncAndonDataService{
	
	@Autowired
	private EventRecordService eventRecordService;
	public void syncReadRecordFromAndon() throws Exception{
		// TODO 同步数据
		List<EventRecord> recordList = new LinkedList<EventRecord>();
		for (int i = 0; i < 3; i++) {
			OpcItem item = new OpcItem("Channel1.Device1.vw10"+i, true, "");
			OpcGroup group = new OpcGroup("Channel1.Device1", true, 500, 0.0f);
			OpcItem synchReadItem = JOpcManager.synchReadItem(group, item);
			if(canAdd(synchReadItem)){
				recordList.add(this.itemToEventRecord(synchReadItem));
			}
		}
		//保存数据
		eventRecordService.addEventRecordList(recordList);
	}
	private boolean canAdd(OpcItem item) {
		if(item == null){
			return false;
		}
		EventRecord record = eventRecordService.getLastRecord(item.getItemName());
		if(record == null || !record.getEventType().equals(String.valueOf(item.getValue()))){
			return true;
		}
		return false;
	}
	private EventRecord itemToEventRecord(OpcItem synchReadItem) {
		EventRecord record = new EventRecord();
		record.setGroupId(synchReadItem.getItemName());
		record.setEventType(String.valueOf(synchReadItem.getValue()));
		record.setCreateTime(synchReadItem.getTimeStamp().getTimeInMillis());
		return record;
	}
}
