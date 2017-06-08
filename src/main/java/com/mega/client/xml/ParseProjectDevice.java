package com.mega.client.xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bstek.dorado.console.Logger;
import com.bstek.dorado.core.Context;
import com.mega.client.model.ProjectDevice;
import com.mega.client.model.ProjectIed;
import com.mega.client.model.ProjectIedPort;
import com.mega.client.service.IProjectDeviceService;
import com.mega.client.service.IProjectIedPortService;
import com.mega.client.service.IProjectIedService;

/**
 * 解析项目详细信息
 * @author Andy.jia
 *
 */
@Component
public class ParseProjectDevice {

	private Logger log = Logger.getLog(ParseProjectDevice.class);
	
	public static final String NODE_IED = "IED";
	public static final String NODE_PORT = "port";
	public static final String NODE_DEVICE = "Device";
	
	public static final String SESSION_IED_ID = "SESSION_IED_ID";
	public static final String SESSION_PORT_ID = "SESSION_PORT_ID";
	
	@Autowired
	private IProjectDeviceService projectDeviceService;
	@Autowired
	private IProjectIedPortService projectIedPortService;
	@Autowired
	private IProjectIedService projectIedService;
	
	
	public void parse(String groupId) throws Exception {
		// 创建saxReader对象
		SAXReader reader = new SAXReader();
		// 通过read方法读取一个文件 转换成Document对象
		Document document = reader.read(new File("D:/10.1.20.100.dcf"));
		// 获取根节点元素对象
		Element node = document.getRootElement();

		// 遍历所有的元素节点
		listNodes(node,groupId);
		
	}

	@SuppressWarnings("unchecked")
	public void listNodes(Element node,String groupId) {

		log.info("当前节点的名称：" + node.getName());
		
		if(node.getName().equals(NODE_IED)){
			parseIED(node,groupId);
		}
		
		if(node.getName().equals(NODE_PORT)){
			parsePort(node);
		}
		
		if(node.getName().equals(NODE_DEVICE)){
			parseDevice(node);
		}
		
		
		// 当前节点下面子节点迭代器
		Iterator<Element> it = node.elementIterator();
		// 遍历
		while (it.hasNext()) {
			// 获取某个子节点对象
			Element e = it.next();
			// 对子节点进行遍历
			listNodes(e,groupId);
		}
	}
	
	/**
	 * 解析ProjectDevice
	 * @param node
	 */
	@SuppressWarnings("unchecked")
	private void parseDevice(Element node) {
		ProjectDevice device = new ProjectDevice();
		List<Attribute> list = node.attributes();
		for (Attribute attr : list) {
			//System.out.println(attr.getText() + "-----" + attr.getName() + "---" + attr.getValue());
			if(attr.getName().equals("name")) device.setName(attr.getValue());
			if(attr.getName().equals("address")) device.setAddress(attr.getValue());
			if(attr.getName().equals("libname")) device.setLibname(attr.getValue());
			if(attr.getName().equals("cfgname")) device.setCfgname(attr.getValue());
			if(attr.getName().equals("valid")) device.setValid(attr.getValue());
		}
		
		//保存数据
		log.info(device.toString());
		String portId = (String) Context.getCurrent().getAttribute(SESSION_PORT_ID);
		device.setPortId(portId);
		
		projectDeviceService.saveProjectDevice(device);
	}

	/**
	 * 解析对象ProjectIdePort
	 * @param node
	 */
	@SuppressWarnings("unchecked")
	private void parsePort(Element node) {
		ProjectIedPort port = new ProjectIedPort();
		List<Attribute> list = node.attributes();
		for (Attribute attr : list) {
			//System.out.println(attr.getText() + "-----" + attr.getName() + "---" + attr.getValue());
			if(attr.getName().equals("com")) port.setCom(attr.getValue());
			if(attr.getName().equals("name")) port.setName(attr.getValue());
			if(attr.getName().equals("mode")) port.setMode(attr.getValue());
			if(attr.getName().equals("baudrate")) port.setBaudrate(attr.getValue());
			if(attr.getName().equals("databits")) port.setDatabits(attr.getValue());
			if(attr.getName().equals("stopbits")) port.setStopbits(attr.getValue());
			if(attr.getName().equals("parity")) port.setParity(attr.getValue());
			if(attr.getName().equals("flowcontrol")) port.setFlowcontrol(attr.getValue());
			if(attr.getName().equals("delay")) port.setDelay(attr.getValue());
			if(attr.getName().equals("valid")) port.setValid(attr.getValue());
		}
		//保存数据
		log.info(port.toString());
		
		String iedId = (String) Context.getCurrent().getAttribute(SESSION_IED_ID);
		port.setIedId(iedId);
		
		String portId = projectIedPortService.saveProjectIdePort(port);
		Context.getCurrent().setAttribute(SESSION_PORT_ID, portId);
	}

	/**
	 * 解析对象ProjectIed
	 * @param node
	 */
	@SuppressWarnings("unchecked")
	private void parseIED(Element node,String groupId) {
		ProjectIed ide = new ProjectIed();
		List<Attribute> list = node.attributes();
		//Field[] field = ide.getClass().getDeclaredFields();
		for (Attribute attr : list) {
			//System.out.println(attr.getText() + "-----" + attr.getName() + "---" + attr.getValue());
			if(attr.getName().equals("id")) ide.setId(attr.getValue());
			if(attr.getName().equals("name")) ide.setName(attr.getValue());
			if(attr.getName().equals("timestamp")) ide.setTimestamp(attr.getValue());
			if(attr.getName().equals("description")) ide.setDescription(attr.getValue());
			if(attr.getName().equals("address")) ide.setAddress(attr.getValue());
			if(attr.getName().equals("personnel")) ide.setPersonnel(attr.getValue());
			if(attr.getName().equals("telphone")) ide.setTelphone(attr.getValue());
			if(attr.getName().equals("valid")) ide.setValid(attr.getValue());
			if(attr.getName().equals("watchdoginterval")) ide.setWatchdoginterval(attr.getValue());
			if(attr.getName().equals("manufacture")) ide.setManufacture(attr.getValue());
			if(attr.getName().equals("guarantee")) ide.setGuarantee(attr.getValue());
			if(attr.getName().equals("model")) ide.setModel(attr.getValue());
			if(attr.getName().equals("parametric")) ide.setParametric(attr.getValue());
			if(attr.getName().equals("remark")) ide.setRemark(attr.getValue());
			if(attr.getName().equals("factory")) ide.setFactory(attr.getValue());
			if(attr.getName().equals("factorytel")) ide.setFactorytel(attr.getValue());
			if(attr.getName().equals("factoryaddress")) ide.setFactoryaddress(attr.getValue());
			if(attr.getName().equals("productimagename")) ide.setProductimagename(attr.getValue());
			if(attr.getName().equals("structureimagename")) ide.setStructureimagename(attr.getValue());
		}
		
		ide.setGroupId(groupId);
		log.info(ide.toString());
		//保存数据
		String iedId = projectIedService.saveProjectIed(ide);
		Context.getCurrent().setAttribute(SESSION_IED_ID, iedId);
	}

//	public static void main(String[] args) {
//		ParseProjectDevice pd = new ParseProjectDevice();
//		try {
//			pd.parse("110");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}