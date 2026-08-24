function romanToInt(s: string): number {
  const romanMap = new Map<string, number>([
    ["I", 1],
    ["V", 5],
    ["X", 10],
    ["L", 50],
    ["C", 100],
    ["D", 500],
    ["M", 1000],
  ]);

  let sum = 0;
  let n = 0;

  for (let i = 0; i < s.length; i++) {
    const current = romanMap.get(s.charAt(i))!;

    if (current > n) {
      sum -= n;
      n = current;
    } else {
      sum += n;
      n = current;
    }
  }

  sum += n;

  return sum;
}
