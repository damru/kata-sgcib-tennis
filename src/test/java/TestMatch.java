import com.damru.kata.sgcib.tennis.services.MatchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by damien on 17/11/2016.
 */

@ContextConfiguration(locations = { "file:src/main/resources/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMatch {

    @Autowired
    private MatchService matchService;

    @Test
    public void testMarquerPoint() {
        matchService.getScore();
    }

}
