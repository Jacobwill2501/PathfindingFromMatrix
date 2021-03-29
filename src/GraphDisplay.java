
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class GraphDisplay extends JPanel {
    private int numberOfVertices;
    private int[][] matrix;
    private int[] finalPath;

    public void setNumberOfVertices(int val) {
        this.numberOfVertices = val;
    }

    public void setFinalPath(int[] finalPath) {
        this.finalPath = finalPath;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void paintComponent(Graphics g) {
        int[][] locations = new int[numberOfVertices][2];
        int leftX;
        int topY;
        int centerOfCircleX = 400;
        int centerOfCircleY = 500;
        int radius = 400;

        int j = 0;

        //storing locations, changed to not draw node for look
        for (int i = 0; i < numberOfVertices; i++) {
            double t = 2 * Math.PI * i / numberOfVertices;
            leftX = (int) Math.round(centerOfCircleX + radius * Math.cos(t));
            locations[i][0] = leftX + 25;

            topY = (int) Math.round(centerOfCircleY + radius * Math.sin(t));
            locations[i][1] = topY + 25;
        }

        //Drawing edges and their weights
        for (int i = 0; i < numberOfVertices; i++) {
            for (int k = i; k < numberOfVertices; k++) {
                if(matrix[i][k] != 0){
                    drawEdge(g,locations,i,k,matrix[i][k]);
                }
            }
        }

        for (int i = 0; i < finalPath.length - 1; i++) {
            drawFinalEdges(g,locations,finalPath[i],finalPath[i+1]);
        }

        //drawing the actual nodes over edges for aesthetic purposes
        for (int i = 0; i < numberOfVertices; i++) {
            double t = 2 * Math.PI * i / numberOfVertices;
            leftX = (int) Math.round(centerOfCircleX + radius * Math.cos(t));
            topY = (int) Math.round(centerOfCircleY + radius * Math.sin(t));

            drawNode(g,j,leftX,topY);
            j++;
        }



    }

    public void drawNode(Graphics g,int currentVertex,int leftX,int topY){
        String asString = String.valueOf(currentVertex);

        g.setColor(Color.ORANGE);
        g.fillOval(leftX , topY , 50, 50);
        g.setColor(Color.BLACK);
        g.drawOval(leftX , topY , 50, 50);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        g.drawString(asString, leftX  + 19, topY  + 33);
    }

    public void drawEdge(Graphics g,int[][] locations,int vertex1,int vertex2, int weight){
        String weightAsString = String.valueOf(weight);
        int x1 = locations[vertex1][0];
        int y1 = locations[vertex1][1];
        int x2 = locations[vertex2][0];
        int y2 = locations[vertex2][1];

//        int xForString = (locations[vertex2][0] + locations[vertex1][0])/2;
//        int yForString = (locations[vertex2][1] + locations[vertex1][1])/2;

        int xForString = x1 + (x2-x1)/3;
        int yForString = y1 + (y2-y1)/3;

        g.setColor(Color.BLACK);
        g.drawLine(x1,y1,x2,y2);

        g.setColor(Color.BLUE);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        g.drawString(weightAsString,xForString - 10,yForString-10);
    }

    public void drawFinalEdges(Graphics g,int[][] locations,int vertex1,int vertex2){
        int x1 = locations[vertex1][0];
        int y1 = locations[vertex1][1];
        int x2 = locations[vertex2][0];
        int y2 = locations[vertex2][1];

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));
        g.setColor(Color.RED);
        g2.draw(new Line2D.Float(x1,y1,x2,y2));
        g2.setStroke(new BasicStroke(2));
    }

}

