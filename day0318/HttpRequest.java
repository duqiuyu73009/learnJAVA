package day0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String method;
    private String url;
    private String version;
    private Map<String,String> headers = new HashMap<>();
    //url中的参数和body中的参数都放到parameters这个hash表中
    private Map<String,String> parameters = new HashMap<>();
    private Map<String,String> cookies = new HashMap<>();
    private String body;

    public static HttpRequest build(InputStream inputStream) throws IOException {
        HttpRequest request = new HttpRequest();
        //此处不能把bufferedReader写道try括号中，一旦写进去就意味着bufferedReader就会被关闭，会影响到clientSocket的状态
        //等到最后正给请求处理完了再统一关闭
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //此处的build过程就是解析请求的过程
        //1.解析首行
        String firstLine = bufferedReader.readLine();
        String[] firstLineTokens = firstLine.split(" ");
        request.method = firstLineTokens[0];
        request.url = firstLineTokens[1];
        request.version = firstLineTokens[2];

        //2.解析url
        int pos = request.url.indexOf("?");
        if (pos != -1){
            //pos表示问号的下标
            //看看有没有带问号，如果没有带问号就不用解析了
            //index.html?a=10&b=20
            String queryString = request.url.substring(pos+1);//从i+1开始取
            //切分的最终结果
            parseKV(queryString,request.parameters);
        }

        //3.解析header
        String line = "";
        //readLine()读到的一行内容，时会自动去掉换行符的
        while ((line = bufferedReader.readLine()) != null && line.length() !=0){
            //还没读完并且读到的不是空字符串
            String[] headerTokens = line.split(": ");//用冒号空格来切分
            request.headers.put(headerTokens[0],headerTokens[1]);
        }

        //4.解析cookie
        String cookie = request.headers.get("cookie");
        if (cookie != null){
            parseCookie(cookie,request.cookies);
        }

        //5.解析body
        if ("POST".equalsIgnoreCase(request.method)
        || "PUT".equalsIgnoreCase(request.method)){
            //这两种方法需要处理body，其他暂时不考虑
            //此处的 长度单位是字节
            int contentLength = Integer.parseInt(request.headers.get("Content-Length"));
            //注意体会：此处的ContentLength为100，就说明body中有100个字节，下面创建的缓冲区为100个char，相当于是两百个字节
            //缓冲区不怕长，就怕不够，这样创建的缓冲区才能保证管够
            char[] buffer = new char[contentLength];
            int length = bufferedReader.read(buffer);
            request.body = new String(buffer,0,length);
            parseKV(request.body,request.parameters);
        }
        return request;
    }

    private static void parseCookie(String cookie, Map<String, String> cookies) {
        //1.先按照&分成若干组键值对
        String[] kvTokens = cookie.split("; ");//这里不一样
        //2.针对切分结果再分别进行按照=切分，得到了键和值
        for (String kv : kvTokens){
            String[] result = kv.split("=");
            cookies.put(result[0],result[1]);
        }
    }

    private static void parseKV(String input, Map<String, String> output) {
        //1.先按照&分成若干组键值对
        String[] kvTokens = input.split("&");
        //2.针对切分结果再分别进行按照=切分，得到了键和值
        for (String kv : kvTokens){
            String[] result = kv.split("=");
            output.put(result[0],result[1]);
        }
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }

    public String getBody() {
        return body;
    }

    public String getParameter(String key){
        return parameters.get(key);
    }

    public String getHeader(String key){
        return headers.get(key);
    }

    public String geCookie(String key){
        return cookies.get(key);
    }
}
