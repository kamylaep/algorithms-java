package sort

import spock.lang.Specification


class SelectionSortTest extends Specification {

    SelectionSort algorithm = new SelectionSort()

    def "selection sort"() {
        when:
        def result = algorithm.sort(arrayToSort)
        then:
        assert result == expectedSortedArray: "result = ${result}\nexpectedSortedArray = ${expectedSortedArray}"
        where:
        arrayToSort                    || expectedSortedArray
        [8, 5, 6, 1, 2, 7, 9, 3, 0, 4] || [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        [10, 5, 2, 3]                  || [2, 3, 5, 10]
        []                             || []
        [5]                            || [5]
        [2, 1]                         || [1, 2]
        [1, 2, 3]                      || [1, 2, 3]
        null                           || null
    }

}