import spock.lang.Specification


class AnagramTest extends Specification {

    Anagram algorithm = new Anagram()

    def "anagram"() {
        when:
        def result = algorithm.isAnagram(a, b)
        then:
        assert anagram == result: "anagram = ${anagram}\nresult = ${result}\na = ${a}\nb = ${b}"
        where:
        a           | b            | anagram
        "rat"       | "tar"        | true
        "cider"     | "cried"      | true
        "cider"     | "CriEd"      | true
        "Dormitory" | "Dirty room" | true
        "dog"       | "cat"        | false
        "big dog"   | "small dog"  | false
    }

}
