import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();

        while (true) {
            getChoice(scanner.nextLine());
        }
    }

    public static void showMenu() {
        System.out.println("""
                Boekhouding Applicatie 1.0 """);

        System.out.println("1) Invoegen inkomsten/uitgave");
        System.out.println("2) Inzage dagen");

        System.out.println("X) Programma sluiten");
        System.out.println("Uw keuze:");
    }

    public static void getChoice(String choice) {
        switch (choice) {
            case "1":
                Dag dag = null;
                while (true) {
                    System.out.println("Voor welke datum wilt u uw inkomsten/uitgave rapporteren?\n" +
                            "Formaat is: d-M-yyyy, bijv 24-2-2022. Als u de datum van vandaag wilt gebruiken dient u hier niets in te vullen alleen op ENTER te drukken.");


                    Scanner scanner = new Scanner(System.in);
                    String date = scanner.nextLine();

                    try {
                        dag = new Dag(date);
                        break;
                    } catch (Exception e) {
                        System.out.println("Deze keuze is onjuist. Probeer het opnieuw.");
                    }
                }
                while (true) {
                    System.out.println("Wilt u [i]nkomsten of [u]itgaven doorgeven? U kunt ook dit menu [v]erlaten.");
                    //doe dingen met input
                    String keuze = scanner.nextLine();

                    if (keuze.equals("i") || keuze.equals("u")) {
                        System.out.println("Naam van inkomen/uitgave: ");
                        String naam = scanner.nextLine();
                        System.out.println("Prijs van inkomen/uitgave: ");
                        Double hoeveelheid = scanner.nextDouble();

                        Record record = new Record(naam, hoeveelheid);

                        if (keuze.equals("i")) {
                            // Inkomst
                            assert dag != null;
                            dag.addInkomsten(record);
                        } else {
                            // Uitgave
                            assert dag != null;
                            dag.addUitgaven(record);
                        }
                        Register.addDag(dag);
                        System.out.println("Toegevoegd aan de geselecteerde dag!");

                        System.out.println("Wilt u meer inkomsten/uitgaven doorgeven? [j]a/[n]ee");
                        scanner.nextLine();
                        keuze = scanner.nextLine();
                        // vraag om nieuwe input
                        // lees input
                        if (keuze.equals("j")) {

                        }
                        if (keuze.equals("n")) {
                            System.out.println("Einde invoer.");
                            showMenu();
                            break;
                        }
                        if (!(keuze.equals("n")) || !(keuze.equals("j"))) {
                            System.out.println("Onjuiste input.");
                        }
                    }
                    break;

                }
                break;
            case "2":
                if(Register.getDagen().isEmpty()) {
                    System.out.println("Er is geen informatie beschikbaar.");
                } else {
                    ArrayList<Dag> dagen = Register.getDagen();
                    for(Dag idxDag : dagen) {
                        System.out.println("Dag ID: " + Register.getDagen().indexOf(idxDag));
                        System.out.println("Datum: " + idxDag.getDate().toString());

                        System.out.println("Inkomsten: ");
                        for(Record inkomsten : idxDag.getInkomsten()) {
                            System.out.println("Label: " + inkomsten.getLabel());
                            System.out.println("Bedrag: " + inkomsten.getPrijs());
                        }
                        System.out.println("Uitgaven: ");
                        for(Record uitgaven : idxDag.getUitgaven()) {
                            System.out.println("Label: " + uitgaven.getLabel());
                            System.out.println("Bedrag: " + uitgaven.getPrijs());
                        }
                        System.out.println("\n");
                    }
                }
                showMenu();

                break;
//            case "3":
//                studentRegister();
//                break;
            case "`":
                break;
            default:
                System.out.println(" is geen juiste optie, probeer het opnieuw.");
        }
    }
}
