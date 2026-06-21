function romanToInt(s: string): number {
  const values: Record<string, number> = {
    I: 1,
    V: 5,
    X: 10,
    L: 50,
    C: 100,
    D: 500,
    M: 1000,
    IV: 4,
    IX: 9,
    XL: 40,
    XC: 90,
    CD: 400,
    CM: 900,
  };

  let sum = 0;
  let i = 0;

  while (i < s.length) {
    if (i < s.length - 1) {
      const twoSymbols = s.substring(i, i + 2);

      if (twoSymbols in values) {
        sum += values[twoSymbols]!;
        i += 2;
        continue;
      }
    }

    const oneSymbol = s.substring(i, i + 1);
    sum += values[oneSymbol]!;
    i += 1;
  }

  return sum;
}
