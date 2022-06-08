package account.test;

import account.Account;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
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

    public CheckNameToEmbossTest(boolean expectResult, String testField) {
        this.testField = testField;
        this.expectResult = expectResult;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {false, new StringBuilder(RandomStringUtils.randomAlphabetic(1)).toString()},
                {false, new StringBuilder(RandomStringUtils.randomAlphabetic(19) + " " + RandomStringUtils.randomAlphabetic(2)).toString()},
                {false, new StringBuilder(" " + " " + RandomStringUtils.randomAlphabetic(1)).toString()},
                {false, new StringBuilder(RandomStringUtils.randomAlphabetic(16) + " " + " "  + RandomStringUtils.randomAlphabetic(1)).toString()},
                {false, new StringBuilder(RandomStringUtils.randomAlphabetic(3) + " " + " " + RandomStringUtils.randomAlphabetic(3) + " " + RandomStringUtils.randomAlphabetic(3)).toString()},
                {false, new StringBuilder(" " + RandomStringUtils.randomAlphabetic(3) + " " + RandomStringUtils.randomAlphabetic(3)).toString()},
                {false, new StringBuilder(RandomStringUtils.randomAlphabetic(16) + " " + RandomStringUtils.randomAlphabetic(1) + " ").toString()},
                {false, new StringBuilder(" " + RandomStringUtils.randomAlphabetic(3) + " " + RandomStringUtils.randomAlphabetic(1) + " ").toString()},
                {true, new StringBuilder(RandomStringUtils.randomAlphabetic(3) + " " + RandomStringUtils.randomAlphabetic(3)).toString()},
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

