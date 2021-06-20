package Hash;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiK on 2016/12/12.
 */
public class HuffmanCoding {
    public static final Double[] probability = new Double[]{0.2,0.19,0.18,0.17,0.16,0.08,0.02};

    public static void main(String[] args) {
        getHuffmanCode(probability);
    }

    /**
     * 由概率得哈夫曼编码
     * @param probab
     * @return
     */
    public static String[] getHuffmanCode(Double[] probab) {
        int publicIndex = 0;

        //probab从小到大排序
        probab = sort(probab);

        List<Node> list = new ArrayList<Node>();
        List<Node> allList = new ArrayList<Node>();
        for(Double p : probab) {
            Node node = new Node();
            node.setIndex(publicIndex++);       //设置脚标
            node.setProbability(p);             //设置概率
            allList.add(node);
            list.add(node);
        }

        while(list.size() > 1) {
            //1.排 序
            list = sortList(list);

            //2.取最小的两个,设置编码
            Node nodeL = list.get(0);
            Node nodeR = list.get(1);
            for(int i = 0; i < allList.size(); i++) {
                if(nodeL.getIndex() == allList.get(i).getIndex()) {
                    allList.get(i).setCode("0");
                    break;
                }
            }
            for(int i = 0; i < allList.size(); i++) {
                if(nodeR.getIndex() == allList.get(i).getIndex()) {
                    allList.get(i).setCode("1");
                    break;
                }
            }

            //3.增父节点
            Node parentNode = new Node();
            parentNode.setParentFlag(true);
            parentNode.setIndex(publicIndex++);
            parentNode.setProbability(nodeL.getProbability() + nodeR.getProbability());
            parentNode.setSonIndex1(nodeL.getIndex());
            parentNode.setSonIndex2(nodeR.getIndex());
            list.add(parentNode);
            allList.add(parentNode);

            //4.减子节点，
            list.remove(0);
            list.remove(0);

        }

        //逆向确定完整编码
        reverseSearch(allList, allList.size() - 1);

        //输出前probab.length个元素
        String[] strings = new String[probab.length];
        for(int i = 0; i < probab.length; i++) {
            System.out.println(allList.get(i).getProbability() + ": " + allList.get(i).getCode());
            strings[i]= allList.get(i).getProbability() + ": " + allList.get(i).getCode();
        }



        return strings;
    }

    /**
     * 逆向确定编码
     * @param allList
     * @param index
     */
    public static void reverseSearch(List<Node> allList, int index) {
        Node node = allList.get(index);
        if(node.isParentFlag()) {
            String code1 = allList.get(node.getSonIndex1()).getCode();
            String code2 = allList.get(node.getSonIndex2()).getCode();
            allList.get(node.getSonIndex1()).setCode(node.getCode() + "" + code1);
            allList.get(node.getSonIndex2()).setCode(node.getCode() + "" + code2);
            reverseSearch(allList, node.getSonIndex1());
            reverseSearch(allList, node.getSonIndex2());
        }
    }

    /**
     * 在List中进行冒泡排序
     * @param list
     * @return
     */
    public static List<Node> sortList(List<Node> list) {
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.size() - i - 1; j++) {
                if(list.get(j).getProbability() > list.get(j + 1).getProbability()) {
                    Node temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

        return list;
    }

    /**
     * 冒泡排序
     * @param probab
     * @return
     */
    public static Double[] sort(Double[] probab) {
        for(int i = 0; i < probab.length; i++) {
            for(int j = 0; j < probab.length - i - 1; j++) {
                if(probab[j] > probab[j + 1]) {
                    Double temp = probab[j];
                    probab[j] = probab[j + 1];
                    probab[j + 1] = temp;
                }
            }
        }

        return probab;
    }
}