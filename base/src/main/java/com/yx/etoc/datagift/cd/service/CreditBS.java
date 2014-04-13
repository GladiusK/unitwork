/**   
* @Title: UserBS.java 
* @Package com.yx.etoc.datagift.ct.service 
* @Description: TODO(客户端用户信息管理) 
* @author yuxuan
* @date 2014-3-7 上午2:37:08 
* @version V1.0
* <pre>
* 修改记录
*    修改后版本:     修改人：  修改日期:     修改内容:
* </pre>
*/

package com.yx.etoc.datagift.cd.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yx.baseframe.service.BaseBS;
import com.yx.etoc.datagift.cd.entity.DgCdInfoH;


/** 
* @ClassName: CreditBS 
* @Description: TODO(积分历史管理) 
* @author yuxuan
* @date 2014-3-14 上午9:24:21 
*  
*/
@Service
@Transactional(readOnly=true)
public class CreditBS extends BaseBS<DgCdInfoH>{
	public DgCdInfoH getLatestDetail(String userid){
		return null;
	}
}
