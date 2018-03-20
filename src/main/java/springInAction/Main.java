package springInAction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dmitry on 20.03.18.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("knight.xml");
        Knight knight = (Knight) context.getBean("knight");
        knight.embarkKnight();
    }
}
