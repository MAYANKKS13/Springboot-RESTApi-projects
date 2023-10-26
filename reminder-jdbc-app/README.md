# Reminders REST api - Practice challenge

Create a REST api for the `Reminder` application using spring boot.

```java
class Reminder {
	private int id;
	private Stirng text;
	private LocalDate date;
	private boolean remind;
}
```

```json
{
	id	: 1,
	text	: "Remind me to schedule MCQ assessment for ther batch #3",
	date	: "2023/08/31",
	remind	: true
}
```


| Method | Endpoint   |  Description |
| -------| :----------- | :------------ |
| GET | /reminders | Fetch all reminders |
| POST | /reminders	|	Create a new reminder |
| PUT |		/reminders/{id}		| Update a reminder |
| DELETE |		/reminders/{id}		| Delete a reminder |


## Objectives

- Make sure to use the model, controller and repository layers to seperate business concerns
- Use `List` to store the reminders
- Use the `ResponseEntity` to send the appopriate response codes.
- Before deleting or editing a reminder make sure to check if the reminder is present in the application
- If not present sent a response code of `not found`