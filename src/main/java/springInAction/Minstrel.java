package springInAction;

public class Minstrel {
    public void singBeforeQuest() { // Вызывается перед выполнением задания
        System.out.println("Fa la la; The knight is so brave!");
    }

    public void singAfterQuest() { // Вызывается после выполнения задания
        System.out.println(
                "Tee hee he; The brave knight did embark on a quest!");
    }
}