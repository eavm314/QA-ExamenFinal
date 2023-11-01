package ej3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import webUITemplate.testSuite.TodolyBaseTest;

import java.util.Random;

public class TodoLyTest extends TodolyBaseTest {
//    WebUI > utilizando la aplicacion todo.ly realizar el test automatizado para verificar
//    que no se puede crear una cuenta con mismo email / user / password
//            steps
//- crear una cuenta, verificar que puede iniciar sesión > realizar el logout > tratar de
//    crear nuevamente la misma cuenta > verificar que no puede crear la cuenta

    private final Random rnd = new Random();

    @Test
    public void verifyAccount(){
        String randomEmail = "enrique"+rnd.nextInt()+"@gmail.com";

        createAccount(randomEmail, true);
        menuSection.logoutButton.click();
        createAccount(randomEmail,false);
    }

    private void createAccount(String email, boolean shouldWork){
        mainPage.signUpButton.click();

        signUpSection.fullNameInput.setText("Enrique");
        signUpSection.emailInput.setText(email);
        signUpSection.pwdInput.setText("password");
        signUpSection.termsOfServiceButton.click();

        signUpSection.signUpButton.click();

        if (shouldWork){
            Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                    "Error: no se creo la cuenta correctamente");
        } else {
            Assertions.assertTrue(mainPage.errorMessage.isControlDisplayed(), "" +
                    "Error: no se muestra la advertencia de que la cuenta ya existe");
        }
    }
}
