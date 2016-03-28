package com.my.core.util;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class DesUtil {

	public static String encrypt(String message) throws Exception{
		MessageDigest md = MessageDigest.getInstance("md5");
		byte[] digestOfPassword = md.digest("HG58YZ3CR9".getBytes("utf-8"));
		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		for (int j = 0, k = 16; j < 8;) {
			keyBytes[k++] = keyBytes[j++];
		}
		SecretKey key = new SecretKeySpec(keyBytes, "DESede");
		IvParameterSpec iv = new IvParameterSpec(new byte[8]);
		Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);

		byte[] plainTextBytes = message.getBytes("utf-8");
		byte[] cipherText = cipher.doFinal(plainTextBytes);
		return Base64.encodeBase64String(cipherText); 
	}

	public static String decrypt(String message) throws Exception {
		MessageDigest md = MessageDigest.getInstance("md5");
		byte[] digestOfPassword = md.digest("HG58YZ3CR9".getBytes("utf-8"));
		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		for (int j = 0, k = 16; j < 8;) {
			keyBytes[k++] = keyBytes[j++];
		}

		SecretKey key = new SecretKeySpec(keyBytes, "DESede");
		IvParameterSpec iv = new IvParameterSpec(new byte[8]);
		Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		decipher.init(Cipher.DECRYPT_MODE, key, iv);
		byte[] encData = Base64.decodeBase64(message);
		byte[] plainText = decipher.doFinal(encData);
		return new String(plainText, "UTF-8");
	}

}
