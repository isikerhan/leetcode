function sortPeople(names: string[], heights: number[]): string[] {
  return [...names.keys()]
    .map((i) => ({ name: names[i], height: heights[i] }))
    .sort(({ height: h1 }, { height: h2 }) => h2 - h1)
    .map(({ name }) => name);
};
