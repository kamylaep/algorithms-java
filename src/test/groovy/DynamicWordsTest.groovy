import spock.lang.Specification


class DynamicWordsTest extends Specification {

    DynamicWords algorithm = new DynamicWords()

    def "find most similar words"() {
        when:
        def result = algorithm.findMostSimilarWord(typedWord, optionA, optionB)
        then:
        assert expectedOption == result: "expectedOption = ${expectedOption}\nposition = ${result}"
        where:
        typedWord | optionA | optionB | expectedOption
        "fosh"    | "fish"  | "fort"  | "fish"
        "hish"    | "fish"  | "vista" | "fish"
        "clue"    | "clues" | "blue"  | "clues"
    }

}