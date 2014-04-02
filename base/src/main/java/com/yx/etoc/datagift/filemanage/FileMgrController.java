/**   
* @Title: FileMgrController.java 
* @Package com.yx.etoc.datagift.filemanage 
* @Description: TODO(用一句话描述该文件做什么) 
* @author yuxuan
* @date 2014-3-17 上午2:32:26 
* @version V1.0
* <pre>
* 修改记录
*    修改后版本:     修改人：  修改日期:     修改内容:
* </pre>
*/

package com.yx.etoc.datagift.filemanage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yx.baseframe.util.BaseController;
import com.yx.baseframe.util.EhcacheUtils;
import com.yx.baseframe.util.Pager;

/** 
 * @ClassName: FileMgrController 
 * @Description: TODO(文件的下载服务) 
 * @author yuxuan
 * @date 2014-3-17 上午2:32:26 
 *  
 */
@Controller
@RequestMapping("/dg/file")
public class FileMgrController extends BaseController {
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download() throws IOException{
		 HttpHeaders headers = new HttpHeaders(); 
		 headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		 headers.setContentDispositionFormData("attachment", "aaa.apk");
		 return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(this.getContextPath()+"/export/DataGift_v2.apk")),headers,HttpStatus.CREATED);
	}
	@RequestMapping("/test")
	@ResponseBody
	public String test(Pager page){
		System.out.println(page.getSortname());
		EhcacheUtils.put("telGegCache", "test", "123");
		System.out.println(EhcacheUtils.get("telGegCache", "test"));
		return "ll";
	}
	@RequestMapping("/test2")
	public String test2(){
		System.out.println(EhcacheUtils.get("telGegCache", "test"));
		return "ll";
	}
}
