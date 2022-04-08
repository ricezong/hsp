package enum_;

/**
 * @Author kong
 * @Date 2022/4/7 16:24
 * @Version 1.0
 * @Desc 演示enum类各种方法的使用
 */
public class EnumMethod {
    public static void main(String[] args) {
        Season2 autumn=Season2.AUTUMN;
        //name()获取枚举对象名称
        System.out.println(autumn.name());
        //ordinal()输出的是枚举对象的次序，从0开始计数
        System.out.println(autumn.ordinal());
        //values()返回所有定义的枚举对象
        Season2[] values = Season2.values();
        //根据定义好的枚举常量找枚举
        Season2 value = Season2.valueOf("AUTUMN");
        System.out.println(value);
        for (Season2 season2:values) {
            System.out.println(season2);
        }
        //compareTo()比较俩个枚举常量的编号
        System.out.println(Season2.AUTUMN.compareTo(Season2.SUMMER));

    }
}
