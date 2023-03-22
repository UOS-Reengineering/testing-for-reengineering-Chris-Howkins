package example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import example.project.domain.Scenario;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestChecker {

    @Test
    public void testCheckCollisionViolations()
    {
        // setup
        Simulator simulator = new Simulator("dummy");
        Scenario scenario = new Scenario();


        // testing target
        Checker checker = mock();
        when(checker.checkCollisionViolations(scenario)).thenReturn(false);
        boolean isCollision = checker.checkCollisionViolations(scenario); // this invokes a null pointer exception due to the dummy simulator
        assertEquals(false, isCollision);
        verify(checker, times(1)).checkCollisionViolations(scenario);
    }

}