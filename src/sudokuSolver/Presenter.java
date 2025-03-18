package sudokuSolver;

public class Presenter {

    static String horizontal = "─";
    static String vertical = "│";
    static String cross = "┼";
    static String topLeft = "┏";
    static String topRight = "┓";
    static String bottomLeft = "┗";
    static String bottomRight = "┛";
    static String topSeparator = "┯";
    static String bottomSeparator = "┷";
    static String leftSeparator = "┣";
    static String rightSeparator = "┫";
    static String centerSeparator = "╂";
    static String thickHorizontal = "━";
    static String thickVertical = "┃";
    static String thickCross = "╋";
    static String semiThickCross = "┿";
    static String thickTopSeparator = "┳";
    static String thickBottomSeparator = "┻";
    static String thickLeftSeparator = "┣";
    static String thickRightSeparator = "┫";

    public static String getRepresentation(Sudoku sudoku) {
        StringBuilder res = new StringBuilder();
        res.append(topLeft);
        appendRepeated(res, thickHorizontal, 3);
        res.append(topSeparator);
        appendRepeated(res, thickHorizontal, 3);
        res.append(topSeparator);
        appendRepeated(res, thickHorizontal, 3);
        res.append(thickTopSeparator);

        appendRepeated(res, thickHorizontal, 3);
        res.append(topSeparator);
        appendRepeated(res, thickHorizontal, 3);
        res.append(topSeparator);
        appendRepeated(res, thickHorizontal, 3);
        res.append(thickTopSeparator);

        appendRepeated(res, thickHorizontal, 3);
        res.append(topSeparator);
        appendRepeated(res, thickHorizontal, 3);
        res.append(topSeparator);
        appendRepeated(res, thickHorizontal, 3);

        res.append(topRight).append("\n");

        for (int i = 0; i < 9; i++) {
            res.append(thickVertical);
            for (int j = 0; j < 9; j++) {
                if (sudoku.getValues()[i][j] == 0) res.append("   ");
                else res.append(" ").append(sudoku.getValues()[i][j]).append(" ");
                if ((j + 1) % 3 == 0 && j != 8) res.append(thickVertical);
                else if (j != 8) res.append(vertical);
            }

            res.append(thickVertical).append("\n");

            if ((i + 1) % 3 == 0 && i != 8) {
                res.append(thickLeftSeparator);

                appendRepeated(res, thickHorizontal, 3);
                res.append(semiThickCross);
                appendRepeated(res, thickHorizontal, 3);
                res.append(semiThickCross);
                appendRepeated(res, thickHorizontal, 3);

                res.append(thickCross);

                appendRepeated(res, thickHorizontal, 3);
                res.append(semiThickCross);
                appendRepeated(res, thickHorizontal, 3);
                res.append(semiThickCross);
                appendRepeated(res, thickHorizontal, 3);

                res.append(thickCross);

                appendRepeated(res, thickHorizontal, 3);
                res.append(semiThickCross);
                appendRepeated(res, thickHorizontal, 3);
                res.append(semiThickCross);
                appendRepeated(res, thickHorizontal, 3);

                res.append(thickRightSeparator).append("\n");
            } else if (i != 8) {
                res.append(leftSeparator);

                appendRepeated(res, horizontal, 3);
                res.append(cross);
                appendRepeated(res, horizontal, 3);
                res.append(cross);
                appendRepeated(res, horizontal, 3);

                res.append(centerSeparator);

                appendRepeated(res, horizontal, 3);
                res.append(cross);
                appendRepeated(res, horizontal, 3);
                res.append(cross);
                appendRepeated(res, horizontal, 3);

                res.append(centerSeparator);

                appendRepeated(res, horizontal, 3);
                res.append(cross);
                appendRepeated(res, horizontal, 3);
                res.append(cross);
                appendRepeated(res, horizontal, 3);

                res.append(rightSeparator).append("\n");
            }
        }
        res.append(bottomLeft);

        appendRepeated(res, thickHorizontal, 3);
        res.append(bottomSeparator);
        appendRepeated(res, thickHorizontal, 3);
        res.append(bottomSeparator);
        appendRepeated(res, thickHorizontal, 3);

        res.append(thickBottomSeparator);

        appendRepeated(res, thickHorizontal, 3);
        res.append(bottomSeparator);
        appendRepeated(res, thickHorizontal, 3);
        res.append(bottomSeparator);
        appendRepeated(res, thickHorizontal, 3);

        res.append(thickBottomSeparator);

        appendRepeated(res, thickHorizontal, 3);
        res.append(bottomSeparator);
        appendRepeated(res, thickHorizontal, 3);
        res.append(bottomSeparator);
        appendRepeated(res, thickHorizontal, 3);

        res.append(bottomRight).append("\n");
        return res.toString();
    }

    private static void appendRepeated(StringBuilder builder, String str, int times) {
        for (int i = 0; i < times; i++) builder.append(str);
    }
}