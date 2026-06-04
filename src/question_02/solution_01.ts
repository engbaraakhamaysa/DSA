function containsDuplicate(nums: number[]): boolean {
  const boolMap = new Map<number, number>();

  for (let i = 0; i < nums.length; i++) {
    if (boolMap.has(nums[i]!)) {
      return true;
    }

    boolMap.set(nums[i]!, i);
  }
  return false;
}

console.log(containsDuplicate([1, 2, 3, 1]));
