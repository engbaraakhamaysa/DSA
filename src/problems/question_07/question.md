# 347. Top K Frequent Elements

## Problem

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements.

You may return the answer in any order.

---

## Example 1

### Input

```text id="347e1"
nums = [1,1,1,2,2,3], k = 2
```

### Output

```text id="347o1"
[1,2]
```

---

## Example 2

### Input

```text id="347e2"
nums = [1], k = 1
```

### Output

```text id="347o2"
[1]
```

---

## Example 3

### Input

```text id="347e3"
nums = [1,2,1,2,1,2,3,1,3,2], k = 2
```

### Output

```text id="347o3"
[1,2]
```

---

## Constraints

```text id="347c1"
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
k is in range [1, number of unique elements]
Answer is guaranteed to be unique
```

---

## Follow-up

Your algorithm must be better than:

```text id="347f1"
O(n log n)
```
