import java.text.NumberFormat;
import java.util.*;
public class Graph {

    //number format class provides the interface for formatting and parsing numbers.
    public NumberFormat fmt = NumberFormat.getCurrencyInstance();

    //this is adjacency matrix to represent graph
    private int [][] adjMatrix;
    //citynames represent vertices in the graph
    private String [] citynames;
    //size is the number of vertices in the graph
    private int size;

    //constructor. takes a string array of city names as a parameter
    //the initial value of weight for each edge in adjMatrix is set to Integer.Max_Value

    public Graph(String [] citylist){
        int numcitynames = citylist.length;
        adjMatrix = new int [numcitynames][numcitynames];
        citynames = citylist;


        for( int i = 0; i < numcitynames; i ++ ){
            for ( int j = 0; j < numcitynames; j ++ ){
                adjMatrix[i][j]= Integer.MAX_VALUE;
            }
        }


    }

    //addEdge method add edge to graph
    //given two endpoints and the weight of the edge, you will add the edge to the graph.
    //you can assume that the graph is undirected
    public void addEdge(int c1, int c2, int weight){
        if ( c1 >= 0 && c1 < citynames.length && c2 >= 0 && c2 < citynames.length){
            adjMatrix[c1][c2] = weight;
            adjMatrix[c2][c1] = weight;
        }else{
            System.out.println("Invalid city indices.");
        }



    }

    //build the mst from vertex 0
    public int prims() {
        return prims(0);
    }


    //prims build the mst from given vertex start
    //prims returns the minimum cost it would require to build the necessary tracks to
    //connect all the citynames. The method should also print a list of edges as it is building the MST
    // prims will call overload version below to finish important functionality.
    public int prims(int start){
        boolean[] visited = new boolean[citynames.length];
        int[] minWeight = new int[citynames.length];
        int[] parent = new int[citynames.length];
        List<String> edges = new ArrayList<>();
        int minCost = 0;

        for (int i = 0; i < citynames.length; i++) {
            minWeight[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        minWeight[start] = 0;
        parent[start] = -1;

        for (int i = 0; i < citynames.length - 1; i++) {
            int minVertex = -1;
            for (int v = 0; v < citynames.length; v++) {
                if (!visited[v] && (minVertex == -1 || minWeight[v] < minWeight[minVertex])) {
                    minVertex = v;
                }
            }

            visited[minVertex] = true;

            if (parent[minVertex] != -1) {
                edges.add(citynames[parent[minVertex]] + " - " + citynames[minVertex] + " : " + adjMatrix[minVertex][parent[minVertex]]);
                minCost += adjMatrix[minVertex][parent[minVertex]];
            }

            for (int j = 0; j < citynames.length; j++) {
                if (adjMatrix[minVertex][j] < minWeight[j] && !visited[j]) {
                    minWeight[j] = adjMatrix[minVertex][j];
                    parent[j] = minVertex;
                }
            }
        }

        System.out.println("Edges in the Minimum Spanning Tree (MST):");
        for (String edge : edges) {
            System.out.println(edge);
        }

        return minCost;
    }

    //prims build the MST recursively. the parameter is arraylist visited
    //it returns the total weight of this mst
    //this is the method who does the real work


    //overloaded addedge method
    //the parameter are 2 strings which represents the end vertices and weight represents weight of the edge.
    public void addEdge(String c1, String c2, int weight){
        //fill in body
    }


    //this is overloaded prims method
    //given a string representing the vertex, build the mst and return the total
    public int prims(String cityname){
        int start = -1;

        // Find the index corresponding to the city name
        for (int i = 0; i < citynames.length; i++) {
            if (citynames[i].equals(cityname)) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            System.out.println("City not found.");
            return -1; // Return -1 to indicate city not found
        }

        // Initiate the MST construction using the index found
        return prims(start);
    }

}
