package example.project.domain;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.sqrt;

/**
 * A class defining the definition of a driving scenario, which is dependent on the domain/application.
 * This must be modified and updated with class Snapshot.
 */
public class Scenario {
    String roadType;
    String weatherCondition;
    List<Float> initEgoCarPos;  // (x, y)
    List<Float> initCarInFrontPos;  // (x, y)

    public Scenario() {
        roadType = null;
        weatherCondition = null;
        initEgoCarPos = null;
        initCarInFrontPos = null;
    }

    public Scenario(String scenarioDescription) {
        // parse scenarioDescription and save the result to the class attributes
        // not implemented
    }

    public boolean distance(Scenario s) {
        float a = initEgoCarPos.get(0) - initCarInFrontPos.get(0);
        float b = initEgoCarPos.get(1) - initCarInFrontPos.get(1);
        float d = s.initEgoCarPos.get(0) - s.initCarInFrontPos.get(0);
        float e = s.initEgoCarPos.get(1) - s.initCarInFrontPos.get(1);
        double c = Math.sqrt(a*a + b*b);
        double f = Math.sqrt(d*d + e*e);


        if (c<0.05 && f<0.05){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;


        Scenario s = (Scenario) obj;

        return roadType.equals(s.roadType)
                && weatherCondition.equals(s.weatherCondition)
                && distance(s);
    }
}
