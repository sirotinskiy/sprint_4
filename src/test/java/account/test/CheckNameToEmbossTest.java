package account.test;

import account.Account;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckNameToEmbossTest {
    private final String testField;
    private final boolean expectResult;

    private Account account;

    public CheckNameToEmbossTest(String testField, boolean expectResult) {
        this.testField = testField;
        this.expectResult = expectResult;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"sdf sdf", true},
                {"sd f sdf", false},
                {"", false},
                {" asdasd sdf ", false}
        };
    }

    @Before
    public void setUp() {
        account = new Account(testField);
    }

    @Test
    @DisplayName("Проверка на требования к имени: на длину и пробелы")
    public void testFieldToSpaceInside() {
        assertEquals(expectResult, account.checkNameToEmboss());
    }
}

