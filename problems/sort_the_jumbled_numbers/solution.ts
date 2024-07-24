function sortJumbled(mapping: number[], nums: number[]): number[] {
  return nums.map((num) => ({ num, val: Number(num.toString().split('').map(digit => mapping[Number(digit)]).join('')) }))
    .sort(({ val: val1 }, { val: val2 }) => val1 - val2)
    .map(({ num }) => num);
};