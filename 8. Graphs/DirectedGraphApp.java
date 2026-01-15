package practicum10;

class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        wasVisited = false;
    }
} 

class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;
    
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }
    
    public void push(int value) {
        stackArray[++top] = value;
    }
    
    public int pop() {
        return stackArray[top--];
    }
    
    public int peek() {
        return stackArray[top];
    }
    
    public boolean isEmpty() {
        return (top == -1);
    }
}

class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private Stack theStack;
    private char sortedArray[];

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        theStack = new Stack(MAX_VERTS);
        sortedArray = new char[MAX_VERTS];
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    } 

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }
 
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
    }

    public void dfs() {
        System.out.println("Connectivity Table:");
        
        for (int start = 0; start < nVerts; start++) {
            System.out.print(vertexList[start].label + " ");
            resetFlags();
            dfsFromVertex(start);
            
            for (int i = 0; i < nVerts; i++) {
                if (vertexList[i].wasVisited && i != start) {
                    System.out.print(vertexList[i].label + " ");
                }
            }
            System.out.println();
        }
        resetFlags();
    }
    
    private void dfsFromVertex(int start) {
        vertexList[start].wasVisited = true;
        theStack.push(start);
        
        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                theStack.push(v);
            }
        }
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }

    private void resetFlags() {
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void display() {
        System.out.println("Directed Graph Edges:");
        for (int row = 0; row < nVerts; row++) {
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] == 1) {
                    System.out.println(
                        vertexList[row].label + 
                        " -> " +
                        vertexList[col].label);
                }
            }
        }
        System.out.println("");
    }

        public void topo() {
        int orig_nVerts = nVerts;
        while (nVerts > 0) {
            int currentVertex = noSuccessors();
            if (currentVertex == -1) {
                System.out.println("ERROR: Graph has cycles");
                return;
            }
            sortedArray[nVerts - 1] = vertexList[currentVertex].label;
            deleteVertex(currentVertex);
        }
        System.out.println("Topologically sorted order: ");
        for (int i = 0; i < orig_nVerts; i++) {
            System.out.print(sortedArray[i] + " ");
        }
        System.out.println("");
    }

    private int noSuccessors() {
        boolean isEdge;
        for (int row = 0; row < nVerts; row++) {
            isEdge = false;
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] > 0) {
                    isEdge = true;
                    break;
                }
            }
            if (!isEdge) {
                return row;
            }
        }
        return -1;
    }

    private void deleteVertex(int delVert) {
        if (delVert != nVerts - 1) {
            for (int j = delVert; j < nVerts - 1; j++) {
                vertexList[j] = vertexList[j + 1];
            }
            for (int row = delVert; row < nVerts - 1; row++) {
                moveRowUp(row, nVerts);
            }
            for (int col = delVert; col < nVerts - 1; col++) {
                moveColLeft(col, nVerts - 1);
            }
        }
        nVerts--;
    }

    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++) {
            adjMat[row][col] = adjMat[row + 1][col];
        }
    }

    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++) {
            adjMat[row][col] = adjMat[row][col + 1];
        }
    }
}

public class DirectedGraphApp {
    public static void main(String[] args) {
        System.out.println("Directed Graph Example");
        Graph theGraph = new Graph();
        
        //Vertexes
        theGraph.addVertex('A'); // 0
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4

        //Edges
        theGraph.addEdge(0, 2); // A -> C
        theGraph.addEdge(1, 4); // B -> E
        theGraph.addEdge(1, 0); // B -> A
        theGraph.addEdge(4, 2); // E -> C
        theGraph.addEdge(3, 4); // D -> E
        
        theGraph.display();
        theGraph.dfs();
        theGraph.topo();
        theGraph.display();
    }
}
/*  
 * 
 */