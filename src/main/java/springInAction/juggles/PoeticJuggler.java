package springInAction.juggles;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class PoeticJuggler extends Juggler implements InitializingBean, DisposableBean{
    private Poem poem;
    private Stage stage;

    public PoeticJuggler(Poem poem) { // Внедрение поэмы
//        super();
        this.poem = poem;
    }

    public PoeticJuggler(int beanBags, Poem poem, Stage stage) {
        super(beanBags);
        this.poem = poem;
        this.stage = stage;
    }

    // Внедрение количества
// мячиков и поэмы
    public void perform() throws PerformanceException {
        super.perform();
        System.out.println("While reciting...");
        poem.recite();
        stage.printSomething();
    }

    public void beforeStart() {
        System.out.println("hello");
    }
    public void beforeStop() {
        System.out.println("goodbye");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("fdfd" + poem.toString());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("fdfd2222" + poem.toString());
    }
}