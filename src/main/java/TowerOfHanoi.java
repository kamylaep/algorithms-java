public class TowerOfHanoi {

    public static void main(String[] args) {
        new TowerOfHanoi().move(10, 'A', 'C', 'B');
    }

    public void move(int n, char from, char to, char inter) {
        if (n == 1) {
            System.out.println("Moving " + n + " from " + from + " to " + to);
        } else {
            move(n - 1, from, inter, to);
            System.out.println("Moving " + n + " from " + from + " to " + to);
            move(n - 1, inter, to, from);
        }
    }
}
