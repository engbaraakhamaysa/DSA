# Notes - 347. Top K Frequent Elements

## Solution 1 - Hash Map + Sorting

---

## Data Structure

### Array (`nums`)

| Operation | Complexity | Reason                       |
| --------- | ---------- | ---------------------------- |
| Access    | O(1)       | Direct index access          |
| Traversal | O(n)       | Need to iterate all elements |

---

### Hash Map (`map`)

Stores:

```text id="347m1"
number → frequency
```

Example:

```text id="347m2"
1 → 3
2 → 2
3 → 1
```

| Operation | Complexity | Reason            |
| --------- | ---------- | ----------------- |
| Insert    | O(1)       | Update frequency  |
| Lookup    | O(1)       | Get current count |
| Update    | O(1)       | Increment count   |

---

### Array of Pairs (`arr`)

```text id="347m3"
[number, frequency]
```

Used for sorting.

---

## Why Hash Map?

- We need to count frequency of each element
- Then rank elements by frequency
- Hash Map gives fast counting in O(1)

---

## Algorithm

### Frequency + Sort

Idea:

1. Count frequency of each number.
2. Convert map into array of pairs.
3. Sort by frequency (descending).
4. Take top k elements.

---

## Steps

1. Create Hash Map for frequencies.
2. Iterate over `nums` and fill map.
3. Convert map to array of `[num, frequency]`.
4. Sort array by frequency descending.
5. Take first `k` elements.
6. Return their values.

---

## Pattern

```text id="347p1"
Hash Map
Sorting
Frequency Counting
Top K Selection
```

---

## Complexity Analysis

Let:

```text id="347c2"
n = length of nums
u = number of unique elements
```

### Time Complexity

```text id="347t1"
O(n log n)
```

#### Reason

- Building frequency map → O(n)
- Converting map → O(u)
- Sorting array → O(u log u)

Worst case:

```text id="347t2"
u ≈ n
```

So:

```text id="347t3"
O(n log n)
```

---

### Space Complexity

```text id="347s1"
O(n)
```

#### Reason

- Hash Map stores all unique elements
- Array stores map entries

---

## Dry Run

Input:

```text id="347d1"
nums = [1,1,1,2,2,3], k = 2
```

### Step 1 - Frequency Map

```text id="347d2"
1 → 3
2 → 2
3 → 1
```

### Step 2 - Convert to Array

```text id="347d3"
[[1,3],[2,2],[3,1]]
```

### Step 3 - Sort

```text id="347d4"
[[1,3],[2,2],[3,1]]
```

### Step 4 - Take Top K

```text id="347d5"
[1,2]
```

---

## Key Idea

We first count frequencies, then sort elements based on frequency.

---

## Limitation

This approach does:

```text id="347l1"
Sorting → O(n log n)
```

But the problem asks for better than O(n log n).

---

## Optimization Hint

Better solutions use:

- Bucket Sort → O(n)
- Heap (Min Heap of size k) → O(n log k)

These avoid full sorting of all elements.

# Notes - 347. Top K Frequent Elements

## Solution 2 - Hash Map + Min Heap (Priority Queue)

---

## Data Structure

### Array (`nums`)

| Operation | Complexity | Reason                       |
| --------- | ---------- | ---------------------------- |
| Access    | O(1)       | Direct index access          |
| Traversal | O(n)       | Iterate through all elements |

---

### Hash Map (`count`)

Stores:

```text id="347h1"
number → frequency
```

Example:

```text id="347h2"
1 → 3
2 → 2
3 → 1
```

| Operation | Complexity | Reason            |
| --------- | ---------- | ----------------- |
| Insert    | O(1)       | Update frequency  |
| Lookup    | O(1)       | Get current count |
| Update    | O(1)       | Increment value   |

---

### Min Heap (`PriorityQueue`)

Stores:

```text id="347h3"
numbers ordered by frequency (smallest first)
```

| Operation     | Complexity | Reason                  |
| ------------- | ---------- | ----------------------- |
| Insert        | O(log k)   | Maintain heap property  |
| Remove (poll) | O(log k)   | Remove smallest element |
| Peek          | O(1)       | Access root             |

---

## Why Min Heap?

Instead of sorting all elements:

- We only keep **top k frequent elements**
- Heap size is always ≤ k
- Less expensive than sorting entire dataset

---

## Algorithm

### Frequency + Heap Optimization

Idea:

1. Count frequency of each number.
2. Use a min heap to store top k elements.
3. If heap size exceeds k, remove smallest frequency.
4. Remaining heap contains top k frequent elements.

---

## Steps

1. If `k == nums.length`, return nums directly.
2. Build frequency map.
3. Create min heap ordered by frequency.
4. For each unique number:
   - Add it to heap
   - If heap size > k → remove smallest frequency

5. Extract elements from heap into result array.

---

## Pattern

```text id="347p2"
Hash Map
Heap (Priority Queue)
Top K Elements
Streaming Optimization
```

---

## Complexity Analysis

Let:

```text id="347c3"
n = number of elements
u = number of unique elements
```

### Time Complexity

```text id="347t4"
O(n log k)
```

#### Reason

1. Building frequency map → O(n)
2. Iterating unique elements → O(u)
3. Each heap operation → O(log k)

Since heap size is limited to k:

```text id="347t5"
O(u log k)
```

Worst case:

```text id="347t6"
u ≈ n → O(n log k)
```

---

### Space Complexity

```text id="347s2"
O(n)
```

#### Reason

- Hash Map stores all unique elements
- Heap stores at most k elements

---

## Dry Run

Input:

```text id="347d6"
nums = [1,1,1,2,2,3], k = 2
```

### Step 1 - Frequency Map

```text id="347d7"
1 → 3
2 → 2
3 → 1
```

---

### Step 2 - Heap Process

```text id="347d8"
add 1 → [1]
add 2 → [2,1]
add 3 → [3,1,2]

remove smallest → [3,2]
```

Final heap:

```text id="347d9"
[1,2]
```

---

## Key Idea

Instead of sorting all elements, we maintain only the top k frequent elements using a **min heap of size k**.

---

## Improvement Over Solution 1

| Solution | Time Complexity |
| -------- | --------------- |
| Sorting  | O(n log n)      |
| Min Heap | O(n log k)      |

This is more efficient when `k << n`.

---

## Core Insight

We trade full sorting for a controlled structure (heap) that only keeps the most important k elements at any time.
