package day0319;

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
    Map<String,String> headers = new HashMap<>();
    Map<String,String> cookies = new HashMap<>();
    Map<String,String> paraments = new HashMap<>();
    private String body;

    public static HttpRequest build (InputStream inputStream) throws IOException {
        HttpRequest request = new HttpRequest();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String firstLine = bufferedReader.readLine();
        String[] firstToken = firstLine.split(" ");
        request.method = firstToken[0];
        request.url = firstToken[1];
        request.version = firstToken[2];

        int post = request.url.indexOf("?");
        if (post != -1){
            String parament = request.url.substring(post+1);
            parseKV(parament,request.paraments);
        }

        String line = "";
        while ((line = bufferedReader.readLine()) != null && line.length() !=0){
            //还没读完并且读到的不是空字符串
            String[] headerTokens = line.split(": ");//用冒号空格来切分
            request.headers.put(headerTokens[0],headerTokens[1]);
        }

        String cookie = request.headers.get("cookie");
        if (cookie != null){
            praseCookie(cookie,request.cookies);
        }

        if ("POST".equalsIgnoreCase(request.method) || "GET".equalsIgnoreCase(request.method)){
            int length = Integer.parseInt(request.headers.get("Content-Length"));
            char[] buffer = new char[length];
            int len = bufferedReader.read(buffer);
            request.body = new String(buffer,0,len);
            parseKV(request.body,request.paraments);
        }

        return request;

    }

    private static void praseCookie(String cookie, Map<String, String> cookies) {
        String[] paraKV = cookie.split(": ");
        for (String KV : paraKV){
            String[] ret = KV.split("=");
            cookies.put(ret[0],ret[1]);
        }
    }

    private static void parseKV(String parament, Map<String, String> paraments) {
        String[] paraKV = parament.split("&");
        for (String KV : paraKV){
            String[] ret = KV.split("=");
            paraments.put(ret[0],ret[1]);
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
        return paraments.get(key);
    }

    public String getHeader(String key){
        return headers.get(key);
    }

    public String geCookie(String key){
        return cookies.get(key);
    }
}
