package datatypes;
import java.util.List;

public class Clause {
    List<Literal> literals;

    public Clause(List<Literal> literals)   {
        this.literals = literals;
    }


    public TruthValue satisfied(TruthValue[] variableValues) {
        //loop through literals and determin
        //satisfied, false or incomplete
        boolean unsatisfied = false;
        for (Literal lit : literals) {
            if (variableValues[lit.variableId] == TruthValue.UNASSIGNED) {
                unsatisfied = true;
                continue;
            }
            // A literal is satisfied if its truth value XOR with negation is true
            if (variableValues[lit.variableId].isTrue() ^ lit.isNegated) {
                return TruthValue.TRUE;
            }
        }
        return unsatisfied ? TruthValue.UNASSIGNED : TruthValue.FALSE;
    }

    @Override
    public String toString()    {
        String clause = "";
        clause += "(";
        for (Literal lit : literals)    {
            clause += lit.toString();
            clause += " V ";
        }

        clause = clause.substring(0, clause.length() - 3);
        clause += ")";
        return clause;
    }
}
