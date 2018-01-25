/**
 * #1. This program determines if there is a connection between two given vertices of a graph.
 * #2. The key to overcoming the size problem would be to use adjacency lists to represent graph connectivity.
 * You could then remove all members of the adjacency list from the list of all vertices in the graph, and return that as the list of vertices which are disconnected from the given vertex.
 * #3. Time complexity is O(|V| + |E|)
 * @author Brianne Coffey
 * @version 10/22/17
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.LinkedList;

class Graph {
    private int V;  //Number of vertices
    private LinkedList<Integer> adj[]; //Adjacency List

    /**
     * Constructor creating the Graph
     * @param v number of vertices
     */
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }


    /**
     * This method adds an edge to the graph
     * @param v first vertex
     * @param w second vertex
     */
    void addEdge(int v, int w) {
        adj[v].add(w);
    }


    /**
     * This method determines if two vertices are connected by traversing the list
     * @param s the first vertex
     * @param d the second vertex
     * @return a boolean T/F whether or not they're connected
     */

    public Boolean connectivity(int s, int d) {

        // First mark all the vertices as not visited
        boolean visited[] = new boolean[V];

        // Create a queue to hold visited vertices
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the first vertex as visited and add it to the queue
        visited[s] = true;
        queue.add(s);

        //Iterate over the adjacency list of the given vertex, looking to see if the adjacent vertex is the destination vertex
        //if its not, mark the vertex as visited, add it to the queue
        //continue through its adjacency list to see if the destination vertex is present
        //if not, look at next vertex in the queue and repeat the search through its adjacency list

        Iterator<Integer> i;
        while (queue.size() != 0) {

            s = queue.poll();

            int n;
            i = adj[s].listIterator();


            while (i.hasNext()) {
                n = i.next();

                if (n == d)
                    return true;


                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        return false;
    }

    public static void main(String args[]) {

        FileReader fr = null;
        Graph g = new Graph(10000000);
        Scanner sc = null;

        try {

            sc = new Scanner(new FileReader("graph.txt"));

            String sCurrentLine;
            int[] connections = new int[0];
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] split = line.split(",");
                connections = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    connections[i] = Integer.parseInt(split[i].trim());
                }
                g.addEdge(connections[0], connections[1]);
            }




        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (sc != null)
                    sc.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }

        System.out.println((g.connectivity(809054,67104)).toString());
        System.out.println((g.connectivity(825289, 891950)).toString());
        System.out.println((g.connectivity(733252, 891950)).toString());
        System.out.println((g.connectivity(250429,2)).toString());

    }
}