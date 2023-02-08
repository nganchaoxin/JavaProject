package mvc;

import mvc.service.MathService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:/beans.xml")
public class MathServiceTest {
    @Autowired
    MathService mathService;
    @Test
    public void testAdd_UC001() {
        int actualResult = mathService.add(2,3);
        int expectedResult = 4;
        assertEquals(expectedResult, actualResult);
    }

}
