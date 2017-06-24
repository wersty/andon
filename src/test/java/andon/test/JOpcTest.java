package andon.test;


import java.util.Properties;

import javafish.clients.opc.JOpc;
import javafish.clients.opc.component.OpcGroup;
import javafish.clients.opc.component.OpcItem;
import javafish.clients.opc.exception.CoInitializeException;
import javafish.clients.opc.exception.ComponentNotFoundException;
import javafish.clients.opc.exception.ConnectivityException;
import javafish.clients.opc.exception.SynchReadException;
import javafish.clients.opc.exception.SynchWriteException;
import javafish.clients.opc.exception.UnableAddGroupException;
import javafish.clients.opc.exception.UnableAddItemException;
import javafish.clients.opc.property.PropertyLoader;
import javafish.clients.opc.variant.Variant;
import junit.framework.TestCase;

public class JOpcTest extends TestCase {

	private Properties serverProps;
	private JOpc opc;
	private OpcGroup group;
	private OpcGroup group2;
	private OpcItem item1;
	private OpcItem itemWrite;

	@Override
	protected void setUp() throws Exception {
		serverProps = PropertyLoader
				.loadProperties("javafish.clients.opc.OPCServerTest");

		opc = new JOpc(serverProps.getProperty("host"),
				serverProps.getProperty("serverProgID"), "");

		item1 = new OpcItem("Channel1.Device1.vw101", true, "");
		// item1.setValue(new Variant(1));

		itemWrite = new OpcItem("Channel1.Device1.m0", true, "");

		group = new OpcGroup("Channel1.Device1", true, 500, 0.0f);

		group.addItem(item1);
		group.addItem(itemWrite);
		// opc.addGroup(group);
		try {
			JOpc.coInitialize();
		} catch (CoInitializeException e1) {
			fail(e1.getMessage());
		}

		try {
			opc.connect();
			/*
			 * opc.registerGroups(); opc.registerItem(group, item1);
			 * opc.synchWriteItem(group, item1);
			 */
		} catch (ConnectivityException e2) {
			fail(e2.getMessage());
		}
	}

	public void testSynchReadItem() {
		OpcItem item;
		try {
			item = opc.synchReadItem(null, null);
			assertTrue(false);
		} catch (ComponentNotFoundException e) {
			assertTrue(true);
		} catch (SynchReadException e) {
			fail(e.getMessage());
		}

		try {
			opc.synchReadItem(group, item1);
			assertTrue(false);
		} catch (ComponentNotFoundException e) {
			assertTrue(true);
		} catch (SynchReadException e) {
			fail(e.getMessage());
		}

		opc.addGroup(group);

		try {
			item = opc.synchReadItem(group, item1);
			assertTrue(false);
		} catch (ComponentNotFoundException e) {
			fail(e.getMessage());
		} catch (SynchReadException e) {
			assertTrue(true);
		}

		try {
			opc.registerGroups();
		} catch (UnableAddGroupException e) {
			fail(e.getMessage());
		} catch (UnableAddItemException e) {
			fail(e.getMessage());
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			fail(e1.getMessage());
		}

		try {
			item = opc.synchReadItem(group, item1);
			assertEquals(item1.getItemName(), item.getItemName());
			assertTrue(item.isQuality());
		} catch (ComponentNotFoundException e) {
			fail(e.getMessage());
		} catch (SynchReadException e) {
			fail(e.getMessage());
		}
	}

	public void testSynchWriteItem() {
		OpcItem item;
		try {
			opc.synchWriteItem(null, null);
			assertTrue(false);
		} catch (ComponentNotFoundException e) {
			assertTrue(true);
		} catch (SynchWriteException e) {
			fail(e.getMessage());
		}

		try {
			opc.synchWriteItem(group, item1);
			assertTrue(false);
		} catch (ComponentNotFoundException e) {
			assertTrue(true);
		} catch (SynchWriteException e) {
			fail(e.getMessage());
		}

		opc.addGroup(group);

		try {
			opc.synchWriteItem(group, item1);
			assertTrue(false);
		} catch (ComponentNotFoundException e) {
			fail(e.getMessage());
		} catch (SynchWriteException e) {
			assertTrue(true);
		}

		try {
			opc.registerGroups();
		} catch (UnableAddGroupException e) {
			fail(e.getMessage());
		} catch (UnableAddItemException e) {
			fail(e.getMessage());
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}

		itemWrite.setValue(new Variant(0));

		try {
			//opc.registerItem(group, itemWrite);
			opc.synchWriteItem(group, itemWrite);
			assertTrue(true);
		} catch (ComponentNotFoundException e) {
			fail(e.getMessage());
		} catch (SynchWriteException e) {
			fail(e.getMessage());
		} 

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}

		try {
			item = opc.synchReadItem(group, itemWrite);
			assertTrue(item.isQuality());
			assertEquals("Compare input/output", itemWrite.getValue()
					.getDouble(), item.getValue().getDouble(), 0.001);
		} catch (ComponentNotFoundException e) {
			fail(e.getMessage());
		} catch (SynchReadException e) {
			fail(e.getMessage());
		}
	}

}
