import java.util.Arrays;

public class Graph {
    private final int numOfNodes;
    private int[][] matrix;

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    //Simple constructor
    public Graph(int numOfNodes) {
        this.numOfNodes = numOfNodes;

        matrix = new int[numOfNodes][numOfNodes];
    }


    //printing out matrix
    public void printMatrix(){
        System.out.println();
        for (int i = 0; i < numOfNodes; i++) {
            for (int j = 0; j < numOfNodes; j++) {
                System.out.format("%8s", matrix[i][j]);
            }
            System.out.println();
        }
    }

    //printing out edges of graph
    public void printEdges(){
        System.out.println();
        for (int i = 0; i < numOfNodes; i++) {
            System.out.print("Node " + i + " is connected to: ");
            for (int j = 0; j < numOfNodes; j++) {
                if (matrix[i][j] > 0){
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public int[] getAdjacentVertices(int v){
        int[] vert = new int[numOfNodes];
        int total = 0;
        for (int i = 0; i < numOfNodes; i++) {
            if(matrix[v][i] != 0){
                vert[total] = i;
                total++;
            }
        }
        return Arrays.copyOf(vert,total);
    }

    private int minDistance(boolean[] visited, int[] distance){
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numOfNodes; i++) {
            if(!visited[i]){
                if(distance[i] <= min){
                    min = distance[i];
                    index = i;
                }
            }
        }
        return index;
    }

    public void allShortestPaths(int[] paths, int[] distances, int vertex){
        boolean[] visited = new boolean[numOfNodes];

        for (int i = 0; i < numOfNodes; i++) {
            visited[i] = false;
            paths[i] = -1;
            distances[i] = Integer.MAX_VALUE;
        }

        distances[vertex] = 0;

        for (int i = 0; i < numOfNodes; i++) {
            int w = minDistance(visited,distances);
            visited[w] = true;

            int[] adj = getAdjacentVertices(w);
            for (int u : adj) {
                if (!visited[u]){
                    if(distances[w]+matrix[w][u] < distances[u]){
                        distances[u] = distances[w]+matrix[w][u];
                        paths[u] = w;
                    }
                }
            }
        }

    }

    public int[] getPath(int s, int t, int[] p){
        int[] shortestPath = new int[p.length];

        int current = t;
        int total=0;
        while (current!=s){
            shortestPath[total]=current;
            current=p[current];
            total++;
        }
        shortestPath[total++] = s;
        shortestPath = Arrays.copyOf(shortestPath,total);

        for (int i = 0; i < total / 2; i++) {
            int temp = shortestPath[i];
            shortestPath[i] = shortestPath[total-1-i];
            shortestPath[total-1-i] = temp;
        }

        return shortestPath;
    }




}

