package mobileTestingTemplate.activities.whenDo;

import mobileTestingTemplate.control.Button;
import org.openqa.selenium.By;

public class ConfirmModal {
    public Button confirmDeleteButton = new Button(By.xpath("//android.widget.Button[@text='DELETE']"));
}
