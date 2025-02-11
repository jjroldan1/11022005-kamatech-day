# NOTE: This is an bonus exercise

## Problem 3: Merge Intervals

You are given a list of intervals, where each interval is represented as a pair of integers [start, end].
Your task is to merge all overlapping intervals and return a list of non-overlapping intervals that cover
all the intervals in the input.

Example 1:
```
Input: intervals = [[1, 3], [2, 6], [8, 10], [15, 18]]
Output: [[1, 6], [8, 10], [15, 18]]
```
Explanation:
```
The intervals [1, 3] and [2, 6] overlap, so they are merged into [1, 6].
The intervals [8, 10] and [15, 18] do not overlap with any other interval, so they remain unchanged.
```

Example 2:
```
Input: intervals = [[1, 4], [4, 5]]
Output: [[1, 5]]
```
Explanation:
```
The intervals [1, 4] and [4, 5] overlap at the boundary, so they are merged into [1, 5].
```

### Problem Requirements

Input: A list of intervals, where each interval is represented as [start, end].

Output: A list of merged intervals in the same format.

### Additional clarifications on the problem

The input intervals are not necessarily sorted.
