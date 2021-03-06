package com.auto.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.auto.entity.EventRecord;

@Repository
public interface EventRecordDao extends PagingAndSortingRepository<EventRecord, Long>, JpaSpecificationExecutor<EventRecord> {

    @Query("from EventRecord t where id = :id")
    List<EventRecord> queryFamilyList(@Param("id") Long id, Pageable pageable);

    @Query(value = "select * from event_record t where item_id = :itemId order by id desc limit 0,50",nativeQuery = true)
    List<EventRecord> queryByGroup(@Param("itemId") String itemId);

}
