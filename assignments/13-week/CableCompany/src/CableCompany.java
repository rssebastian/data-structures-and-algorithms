// Adaptation of DijkstraUndirectedSP.java created by Robert Sedgewick and Kevin Wayne

import edu.princeton.cs.algs4.*;

import java.util.Arrays;

public class CableCompany {
    private double[] distTo;          // distTo[v] = distance  of shortest s->v path
    private Edge[] edgeTo;            // edgeTo[v] = last edge on shortest s->v path
    private IndexMinPQ<Double> pq;    // priority queue of vertices
    private static int[] sites = {7, 14, 25, 28, 40};
    private int site;
    public CableCompany(EdgeWeightedGraph G, int s) {
        site = s;
        for (Edge e : G.edges()) {
            if (e.weight() < 0)
                throw new IllegalArgumentException("edge " + e + " has negative weight");
        }

        distTo = new double[G.V()];
        edgeTo = new Edge[G.V()];

        validateVertex(s);

        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        // relax vertices in order of distance from s
        pq = new IndexMinPQ<Double>(G.V());
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (Edge e : G.adj(v)){
                if (isSite(e.either(), s) || isSite(e.other(v), s)) continue;
                relax(e, v);
            }
        }
    }

    // relax edge e and update pq if changed
    private void relax(Edge e, int v) {
        int w = e.other(v);
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else                pq.insert(w, distTo[w]);
        }
    }

    public double distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<Edge> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<Edge> path = new Stack<Edge>();
        int x = v;
        for (Edge e = edgeTo[v]; e != null; e = edgeTo[x]) {
            path.push(e);
            x = e.other(x);
        }
        return path;
    }

    private void validateVertex(int v) {
        int V = distTo.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    private boolean isSite(int v, int s) {
        for (int site: sites) {
            if (site == v && site != s) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        CableCompany[] networks = new CableCompany[sites.length];
        for (int i=0; i<sites.length; i++) {
            networks[i] = new CableCompany(G,sites[i]);
        }

        int[] bestSite = new int[G.V()];
        double[] shortestDist = new double[G.V()];
        Arrays.fill(shortestDist, Double.POSITIVE_INFINITY);
        for (int t = 0; t < G.V(); t++) {
            for (int i = 0; i<sites.length; i++) {
                if (networks[i].hasPathTo(t)) {
                    if (networks[i].distTo[t] < shortestDist[t]) {
                        bestSite[t] = i;
                        shortestDist[t] = networks[i].distTo[t];
                    }
                }
            }
        }
        for (int i = 0; i<bestSite.length; i++) {
            StdOut.print("Vertex: " + i + ", Site: " + sites[bestSite[i]] + ", Response Time: " + shortestDist[i] + ", Path: ");
            for (Edge e : networks[bestSite[i]].pathTo(i)) {
                StdOut.print(e + "   ");
            }
            StdOut.println();
        }
        double totalDist = 0;
        for (int i = 0; i<shortestDist.length; i++){
            totalDist += shortestDist[i];
        }
        StdOut.println("Total Response Time for overall shortest path, 5 sites: " + totalDist);
        for (int i = 0; i<sites.length; i++) {
            double totalDistance = 0;
            for (int j = 0; j < G.V(); j++){
                if (networks[i].hasPathTo(j)) totalDistance += networks[i].distTo[j];
            }
            StdOut.println("Total Response Time for only Site " + sites[i] + ": " + totalDistance);
        }
    }
}

/*TEST CASE OUTPUT
Vertex: 0, Site: 7, Response Time: 52.0, Path: 5-7 15.00000   5-6 20.00000   0-6 17.00000
Vertex: 1, Site: 7, Response Time: 28.0, Path: 5-7 15.00000   1-5 13.00000
Vertex: 2, Site: 14, Response Time: 30.0, Path: 3-14 15.00000   2-3 15.00000
Vertex: 3, Site: 14, Response Time: 15.0, Path: 3-14 15.00000
Vertex: 4, Site: 7, Response Time: 31.0, Path: 4-7 31.00000
Vertex: 5, Site: 7, Response Time: 15.0, Path: 5-7 15.00000
Vertex: 6, Site: 7, Response Time: 35.0, Path: 5-7 15.00000   5-6 20.00000
Vertex: 7, Site: 7, Response Time: 0.0, Path:
Vertex: 8, Site: 14, Response Time: 30.0, Path: 3-14 15.00000   3-8 15.00000
Vertex: 9, Site: 14, Response Time: 46.0, Path: 3-14 15.00000   3-9 31.00000
Vertex: 10, Site: 14, Response Time: 44.0, Path: 12-14 22.00000   10-12 22.00000
Vertex: 11, Site: 40, Response Time: 41.0, Path: 40-45 20.00000   11-45 21.00000
Vertex: 12, Site: 14, Response Time: 22.0, Path: 12-14 22.00000
Vertex: 13, Site: 14, Response Time: 64.0, Path: 14-15 36.00000   13-15 28.00000
Vertex: 14, Site: 14, Response Time: 0.0, Path:
Vertex: 15, Site: 14, Response Time: 36.0, Path: 14-15 36.00000
Vertex: 16, Site: 7, Response Time: 25.0, Path: 7-16 25.00000
Vertex: 17, Site: 7, Response Time: 20.0, Path: 7-17 20.00000
Vertex: 18, Site: 14, Response Time: 36.0, Path: 14-21 16.00000   18-21 20.00000
Vertex: 19, Site: 14, Response Time: 23.0, Path: 14-19 23.00000
Vertex: 20, Site: 14, Response Time: 35.0, Path: 14-20 35.00000
Vertex: 21, Site: 14, Response Time: 16.0, Path: 14-21 16.00000
Vertex: 22, Site: 28, Response Time: 30.0, Path: 22-28 30.00000
Vertex: 23, Site: 28, Response Time: 18.0, Path: 23-28 18.00000
Vertex: 24, Site: 25, Response Time: 25.0, Path: 24-25 25.00000
Vertex: 25, Site: 25, Response Time: 0.0, Path:
Vertex: 26, Site: 25, Response Time: 30.0, Path: 25-26 30.00000
Vertex: 27, Site: 28, Response Time: 43.0, Path: 27-28 43.00000
Vertex: 28, Site: 28, Response Time: 0.0, Path:
Vertex: 29, Site: 25, Response Time: 40.0, Path: 24-25 25.00000   24-29 15.00000
Vertex: 30, Site: 25, Response Time: 30.0, Path: 25-30 30.00000
Vertex: 31, Site: 25, Response Time: 21.0, Path: 25-31 21.00000
Vertex: 32, Site: 7, Response Time: 30.0, Path: 7-32 30.00000
Vertex: 33, Site: 40, Response Time: 58.0, Path: 40-46 28.00000   33-46 30.00000
Vertex: 34, Site: 28, Response Time: 30.0, Path: 28-34 30.00000
Vertex: 35, Site: 28, Response Time: 25.0, Path: 28-35 25.00000
Vertex: 36, Site: 40, Response Time: 30.0, Path: 36-40 30.00000
Vertex: 37, Site: 25, Response Time: 50.0, Path: 25-37 50.00000
Vertex: 38, Site: 25, Response Time: 61.0, Path: 25-31 21.00000   31-38 40.00000
Vertex: 39, Site: 40, Response Time: 40.0, Path: 39-40 40.00000
Vertex: 40, Site: 40, Response Time: 0.0, Path:
Vertex: 41, Site: 40, Response Time: 27.0, Path: 40-41 27.00000
Vertex: 42, Site: 28, Response Time: 50.0, Path: 28-34 30.00000   34-42 20.00000
Vertex: 43, Site: 40, Response Time: 41.0, Path: 40-41 27.00000   41-43 14.00000
Vertex: 44, Site: 28, Response Time: 74.0, Path: 28-34 30.00000   34-42 20.00000   42-44 24.00000
Vertex: 45, Site: 40, Response Time: 20.0, Path: 40-45 20.00000
Vertex: 46, Site: 40, Response Time: 28.0, Path: 40-46 28.00000
Vertex: 47, Site: 40, Response Time: 56.0, Path: 40-41 27.00000   41-43 14.00000   43-47 15.00000
Vertex: 48, Site: 40, Response Time: 43.0, Path: 40-46 28.00000   46-48 15.00000
Vertex: 49, Site: 40, Response Time: 63.0, Path: 40-46 28.00000   46-49 35.00000
Total Response Time for overall shortest path, 5 sites: 1607.0
Total Response Time for only Site 7: 4269.0
Total Response Time for only Site 14: 4033.0
Total Response Time for only Site 25: 4013.0
Total Response Time for only Site 28: 3925.0
Total Response Time for only Site 40: 4636.0
*/
