import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row = getParameter(input, "row");
        int column = getParameter(input, "column");

        while (row * column < 3) {
            System.out.println("Please minimum matris item number 3 and higher");
            row = getParameter(input, "row");
            column = getParameter(input, "column");
        }
        MineSweeper mine = new MineSweeper(row, column);
        mine.run();
    }

    static int getParameter(Scanner input, String type) {
        System.out.print("Enter matris " + type + " length : ");
        return input.nextInt();
    }
}