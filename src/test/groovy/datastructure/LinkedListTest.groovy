package datastructure

import spock.lang.Specification

class LinkedListTest extends Specification {

    def "addFirst"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        when:
        linkedList.addFirst(1)
        then:
        assert linkedList.size() == 1
        assert linkedList.head != null
        assert linkedList.head.data == 1
        assert linkedList.head == linkedList.tail
    }

    def "addFirst when data already exists"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        linkedList.addFirst(1)
        when:
        linkedList.addFirst(2)
        then:
        assert linkedList.size() == 2
        assert linkedList.head != null
        assert linkedList.head.data == 2
        assert linkedList.head.next != null
        assert linkedList.head.next.data == 1
        assert linkedList.tail.data == 1
    }

    def "addLast"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        when:
        linkedList.addLast(1)
        then:
        assert linkedList.size() == 1
        assert linkedList.tail != null
        assert linkedList.tail.data == 1
        assert linkedList.head == linkedList.tail
    }

    def "addLast when data already exists"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        linkedList.addLast(1)
        when:
        linkedList.addLast(2)
        then:
        assert linkedList.size() == 2
        assert linkedList.tail != null
        assert linkedList.tail.data == 2
        assert linkedList.tail.previous != null
        assert linkedList.tail.previous.data == 1
        assert linkedList.head.data == 1
    }

    def "removeFirst"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        linkedList.addFirst(1)
        linkedList.addFirst(2)
        linkedList.addFirst(3)
        when:
        def data = linkedList.removeFirst()
        then:
        assert linkedList.size() == 2
        assert linkedList.head != null
        assert linkedList.head.data == 2
        assert data == 3
    }

    def "removeFirst with no data"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        when:
        def data = linkedList.removeFirst()
        then:
        assert data == null
    }

    def "removeLast"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        linkedList.addLast(1)
        linkedList.addLast(2)
        linkedList.addLast(3)
        when:
        def data = linkedList.removeLast()
        then:
        assert linkedList.size() == 2
        assert linkedList.tail != null
        assert linkedList.tail.data == 2
        assert data == 3
    }

    def "removeLast with no data"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        when:
        def data = linkedList.removeLast()
        then:
        assert data == null
    }

    def "remove"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        linkedList.addFirst(1)
        linkedList.addFirst(2)
        linkedList.addFirst(3)
        when:
        def data = linkedList.remove(2)
        then:
        assert linkedList.size() == 2
        assert linkedList.head != null
        assert linkedList.head.data == 3
        assert linkedList.head.next.data == 1
        assert linkedList.head.previous == null
        assert linkedList.head.next.next == null
        assert linkedList.head.next.previous.data == 3
        assert data == 2
    }

    def "remove with no data"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        when:
        def data = linkedList.remove(4)
        then:
        assert data == null
    }

    def "remove with data not found"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        linkedList.addFirst(1)
        linkedList.addFirst(2)
        linkedList.addFirst(3)
        when:
        def data = linkedList.remove(4)
        then:
        assert data == null
    }

    def "getFirst"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        linkedList.addFirst(1)
        linkedList.addFirst(2)
        linkedList.addFirst(3)
        when:
        def data = linkedList.peekFirst()
        then:
        assert data == 3
    }

    def "getFirst with no data"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        when:
        def data = linkedList.peekFirst()
        then:
        assert data == null
    }

    def "getLast"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        linkedList.addLast(1)
        linkedList.addLast(2)
        linkedList.addLast(3)
        when:
        def data = linkedList.peekLast()
        then:
        assert data == 3
    }

    def "getLast with no data"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        when:
        def data = linkedList.peekLast()
        then:
        assert data == null
    }

    def "clear"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        linkedList.addLast(1)
        linkedList.addLast(2)
        linkedList.addLast(3)
        when:
        linkedList.clear()
        then:
        assert linkedList.size() == 0
        assert linkedList.head == null
        assert linkedList.tail == null
    }

    def "size"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        linkedList.addLast(1)
        linkedList.addLast(2)
        linkedList.addLast(3)
        when:
        def size = linkedList.size()
        then:
        assert size == 3
    }

    def "isEmpty"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        when:
        def empty = linkedList.isEmpty()
        then:
        assert empty == true
    }

    def "isNotEmpty"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        linkedList.addLast(1)
        linkedList.addLast(2)
        linkedList.addLast(3)
        when:
        def empty = linkedList.isEmpty()
        then:
        assert empty == false
    }


    def "contains"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        linkedList.addLast(1)
        linkedList.addFirst(2)
        linkedList.addLast(3)
        when:
        def result = linkedList.contains(find)
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
        LinkedList<Integer> linkedList = new LinkedList<>()
        when:
        def result = linkedList.contains(find)
        then:
        assert result == expectedResult
        where:
        find || expectedResult
        1    || false
        100  || false
        3    || false
    }


    def "reverseHead"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        linkedList.addFirst(1)
        linkedList.addFirst(2)
        linkedList.addFirst(3)
        when:
        linkedList.reverseHead()
        then:
        assert linkedList.head.data == 3
        assert linkedList.tail.data == 1
    }

    def "reverseHead with no data"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        when:
        linkedList.reverseHead()
        then:
        assert linkedList.head == null
        assert linkedList.tail == null
    }

    def "reverseTail"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        linkedList.addFirst(1)
        linkedList.addFirst(2)
        linkedList.addFirst(3)
        when:
        linkedList.reverseTail()
        then:
        assert linkedList.head.data == 1
        assert linkedList.tail.data == 3
    }

    def "reverseTail with no data"() {
        setup:
        LinkedList<Integer> linkedList = new LinkedList<>()
        when:
        linkedList.reverseTail()
        then:
        assert linkedList.head == null
        assert linkedList.tail == null
    }

}