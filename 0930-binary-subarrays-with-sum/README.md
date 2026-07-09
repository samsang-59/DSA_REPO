<h2><a href="https://leetcode.com/problems/binary-subarrays-with-sum">930. Binary Subarrays With Sum</a></h2><h3>Medium</h3><hr><p>Given a binary array <code>nums</code> and an integer <code>goal</code>, return <em>the number of non-empty <strong>subarrays</strong> with a sum</em> <code>goal</code>.</p>

<p>A <strong>subarray</strong> is a contiguous part of the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,0,1,0,1], goal = 2
<strong>Output:</strong> 4
<strong>Explanation:</strong> The 4 subarrays are bolded and underlined below:
[<u><strong>1,0,1</strong></u>,0,1]
[<u><strong>1,0,1,0</strong></u>,1]
[1,<u><strong>0,1,0,1</strong></u>]
[1,0,<u><strong>1,0,1</strong></u>]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,0,0,0,0], goal = 0
<strong>Output:</strong> 15
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>nums[i]</code> is either <code>0</code> or <code>1</code>.</li>
	<li><code>0 &lt;= goal &lt;= nums.length</code></li>
</ul>

---

## Solution Notes — `0930-binary-subarrays-with-sum.java`

**Problem:** Binary Subarrays With Sum
**Language:** Java

### Pattern / Technique
Sliding Window - "AtMost(K) - AtMost(K-1)" Trick

### Approach
`AtMost(target)` counts subarrays whose sum is `<= target` using a shrinking window (shrink while `sum > target`, then add `end - start + 1` valid subarrays ending at `end`). The exact-sum answer is `AtMost(goal) - AtMost(goal - 1)`.

### Complexity
- **Time:** O(n) - `AtMost` is called twice, each a linear-time sliding window
- **Space:** O(1)

### Notes
This subtraction trick converts an "exactly K" sliding-window problem (which has no clean single-window formulation) into two solvable "at most K" problems.
