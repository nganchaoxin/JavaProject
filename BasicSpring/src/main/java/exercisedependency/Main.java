package exercisedependency;

import exercisedependency.pojobeans.HocSinh;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("exercisedependency/beans.xml");
        HocSinh hocSinh = applicationContext.getBean("hocSinh", HocSinh.class);
        hocSinh.drawCircle();
    }
}
