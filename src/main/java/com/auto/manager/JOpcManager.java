package com.auto.manager;

import java.util.Properties;

import javafish.clients.opc.JOpc;
import javafish.clients.opc.component.OpcGroup;
import javafish.clients.opc.component.OpcItem;
import javafish.clients.opc.exception.ComponentNotFoundException;
import javafish.clients.opc.exception.SynchReadException;
import javafish.clients.opc.exception.UnableAddGroupException;
import javafish.clients.opc.exception.UnableAddItemException;
import javafish.clients.opc.property.PropertyLoader;

public class JOpcManager {
	private static Properties serverProps;
	private static JOpc opc;
	
	public static void initAndConnect() throws Exception {
		JOpc.coInitialize();
		serverProps = PropertyLoader
				.loadProperties("javafish.clients.opc.OPCServerTest");

		opc = new JOpc(serverProps.getProperty("host"),
				serverProps.getProperty("serverProgID"), "");
		opc.connect();
	}
	
	public static void unconnect() throws Exception {
		JOpc.coUninitialize();
	}

	public static OpcItem synchReadItem(OpcGroup group, OpcItem item) throws Exception {
		OpcItem backItem = null;
		try {
			initAndConnect();
			group.addItem(item);
			opc.addGroup(group);
			opc.registerGroups();
			Thread.sleep(2000);
			backItem = opc.synchReadItem(group, item);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			unconnect();
		}
		return backItem;
	}
	public static void main(String[] args) throws Exception {
//		OpcItem item = new OpcItem("Channel1.Device1.vw101", true, "");
//
//		OpcGroup group = new OpcGroup("Channel1.Device1", true, 500, 0.0f);
//		
//		OpcItem synchReadItem = synchReadItem(group, item);
//		System.out.println(synchReadItem.getValue());
	}
}
