package sort

import spock.lang.Specification

class CountingSortTest extends Specification {

    CountingSort algorithm = new CountingSort()

    def "merge sort"() {
        when:
        def result = algorithm.sort(unorderedArray)
        then:
        assert expectedOrderedArray == result: "expectedOrderedArray = ${expectedOrderedArray}\nresult = ${result}"
        where:
        unorderedArray                          || expectedOrderedArray
        [8, 5, 6, 1, 2, 7, 9, 3, 0, 4] as int[] || [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        [10, 5, 2, 3] as int[]                  || [2, 3, 5, 10]
        [] as int[]                             || []
        [5] as int[]                            || [5]
        [2, 1] as int[]                         || [1, 2]
        [800, 950, 362, 452, 800] as int[]      || [362, 452, 800, 800, 950]
        [100050, 30, 80, 10, 26] as int[]       || [10, 26, 30, 80, 100050]
        null                                    || null
    }

}