// Copy List with random pointer - Leetcode 138

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Map<Node,Node> map = new HashMap<>();
        Node ptr2 = new Node(head.val);
        map.put(head,ptr2);
        Node ptr = head;
        while(ptr!=null){
            Node randomNode = ptr.random;
            Node nextNode = ptr.next;
            if(randomNode!=null){
                if(!map.containsKey(randomNode)){
                    map.put(randomNode, new Node(randomNode.val));
                }
                ptr2.random = map.get(randomNode);
            }
            if(nextNode!=null){
                if(!map.containsKey(nextNode)){
                    map.put(nextNode, new Node(nextNode.val));
                }
                ptr2.next = map.get(nextNode);
            }
            ptr = ptr.next;
            ptr2 = ptr2.next;
        }
        return map.get(head);
    }
}