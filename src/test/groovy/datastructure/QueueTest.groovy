package datastructure

import spock.lang.Specification

class QueueTest extends Specification {

    def "enqueue"() {
        setup:
        Queue<Integer> queue = new Queue<>()
        when:
        def enq = queue.enqueue(1)
        then:
        assert queue.size() == 1
        assert queue.linkedList.head != null
        assert queue.linkedList.head.data == 1
        assert queue.linkedList.head.data == enq
        assert queue.linkedList.head == queue.linkedList.tail
    }

    def "dequeue"() {
        setup:
        Queue<Integer> queue = new Queue<>()
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        when:
        def data = queue.dequeue()
        then:
        assert queue.size() == 2
        assert queue.linkedList.head != null
        assert queue.linkedList.head.data == 2
        assert data == 1
    }

    def "dequeue with no data"() {
        setup:
        Queue<Integer> queue = new Queue<>()
        when:
        def data = queue.dequeue()
        then:
        assert data == null
    }

    def "peek"() {
        setup:
        Queue<Integer> queue = new Queue<>()
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        when:
        def data = queue.peek()
        then:
        assert data == 1
    }

    def "peek with no data"() {
        setup:
        Queue<Integer> queue = new Queue<>()
        when:
        def data = queue.peek()
        then:
        assert data == null
    }

    def "clear"() {
        setup:
        Queue<Integer> queue = new Queue<>()
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        when:
        queue.clear()
        then:
        assert queue.size() == 0
        assert queue.linkedList.head == null
        assert queue.linkedList.tail == null
    }

    def "size"() {
        setup:
        Queue<Integer> queue = new Queue<>()
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        when:
        def size = queue.size()
        then:
        assert size == 3
    }

    def "isEmpty"() {
        setup:
        Queue<Integer> queue = new Queue<>()
        when:
        def empty = queue.isEmpty()
        then:
        assert empty == true
    }

    def "isNotEmpty"() {
        setup:
        Queue<Integer> queue = new Queue<>()
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        when:
        def empty = queue.isEmpty()
        then:
        assert empty == false
    }

    def "contains"() {
        setup:
        Queue<Integer> queue = new Queue<>()
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        when:
        def result = queue.contains(find)
        then:
        assert result == expectedResult
        where:
        find || expectedResult
        1    || true
        100  || false
        3    || true
    }

    def "contains with no data"() {
        setup:
        Queue<Integer> queue = new Queue<>()
        when:
        def result = queue.contains(find)
        then:
        assert result == expectedResult
        where:
        find || expectedResult
        1    || false
        100  || false
        3    || false
    }

}