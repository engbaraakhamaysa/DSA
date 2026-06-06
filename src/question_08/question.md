# 13. Roman to Integer

## Problem

Given a Roman numeral string `s`, convert it to an integer.

Roman numerals use the following symbols:

| Symbol | Value |
| ------ | ----- |
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |

---

## Rules

Normally, symbols are written from largest to smallest.

However, subtraction rules apply:

- I before V or X → 4, 9
- X before L or C → 40, 90
- C before D or M → 400, 900

---

## Example 1

### Input

```text id="13e1"
s = "III"
```

### Output

```text id="13o1"
3
```

---

## Example 2

### Input

```text id="13e2"
s = "LVIII"
```

### Output

```text id="13o2"
58
```

---

## Example 3

### Input

```text id="13e3"
s = "MCMXCIV"
```

### Output

```text id="13o3"
1994
```

---

## Constraints

```text id="13c1"
1 <= s.length <= 15
s consists of ('I', 'V', 'X', 'L', 'C', 'D', 'M')
1 <= value <= 3999
```

---

## Follow-up

Handle valid Roman numerals efficiently (linear time expected).
