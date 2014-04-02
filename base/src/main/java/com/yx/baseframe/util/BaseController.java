package com.yx.baseframe.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yx.etoc.datagift.common.GlobalConstants;



/**
 * 
 * <pre>
 * Title:基础Controller类型
 * Description: 实现部分公用方法
 * </pre>
 * 
 * @author 
 * @version 1.00.00
 * 
 *          <pre>
 */
public abstract class BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 获得当前工程的url
	 */
	public String getProjectUrl() {
		// String contextPath =
		// ServletActionContext.getServletContext().getContextPath();
		String contextPath = GlobalConstants.APP_CONTEXT_PATH;
		String imgUrl = contextPath + "/";
		return imgUrl;
	}

	/**
	 * 获取Spring管理的Bean
	 * 
	 * @param beanName
	 * @return
	 */
	public Object getSpringBean(String beanName) {
		return SpringContextHolder.getBean(beanName);
	}


	/**
	 * 绕过Template,直接输出内容的简便函数.
	 */
	protected String render(String text, String contentType,
			HttpServletResponse response) {
		try {
			response.setContentType(contentType);
			response.getWriter().write(text);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 直接输出字符串.
	 */
	protected String renderText(String text, HttpServletResponse response) {
		return render(text, "text/plain;charset=UTF-8", response);
	}

	/**
	 * 直接输出HTML.
	 */
	protected String renderHtml(String html, HttpServletResponse response) {
		return render(html, "text/html;charset=UTF-8", response);
	}

	/**
	 * 直接输出XML.
	 */
	protected String renderXML(String xml, HttpServletResponse response) {
		return render(xml, "text/xml;charset=UTF-8", response);
	}

	/**
	 * 关闭窗口
	 */
	protected void closeWindow(HttpServletResponse response) {
		StringBuffer html = new StringBuffer();
		html.append("<script type=\"text/javascript\">");
		html.append("window.opener=null;");
		html.append("window.open('', '_self', '');");
		html.append("window.close();");
		html.append("</script>");
		this.renderHtml(html.toString(), response);
	}

	/**
	 * 获取HttpServletRequest对象
	 * 
	 * @return
	 */
	protected HttpServletRequest getRequest() {

		return ((ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes()).getRequest();
	}

	
	/**
	 * 工程当前真实的物理地址，weblogic war发布模式时不能获取路径
	 */
	public String getRealPath() {
		String path = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession()
				.getServletContext().getRealPath("/");
		return path;
	}

	/**
	 * 获得ContextPath
	 */
	public String getContextPath() {
		// String path = ((ServletRequestAttributes)
		// RequestContextHolder.getRequestAttributes()).getRequest()
		// .getSession().getServletContext().getServletContextName();
		// return path;

		
		// return GlobalConstants.APP_CONTEXT_PATH;
		
//		return ((ServletRequestAttributes) RequestContextHolder
//				.getRequestAttributes()).getRequest().getContextPath();
		return System.getProperty("base.root");
	}
}
