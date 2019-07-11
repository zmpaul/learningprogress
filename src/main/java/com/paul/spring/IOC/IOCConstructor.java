package com.paul.spring.IOC;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.paul.base.bean.Child;

/**
 * 手写简单IOC
 * 步骤：1 读取XML
 * 2.解析XML 获取bean各个属性
 * 3.利用反射注入bean
 * 4.放入bean容器(map)
 * 
 * @ClassName: IOCConstructor
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author admin
 * @date 2019年7月9日 下午4:41:53
 * @param <T>
 */
public class IOCConstructor {

    public static Map<String, Object> beanMap = new HashMap<String, Object>();

    public static void loadProperties()
            throws SAXException, IOException, ParserConfigurationException, ClassNotFoundException,
 InstantiationException,
 IllegalAccessException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException {
        String xmlfile =
                IOCConstructor.class.getClassLoader().getResource("").toString().substring(6)
                        + "config/spring/ioc.xml";
        // 1 读取XML
        Document document =
                DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(xmlfile));
        Element docEle = document.getDocumentElement();
        // 2.解析XML 获取bean各个属性
        NodeList databaseList = docEle.getElementsByTagName("bean");
        for (int i = 0; i < databaseList.getLength(); i++) {
            Node node = databaseList.item(i);
            if (!(node instanceof Element)) {
                continue;
            }
            String name = node.getAttributes().getNamedItem("name").getNodeValue();
            String className = node.getAttributes().getNamedItem("class").getNodeValue();
            Object bean = Class.forName(className).newInstance();
            Field[] fields = bean.getClass().getDeclaredFields();
            NodeList nodeList = node.getChildNodes();
            int nodeList_length = nodeList.getLength();
            for (int j = 0; j < nodeList_length; j++) {
                Node properties = nodeList.item(j);
                if (!(properties instanceof Element)) {
                    continue;
                }
                String node_name = properties.getAttributes().getNamedItem("name").getNodeValue();
                String node_value = properties.getAttributes().getNamedItem("value").getNodeValue();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String setMethod = "set" + node_name.substring(0, 1).toUpperCase()
                            + node_name.substring(1);
                    Method methed =
                            Class.forName(className).getDeclaredMethod(setMethod, String.class);
                    // 利用反射注入bean
                    methed.invoke(bean, node_value);
                }
            }
            // 4.放入bean容器(map)
            beanMap.put(name, bean);
            Child child = (Child)beanMap.get("child");
            System.out.println("name:" + child.getName() + " sex: " + child.getSex());
        }
    }

    public static void main(String[] args)
            throws SAXException, IOException, ParserConfigurationException, ClassNotFoundException,
            InstantiationException, IllegalAccessException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException {
        loadProperties();
    }
}
