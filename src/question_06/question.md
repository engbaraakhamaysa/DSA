# 238. Product of Array Except Self

## Problem

Given an integer array `nums`, return an array `answer` such that:

```text id="238p1"
answer[i] = product of all elements of nums except nums[i]
```

The product of any prefix or suffix of `nums` is guaranteed to fit in a 32-bit integer.

You must write an algorithm that:

- Runs in `O(n)` time.
- Does not use the division operation.

---

## Example 1

### Input

```text id="238e1"
nums = [1,2,3,4]
```

### Output

```text id="238o1"
[24,12,8,6]
```

### Explanation

```text id="238x1"
answer[0] = 2×3×4 = 24
answer[1] = 1×3×4 = 12
answer[2] = 1×2×4 = 8
answer[3] = 1×2×3 = 6
```

---

## Example 2

### Input

```text id="238e2"
nums = [-1,1,0,-3,3]
```

### Output

```text id="238o2"
[0,0,9,0,0]
```

---

## Constraints

```text id="238c1"
2 <= nums.length <= 10^5
-30 <= nums[i] <= 30
The input is generated such that answer[i] fits in a 32-bit integer.
```

---

## Follow Up

Can you solve the problem in:

```text id="238f1"
O(1) extra space
```

(The output array does not count as extra space.)
