package in.stackroute.repository;


import in.stackroute.model.Reminder;

import java.util.*;

public interface ReminderRepository {

    Reminder create(Reminder reminder);

    List<Reminder> findAll();

    Reminder update(Reminder reminder);

    boolean existsById(int id);

    boolean delete(int id);




    
}
