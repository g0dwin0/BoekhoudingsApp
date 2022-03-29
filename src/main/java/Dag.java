import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Dag {

    private ArrayList<Record> inkomsten = new ArrayList<Record>();
    private ArrayList<Record> uitgaven = new ArrayList<Record>();

    private LocalDate date;

    public Dag() {

    }
    public Dag(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-y", Locale.ENGLISH);
        LocalDate objDate = LocalDate.parse(date, formatter);
        this.date = objDate;
    }

    public ArrayList<Record> getInkomsten() {
        return inkomsten;
    }
    public void addInkomsten(Record record) {
        this.inkomsten.add(record);
    }

    public void addUitgaven(Record record) {
        this.uitgaven.add(record);
    }



    public void setInkomsten(ArrayList<Record> inkomsten) {
        this.inkomsten = inkomsten;
    }

    public ArrayList<Record> getUitgaven() {
        return uitgaven;
    }

    public void setUitgaven(ArrayList<Record> uitgaven) {
        this.uitgaven = uitgaven;
    }

    public LocalDate getDate() {
        return date;
    }

    public void Date(LocalDate date) {
        this.date = date;
    }
}
