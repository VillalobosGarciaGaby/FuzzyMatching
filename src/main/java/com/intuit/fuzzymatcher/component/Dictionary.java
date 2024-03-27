package com.intuit.fuzzymatcher.component;

import com.intuit.fuzzymatcher.exception.MatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Used for Pre-Processing, the Dictionary caches a pre-defined normalization and replacement for common characters
 * found in names and adresses.
 *
 */
public class Dictionary {

    private static final Logger LOGGER = LoggerFactory.getLogger(Dictionary.class);
    public static final Map<String, String> addressDictionary = getAddressDictionary();

    public static final Map<String, String> nameDictionary = getNameDictionary();
    public static final Map<String, String> phoneDictionary = getPhoneDictionary();

    private static Map<String, String>  getAddressDictionary() {
        try {
            ClassLoader classLoader = Dictionary.class.getClassLoader();
            BufferedReader br = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream("address-dictionary.txt")));
            return getDictionary(br);
        } catch (IOException e) {
            LOGGER.error("could not load address dictonary", e);
            throw new MatchException("could not load address dictonary", e);
        }
    }

    private static Map<String, String> getNameDictionary() {
        try {
            ClassLoader classLoader = Dictionary.class.getClassLoader();
            BufferedReader br = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream("name-dictionary.txt")));
            return getDictionary(br);
        } catch (IOException e) {
            LOGGER.error("could not load name dictonary", e);
            throw new MatchException("could not load name dictonary", e);
        }
    }

    /**
     * Retrieves the phone dictionary from the classpath resources and returns it as a Map.
     * The phone dictionary is expected to be in a file named "phone-dictionary.txt".
     * Each line in the file is expected to contain a pair of key-value separated by ":".
     *
     * @return A Map containing phone dictionary entries where keys represent original values
     *         and values represent normalized values.
     * @throws MatchException if an error occurs while loading or parsing the phone dictionary.
     */
    private static Map<String, String> getPhoneDictionary() {
        try {
            ClassLoader classLoader = Dictionary.class.getClassLoader();
            BufferedReader br = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream("phone-dictionary.txt")));
            return getDictionary(br);
        } catch (IOException e) {
            LOGGER.error("could not load phone dictionary", e);
            throw new MatchException("could not load phone dictionary", e);
        }
    }

    private static Map<String, String> getDictionary(BufferedReader br) throws IOException {
            return br
                    .lines()
                    .map(String::toLowerCase)
                    .filter(line -> !line.isEmpty())
                    .map(s -> s.split(":", 2))
                    .filter(arr -> arr.length == 2)
                    .collect(Collectors.toMap(arr -> arr[0].trim(), arr -> arr[1].trim(), (a1, a2) -> a1));
    }
}
