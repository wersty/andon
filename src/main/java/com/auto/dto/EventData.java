package com.auto.dto;

import com.auto.entity.EventRecord;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pangjian on 7/1/17.
 */
public class EventData {

    private int id;

    private String itemId;

    private String createTime;

    private String itemValue;

    public EventData(){}

    public EventData(int id, String itemId, String itemValue) {
        this.id = id;
        this.itemId = itemId;
        this.itemValue = itemValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    public static EventData toEventData(EventRecord record)  {
        EventData eventData = new EventData(record.getId(),record.getItemId(),record.getItemValue());

        Date date = new Date(record.getCreateTime());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = formatter.format(date);

        eventData.setCreateTime(createTime);

        return eventData;
    }
}
