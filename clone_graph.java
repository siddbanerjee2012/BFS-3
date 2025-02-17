// Time Complexity : O(V+E)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    HashMap<Node,Node> map; 
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        map = new HashMap<>();

        Queue<Node> q= new LinkedList<>();
        Node copyNode = clone(node);
        q.add(node);

        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node neighbor : curr.neighbors){
                if(!map.containsKey(neighbor)){
                    clone(neighbor);
                    q.add(neighbor);
                }

                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        return copyNode;
    }

    private Node clone(Node node){
        if(map.containsKey(node)) return map.get(node);

        Node newNode = new Node(node.val);
        map.put(node,newNode);
        return newNode;
    }
}