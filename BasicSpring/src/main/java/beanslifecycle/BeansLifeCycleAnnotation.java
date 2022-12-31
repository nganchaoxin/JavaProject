package beanslifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeansLifeCycleAnnotation {
    @PostConstruct
    public void init() {
        System.out.println("init");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("close");
    }
}
