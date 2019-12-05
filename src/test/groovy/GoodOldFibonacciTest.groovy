import spock.lang.Specification


class GoodOldFibonacciTest extends Specification {

    GoodOldFibonacci algorithm = new GoodOldFibonacci()

    def "calculate nth fibonacci recursively"() {
        when:
        def result = algorithm.recursive(n)
        then:
        assert expectedValue == result: "expectedValue = ${expectedValue}\nactualValue = ${result}"
        where:
        n  || expectedValue
        0  || 0
        1  || 1
        2  || 1
        3  || 2
        4  || 3
        5  || 5
        6  || 8
        7  || 13
        8  || 21
        9  || 34
        10 || 55
        15 || 610
        16 || 987
        25 || 75025
        26 || 121393
    }

    def "calculate nth fibonacci dynamically"() {
        when:
        def result = algorithm.dynamic(n)
        then:
        assert expectedValue == result: "expectedValue = ${expectedValue}\nactualValue = ${result}"
        where:
        n  || expectedValue
        0  || 0
        1  || 1
        2  || 1
        3  || 2
        4  || 3
        5  || 5
        6  || 8
        7  || 13
        8  || 21
        9  || 34
        10 || 55
        15 || 610
        16 || 987
        25 || 75025
        26 || 121393
    }

    def "calculate nth fibonacci last two"() {
        when:
        def result = algorithm.lastTwo(n)
        then:
        assert expectedValue == result: "expectedValue = ${expectedValue}\nactualValue = ${result}"
        where:
        n  || expectedValue
        0  || 0
        1  || 1
        2  || 1
        3  || 2
        4  || 3
        5  || 5
        6  || 8
        7  || 13
        8  || 21
        9  || 34
        10 || 55
        15 || 610
        16 || 987
        25 || 75025
        26 || 121393
    }

}