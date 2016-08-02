package com.qjk.ssh.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ����ʱ�乤����
 * @author qiejinkai
 *
 */
public final class DateUtil {

	/**
	 * 2015-05-31 09:15:20 ������
	 */
	public static final String DEFAULTFORMATE="yyyy-MM-dd HH:mm:ss E";
	

	/**
	 * 2015-05-31 09:15:20
	 */
	public static final String FORMATE_1="yyyy-MM-dd HH:mm:ss";
	
	private DateUtil(){
		
	}
	
	/**
	 * ��ȡ��ǰʱ��
	 * @return long 11λ������ ��ȷ����
	 */
	public static long now(){
		
		return System.currentTimeMillis()/1000;
	}
	
	/**
	 * ��ʽ������ʱ�� 
	 * Ĭ�ϸ�ʽ
	 * @param time
	 * @return
	 */
	public static String formateDate(long time){
		
		return formateDate(time, DEFAULTFORMATE);
	}
	
	/**
	 * ��ʽ������ʱ��
	 * @param time
	 * @param formate
	 * @return
	 */
	public static String formateDate(long time,String formate){
		
		SimpleDateFormat sdf =new SimpleDateFormat(formate);
		
		Date date=new Date(time);
		
		return sdf.format(date);
	}
	
}
