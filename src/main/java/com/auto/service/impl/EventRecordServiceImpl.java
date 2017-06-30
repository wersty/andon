package com.auto.service.impl;

import java.util.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.auto.dto.DeviceData;
import com.auto.dto.EventData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.auto.dao.EventRecordDao;
import com.auto.entity.EventRecord;
import com.auto.service.EventRecordService;

@Service
@Transactional
public class EventRecordServiceImpl implements EventRecordService{

	@Autowired
	private EventRecordDao eventRecordDao;
	
	@Override
	public EventRecord saveEventRecord(EventRecord record) {
		return eventRecordDao.save(record);
	}

	@Override
	public void saveEventRecordList(List<EventRecord> recordList) {
		eventRecordDao.save(recordList);
	}

	@Override
	public EventRecord getLastRecord(final String itemId) {
		java.util.List<Order> list = new ArrayList<Order>();
		Order order = new Order(Direction.DESC, "createTime");
		list.add(order);
		Sort sort = new Sort(list);
		
		Specification<EventRecord> specification = new Specification<EventRecord>() {

			@Override
			public Predicate toPredicate(Root<EventRecord> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate p=cb.equal(root.get("itemId").as(String.class), itemId);  
				return p;
			}
		};
		List<EventRecord> eventList = eventRecordDao.findAll(specification, sort);
		if(eventList.isEmpty()){
			return null;
		}
		return eventList.get(0);
	}

	@Override
	public List<DeviceData> eventRecordByGroup() {
		String devicePre = "Channel1.Device1.vw";
		List<String> devices = Arrays.asList(devicePre+"100",devicePre+"101",devicePre+"102",devicePre+"103");

		List<DeviceData> resultList = new ArrayList<DeviceData>();

		for (String device :devices) {
			List<EventRecord> eventRecords = eventRecordDao.queryByGroup(device);

			DeviceData deviceData = this.subGroup(eventRecords);
			resultList.add(deviceData);
		}

		return resultList;
	}

	private DeviceData subGroup(List<EventRecord> list){

		list.sort(new Comparator<EventRecord>() {
			public int compare(EventRecord o1, EventRecord o2) {
				return Integer.valueOf((o1.getCreateTime() - o2.getCreateTime())+"");
			}
		});

		Map<Integer,List<EventData>> mapEvents = new LinkedHashMap<>();


		List<EventRecord> subEventRecordList = new LinkedList<>();
		for (int i=0;i<list.size();i++) {
			EventRecord eventRecord = list.get(i);

			if(eventRecord.getItemValue().equals("100")){
				subEventRecordList = list.subList(i, list.size());
				break;
			}
		}

		for (int i=0;i<subEventRecordList.size();i++) {
			EventRecord eventRecord = list.get(i);

			EventData eventData = EventData.toEventData(eventRecord);

			if(mapEvents.containsKey(eventRecord.getGroupId())){
				mapEvents.get(eventRecord.getGroupId()).add(eventData);
			}else{
				List<EventData> subList = new ArrayList<>();
				subList.add(eventData);
				mapEvents.put(eventRecord.getGroupId(),subList);
			}
		}



		return new DeviceData(mapEvents);
	}
}
