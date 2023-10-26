package in.stackroute.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter



public class Reminder {

    private int id;
    private String text;
    private LocalDate date;
    private boolean remind;

    public Reminder(int id, String text, LocalDate date, boolean remind) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.remind = remind;

    }
}
