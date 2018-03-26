package springInAction.juggles;

/**
 * Created by dmitry on 26.03.18.
 */
public class Instrumentalist implements Performer {
    private String songString;
    private Instrument instrument;

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void setSongString(String songString) {
        this.songString = songString;
    }

    @Override
    public void perform() throws PerformanceException {
        instrument.play();
    }
}
