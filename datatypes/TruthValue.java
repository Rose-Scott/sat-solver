package datatypes;
//represent the state of variables that may not yet be defined
public enum TruthValue {
    TRUE,
    FALSE,
    UNASSIGNED;

    public boolean isTrue() {
        return this == TRUE;
    }

    public boolean isAssigned() {
        return this != UNASSIGNED;
    }
}
