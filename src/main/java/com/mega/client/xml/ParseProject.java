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
import com.mega.client.model.ProjectGroup;
import com.mega.client.service.IProjectGroupService;

/**
 * 解析项目主要信息
 * @author Andy.jia
 *
 */
@Component
public class ParseProject {

	public static final String NODE_PROJECT = "PROJECT";
	public static final String NODE_GROUP = "GROUP";
	public static final String NODE_IED = "IED";

	private Logger log = Logger.getLog(ParseProject.class);
	
	@Autowired
	private IProjectGroupService projectGroupService;

	public String  parse(String comapnyId) throws Exception {
		// 创建saxReader对象
		SAXReader reader = new SAXReader();
		// 通过read方法读取一个文件 转换成Document对象
		Document document = reader.read(new File("D:/project.pcf"));
		// 获取根节点元素对象
		Element node = document.getRootElement();

		ProjectGroup project = new ProjectGroup();
		// 遍历所有的元素节点
		listNodes(node, project);
		project.setCompanyId(comapnyId);
		log.info(project.toString());
		
		return projectGroupService.saveProjectGroup(project);
	}

	@SuppressWarnings("unchecked")
	public void listNodes(Element node, ProjectGroup project) {

		log.info("当前节点的名称：：" + node.getName());

		if (node.getName().equals(NODE_PROJECT)) {
			List<Attribute> list = node.attributes();
			for (Attribute attr : list) {
				log.info(attr.getText() + "-----" + attr.getName() + "---" + attr.getValue());
				project.setProjectName(attr.getValue());
			}
		}

		if (node.getName().equals(NODE_GROUP)) {
			List<Attribute> list = node.attributes();
			for (Attribute attr : list) {
				log.info(attr.getText() + "-----" + attr.getName() + "---" + attr.getValue());
				if (attr.getName().equals("name"))
					project.setGroupName(attr.getValue());
				if (attr.getName().equals("id"))
					project.setGroupId(attr.getValue());
			}
		}

		if (node.getName().equals(NODE_IED)) {
			List<Attribute> list = node.attributes();
			for (Attribute attr : list) {
				log.info(attr.getText() + "-----" + attr.getName() + "---" + attr.getValue());
				if (attr.getName().equals("url"))
					project.setIedUrl(attr.getValue());
			}
		}

//		if (!(node.getTextTrim().equals(""))) {
//			log.info("文本内容：：：：" + node.getText());
//		}

		// 当前节点下面子节点迭代器
		Iterator<Element> it = node.elementIterator();
		// 遍历
		while (it.hasNext()) {
			// 获取某个子节点对象
			Element e = it.next();
			// 对子节点进行遍历
			listNodes(e, project);
		}
	}
}