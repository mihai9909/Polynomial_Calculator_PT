import controller.Controller;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

public class OperationsTest {
    @Test
    public void Tests(){
        Controller c = new Controller();
        assertEquals("+2.0*x^3+3.0*x^2+1.0*x^1",c.getAddition("1x^2+1x^1","2x^3+2x^2"),"Addition works");
        assertEquals("-2.0*x^3-1.0*x^2+1.0*x^1",c.getSubtraction("1x^2+1x^1","2x^3+2x^2"),"Subtraction works");
        assertEquals("+2.0*x^5+4.0*x^4+2.0*x^3",c.getMultiplication("1x^2+1x^1","2x^3+2x^2"), "Multiplication works");
        assertEquals("+6.0*x^2+4.0*x^1",c.getDerivative("2x^3+2x^2"), "Derivation works");
        assertEquals("+3.0*x^7+4.0*x^3+0.5*x^2",c.getIntegral("21x^6+12x^2+1*x^1") ,"Integration works");
        assertEquals("+1.0*x^2+1.0*x^1+3.0*x^0\n+5.0*x^0",c.getDivision("1x^3-2x^2-4x^0","1x^1-3x^0"), "Division works");
    }
}
