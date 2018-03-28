package springInAction.juggles;

public class Stage {
    private Performer performer;

    public void setPerformer(Performer performer) {
        this.performer = performer;
    }

    private Stage() {
    }

    public void printSomething() {
        System.out.println("stage print");
    }

    private static class StageSingletonHolder {
        static Stage instance = new Stage(); // Создание экземпляра
    }

    public void beginShow() throws PerformanceException {
        System.out.println("begin");
        performer.perform();
    }

    public static Stage getInstance() {
        return StageSingletonHolder.instance; // Возвращает экземпляр
    }
}