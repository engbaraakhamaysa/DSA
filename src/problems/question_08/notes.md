# Notes - 13. Roman to Integer

## Solution 1 - Hash Map + Left-to-Right Parsing

---

## Data Structure

### String (`s`)

| Operation | Complexity | Reason                              |
| --------- | ---------- | ----------------------------------- |
| Access    | O(1)       | Access character by index (`s[i]`). |
| Traversal | O(n)       | We scan the entire string once.     |

---

### Hash Map (`romanMap`)

Stores:

```text id="13m1"
Roman symbol → integer value
```

Example:

```text id="13m2"
I → 1
V → 5
X → 10
L → 50
C → 100
D → 500
M → 1000
```

| Operation | Complexity | Reason                  |
| --------- | ---------- | ----------------------- |
| Lookup    | O(1)       | Direct key-value access |
| Insert    | O(1)       | Predefined static map   |

---

## Why Hash Map?

- Fast conversion from Roman symbol to integer
- Avoids multiple conditional checks
- Clean mapping between characters and values

---

## Algorithm

### Left-to-Right with Previous Tracking

Idea:

We compare each Roman numeral with the previous one:

- If current value > previous → subtraction case
- Otherwise → addition case

---

## Steps

1. Create Roman value map.
2. Initialize:
   - `sum = 0`
   - `n = 0` (previous value)

3. Loop through string:
   - Get current value
   - If current > previous:
     - subtract previous from sum

   - Else:
     - add previous to sum

   - Update previous = current

4. After loop, add last stored value (`n`)
5. Return result

---

## Pattern

```text id="13p1"
Hash Map
Greedy Parsing
Left-to-Right Scan
```

---

## Complexity Analysis

### Time Complexity

```text id="13t1"
O(n)
```

#### Reason

- Single pass through string
- Each lookup in map is O(1)

---

### Space Complexity

```text id="13s1"
O(1)
```

#### Reason

- Roman map size is constant (7 symbols)
- No extra dynamic structures based on input size

---

## Dry Run

Input:

```text id="13d1"
s = "MCMXCIV"
```

Execution:

```text id="13d2"
M  → 1000
C  → 100
M  → 1000
X  → 10
C  → 100
I  → 1
V  → 5
```

Processing:

```text id="13d3"
M   → add 1000
CM  → +900
XC  → +90
IV  → +4
```

Final result:

```text id="13d4"
1994
```

---

## Key Idea

We process Roman numerals sequentially and decide whether to add or subtract based on the relative values of adjacent symbols.

---

## Insight

Instead of hardcoding all subtraction cases, we detect them dynamically by comparing current and previous values.

# Notes - 13. Roman to Integer

## Solution 2 - Hash Map with Two-Character Matching

---

## Data Structure

### String (`s`)

| Operation | Complexity             | Reason                                            |
| --------- | ---------------------- | ------------------------------------------------- |
| Access    | O(1)                   | Access characters by index                        |
| Substring | O(1) average (small n) | Extract 1–2 characters                            |
| Traversal | O(n)                   | Each character is processed at most once or twice |

---

### Lookup Table (`values`)

Stores:

```text id="13m3"
Roman symbol / pair → integer value
```

Example:

```text id="13m4"
I → 1
V → 5
...
IV → 4
IX → 9
...
CM → 900
```

| Operation | Complexity | Reason               |
| --------- | ---------- | -------------------- |
| Lookup    | O(1)       | Direct object access |

---

## Why This Approach?

- Handles subtraction cases explicitly (`IV`, `IX`, etc.)
- Avoids comparisons between adjacent characters
- Direct mapping for both single and double symbols

---

## Algorithm

### Greedy with Two-Character Matching

Idea:

At each position:

- Try to match a **two-character Roman numeral**
- If it exists → use it
- Otherwise → use single character

---

## Steps

1. Create lookup table for all Roman values.
2. Initialize:
   - `sum = 0`
   - `i = 0`

3. While `i < s.length`:
   - Check next two characters:
     - If valid pair exists → add value, move `i += 2`

   - Else:
     - Add single character value, move `i += 1`

4. Return sum

---

## Pattern

```text id="13p2"
Hash Map
Greedy Parsing
Two-Pointer Scan
String Matching
```

---

## Complexity Analysis

### Time Complexity

```text id="13t2"
O(n)
```

#### Reason

- Each character is processed at most once
- Some iterations consume 2 characters at once
- Overall linear traversal

---

### Space Complexity

```text id="13s2"
O(1)
```

#### Reason

- Fixed-size lookup table (13 Roman patterns)
- No extra structures dependent on input size

---

## Dry Run

Input:

```text id="13d5"
s = "MCMXCIV"
```

Processing:

```text id="13d6"
M   → 1000
CM  → 900
XC  → 90
IV  → 4
```

Final result:

```text id="13d7"
1994
```

---

## Key Idea

Instead of inferring subtraction rules dynamically, we directly match all special Roman combinations.

---

## Comparison

| Approach   | Idea                    | Complexity | Style            |
| ---------- | ----------------------- | ---------- | ---------------- |
| Solution 1 | Compare previous values | O(n)       | Greedy logic     |
| Solution 2 | Match 1–2 char tokens   | O(n)       | Pattern matching |

---

## Insight

This approach is more explicit and easier to reason about because it encodes all special cases directly in the lookup table.
