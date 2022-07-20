package be.digitalcity.tu;

import org.junit.jupiter.api.*;

import java.util.logging.Logger;

public class TestInfoDemoLogger {

    private Logger logger = Logger.getLogger(TestInfoDemoLogger.class.getName());

    @BeforeEach
    void beforeEachTest(TestInfo testInfo, RepetitionInfo repetitionInfo){
        logger.info(String.format(
                "Repetition %s / %s pour %s",
                repetitionInfo.getCurrentRepetition(),
                repetitionInfo.getTotalRepetitions(),
                testInfo.getTestMethod().get().getName()
        ));
    }

    @RepeatedTest(4)
    void repeatTest(){}
}
