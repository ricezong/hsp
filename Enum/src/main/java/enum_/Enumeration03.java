package enum_;

/**
 * @Author kong
 * @Date 2022/4/7 15:59
 * @Version 1.0
 * @Desc 演示使用enum关键字实现枚举类
 */
public class Enumeration03 {
    public static void main(String[] args) {

        System.out.println(Season2.AUTUMN.getDesc());
    }
}

/**
 * 使用enum关键字实现枚举
 * 枚举需定义在成员变量之前且多个枚举之间用逗号隔开
 * 使用enum关键字后就不能继承其他类了，因为enum会隐士继承Enum,java是单继承，但可以实现其他接口
 */
enum Season2{

    SPRING("春天", "春回大地"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "凛冬将至");
    //如果使用无参构造器创建对象则可以省略括号和括号里的内容，例SUMMER

    private String name;
    private String desc;

    private Season2(String name,String desc){
        this.name=name;
        this.desc=desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season2{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
