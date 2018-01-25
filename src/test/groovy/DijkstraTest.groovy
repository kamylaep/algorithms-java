import spock.lang.Ignore
import spock.lang.Specification

class DijkstraTest extends Specification {

    Dijkstra algorithm = new Dijkstra()

    def "Dijkstra’s algorithm"() {
        when:
        def result = algorithm.find(graph, start, end)
        then:
        assert expectedResult == result: "expectedResult = ${expectedResult}\nresult = ${result}"
        where:
        graph            | start   | end   | expectedResult
        generateGraph1() | "start" | "fin" | ["start", "B", "A", "fin"]
        generateGraph2() | "start" | "fin" | ["start", "A", "D", "fin"]
        generateGraph3() | "start" | "fin" | ["start", "A", "B", "fin"]
    }

    @Ignore
    def "Dijkstra’s algorithm with negative weight"() {
        when:
        algorithm.find(graph, start, end)
        then:
        def ex = thrown(RuntimeException)
        assert ex.message == Dijkstra.INVALID_NODE_WIGHT_ERROR_MESSAGE
        where:
        graph                             | start   | end
        generateGraphWithNegativeWeight() | "start" | "fin"
    }

    def generateGraph1() {
        def graph = [:]

        graph["start"] = ["A": 6.0 as double, "B": 2.0 as double]
        graph["A"] = ["fin": 1.0 as double]
        graph["B"] = ["A": 3.0 as double, "fin": 5.0 as double]
        graph["fin"] = [:]

        return graph
    }


    def generateGraph2() {
        def graph = [:]

        graph["start"] = ["A": 5.0 as double, "B": 2.0 as double]
        graph["A"] = ["C": 4.0 as double, "D": 2.0 as double]
        graph["B"] = ["A": 8.0 as double, "D": 7.0 as double]
        graph["C"] = ["fin": 3.0 as double, "D": 6.0 as double]
        graph["D"] = ["fin": 1.0 as double]
        graph["fin"] = [:]

        return graph
    }

    def generateGraph3() {
        def graph = [:]

        graph["start"] = ["A": 10.0 as double,]
        graph["A"] = ["B": 20.0 as double]
        graph["B"] = ["C": 1.0 as double, "fin": 30.0 as double]
        graph["C"] = ["A": 1.0 as double]
        graph["fin"] = [:]

        return graph
    }

    def generateGraphWithNegativeWeight() {
        def graph = [:]

        graph["start"] = ["A": 2.0 as double, "B": 2.0 as double]
        graph["A"] = ["B": 2.0 as double, "fin": 2.0 as double]
        graph["B"] = ["A": 2.0 as double]
        graph["C"] = ["B": -1.0 as double, "fin": 2.0 as double]
        graph["fin"] = [:]

        return graph
    }

}
