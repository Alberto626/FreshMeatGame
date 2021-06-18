import java.util.Arrays;
public class GridMaps { // when the player selects a map this will run and the map will start up
	private int columns;
	private int rows;
	private char[][] grid;

	public GridMaps(int columns, int rows) {
		this.rows = rows;
		this.columns = columns;
		grid = new char[rows][columns];
		for(int x = 0; grid.length > x; x++) {
			for(int y = 0; grid[x].length > y; y++) {
				grid[x][y] = '_';
			}
		}
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	public char[][] getGrid() {
		return this.grid;
	}
	public void setCharacterAtXY(int c, int r, char image) {
		grid[r][c] = image; // inverted remember
	}
	public void changeChar(int c, int r) {
		grid[r][c] = '_';
	}
	@Override
	public String toString() {
		String rep = "";
		for(int x = 0; grid.length > x; x++) {
			for(int y = 0; grid[x].length > y; y++) {
				rep += "_ ";
			}
			rep += "\n";
		}
		return rep;
	}

}
