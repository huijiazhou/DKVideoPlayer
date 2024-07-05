package com.jeffmony.videocache.ppvod;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by junwen.deng on 2019/6/13.
 */
public class Aes {


    public String paddingData(String data){
        int padding = 16 - (data.length() % 16);

        char padingchar = (char)padding;
        int length = padding;
        for (int i = 0; i < length; i++){

            data += padingchar;
        }
        return data;
    }


    public byte[] caculateGenKeyData(String key) throws NoSuchAlgorithmException {


        byte[] rawKey = key.getBytes();
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        byte[] genKeyData = new byte[0];

        while (genKeyData.length < 32)

        {
            byte[] newArr = mergerArray(genKeyData, rawKey);
            genKeyData = mergerArray(genKeyData, md5.digest(newArr));

        }
        return genKeyData;

    }



    /**
     * 加密方法
     *
     * @param data
     *            要加密的字符串
     * @param key
     *            加密密钥
     * @return
     */
    public byte[] encrypt(String data, String key) throws NoSuchAlgorithmException {
        data = paddingData(data);
        byte[] genKeyData = caculateGenKeyData(key);

        byte[] keyBytes = Aes.subByte(genKeyData, 0, 16);
        byte[] myIv =  Aes.subByte(genKeyData, 16, 16);
       return this.encrypt(data.getBytes(), keyBytes, myIv);
    }

    /**
     * 解密方法
     *
     * @param data
     *            要解密的字符串
     * @param key
     *            解密密钥
     * @return
     */
    public byte[] decrypt(String data, String key) throws NoSuchAlgorithmException {
        byte[] genKeyData = caculateGenKeyData(key);

        byte[] keyBytes = Aes.subByte(genKeyData, 0, 16);
        byte[] myIv =  Aes.subByte(genKeyData, 16, 16);
        byte[] content = Hex.decode(data.getBytes());


        return this.decrypt(content, keyBytes, myIv);
    }

    /**
     *
     * @author ngh
     * AES128 算法
     *
     * CBC 模式
     *
     * PKCS7Padding 填充模式
     *
     * CBC模式需要添加一个参数iv
     *
     * 介于java 不支持PKCS7Padding，只支持PKCS5Padding 但是PKCS7Padding 和 PKCS5Padding 没有什么区别
     * 要实现在java端用PKCS7Padding填充，需要用到bouncycastle组件来实现
     */
    // 算法名称
    final String KEY_ALGORITHM = "AES";
    // 加解密算法/模式/填充方式
    final String algorithmStr = "AES/CBC/NoPadding";
    //
    private Key key;
    private Cipher cipher;


    public void init(byte[] keyBytes) {

        // 初始化
        Security.addProvider(new BouncyCastleProvider());
        // 转化成JAVA的密钥格式
        key = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
        try {
            // 初始化cipher
            cipher = Cipher.getInstance(algorithmStr);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 加密方法
     *
     * @param content
     *            要加密的字符串
     * @param keyBytes
     *            加密密钥
     * @return
     */
    private byte[] encrypt(byte[] content, byte[] keyBytes, byte[] myIv) {
        byte[] encryptedText = null;
        init(keyBytes);
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(myIv));
            encryptedText = cipher.doFinal(content);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return encryptedText;
    }
    /**
     * 解密方法
     *
     * @param encryptedData
     *            要解密的字符串
     * @param keyBytes
     *            解密密钥
     * @return
     */
    private byte[] decrypt(byte[] encryptedData, byte[] keyBytes, byte[] myIv) {
        byte[] encryptedText = null;
        init(keyBytes);
        try {
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(myIv));
            encryptedText = cipher.doFinal(encryptedData);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return encryptedText;
    }

    /**
     * 字节转十六进制
     * @param b 需要进行转换的byte字节
     * @return  转换后的Hex字符串
     */
    public static String byteToHex(byte b){
        String hex = Integer.toHexString(b & 0xFF);
        if(hex.length() < 2){
            hex = "0" + hex;
        }
        return hex;
    }


    public static byte[] mergerArray(byte[] arr1, byte[] arr2){
        byte[] newarr = new byte[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++){
            newarr[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++){
            newarr[arr1.length + i] = arr2[i];
        }
        return newarr;
    }
    /**
     * 截取byte数组   不改变原数组
     * @param b 原数组
     * @param off 偏差值（索引）
     * @param length 长度
     * @return 截取后的数组
     */
    public static byte[] subByte(byte[] b,int off,int length){
        byte[] b1 = new byte[length];
        System.arraycopy(b, off, b1, 0, length);
        return b1;
    }




}
