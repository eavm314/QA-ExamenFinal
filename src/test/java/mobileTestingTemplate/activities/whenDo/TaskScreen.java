package mobileTestingTemplate.activities.whenDo;

import mobileTestingTemplate.control.Button;
import mobileTestingTemplate.control.TextBox;
import org.openqa.selenium.By;

public class TaskScreen {
    public TextBox titleInput = new TextBox(By.id("noteTextTitle"));
    public TextBox descInput = new TextBox(By.id("noteTextNotes"));
    public Button saveButton = new Button(By.id("saveItem"));
    public Button deleteButton = new Button(By.id("deleteItem"));
}
