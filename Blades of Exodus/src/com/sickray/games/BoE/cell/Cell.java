package com.sickray.games.BoE.cell;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Cell {
	int CellCount;
	int CellX, CellY;
	int height, width;
	int cellsize;

	public Cell(int height, int width, int cellsize) {
		this.height = height;
		this.width = width;
		this.cellsize = cellsize;
		CellX = width / cellsize;
		CellY = height / cellsize;
		CellCount = CellX * CellY;
	}

	public int getCellX() {
		return CellX;
	}

	public int getCellY() {
		return CellX;
	}

	public int getCellCount() {
		return CellCount;
	}

	public int addCellX(int cellX) {
		return cellX * cellsize;
	}

	public int addCellY(int cellY) {
		return cellY * cellsize;
	}

	public Dimension addCells(int cellX, int cellY) {
		return new Dimension(cellX * cellsize, cellY * cellsize);
	}

	public void render(Graphics g) {
		int e = -1;
		for (int x = 0; x != CellX; x++) {
			for (int y = 0; y != CellY; y++) {
				e++;
				g.drawRect(x * cellsize, y * cellsize, cellsize, cellsize);

				g.drawString("" + e, x * cellsize, y * cellsize);
				g.setColor(Color.green);

			}

		}

	}

}
