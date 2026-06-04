# Notes - 242. Valid Anagram

## Solution 1 - Hash Map (Frequency Count)

---

## Data Structure

### Strings (`s`, `t`)

| Operation | Complexity | Reason                                      |
| --------- | ---------- | ------------------------------------------- |
| Access    | O(1)       | Access character by index (`s[i]`, `t[i]`). |
| Traversal | O(n)       | Need to scan each character.                |

---

### Hash Map (`map`)

Stores:

```text id="m1a2b3"
character → frequency count
```

| Operation | Complexity | Reason                                |
| --------- | ---------- | ------------------------------------- |
| Insert    | O(1)       | Add/update character count            |
| Lookup    | O(1)       | Check if character exists             |
| Delete    | O(1)       | Remove character when count becomes 0 |

---

## Why Hash Map?

- We need to compare **frequency of characters**
- Fast lookup and updates per character
- Avoid sorting (O(n log n)) approach

---

## Algorithm

### Two Pass Frequency Approach

#### Step 1: Build frequency map for `s`

- Count how many times each character appears

#### Step 2: Validate using `t`

For each character in `t`:

- If character not in map → not an anagram
- Decrease frequency
- If frequency becomes 0 → remove key

---

## Steps

1. If lengths differ → return false
2. Create empty Hash Map
3. Count characters in `s`
4. Traverse `t`
5. For each character:
   - If not in map → return false
   - Decrease count
   - Remove if count becomes 0

6. Return `map.size === 0`

---

## Pattern

```text id="p1a2c3"
Hashing
Frequency Counting
Two Pass Scan
```

---

## Complexity Analysis

### Time Complexity

```text id="t1a2b3"
O(n)
```

#### Reason:

- One pass for `s`
- One pass for `t`
- Each map operation is O(1)

---

### Space Complexity

```text id="s1a2b3"
O(1)
```

#### Reason:

- Only lowercase English letters → max 26 keys
- Therefore space is constant

---

## Key Idea

Instead of sorting, we compare **character frequency balance** using a Hash Map.

---

## Optimization Insight

If input were Unicode:

- Hash Map would still work
- But space becomes O(n) instead of O(1)
- Because character set is much larger

---

---

## Solution 2 - Fixed Array Frequency (Lowercase Letters)

---

## Data Structure

### Strings (`s`, `t`)

| Operation | Complexity | Reason                                      |
| --------- | ---------- | ------------------------------------------- |
| Access    | O(1)       | Access character by index (`s[i]`, `t[i]`). |
| Traversal | O(n)       | Need to scan all characters once.           |

---

### Fixed Array (`charCounts`)

We use a fixed-size array of 26 integers:

```text id="a1b2c3"
index = charCodeAt(character) - 97
```

| Operation | Complexity | Reason                       |
| --------- | ---------- | ---------------------------- |
| Access    | O(1)       | Direct index access in array |
| Update    | O(1)       | Increment / decrement value  |
| Size      | O(1)       | Always 26 elements only      |

---

## Why Array Instead of Hash Map?

- Input is limited to lowercase English letters only (`a-z`)
- We can map each character to a fixed index (0–25)
- Faster than Hash Map (no hashing overhead)
- Uses constant space

---

## Algorithm

### Single Pass Frequency Balance

Idea:

- Instead of building two separate counts
- We update counts for both strings in one loop

---

### Steps

1. If lengths differ → return false
2. Create array of size 26 filled with 0
3. Loop through both strings at the same time:
   - Increment count for `s[i]`
   - Decrement count for `t[i]`

4. Check final array:
   - If any value ≠ 0 → not an anagram

5. Otherwise → return true

---

## Pattern

```text id="p2a3b4"
Frequency Array
Character Mapping
Single Pass Optimization
```

---

## Complexity Analysis

### Time Complexity

```text id="t2a3b4"
O(n)
```

#### Reason:

- Single loop through strings
- Final check over fixed 26 elements → O(1)

---

### Space Complexity

```text id="s2a3b4"
O(1)
```

#### Reason:

- Array size is fixed (26)
- Does not grow with input size

---

## Key Idea

Instead of using a Hash Map, we map characters directly to array indices, making the solution faster and more memory efficient.

---

## Optimization Insight

| Approach    | Time | Space |
| ----------- | ---- | ----- |
| Hash Map    | O(n) | O(n)  |
| Fixed Array | O(n) | O(1)  |

This is the preferred solution when the character set is known and limited.
