# 242. Valid Anagram

## Problem

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, otherwise return `false`.

An anagram means both strings contain the same characters with the same frequencies, but in a different order.

### Example

```text
Input:  s = "anagram", t = "nagaram"
Output: true

Input:  s = "rat", t = "car"
Output: false
```

---

# Possible Solutions

| Solution                   | Time       | Space        |
| -------------------------- | ---------- | ------------ |
| Sorting                    | O(n log n) | O(1) or O(n) |
| Hash Map (Frequency Count) | O(n)       | O(n)         |
| Fixed Array (26 Letters)   | O(n)       | O(1)         |

---

# Solution Used

## Data Structure

### Strings

Used to store and traverse characters.

Operations:

| Operation | Complexity |
| --------- | ---------- |
| Access    | O(1)       |
| Traversal | O(n)       |

### Fixed Array

Stores character frequencies.

```text
index = character - 'a'
```

Operations:

| Operation | Complexity |
| --------- | ---------- |
| Access    | O(1)       |
| Update    | O(1)       |

### Why Fixed Array?

- Input contains only lowercase English letters.
- Faster than Hash Map.
- Direct character-to-index mapping.
- Uses constant space.

---

# Pattern

```text
Frequency Counting
Character Mapping
Single Pass
```

---

# Algorithm

1. If lengths are different, return `false`.
2. Create an integer array of size 26.
3. Traverse both strings simultaneously:
   - Increment count for `s[i]`.
   - Decrement count for `t[i]`.
4. Traverse the frequency array.
5. If any value is not zero, return `false`.
6. Otherwise return `true`.

---

# Complexity Analysis

## Time Complexity

```text
O(n)
```

Reason:

- One traversal through both strings.
- Final traversal over 26 elements only.

---

## Space Complexity

```text
O(1)
```

Reason:

- The frequency array always contains 26 elements.
- Space does not grow with input size.

---

# Key Takeaway

```text
Sorting         -> O(n log n)
Hash Map        -> O(n)
Fixed Array     -> O(n) ✓ Best
```
