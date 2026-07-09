<h2><a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list">19. Remove Nth Node From End of List</a></h2><h3>Medium</h3><hr><p>Given the <code>head</code> of a linked list, remove the <code>n<sup>th</sup></code> node from the end of the list and return its head.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 542px; height: 222px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5], n = 2
<strong>Output:</strong> [1,2,3,5]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> head = [1], n = 1
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> head = [1,2], n = 1
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is <code>sz</code>.</li>
	<li><code>1 &lt;= sz &lt;= 30</code></li>
	<li><code>0 &lt;= Node.val &lt;= 100</code></li>
	<li><code>1 &lt;= n &lt;= sz</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you do this in one pass?</p>

---

## Solution Notes — `0019-remove-nth-node-from-end-of-list.java`

**Problem:** Remove Nth Node From End of List
**Language:** Java

### Pattern / Technique
Two Pointers (Fixed Gap) + Dummy Node

### Approach
A `dummy` node is inserted before `head` so the edge case of removing the head itself doesn't need special-casing. `fast` and `slow` both start at `dummy`. First, `fast` is advanced `n` steps ahead alone, opening up a gap of `n` nodes between `fast` and `slow`. Then both pointers advance together until `fast.next == null` (i.e. `fast` reaches the last node) — at that point `slow` is sitting exactly one node before the target, since the gap between them stayed fixed at `n`. Finally `slow.next = slow.next.next` unlinks the target node, and `dummy.next` is returned as the new head.

### Complexity
- **Time:** O(n) — single pass to open the gap plus one pass to walk it to the end, i.e. one overall traversal (satisfies the one-pass follow-up)
- **Space:** O(1) — only the dummy node and two pointers are used

### Notes
The `dummy` node is what lets `slow.next = slow.next.next` safely remove the head node too, without a separate `if (n == length)` branch.
