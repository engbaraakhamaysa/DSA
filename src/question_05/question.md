# 49. Group Anagrams

## Problem

Given an array of strings `strs`, group the anagrams together.

You can return the answer in any order.

An anagram is a word or phrase formed by rearranging the letters of another word, using all original letters exactly once.

---

## Example 1

### Input

```text id="49ex1"
strs = ["eat","tea","tan","ate","nat","bat"]
```

### Output

```text id="49out1"
[["bat"],["nat","tan"],["ate","eat","tea"]]
```

### Explanation

```text id="49exp1"
"nat" and "tan" are anagrams.

"ate", "eat", and "tea" are anagrams.

"bat" has no matching anagram in the array.
```

---

## Example 2

### Input

```text id="49ex2"
strs = [""]
```

### Output

```text id="49out2"
[[""]]
```

---

## Example 3

### Input

```text id="49ex3"
strs = ["a"]
```

### Output

```text id="49out3"
[["a"]]
```

---

## Constraints

```text id="49cons"
1 <= strs.length <= 10^4
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters
```
