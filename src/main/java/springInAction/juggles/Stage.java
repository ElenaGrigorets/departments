package springInAction.juggles;

public class Stage {
    private Stage() {
    }

    public void pringSomething() {
        System.out.println("stage print");
    }

    private static class StageSingletonHolder {
        static Stage instance = new Stage(); // Создание экземпляра
    }

    public static Stage getInstance() {
        return StageSingletonHolder.instance; // Возвращает экземпляр
    }
}