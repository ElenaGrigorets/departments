package springInAction;

/**
 * Created by dmitry on 20.03.18.
 */
public class Knight {
    private Quest quest;

    public Knight(Quest quest) {
        this.quest = quest;
    }

    public void embarkKnight() {
        quest.embark();
    }
}
