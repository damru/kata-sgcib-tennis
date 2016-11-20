import com.damru.kata.sgcib.tennis.enums.Point;
import com.damru.kata.sgcib.tennis.models.Jeu;
import com.damru.kata.sgcib.tennis.models.Joueur;
import com.damru.kata.sgcib.tennis.models.Match;
import com.damru.kata.sgcib.tennis.services.MatchService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.IntStream;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

/**
 * Created by damien on 17/11/2016.
 */

@ContextConfiguration(locations = { "file:src/main/resources/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMatch {

    @Autowired
    private MatchService matchService;

    private Match match;

    private Joueur john;

    private Joueur jane;

    @Before
    public void init() {
        john = new Joueur("John", "Doe");
        jane = new Joueur("Jane", "Doe");
        match = new Match(jane, john);
    }
    @Test
    public void testScore15Points() {
        matchService.marquerPoint(match, john);
        assertTrue(Point.QUINZE.equals(matchService.getScore(match, john)));
    }

    @Test
    public void testScore30Points() {
        matchService.marquerPoint(match, john);
        matchService.marquerPoint(match, john);
        assertTrue(Point.TRENTE.equals(matchService.getScore(match, john)));
    }

    @Test
    public void testScoreDeuce() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            matchService.marquerPoint(match, john);
            matchService.marquerPoint(match, jane);
        });

        assertTrue(Point.DEUCE.equals(matchService.getScore(match, john)));
        assertTrue(Point.DEUCE.equals(matchService.getScore(match, jane)));
    }


    @Test
    public void testScoreAvantage() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            matchService.marquerPoint(match, john);
            matchService.marquerPoint(match, jane);
            });

        matchService.marquerPoint(match, jane);

        assertTrue(Point.AVANTAGE.equals(matchService.getScore(match, jane)));
        assertTrue(Point.QUARANTE.equals(matchService.getScore(match, john)));
    }

    @Test
    public void testGagnerJeu() {
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            matchService.marquerPoint(match, jane);
        });

        assertTrue(matchService.getJeuxGagnes(match,jane) >= 1 );
    }
}
