package front_end_tests.tests;

import org.testng.annotations.DataProvider;

public class NewUserData {
    @DataProvider(name = "newUserData")
    public Object[] signUpNewUserData(){

        Object [] [] userData = new Object [3] [1];

        userData [0] [0] = "Demo|User|demouser@domain.xyz|qwerty123|07-21-1994|STUDENT|NSW, Australia|Rockville|This-City|Alabama|00100|United States|Slip Under Door|0420710000|0420710000";
        userData [1] [0] = "Another Demo|User|demouser@domain.xyz|qwerty123|06-01-1994|STUDENT|NSW, Australia|Rockville|This-City|Alabama|00100|United States|Neighbour|0420710000|0420710000";
        userData [2] [0] = "Next Demo|User|demouser@domain.xyz|qwerty123|06-25-1994|STUDENT|NSW, Australia|Rockville|This-City|Arizona|00100|United States|Ring 13|0420710000|0420710000";

        return  userData;
    }
}
