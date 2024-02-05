import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {
    @BeforeAll
    static void setup(){
        System.out.println("Test related to Product Service");
    }

    @Test
    void testCreateProduct_WhenProductTitleIsMissing_ThrowsProductServiceException(){

    }
}
