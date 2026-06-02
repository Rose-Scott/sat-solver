package datatypes;
public class Literal {
    int variableId;
    boolean isNegated;
    
    public Literal(int variableId, boolean isNegated)   {
        this.variableId = variableId;
        this.isNegated = isNegated;
    }

    @Override
    public String toString()   {
        return isNegated ? "-x" + variableId : "x" + variableId;
    }
}
