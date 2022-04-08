import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author kong
 * @Date 2022/4/7 17:08
 * @Version 1.0
 * @Desc
 */

public class LambdaTest {

    @Test
    public void filterTest(){

    }
}
class Student{
    String name;
    Integer age;
    Integer score;

    public Student() { }

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
}
