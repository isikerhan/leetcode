function canBeEqual(target: number[], arr: number[]): boolean {
  const targetOccurrences = target.reduce((map, num) => map.set(num, (map.get(num) ?? 0) + 1), new Map<number, number>());
  const arrOccurrences = arr.reduce((map, num) => map.set(num, (map.get(num) ?? 0) + 1), new Map<number, number>());

  return [...targetOccurrences.entries()].every(([number, numOfOccurrence]) => numOfOccurrence === arrOccurrences.get(number));
};
