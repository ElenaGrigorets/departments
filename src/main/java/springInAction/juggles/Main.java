package springInAction.juggles;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springInAction.Knight;

/**
 * Created by dmitry on 20.03.18.
 */
public class Main {
    public static void main(String[] args) throws PerformanceException {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("juggles.xml");
//        PoeticJuggler poeticJuggler15 = (PoeticJuggler) context.getBean("poeticJuggler");
//        PoeticJuggler poeticJuggler11 = (PoeticJuggler) context.getBean("poeticJuggler");
//        poeticJuggler15.perform();
//
//        Stage stage = (Stage) context.getBean("stage");
//        Stage stage2 = (Stage) context.getBean("stage");
//        Stage stage3 = Stage.getInstance();


        Instrumentalist instrumentalist = (Instrumentalist) context.getBean("instrumentalist");
        instrumentalist.perform();

        Performer performer = (Performer) context.getBean("performer");

        context.registerShutdownHook();

    }
}
