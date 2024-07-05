package com.jeffmony.videocache.ppvod;


import android.content.Context;

import org.bouncycastle.util.encoders.Hex;

import java.security.NoSuchAlgorithmException;

public class PpvodUtil {

    private static String mKey = "C77A9FF7F323B5404902102257503C2F";
    public static void setKey(String key){
        mKey = key;
    }
    public static   String getUrlWithOutSign(String url){
        String newUrl = "";
        if (url.contains(".m3u8") && url.contains("sign=")){
            newUrl = url.substring(0,url.indexOf(".m3u8")+5);
        } else {
            newUrl = url;
        }
        return newUrl;
    }
    public  static String getNewUrl(String url){
        String newUrl = "";
        if (url.contains(".m3u8") ){
            if (url.contains("sign=")) {
                newUrl = url.substring(0, url.indexOf("sign="));
                newUrl += "sign=" + getEncryptKey();
            }else {
                newUrl = url+"?sign=" + getEncryptKey();
            }
        }else {
            newUrl = url;
        }
        return newUrl;
    }

    private static String getEncryptKey(){
        try {
            Aes aes = new Aes();
            String data = "timestamp="+System.currentTimeMillis();
            String key = mKey;
            byte[] enc = new byte[0];
            enc = aes.encrypt(data, key);
            return new String(Hex.encode(enc));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
