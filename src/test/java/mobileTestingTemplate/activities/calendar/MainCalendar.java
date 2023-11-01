package mobileTestingTemplate.activities.calendar;

import mobileTestingTemplate.control.Button;
import mobileTestingTemplate.control.Label;
import org.openqa.selenium.By;

public class MainCalendar {
    public Button addEvent = new Button(By.id("com.simplemobiletools.calendar:id/calendar_fab"));
    public Button dateOctober31 = new Button(By.xpath("//android.widget.TextView[@text='31']"));
    public Label getEventLabel(String title){
        return new Label(By.xpath("//android.widget.TextView[@resource-id=\"com.simplemobiletools.calendar:id/event_item_title\" " +
                "and @text='"+title+"']"));
    }
    public Label getEventDescriptionLabel(String description){
        return new Label(By.xpath("//android.widget.TextView[@resource-id=\"com.simplemobiletools.calendar:id/event_item_description\" " +
                "and @text='"+description+"']"));
    }

}
