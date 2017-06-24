package com.auto.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

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
	public void addEventRecord(EventRecord record) {
		eventRecordDao.save(record);
	}

	@Override
	public void addEventRecordList(List<EventRecord> recordList) {
		eventRecordDao.save(recordList);
	}

	@Override
	public EventRecord getLastRecord(final String groupId) {
		java.util.List<Order> list = new ArrayList<Order>();
		Order order = new Order(Direction.DESC, "createTime");
		list.add(order);
		Sort sort = new Sort(list);
		
		Specification<EventRecord> specification = new Specification<EventRecord>() {

			@Override
			public Predicate toPredicate(Root<EventRecord> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate p=cb.equal(root.get("groupId").as(String.class), groupId);  
				return p;
			}
		};
		List<EventRecord> eventList = eventRecordDao.findAll(specification, sort);
		return eventList.get(0);
	}


}
