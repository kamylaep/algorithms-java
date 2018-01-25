package datastructure

import spock.lang.Specification

class StackTest extends Specification {

    def "push"() {
        setup:
        Stack<Integer> stack = new Stack<>()
        when:
        def pus = stack.push(1)
        then:
        assert stack.size() == 1
        assert stack.linkedList.head != null
        assert stack.linkedList.head.data == 1
        assert stack.linkedList.head.data == pus
        assert stack.linkedList.head == stack.linkedList.tail
    }

    def "pop"() {
        setup:
        Stack<Integer> stack = new Stack<>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        when:
        def data = stack.pop()
        then:
        assert stack.size() == 2
        assert stack.linkedList.head != null
        assert stack.linkedList.head.data == 2
        assert data == 3
    }

    def "pop with no data"() {
        setup:
        Stack<Integer> stack = new Stack<>()
        when:
        def data = stack.pop()
        then:
        assert data == null
    }

    def "peek"() {
        setup:
        Stack<Integer> stack = new Stack<>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        when:
        def data = stack.peek()
        then:
        assert data == 3
    }

    def "peek with no data"() {
        setup:
        Stack<Integer> stack = new Stack<>()
        when:
        def data = stack.peek()
        then:
        assert data == null
    }

    def "clear"() {
        setup:
        Stack<Integer> stack = new Stack<>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        when:
        stack.clear()
        then:
        assert stack.size() == 0
        assert stack.linkedList.head == null
        assert stack.linkedList.tail == null
    }

    def "size"() {
        setup:
        Stack<Integer> stack = new Stack<>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        when:
        def size = stack.size()
        then:
        assert size == 3
    }

    def "isEmpty"() {
        setup:
        Stack<Integer> stack = new Stack<>()
        when:
        def empty = stack.isEmpty()
        then:
        assert empty == true
    }

    def "isNotEmpty"() {
        setup:
        Stack<Integer> stack = new Stack<>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        when:
        def empty = stack.isEmpty()
        then:
        assert empty == false
    }

    def "contains"() {
        setup:
        Stack<Integer> stack = new Stack<>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        when:
        def result = stack.contains(find)
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
        Stack<Integer> stack = new Stack<>()
        when:
        def result = stack.contains(find)
        then:
        assert result == expectedResult
        where:
        find || expectedResult
        1    || false
        100  || false
        3    || false
    }

}