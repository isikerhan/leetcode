function makeSmallestPalindrome(s: string): string {
  const arr = s.split('');

  for (let i = 0; i < arr.length / 2; i++) {
    if (arr[i] !== arr[arr.length - i - 1]) {
      if (arr[i] < arr[arr.length - i - 1]) {
        arr[arr.length - i - 1] = arr[i];
      } else {
        arr[i] = arr[arr.length - i - 1];
      }
    }
  }

  return arr.join('');
};
