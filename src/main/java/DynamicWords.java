public class DynamicWords {

    public String findMostSimilarWord(String typedWord, String optionA, String optionB) {
        int opA = calcPossibilities(typedWord, optionA);
        int opb = calcPossibilities(typedWord, optionB);

        return opA > opb ? optionA : optionB;
    }

    private int calcPossibilities(String typed, String option) {
        int[][] grid = new int[typed.length()][option.length()];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int i1 = i == 0 ? i : i - 1;
                int j1 = j == 0 ? j : j - 1;

                if (typed.charAt(i) == option.charAt(j)) {
                    grid[i][j] = grid[i1][j1] + 1;
                } else {
                    grid[i][j] = Math.max(grid[i1][j], grid[i][j1]);
                }

                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        return grid[grid.length - 1][grid.length - 1];
    }

}
