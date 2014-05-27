/**   
* @Title: DataAppStructure.java 
* @Package com.yx.etoc.datagift.app.web.dto 
* @Description: TODO(用一句话描述该文件做什么) 
* @author yuxuan
* @date 2014-4-2 上午7:19:44 
* @version V1.0
* <pre>
* 修改记录
*    修改后版本:     修改人：  修改日期:     修改内容:
* </pre>
*/

package com.yx.etoc.datagift.cd.web.dto;

/** 
 * @ClassName: DataAppStructure 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author yuxuan
 * @date 2014-4-2 上午7:19:44 
 *  
 */
public class CreditDetailStructure {
	private Long date;
	private String desc;
	private String url;
	
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
