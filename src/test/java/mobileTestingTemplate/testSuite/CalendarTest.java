package mobileTestingTemplate.testSuite;

import mobileTestingTemplate.activities.calendar.AddEventActivity;
import mobileTestingTemplate.activities.calendar.MainCalendar;
import mobileTestingTemplate.control.Label;
import mobileTestingTemplate.session.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class CalendarTest {
    MainCalendar mainCalendar = new MainCalendar();
    AddEventActivity addEventActivity = new AddEventActivity();
    Random rnd = new Random();
    @Test
    public void verifyCreateEvent(){
        String title = "Title "+rnd.nextInt();
        String description = "Description "+rnd.nextInt();

        mainCalendar.addEvent.click();

        addEventActivity.titleInput.setText(title);
        addEventActivity.descriptionInput.setText(description);

        addEventActivity.selectDate.click();
        addEventActivity.october31.click();
        addEventActivity.okButton.click();

        addEventActivity.saveButton.click();

        mainCalendar.dateOctober31.click();

        Label eventTitle = mainCalendar.getEventLabel(title);
        Label eventDescription = mainCalendar.getEventDescriptionLabel(description);

        Assertions.assertTrue(eventTitle.isControlDisplayed(),
                "ERROR no se creo el evento");

        Assertions.assertTrue(eventTitle.isControlDisplayed() && eventDescription.isControlDisplayed(),
                "ERROR no se creo el evento");

    }
    @AfterEach
    public void closeApp(){
        Session.getSession().closeApp();
    }



}
