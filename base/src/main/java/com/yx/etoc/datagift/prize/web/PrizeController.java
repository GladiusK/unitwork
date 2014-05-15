/**   
 * @Title: PrizeController.java 
 * @Package com.yx.etoc.datagift.prize.web 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author yuxuan
 * @date 2014-5-6 上午6:52:10 
 * @version V1.0
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */

package com.yx.etoc.datagift.prize.web;

import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.yx.baseframe.util.BaseController;
import com.yx.etoc.datagift.common.GlobalConstants;
import com.yx.etoc.datagift.ct.entity.DgCtUser;
import com.yx.etoc.datagift.ct.service.UserBS;
import com.yx.etoc.datagift.prize.service.PrizeBS;
import com.yx.etoc.datagift.task.web.dto.PrizeAppStructure;

/**
 * @ClassName: PrizeController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yuxuan
 * @date 2014-5-6 上午6:52:10
 * 
 */
@Controller
@RequestMapping("/dg/prize")
public class PrizeController extends BaseController {
	@Autowired
	private PrizeBS prizeBS;
	@Autowired
	private UserBS userBS;
	
	@RequestMapping(value="/try",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> tryPrize(@RequestBody String rquestParam){
		Map<String, Object> rsMap = Maps.newHashMap();
		JSONObject obj = JSONObject.fromObject(rquestParam);
		if (obj.isEmpty()) {
			rsMap.put("status", GlobalConstants.CT_PARAM_NULL);
			return rsMap;
		}
		String userid = obj.getString("userid");
		DgCtUser user = this.userBS.getEntityById(DgCtUser.class, userid);
		if(user != null){
			PrizeAppStructure rs = prizeBS.rotatePrize();
			if(rs == null){
				rsMap.put("status", GlobalConstants.CT_PRIZE_NO_PRIZE);
			}else{
				rsMap.put("status", GlobalConstants.CT_OK);
				rsMap.put("prize", prizeBS.rotatePrize());
			}
			return rsMap;
		}else{
			rsMap.put("status", GlobalConstants.CT_NO_USR);
			return rsMap;
		}
	}

}
