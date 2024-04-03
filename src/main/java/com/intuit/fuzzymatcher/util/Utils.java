package com.intuit.fuzzymatcher.util;

import com.intuit.fuzzymatcher.exception.MatchException;
import org.apache.lucene.analysis.ngram.NGramTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    public static Stream<String> getNGrams(String value, int size) {
        Stream.Builder<String> stringStream = Stream.builder();
        if (value.length() <= size) {
            stringStream.add(value);
        } else {
            NGramTokenizer nGramTokenizer = new NGramTokenizer(size, size);
            CharTermAttribute charTermAttribute = nGramTokenizer.addAttribute(CharTermAttribute.class);
            nGramTokenizer.setReader(new StringReader(value));
            try {
                nGramTokenizer.reset();
                while (nGramTokenizer.incrementToken()) {
                    stringStream.add(charTermAttribute.toString());
                }
                nGramTokenizer.end();
                nGramTokenizer.close();
            } catch (IOException io) {
                throw new MatchException("Failure in creating tokens : ", io);
            }
        }
        return stringStream.build();
    }

    /**
     * utility method to apply dictionary for normalizing strings
     *
     * @param str A String of element value to be nomalized
     * @param dict A dictonary map containing the mapping of string to normalize
     * @return the normalized string
     */
    public static String getNormalizedString(String str, Map<String, String> dict) {
        return Arrays.stream(str.split("\\s+"))
                .map(d -> dict.containsKey(d.toLowerCase()) ?
                        dict.get(d.toLowerCase())
                        : d)
                .collect(Collectors.joining(" "));
    }

    public static void getRabinKarp (String pat, String txt, int q)
    {
        int d = 256;
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;

        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        for (i = 0; i <= N - M; i++) {

            if (p == t) {

                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }

                if (j == M)
                    System.out.println("Pattern found at index " + i);
            }

            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                if (t < 0)
                    t = (t + q);
            }
        }
    }

    public static boolean isNumeric(String str) {
        return str.matches(".*\\d.*");
    }
}
