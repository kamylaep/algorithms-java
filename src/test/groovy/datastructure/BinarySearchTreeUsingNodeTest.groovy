package datastructure

import spock.lang.Specification

class BinarySearchTreeUsingNodeTest extends Specification {

    def "constructor with root"() {
        when:
        BinarySearchTreeUsingNode tree = new BinarySearchTreeUsingNode(data)
        then:
        assert tree.root.data == data
        assert tree.root.right == null
        assert tree.root.left == null
        where:
        data << [2,
                 4,
                 "String"]
    }

    def "constructor with empty root"() {
        when:
        new BinarySearchTreeUsingNode(null)
        then:
        def ex = thrown(IllegalArgumentException)
        assert ex.message == "Invalid empty root"
    }

    def "constructor with array"() {
        when:
        BinarySearchTreeUsingNode tree = new BinarySearchTreeUsingNode(8, 5, 12, 3, 6, 9, 15, 2, 4, 7, 14, 23);
        then: "root"
        assert tree.root.data == 8
        and: "level 1"
        assert tree.root.left.data == 5
        assert tree.root.right.data == 12
        and: "level 2"
        assert tree.root.left.left.data == 3
        assert tree.root.left.right.data == 6
        assert tree.root.right.left.data == 9
        assert tree.root.right.right.data == 15
        and: "level 3"
        assert tree.root.left.left.left.data == 2
        assert tree.root.left.left.right.data == 4
        assert tree.root.left.right.left == null
        assert tree.root.left.right.right.data == 7
        assert tree.root.right.left.left == null
        assert tree.root.right.left.right == null
        assert tree.root.right.right.left.data == 14
        assert tree.root.right.right.right.data == 23
    }

    def "constructor with empty array"() {
        when:
        new BinarySearchTreeUsingNode();
        then:
        def ex = thrown(IllegalArgumentException)
        assert ex.message == "Invalid empty array"
    }

    def "insert"() {
        when:
        BinarySearchTreeUsingNode tree = createTree()
        then: "root"
        assert tree.root.data == 8
        and: "level 1"
        assert tree.root.left.data == 5
        assert tree.root.right.data == 12
        and: "level 2"
        assert tree.root.left.left.data == 3
        assert tree.root.left.right.data == 6
        assert tree.root.right.left.data == 9
        assert tree.root.right.right.data == 15
        and: "level 3"
        assert tree.root.left.left.left.data == 2
        assert tree.root.left.left.right.data == 4
        assert tree.root.left.right.left == null
        assert tree.root.left.right.right.data == 7
        assert tree.root.right.left.left == null
        assert tree.root.right.left.right == null
        assert tree.root.right.right.left.data == 14
        assert tree.root.right.right.right.data == 23
    }

    def "insert whit null root"() {
        setup:
        BinarySearchTreeUsingNode tree = new BinarySearchTreeUsingNode(8)
        when:
        tree.remove(8)
        and:
        tree.insert(2)
        then:
        assert tree.root.data == 2
    }

    def "leafsNodeCount"() {
        setup:
        BinarySearchTreeUsingNode tree = createTree()
        when:
        def leafs = tree.leafsNodeCount()
        then:
        assert leafs == 6
    }

    def "leafsNodeCount with deletion"() {
        setup:
        BinarySearchTreeUsingNode tree = createTree()
        and:
        tree.remove(7)
        when:
        def leafs = tree.leafsNodeCount()
        then:
        assert leafs == 6
    }

    def "allNodesCount"() {
        setup:
        BinarySearchTreeUsingNode tree = createTree()
        when:
        def size = tree.allNodesCount()
        then:
        assert size == 13
    }

    def "allNodesCount with deletion"() {
        setup:
        BinarySearchTreeUsingNode tree = createTree()
        and:
        tree.remove(12)
        when:
        def size = tree.allNodesCount()
        then:
        assert size == 12
    }

    def "height"() {
        setup:
        BinarySearchTreeUsingNode tree = createTree()
        when:
        def height = tree.height()
        then:
        assert height == 5
    }

    def "height with deletion of a whole level"() {
        setup:
        BinarySearchTreeUsingNode tree = createTree()
        and:
        tree.remove(2)
        tree.remove(4)
        tree.remove(7)
        tree.remove(14)
        tree.remove(23)
        when:
        def height = tree.height()
        then:
        assert height == 4
    }

    def "min"() {
        setup:
        BinarySearchTreeUsingNode tree = createTree()
        when:
        def min = tree.min()
        then:
        assert min == 2
    }

    def "min with deletion"() {
        setup:
        BinarySearchTreeUsingNode tree = createTree()
        and:
        tree.remove(2)
        when:
        def min = tree.min()
        then:
        assert min == 3
    }

    def "max"() {
        setup:
        BinarySearchTreeUsingNode tree = createTree()
        when:
        def max = tree.max()
        then:
        assert max == 23
    }

    def "max with deletion"() {
        setup:
        BinarySearchTreeUsingNode tree = createTree()
        and:
        tree.remove(23)
        when:
        def max = tree.max()
        then:
        assert max == 22
    }

    def "search"() {
        setup:
        BinarySearchTreeUsingNode tree = createTree()
        when:
        def result = tree.search(search)
        then:
        assert result == expectedResult
        where:
        search || expectedResult
        23     || 23
        2      || 2
        8      || 8
        14     || 14
        99     || null
        null   || null
    }

    def "delete"() {
        setup:
        BinarySearchTreeUsingNode tree = createTree()
        when:
        def deleted = tree.remove(search)
        and:
        def searchResult = tree.search(search)
        then:
        assert deleted == expectedDeletedResult
        assert searchResult == null
        where:
        search || expectedDeletedResult
        23     || 23
        2      || 2
        8      || 8
        14     || 14
        99     || null
        null   || null
        7      || 7
        4      || 4
        2      || 2
        6      || 6
        9      || 9
    }

    def "traverse inorder"() {
        setup:
        BinarySearchTreeUsingNode tree = createTree()
        when:
        def result = [];
        tree.traverseInOrder({ c -> result << c })
        then:
        assert result == [2, 3, 4, 5, 6, 7, 8, 9, 12, 14, 15, 22, 23]
    }

    def "traverse preorder"() {
        setup:
        BinarySearchTreeUsingNode tree = createTree()
        when:
        def result = [];
        tree.traversePreOrder({ c -> result << c })
        then:
        assert result == [8, 5, 3, 2, 4, 6, 7, 12, 9, 15, 14, 23, 22]
    }

    def "traverse posorder"() {
        setup:
        BinarySearchTreeUsingNode tree = createTree()
        when:
        def result = [];
        tree.traversePosOrder({ c -> result << c })
        then:
        assert result == [2, 4, 3, 7, 6, 5, 9, 14, 22, 23, 15, 12, 8]
    }

    /*
    *                   8
    *         5                       12
    *   3           6           9           15
    * 2   4           7                 14      23
    *                                        22
    * */

    def createTree() {
        BinarySearchTreeUsingNode tree = new BinarySearchTreeUsingNode(8)
        tree.insert(5)
        tree.insert(3)
        tree.insert(6)
        tree.insert(12)
        tree.insert(9)
        tree.insert(15)
        tree.insert(2)
        tree.insert(4)
        tree.insert(7)
        tree.insert(23)
        tree.insert(14)
        tree.insert(22)
        return tree
    }

}