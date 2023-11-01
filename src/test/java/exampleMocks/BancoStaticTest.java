package exampleMocks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class BancoStaticTest {

    private static MockedStatic<AsfiStatic> asfiMockedStatic;
    @BeforeAll
    public static void setup(){
        // Create Mock
        asfiMockedStatic = Mockito.mockStatic(AsfiStatic.class);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "454566, A, 200000",
                    "999999, B, 100000",
                    "77777, C, 0",
            }
    )
    public void verifyMaximoPrestamo(String ci, String categoria, int montoMaximoEsperado){
        // Create method - mock
        asfiMockedStatic.when(()-> AsfiStatic.getCategoria(ci)).thenReturn(categoria);

        Banco banco = new Banco();
        int actualResult = banco.getMaximoPrestamoStatic(ci) ;

        Assertions.assertEquals(montoMaximoEsperado,actualResult,"ERROR! el monto de prestamo maximo es incorrecto");
    }
}
