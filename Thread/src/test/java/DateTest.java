import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author kong
 * @Date 2022/6/14 10:39
 * @Version 1.0
 * @Desc
 */
public class DateTest {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date(System.currentTimeMillis())));
    }
}
