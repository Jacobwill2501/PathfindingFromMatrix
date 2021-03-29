import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadInputFromTextFile {
    int numberOfVertices;
    int mat_i_j;
    int[][] matrix = null;
    int s;
    int t;

    public ReadInputFromTextFile(){
        readGraph();
    }

    /**
     * Reads graph from text file
     * and prints it
     */
    public void readGraph(){
        File input = new File("src/graph.txt");

        Scanner in = null;
        try{
            in = new Scanner(input);
        }
        catch(FileNotFoundException e){
            System.out.println("File not found!");
        }

        numberOfVertices=0;
        mat_i_j=0;

        while (true){
            assert in != null;
            if (!in.hasNextLine()) break;
            numberOfVertices = in.nextInt();
            //System.out.println(numberOfVertices);
            matrix = new int[numberOfVertices][numberOfVertices];

            for(int i=0; i<numberOfVertices; i++){
                for(int j=0; j<numberOfVertices; j++){
                    mat_i_j = in.nextInt();
                    //System.out.print(mat_i_j + " ");
                    matrix[i][j] = mat_i_j;
                }
                System.out.println();
            }

            s = in.nextInt();
            t = in.nextInt();
            //System.out.println(s + " " + t);
        }
        in.close();

    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getS() {
        return s;
    }

    public int getT() {
        return t;
    }
}
