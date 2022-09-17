package cn.gekal.sample.testparameterinjector.tests;

import com.google.testing.junit.testparameterinjector.junit5.TestParameter;
import com.google.testing.junit.testparameterinjector.junit5.TestParameterInjectorTest;
import com.google.testing.junit.testparameterinjector.junit5.TestParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MyTests {

    /** LOGGER */
    private static final Logger LOGGER = LoggerFactory.getLogger(MyTests.class);

    @TestParameterInjectorTest
    void test1(@TestParameter boolean enableFlag) {

        LOGGER.info("enableFlag = {}", enableFlag);
    }

    @TestParameterInjectorTest
    void test2(@TestParameter MyEnum myEnum) {

        LOGGER.info("myEnum = {}", myEnum);
    }

    @TestParameterInjectorTest
    void test3(@TestParameter({"1", "2", "3"}) Integer age, @TestParameter({"cat", "dog"}) String animalName) {

        LOGGER.info("age = {}, animalName = {}", age, animalName);
    }

    @TestParameterInjectorTest
    @TestParameters("{age: 17, expectIsAdult: false}")
    @TestParameters("{age: 22, expectIsAdult: true}")
    public void withRepeatedAnnotation(int age, boolean expectIsAdult) {

        LOGGER.info("age = {}, expectIsAdult = {}", age, expectIsAdult);
    }
}