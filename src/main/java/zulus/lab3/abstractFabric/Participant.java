package zulus.lab3.abstractFabric;

/**
 * Created by zulus on 23.02.18
 */

/**
 * defines participant of competition
 */
public class Participant {
    private String _name;

    private String _school;
    private int _classOfParticipant;
    private Type _type;

    /**
     * type of participant
     */
    public enum Type {
        LOOSER, WINNER, DIPLOMAT
    }

    public Participant(String name, Type type, String school, int _classOfParticipant) {
        setName(name);
        setType(type);
        setClassOfParticipant(_classOfParticipant);
        setSchool(school);
    }

    public String getSchool() {
        return _school;
    }

    public void setSchool(String _school) {
        this._school = _school;
    }

    public int getClassOfParticipant() {
        return _classOfParticipant;
    }

    public void setClassOfParticipant(int classOfParticipant) {
        if (classOfParticipant < 0 || classOfParticipant > 11)
            throw new IllegalArgumentException("Argument class must be a number from range [1,11]");
        this._classOfParticipant = classOfParticipant;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public Type getType() {
        return _type;
    }

    public void setType(Type type) {
        if (type == null) throw new IllegalArgumentException("Argument type must be not-null value");
        this._type = type;
    }

    @Override
    public String toString() {
        return String.format("Participant '%s'form: %2d school: '%s' type: %s", _name, _classOfParticipant, _school, _type);
    }
}
