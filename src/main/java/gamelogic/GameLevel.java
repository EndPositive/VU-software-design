package main.java.gamelogic;

import main.java.misc.Cell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GameLevel {
    private final Map<Cell, String> matrix = new HashMap<>();
    private final List<Sequence> solutions = new ArrayList<>();
    private int matrixSize;
    private int bufferLength;

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
            if (line.isEmpty()) break;

            String[] splitLine = line.split("\\s+");

            for (int j = 0; j < splitLine.length; j++)
                matrix.put(new Cell(j, i), splitLine[j].toUpperCase());

            i++;
        }

        matrixSize = i;
        if (matrixSize == 0) throw new NoSuchElementException();
    }

    private void createSolutionFromFile(Scanner sc) {
        while (sc.hasNextLine())
            // this line reads a line from the file and parses it
            solutions.add(new Sequence(Arrays.asList(sc.nextLine().toUpperCase().split("\\s+"))));

        if (solutions.isEmpty()) throw new NoSuchElementException();
    }

    public int getMatrixSize() {
        return matrixSize;
    }

    public int getBufferLength() {
        return bufferLength;
    }

    public Map<Cell, String> getMatrix() {
        return matrix;
    }

    public List<Sequence> getSolutions() {
        return solutions;
    }
}
