
import java.util.*;

public class DijkstrasAlgo
{
    static final int V = 5;
    static final int M = Integer.MAX_VALUE;
    static String[] names = {"P", "Q", "R", "S", "T"};

    int minDist(int[] distance, boolean[] used)
    {
        int min = M, idx = -1;
        for (int i = 0; i < V; i++)
        {
            if (!used[i] && distance[i] <= min)
            {
                min = distance[i];
                idx = i;
            }
        }
        return idx;
    }

    void dijkstra(int[][] graph, int startnode)
    {
        int[] distance = new int[V];
        boolean[] used = new boolean[V];
        String[] path = new String[V];

        Arrays.fill(distance, M);
        Arrays.fill(used, false);
        for (int i = 0; i < V; i++)
        {
            path[i] = names[startnode];
        }

        distance[startnode] = 0;

        for (int step = 0; step < V - 1; step++)
        {
            int u = minDist(distance, used);
            used[u] = true;

            System.out.println("Step " + (step + 1) + ":");
            System.out.println("Visited: " + Arrays.toString(used));
            System.out.println("Distance: " + Arrays.toString(distance));

            for (int v = 0; v < V; v++)
            {
                if (!used[v] && graph[u][v] != 0 && distance[u] != M &&
                    distance[u] + graph[u][v] < distance[v])
                {
                    distance[v] = distance[u] + graph[u][v];
                    path[v] = path[u] + " -> " + names[v];
                }
            }

            System.out.println("Updated Distance: " + Arrays.toString(distance));
            System.out.println("Updated Path: " + Arrays.toString(path) + "\n");
        }

        System.out.println("\nVertex\tDistance\tPath");
        for (int i = 0; i < V; i++)
        {
            if (i != startnode)
            {
                System.out.println(names[startnode] + " -> " + names[i] + "\t" +
                        distance[i] + "\t\t" + path[i]);
            }
        }
    }

    public static void main(String[] args)
    {
        int[][] graph = {
            {0, 4, 0, 5, 0},
            {4, 0, 6, 7, 3},
            {0, 6, 0, 0, 8},
            {5, 7, 0, 0, 10},
            {0, 3, 8, 10, 0}
        };
        DijkstrasAlgo obj = new DijkstrasAlgo();
        obj.dijkstra(graph, 0);
    }
}




