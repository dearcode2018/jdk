/**
  * @filename UserAgent.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.agent;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import com.hua.bean.User;

 /**
 * @type UserAgent
 * @description  
 * @author qianye.zheng
 */
public final class UserAgent {

	/**
	 * 
	 * @description 启动
	 * @param domain 域名
	 * @param name MBean名称
	 * 域名:name=MBean名称
	 * @author qianye.zheng
	 */
	public static final void start(final String domain, final String name)
	{
		//final MBeanServer server = MBeanServerFactory.createMBeanServer();
		// 获取 平台MBean服务器
		final MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		
		try {
			final ObjectName objectName = new ObjectName("com.hua:name=UserMBean");
			// 注册MBean
			server.registerMBean(new User(), objectName);
			final ObjectName adaptorName = new ObjectName("UserAgent:htmlAdaptor,port=8080");
			
		} catch (MalformedObjectNameException e) {
			e.printStackTrace();
		} catch (InstanceAlreadyExistsException e) {
			e.printStackTrace();
		} catch (MBeanRegistrationException e) {
			e.printStackTrace();
		} catch (NotCompliantMBeanException e) {
			e.printStackTrace();
		}
	}
}
