package springInAction.juggles;

public class PoeticJuggler extends Juggler {
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
        stage.pringSomething();
    }

    public void beforeStart() {
        System.out.println("hello");
    }
    public void beforeStop() {
        System.out.println("goodbye");
    }
}