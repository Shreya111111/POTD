/*Given a Binary Search Tree of size N, find the Median of its Node values.

Example 1:

Input:
       6
     /   \
   3      8   
 /  \    /  \
1    4  7    9
Output: 6
Explanation: Inorder of Given BST will be:
1, 3, 4, 6, 7, 8, 9. So, here median will 6.

Example 2:

Input:
       6
     /   \
   3      8   
 /   \    /   
1    4   7   
Output: 5
Explanation:Inorder of Given BST will be:
1, 3, 4, 6, 7, 8. So, here median will
(4 + 6)/2 = 10/2 = 5.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function findMedian() which takes the root of the Binary Search Tree as input and returns the Median of Node values in the given BST.
Median of the BST is:

If number of nodes are even: then median = (N/2 th node + (N/2)+1 th node)/2
If number of nodes are odd : then median = (N+1)/2th node.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).


Constraints:
1<=N<=10000 */
class Tree {
    public static void inorder(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public static float findMedian(Node root) {
        ArrayList<Integer> list = new ArrayList<>();

        inorder(root, list);
        // determine t
        int n = list.size();

        if (n % 2 == 0) {// In java index starts with 0 n/2-1 instead of n/2
                         // and n/2 instead of n/2+1;
            int sum = list.get(n / 2 - 1) + list.get(n / 2);
            // return sum;
            // converting into float if modulo is not zero
            return sum % 2 == 0 ? sum / 2 : (float) ((float) sum / 2);
        } else {
            return list.get((n + 1) / 2 - 1);
        }
        // code here.
    }
}