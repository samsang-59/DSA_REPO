<h2><a href="https://leetcode.com/problems/palindrome-linked-list">234. Palindrome Linked List</a></h2><h3>Easy</h3><hr><p>Given the <code>head</code> of a singly linked list, return <code>true</code><em> if it is a </em><span data-keyword="palindrome-sequence"><em>palindrome</em></span><em> or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg" style="width: 422px; height: 62px;" />
<pre>
<strong>Input:</strong> head = [1,2,2,1]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg" style="width: 182px; height: 62px;" />
<pre>
<strong>Input:</strong> head = [1,2]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you do it in <code>O(n)</code> time and <code>O(1)</code> space?

---

## Solution Notes — `0234-palindrome-linked-list.java`

**Problem:** Palindrome Linked List
**Language:** Java

### Pattern / Technique
Fast & Slow Pointers + In-Place Linked List Reversal (combined)

### Approach
First use `fast`/`slow` pointers (same technique as problem 876) to find the middle of the list — `fast` moves two nodes per step, `slow` moves one, so when `fast` runs off the end, `slow` sits at the second half's start. Then reverse the second half in place from `slow` onward (same three-pointer `prev`/`curr`/`Next` technique as problem 206), producing `newHead`. Finally walk two pointers — `p1` from the original `head` and `p2` from `newHead` — comparing values in lockstep; any mismatch means it isn't a palindrome.

### Complexity
- **Time:** O(n) — one pass to find the middle, one pass to reverse, one pass to compare
- **Space:** O(1) — reversal and comparison are done in place, no extra list/array copy

### Notes
Meets the follow-up requirement of O(n) time / O(1) space by avoiding a copy into an array or stack. It reuses the exact same fast/slow and reversal building blocks already seen in problems 876 and 206.