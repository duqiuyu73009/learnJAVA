package day0319;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    private String version = "HTTP/1.1";
    private int status;
    private String message;
    Map<String,String> headers = new HashMap<>();
    private StringBuilder body = new StringBuilder();
    public OutputStream outputStream;

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

    public void flash() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(version+" "+status+ " "+message+"\n");
        headers.put("Content_Length",body.toString().getBytes().length+"");
        for (Map.Entry<String,String> entry : headers.entrySet()){
            bufferedWriter.write(entry.getKey()+": "+entry.getValue()+"\n");
        }
        bufferedWriter.write("\n");
        bufferedWriter.write(body.toString());
        bufferedWriter.flush();
    }
}
