# Notes - 49. Group Anagrams

## Solution 1 - Brute Force + Frequency Array

---

## Data Structure

### Array (`strs`)

| Operation | Complexity | Reason                                 |
| --------- | ---------- | -------------------------------------- |
| Access    | O(1)       | Direct access using index (`strs[i]`). |
| Traversal | O(n)       | Need to scan all strings.              |
| Insert    | O(1)       | Push to end of array.                  |

---

### Boolean Array (`visited`)

Stores:

```text id="49v1"
index → processed or not
```

| Operation | Complexity | Reason              |
| --------- | ---------- | ------------------- |
| Access    | O(1)       | Direct index lookup |
| Update    | O(1)       | Assign true/false   |

---

### Frequency Array (`charCounts`)

Stores:

```text id="49v2"
character → frequency
```

Size:

```text id="49v3"
26
```

| Operation | Complexity | Reason                    |
| --------- | ---------- | ------------------------- |
| Access    | O(1)       | Direct index access       |
| Update    | O(1)       | Increment/decrement count |

---

## Why These Data Structures?

### visited

- Prevents processing the same word multiple times.
- Once a word joins a group, it is marked as visited.

### charCounts

- Used to compare two strings.
- If all frequencies become zero, the strings are anagrams.

---

## Algorithm

### Brute Force Grouping

Idea:

For each word:

1. Create a new group.
2. Compare it with every remaining word.
3. Use a frequency array to check if they are anagrams.
4. Add matching words to the same group.
5. Mark matched words as visited.

---

## Steps

1. Create result array.
2. Create visited array.
3. Loop through each string.
4. Skip visited strings.
5. Create a new group.
6. Compare with remaining strings.
7. Build frequency balance array.
8. Check if all frequencies are zero.
9. If yes:
   - Add to group.
   - Mark visited.

10. Add group to result.

---

## Pattern

```text id="49p1"
Brute Force
Frequency Counting
Grouping
```

---

## Complexity Analysis

Let:

```text id="49p2"
n = number of strings
m = average string length
```

### Time Complexity

```text id="49t1"
O(n² × m)
```

#### Reason

For every string:

- Compare with all remaining strings → O(n²)
- Anagram check costs O(m)

Therefore:

```text id="49t2"
O(n² × m)
```

---

### Space Complexity

```text id="49s1"
O(n)
```

#### Reason

- visited array stores n values
- result array stores grouped strings
- frequency array size is fixed (26)

---

## Dry Run

Input:

```text id="49d1"
["eat","tea","tan","ate","nat","bat"]
```

Execution:

```text id="49d2"
eat
 ├─ tea ✓
 ├─ ate ✓
Group = [eat, tea, ate]

tan
 ├─ nat ✓
Group = [tan, nat]

bat
Group = [bat]
```

---

## Key Idea

This solution explicitly compares strings and groups matching anagrams together.

It works correctly but performs many repeated comparisons.

---

## Limitation

The same anagram pattern may be checked many times.

This leads to:

```text id="49l1"
O(n² × m)
```

A Hash Map solution can improve this to:

```text id="49l2"
O(n × m)
```

by generating a unique key for each anagram group.

# Notes - 49. Group Anagrams

## Solution 2 - Hash Map + Sorted String Key

---

## Data Structure

### Array (`strs`)

| Operation | Complexity | Reason                      |
| --------- | ---------- | --------------------------- |
| Access    | O(1)       | Direct access by index.     |
| Traversal | O(n)       | Need to visit every string. |
| Insert    | O(1)       | Push to end of array.       |

---

### Hash Map (`map`)

Stores:

```text id="49m1"
sorted_string → group of anagrams
```

Example:

```text id="49m2"
"aet" → ["eat","tea","ate"]
"ant" → ["tan","nat"]
"abt" → ["bat"]
```

| Operation | Complexity | Reason                 |
| --------- | ---------- | ---------------------- |
| Insert    | O(1)       | Store group using key  |
| Lookup    | O(1)       | Find existing group    |
| Update    | O(1)       | Push string into group |

---

## Why Hash Map?

- All anagrams produce the same sorted string.
- The sorted string becomes a unique key.
- Strings with the same key belong to the same group.
- Avoids comparing every pair of strings.

---

## Algorithm

### Group by Sorted String

Idea:

Convert every string into its sorted version.

Examples:

```text id="49g1"
eat → aet
tea → aet
ate → aet
```

Since all generate the same key:

```text id="49g2"
aet
```

they belong to the same group.

---

## Steps

1. Create empty Hash Map.
2. Loop through every string.
3. Sort characters of current string.
4. Use sorted string as key.
5. If key does not exist:
   - Create empty group.

6. Add current string to its group.
7. Return all map values.

---

## Pattern

```text id="49p3"
Hashing
Grouping
Anagram Classification
```

---

## Complexity Analysis

Let:

```text id="49c1"
n = number of strings
m = average string length
```

### Time Complexity

```text id="49t3"
O(n × m log m)
```

#### Reason

For each string:

```text id="49t4"
split()  → O(m)
sort()   → O(m log m)
join()   → O(m)
```

Dominant operation:

```text id="49t5"
O(m log m)
```

Performed for every string:

```text id="49t6"
O(n × m log m)
```

---

### Space Complexity

```text id="49s2"
O(n × m)
```

#### Reason

- Hash Map stores all strings.
- Keys are derived from sorted strings.
- Result groups contain every input string.

---

## Dry Run

Input:

```text id="49d3"
["eat","tea","tan","ate","nat","bat"]
```

Execution:

```text id="49d4"
eat → aet
tea → aet
tan → ant
ate → aet
nat → ant
bat → abt
```

Map:

```text id="49d5"
aet → [eat, tea, ate]
ant → [tan, nat]
abt → [bat]
```

Result:

```text id="49d6"
[
  ["eat","tea","ate"],
  ["tan","nat"],
  ["bat"]
]
```

---

## Key Idea

Instead of comparing strings with each other, generate a canonical representation (sorted string).

All anagrams share the same sorted form, making grouping very efficient.

---

## Improvement Over Solution 1

| Solution                      | Time Complexity |
| ----------------------------- | --------------- |
| Brute Force + Frequency Array | O(n² × m)       |
| Hash Map + Sorted Key         | O(n × m log m)  |

The Hash Map approach removes the expensive pairwise comparisons and scales much better for large inputs.

---

---

# Notes - 49. Group Anagrams

## Solution 3 - Hash Map + Frequency Count Key

---

## Data Structure

### Array (`strs`)

| Operation | Complexity | Reason                        |
| --------- | ---------- | ----------------------------- |
| Access    | O(1)       | Direct access by index.       |
| Traversal | O(n)       | Need to process every string. |
| Insert    | O(1)       | Push to end of array.         |

---

### Frequency Array (`count`)

Stores:

```text id="49f1"
character → frequency
```

Size:

```text id="49f2"
26
```

| Operation | Complexity   | Reason              |
| --------- | ------------ | ------------------- |
| Access    | O(1)         | Direct index lookup |
| Update    | O(1)         | Increment frequency |
| Reset     | O(26) = O(1) | Fixed-size array    |

---

### Hash Map (`ansMap`)

Stores:

```text id="49f3"
frequency_key → group of anagrams
```

Example:

```text id="49f4"
#1#0#0#0...#1... → ["eat","tea","ate"]
```

| Operation | Complexity | Reason                |
| --------- | ---------- | --------------------- |
| Insert    | O(1)       | Store group using key |
| Lookup    | O(1)       | Find existing group   |
| Update    | O(1)       | Add string to group   |

---

## Why Frequency Count Key?

Instead of sorting:

```text id="49f5"
eat → aet
tea → aet
```

we represent each word by its character frequencies:

```text id="49f6"
a=1,e=1,t=1
```

All anagrams produce exactly the same frequency signature.

---

## Algorithm

### Group by Character Frequency

Idea:

- Count occurrences of each letter.
- Build a unique key from those frequencies.
- Use the key to group anagrams.

---

## Steps

1. Create empty Hash Map.
2. For each string:
   - Reset frequency array.
   - Count character occurrences.
   - Build frequency key.

3. If key does not exist:
   - Create new group.

4. Add string to its group.
5. Return all groups.

---

## Pattern

```text id="49p4"
Hashing
Frequency Counting
Grouping
```

---

## Complexity Analysis

Let:

```text id="49c2"
n = number of strings
m = average string length
```

### Time Complexity

```text id="49t7"
O(n × m)
```

#### Reason

For each string:

- Count characters → O(m)
- Build key using 26 positions → O(26)

Since 26 is constant:

```text id="49t8"
O(m + 26)
=
O(m)
```

For all strings:

```text id="49t9"
O(n × m)
```

---

### Space Complexity

```text id="49s3"
O(n × m)
```

#### Reason

- Hash Map stores all strings.
- Keys are stored for each anagram group.
- Output contains every input string.

Additional frequency array:

```text id="49s4"
O(26) = O(1)
```

---

## Dry Run

Input:

```text id="49d7"
["eat","tea","tan","ate","nat","bat"]
```

Execution:

```text id="49d8"
eat → #1#0#0#0#1...#1...
tea → #1#0#0#0#1...#1...
ate → #1#0#0#0#1...#1...

tan → #1#0#0...#1...#1...
nat → #1#0#0...#1...#1...

bat → #1#1#0...#1...
```

Map:

```text id="49d9"
key1 → [eat, tea, ate]
key2 → [tan, nat]
key3 → [bat]
```

---

## Key Idea

Two strings are anagrams if and only if their character frequencies are identical.

Instead of sorting every string, we build a frequency signature and use it as the Hash Map key.

---

## Improvement Over Solution 2

| Solution                 | Time Complexity |
| ------------------------ | --------------- |
| Hash Map + Sorted Key    | O(n × m log m)  |
| Hash Map + Frequency Key | O(n × m)        |

This solution avoids sorting entirely, making it the most efficient approach for lowercase English letters.
