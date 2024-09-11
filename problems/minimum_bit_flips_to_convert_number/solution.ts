function minBitFlips(start: number, goal: number): number {
    const startBinaryNoPad = start.toString(2);
    const goalBinaryNoPad = goal.toString(2);
    const len = Math.max(startBinaryNoPad.length, goalBinaryNoPad.length);

    const startBinary = startBinaryNoPad.padStart(len, '0');
    const goalBinary = goalBinaryNoPad.padStart(len, '0');

    return [...Array(len).keys()].map((i) => Number(startBinary[i] !== goalBinary[i])).reduce((a, b) => a + b, 0);
};