
package com.intuit.fuzzymatcher;

import com.intuit.fuzzymatcher.component.MatchService;
import com.intuit.fuzzymatcher.domain.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.intuit.fuzzymatcher.domain.ElementType.NAME;
import static com.intuit.fuzzymatcher.domain.ElementType.TEXT;
import static com.intuit.fuzzymatcher.function.TokenizerFunction.wordSoundexEncodeTokenizer;


public class PathTest {
    @Test
    public void pathsTesting() {
        String value = "https:atest.comausera1";

        Function<Element<String>, Stream<Token>> customTokenFunc = (element) -> Arrays.stream(element.getPreProcessedValue().split("a"))
                .map(token -> new Token(token, element));

        Element customTokenElement = new Element.Builder().setType(TEXT)
                .setTokenizerFunction(customTokenFunc)
                .setValue(value)
                .createElement();
        Stream<Token> customStream = (Stream<Token>) customTokenElement
                .getTokenizerFunction()
                .apply(customTokenElement);
        List<Token> customResults = customStream.collect(Collectors.toList());

        for (Token token: customResults) {
            System.out.println(token);
        }

        Assert.assertEquals("https", customResults.get(0).getValue());
        Assert.assertEquals("testcom", customResults.get(1).getValue());

        Assert.assertEquals(4, customResults.size());
    }
}
