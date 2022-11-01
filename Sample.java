Problem 4-Queue using 2 Stacks(155)

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyQueue {
    Stack<Integer> first;
    Stack<Integer> second;

    public MyQueue() {
        first=new Stack<>();
        second=new Stack<>();
        
    }
    
    public void push(int x) {
        first.push(x);
        
    }
    
    public int pop() {
        peek();
        return second.pop();
        
        
    }
    
    public int peek() {
        if(!second.isEmpty())
        {
            return second.peek();
        }
        else
        {
            while(!first.isEmpty())
            {
                second.push(first.pop());
            }
            return second.peek();
        }
        
    }
    
    public boolean empty() {
        if(first.isEmpty() && second.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */









Problem 5-Design a hashset(232)

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        
        public Node(int key, int val)
        {
            this.key=key;
            this.val=val;
        }
    }
    Node [] nodes;

    public MyHashMap() {
        nodes=new Node[10000];
        
    }
    
    public int idx(int key)
    {
        return key%10000;
    }
    
    private Node find(Node head, int key)
    {
        Node prev=null;
        Node curr=head;
        
        while(curr!=null && curr.key!=key)
        {
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int idx=idx(key);
        if(nodes[idx]==null)
        {
            nodes[idx]= new Node(-1,-1);
        }
        //If already exists in out list;
        Node prev=find(nodes[idx], key);
        if(prev.next==null)
        {
            prev.next = new Node(key, value);
        }
        else
        {
            prev.next.val=value;
        }
        
    }
    
    public int get(int key) {
        
        int idx=idx(key);
        if(nodes[idx]==null) return -1;
        
        Node prev= find(nodes[idx], key);
        if(prev.next==null)
        {
            return -1;
        }
            return prev.next.val;
        
        
        
    }
    
    public void remove(int key) {
         int idx=idx(key);
        if(nodes[idx]==null) return;
         Node prev= find(nodes[idx], key);
        if(prev.next==null) return;
        prev.next=prev.next.next;
        
    }
        
        
    }    
