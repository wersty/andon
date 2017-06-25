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

import com.auto.entity.EventItemValue;
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
		//  同步数据
		List<EventRecord> recordList = new LinkedList<EventRecord>();
		for (int i = 0; i < 3; i++) {
			OpcItem item = new OpcItem("Channel1.Device1.vw10"+i, true, "");
			OpcGroup group = new OpcGroup("Channel1.Device1", true, 500, 0.0f);
			OpcItem synchReadItem = JOpcManager.synchReadItem(group, item);
			EventRecord lastRecord = eventRecordService.getLastRecord(item.getItemName());
			if(canAdd(synchReadItem,lastRecord)){
				if(lastRecord == null || (lastRecord != null 
						&& EventItemValue.FINISHED.getItemValue().equals(lastRecord.getItemValue()))){
					//一开始或上一条记录已经完成，开始下一组数据
					EventRecord saveEventRecord = eventRecordService.saveEventRecord(this.itemToEventRecord(synchReadItem,null));
					saveEventRecord.setGroupId(saveEventRecord.getId());
					recordList.add(saveEventRecord);
				}else{
					recordList.add(this.itemToEventRecord(synchReadItem, lastRecord.getGroupId()));
				}
			}
		}
		//保存数据
		eventRecordService.saveEventRecordList(recordList);
	}
	private boolean canAdd(OpcItem item, EventRecord record) {
		if(item == null){
			return false;
		}
		
		if(record == null || !record.getItemValue().equals(String.valueOf(item.getValue()))){
			return true;
		}
		return false;
	}
	private EventRecord itemToEventRecord(OpcItem synchReadItem, Long groupId) {
		EventRecord record = new EventRecord();
		record.setItemId(synchReadItem.getItemName());
		record.setItemValue(String.valueOf(synchReadItem.getValue()));
		record.setCreateTime(synchReadItem.getTimeStamp().getTimeInMillis());
		record.setGroupId(groupId);
		return record;
	}
}
