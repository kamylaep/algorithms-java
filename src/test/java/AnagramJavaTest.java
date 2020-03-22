import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AnagramJavaTest {

  private Anagram anagram = new Anagram();

  @ParameterizedTest(name = "a={0}, b={1}, expected={2}")
  @MethodSource("anagramSource")
  @DisplayName("should return true if 'a' and 'b' are anagrams, or false otherwise")
  public void validateAnagram(String a, String b, boolean expected) {
    boolean isAnagram = this.anagram.isAnagram(a, b);
    Assertions.assertEquals(expected, isAnagram);
  }

  private static Stream<Arguments> anagramSource() {
    return Stream.of(Arguments.of("rat", "tar", true),
        Arguments.of("cider", "cried", true),
        Arguments.of("cider", "CriEd", true),
        Arguments.of("Dormitory", "Dirty room", true),
        Arguments.of("dog", "cat", false),
        Arguments.of("big dog", "small dog", false));
  }
}
