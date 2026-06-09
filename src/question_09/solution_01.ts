function isAlienSorted(words: string[], order: string): boolean {
  const orderMap = new Map<string, number>();

  for (let i = 0; i < order.length; i++) {
    orderMap.set(order[i]!, i);
  }

  for (let i = 0; i < words.length - 1; i++) {
    for (let j = 0; j < words[i]!.length; j++) {
      if (j >= words[i + 1]!.length) {
        return false;
      }

      if (words[i]![j] !== words[i + 1]![j]) {
        const currentLetter = orderMap.get(words[i]![j]!)!;
        const nextLetter = orderMap.get(words[i + 1]![j]!)!;

        if (nextLetter < currentLetter) {
          return false;
        } else {
          break;
        }
      }
    }
  }

  return true;
}
