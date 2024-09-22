import com.yixi.micro.util.JwtHelper;
import org.junit.jupiter.api.Test;

public class TestJwtHelper {

    @Test
    public void TestAllMethod(){
        String token = JwtHelper.createToken(1L);
        System.out.println(token);

        Long userId = JwtHelper.getUserId(token);
        System.out.println(userId);
        boolean expiration = JwtHelper.isExpiration(token);
        System.out.println(expiration);
    }
}
