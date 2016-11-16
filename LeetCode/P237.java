/*
* @Author: GZhY
* @Date:   2016-11-16 23:26:40
* @Last Modified by:   GZhY
* @Last Modified time: 2016-11-16 23:28:27
*/
// Runtime:1ms
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}