package com.yx.baseframe.util;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * 封装各种生成唯一性.
 * 
 * 
 */
public class RandomUtils {

	private static SecureRandom random = new SecureRandom();

	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间有-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid2() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 使用SecureRandom随机生成Long.
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}

	/**
	 * 创建指定数量的随机字符串
	 * 
	 * @param numberFlag
	 *            是否是纯数字
	 * @param length
	 * @return
	 */
	public static String createRandom(boolean numberFlag, int length) {
		StringBuffer retStr = new StringBuffer();
		String strTable = numberFlag ? "1234567890"
				: "1234567890abcdefghijkmnpqrstuvwxyz";
		int len = strTable.length();
		for (int i = 0; i < length; i++) {
			double dblR = Math.random() * len;
			int intR = (int) Math.floor(dblR);
			retStr.append(strTable.charAt(intR));
		}

		return retStr.toString();
	}
}
