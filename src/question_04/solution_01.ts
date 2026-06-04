function isAnagram(s: string, t: string): boolean {
  const map = new Map<string, number>();

  if (s.length !== t.length) {
    return false;
  }

  for (let i = 0; i < s.length; i++) {
    map.set(s[i]!, (map.get(s[i]!) || 0) + 1);
  }

  for (let i = 0; i < t.length; i++) {
    if (!map.has(t[i]!)) {
      return false;
    }

    let count = map.get(t[i]!)! - 1;

    if (count === 0) {
      map.delete(t[i]!);
    } else {
      map.set(t[i]!, count);
    }
  }

  return map.size === 0;
}

console.log(isAnagram("anagram", "nagaram"));
