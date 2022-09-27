package practiceLessons03;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02 {
    @Test
    public void test01() {
        // Verify that we have pom.xml file in our project => please try in 4 min s


        String filePath="C:\\Users\\FatihKamil\\IdeaProjects\\SeleniumPractice\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }
}
