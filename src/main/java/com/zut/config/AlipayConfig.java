package com.zut.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2022-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000119629658";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCBfhKnnW5kDfbfmpVLB6AtE2NiR5bDza9uM5hL6ufouDsKBvUgTsYebh5kb3VzHwwrqb6RExnNf0EtDRl+XckGiXVTkANU5mik7ggsAMn1Z3AcuUPZWFK8dMpqxBo1VOXiKq6jEPTmx0FwDVLGntzIJBUfWl8+KTH7RQIdPjUWN4J8iFgasFoI8lsZIvpWEI2kfbgyPy84pzc3T4DYsuCpol2uVR+YOp6zp9PLs9GhOkdAdpBGiQbhQcHoRUTfVG2Y8XinTNbjCW4QquTSFXNuayqHV9D6MJ5sVyzKGLkRB4v092jKhXSPQG5Da/pCZeG45Ctn6Sbe5Nl+TunHmkwLAgMBAAECggEADt/UdLx4ubWA7h5rl7rAg2z+tYNTphoyVI5IqC/Lg8flwDkcXyGtUEGF7DOBYj/mvf05jqCLDjfX3LzseL99H+saNwcL2uy8iHVvKt7MVAwVrLb7PDQRDOS9e5YbDJU78sbEWKbR+tBYi+5726TT54l9g6R13EYPH7XFkGZc4rhCrqxb6iJgBVlp7PSpZ5VHI0AVunptYBceLib4fTG8FObwBHZQfxWp2HYAbjvEC51l8JGChMLki6MyaPIk1JiKhF7jLX5kbwRREbqUlBVmWPNuO0gnP1y2GiAVZTowkieqGe46S/rZgKPfC9XrnqsIPILJFj+odbpezTS36BNKgQKBgQDk72kj4hkNAWz7aG/V4btNyizmq2dFGmsMYYj4AhW+7bjjADTfSCUzEZSSP7wkWxpfXCLsQIUj1y1rUqy+ZNYSEpKHsPOZz4tiCfaLVKuZ7zun+ctkXyEnOF9i5+kjJG1vM47LdVTzd98HWtSM6HPRcj12oOYKYSttlEGKD5je8wKBgQCQzRYjZ7bJGBE7kBoIj5U5k+GELVVVw8LkMdNd/BTKc7dBKWv8HdEaoC0SENuT/oawMMqxr1GmJmGqx3+Sfdj7DUKpztkJeXxpZ/mCEih5hNaTvGVvV7qsBTyiQWr3tv/8mWftPZ4596PLCIZOdBu5gdsFipdsSnuDDZI7pSAUiQKBgQCFLAtiN0TRPvIRcRgVN8FIKAJkkHJ7TTnWMuqFMllJ/mkdi2I2PHZ/NYvSY0bjcydtL2CVQ5bvWV1vX+Fiw6+PRcR9MF8UKxnuhtMnC7Li0bpHJVS+Z2QWt4EtPLBuo+MQ29IF4pPvKNzRH3IjIZk1zhmY51HJ2ep0TNivIhGQJwKBgBilf9Yo6hjSauR7g6LfZaP2QtVvre26M2sJ/BMsPBG1noSN215/aL8icml3yxgmo6BLvcR+teQU9lzONi2mFA+vUyB6H8EYF5ANbY+xLYh5jth4ob9Q7GopPgfUILPnRy0ko2bjLRJqz0tYuRuTccCilLgdveZlyx4kajaSxaIZAoGAEeKPRTzjGgnqilNLJO1cH+4UUmbyV//iY8dZZmpP7SPaKPnOr3mYWUa5ZBbhUfBhnSdEQqRq04x4TKvmqLL04SWJvhbcM9E29/BjLXs592L0mNf+zmTAAizLYXj8E/K5y6tGRjbLFrM2RNCH1HhQslZ82US29Y8ViM8ArVTA5g4=";
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4cy6Wi0zmwCC5MS4iKOqzZyp4Ofc1vf8CkKobqa4j/n/XcdWgHwzqtH9qkrNM8hUftCao5v+CZ4IBmP/cIOKZb0n3HFJ5P1djxiBnm/YxarNwCeq0lm/4yBh/LC7gDqO+dKSQB3oHhypGvqjpvCopbqHtPhqxBGDUo3dLApT5IgFnGQ+N9ivRH+aHUikx6Ri3hkEFPmDSVKXXfBTCOx1GmBNaE+8+it2POYRTbENh+OgIqCYY8WMjazhytQ8MLecNUWQJ8KOuQUAJQhPQfmW3Ez2A9sK3AoGKMm0kykL9t0fwBUrRpQggtXazNEovxgzRIKJArwfKQapj4s8kywDqQIDAQAB";
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/_war_exploded2/alipay/notice.action";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/_war_exploded2/alipay/notice.action";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

