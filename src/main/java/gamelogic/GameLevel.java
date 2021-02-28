package main.java.gamelogic;

import main.java.misc.Cell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GameLevel {
    public int buffer;
    public final List<List<String>> solutions = new ArrayList<>();
    public final Map<Cell, String> matrix = new HashMap<>();

    public GameLevel(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        this.buffer = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.matrix.put(new Cell(i, j), sc.next());
            }
        }

        //matrix.forEach((key, value) -> System.out.print("(" + key.x + "," + key.y + ") : " + value + "\n"));
        //System.out.println(matrix.get(new Cell(1,1)));

        //These two are required to be here because the scanner reads [] twice after the matrix is finished reading
        //I don't understand where they are coming from...
        sc.nextLine();
        sc.nextLine();

        while (sc.hasNextLine()) {
            solutions.add(Arrays.asList(sc.nextLine().split("\\s+")));
        }
    }
}
