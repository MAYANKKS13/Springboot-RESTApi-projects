package in.stackroute.controller;


import com.fasterxml.jackson.annotation.JacksonInject;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.stackroute.model.Reminder;
import in.stackroute.repository.ReminderRepository;

import java.util.*;

@RestController
@RequestMapping("/api/v1/reminders")

public class ReminderController {


    private final ReminderRepository reminderRepository;
    public ReminderController(@Qualifier("list") ReminderRepository reminderRepository)
    {
        this.reminderRepository = reminderRepository;
    }



   @GetMapping("/all")
    public ResponseEntity<List<Reminder>> getAllReminders()
   {
       var reminders = reminderRepository.findAll();
       if(reminders.isEmpty()){
           return ResponseEntity.noContent().build();
       }

       return ResponseEntity.ok(reminders);
   }


   @PostMapping("/create")
    public ResponseEntity<Reminder> createReminder(@RequestBody Reminder reminder)
   {
       var exists = reminderRepository.existsById(reminder.getId());

       if(exists)
       {
           return ResponseEntity.badRequest().build();
       }

       reminderRepository.create(reminder);
       return ResponseEntity.status(HttpStatus.CREATED).body(reminder);


   }



   @PatchMapping("/update/{id}")
   public ResponseEntity<Reminder> updateReminder(@PathVariable int id, @RequestBody Reminder reminder)
   {
       var exists = reminderRepository.existsById(id);
       if(exists)
       {
           reminder.setId(id);
           Reminder rem = reminderRepository.update(reminder);
           return ResponseEntity.ok(rem);

       }

       else {
           return ResponseEntity.notFound().build();
       }

   }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable int id) {
        if (reminderRepository.existsById(id))
        {
            reminderRepository.delete(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.badRequest().build();
        }

    }
















    
}
