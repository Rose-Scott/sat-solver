package datatypes;
import java.util.List;

public class Clause {
    List<Literal> literals;

    public Clause(List<Literal> literals)   {
        this.literals = literals;
    }


    @Override
    public String toString()    {
        String clause = "";
        clause += "(";
        for (Literal lit : literals)    {
            clause += lit.toString();
            clause += " V";
        }

        clause = clause.substring(0, clause.length() - 2);
        clause += ")";
        return clause;
    }
}
