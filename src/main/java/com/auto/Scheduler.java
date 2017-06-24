package com.auto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.auto.service.SyncAndonDataService;

@Component 
public class Scheduler {  
	@Autowired
	private SyncAndonDataService syncAndonDataService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());  
      
//    @Scheduled(cron="0 0/1 * * * ?") //每分钟执行一次  
//    public void statusCheck() {      
//        logger.info("每分钟执行一次。开始……");  
//        //statusTask.healthCheck();  
//        logger.info("每分钟执行一次。结束。");  
//    }    
  
    @Scheduled(fixedRate=50000)  
    public void testTasks() throws Exception {      
        logger.info("每5秒执行一次。开始……");  
        syncAndonDataService.syncReadRecordFromAndon();
        logger.info("每5秒执行一次。结束。");  
    }    
}  