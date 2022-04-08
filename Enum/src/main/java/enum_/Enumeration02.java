package enum_;

/**
 * @Author kong
 * @Date 2022/4/7 15:32
 * @Version 1.0
 * @Desc 演示自定义枚举类实现
 */
public class Enumeration02 {
    public static void main(String[] args) {
        //对于季节而言对象是固定的只有四个
        /**
         * 枚举类【枚：一个一个   举：例举】：把具体的对象一个一个例举出来的类
         */
        System.out.println(Season.AUTUMN);

    }
}
/**
 * 将构造器私有化防止直接new出来
 * 去掉setXXX相关方法，防止属性被修改
 * 在类内部创建固定的对象
 * 优化：加入final
 */
class Season{

    private String name;
    private String desc;

    public static final Season SPRING=new Season("春天", "春回大地");
    public static final Season SUMMER=new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN=new Season("秋天", "秋高气爽");
    public static final Season WINTER=new Season("冬天", "凛冬将至");

    private Season(String name,String desc){
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
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
