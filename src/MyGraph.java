import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MyGraph {

    public List<List<Integer>> adjacencyList;
    int vertices;
    int nodesInComponent;

    MyGraph(int v) {
        this.vertices = v;
        adjacencyList = new ArrayList<>();
        nodesInComponent = 0;
        for (int i = 0; i <= this.vertices; i++) {
            List<Integer> temp = new ArrayList<>();
            adjacencyList.add(temp);
        }
    }

    void addConnection(int node1, int node2) {
        this.adjacencyList.get(node1).add(node2);
        this.adjacencyList.get(node2).add(node1);
    }

    void connectionsFromCurrentNode(int node, List<Boolean> visited) {
        visited.set(node, true);
        nodesInComponent++;

        if (!adjacencyList.get(node).isEmpty()) {
            List<Integer> curList = adjacencyList.get(node);
            for (Integer neighbor : curList) {
                if (!visited.get(neighbor)) {
                    connectionsFromCurrentNode(neighbor, visited);
                }
            }
        }
    }

    List<Integer> componentsInGraph() {
        List<Integer> componentCountList = new ArrayList<>();
        List<Boolean> visited = new ArrayList<>(Collections.nCopies(vertices + 1, false));

        for (int i = 1; i <= vertices; i++) {
            if (!visited.get(i)) {
                nodesInComponent = 0;
                connectionsFromCurrentNode(i, visited);
                if (nodesInComponent > 1) {
                    componentCountList.add(nodesInComponent);
                }
            }
        }

        Collections.sort(componentCountList, Collections.reverseOrder());

        List<Integer> finalOp = new ArrayList<>();

        finalOp.add(componentCountList.stream().min(Integer::compare).get());
        finalOp.add(componentCountList.stream().max(Integer::compare).get());

        return finalOp;
    }

    public static void main(String args[]) {
        List<List<Integer>> connections = new ArrayList<>();


        connections.add(Arrays.asList(1, 17));
        connections.add(Arrays.asList(5, 13));
        connections.add(Arrays.asList(7, 12));
        connections.add(Arrays.asList(5, 17));
        connections.add(Arrays.asList(5, 12));
        connections.add(Arrays.asList(2, 17));
        connections.add(Arrays.asList(1, 18));
        connections.add(Arrays.asList(8,13));
        connections.add(Arrays.asList(2, 15));
        connections.add(Arrays.asList(5, 20));

        MyGraph myGraph = new MyGraph(connections.size()*2); // Set the vertices based on the highest node value

        for (List<Integer> connection : connections) {
            myGraph.addConnection(connection.get(0), connection.get(1));
        }

        List<Integer> comps = myGraph.componentsInGraph();
        System.out.println("Top two components: " + comps);
    }
}
