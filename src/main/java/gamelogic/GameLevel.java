package main.java.gamelogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import main.java.misc.Cell;

public class GameLevel {
    public int buffer;
    public List<List<String>> solutions = new ArrayList<>();
    public Map<Cell, String> matrix = new HashMap<>();

    public GameLevel(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
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

        while (sc.hasNextLine()) {
            solutions.add(Arrays.asList(sc.nextLine().split("\\s+")));
        }
    }
}
