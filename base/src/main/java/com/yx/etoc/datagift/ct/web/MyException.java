/**   
* @Title: MyException.java 
* @Package com.yx.etoc.datagift.ct.web 
* @Description: TODO(用一句话描述该文件做什么) 
* @author yuxuan
* @date 2014-3-7 上午7:50:25 
* @version V1.0
* <pre>
* 修改记录
*    修改后版本:     修改人：  修改日期:     修改内容:
* </pre>
*/

package com.yx.etoc.datagift.ct.web;

/** 
 * @ClassName: MyException 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author yuxuan
 * @date 2014-3-7 上午7:50:25 
 *  
 */
public class MyException extends Exception{
	public MyException(){
        super();
    }
    public MyException(String msg){
        super(msg);
    }
}
