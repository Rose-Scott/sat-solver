package datatypes;
import java.util.List;

public class Formula {
    List<Clause> clauses;
    int variables;

    public Formula (List<Clause> clauses, int variables)   {
        this.clauses = clauses;
        this.variables = variables;
    }

    public List<Clause> getClauses()   {
        return this.clauses;
    }
    public int getVariables()   {
        return this.variables;
    }


    public TruthValue satisfied(TruthValue[] variableValues)    {
        boolean incomplete = false;
        for (Clause clause : clauses) {

            TruthValue clauseSat = clause.satisfied(variableValues);
            if (clauseSat == TruthValue.UNASSIGNED) {incomplete = true;}
            if (clauseSat == TruthValue.FALSE) {return TruthValue.FALSE;}

        }
        return incomplete ? TruthValue.UNASSIGNED : TruthValue.TRUE;
        
    }
    @Override
    public String toString()    {
        String formula = "";

        for (Clause cls: clauses)   {
            formula += cls.toString();
            formula += " ^ ";
        }

        formula = formula.substring(0,formula.length() - 3);
        return formula;
    }
    
}
