2. The fuzzy-matcher algorithm uses different types of algorithms for the third part of its process (Matching), the most used ones are the edit distance or levenshtein, Ratio, etc.

     a) If we try to use any of the algorithms seen in class, none of them could be implemented in an optimal way, an algorithm that could be used is the Damerau-Levenshtein algorithm.

      b) Like the Levenshtein algorithm, the Damerau-Levenshtein algorithm calculates the minimum number of operations to transform one string into another, it can also perform transpositions of adjacent characters as an additional editing operation, this could be used mainly when strings that differ in character order are expected (e.g. when reviewing a document that contains typing errors or inversion of the character order).

      c) If you want to add another matching algorithm you would have to make changes in the ElementMatch and MatchServices classes; you would add another method in the ElementMatch class implementing the Damerau-Levenshtein algorithm, and you would add another method in MatchServices to be able to review documents containing typing errors or character order reversal.
