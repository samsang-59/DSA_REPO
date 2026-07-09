<h2><a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array">34. Find First and Last Position of Element in Sorted Array</a></h2><h3>Medium</h3><hr><p>Given an array of integers <code>nums</code> sorted in non-decreasing order, find the starting and ending position of a given <code>target</code> value.</p>

<p>If <code>target</code> is not found in the array, return <code>[-1, -1]</code>.</p>

<p>You must&nbsp;write an algorithm with&nbsp;<code>O(log n)</code> runtime complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 8
<strong>Output:</strong> [3,4]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 6
<strong>Output:</strong> [-1,-1]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> nums = [], target = 0
<strong>Output:</strong> [-1,-1]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup>&nbsp;&lt;= nums[i]&nbsp;&lt;= 10<sup>9</sup></code></li>
	<li><code>nums</code> is a non-decreasing array.</li>
	<li><code>-10<sup>9</sup>&nbsp;&lt;= target&nbsp;&lt;= 10<sup>9</sup></code></li>
</ul>

---

## Solution Notes — `0034-find-first-and-last-position-of-element-in-sorted-array.java`

**Problem:** Find First and Last Position of Element in Sorted Array
**Language:** Java

### Pattern / Technique
Binary Search - Lower Bound & Upper Bound

### Approach
Two independent binary searches. `find_first_pos` records a match in `res` and keeps searching left (`high = mid - 1`) to find the left-most occurrence. `find_last_pos` records a match and keeps searching right (`low = mid + 1`) to find the right-most occurrence.

### Complexity
- **Time:** O(log n) - two binary searches run one after another
- **Space:** O(1)

### Notes
Running two bounded binary searches is the standard way to get a range in a sorted array with duplicates.
