/**   
* @Title: AppImgBS.java 
* @Package com.yx.etoc.datagift.app.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author yuxuan
* @date 2014-4-4 上午8:53:26 
* @version V1.0
* <pre>
* 修改记录
*    修改后版本:     修改人：  修改日期:     修改内容:
* </pre>
*/

package com.yx.etoc.datagift.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yx.baseframe.service.BaseBS;
import com.yx.etoc.datagift.app.entity.DgAppImg;

/** 
 * @ClassName: AppImgBS 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author yuxuan
 * @date 2014-4-4 上午8:53:26 
 *  
 */
@Service
@Transactional(readOnly=true)
public class AppImgBS extends BaseBS<DgAppImg> {

}
