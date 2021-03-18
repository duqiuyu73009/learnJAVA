package day0318;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    private String version = "HTTP/1.1";
    private int status; //状态码
    private String message; //状态码描述信息
    private Map<String,String> headers = new HashMap<>();
    private StringBuilder body = new StringBuilder();
    //当代码需要把响应写回客户端的时候，就往这个OutputStream里面写就好了
    private OutputStream outputStream = null;

    //工厂方法
    public static HttpResponse build(OutputStream outputStream){
        HttpResponse response = new HttpResponse();
        response.outputStream = outputStream;
        return response;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHeaders(String key, String value) {
        headers.put(key,value);
    }

    public void writeBody(String content) {
        body.append(content);
    }

    //以上的设置属性操作都是在内存中搞得，还需要一个专门的方法，把这些属性按照HTTP协议，都写到Socket中
    public void flush() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(version+" "+status+ " "+message+"\n");
        headers.put("Content-Length",body.toString().getBytes().length+"");
        for (Map.Entry<String,String> entry : headers.entrySet()){
            bufferedWriter.write(entry.getKey()+": "+entry.getValue()+"\n");
        }
        bufferedWriter.write("\n");
        bufferedWriter.write(body.toString());
        bufferedWriter.flush();
    }
}
