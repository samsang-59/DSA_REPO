<h2><a href="https://leetcode.com/problems/longest-repeating-character-replacement">424. Longest Repeating Character Replacement</a></h2><h3>Medium</h3><hr><p>You are given a string <code>s</code> and an integer <code>k</code>. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most <code>k</code> times.</p>

<p>Return <em>the length of the longest substring containing the same letter you can get after performing the above operations</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;ABAB&quot;, k = 2
<strong>Output:</strong> 4
<strong>Explanation:</strong> Replace the two &#39;A&#39;s with two &#39;B&#39;s or vice versa.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;AABABBA&quot;, k = 1
<strong>Output:</strong> 4
<strong>Explanation:</strong> Replace the one &#39;A&#39; in the middle with &#39;B&#39; and form &quot;AABBBBA&quot;.
The substring &quot;BBBB&quot; has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists of only uppercase English letters.</li>
	<li><code>0 &lt;= k &lt;= s.length</code></li>
</ul>

---

## Solution Notes — `0424-longest-repeating-character-replacement.java`

**Problem:** Longest Repeating Character Replacement
**Language:** Java

### Pattern / Technique
Sliding Window (variable size) + Frequency Array

### Approach
`counts[26]` tracks character frequency inside the window `[start, end]`; `maxFreq` tracks the count of the most frequent character seen in the window so far. The window is valid as long as `(windowLength - maxFreq) <= k` (i.e. the number of characters that need replacing fits the budget `k`); otherwise shrink from `start`.

### Complexity
- **Time:** O(n) - `maxFreq` is never decreased, but this is still correct because it only ever needs to grow the answer
- **Space:** O(1) - fixed 26-size frequency array

### Notes
`maxFreq` deliberately isn't recomputed on shrink; the window can only get as large as the best window found so far, which is enough to compute the correct max length.
