package search

import spock.lang.Specification


class BreadthFirstSearchTest extends Specification {

    BreadthFirstSearch algorithm = new BreadthFirstSearch()

    def "breadth first search"() {
        when:
        def result = algorithm.search(graph, startPoint, predicate)
        then:
        assert expectedResult == result: "expectedResult = ${expectedResult}\nresult = ${result}"
        where:
        graph                     | startPoint | predicate                   || expectedResult
        generatePeopleGraph()     | "banana"   | { s -> s.equals("claire") } || null
        generatePeopleGraph()     | "you"      | { s -> s.equals("claire") } || "claire"
        generatePeopleGraph()     | "you"      | { s -> s.equals("bob") }    || "bob"
        generatePeopleGraph()     | "you"      | { s -> s.equals("thom") }   || "thom"
        generatePeopleGraph()     | "you"      | { s -> s.equals("billy") }  || null

        generatePeopleLoopGraph() | "youhu"    | { s -> true }               || null
        generatePeopleLoopGraph() | "you"      | { s -> false }              || null
        generatePeopleLoopGraph() | "you"      | { s -> s.equals("alice") }  || "alice"
        generatePeopleLoopGraph() | "alice"    | { s -> false }              || null
        generatePeopleLoopGraph() | "alice"    | { s -> s.equals("you") }    || "you"

        generateNumberGraph()     | 999        | { n -> n > 200 }            || null
        generateNumberGraph()     | 15         | { n -> n > 200 }            || 350
        generateNumberGraph()     | 15         | { n -> n < 15 }             || 14
        generateNumberGraph()     | 15         | { n -> n > 100 }            || 128
        generateNumberGraph()     | 15         | { n -> n > 1000 }           || null
        generateNumberGraph()     | 15         | { n -> n < 14 }             || null
    }

    def generatePeopleGraph() {
        def people = [:]

        people["you"] = ["alice", "bob", "claire"]
        people["bob"] = ["anuj", "peggy"]
        people["alice"] = ["peggy"]
        people["claire"] = ["thom", "jonny"]
        people["anuj"] = []
        people["peggy"] = []
        people["thom"] = []
        people["jonny"] = []

        return people
    }

    def generatePeopleLoopGraph() {
        def people = [:]

        people["you"] = ["alice", "bob", "claire"]
        people["alice"] = ["you"]

        return people
    }

    def generateNumberGraph() {
        def number = [:]

        number[15] = [60, 58, 98, 23, 100]
        number[100] = [14, 26, 98]
        number[98] = [350, 47]
        number[23] = [50, 47]
        number[60] = []
        number[58] = [128]
        number[50] = []
        number[47] = [15]
        number[128] = []

        return number
    }

}
