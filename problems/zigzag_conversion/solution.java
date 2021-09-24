class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;
        char[][] grid = new char[numRows][(int) Math.ceil((double) s.length() / 2)];
        int x = 0, y = 0;
        boolean down = true;

        for (int i = 0; i < s.length(); i++) {
            grid[y][x] = s.charAt(i);
            if (down) {
                y += 1;
            } else {
                x += 1;
                y -= 1;
            }
            if (down && y == numRows - 1) {
                down = false;
            } else if (!down && y == 0) {
                down = true;
            }
        }
        return Stream.of(grid)
                .map(String::new)
                .map(line -> line.replaceAll("\\x00", ""))
                .collect(Collectors.joining());
    }
}