package main.java.com.mycompany.practicum8;

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

class Queue {
    private int maxSize;
    private int[] queArray;
    private int front;
    private int rear;
    private int nItems;
    
    public Queue(int size) {
        maxSize = size;
        queArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    
    public void insert(int value) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = value;
        nItems++;
    }
    
    public int remove() {
        int temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }
    
    public boolean isEmpty() {
        return (nItems == 0);
    }
}

class Graph {

    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private Stack theStack;  
    private Queue theQueue;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        theStack = new Stack(MAX_VERTS);
        theQueue = new Queue(MAX_VERTS);
        for (int i = 0; i < MAX_VERTS; i++) {
          for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
          }
        }
    } 

    public void addVertex(char label) {
        vertexList[nVerts++] = 
                           new Vertex(label);
    }
 
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
    
    public void bfs() {
    System.out.println("Visit by using BFS algorithm: ");
    vertexList[0].wasVisited = true;
    displayVertex(0);
    theQueue.insert(0);
    
    int v2;
    while (!theQueue.isEmpty()) {
        int v1 = theQueue.remove();
        while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
            vertexList[v2].wasVisited = true;
            displayVertex(v2);
            theQueue.insert(v2);
        }
    }
    System.out.println("");
    resetFlags();
}

    public void dfs() {
        System.out.println("Visit by using DFS algorithm: ");
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);
        
        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        System.out.println("");
        resetFlags();
    }

    public void mst() {
    System.out.println("Minimum spanning tree: ");
    vertexList[0].wasVisited = true;     // Tandai vertex 0
    theStack.push(0);                     // Push ke stack
    
    while (!theStack.isEmpty()) {         // Selama stack tidak kosong
        int currentVertex = theStack.peek();  // Lihat vertex teratas
        int v = getAdjUnvisitedVertex(currentVertex);  // Cari tetangga
        
        if (v == -1) {                    // Jika tidak ada tetangga
            theStack.pop();               // Pop (backtrack)
        } else {                          // Jika ada tetangga
            vertexList[v].wasVisited = true;  // Tandai
            theStack.push(v);             // Push
            displayVertex(currentVertex); // Cetak edge: 
            System.out.print(" -- ");     // currentVertex -- v
            displayVertex(v);
            System.out.println("");
        }
    }
    resetFlags();                         // Reset flag
}

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label + " ");
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
        System.out.println("Adjecency:");
        for (int row = 0; row < nVerts; row++) 
        {
            for (int col = 0; col < row;
                 col++) {
                if (adjMat[row][col] == 1) {
                   System.out.println(
                      vertexList[row].label + 
                      " -- " +
                      vertexList[col].label);
                }
            }
        }
        System.out.println("");
    }
}//end class Graph
public class GraphApp {
    public static void main(String[] args) {

        Graph theGraph = new Graph();
        theGraph.addVertex('A'); // 0
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4

        theGraph.addEdge(0, 1); // AB
        theGraph.addEdge(1, 2); // BC
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(3, 4); // DE
        theGraph.display();
        theGraph.dfs();
        theGraph.bfs(); 
        theGraph.mst();
    }
}
