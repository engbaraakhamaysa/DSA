# Notes - 219. Contains Duplicate II

## Solution 1 - Hash Map (Index Tracking)

---

## Data Structure

### Array (`nums`)

| Operation | Complexity | Reason                                          |
| --------- | ---------- | ----------------------------------------------- |
| Access    | O(1)       | Direct access using index (`nums[i]`).          |
| Search    | O(n)       | Need to scan elements in worst case.            |
| Insert    | O(n)       | Inserting in middle requires shifting elements. |
| Delete    | O(n)       | Removing elements requires shifting.            |

---

### Hash Map (`map`)

Stores:

```text id="m1k2l3"
value → last index
```

| Operation | Complexity | Reason                             |
| --------- | ---------- | ---------------------------------- |
| Insert    | O(1)       | Direct hashing of key-value pair   |
| Lookup    | O(1)       | Direct key access without scanning |
| Update    | O(1)       | Overwriting existing key           |

---

## Why Hash Map?

- We need to track the **last index** of each value
- To efficiently check the distance between duplicates
- Avoid nested loops (O(n²))

---

## Algorithm

### One Pass Hash Map

Idea:

For each number:

1. Check if it was seen before
2. If yes:
   - Compare current index with previous index
   - If difference ≤ k → return true

3. Update map with current index

---

### Steps

1. Create empty Hash Map
2. Loop through `nums`
3. If number exists in map:
   - Get previous index
   - Check `i - prevIndex <= k`
   - If true → return true

4. Update map with current index
5. If loop ends → return false

---

## Pattern

```text id="p2k9m1"
Hash Map
Index Tracking
Sliding Window (Implicit)
```

---

## Complexity Analysis

### Time Complexity

```text id="t9x8aa"
O(n)
```

#### Reason:

- Single traversal of array
- Each operation (get, set, has) is O(1)

---

### Space Complexity

```text id="s7v4bb"
O(n)
```

#### Reason:

- In worst case, store all elements in map

---

## Key Idea

Instead of checking all pairs, we only store the **latest index** of each number and compare distances instantly.
