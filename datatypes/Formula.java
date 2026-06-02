package datatypes;
import java.util.List;

public class Formula {
    List<Clause> clauses;

    public Formula (List<Clause> clauses)   {
        this.clauses = clauses;
    }

    @Override
    public String toString()    {
        String formula = "";

        for (Clause cls: clauses)   {
            formula += cls.toString();
            formula += " ^";
        }

        formula = formula.substring(0,formula.length() - 2);
        return formula;
    }
    
}
