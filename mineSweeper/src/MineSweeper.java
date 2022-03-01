import java.util.Scanner;

class MineSweeper {
    int row;
    int column;
    int mineNumber;
    String[][] matris;
    String[][] bombMatris;
    static Scanner innerInput = new Scanner(System.in);

    MineSweeper(int row, int column) {
        this.row = row;
        this.column = column;
        this.matris = new String[this.row][this.column];
        this.bombMatris = new String[this.row][this.column];
        this.mineNumber = (this.row * this.column) / 3;
    }

    void run() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                this.matris[i][j] = "-";
                this.bombMatris[i][j] = "-";
            }
        }
        putInBomb();
    }

    void putInBomb() {
        while (this.mineNumber > 0) {
            int tempX = (int) (Math.random() * this.row), tempY = (int) (Math.random() * this.column);
            this.bombMatris[tempX][tempY] = "*";
            this.mineNumber--;
        }
        enterIndex();
    }

    void viewMatris() {
        System.out.println();
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                System.out.print(this.matris[i][j] + " ");
            }
            System.out.println();
        }
    }

    void enterIndex() {
        int tempRow;
        int tempColumn;
        int ticket = this.row * this.column;
        boolean isWin = true;

        while (isWin && ticket > 1) {
            viewMatris();
            System.out.println("Enter new matris index ");
            System.out.print("Enter row : ");
            tempRow = innerInput.nextInt();
            System.out.print("Enter column : ");
            tempColumn = innerInput.nextInt();

            if ((tempRow <= this.row) && (tempRow >= 0) && (tempColumn <= this.column) && (tempColumn >= 0)) {
                if (this.bombMatris[tempRow][tempColumn] == "*") {
                    System.out.println("Game Over!");
                    isWin = false;
                    ticket = 0;
                } else if (this.bombMatris[tempRow][tempColumn] != "-") {
                    break;
                } else {
                    int bombNumber = 0;
                    for (int i = (tempRow - 1 >= 0) ? tempRow - 1 : 0; i <= ((tempRow + 1 < this.row) ? tempRow + 1 : this.row - 1); i++) {
                        for (int j = (tempColumn - 1 >= 0) ? tempColumn - 1 : 0; j <= ((tempColumn + 1 < this.column) ? tempColumn + 1 : this.column - 1); j++) {
                            if (bombMatris[i][j] == "*") {
                                bombNumber++;
                            }
                        }
                    }
                    matris[tempRow][tempColumn] = String.valueOf(bombNumber);
                }
            } else {
                break;
            }
            ticket--;
        }

        if (isWin) {
            System.out.println("Congratulations!");
        }
    }
}