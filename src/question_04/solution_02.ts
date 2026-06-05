function isAnagram(s: string, t: string): boolean {
  if (s.length !== t.length) {
    return false;
  }

  const charCounts: number[] = new Array(26).fill(0);

  for (let i = 0; i < s.length; i++) {
    charCounts[s.charCodeAt(i) - 97]!++; // 'a' = 97
    charCounts[t.charCodeAt(i) - 97]!--;
  }

  for (const count of charCounts) {
    if (count !== 0) {
      return false;
    }
  }

  return true;
}
