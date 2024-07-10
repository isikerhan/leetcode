function minOperations(logs: string[]): number {
  let depth = 0;

  logs.forEach((log) => {
    switch (log) {
      case './':
        break;
      case '../':
        depth = Math.max(depth - 1, 0);
        break;
      default:
        depth++;
        break;
    }
  });

  return depth;
};
