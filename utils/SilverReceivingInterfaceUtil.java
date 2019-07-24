package com.boot.security.server.utils;

import java.util.List;

/**
 * Created by zjw on 2018/11/11.
 */
public class SilverReceivingInterfaceUtil {
    public static int encryptionParameterVerification(PageData parameterPd) {
        String secret = "L82V6ZVD6JMD5";//参与加密字符串
        try {
            String key = MD5.md5(secret + parameterPd.get("timestamp").toString() + parameterPd.get("nonceStr").toString()).substring(0, 16).toLowerCase();
            String signatureMd5 = MD5.md5(key + parameterPd.get("timestamp").toString() + parameterPd.get("nonceStr").toString()).substring(0, 16).toLowerCase();
            if (!(signatureMd5.equals(parameterPd.get("signature").toString()))) {
                return 8004;
            } else {
                return 1; //参数正常，调用service
            }
        } catch (Exception e) {
            if ("" == parameterPd.get("timestamp") || null == parameterPd.get("timestamp")) return 8001;
            if ("" == parameterPd.get("nonceStr") || null == parameterPd.get("nonceStr")) return 8002;
            if ("" == parameterPd.get("signature") || null == parameterPd.get("signature")) return 8003;
        }
        return 9999;
    }

}
