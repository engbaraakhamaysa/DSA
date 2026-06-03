# 1. Two Sum

## Problem

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

---

## Example 1

### Input

```text
nums = [2,7,11,15]
target = 9
```

### Output

```text
[0,1]
```

### Explanation

```text
nums[0] + nums[1] = 2 + 7 = 9
```

---

## Example 2

### Input

```text
nums = [3,2,4]
target = 6
```

### Output

```text
[1,2]
```

---

## Example 3

### Input

```text
nums = [3,3]
target = 6
```

### Output

```text
[0,1]
```

---

## Constraints

```text
2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
Only one valid answer exists.
```

---

## Follow-up

Can you come up with an algorithm that is less than O(n²) time complexity?
