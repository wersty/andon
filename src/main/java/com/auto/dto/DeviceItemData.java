package com.auto.dto;

import java.util.List;

/**
 * Created by pangjian on 7/1/17.
 */
public class DeviceItemData {

    private int groupId;

    private List<EventData> eventDatas;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<EventData> getEventDatas() {
        return eventDatas;
    }

    public void setEventDatas(List<EventData> eventDatas) {
        this.eventDatas = eventDatas;
    }
}
