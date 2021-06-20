package Hash;
/**
 * Created by LiK on 2016/12/12.
 */
public class Node {
    Integer index;
    Double probability;
    String code = "";
    boolean parentFlag = false;
    Integer sonIndex1;
    Integer sonIndex2;

    public Node() {

    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isParentFlag() {
        return parentFlag;
    }

    public void setParentFlag(boolean parentFlag) {
        this.parentFlag = parentFlag;
    }

    public Integer getSonIndex1() {
        return sonIndex1;
    }

    public void setSonIndex1(Integer sonIndex1) {
        this.sonIndex1 = sonIndex1;
    }

    public Integer getSonIndex2() {
        return sonIndex2;
    }

    public void setSonIndex2(Integer sonIndex2) {
        this.sonIndex2 = sonIndex2;
    }
}