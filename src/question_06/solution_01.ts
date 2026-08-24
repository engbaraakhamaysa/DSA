function productExceptSelf(nums: number[]): number[] {
  const map = new Map<number, number[]>();

  let arrResult: number[] = [];
  let result: number = 1;

  for (let i = 0; i < nums.length; i++) {
    let newArr: number[] = [...nums];
    newArr[i] = 1;

    map.set(i, newArr);
  }

  for (let j = 0; j < map.size; j++) {
    const arr = map.get(j);

    for (let i = 0; i < arr!.length; i++) {
      result *= arr![i]!;
    }

    arrResult.push(result);
    result = 1;
  }
  return arrResult;
}
