package sort

import spock.lang.Specification

class BubbleSortTest extends Specification {

    BubbleSort algorithm = new BubbleSort()

    def "bubble sort"() {
        when:
        def result = algorithm.sort(unorderedArray)
        then:
        assert expectedOrderedArray as int[] == result: "expectedOrderedArray = ${expectedOrderedArray}\nresult = ${result}"
        where:
        unorderedArray                          || expectedOrderedArray
        [8, 5, 6, 1, 2, 7, 9, 3, 0, 4] as int[] || [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        [10, 5, 2, 3] as int[]                  || [2, 3, 5, 10]
        [] as int[]                             || []
        [5] as int[]                            || [5]
        [2, 1] as int[]                         || [1, 2]
        [1, 2] as int[]                         || [1, 2]
        [1, 3, 4, 2, 10] as int[]               || [1, 2, 3, 4, 10]
        [] as int[]                             || []
        null                                    || null
    }

}