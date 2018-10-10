package com.yicuojin.football.utils;

import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.KeyStore;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;


import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * HTTP 工具类
 */
public class YCJHTTPUtils {
    private static final Logger logger = Logger.getLogger(YCJHTTPUtils.class);

    /**
     * Content-Type: text/xml
     */
    public static final String CONTENTTYPEXML = "text/xml";
    /**
     * Content-Type: application/json
     */
    public static final String CONTENTTYPEJSON = "application/json";

    /**
     * HTTP Get 方法请求URL
     *
     * @param url URL
     * @return Response字符串
     * @throws IOException
     */
    public static String getHttp(String url, String charset) throws IOException {
        String responseMsg = "";

        // 创建HTTP客户端对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建HTTP Get方法对象
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Content-Type", "application/json;charset=" + charset);

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            responseMsg = EntityUtils.toString(response.getEntity(), Charset.forName(charset));
            System.out.println(responseMsg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null)
                response.close();
            httpClient.close();
        }

        return responseMsg;
    }

    /**
     * POST方式访问 HTTP服务
     *
     * @param url         URL
     * @param postString  提交的内容
     * @param contenttype HTTP Content-Type 参数
     * @return HTTP返回内容
     */
    public static String postHttp(String url, String postString, String contenttype, String charset) {
        logger.info("post request url:" + url + ",para:" + postString);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        String result = "";
        try {
            StringEntity stringEntity = new StringEntity(postString, Charset.forName(charset));
            stringEntity.setContentEncoding("UTF-8");
            Header header = new BasicHeader("Content-Type", contenttype);
            stringEntity.setContentType(header);
            post.setEntity(stringEntity);
            HttpResponse res = client.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = res.getEntity();
                result = EntityUtils.toString(entity, Charset.forName(charset));// 返回，字符串
            }
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.info("post response:" + result);
        return result;
    }

    /**
     * 获取完整URL行，含参数
     *
     * @param request
     * @return 完整URL行
     */
    public static String getFullURLString(HttpServletRequest request, Boolean needURLEncoding) {
        String resultURL = "";
        try {
            String fullURLString = request.getRequestURL().toString();
            String queryString = request.getQueryString();
            if (queryString != null) {
                fullURLString += "?" + queryString;
            }

            if (needURLEncoding) {
                resultURL = URLEncoder.encode(fullURLString, "UTF-8");
            } else {
                resultURL = fullURLString;
            }
        } catch (Exception e) {
            e.getSuppressed();
        }

        return resultURL;
    }

    public static String postHttpSSL(String url, String postString, String contenttype, String charset) {

        String result = "";
        CloseableHttpClient client = null;
        String certKey = "1444656202"; // 初始是商户ID

        try {
            // 指定读取证书格式为PKCS12
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            // 读取本机存放的PKCS12证书文件
            FileInputStream instream = new FileInputStream(new File("/ycjcert/cert/apiclient_cert.p12"));
            try {
                // 指定PKCS12的密码(初始是商户ID)
                keyStore.load(instream, certKey.toCharArray());
            } finally {
                instream.close();
            }
            SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, certKey.toCharArray()).build();
            // 指定TLS版本
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"},
                    null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            // 设置httpclient的SSLSocketFactory
            client = HttpClients.custom().setSSLSocketFactory(sslsf).build();

            HttpPost post = new HttpPost(url);

            StringEntity stringEntity = new StringEntity(postString, Charset.forName(charset));
            stringEntity.setContentEncoding("UTF-8");
            Header header = new BasicHeader("Content-Type", contenttype);
            stringEntity.setContentType(header);
            post.setEntity(stringEntity);
            HttpResponse res = client.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = res.getEntity();
                result = EntityUtils.toString(entity, Charset.forName(charset));// 返回，字符串
            }
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.info("post response:" + result);
        return result;
    }

    /**
     * 获取客户端IP地址
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
            }
        }
        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }

    /**
     * 发送https请求
     *
     * @param requestUrl    请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr     提交的数据
     * @return 返回微信服务器响应的信息
     * @throws Exception
     */
    public static String httpsRequest(String requestUrl, String requestMethod,
                                      String outputStr) throws Exception {
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = {new FsTrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            //使用http请求
//            conn.setSSLSocketFactory(ssf);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("content-type",
                    "application/x-www-form-urlencoded");
            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(
                    inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(
                    inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            return buffer.toString();
        } catch (ConnectException ce) {
            logger.error("连接超时：{}", ce);
            throw new RuntimeException("链接异常" + ce);
        } catch (Exception e) {
            logger.error("https请求异常：{}", e);
            throw new RuntimeException("https请求异常" + e);
        }

    }

}
