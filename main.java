//broad representation understanding
//we have a list of "variables"
//we have a literal class which contains an id number to refrence a variable and if negated
//clauses are literals connected by ors
//formulas are clauses connected by ands

import java.io.File;
import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        File test = new File("testDIMACS1.txt");
        System.out.println(Parser.parseDIMACSCNF(test));
    }
}
