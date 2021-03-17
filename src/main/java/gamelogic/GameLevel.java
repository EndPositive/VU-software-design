package main.java.gamelogic;

import main.java.misc.Cell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GameLevel {
    public int matrixSize;
    public int bufferLength;
    public final List<List<String>> solutions = new ArrayList<>();
    public final Map<Cell, String> matrix = new HashMap<>();

    public GameLevel(String filePath) throws FileNotFoundException, NumberFormatException, NoSuchElementException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        setBufferLengthFromFile(sc);
        createMatrixFromFile(sc);
        createSolutionFromFile(sc);
    }

    private void setBufferLengthFromFile(Scanner sc) {
        bufferLength = Integer.parseInt(sc.nextLine());
        sc.nextLine();
    }

    private void createMatrixFromFile(Scanner sc) {
        int i = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            if (!line.isEmpty()) {
                String[] splitLine = line.split("\\s+");

                for (int j = 0; j < splitLine.length; j++)
                    matrix.put(new Cell(j, i), splitLine[j].toUpperCase());

                i++;
            } else break;
        }

        matrixSize = i;
        if (matrixSize == 0) throw new NoSuchElementException();
    }

    private void createSolutionFromFile(Scanner sc) {
        while (sc.hasNextLine())
            solutions.add(Arrays.asList(sc.nextLine().toUpperCase().split("\\s+")));

        if (solutions.size() == 0) throw new NoSuchElementException();
    }
}
