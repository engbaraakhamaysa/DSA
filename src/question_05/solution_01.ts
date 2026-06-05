function groupAnagrams(strs: string[]): string[][] {
  const arr: string[][] = [];

  const visited: boolean[] = new Array(strs.length).fill(false);

  for (let i = 0; i < strs.length; i++) {
    if (visited[i]) continue;

    const group: string[] = [];
    group.push(strs[i]!);
    visited[i] = true;

    for (let k = i + 1; k < strs.length; k++) {
      if (strs[i]!.length !== strs[k]!.length) continue;

      const charCounts: number[] = new Array(26).fill(0);

      for (let j = 0; j < strs[i]!.length; j++) {
        charCounts[strs[i]!.charCodeAt(j) - 97]!++;
        charCounts[strs[k]!.charCodeAt(j) - 97]!--;
      }

      let isZero = true;

      for (const count of charCounts) {
        if (count !== 0) {
          isZero = false;
          break;
        }
      }

      if (isZero) {
        group.push(strs[k]!);
        visited[k] = true;
      }
    }

    arr.push(group);
  }

  return arr;
}
