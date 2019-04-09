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

    //Verify the create Answer
    @Test
    public void Check_Created_Answer() throws Exception{
        Answer answer = new Answer();
        Answer answer2 = new Answer();
        List<String> inputList = new ArrayList<>();
        for (int i = 1; i < 5; i++)
            inputList.add(i+"");
        String inputString = "1 2 3 4";
        answer2.setNumList(inputList);
        answer = answer.createAnswer(inputString);
        assertThat(answer.createAnswer(inputString)).isEqualsToByComparingFields(answer2);
    }

    //If the input string length is not legal
    @Test
    public void isValid() throws Exception {
        Answer answer = new Answer();
        Answer answer2 = new Answer();

        List<String> inputList = new ArrayList<>();
        for (int i = 1; i < 3; i++)
            inputList.add(i+"");

        answer.setNumList(inputList);

        List<String> inputList2 = new ArrayList<>();
        for (int i = 1; i < 6; i++)
            inputList2.add(i+"");

        answer2.setNumList(inputList2);

        try {
            answer.validate();
        } catch (Exception e) {
            assertThat(e).isInstanceOf(OutOfRangeAnswerException.class)
                    .hasMessage("Answer format is incorrect");
        }

        try {
            answer2.validate();
        } catch (Exception e) {
            assertThat(e).isInstanceOf(OutOfRangeAnswerException.class)
                    .hasMessage("Answer format is incorrect");
        }
    }

    //Check the index position
    @Test
    public void Check_Index_of_NumberList() throws Exception{
        Answer answer = new Answer();

        List<String> inputList = new ArrayList<>();
        for (int i = 1; i < 5; i++)
            inputList.add(i+"");

        answer.setNumList(inputList);
        assertThat(answer.getIndexOfNum("1")).isEqualTo(0);
        assertThat(answer.getIndexOfNum("6")).isEqualTo(-1);

    }

}