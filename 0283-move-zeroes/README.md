<h2><a href="https://leetcode.com/problems/move-zeroes">283. Move Zeroes</a></h2><h3>Easy</h3><hr><p>Given an integer array <code>nums</code>, move all <code>0</code>&#39;s to the end of it while maintaining the relative order of the non-zero elements.</p>

<p><strong>Note</strong> that you must do this in-place without making a copy of the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [0,1,0,3,12]
<strong>Output:</strong> [1,3,12,0,0]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [0]
<strong>Output:</strong> [0]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you minimize the total number of operations done?

---

## Solution Notes — `0283-move-zeroes.java`

**Problem:** Move Zeroes
**Language:** Java

### Pattern / Technique
Two Pointers (Read-Write / In-Place Compaction)

### Approach
`write` tracks the position where the next non-zero element belongs; `read` scans forward. When `nums[read]` is non-zero, it's swapped into `nums[write]` and `write` advances. Zeros are naturally pushed toward the end.

### Complexity
- **Time:** O(n)
- **Space:** O(1)

### Notes
Preserves relative order of non-zero elements while zeroing everything in-place, in one pass.
