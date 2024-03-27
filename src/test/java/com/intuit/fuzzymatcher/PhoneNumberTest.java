package com.intuit.fuzzymatcher;

import com.intuit.fuzzymatcher.component.MatchService;
import com.intuit.fuzzymatcher.domain.Document;
import com.intuit.fuzzymatcher.domain.Element;
import com.intuit.fuzzymatcher.domain.ElementType;
import com.intuit.fuzzymatcher.domain.Match;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneNumberTest {
    @Test
    public void phoneMatched() {
        String[][] input = {
                {"1", "Steven Wilson", "45th Avenue 5th st.", "+1-(569)-752-1276"},
                {"2", "John Doe", "546 Freeman Avenue", "+1-(123)-456-4345"},
                {"3", "Stephen Wilson", "45th Avenue 5th Street", "+1-(569)-752-1276"}
        };

        List<Document> documentList = Arrays.stream(input).map(contact -> {
            return new Document.Builder(contact[0])
                    .addElement(new Element.Builder<String>().setValue(contact[3]).setType(ElementType.PHONE).createElement())
                    .addElement(new Element.Builder<String>().setValue(contact[2]).setType(ElementType.ADDRESS).createElement())
                    .createDocument();
        }).collect(Collectors.toList());

        MatchService matchService = new MatchService();
        Map<String, List<Match<Document>>> result = matchService.applyMatchByDocId(documentList);

        result.entrySet().forEach(entry -> {
            entry.getValue().forEach(match -> {
                System.out.println("Data: " + match.getData() + " Matched With: " + match.getMatchedWith() + " Score: " + match.getScore().getResult());
            });
        });
    }

    @Test
    public void phoneMatched2() {
        String[][] input = {
                {"1", "Michael Smith", "123 Main Street", "+1-(234)-567-8901"},
                {"2", "Emily Johnson", "456 Elm Street", "+1-(345)-678-9012"},
                {"3", "Jessica Brown", "789 Oak Street", "+1-(456)-789-0123"}
        };

        List<Document> documentList = Arrays.stream(input).map(contact -> {
            return new Document.Builder(contact[0])
                    .addElement(new Element.Builder<String>().setValue(contact[3]).setType(ElementType.PHONE).createElement())
                    .addElement(new Element.Builder<String>().setValue(contact[2]).setType(ElementType.ADDRESS).createElement())
                    .createDocument();
        }).collect(Collectors.toList());

        MatchService matchService = new MatchService();
        Map<String, List<Match<Document>>> result = matchService.applyMatchByDocId(documentList);

        result.entrySet().forEach(entry -> {
            entry.getValue().forEach(match -> {
                System.out.println("Data: " + match.getData() + " Matched With: " + match.getMatchedWith() + " Score: " + match.getScore().getResult());
            });
        });
    }

    @Test
    public void phoneMatched3() {
        String[][] input = {
                {"1", "David Wilson", "321 Pine Street", "+1-(543)-210-9876"},
                {"2", "Sophia Martinez", "654 Cedar Street", "+1-(432)-109-8765"},
                {"3", "James Taylor", "987 Maple Street", "+1-(321)-098-7654"}
        };

        List<Document> documentList = Arrays.stream(input).map(contact -> {
            return new Document.Builder(contact[0])
                    .addElement(new Element.Builder<String>().setValue(contact[3]).setType(ElementType.PHONE).createElement())
                    .addElement(new Element.Builder<String>().setValue(contact[2]).setType(ElementType.ADDRESS).createElement())
                    .createDocument();
        }).collect(Collectors.toList());

        MatchService matchService = new MatchService();
        Map<String, List<Match<Document>>> result = matchService.applyMatchByDocId(documentList);

        result.entrySet().forEach(entry -> {
            entry.getValue().forEach(match -> {
                System.out.println("Data: " + match.getData() + " Matched With: " + match.getMatchedWith() + " Score: " + match.getScore().getResult());
            });
        });
    }

    @Test
    public void phoneMatched4() {
        String[][] input = {
                {"1", "Emma Davis", "123 Elm Street", "+1-(654)-321-0987"},
                {"2", "Alexander Garcia", "456 Oak Street", "+1-(765)-432-1098"},
                {"3", "Olivia Brown", "789 Pine Street", "+1-(876)-543-2109"}
        };

        List<Document> documentList = Arrays.stream(input).map(contact -> {
            return new Document.Builder(contact[0])
                    .addElement(new Element.Builder<String>().setValue(contact[3]).setType(ElementType.PHONE).createElement())
                    .addElement(new Element.Builder<String>().setValue(contact[2]).setType(ElementType.ADDRESS).createElement())
                    .createDocument();
        }).collect(Collectors.toList());

        MatchService matchService = new MatchService();
        Map<String, List<Match<Document>>> result = matchService.applyMatchByDocId(documentList);

        result.entrySet().forEach(entry -> {
            entry.getValue().forEach(match -> {
                System.out.println("Data: " + match.getData() + " Matched With: " + match.getMatchedWith() + " Score: " + match.getScore().getResult());
            });
        });
    }

    @Test
    public void phoneMatched5() {
        String[][] input = {
                {"1", "William Rodriguez", "123 Maple Street", "+1-(987)-654-3210"},
                {"2", "Isabella Hernandez", "456 Cedar Street", "+1-(876)-543-2109"},
                {"3", "Daniel Lopez", "789 Pine Street", "+1-(765)-432-1098"}
        };

        List<Document> documentList = Arrays.stream(input).map(contact -> {
            return new Document.Builder(contact[0])
                    .addElement(new Element.Builder<String>().setValue(contact[3]).setType(ElementType.PHONE).createElement())
                    .addElement(new Element.Builder<String>().setValue(contact[2]).setType(ElementType.ADDRESS).createElement())
                    .createDocument();
        }).collect(Collectors.toList());

        MatchService matchService = new MatchService();
        Map<String, List<Match<Document>>> result = matchService.applyMatchByDocId(documentList);

        result.entrySet().forEach(entry -> {
            entry.getValue().forEach(match -> {
                System.out.println("Data: " + match.getData() + " Matched With: " + match.getMatchedWith() + " Score: " + match.getScore().getResult());
            });
        });
    }

    @Test
    public void phoneMatched6() {
        String[][] input = {
                {"1", "Mia Martinez", "123 Oak Street", "+1-(234)-567-8901"},
                {"2", "Alexander Johnson", "456 Elm Street", "+1-(987)-654-3210"},
                {"3", "Ethan Wilson", "789 Cedar Street", "+1-(876)-543-2109"}
        };

        List<Document> documentList = Arrays.stream(input).map(contact -> {
            return new Document.Builder(contact[0])
                    .addElement(new Element.Builder<String>().setValue(contact[3]).setType(ElementType.PHONE).createElement())
                    .addElement(new Element.Builder<String>().setValue(contact[2]).setType(ElementType.ADDRESS).createElement())
                    .createDocument();
        }).collect(Collectors.toList());

        MatchService matchService = new MatchService();
        Map<String, List<Match<Document>>> result = matchService.applyMatchByDocId(documentList);

        result.entrySet().forEach(entry -> {
            entry.getValue().forEach(match -> {
                System.out.println("Data: " + match.getData() + " Matched With: " + match.getMatchedWith() + " Score: " + match.getScore().getResult());
            });
        });
    }

}
