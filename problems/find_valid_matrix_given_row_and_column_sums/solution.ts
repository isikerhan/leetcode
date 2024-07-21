function restoreMatrix(rowSum: number[], colSum: number[]): number[][] {
  let firstRow = [...colSum];
  let matrix = [firstRow];

  let i = 0;

  rowSum.slice(1).forEach((sum) => {
    if (sum === 0) {
      matrix.push(Array(colSum.length).fill(0));
      return;
    }

    const newRow = Array(i).fill(0);

    while (sum > 0) {
      while (firstRow[i] === 0) {
        if (newRow.length === i) {
          newRow.push(0);
        }
        i++;
      }

      const amount = Math.min(firstRow[i], sum)
      sum -= amount;
      firstRow[i] -= amount;
      newRow.push(amount);
    }

    newRow.push(...Array(colSum.length - newRow.length).fill(0));

    matrix.push(newRow);
  });

  return matrix;
};