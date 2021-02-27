package misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameLevel {
    public int buffer;
    public int numOfSolutions;
    public String[][] solutions = new String[4][];
    public Map<Cell, String> matrix = new HashMap<>();

    //TODO: pass a 'String path' in the definition
    public GameLevel() throws FileNotFoundException {
        File file = new File("C:\\Users\\sebii\\Desktop\\software-design-vu-Assignment2\\src\\resources\\01.txt");
        Scanner sc = new Scanner(file);

        this.buffer = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.matrix.put(new Cell(i, j), sc.next());
            }
        }

        //These two are required to be here because the scanner reads [] twice after the matrix is finished reading
        //I don't understand where they are coming from...
        sc.nextLine();
        sc.nextLine();

        this.numOfSolutions = 0;
        while (sc.hasNextLine()) {
            this.solutions[this.numOfSolutions] = sc.nextLine().split("\\s+");
            this.numOfSolutions++;
        }
    }
}
