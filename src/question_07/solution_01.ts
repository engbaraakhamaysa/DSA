function topKFrequent(nums: number[], k: number): number[] {
  const map = new Map<number, number>();

  for (const num of nums) {
    map.set(num, (map.get(num) ?? 0) + 1);
  }

  const arr: [number, number][] = Array.from(map.entries());

  arr.sort((a, b) => b[1] - a[1]);

  const result: number[] = [];

  for (let i = 0; i < k; i++) {
    result.push(arr[i]![0]);
  }

  return result;
}
