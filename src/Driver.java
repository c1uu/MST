import java.text.NumberFormat;

public class Driver {
    public static void main(String[] args){
        //build graph
        Graph g = buildGraph();

        //call prims() to build mst starting from vertex 0
        int cost = g.prims() * 1000;
        NumberFormat fmt = NumberFormat.getNumberInstance();
        //print total cost
        System.out.println("Total cost: " + fmt.format(cost));
    }

    //buildGraph will build the graph provided in the homework
    private static Graph buildGraph(){
        //names is array of cityname

        String names [] = {"Seattle", "San Francisco", "Las Vegas", "Los Angeles", "Denver", "Minneapolis", "Dallas", "Chicago", "Washington DC", "Boston", "New York", "Miami"};

        //create graph object and add edge including weight
        Graph g = new Graph(names);
        g.addEdge(0,1,1306);
        g.addEdge(0,4,2161);
        g.addEdge(0,5,2661);
        g.addEdge(0,5,2661);
        g.addEdge(1,2,919);
        g.addEdge(1,3,629);
        g.addEdge(2,3,435);
        g.addEdge(2,4,1225);
        g.addEdge(2,6,1983);
        g.addEdge(4,5,1483);
        g.addEdge(4,6,1258);
        g.addEdge(5,6,1532);
        g.addEdge(5,7,661);
        g.addEdge(6,8,2113);
        g.addEdge(6,11,2161);
        g.addEdge(7,8,1145);
        g.addEdge(7,9,1613);
        g.addEdge(8,9,725);
        g.addEdge(8,10,383);
        g.addEdge(8,11,1709);
        g.addEdge(9,10,338);
        g.addEdge(10,11,2145);
        return g;




    }
}
