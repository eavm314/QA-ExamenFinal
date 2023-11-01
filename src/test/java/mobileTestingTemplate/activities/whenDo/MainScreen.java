package mobileTestingTemplate.activities.whenDo;

import mobileTestingTemplate.control.Button;
import mobileTestingTemplate.control.Label;
import org.openqa.selenium.By;

public class MainScreen {
    public Button createTaskButton = new Button(By.id("fab"));
    public Button enterTaskButton(String title){
        return new Button(By.xpath("//android.widget.TextView[@resource-id=\"com.vrproductiveapps.whendo:id/home_list_item_text\" and @text='"+title+"']"));
    }

    public Label getDescription(String desc){
        return new Label(By.xpath("//android.widget.TextView[@resource-id=\"com.vrproductiveapps.whendo:id/home_list_item_text2\" and @text='"+desc+"']"));
    }
}
