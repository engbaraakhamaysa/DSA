# Notes - 238. Product of Array Except Self

## Solution 1 - Brute Force + Array Copy

---

## Data Structure

### Array (`nums`)

| Operation | Complexity | Reason                                              |
| --------- | ---------- | --------------------------------------------------- |
| Access    | O(1)       | Direct access using index (`nums[i]`).              |
| Traversal | O(n)       | Need to iterate through all elements.               |
| Copy      | O(n)       | Creating a new array requires copying all elements. |

---

### Hash Map (`map`)

Stores:

```text id="238m1"
index → modified array
```

Example:

```text id="238m2"
0 → [1,2,3,4]
1 → [1,1,3,4]
2 → [1,2,1,4]
3 → [1,2,3,1]
```

| Operation | Complexity | Reason                |
| --------- | ---------- | --------------------- |
| Insert    | O(1)       | Store key-value pair  |
| Lookup    | O(1)       | Retrieve array by key |

---

## Why This Approach?

For each position:

- Create a copy of the array.
- Replace the current element with `1`.
- Multiply all values.
- Store the result.

This simulates:

```text id="238m3"
product of all elements except nums[i]
```

---

## Algorithm

### Brute Force

Idea:

For every index:

1. Copy the array.
2. Replace current element with 1.
3. Multiply all elements.
4. Store the product.

---

## Steps

1. Create Hash Map.
2. For each index:
   - Copy array.
   - Replace current value with 1.
   - Store modified array.

3. For every stored array:
   - Calculate product.
   - Push result to answer array.

4. Return answer.

---

## Pattern

```text id="238p2"
Brute Force
Array Copying
Simulation
```

---

## Complexity Analysis

Let:

```text id="238p3"
n = nums.length
```

### Time Complexity

```text id="238t1"
O(n²)
```

#### Reason

##### Building the map

For each index:

```text id="238t2"
[...nums]
```

copies the entire array:

```text id="238t3"
O(n)
```

Performed n times:

```text id="238t4"
O(n²)
```

##### Calculating products

For every stored array:

- Traverse all n elements

```text id="238t5"
O(n × n)
=
O(n²)
```

Total:

```text id="238t6"
O(n²)
```

---

### Space Complexity

```text id="238s1"
O(n²)
```

#### Reason

The map stores:

```text id="238s2"
n arrays
```

Each array contains:

```text id="238s3"
n elements
```

Therefore:

```text id="238s4"
n × n
=
O(n²)
```

---

## Dry Run

Input:

```text id="238d1"
nums = [1,2,3,4]
```

Generated Arrays:

```text id="238d2"
[1,2,3,4]
[1,1,3,4]
[1,2,1,4]
[1,2,3,1]
```

Products:

```text id="238d3"
24
12
8
6
```

Result:

```text id="238d4"
[24,12,8,6]
```

---

## Key Idea

This solution works by explicitly rebuilding the product for every index.

---

## Limitation

The problem requires:

```text id="238l1"
O(n) Time
```

but this solution uses:

```text id="238l2"
O(n²) Time
O(n²) Space
```

because it repeatedly copies arrays and recalculates products.

The optimized solution uses:

```text id="238l3"
Prefix Products
Suffix Products
```

to achieve:

```text id="238l4"
O(n) Time
```

---

---

# Notes - 238. Product of Array Except Self

## Solution 2 - Prefix & Suffix Products

---

## Data Structure

### Array (`nums`)

| Operation | Complexity | Reason                                 |
| --------- | ---------- | -------------------------------------- |
| Access    | O(1)       | Direct access using index (`nums[i]`). |
| Traversal | O(n)       | Need to iterate through all elements.  |

---

### Result Array (`result`)

Stores:

```text id="238r1"
result[i] = product of all elements except nums[i]
```

| Operation | Complexity | Reason                         |
| --------- | ---------- | ------------------------------ |
| Access    | O(1)       | Direct index access            |
| Update    | O(1)       | Update value at specific index |

---

## Why Prefix & Suffix?

Instead of recalculating products for every position:

```text id="238r2"
1 × 2 × 3 × 4
```

we reuse previous computations.

For each index:

```text id="238r3"
answer[i]
=
(product of elements to the left)
×
(product of elements to the right)
```

---

## Algorithm

### Prefix Pass

Store product of all elements before index `i`.

Example:

```text id="238r4"
nums = [1,2,3,4]

result = [1,1,2,6]
```

Explanation:

```text id="238r5"
1
1
1×2
1×2×3
```

---

### Suffix Pass

Multiply each position by product of elements after it.

Example:

```text id="238r6"
suffix products:

24
12
4
1
```

Final result:

```text id="238r7"
[24,12,8,6]
```

---

## Steps

1. Create result array filled with 1.
2. Traverse left → right:
   - Store prefix product.

3. Traverse right → left:
   - Multiply by suffix product.

4. Return result.

---

## Pattern

```text id="238p4"
Prefix Sum / Product
Suffix Sum / Product
Precomputation
```

---

## Complexity Analysis

Let:

```text id="238p5"
n = nums.length
```

### Time Complexity

```text id="238t7"
O(n)
```

#### Reason

First loop:

```text id="238t8"
O(n)
```

Second loop:

```text id="238t9"
O(n)
```

Total:

```text id="238t10"
O(n + n)
=
O(n)
```

---

### Space Complexity

```text id="238s5"
O(1)
```

#### Reason

Extra variables used:

```text id="238s6"
pre
post
```

Both require constant space.

The result array is not counted as extra space according to the problem statement.

---

## Dry Run

Input:

```text id="238d5"
nums = [1,2,3,4]
```

### Prefix Pass

```text id="238d6"
pre = 1

result[0] = 1
pre = 1

result[1] = 1
pre = 2

result[2] = 2
pre = 6

result[3] = 6
pre = 24
```

Result:

```text id="238d7"
[1,1,2,6]
```

---

### Suffix Pass

```text id="238d8"
post = 1

result[3] *= 1  → 6
post = 4

result[2] *= 4  → 8
post = 12

result[1] *= 12 → 12
post = 24

result[0] *= 24 → 24
```

Final:

```text id="238d9"
[24,12,8,6]
```

---

## Key Idea

For every index:

```text id="238k1"
answer[i]
=
left product × right product
```

Instead of recomputing products repeatedly, we build them incrementally using prefix and suffix accumulations.

---

## Improvement Over Solution 1

| Solution                   | Time  | Space |
| -------------------------- | ----- | ----- |
| Brute Force + Array Copies | O(n²) | O(n²) |
| Prefix & Suffix Products   | O(n)  | O(1)  |

This is the optimal solution required by the problem.
