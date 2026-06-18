# 1. Two Sum

## Problem

Given an array `nums` and a target value, return the indices of the two numbers whose sum equals the target.

---

# Possible Solutions

| Solution                   | Time       | Space |
| -------------------------- | ---------- | ----- |
| Brute Force (Nested Loops) | O(n²)      | O(1)  |
| Sorting + Two Pointers     | O(n log n) | O(n)  |
| Hash Map (One Pass)        | O(n)       | O(n)  |

---

# Solution Used

## Data Structure

### Array

Used to store the input numbers and access them by index.

Operations:

| Operation | Complexity |
| --------- | ---------- |
| Access    | O(1)       |
| Search    | O(n)       |
| Insert    | O(n)       |
| Delete    | O(n)       |

### Hash Map

Used to store previously visited numbers and their indices.

Operations:

| Operation | Complexity |
| --------- | ---------- |
| Insert    | O(1)       |
| Lookup    | O(1)       |
| Delete    | O(1)       |

### Why Hash Map?

- Fast lookup.
- Avoids nested loops.
- Allows finding the complement in constant time.

---

# Pattern

```text
Hashing
Lookup Table
One Pass
```

---

# Algorithm

1. Create a Hash Map.
2. Traverse the array once.
3. Calculate:

   complement = target - nums[i]

4. If the complement exists in the Hash Map:
   - Return its index and the current index.
5. Otherwise:
   - Store the current number and its index in the Hash Map.
6. Continue until the pair is found.

---

# Complexity Analysis

## Time Complexity

```text
O(n)
```

Reason:

- One traversal of the array.
- Hash Map lookup is O(1).
- Hash Map insertion is O(1).

---

## Space Complexity

```text
O(n)
```

Reason:

- In the worst case, all elements are stored in the Hash Map.

---

# Key Takeaway

```text
Brute Force         -> O(n²)
Sorting + Pointers  -> O(n log n)
Hash Map            -> O(n) ✓
```
