<h2><a href="https://leetcode.com/problems/odd-even-linked-list">328. Odd Even Linked List</a></h2><h3>Medium</h3><hr><p>Given the <code>head</code> of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return <em>the reordered list</em>.</p>

<p>The <strong>first</strong> node is considered <strong>odd</strong>, and the <strong>second</strong> node is <strong>even</strong>, and so on.</p>

<p>Note that the relative order inside both the even and odd groups should remain as it was in the input.</p>

<p>You must solve the problem&nbsp;in <code>O(1)</code>&nbsp;extra space complexity and <code>O(n)</code> time complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/10/oddeven-linked-list.jpg" style="width: 300px; height: 123px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5]
<strong>Output:</strong> [1,3,5,2,4]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/10/oddeven2-linked-list.jpg" style="width: 500px; height: 142px;" />
<pre>
<strong>Input:</strong> head = [2,1,3,5,6,4,7]
<strong>Output:</strong> [2,3,6,7,1,5,4]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the linked list is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>-10<sup>6</sup> &lt;= Node.val &lt;= 10<sup>6</sup></code></li>
</ul>

---

## Solution Notes — `0328-odd-even-linked-list.java`

**Problem:** Odd Even Linked List
**Language:** Java

### Pattern / Technique
Two Pointers (In-Place Interleaved List Splitting & Relinking)

### Approach
Two pointers walk the list one node apart: `even` starts at `head` (the odd-indexed chain: 1st, 3rd, 5th, ...) and `odd` starts at `head.next` (the even-indexed chain: 2nd, 4th, 6th, ...), with `evenHead`/`oddHead` saved as the two chains' starting points. On each iteration, `even.next` is rewired to skip over to the next odd-position node (`odd.next`) and `even` advances; symmetrically `odd.next` is rewired to the next even-position node and `odd` advances. This continues while both chains still have a following node. After the loop, `even.next = oddHead` splices the even-indexed chain onto the end of the odd-indexed chain, and `evenHead` (despite the variable name, this is the odd-indexed chain's head) is returned.

### Complexity
- **Time:** O(n) — single pass through the list
- **Space:** O(1) — nodes are relinked in place, no new nodes allocated

### Notes
Variable naming is a bit misleading: `even`/`evenHead` actually track the *odd-indexed* (1st, 3rd, ...) chain and `odd`/`oddHead` track the *even-indexed* (2nd, 4th, ...) chain, per the problem's 1-indexed "first node is odd" convention. The loop condition checks `.next != null` on both pointers to safely stop before dereferencing past the list end on either odd or even total-length lists.
