package main.java.gamelogic;

import main.java.misc.Cell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GameLevel {
    public int bufferLength;
    public final List<List<String>> solutions = new ArrayList<>();
    public final Map<Cell, String> matrix = new HashMap<>();

    public GameLevel(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        bufferLength = Integer.parseInt(sc.nextLine());
        sc.nextLine();

        int i = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            if (!line.isEmpty()) {
                String[] splitLine = line.split("\\s+");

                for (int j = 0; j < splitLine.length; j++)
                    matrix.put(new Cell(j, i), splitLine[j]);

                i++;
            } else break;
        }

        while (sc.hasNextLine()) {
            solutions.add(Arrays.asList(sc.nextLine().split("\\s+")));
        }
    }
}
