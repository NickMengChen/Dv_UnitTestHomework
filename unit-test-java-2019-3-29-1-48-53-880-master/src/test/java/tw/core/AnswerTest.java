package tw.core;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.exception.OutOfRangeAnswerException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.fail;


public class AnswerTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void Is_InputNumberValid() throws Exception {
        Answer answer = new Answer();
        List<String> inputList = new ArrayList<>();
        inputList.add("1");
        //inputList.add("a");
        inputList.add("3");
        inputList.add("4");
        answer.setNumList(inputList);
        System.out.println(inputList);

        try {
            answer.validate();
        } catch (Exception e) {
            assertThat(e).isInstanceOf(OutOfRangeAnswerException.class)
                    .hasMessage("Answer format is incorrect");
        }


    }

}