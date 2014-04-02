/**   
* @Title: GlobalExceptionHandle.java 
* @Package com.yx.etoc.datagift.common 
* @Description: TODO(用一句话描述该文件做什么) 
* @author yuxuan
* @date 2014-3-12 上午2:48:57 
* @version V1.0
* <pre>
* 修改记录
*    修改后版本:     修改人：  修改日期:     修改内容:
* </pre>
*/

package com.yx.etoc.datagift.common;

import java.io.UnsupportedEncodingException;

import net.sf.json.JSONException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/** 
 * @ClassName: GlobalExceptionHandle 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author yuxuan
 * @date 2014-3-12 上午12:48:57 
 *  
 */
@EnableWebMvc
@ControllerAdvice
public class GlobalExceptionHandle {
	@ExceptionHandler(JSONException.class)
	@ResponseBody
	public String test(Exception ex) {
		ex.printStackTrace();
		return  GlobalConstants.CT_PARAM_NOMACHE+ex.getMessage();
	}
}
