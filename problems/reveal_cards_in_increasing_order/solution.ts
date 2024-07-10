function deckRevealedIncreasing(deck: number[]): number[] {
  const sim = [...Array(deck.length).keys()];
  const simResult: number[] = [];

  while (sim.length > 0) {
    simResult.push(sim.shift()!!);
    const toBottom = sim.shift();
    if (toBottom) {
      sim.push(toBottom);
    }
  }

  const indexMapping = new Map(
    deck.sort((a, b) => a - b)
      .map((value, index) => [simResult[index], value])
  );

  return Array(deck.length)
    .fill(0)
    .map((_, i) => indexMapping.get(i)!!);
};