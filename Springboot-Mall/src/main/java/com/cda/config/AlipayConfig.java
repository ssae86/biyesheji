package com.cda.config;

import com.cda.util.general.PropertiesUtil;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Captain
 */
//@Data
//@Component
//public class AlipayConfig {
//    /**
//     * 沙箱appId
//     */
//    public static final String APPID = "2021000119656007";
//
//    /**
//     * 请求网关  固定
//     */
//    public static final String URL = "https://openapi.alipaydev.com/gateway.do";
//
//    /**
//     * 编码
//     */
//    public static final String CHARSET = "UTF-8";
//
//    /**
//     * 返回格式
//     */
//    public static final String FORMAT = "json";
//
//    /**
//     * RSA2
//     */
//    public static final String SIGNTYPE = "RSA2";
//
//    /**
//     * 异步通知地址
//     */
////    public static final String NOTIFY_URL = "http://" + PropertiesUtil.getDomain() + "/alipay/notify";
//    public static final String NOTIFY_URL = "http://as27ci.natappfree.cc/alipay/notify";
//
//    /**
//     * 同步地址
//     */
////    public static final String RETURN_URL = "http://" + PropertiesUtil.getDomain() + "/alipay" + "/success";
//    public static final String RETURN_URL = "http://as27ci.natappfree.cc/alipay" + "/success";
//
//    /**
//     * 应用私钥 pkcs8格式
//     */
//    public static final String RSA_PRIVATE_KEY =
//            "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCFxDnCJPJT4Ol/duG91rA2VtSTfhz7VApBSWCjVirqIEAnAz9wRPeY74j7OGVTsl9f6QnB6De+vkJudXR3GHXuFQJcmlnnKn62uMxMGLG+P8WsN/skcL+rwuWtZh4pWI7l39KgAECNQS5FPozP59F1qE5zRRPBDulOUQ5LYcNIXf88UgOq8MNhQhint1V3mXMjZWWTHgIl9xj3TGJ8huFh2t2fwr4RphJoy9jTSd4w434A6gPXq0SanVOql6u/G0Sm/EZ83xRZs/cLwrphz5BKTbnnpPm3eZ2n0Hi2XM2rPXfFnvG170TEdfzYGvjEAO17az3oMkTD9U5ruXoKKIx7AgMBAAECggEBAIW/heDRAFtN7yo7u8sM9nPerf4rgt7pULemnrGyXoZqaLqZTLz8uHR6TQSjhu0A1MwZPmBbyCE4K0Q2vJS4KHI9H3dn/axdmQUqEVuk9VO8f/GKp9nvwjYDUZLnIBFHMto1yWuh1Oln2tPxjunyaES0XHx0/SNzvWNJOHm27oNTxsa3AEgVLGiHFCPfEfDSisB4hQnOOJqgs5b/6v2a4bSSMxa+BmuwXUrLBmznbMrvTpmxB+FVnUo0IE67CV/MFNo2B2N9DTyBBSxT8V585jBp7VuFoPEXvwAwimLy9xQzAZfACo8UE4IK1NVXEijTr4udldcaabK+FTVx+04hnsECgYEAviM4bfTt0/Am1MLDn4aXzbcuzQ88RSTRJRVXl7l7rnoPGoAwrNRP+FO+Qkn+9YBmDSjezI0JekB9oaBu97htIi26OLyy3KqgzTGpcHWidzv9FOwZKrXGl5nbv1WiBWbXTfTB7DIzgHD2Od/CeCHJNMMBJB1lehiyvVXoj15Ekb0CgYEAtBoz14j8EryCInD04Cpu9UOyDt1BRZSRQQSqXnIizFUjRjK5jU9/4mgn3iOZ4XXngp+Z0i0bX4b3rkcvRCBZey28z/y5q2EieKc2lSQYk7zV+2DL/Ixmq5MxWLI3+ibLJy4GTH7U+ocTCLJaaTGWW04xppKCx44B3xy58TP7TpcCgYBqh7NDMDrcRy6KgIE4bSG6mcr4C3Q6TVF9FIMaOEtKy4qQz4f2HZKc0NbFr03RYVpMPzztoIvR2jZJi2kBFGzY/IPc7CTOrC8iKJQFtXMMmSjIQywqmOQm5oaPojwACMnTHLJWUx419ZSPgoYj5tIj5KpMAMhta08h8/Mz+J40hQKBgHaf45GNWmqE2zoQKFoV2OuW4QrFVJ6d0mZ+yjBXAPCRCyDLfEfFGzhm3guEa3CDFi+FK+2xZBwxa6XQoSNAI2/smjZsAWcOHYRWrq7hDYcRk+d0xCbd2yobUx9Wk2QidSCjQebUizdQDItn3gD3dk9BW5aZXaZOtJDd/OMQF/CVAoGAS9JwctL2UW1AfPI+GvM/mur1O24UDGBcXtXFukoJZ8wRKCwIgp+VAk8tm6BTFkKHOwaSRj4+wVQIAlQGCB7hhK5+v6JSL2HHCDaN/b3+MsSZUR5miTepGg62oU0BT03j7c7sWe/+eY5N6MXHseDnbmX4MN+rFFKPOsLbz6xiOWg=";
//
//    /**
//     * 沙箱支付宝公钥
//     */
//    public static final String ALIPAY_PUBLIC_KEY =
//            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtGPxH0twZmACkgTToWdW5cJfEQs3cp1i8C9t9syBXbEz2ERJ5635DshEDOTxbx7MqATVeERDvgEdsHUWiDLVrH6iYIO3zVPTpdmiHnpramsDi//RrxoNRKfBrJ9ouOh6GVRBT8B1aTnskiEt0zm0S9m0VvbC0p3SIt4w2WDkEUXM0gafWCqym4rThW1vbuNKCGrjNqork8FIxuBwcE8Ij1YV2VkJ4kWrPqILFak3hW+DYTyRrLgqVNem9oBQITMfCN9334wx84kdFGHqxZvJD0F44dGNSrjxE54CC0oCHWG7ciVYcg/gw11kwb2KA0zF6wUb92ea8KNy971YRtBogQIDAQAB";
//
//    private AlipayConfig() {
//    }
//}
@Data
@Component
public class AlipayConfig {
    /**
     * 沙箱appId
     */
    public static final String APPID = "2021000119656007";

    /**
     * 请求网关  固定
     */
    public static final String URL = "https://openapi.alipaydev.com/gateway.do";

    /**
     * 编码
     */
    public static final String CHARSET = "UTF-8";

    /**
     * 返回格式
     */
    public static final String FORMAT = "json";

    /**
     * RSA2
     */
    public static final String SIGNTYPE = "RSA2";

    /**
     * 异步通知地址
     */
    public static final String NOTIFY_URL = "http://" + PropertiesUtil.getDomain() + "/alipay/notify";

    /**
     * 同步地址
     */
    public static final String RETURN_URL = "http://" + PropertiesUtil.getDomain() + "/alipay" +
            "/success";

    /**
     * 应用私钥 pkcs8格式
     */
    public static final String RSA_PRIVATE_KEY =
            "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCFxDnCJPJT4Ol/duG91rA2VtSTfhz7VApBSWCjVirqIEAnAz9wRPeY74j7OGVTsl9f6QnB6De+vkJudXR3GHXuFQJcmlnnKn62uMxMGLG+P8WsN/skcL+rwuWtZh4pWI7l39KgAECNQS5FPozP59F1qE5zRRPBDulOUQ5LYcNIXf88UgOq8MNhQhint1V3mXMjZWWTHgIl9xj3TGJ8huFh2t2fwr4RphJoy9jTSd4w434A6gPXq0SanVOql6u/G0Sm/EZ83xRZs/cLwrphz5BKTbnnpPm3eZ2n0Hi2XM2rPXfFnvG170TEdfzYGvjEAO17az3oMkTD9U5ruXoKKIx7AgMBAAECggEBAIW/heDRAFtN7yo7u8sM9nPerf4rgt7pULemnrGyXoZqaLqZTLz8uHR6TQSjhu0A1MwZPmBbyCE4K0Q2vJS4KHI9H3dn/axdmQUqEVuk9VO8f/GKp9nvwjYDUZLnIBFHMto1yWuh1Oln2tPxjunyaES0XHx0/SNzvWNJOHm27oNTxsa3AEgVLGiHFCPfEfDSisB4hQnOOJqgs5b/6v2a4bSSMxa+BmuwXUrLBmznbMrvTpmxB+FVnUo0IE67CV/MFNo2B2N9DTyBBSxT8V585jBp7VuFoPEXvwAwimLy9xQzAZfACo8UE4IK1NVXEijTr4udldcaabK+FTVx+04hnsECgYEAviM4bfTt0/Am1MLDn4aXzbcuzQ88RSTRJRVXl7l7rnoPGoAwrNRP+FO+Qkn+9YBmDSjezI0JekB9oaBu97htIi26OLyy3KqgzTGpcHWidzv9FOwZKrXGl5nbv1WiBWbXTfTB7DIzgHD2Od/CeCHJNMMBJB1lehiyvVXoj15Ekb0CgYEAtBoz14j8EryCInD04Cpu9UOyDt1BRZSRQQSqXnIizFUjRjK5jU9/4mgn3iOZ4XXngp+Z0i0bX4b3rkcvRCBZey28z/y5q2EieKc2lSQYk7zV+2DL/Ixmq5MxWLI3+ibLJy4GTH7U+ocTCLJaaTGWW04xppKCx44B3xy58TP7TpcCgYBqh7NDMDrcRy6KgIE4bSG6mcr4C3Q6TVF9FIMaOEtKy4qQz4f2HZKc0NbFr03RYVpMPzztoIvR2jZJi2kBFGzY/IPc7CTOrC8iKJQFtXMMmSjIQywqmOQm5oaPojwACMnTHLJWUx419ZSPgoYj5tIj5KpMAMhta08h8/Mz+J40hQKBgHaf45GNWmqE2zoQKFoV2OuW4QrFVJ6d0mZ+yjBXAPCRCyDLfEfFGzhm3guEa3CDFi+FK+2xZBwxa6XQoSNAI2/smjZsAWcOHYRWrq7hDYcRk+d0xCbd2yobUx9Wk2QidSCjQebUizdQDItn3gD3dk9BW5aZXaZOtJDd/OMQF/CVAoGAS9JwctL2UW1AfPI+GvM/mur1O24UDGBcXtXFukoJZ8wRKCwIgp+VAk8tm6BTFkKHOwaSRj4+wVQIAlQGCB7hhK5+v6JSL2HHCDaN/b3+MsSZUR5miTepGg62oU0BT03j7c7sWe/+eY5N6MXHseDnbmX4MN+rFFKPOsLbz6xiOWg=";

    /**
     * 沙箱支付宝公钥
     */
    public static final String ALIPAY_PUBLIC_KEY =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtGPxH0twZmACkgTToWdW5cJfEQs3cp1i8C9t9syBXbEz2ERJ5635DshEDOTxbx7MqATVeERDvgEdsHUWiDLVrH6iYIO3zVPTpdmiHnpramsDi//RrxoNRKfBrJ9ouOh6GVRBT8B1aTnskiEt0zm0S9m0VvbC0p3SIt4w2WDkEUXM0gafWCqym4rThW1vbuNKCGrjNqork8FIxuBwcE8Ij1YV2VkJ4kWrPqILFak3hW+DYTyRrLgqVNem9oBQITMfCN9334wx84kdFGHqxZvJD0F44dGNSrjxE54CC0oCHWG7ciVYcg/gw11kwb2KA0zF6wUb92ea8KNy971YRtBogQIDAQAB";

    private AlipayConfig() {
    }
}