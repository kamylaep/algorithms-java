package search

import spock.lang.Specification


class BinarySearchTest extends Specification {

    BinarySearch algorithm = new BinarySearch()

    def "binary search"() {
        when:
        def result = algorithm.search(searchElements as int[], findElement)
        then:
        assert expectedPosition == result: "expectedPosition = ${expectedPosition}\nposition = ${result}"
        where:
        searchElements                 | findElement || expectedPosition
        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] | 5           || 5
        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] | 9           || 9
        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] | 10          || -1
        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] | 0           || 0
        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] | 2           || 2

    }

}