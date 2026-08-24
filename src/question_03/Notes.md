# 219. Contains Duplicate II

## Problem

Given an integer array `nums` and an integer `k`, return `true` if there are two distinct indices `i` and `j` such that:

- `nums[i] == nums[j]`
- `|i - j| <= k`

### Example

```text
Input:  nums = [1,2,3,1], k = 3
Output: true

Explanation:
The value 1 appears at indices 0 and 3.
|0 - 3| = 3 <= k
```

---

# Possible Solutions

| Solution                      | Time  | Space |
| ----------------------------- | ----- | ----- |
| Brute Force (Check All Pairs) | O(n²) | O(1)  |
| Sliding Window + Hash Set     | O(n)  | O(k)  |
| Hash Map (Index Tracking)     | O(n)  | O(n)  |

---

# Solution Used

## Data Structure

### Array

Used to store the input numbers.

Operations:

| Operation | Complexity |
| --------- | ---------- |
| Access    | O(1)       |
| Search    | O(n)       |
| Insert    | O(n)       |
| Delete    | O(n)       |

### Hash Map

Stores:

```text
value → latest index
```

Operations:

| Operation | Complexity |
| --------- | ---------- |
| Insert    | O(1)       |
| Lookup    | O(1)       |
| Update    | O(1)       |

### Why Hash Map?

- We need to remember where each value was last seen.
- Allows instant access to the previous index.
- Avoids checking all pairs.
- Efficiently calculates distance between duplicates.

---

# Pattern

```text
Hash Map
Index Tracking
Sliding Window (Implicit)
```

---

# Algorithm

1. Create an empty Hash Map.
2. Traverse the array once.
3. For each number:
   - Check if it already exists in the map.
   - If it exists:
     - Get its previous index.
     - Calculate the distance.
     - If distance ≤ k, return `true`.
4. Update the map with the current index.
5. If the loop finishes, return `false`.

---

# Complexity Analysis

## Time Complexity

```text
O(n)
```

Reason:

- One traversal of the array.
- Hash Map lookup is O(1).
- Hash Map update is O(1).

---

## Space Complexity

```text
O(n)
```

Reason:

- In the worst case all values are unique.
- The Hash Map stores up to `n` entries.

---

# Key Takeaway

```text
Brute Force             -> O(n²)
Sliding Window + Set    -> O(n)
Hash Map                -> O(n) ✓
```
