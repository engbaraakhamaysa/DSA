# 217. Contains Duplicate

## Problem

Given an integer array `nums`, return `true` if any value appears more than once in the array, otherwise return `false`.

Example:

```text
Input:  nums = [1,2,3,1]
Output: true

Input:  nums = [1,2,3,4]
Output: false
```

---

# Possible Solutions

| Solution                   | Time       | Space        |
| -------------------------- | ---------- | ------------ |
| Brute Force (Nested Loops) | O(n²)      | O(1)         |
| Sorting                    | O(n log n) | O(1) or O(n) |
| Hash Map / Hash Set        | O(n)       | O(n)         |

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

Used to store numbers that have already been seen.

Operations:

| Operation | Complexity |
| --------- | ---------- |
| Insert    | O(1)       |
| Lookup    | O(1)       |
| Delete    | O(1)       |

### Why Hash Map?

- Fast duplicate detection.
- Constant-time lookup.
- Avoids nested loops.
- Allows early return when a duplicate is found.

---

# Pattern

```text
Hashing
Duplicate Detection
One Pass Scan
```

---

# Algorithm

1. Create an empty Hash Map.
2. Traverse the array once.
3. For each number:
   - Check if it already exists in the map.
   - If it exists, return `true`.
   - Otherwise store it in the map.
4. If the loop finishes, return `false`.

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

- In the worst case all elements are unique.
- The Hash Map stores up to `n` elements.

---

# Key Takeaway

```text
Brute Force      -> O(n²)
Sorting          -> O(n log n)
Hash Map / Set   -> O(n) ✓
```
