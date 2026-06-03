# Notes

## Solution 1 - Brute Force

### Data Structure

### Array (`nums`)

| Operation | Complexity | Reason                                                             |
| --------- | ---------- | ------------------------------------------------------------------ |
| Access    | O(1)       | We can directly access any element using its index (`nums[i]`).    |
| Search    | O(n)       | We may need to scan the entire array to find a value.              |
| Insert    | O(n)       | Inserting in the middle may require shifting elements.             |
| Delete    | O(n)       | Removing an element may require shifting elements to fill the gap. |

#### Why Array?

- The input is provided as an array.
- We need direct access to elements by index.
- The answer requires returning indices.

---

### Algorithm

#### Brute Force (Nested Loops)

Idea:

- Check every possible pair of numbers.
- If the sum equals `target`, return their indices.

Steps:

1. Start with the first element.
2. Compare it with every element after it.
3. Check if their sum equals `target`.
4. Return the indices when a valid pair is found.

---

### Pattern

```text
Brute Force
Nested Loops
Pair Search
```

---

### Complexity Analysis

#### Time Complexity

```text
O(n²)
```

Reason:

- Outer loop runs `n` times.
- Inner loop may run up to `n` times for each iteration.

---

#### Space Complexity

```text
O(1)
```

Reason:

- No extra data structures are used.
- Only loop variables are stored.

---

### Dry Run

Input:

```text
nums = [2,7,11,15]
target = 9
```

Execution:

```text
i = 0 → nums[i] = 2

j = 1 → nums[j] = 7

2 + 7 = 9 ✓

return [0,1]
```

---

### Key Takeaway

This solution is simple and easy to understand, but it checks many unnecessary pairs.

The follow-up suggests using a Hash Map to achieve:

```text
Time: O(n)
Space: O(n)
```

# Solution 2 - Hash Map

### Data Structure

#### Array (`nums`)

| Operation | Complexity | Reason                                                             |
| --------- | ---------- | ------------------------------------------------------------------ |
| Access    | O(1)       | We can directly access any element using its index (`nums[i]`).    |
| Search    | O(n)       | We may need to scan the entire array to find a value.              |
| Insert    | O(n)       | Inserting in the middle may require shifting elements.             |
| Delete    | O(n)       | Removing an element may require shifting elements to fill the gap. |

#### Hash Map (`myMap`)

| Operation | Complexity | Reason                                             |
| --------- | ---------- | -------------------------------------------------- |
| Insert    | O(1)       | Store a value and its index using a key.           |
| Lookup    | O(1)       | Find a key directly without scanning all elements. |
| Delete    | O(1)       | Remove a key directly from the map.                |

Why Hash Map?

- Stores numbers already visited.
- Allows fast lookup of the complement value.
- Eliminates the need for nested loops.

---

### Algorithm

#### One Pass Hash Map

Idea:

For each number:

1. Calculate the complement.

```text
complement = target - nums[i]
```

2. Check if the complement already exists in the Hash Map.
3. If it exists, return the stored index and the current index.
4. Otherwise, store the current number and its index in the Hash Map.

---

### Pattern

```text
Hashing
Lookup Table
One Pass
```

---

### Complexity Analysis

#### Time Complexity

```text
O(n)
```

Reason:

- We iterate through the array once.
- Each Hash Map lookup (`has`) is O(1).
- Each Hash Map insertion (`set`) is O(1).

Therefore:

```text
n × O(1) = O(n)
```

---

#### Space Complexity

```text
O(n)
```

Reason:

- In the worst case, all elements are stored in the Hash Map.
- The map may contain up to `n` entries.

---

### Dry Run

Input:

```text
nums = [2,7,11,15]
target = 9
```

Execution:

```text
i = 0

num = 2
complement = 7

Map = {2:0}

----------------

i = 1

num = 7
complement = 2

Map contains 2 ✓

return [0,1]
```

---

### Key Takeaway

This solution improves the brute-force approach by using a Hash Map to find complements instantly instead of checking every possible pair.

Improvement:

```text
Brute Force : O(n²)
Hash Map    : O(n)
```
