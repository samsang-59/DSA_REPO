<h2><a href="https://leetcode.com/problems/sort-colors">75. Sort Colors</a></h2><h3>Medium</h3><hr><p>Given an array <code>nums</code> with <code>n</code> objects colored red, white, or blue, sort them <strong><a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a> </strong>so that objects of the same color are adjacent, with the colors in the order red, white, and blue.</p>

<p>We will use the integers <code>0</code>, <code>1</code>, and <code>2</code> to represent the color red, white, and blue, respectively.</p>

<p>You must solve this problem without using the library&#39;s sort function.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,0,2,1,1,0]
<strong>Output:</strong> [0,0,1,1,2,2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,0,1]
<strong>Output:</strong> [0,1,2]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 300</code></li>
	<li><code>nums[i]</code> is either <code>0</code>, <code>1</code>, or <code>2</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong>&nbsp;Could you come up with a one-pass algorithm using only&nbsp;constant extra space?</p>

---

## Solution Notes — `0075-sort-colors.java`

**Problem:** Sort Colors
**Language:** Java

### Pattern / Technique
Dutch National Flag Algorithm (3-Way Partitioning)

### Approach
Three pointers `low`, `mid`, `high` partition the array into 0s, 1s, and 2s in a single pass. `nums[mid] == 0` swaps with `low` and advances both `low`/`mid`; `nums[mid] == 1` just advances `mid`; `nums[mid] == 2` swaps with `high` and shrinks `high` (without advancing `mid`, since the swapped-in value is unchecked).

### Complexity
- **Time:** O(n) - single pass
- **Space:** O(1) - in-place swaps

### Notes
Solves the problem in one pass without a counting sort / extra array.
