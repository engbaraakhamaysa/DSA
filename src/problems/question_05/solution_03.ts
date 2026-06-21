function groupAnagrams(strs: string[]): string[][] {
  if (strs.length === 0) {
    return [];
  }

  const ansMap = new Map<string, string[]>();

  const count = new Array(26).fill(0);

  for (const s of strs) {
    count.fill(0);

    for (const c of s) {
      count[c.charCodeAt(0) - "a".charCodeAt(0)]++;
    }

    let key = "";

    for (let i = 0; i < 26; i++) {
      key += "#" + count[i];
    }

    if (!ansMap.has(key)) {
      ansMap.set(key, []);
    }

    ansMap.get(key)!.push(s);
  }

  return Array.from(ansMap.values());
}
