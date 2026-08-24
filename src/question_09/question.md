# 953. Verifying an Alien Dictionary

## Problem

In an alien language, English lowercase letters are used, but the order of the alphabet may be different.

Given:

- An array of words `words`
- A string `order` representing the alien alphabet order

Return `true` if the words are sorted lexicographically according to the alien language, otherwise return `false`.

---

## Example 1

### Input

```text id="953e1"
words = ["hello","leetcode"]
order = "hlabcdefgijkmnopqrstuvwxyz"
```

### Output

```text id="953o1"
true
```

### Explanation

```text id="953x1"
'h' comes before 'l' in the alien alphabet,
so the words are correctly sorted.
```

---

## Example 2

### Input

```text id="953e2"
words = ["word","world","row"]
order = "worldabcefghijkmnpqstuvxyz"
```

### Output

```text id="953o2"
false
```

### Explanation

```text id="953x2"
'd' comes after 'l' in the alien alphabet,
therefore "word" > "world".
```

---

## Example 3

### Input

```text id="953e3"
words = ["apple","app"]
order = "abcdefghijklmnopqrstuvwxyz"
```

### Output

```text id="953o3"
false
```

### Explanation

```text id="953x3"
The prefix "app" is identical,
but the first word is longer.

According to lexicographical order:

"apple" > "app"
```

---

## Constraints

```text id="953c1"
1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
words[i] and order contain lowercase English letters only
```
