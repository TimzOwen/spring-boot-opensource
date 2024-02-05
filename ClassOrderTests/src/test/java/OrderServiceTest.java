import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    @BeforeAll
    static void setup(){
        System.out.println("Test related to Order Service");
    }

    @Test
    void testCreateOrder_whenProductIsMissing_ThrowsOrderServiceException(){

    }
}
