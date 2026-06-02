// must take in a text file to read in the DIMACS CNF 
// formate and create a Formula object and its respective children

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import datatypes.Clause;
import datatypes.Formula;
import datatypes.Literal;


public class Parser {
    public static Formula parseDIMACSCNF(File file) throws FileNotFoundException {
        // implementation to read the file and create a Formula object
        Scanner sc = new Scanner(file);
        int variables = 0;
        int clauses = 0;
        //loop for each line

//WARNING bad files with multiple headers not properly handled yet

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            //skip comments
            if (line.startsWith("c")) {
                continue;
            }
            // header line
            if (line.startsWith("p")) {
                String[] fileInfo = line.split(" ");
                //verify format
                if (!fileInfo[1].equals("cnf")) {throw new IllegalArgumentException("File not of supported type.");}
                variables = Integer.parseInt(fileInfo[2]);
                clauses = Integer.parseInt(fileInfo[3]);
            }

        }
        return new Formula();
    }



//should refactor for safety and based off integer parsing first but minimum viable atm
    public static Clause lineToClause(String line) {
        
        List<Literal> literals = new ArrayList<Literal>();

        String[] stringLiterals = line.split(" ");
        boolean isNegated = false;

        for (String stringLit : stringLiterals) {
            if (stringLit.charAt(0) == '0') {break;}
            if(stringLit.charAt(0) == '-') {
                isNegated = true;
            }
            literals.add(new Literal(Math.abs(Integer.parseInt(stringLit)), isNegated));
            isNegated = false;
        }
        
        return new Clause(literals);
    }
}
