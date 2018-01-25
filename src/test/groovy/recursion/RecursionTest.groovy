package recursion

import spock.lang.Specification

class RecursionTest extends Specification {

    Recursion algorithm = new Recursion()

    def "sum"() {
        when:
        def result = algorithm.sum(arrayToSum)
        then:
        assert result == expectedResult: "result = ${result}\nexpectedResult = ${expectedResult}"
        where:
        arrayToSum                              || expectedResult
        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] as int[] || 45
        [10, 15, 20] as int[]                   || 45
        [1, 2, 3] as int[]                      || 6
        [] as int[]                             || 0
        [8] as int[]                            || 8
        null                                    || 0
    }

    def "count"() {
        when:
        def result = algorithm.count(arrayToCount)
        then:
        assert result == expectedResult: "result = ${result}\nexpectedResult = ${expectedResult}"
        where:
        arrayToCount                            || expectedResult
        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] as int[] || 10
        [10, 15, 20] as int[]                   || 3
        [1, 2, 3] as int[]                      || 3
        [] as int[]                             || 0
        [8] as int[]                            || 1
        null                                    || 0
    }

    def "max"() {
        when:
        def result = algorithm.max(arr)
        then:
        assert result == expectedResult: "result = ${result}\nexpectedResult = ${expectedResult}"
        where:
        arr                                     || expectedResult
        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] as int[] || 9
        [10, 15, 20] as int[]                   || 20
        [1, 2, 3] as int[]                      || 3
        [] as int[]                             || 0
        [8] as int[]                            || 8
        [50, 3, 6, 42] as int[]                 || 50
        [100, 101, 89, 12] as int[]             || 101
        [11, 2, 23, 12] as int[]                || 23
        null                                    || 0
    }

    def "factorial"() {
        when:
        def result = algorithm.factorial(n)
        then:
        assert result == expectedResult: "result = ${result}\nexpectedResult = ${expectedResult}"
        where:
        n || expectedResult
        1 || 1
        5 || 120
        3 || 6
        8 || 40320

    }


}
