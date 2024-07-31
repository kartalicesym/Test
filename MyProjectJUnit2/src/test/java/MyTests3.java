import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MyTests3 {

    @BeforeEach
    public void setUp(){
        System.out.println("setUp");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Bahadır", "Buse", "Gül"})
    public void test03(String name){
        System.out.println(name);

    }

    @AfterEach
    public void tearDown(){
        System.out.println("tearDown");
    }
}
