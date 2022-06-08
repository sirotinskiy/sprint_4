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
public class CheckFieldToLengthTest {
    private final String testField;
    private final boolean expectResult;

    private Account account;

    public CheckFieldToLengthTest(String testField, boolean expectResult) {
        this.testField = testField;
        this.expectResult = expectResult;
    }


    //метод checkFieldToLength() - проверяет поле только на длину строки, то есть что длина должна быть от 3 до 19
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {RandomStringUtils.randomAlphabetic(2), false},
                {RandomStringUtils.randomAlphabetic(20), false},
                {RandomStringUtils.randomAlphabetic(3), true},
                {RandomStringUtils.randomAlphabetic(19), true},
                {RandomStringUtils.randomAlphabetic(13), true},
        };
    }

    @Before
    public void setUp(){
        account = new Account(testField);
    }

    @Test
    @DisplayName("Проверка на длину имени")
    public void testLengthField(){
        assertEquals(expectResult, account.checkFieldToLength(testField));
    }
}
