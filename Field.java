package gameXOv2;

public class Field {
	
	private static final byte DEFSIZEOFARR = 3;

	private final byte sizeOfArr;

	private static byte[][] field;

	public Field() {
		this(DEFSIZEOFARR);
	}

	public Field(byte sizeIn) {
		sizeOfArr = (byte) (sizeIn);
		field = new byte[sizeOfArr][sizeOfArr];
	}

	public void initArrBy(byte i) {
		for (int j = 0; j < sizeOfArr; j++) {
			for (int k = 0; k < sizeOfArr; k++) {
				field[j][k] = i;
			}
		}
	}
	
	public void showFields() {		
		System.out.print("   ");
		for (int p = 0; p < sizeOfArr; p++) {
			System.out.print(p +"  ");
			}
		System.out.println();
		for (int i = 0; i < sizeOfArr; i++) {
			System.out.print(i +" ");
			showLine(i);
			System.out.println();
		}
	}
	
	private void showLine(int i){
		for (int p = 0; p < sizeOfArr; p++) {
			System.out.print("[");
			if (field[i][p] == -1) {
				System.out.print("O");				
				} else {
					if (field[i][p] == 0) {
						System.out.print(" ");
					} else {
						if (field[i][p] == 1) {
							System.out.print("X");
						}
					}
				}
			System.out.print("]");
		}
	}
	
	public void setFieldBy (byte coll, byte row, byte valueForField) {
		field[coll][row] = valueForField;
	}
	
	public byte getSizeOfArr() {
		return sizeOfArr;
	}
	
	public static boolean checkForZero(byte x, byte y) {
		if (field[x][y] == 0) {
			return true;
		} else {
			return false;
		}

	}
	
	public byte[] getFieldFromRandom() {
		byte[] arr = new byte[2];
		while (true) {
			arr[0] = (byte) (Math.random() * (sizeOfArr));
			arr[1] = (byte) (Math.random() * (sizeOfArr));
			if (checkForZero(arr[0],arr[1]) == true) {
				return arr;
			} 
		}
	}
	
	private boolean checkOut(byte coll, byte row) {
		byte sumcoll;
		byte sumrow;
		byte diag = 0;
		byte revDiag = 0;
		for (byte i = (byte) (coll - 1); i < (byte) (coll + 2); i++) {
			sumcoll = 0;
			sumrow = 0;
			for (byte j = (byte) (row - 1); j < (byte) (row + 2); j++) {
				
				sumcoll += field[i][j];
				sumrow += field[j][i];
				
				if (i == j) {
					diag += field[i][j];
				}
				
				if (((i == coll - 1) && (j == row + 1)) || ((i == coll) && (j == row)) || ((i == coll + 1) && (j == row - 1))) {
					revDiag += field[i][j];
				}
				
				if ((Math.abs(sumcoll) == 3) || (Math.abs(sumrow) == 3) || (Math.abs(diag) == 3) || (Math.abs(revDiag) == 3)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean checkForWin() {
		for (byte coll = 1; coll < (sizeOfArr - 1); coll++) {
			for (byte row = 1; row < (sizeOfArr - 1); row++) {
				if (checkOut(coll, row) == true) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	// AI block
	
	private boolean checkFieldForWin(byte coll, byte row, byte vuln) {
		if (checkForZero(coll, row) == false) {
			return false;
		}
		field[coll][row] = vuln;
		if (checkForWin() == true) {
			field[coll][row] = 0; return true;
		}
		field[coll][row] = 0;
		return false;
	}
	
	public byte[] getFieldForWin(byte vuln) {
		byte[] arr = new byte[2];
		byte reverseVuln = -1;
		for (byte i = 1; i < sizeOfArr; i++) {
			for (byte j = 1; j < sizeOfArr; j++) {
				if (checkFieldForWin(i,j,vuln) == true) {
					arr[0] = i;
					arr[1] = j;
					return arr;
				} else {
					if (checkFieldForWin(i,j,(byte) (vuln * reverseVuln)) == true) {
						arr[0] = i;
						arr[1] = j;
						return arr;
					}
				}
			}
		}
		
		return getFieldFromRandom();
	}
	
}
