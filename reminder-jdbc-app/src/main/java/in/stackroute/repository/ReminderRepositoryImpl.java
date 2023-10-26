package in.stackroute.repository;

import in.stackroute.model.Reminder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;


@Repository
@Qualifier("list")
public class ReminderRepositoryImpl implements ReminderRepository{


    private static List<Reminder> reminders;

    public ReminderRepositoryImpl()
    {
        reminders = new ArrayList<>(
                List.of(
                        new Reminder(1,"Remind me to schedule MCQ assessment for their batch 3", LocalDate.of(2023,8,31),true),
                        new Reminder(2,"Remind me to learn SpringBoot",LocalDate.of(2023,9,2),true),
                        new Reminder(3,"Remind me to the project", LocalDate.of(2023,9,7),true)



                )
        );
    }




    @Override
    public Reminder create(Reminder reminder) {
        reminders.add(reminder);
        return reminder;
    }


    @Override
    public List<Reminder> findAll() {
        return reminders;
    }


    @Override
    public Reminder update(Reminder reminder) {

        for(Reminder rem : reminders)
        {
            if(rem.getId()==reminder.getId()) {
                rem.setText(reminder.getText());


                return rem;
            }
        }
        return null;
    }


    @Override
    public boolean existsById(int id) {

        for(Reminder reminder : reminders)
        {
            if(reminder.getId() == id)
                return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {

        if(!existsById(id))
        {
            return false;
        }

        for (Reminder reminder : reminders)
        {
            if(reminder.getId()==id)
            {
                reminders.remove(reminder);
                return true;
            }
        }

        return false;
    }
}
