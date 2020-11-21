package Test2;
class Student {
    private int age;
    private int classroom;
    private String name;
    private int id_card;
    private String sex;
    private int grade;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Student(int age,int classroom,String name,int id_card,String sex,int grade) {
        this.age = age;
        this.classroom = classroom;
        this.name = name;
        this.id_card = id_card;
        this.sex = sex;
        this.grade = grade;
    }

    public void grade() {
        System.out.println(this.name+"学号是:"+id_card+"班级是:"+classroom+"性别是:"
                +sex+"成绩为:"+grade+"分");
    }
}
public class TestDemo1 {
    public static void main(String[] args) {
        Student student = new Student(20,234,"小明",
                20180202,"女",64);
        System.out.println(student.getAge());
        student.grade();
    }
}

