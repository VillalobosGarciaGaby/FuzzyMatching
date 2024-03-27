package com.intuit.fuzzymatcher;

import com.intuit.fuzzymatcher.component.MatchService;
import com.intuit.fuzzymatcher.domain.Document;
import com.intuit.fuzzymatcher.domain.Element;
import com.intuit.fuzzymatcher.domain.Match;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.intuit.fuzzymatcher.domain.ElementType.PATH;

public class PathComparisonTest {

    @Test
    public void textTokenization() {
        String path = "Android/android-L-preview/AndroidManifest.xml";
        String path1 = "Android/android-L-preview/AndroidManifest.xml";

        Document document = new Document.Builder("1").addElement(new Element.Builder<String>().setValue(path).setType(PATH).createElement()).createDocument();
        MatchService matchService = new MatchService();

        List<Document> documents = new ArrayList<>();
        documents.add(new Document.Builder("1").addElement(new Element.Builder<String>().setValue(path1).setType(PATH).createElement()).createDocument());

        Map<Document, List<Match<Document>>> result = matchService.applyMatch(document, documents);

        result.entrySet().forEach(entry -> {
            entry.getValue().forEach(match -> {
                System.out.println("Data: " + match.getData() + " Matched With: " + match.getMatchedWith() + " Score: " + match.getScore().getResult());
            });
        });
    }
}
