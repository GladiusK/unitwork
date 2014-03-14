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

package com.yx.etoc.datagift.ct.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yx.baseframe.service.BaseBS;
import com.yx.etoc.datagift.ct.entity.DgCtInfo;
import com.yx.etoc.datagift.ct.entity.DgCtUser;

/** 
 * @ClassName: UserBS 
 * @Description: TODO(客户端用户信息管理) 
 * @author yuxuan
 * @date 2014-3-7 上午2:37:08 
 *  
 */
@Service
@Transactional(readOnly=true)
public class UserBS extends BaseBS<DgCtUser>{
	@Autowired
	private UaBS ua;
	@Transactional(readOnly=false)
	public void test() throws IOException{
		DgCtUser user = new DgCtUser();
		user.setUserId("2342");
		user.setTelNum("ll111111");
		user.setCtVs("1111111111");
		
		DgCtInfo info = new DgCtInfo();
		info.setCtId("ll");
		info.setCtVs("11");
		String sql = "update DgCtInfo d set d.outVs =12 where d.ctid='ll'";
		//this.baseDAO.createQueryWithIndexParam(sql).executeUpdate();
		this.ua.saveEntity(info);
		this.saveEntity(user);
		
	//	int i =1/0;
//	throw new RuntimeException();
	}
}
