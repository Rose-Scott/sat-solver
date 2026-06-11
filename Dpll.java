import datatypes.Clause;
import datatypes.Formula;
import datatypes.TruthValue;

public class Dpll {
    public static boolean unasignedVariables(TruthValue[] variableValues)   {

        for (TruthValue var: variableValues) {
            if (!var.isAssigned())   {return true;}
        }
        return false;
    }

    public static boolean dpplStep(Formula formula, TruthValue[] values)   {
        TruthValue[] tempValues = values.clone();
        tempValues = unitPropogation(formula, tempValues);
        // 3 branches, solved, branch unsolvable and incomplete
        //solved
        if (formula.satisfied(tempValues).isTrue()) {
            return true;
        }
        //branch unsolvable
        else if (formula.satisfied(tempValues) == TruthValue.FALSE) {
            //propogate back error
            return false;
        }
        //guess
        else    {
            int unnasignedIndex = findUnassigned(tempValues);
            // guess positive
            tempValues[unnasignedIndex] = TruthValue.TRUE;
            boolean success = dpplStep(formula,tempValues);
            if (success) {return true;}

            // guess negative
            tempValues[unnasignedIndex] = TruthValue.FALSE;
            success = dpplStep(formula,tempValues);
            if (success) {return true;}

            //failure higher up
            return false;
        }
    }

    public static TruthValue[] unitPropogation(Formula formula, TruthValue[] values)   {
        boolean madeChanges = true;
        while(madeChanges)  {
            madeChanges = false;

            for (Clause clause : formula.getClauses())  {
                if (clause.isUnitClause(values)) {
                    datatypes.Literal lit = clause.unnasigned(values);
                    //set to the value that makes the unassigned literal evaluate to true
                    values[lit.getVariableId()] = lit.getIsNegated() ? TruthValue.FALSE : TruthValue.TRUE;
                    
                    madeChanges = true;
                }
            }
        }
        return values;
    }
    //precondition something is unassigned
    public static int findUnassigned(TruthValue[] values)  {
        for (int i = 1; i< values.length; i++)  {
            if (!values[i].isAssigned()) {return i;}
        }
        throw new IllegalStateException("No unassigned variables found");
    }
}

