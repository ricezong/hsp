import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author kong
 * @Date 2022/4/7 17:08
 * @Version 1.0
 * @Desc Lambda表达式练习
 */
//https://blog.csdn.net/weixin_36133625/article/details/116903121
//https://blog.csdn.net/weixin_39407066/article/details/88805123
//https://blog.csdn.net/mu_wind/article/details/109516995
/**
 * Lambda表达式的语法:
 * ”基本语法: (parameters) -> expression 或 (parameters) ->{ statements; }
 * 中间操作常用方法有：筛选：filter 映射：map 排序：sorted提取与组合 收集：collect。
 * 终止操作：遍历：foreach 匹配：find、match 规约：reduce 聚合：max、min、count
 */
public class LambdaTest {

    public List<Student> initData(){
        List<Student> list=new ArrayList();
        list.add(new Student("赵丽颖", 28, 95));
        list.add(new Student("赵丽颖", 28, 95));
        list.add(new Student("杨颖", 26, 88));
        list.add(new Student("迪丽热巴", 25, 55));
        list.add(new Student("柳岩", 38, 33));
        return list;
    }

    /**
     * 创建Stream的方法的4种方式
     */
    @Test
    public void createStream() {
        //方式1：Collection接口的方法
        Collection collection = new ArrayList();
        //获取串行流
        Stream stream = collection.stream();
        //获取并行流
        Stream pStream = collection.parallelStream();
        //方式2：通过Arrays中的Stream方法  数组
        IntStream intStream = Arrays.stream(new int[]{1, 2, 3, 4, 5});
        //方式3：Stream中的of方法
        Stream<String> ofStream = Stream.of("111", "222", "333");
        //方法4：Stream中的方法  创建无限流  （结果是无线个）
        Stream<Integer> iterate = Stream.iterate(2, (x) -> x + 2);
        System.out.println(stream);
        System.out.println(pStream);
        System.out.println(intStream);
        System.out.println(ofStream);
        System.out.println(iterate);
    }

    /**
     * Stream filter(Predicate<?super T> predicate)返回由与此给定谓词匹配的此流的元素组成的流。
     * —>接收Lambda，从流中排除某些元素
     */
    @Test
    public void filterTest() {
        List<Student> list = initData();
        //1：创建Stream;
        Stream<Student> stream = list.stream();
        //2：filter方法（找到年龄大于等于18岁的学生）
        //Stream<Student> studentStream = stream.filter((student) -> student.getAge() >= 18);
        //3：终止操作;如果没有终止操作的话，上面的第二步中间操作不执行
        //studentStream.forEach(System.out::println);
        List<Student> students = stream.filter(s -> {
            return s.getAge() > 50;
        }).collect(Collectors.toList());
        System.out.println("students:"+students);
        /**
         * 注意：如果只执行1,2操作的话，不会有任何结果。
         * 验证出Steam操作是延迟的，只有进行了终止操作，才会执行中间操作！这就是所谓的延迟加载
         */
    }

    /**
     * Stream limit(Long maxSize)
     * 返回由该流的元素组成的流，截断长度不能超过maxSize. 只有找到maxSize个满足条件的即可。
     * ---->截断流，使其元素不超过给定的数量
     */
    @Test
    public void limitTest() {
        List<Student> list = initData();
        //Limit方法 短路(效率增高)，只要找到了2个满足条件的，后面的迭代操作就不在执行了！
        list.stream().filter(x -> {
            System.out.println("正在过滤！！");
            return x.getAge() > 18;
        }).limit(2).forEach(System.out::println);
    }

    /**
     * Stream skip(Long n)
     * ---->跳过元素，返回一个扔掉了前n个元素的流。
     * 如果流中的元素不足n个，则返回一个空流，与limit(n)互补
     */
    @Test
    public void skipTest(){
        List<Student> list = initData();
        //skip 方法跳过前2个满足条件的  留下后面满足条件的结果！！
        list.stream().filter(x -> {
            System.out.println("正在过滤后面满足条件的结果");
            return x.getAge() > 18;
        }).skip(2).forEach(System.out::println);
    }

    /**
     * Stream distinct()
     * 注意：
     * 自定义的类在去重的过程中必须重写hashCode和equals方法，因为distinct实现的时候底层去找这两个方法
     */
    @Test
    public void distinctTest(){
        List<Student> list = initData();
        //distinct 去重操作！
        list.stream().distinct().forEach(System.out::println);
    }

    /**
     *  map映射：
     * 如果需要将流中的元素映射到另一个流中，可以使用map方法。方法签名：
     * Stream map(Function<? super T, ? extends R> mapper);
     * 该接口需要一个Function函数式接口参数，可以将当前流中的T类型数据转换为另一种R类型的流
     */
    @Test
    public void mapTest(){
        Stream<String> original = Stream.of("11", "22", "33");
        Stream<Integer> result = original.map(Integer::parseInt);
        result.forEach(s -> System.out.println(s + 10));
        //这段代码中，map方法的参数通过方法引用，将字符串类型转换成为了int类型（并自动装箱为Integer类对象）。
        //案例1、2下面两种写法等同
        List<Student> list = initData();
        //写法1
        list.stream().map((x)->x.getName()).forEach(System.out::println);
        //写法2
        list.stream().map(Student::getName).forEach(System.out::println);
    }

    /**
     * 排序 (两种方式)
     *
     * （1）Stream sorted()返回此流元素组成的流，根据自然顺序排序。底层按照内部比较器进行排序，实现Comparable接口中的compareTo方法。
     *
     * （2）Stream sorted(Comparator<?super T>comparator) 返回由此元素组成的流，根据挺的Comparator进行顺序排序。指定顺序。
     * 指定排序策略：底层按照外部比较器进行排序 Comparator接口一定要重新Compare方法
     */
    @Test
    public void sortedTest(){
        // sorted(): 根据元素的自然顺序排序
        // sorted(Comparator<? super T> comparator): 根据比较器指定的规则排序
        Stream.of(33, 22, 11, 55)
                //.sorted()
                .sorted((o1, o2) -> o2 - o1)
                .forEach(System.out::println);
        //这段代码中，sorted方法根据元素的自然顺序排序，也可以指定比较器排序。
    }

    /**
     * 查找(find)和匹配(match)
     *
     * 如果需要找到某些数据，可以使用find相关方法。方法签名：
     *
     * Optional findFirst();
     * Optional findAny();
     * Stream流中的find相关方法使用代码
     */
    @Test
    public void findTest(){
        List<Student> list = initData();
        System.out.println(list.stream().findFirst());
        System.out.println(list.stream().filter(s->s.getAge()>55).findAny());
        Optional<Integer> first = Stream.of(5, 3, 6, 1).findFirst();
        System.out.println("first = " + first.get());

        Optional<Integer> any = Stream.of(5, 3, 6, 1).findAny();
        System.out.println("any = " + any.get());
    }

    /**
     * Stream流的match方法
     *
     * 如果需要判断数据是否匹配指定的条件，可以使用Match相关方法。方法签名：
     *
     * boolean allMatch(Predicate<? super T> predicate);
     * boolean anyMatch(Predicate<? super T> predicate);
     * boolean noneMatch(Predicate<? super T> predicate);
     * 基本使用
     * Stream流中的Match相关方法使用代码如
     */
    @Test
    public void matchTest(){
        boolean b = Stream.of(5, 3, 6, 1)
                // .allMatch(e -> e > 0); // allMatch: 元素是否全部满足条件
                // .anyMatch(e -> e > 5); // anyMatch: 元素是否任意有一个满足条件
                .noneMatch(e -> e < 0); // noneMatch: 元素是否全部不满足条件
        System.out.println("b = " + b);
    }

    /**
     * Stream流的max、min
     */
    @Test
    public void numTest(){
        List<String> list13 = Arrays.asList("zhangsan","lisi","wangwu","xuwujing");
        int maxLines = list13.stream().mapToInt(String::length).max().getAsInt();
        int minLines = list13.stream().mapToInt(String::length).min().getAsInt();
        System.out.println("最长字符的长度:" + maxLines+",最短字符的长度:"+minLines);
        //最长字符的长度:8,最短字符的长度:4
    }

    /**
     * Stream流的count
     */
    @Test
    public void countTest() {
        List<String> strList = new ArrayList<>();
        Collections.addAll(strList, "张无忌", "周芷若", "赵敏", "小昭", "杨不悔");
        System.out.println(strList.stream().count());
        strList.stream().close();
    }

    /**
     * 分组：groupingBy；
     * 当我们使用Stream流处理数据后，可以根据某个属性将数据分组
     */
    @Test
    public void groupTest(){
        List<Student> list = initData();
        // Map<Integer, List<Student>> map = studentStream.collect(Collectors.groupingBy(Student::getAge));
        // 将分数大于60的分为一组,小于60分成另一组
        Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy((s) -> {
            if (s.getScore() > 60) {
                return "及格";
            } else {
                return "不及格";
            }
        }));
        map.forEach((k, v) -> {
            System.out.println(k + "::" + v);
        });
    }

    /**
     * Collectors.joining会根据指定的连接符，将所有元素连接成一个字符串。
     * 拼接
     */
    @Test
    public void joiningTest(){
        List<Student> list = initData();
        String collect = list.stream()
                .map(Student::getName)
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
    }

    /**
     * 聚合：toList,toSet,toMap;
     *
     * Stream流提供collect方法，其参数需要一个java.util.stream.Collector<T,A, R>接口对象来指定收集到哪种集合中。
     *
     * public static Collector<T, ?, List> toList()：转换为List集合。
     * public static Collector<T, ?, Set> toSet()：转换为Set集合。
     * public static <T, K, U> Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
     * Function<? super T, ? extends U> valueMapper):转换为Map集合。
     * 将流中数据收集到集合中
     */
    @Test
    public void testStreamToCollection() {
        Stream<String> stream = Stream.of("aa", "bb", "cc");
        // List<String> strList = stream.collect(Collectors.toList());
        // Set<String>  strSet = stream.collect(Collectors.toSet());

        ArrayList<String> arrayList = stream.collect(Collectors.toCollection(ArrayList::new));
        //HashSet<String> hashSet = stream.collect(Collectors.toCollection(HashSet::new));
        System.out.println(arrayList);
    }

    /**
     * toMap
     */
    @Test
    public void testCollectToMap(){
        //案例1
        List<Integer> list = Arrays.asList(1, 2, 3);
        Map<String, String> collect1 = list.stream().map(i -> i).collect(Collectors.toMap(key -> "key" + key, value -> "value:" + value));

        //实体list转化map id作为主键，对象作为value
        List<UserTask> userList =new ArrayList<>();
        UserTask userTask = new UserTask();
        userTask.setId(1);
        userTask.setName("测试");
        userList.add(userTask);

        Map<Integer,UserTask> taskMap = userList.stream().collect(Collectors.toMap(UserTask::getId, entity -> entity));
        System.out.println(collect1.toString());
        System.out.println(taskMap.toString());
    }

    /**
     * 遍历集合
     */
    @Test
    public void forEachTest(){
        List<Student> list = initData();
        //方式一
        list.forEach(s-> System.out.println(s.getName()));
        //方式二
        list.forEach(System.out::print);

        System.out.println("=======================================================");
        //使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("使用匿名内部类");
            }
        }).start();

        new Thread(() -> System.out.println("Hello world !")).start();

        //使用匿名内部类
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        };

        Runnable race2 = () -> System.out.println("使用匿名内部类!");

        race1.run();
        race2.run();
    }

    /**
     *collect，收集，可以说是内容最繁多、功能最丰富的部分了。从字面上去理解，就是把一个流收集起来，最终可以是收集成一个值也可以收集成一个新的集合。
     */
    @Test
    public void collectTest(){
        List<Student> list = initData();
        Student s = list.stream().sorted((s1, s2) -> s1.getAge().compareTo(s2.getAge()))
                .limit(5)
                .distinct()
                .max((s1,s2)->(s1.getScore()-s2.getScore()))
                .get();
                //.collect(Collectors.toList());
        System.out.println(s);

        List<Student> students = list.stream().sorted((s1, s2) -> s1.getAge().compareTo(s2.getAge()))
                .limit(5)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(students);
    }

    /**
     * 归约(reduce)
     * 归约，也称缩减，顾名思义，是把一个流缩减成一个值，能实现对集合求和、求乘积和求最值操作。
     */
    @Test
    public void reduceTest(){
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        // 求和方式1
        Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);
        // 求和方式2
        Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
        // 求和方式3
        Integer sum3 = list.stream().reduce(0, Integer::sum);

        // 求乘积
        Optional<Integer> product = list.stream().reduce((x, y) -> x * y);

        // 求最大值方式1
        Optional<Integer> max = list.stream().reduce((x, y) -> x > y ? x : y);
        // 求最大值写法2
        Integer max2 = list.stream().reduce(1, Integer::max);

        System.out.println("list求和：" + sum.get() + "," + sum2.get() + "," + sum3);
        System.out.println("list求积：" + product.get());
        System.out.println("list求和：" + max.get() + "," + max2);
    }

}

class Student {
    String name;
    Integer age;
    Integer score;

    public Student() {
    }

    public Student(String name, Integer age, Integer score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(age, student.age) &&
                Objects.equals(score, student.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, score);
    }
}
class UserTask{
    Integer id;
    String name;

    public UserTask() {
    }

    public UserTask(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserTask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
