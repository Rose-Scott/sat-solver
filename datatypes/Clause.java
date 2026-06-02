package datatypes;
import java.util.List;

public class Clause {
    List<Literal> literals;

    public Clause(List<Literal> literals)   {
        this.literals = literals;
    }
}
