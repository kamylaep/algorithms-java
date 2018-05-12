package datastructure

import spock.lang.Specification

class HeapTest extends Specification {

    def "add"() {
        setup:
        Heap heap = new Heap();
        when:
        heap.add(2)
        heap.add(5)
        heap.add(1)
        heap.add(3)
        heap.add(4)
        then:
        assert heap.size == 5
    }
}