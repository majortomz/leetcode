package solution100_199;

import java.util.*;

/**
 * Created by zjw on 2017/9/27.
 */
public class P133_CloneGraph {

     class UndirectedGraphNode {
         int label;
         List<UndirectedGraphNode> neighbors;
         UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
      };

    Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)    return null;
        if(map.containsKey(node.label))     return map.get(node.label);

        UndirectedGraphNode nodeCopy = map.getOrDefault(node.label, new UndirectedGraphNode(node.label));
        map.put(nodeCopy.label, nodeCopy);

        for(UndirectedGraphNode neighbor : node.neighbors) {
            nodeCopy.neighbors.add(cloneGraph(neighbor));
        }
        return nodeCopy;
    }
}
