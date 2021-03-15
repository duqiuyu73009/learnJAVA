package day0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求：表示一个http请求，并负责解析
 */
public class HttpRequest {
    private String method;
    private String url;
    private String version;
    private Map<String,String> headers = new HashMap<>();
    private Map<String,String> parameters = new HashMap<>();

    //请求的构造逻辑,也是用工厂模式来构造
    //此处的参数就是从socket中获取到的InputStream对象
    //就相当于反序列化
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

        //2.解析url中的参数
        int pos = request.url.indexOf("?");
        if (pos != -1){
            //pos表示问号的下标
            //看看有没有带问号，如果没有带问号就不用解析了
            //index.html?a=10&b=20
            String parameters = request.url.substring(pos+1);//从i+1开始取
            //切分的最终结果
            parseKV(parameters,request.parameters);
        }

        //3.解析header
        String line = "";
        //readLine()读到的一行内容，时会自动去掉换行符的
        while ((line = bufferedReader.readLine()) != null && line.length() !=0){
            //还没读完并且读到的不是空字符串
            String[] headerTokens = line.split(": ");//用冒号空格来切分
            request.headers.put(headerTokens[0],headerTokens[1]);
        }
        //4.解析body

        return request;
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

    //给这个类构造getter方法，不要搞setter方法，因为请求对象内容应该是从网络上解析来的，用户不应该修改

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }

    public String getHeaders(String key) {
        return headers.get(key);
    }

    public String getParameters(String key) {
        return parameters.get(key);
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", version='" + version + '\'' +
                ", headers=" + headers +
                ", parameters=" + parameters +
                '}';
    }
}
