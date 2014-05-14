/**   
* @Title: PrizeBS.java 
* @Package com.yx.etoc.datagift.prize.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author yuxuan
* @date 2014-5-6 上午6:51:28 
* @version V1.0
* <pre>
* 修改记录
*    修改后版本:     修改人：  修改日期:     修改内容:
* </pre>
*/

package com.yx.etoc.datagift.prize.service;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.LockMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.yx.baseframe.service.BaseBS;
import com.yx.baseframe.util.RandomUtils;
import com.yx.etoc.datagift.prize.entity.DgPrizeDetail;
import com.yx.etoc.datagift.task.web.dto.PrizeAppStructure;

/** 
 * @ClassName: PrizeBS 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author yuxuan
 * @date 2014-5-6 上午6:51:28 
 *  
 */
@Service
@Transactional(readOnly = true)
public class PrizeBS extends BaseBS<DgPrizeDetail> {
	@Transactional(propagation = Propagation.REQUIRED)
	public PrizeAppStructure rotatePrize(){
		List<DgPrizeDetail> prizeList = this.getAllEntityList("weight", false);
		String sql = "select prize from DgPrizeDetail prize ";
		Query q = this.baseDAO.createQueryWithIndexParam(sql, null);
		
		String jql = "select sum(obj.prizeProba) from DgPrizeDetail obj ";
		List<Object> totalRange = (List<Object>) this.baseDAO.createQueryWithIndexParam(jql, null).getResultList();
		int min = 1;
		int max = 0;
		if(totalRange.get(0) == null){
			max = 0;
		}else{
			max = Integer.valueOf(totalRange.get(0)+"");
		}
		DgPrizeDetail rsObj = generatePrize(prizeList,min,max);
		if(rsObj != null){
			PrizeAppStructure appPrize = new PrizeAppStructure();
			String maxAngle = rsObj.getMaxAngle();
			String minAngle = rsObj.getMinAngle();
			if(!StringUtils.contains(maxAngle, ",") && !StringUtils.contains(minAngle, ",")){
				appPrize.setAngle(RandomUtils.createRnageRndom(Integer.valueOf(minAngle), Integer.valueOf(maxAngle)));
			}else if(StringUtils.contains(maxAngle, ",") && StringUtils.contains(minAngle, ",")){
				String[] minAngles = StringUtils.split(minAngle, ",");
				String[] maxAngles = StringUtils.split(maxAngle, ",");
				int rndTmp = RandomUtils.createRnageRndom(0, minAngles.length);
				appPrize.setAngle(RandomUtils.createRnageRndom(Integer.valueOf(minAngles[rndTmp]), Integer.valueOf(maxAngles[rndTmp])));
			}else{
				appPrize.setAngle(0);
			}
			appPrize.setPrizedetail(rsObj.getPrizeRemark());
			appPrize.setPrizename(rsObj.getPrizeName());
			return appPrize;
		}
		return null;
	}
	/** 
	* @Title: generatePrize 
	* @Description: TODO(生成奖项的算法) -- 用所有奖项的概率和作为一开始随机范围的max，然后比对随机数和当前奖项概率，如果不符合当前奖项那么max 减去当前奖项概率最为新max
	* @param @param prizeList
	* @param @param min
	* @param @param max
	* @param @return    设定文件 
	* @return DgPrizeDetail    返回类型 
	* @throws 
	*/
	@Transactional(propagation = Propagation.REQUIRED)
	private DgPrizeDetail generatePrize(List<DgPrizeDetail> prizeList, int min, int max){
		int tmp = 0;
		int currentProp = 0;
		for(DgPrizeDetail prize : prizeList){
			currentProp = prize.getPrizeProba();
			tmp = RandomUtils.createRnageRndom(min,max);
			if(tmp < currentProp ){
				if(prize.getPrizeCount() == 0){
					continue;
				}
				prize.setPrizeCount(prize.getPrizeCount() -1 );
				prize = this.baseDAO.merge(prize);
				return prize;
			}else{
				max = max - currentProp;
			}
		}
		return null;
	}
}
