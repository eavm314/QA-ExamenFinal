package ej1;

import mobileTestingTemplate.activities.whenDo.ConfirmModal;
import mobileTestingTemplate.activities.whenDo.MainScreen;
import mobileTestingTemplate.activities.whenDo.TaskScreen;
import mobileTestingTemplate.control.AppiumControl;
import mobileTestingTemplate.control.Label;
import mobileTestingTemplate.session.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class WhenDoTest {
//    Mobile > utilizando la aplicación WhenDo realizar el test automatizado para la
//    creación, actualización y eliminación de una task (3 verificaciones)

    MainScreen mainScreen = new MainScreen();
    TaskScreen taskScreen = new TaskScreen();
    ConfirmModal confirmModal = new ConfirmModal();

    Random rnd = new Random();

    private String randomTitle;
    private String randomDesc;
    @Test
    public void verifyTask(){
        createTask();
        updateTask();
        deleteTask();
    }

    @AfterEach
    public void closeApp(){
        Session.getSession().closeApp();
    }

    private void createTask(){
        randomTitle = "Title "+rnd.nextInt();
        randomDesc = "Random Description "+rnd.nextInt();

        mainScreen.createTaskButton.click();

        taskScreen.titleInput.setText(randomTitle);
        taskScreen.descInput.setText(randomDesc);

        taskScreen.saveButton.click();

        AppiumControl task = mainScreen.enterTaskButton(randomTitle);
        Label description = mainScreen.getDescription(randomDesc);

        Assertions.assertTrue(task.isControlDisplayed() && description.isControlDisplayed(),
                "Error: no se creo la tarea");
    }

    private void updateTask(){
        AppiumControl task = mainScreen.enterTaskButton(randomTitle);
        task.click();

        String newDesc = "Nueva descripcion actualizada recien";
        taskScreen.descInput.clearSetText(newDesc);

        taskScreen.saveButton.click();

        Label description = mainScreen.getDescription(newDesc);

        Assertions.assertTrue(task.isControlDisplayed() && description.isControlDisplayed(),
                "Error: no se actualizó la tarea");
    }

    private void deleteTask(){
        AppiumControl task = mainScreen.enterTaskButton(randomTitle);
        task.click();

        taskScreen.deleteButton.click();

        confirmModal.confirmDeleteButton.click();

        Assertions.assertFalse(task.isControlDisplayed(), "Error: no se eliminó la tarea");
    }


}
