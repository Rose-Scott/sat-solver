//broad representation understanding
//we have a list of "variables"
//we have a literal class which contains an id number to refrence a variable and if negated
//clauses are literals connected by ors
//formulas are clauses connected by ands

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import datatypes.Formula;
import datatypes.TruthValue;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        //get files
        if (args.length == 0) {
            System.err.println("Usage: java main <test_file>");
            System.exit(1);
        }
        
        //DIMACS call
        File test = new File(args[0]);
        Formula formula = Parser.parseDIMACSCNF(test);
        TruthValue[] values = new TruthValue[formula.getVariables() + 1];
        Arrays.fill(values, TruthValue.UNASSIGNED);
        Boolean result = Dpll.dpplStep(formula, values);
        System.out.println(result);

    }
}
