import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        //reading text file
        ReadInputFromTextFile r = new ReadInputFromTextFile();

        //variables
        int s = r.getS();
        int t = r.getT();
        int numberOfVertices = r.getNumberOfVertices();
        int[] paths = new int[numberOfVertices];
        int[] distances = new int[numberOfVertices];
        int[][] matrix = r.getMatrix();

        //creating graph and setting matrix
        Graph graph = new Graph(numberOfVertices);
        graph.setMatrix(matrix);

        //printing graph and edges to console
        System.out.println("Printing matrix from main:");
        graph.printMatrix();
        graph.printEdges();

        //Finding the shortest path from s to t
        graph.allShortestPaths(paths,distances,s);
        int[] finalPath = graph.getPath(s,t,paths);

        //Paint the graph with edges and the final path
        FrameDisplay frame = new FrameDisplay(numberOfVertices,matrix,finalPath);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

}
