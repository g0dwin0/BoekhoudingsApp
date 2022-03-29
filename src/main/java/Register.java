import java.util.ArrayList;

public class Register {
    private static ArrayList<Dag> dagen = new ArrayList<Dag>();

    public static ArrayList<Dag> getDagen() {
        return dagen;
    }

    public static void addDag(Dag dag) {
        Register.dagen.add(dag);
    }
}
