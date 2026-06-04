# Notes - 217. Contains Duplicate

## Solution 1 - Hash Map

---

## Data Structure

### Array (`nums`)

| Operation | Complexity | Reason                                          |
| --------- | ---------- | ----------------------------------------------- |
| Access    | O(1)       | Direct access using index (`nums[i]`).          |
| Search    | O(n)       | Need to scan elements to find a value.          |
| Insert    | O(n)       | Inserting in middle requires shifting elements. |
| Delete    | O(n)       | Removing elements requires shifting.            |

---

### Hash Map (`boolMap`)

| Operation | Complexity | Reason                                             |
| --------- | ---------- | -------------------------------------------------- |
| Insert    | O(1)       | Key-value stored directly using hashing.           |
| Lookup    | O(1)       | Check if key exists without scanning all elements. |
| Delete    | O(1)       | Direct removal using key.                          |

---

### Why Hash Map?

- We need to detect **repeated values**
- Fast lookup is required to check if a number already exists
- Avoids nested loops

---

## Algorithm

### Single Pass Hash Map

Idea:

- Iterate through the array once
- For each number:
  - If it already exists in the map → return `true`
  - Otherwise store it in the map

---

### Steps

1. Create empty Hash Map
2. Loop through `nums`
3. Check if current number exists in map
4. If yes → duplicate found → return `true`
5. If no → store it
6. If loop ends → return `false`

---

## Pattern

```text id="p3q8xk"
Hashing
Duplicate Detection
One Pass Scan
```

---

## Complexity Analysis

### Time Complexity

```text id="t1z9aa"
O(n)
```

#### Reason:

- We traverse the array once
- Each `has()` and `set()` operation in Map is O(1)
- Total operations: n × O(1)

---

### Space Complexity

```text id="u9b2ld"
O(n)
```

#### Reason:

- In worst case, all elements are unique
- We store all elements in the Hash Map

---

## Dry Run

Input:

```text id="k8v1qp"
nums = [1,2,3,1]
```

Execution:

```text id="x9m2aa"
i = 0 → 1 → map = {1}

i = 1 → 2 → map = {1,2}

i = 2 → 3 → map = {1,2,3}

i = 3 → 1 → already exists → return true
```

---

## Key Takeaway

- Hash Map allows fast detection of duplicates
- Much better than brute force O(n²)
- Stops early as soon as duplicate is found
