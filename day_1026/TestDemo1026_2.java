package day_1026;

class Library{
    private String book;//书籍名称
    private String author;//作者
    private double price;//价格
    private String press;//出版社
    private String area;//区
    private int num;//剩余数量

    public Library(String book, String author, double price, String press, String area,int num) {
        this.book = book;
        this.author = author;
        this.price = price;
        this.press = press;
        this.area = area;
        this.num = num;
    }

    //修改书本价格
    public void changePrice(Library books, double newPrice){
        this.price = newPrice;
        System.out.println("《"+books.book + "》价格修改成功！");
    }

    //修改书本放置位置
    public void changeArea(Library books, String newArea){
        this.area = newArea;
        System.out.println("《"+books.book + "》放置区域修改成功！");
    }

    //借阅书籍操作
    public void changeNum(Library books){
        books.num--;
        System.out.println("借阅成功！");
    }


    @Override
    public String toString() {
        return "{" +
                "书名：《" + book + '》' +
                ", 作者：" + author +
                ", 价格：" + price +
                ", 出版社" + press + '\'' +
                ", 所在区域" + area + '\'' +", 剩余数量：" + num+
                '}';
    }
}

public class TestDemo1026_2 {
    public static void main(String[] args) {
        Library book1 = new Library("西游记","吴承恩",85.6,"人民出版社","3楼-古代文学-1",10);
        Library book2 = new Library("红楼梦","曹雪芹",54.8,"古代文学出版社","3楼-古代文学-2",7);
        Library book3 = new Library("水浒传","施耐庵",66.9,"人民出版社","3楼-古代文学-2",9);
        Library book4 = new Library("三国演义","罗贯中",75.7,"新华出版社","3楼-古代文学-1",12);

        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());
        System.out.println(book4.toString());

        book1.changePrice(book1,55.6);
        book2.changeArea(book2,"2楼-名著书籍-3");

        System.out.println("修改后的结果为："+book1.toString());

        book1.changeNum(book1);


        System.out.println("修改后的结果为："+book1.toString());



    }
}
