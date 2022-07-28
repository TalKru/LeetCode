package questions.other;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
The DNA sequence is composed of a series of
nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence,
return all the 10-letter-long sequences (substrings)
that occur more than once in a DNA molecule.
You may return the answer in any order.

Example 1:
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]

Example 2:
Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]

Constraints:
1 <= s.length <= 105
s[i] is either 'A', 'C', 'G', or 'T'.
 */
public class _187_Repeated_DNA_Sequences {

    public static void main(String[] args) {

        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        List<String> res = findRepeatedDnaSequences(s);

        System.out.println("Repeated_DNA_Sequences: " + res);
    }

    public static List<String> findRepeatedDnaSequences(String s) {

        int wordLen = 10;

        if (s.isEmpty() || s.length() < wordLen + 1) {
            return new LinkedList();
        }
        HashSet<String> resultList = new HashSet<>();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < s.length() - wordLen + 1; i++) {

            String substring = s.substring(i, i + wordLen);

            if (set.contains(substring)) {

                resultList.add(substring);
            }
            else {
                set.add(substring);
            }
        }
        return new LinkedList<>(resultList);
    }
}
