package day0309;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

//实现一个翻译功能
public class UdpDictServer extends UdpEchoServer {

    private Map<String,String> dict = new HashMap<>();

    public UdpDictServer(int port) throws SocketException {
        super(port);

        dict.put("cat","小猫");
        dict.put("dog","小狗");
        dict.put("find","找到");
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request,"这超出了我的知识范围");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer server = new UdpDictServer(9090);
        server.start();
    }
}
