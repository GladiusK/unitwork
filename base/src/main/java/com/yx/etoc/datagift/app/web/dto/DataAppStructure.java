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

package com.yx.etoc.datagift.app.web.dto;

/** 
 * @ClassName: DataAppStructure 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author yuxuan
 * @date 2014-4-2 上午7:19:44 
 *  
 */
public class DataAppStructure {
	public static class AppProduct {
		private String appid;//id
		private String name;//应用名
		private String pkgname;//包名
		private String icon;//图标url
		private String[] previewUrl;//详情url
		private String[] steps;//活动步骤
		private String intro;//简介
		private String downnum;//应用下载次数
		private APKFile apk;//apk文件
		private String type;//奖励类型  积分  流量
		private String point;//奖励积分
		private String exp;//奖励经验
		private String data;//奖励流量
		
		public String getAppid() {
			return appid;
		}
		public void setAppid(String appid) {
			this.appid = appid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPkgname() {
			return pkgname;
		}
		public void setPkgname(String pkgname) {
			this.pkgname = pkgname;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public String[] getPreviewUrl() {
			return previewUrl;
		}
		public void setPreviewUrl(String[] previewUrl) {
			this.previewUrl = previewUrl;
		}
		public String[] getSteps() {
			return steps;
		}
		public void setSteps(String[] steps) {
			this.steps = steps;
		}
		public String getIntro() {
			return intro;
		}
		public void setIntro(String intro) {
			this.intro = intro;
		}
		public String getDownnum() {
			return downnum;
		}
		public void setDownnum(String downnum) {
			this.downnum = downnum;
		}
		public APKFile getApk() {
			return apk;
		}
		public void setApk(APKFile apk) {
			this.apk = apk;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getPoint() {
			return point;
		}
		public void setPoint(String point) {
			this.point = point;
		}
		public String getExp() {
			return exp;
		}
		public void setExp(String exp) {
			this.exp = exp;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		
	}
	
	public static class APKFile {
		private String localpath;   //apk文件本地路径
		private String remotepath;  //apk文件服务器路径
		private String filesize;    //文件大小(Byte)
		private String filename;
		public String getLocalpath() {
			return localpath;
		}
		public void setLocalpath(String localpath) {
			this.localpath = localpath;
		}
		public String getRemotepath() {
			return remotepath;
		}
		public void setRemotepath(String remotepath) {
			this.remotepath = remotepath;
		}
		public String getFilesize() {
			return filesize;
		}
		public void setFilesize(String filesize) {
			this.filesize = filesize;
		}
		public String getFilename() {
			return filename;
		}
		public void setFilename(String filename) {
			this.filename = filename;
		}
		
	}

}
