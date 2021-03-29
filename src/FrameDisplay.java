import javax.swing.*;

public class FrameDisplay extends JFrame {

    final int WIDTH = 900;
    final int HEIGHT = 1000;

    public FrameDisplay(int numberOfVertices, int[][] matrix, int[] finalPath) {
        setTitle("Graph Display");
        setSize(WIDTH, HEIGHT);

        GraphDisplay panel = new GraphDisplay();
        panel.setNumberOfVertices(numberOfVertices);
        panel.setMatrix(matrix);
        panel.setFinalPath(finalPath);
        add(panel);
    }

}
