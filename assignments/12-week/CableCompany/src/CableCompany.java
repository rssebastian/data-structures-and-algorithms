import edu.princeton.cs.algs4.*;

public class CableCompany {
    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G;
        G = new EdgeWeightedGraph(in);

        PrimMST pmst = new PrimMST(G);
        StdOut.println("Running with 40 as field station");
        for (Edge e : pmst.edges()){
            StdOut.println(e);
        }
        StdOut.println(pmst.weight());
    }
}

/*TEST CASE OUTPUT
Running with all field stations
1-6 18.00000
2-3 15.00000
3-14 15.00000
4-5 20.00000
1-5 13.00000
0-6 17.00000
5-7 15.00000
3-8 15.00000
2-9 20.00000
10-12 22.00000
11-45 21.00000
12-14 22.00000
10-13 28.00000
14-21 16.00000
13-15 28.00000
7-16 25.00000
7-17 20.00000
18-32 15.00000
14-19 23.00000
15-20 25.00000
18-21 20.00000
17-22 28.00000
17-23 25.00000
24-29 15.00000
24-25 25.00000
26-31 20.00000
27-34 25.00000
23-28 18.00000
18-29 15.00000
25-30 30.00000
25-31 21.00000
17-32 15.00000
33-39 25.00000
34-41 25.00000
28-35 25.00000
36-39 25.00000
37-38 25.00000
33-38 25.00000
39-46 20.00000
40-45 20.00000
35-41 30.00000
34-42 20.00000
41-43 14.00000
42-44 24.00000
41-45 23.00000
40-46 28.00000
43-47 15.00000
46-48 15.00000
33-49 20.00000
1029.0*/

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
