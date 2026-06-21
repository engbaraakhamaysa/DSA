# Notes - 953. Verifying an Alien Dictionary

## Solution 1 - Hash Map + Lexicographical Comparison

---

## Data Structure

### Array (`words`)

| Operation | Complexity | Reason                         |
| --------- | ---------- | ------------------------------ |
| Access    | O(1)       | Direct access using index      |
| Traversal | O(n)       | Need to compare adjacent words |

---

### String (`order`)

Represents the alien alphabet order.

Example:

```text id="953m1"
hlabcdefgijkmnopqrstuvwxyz
```

---

### Hash Map (`orderMap`)

Stores:

```text id="953m2"
character → alien rank
```

Example:

```text id="953m3"
h → 0
l → 1
a → 2
b → 3
...
```

| Operation | Complexity | Reason                 |
| --------- | ---------- | ---------------------- |
| Insert    | O(1)       | Store rank             |
| Lookup    | O(1)       | Get character priority |

---

## Why Hash Map?

We need to quickly determine:

```text id="953m4"
Which alien letter comes first?
```

Without a map, every comparison would require searching inside `order`.

The map converts:

```text id="953m5"
character → rank
```

for constant-time comparisons.

---

## Algorithm

### Compare Adjacent Words

Idea:

Words are sorted if every adjacent pair is sorted.

Compare:

```text id="953m6"
words[i]
words[i + 1]
```

character by character.

---

## Steps

1. Build `orderMap`.
2. Compare every adjacent word pair.
3. For each pair:
   - Compare characters from left to right.

4. If characters differ:
   - Compare alien ranks.
   - If first word rank is greater → return false.
   - Otherwise stop comparing this pair.

5. Handle prefix case:
   - If second word ends first → return false.

6. If all pairs are valid → return true.

---

## Pattern

```text id="953p1"
Hash Map
Custom Sorting
Lexicographical Comparison
```

---

## Complexity Analysis

Let:

```text id="953c2"
n = number of words
m = average word length
```

### Time Complexity

```text id="953t1"
O(n × m)
```

#### Reason

- Build rank map → O(26) = O(1)
- Compare adjacent words
- Each comparison may scan up to m characters

Total:

```text id="953t2"
O(n × m)
```

---

### Space Complexity

```text id="953s1"
O(1)
```

#### Reason

Alien alphabet contains exactly:

```text id="953s2"
26 characters
```

Map size never grows beyond 26.

---

## Dry Run

Input:

```text id="953d1"
words = ["hello","leetcode"]

order = "hlabcdefgijkmnopqrstuvwxyz"
```

Map:

```text id="953d2"
h → 0
l → 1
a → 2
...
```

Compare:

```text id="953d3"
hello
leetcode
```

First different character:

```text id="953d4"
h vs l
```

Ranks:

```text id="953d5"
0 < 1
```

Valid order.

Result:

```text id="953d6"
true
```

---

## Prefix Case

Input:

```text id="953d7"
["apple","app"]
```

Comparison:

```text id="953d8"
app = app
```

Second word ends first:

```text id="953d9"
"apple" > "app"
```

Return:

```text id="953d10"
false
```

---

## Key Idea

Convert the alien alphabet into numerical ranks, then perform normal lexicographical comparisons using those ranks.

---

## Insight

The problem is essentially:

```text id="953i1"
"Verify sorting under a custom alphabet."
```

The Hash Map allows us to transform the custom alphabet into an easily comparable ranking system.
