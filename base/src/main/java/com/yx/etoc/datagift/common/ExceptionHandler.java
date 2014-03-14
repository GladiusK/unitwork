/**   
* @Title: ExceptionHandler.java 
* @Package com.yx.etoc.datagift.common 
* @Description: TODO(用一句话描述该文件做什么) 
* @author yuxuan
* @date 2014-3-7 上午7:33:45 
* @version V1.0
* <pre>
* 修改记录
*    修改后版本:     修改人：  修改日期:     修改内容:
* </pre>
*/

package com.yx.etoc.datagift.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;

/** 
 * @ClassName: ExceptionHandler 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author yuxuan
 * @date 2014-3-7 上午7:33:45 
 *  
 */
public class ExceptionHandler implements HandlerExceptionResolver {

	/* (non-Javadoc) 
	 * <p>Title: resolveException</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @return 
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception) 
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		System.out.println(request);
		request.getParameterMap();
		// TODO Auto-generated method stub
		System.out.println("错误"+ex.getMessage());
		Map m = Maps.newHashMap();
		m.put("rs", "ll");
		return new ModelAndView("", m);
	}

}
