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
        boolean incomplete = false;
        for (Literal lit : literals) {
            if (variableValues[lit.variableId] == TruthValue.UNASSIGNED) {
                incomplete = true;
                continue;
            }
            // A literal is satisfied if its truth value XOR with negation is true
            if (variableValues[lit.variableId].isTrue() ^ lit.isNegated) {
                return TruthValue.TRUE;
            }
        }
        return incomplete ? TruthValue.UNASSIGNED : TruthValue.FALSE;
    }
    public boolean isUnitClause(TruthValue[] variableValues)  {
        int numUnasigned = 0;

        for (Literal lit: literals) {
            if (!variableValues[lit.variableId].isAssigned())    {numUnasigned++;}
            if (variableValues[lit.variableId].isTrue() ^ lit.isNegated) {return false;}
        }

        return (numUnasigned == 1) ? true : false;
    }

    //pre condition is that the clause is a unit clause ie there is exactly one unnasigned lit
    public Literal unnasigned(TruthValue[] variableValues)  {
        for (Literal lit : literals)    {
            if (!variableValues[lit.variableId].isAssigned())   {return lit;}
        }
        return null;
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
