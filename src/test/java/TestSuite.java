import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        Assert_True_Or_False.class,
        CalculatorTest.class,
        CountTest_DRY_Principle.class,
        MoveElementTest.class,
        SearchListTest_ListWebElement.class,
        SpellingTest_ForIfElseTest.class,
        VerifyVsAssertTestTryCatchTest.class
})

public class TestSuite {
}
