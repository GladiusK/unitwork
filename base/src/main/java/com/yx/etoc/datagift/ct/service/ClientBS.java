/**   
* @Title: ClientBS.java 
* @Package com.yx.etoc.datagift.ct.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author yuxuan
* @date 2014-4-8 上午8:53:18 
* @version V1.0
* <pre>
* 修改记录
*    修改后版本:     修改人：  修改日期:     修改内容:
* </pre>
*/

package com.yx.etoc.datagift.ct.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yx.baseframe.service.BaseBS;
import com.yx.etoc.datagift.ct.entity.DgCtInfo;

/** 
 * @ClassName: ClientBS 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author yuxuan
 * @date 2014-4-8 上午8:53:18 
 *  
 */
@Service
@Transactional(readOnly=false)
public class ClientBS extends BaseBS<DgCtInfo> {

}
