package com.auto.dto;

import java.util.List;
import java.util.Map;

/**
 * Created by pangjian on 7/1/17.
 */
public class DeviceData {

    private String status;

    private Map<Integer,List<EventData>> eventDatas;

    public DeviceData() {
    }

    public DeviceData(Map<Integer, List<EventData>> eventDatas) {
        this.eventDatas = eventDatas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<Integer, List<EventData>> getEventDatas() {
        return eventDatas;
    }

    public void setEventDatas(Map<Integer, List<EventData>> eventDatas) {
        this.eventDatas = eventDatas;
    }

    /*
    public List<DeviceItemData> deviceItemDatas;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DeviceItemData> getDeviceItemDatas() {
        return deviceItemDatas;
    }

    public void setDeviceItemDatas(List<DeviceItemData> deviceItemDatas) {
        this.deviceItemDatas = deviceItemDatas;
    }*/
}
