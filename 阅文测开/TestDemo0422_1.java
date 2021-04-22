package 阅文测开;

//链接：https://www.nowcoder.com/questionTerminal/3172ff61a69a49f4898c5f7a816492e3?orderByHotValue=0&mutiTagIds=933&page=4&onlyReference=false
//来源：牛客网
//
//起点客户端上允许用户对作品进行评论，为了防止用户恶意评论，发表不当内容，
// 需要对用户发布的内容进行过滤，请写程序过滤用户发布内容中带有的QQ号（6~10位数字组成）
//允许对内容严格操作，如用户发表了 作者大大666666，为你点赞 ，经过过滤后也可以为作者大大，为你点赞 ，将666666过滤掉了。
//示例1
//输入
//"作者大大666666666，为你点赞"
//输出
//"作者大大，为你点赞"
public class TestDemo0422_1 {

    //100%
    public String filterContent (String content){
        StringBuilder stringBuilder = new StringBuilder();
        String c = content;
        for (int i = 0; i < content.length(); i++){
            if (Character.isDigit(content.charAt(i))){
                if (stringBuilder.length() == 0 && Integer.valueOf(content.substring(i,i+1))== 0){
                    continue;
                }
                stringBuilder.append(content.substring(i,i+1));
                if(i == content.length()-1){
                    if(stringBuilder.length()<=10 && stringBuilder.length()>=6){
                       c = c.replace(new String(stringBuilder),"");
                    }
                }
            }else {
                if(stringBuilder.length()<=10 && stringBuilder.length()>=6){
                    c = c.replace(new String(stringBuilder),"");
                }
            }
        }
        return c;
    }


    //25%
    public String filterContent1 (String content) {
        // write code here
        StringBuilder stringBuilder = new StringBuilder();
        //char[] chars = new char[content.length()];
        for (int i = 0; i < content.length(); i++){
            if (content.charAt(i) > 0 && content.charAt(i) <= 9){
                continue;
            }else {
                stringBuilder.append(content.charAt(i));
            }
        }
        String ret = "";
        ret += stringBuilder.substring(0,stringBuilder.length());

        return ret;
    }
}
