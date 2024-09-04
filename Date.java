import java.io.Serializable;

public class Date implements Serializable {
    int day, month, year;

    public Date(){
        day = 8;
        month = 11;
        year = 2022;
    }

    public Date(int d, int m, int y){
        day = d;
        month = m;
        year = y;
    }

    public Date(Date d){
        this.day = d.day;
        this.month = d.month;
        this.year = d.year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int d) {
        day = d;
    }

    public void setMonth(int m) {
        month = m;
    }

    public void setYear(int y) {
        year = y;
    }

    public String toString(){
        return day + " / " + month + " / " + year;
    }
}
