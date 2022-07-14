package test;
import Egysegek.*;
import miez.Csatater;
import miez.Hos;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestEgyseg {
    private Foldmuves paraszt;
    private Sarkany sarkany;
    private Griff griff;
    private VampirUr drakula;

    @BeforeEach
    public void setUp() {
        paraszt = new Foldmuves();
        sarkany = new Sarkany();
        griff = new Griff();
        drakula = new VampirUr();
        Hos jatekos = new Hos();
        Hos ellenfel = new Hos();
        Csatater csatater = new Csatater();
    }
    @AfterAll
    public static void tearDown() {
        System.out.println("Lezajlott a tesz!");
    }

    @Test
    public void testConstuctors(){
        assertEquals(paraszt.getEletero(),3);
        assertEquals(sarkany.getAr(),35);
    }



}
