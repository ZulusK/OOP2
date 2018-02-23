package zulus.lab3.abstractFabric;

/**
 * Created by zulus on 23.02.18
 */

import java.util.Random;

/**
 * defines loader of participants, that uses singleton pattern
 * used like DB
 */
public class ParticipantsLoader {
    static ParticipantsLoader _instance;


    /**
     * emulates request to DB
     *
     * @return
     */
    public Participant[] getParticipants(int count) {
        String names[] = "Sam, Jack, Nicol, Denis, Archibald,  Ron, John, Helen, Ann, Diana, Bill, Daniel, Tonya".split(",\\s*");
        String schools[] = "#1, #2, #3, #4".split(",\\s*");
        Participant[] _participants = new Participant[count];
        Participant.Type types[] = Participant.Type.values();
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < _participants.length; i++) {
            _participants[i] = new Participant(
                    names[rand.nextInt(names.length)],
                    types[rand.nextInt(types.length)],
                    schools[rand.nextInt(schools.length)],
                    1 + rand.nextInt(11));
        }
        return _participants;
    }

    private ParticipantsLoader() {

    }

    /**
     * get instance of loader
     *
     * @return instance of loader
     */
    public static ParticipantsLoader getInstance() {
        if (_instance == null) {
            _instance = new ParticipantsLoader();
        }
        return _instance;
    }

}
