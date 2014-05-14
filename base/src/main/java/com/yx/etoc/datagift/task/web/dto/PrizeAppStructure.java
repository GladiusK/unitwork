/**   
* @Title: PrizeAppStructure.java 
* @Package com.yx.etoc.datagift.task.web.dto 
* @Description: TODO(用一句话描述该文件做什么) 
* @author yuxuan
* @date 2014-5-6 上午7:39:40 
* @version V1.0
* <pre>
* 修改记录
*    修改后版本:     修改人：  修改日期:     修改内容:
* </pre>
*/

package com.yx.etoc.datagift.task.web.dto;

/** 
 * @ClassName: PrizeAppStructure 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author yuxuan
 * @date 2014-5-6 上午7:39:40 
 *  
 */
public class PrizeAppStructure {
	//奖项名称
	private String prizename;
	//转盘结果角度
	private int angle;
	//奖项内容
	private String prizedetail;
	public String getPrizename() {
		return prizename;
	}
	public void setPrizename(String prizename) {
		this.prizename = prizename;
	}
	public int getAngle() {
		return angle;
	}
	public void setAngle(int angle) {
		this.angle = angle;
	}
	public String getPrizedetail() {
		return prizedetail;
	}
	public void setPrizedetail(String prizedetail) {
		this.prizedetail = prizedetail;
	}
	
	
}
