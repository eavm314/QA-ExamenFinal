package mobileTestingTemplate.activities.calendar;

import mobileTestingTemplate.control.Button;
import mobileTestingTemplate.control.TextBox;
import org.openqa.selenium.By;

public class AddEventActivity {
    public TextBox titleInput = new TextBox(By.id("com.simplemobiletools.calendar:id/event_title"));
    public TextBox descriptionInput = new TextBox(By.id("com.simplemobiletools.calendar:id/event_description"));
    public Button selectDate = new Button(By.id("com.simplemobiletools.calendar:id/event_start_date"));
    public Button october31 = new Button(By.xpath("//android.view.View[@content-desc=\"31 October 2023\"]"));
    public Button okButton = new Button(By.id("android:id/button1"));
    public Button saveButton = new Button(By.id("com.simplemobiletools.calendar:id/save"));
}
