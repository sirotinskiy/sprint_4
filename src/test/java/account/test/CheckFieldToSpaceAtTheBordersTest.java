package account.test;

import account.Account;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class CheckFieldToSpaceAtTheBordersTest {
    private final String testField;
    private final boolean expectResult;

    private Account account;

    public CheckFieldToSpaceAtTheBordersTest(String testField, boolean expectResult) {
        this.testField = testField;
        this.expectResult = expectResult;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {" sdfsdf ", false},
                {"dfgdf ", false},
                {" sfgdfg", false },
                {"sdfsdf", true}
        };
    }

    @Before
    public void setUp(){
        account = new Account(testField);
    }

    @Test
    @DisplayName("Проверка на пробел в начале или в конце имени")
    public void testFieldToSpaceAtTheBorders(){
        assertEquals(expectResult, account.checkFieldToSpaceAtTheBorders(testField));
    }
}
