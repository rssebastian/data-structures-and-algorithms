// Adaptation of LazyPrimMST.java created by Robert Sedgewick and Kevin Wayne

import edu.princeton.cs.algs4.*;

public class CableCompany {
    private static final double FLOATING_POINT_EPSILON = 1E-12;
    private double weight;       // total weight of MST
    private Queue<Edge> mst;     // edges in the MST
    private boolean[] marked;    // marked[v] = true iff v on tree
    private MinPQ<Edge> pq;      // edges with one endpoint in tree
    int[] sites = {7, 14, 25, 28, 40};

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     * @param G the edge-weighted graph
     */
    public CableCompany(EdgeWeightedGraph G) {
        mst = new Queue<Edge>();
        pq = new MinPQ<Edge>();
        marked = new boolean[G.V()];
        /** Add all field stations to the PQ and add their edges to the PQ
         Prior to scanning the rest of the vertices
         */
        for (int site : sites) {
            marked[site] = true;
            for (Edge e : G.adj(site)) pq.insert(e);
        }
        while (!pq.isEmpty()) {                        // better to stop when mst has V-1 edges
            Edge e = pq.delMin();                      // smallest edge on pq
            int v = e.either(), w = e.other(v);        // two endpoints
            if (marked[v] && marked[w]) continue;      // lazy, both v and w already scanned
            mst.enqueue(e);                            // add e to MST
            weight += e.weight();
            if (!marked[v]) scan(G, v);                // v becomes part of tree
            if (!marked[w]) scan(G, w);                // w becomes part of tree
        }
    }

    // add all edges e incident to v onto pq if the other endpoint has not yet been scanned
    private void scan(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v))
            if (!marked[e.other(v)]) pq.insert(e);
    }

    /**
     * Returns the edges in a minimum spanning tree (or forest).
     * @return the edges in a minimum spanning tree (or forest) as
     *    an iterable of edges
     */
    public Iterable<Edge> edges() {
        return mst;
    }

    /**
     * Returns the sum of the edge weights in a minimum spanning tree (or forest).
     * @return the sum of the edge weights in a minimum spanning tree (or forest)
     */
    public double weight() {
        return weight;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G;
        G = new EdgeWeightedGraph(in);

        CableCompany network = new CableCompany(G);
        for (Edge e : network.edges()){
            StdOut.println(e);
        }
        StdOut.println(network.weight());
    }
}

/*TEST CASE OUTPUT
5-7 15.00000
1-5 13.00000
3-14 15.00000
3-8 15.00000
2-3 15.00000
14-21 16.00000
23-28 18.00000
1-6 18.00000
0-6 17.00000
4-5 20.00000
7-17 20.00000
17-32 15.00000
18-32 15.00000
2-9 20.00000
40-45 20.00000
25-31 21.00000
26-31 20.00000
11-45 21.00000
12-14 22.00000
10-12 22.00000
14-19 23.00000
41-45 23.00000
41-43 14.00000
43-47 15.00000
28-35 25.00000
24-25 25.00000
24-29 15.00000
7-16 25.00000
34-41 25.00000
34-42 20.00000
42-44 24.00000
27-34 25.00000
40-46 28.00000
46-48 15.00000
39-46 20.00000
36-39 25.00000
33-39 25.00000
33-49 20.00000
33-38 25.00000
37-38 25.00000
17-22 28.00000
10-13 28.00000
13-15 28.00000
15-20 25.00000
30-37 30.00000
939.0
*/

/*Running with 7 as field station
    994.0*/

/*Running with 14 as field station
    973.0*/

/*Running with 25 as field station
    981.0*/

/*Running with 28 as field station
    983.0*/

/*Running with 40 as field station
    988.0*/
