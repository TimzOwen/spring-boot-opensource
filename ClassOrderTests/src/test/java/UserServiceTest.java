import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @BeforeAll
    static void setup(){
        System.out.println("Test related to User Service");
    }

    @Test
    void testCreateUser_WhenFirstNameMissing_ThrowsUserServiceException(){

    }

}
