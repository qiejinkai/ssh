package com.qjk.ssh.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public final class DigestUtil {
	
	private final static String PASSWORD_TOKEN = "cdXDk49k23-";
	
	public static String encodePassword(String password){
		return DigestUtil.md5(PASSWORD_TOKEN + password + PASSWORD_TOKEN);
	}
	
	
	public final static String md5(String s) {
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};       
        try {
            byte[] btInput = s.getBytes("utf-8");
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public final static byte[] md5bytes(String s) {
             
        try {
            byte[] btInput = s.getBytes("utf-8");
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            return mdInst.digest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	
	public final static String md5(byte bytes[]) {
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};       
        try {
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(bytes);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public final static String base64enc(byte[] data) {
		return (new BASE64Encoder()).encode(data);
	}
	
	public final static byte[] base64dec(String string) throws IOException {
		return (new BASE64Decoder()).decodeBuffer(string);
	}
	
	/**
     * Description 根据键值进行加密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    public final static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom(key);
 
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
 
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);
       
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance("DES");
 
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
 
        return cipher.doFinal(data);
    }
     
     
    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    public final static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom(key);
 
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
 
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);
 
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
 
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
 
        return cipher.doFinal(data);
    }
    
    public final static byte[] dechexString(String hexString) {
    	
    	int length = hexString.length() / 2;
    	byte[] bytes = new byte[length];
    	for(int i=0;i<length;i++){
    		
    		bytes[i] =(byte)( (Byte.valueOf(hexString.substring(i * 2,i * 2 + 1), 16) << 4)
    					| (Byte.valueOf(hexString.substring(i * 2 + 1,i * 2 + 2), 16)) );
    	}
    	return bytes;
    }
    
    public final static String enchexString(byte[] bytes){
    	char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'}; 
    	 char str[] = new char[bytes.length * 2];
         int k = 0;
         for (int i = 0; i < bytes.length; i++) {
             byte b = bytes[i];
             str[k++] = hexDigits[((int)b >> 4) & 0xf];
             str[k++] = hexDigits[(int)b & 0xf];
         }
         return new String(str);
    }
    
    public final static byte[] long2bytes(long v){
    	byte[] bytes = new byte[8];
    	long2bytes(v,bytes,0);
    	return bytes;
    }
    
    public final static void long2bytes(long v,byte[] bytes,int index){
    	
    	long vv = v;
    	
    	for(int i=7;i>=0;i--){
    		bytes[index + i] = (byte) (vv & 0x0ff);
    		vv = vv >> 8;
    	}
    	
    }
    
    public final static long bytes2long(byte[] bytes,int index){
    	
    	long v = 0;
    	
    	for(int i=0;i<8;i++){
    		long b = bytes[i + index];
    		b = b & 0x0ff;
    		v = v << 8 | b;
    	}
    	
    	return v;
    }
    
    public final static byte[] int2bytes(long v){
    	byte[] bytes = new byte[4];
    	long2bytes(v,bytes,0);
    	return bytes;
    }
    
    public final static void int2bytes(long v,byte[] bytes,int index){
    	
    	long vv = v;
    	
    	for(int i=3;i>=0;i--){
    		bytes[index + i] = (byte) (vv & 0x0ff);
    		vv = vv >> 8;
    	}
    	
    }
    
    public final static int bytes2int(byte[] bytes,int index){
    	
    	int v = 0;
    	
    	for(int i=0;i<4;i++){
    		int b = bytes[i + index];
    		b = b & 0x0ff;
    		v = v << 8 | b;
    	}
    	
    	return v;
    }
    
    public final static String md5sign(String key, Map<String,String> values) {
    	
    	List<String> keys = new ArrayList<String>(values.keySet());
    	
		Collections.sort(keys);

		StringBuilder prestr = new StringBuilder();
		
		String v;
		
		for(String k : keys){
			
			v = values.get(k);
			
			if(v != null && ! "".equals(v)){
				if(prestr.length() > 0){
					prestr.append("&").append(k).append("=").append(v);
				}
				else {
					prestr.append(k).append("=").append(v);
				}
			}
			
		}
		
		return md5(prestr.append(key).toString());
    }
    
    public final static String sha1(String string) { 
    	try {
			return sha1(string.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
    
    public final static String sha1(byte[] bytes) {
    	char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};       
        try {
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("SHA-1");
            // 使用指定的字节更新摘要
            mdInst.update(bytes);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
