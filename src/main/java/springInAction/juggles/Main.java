package springInAction.juggles;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springInAction.Knight;

/**
 * Created by dmitry on 20.03.18.
 */
public class Main {
    public static void main(String[] args) throws PerformanceException {
        ApplicationContext context = new ClassPathXmlApplicationContext("juggles.xml");
        PoeticJuggler poeticJuggler15 = (PoeticJuggler) context.getBean("poeticJuggler");
        poeticJuggler15.perform();
    }
}
