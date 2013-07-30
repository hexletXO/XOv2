package gameXOv2;

public class Main {

	private static final byte MAXSIZEOFARR = 10;

	private static final byte MINSIZEOFARR = 3;
	
	private static final byte DEFSIZEOFARR = 3;
	
	private final static byte CLEARARRBYZERO = 0;
	
	private static byte MINTYPEOFGAME = 1;

	private static byte MAXTYPEOFGAME = 3;

	private static byte inputType;

	private static byte valueForField;

	private static byte[] arr = new byte[2];

	public static void main(String[] args) {

		Dialog gameDialog = new Dialog();

		Field gameField = new Field(Dialog.getFromConsoleSizeOfArr(MINSIZEOFARR, MAXSIZEOFARR, DEFSIZEOFARR));

		inputType = gameDialog.getFromConsoleInputType(MINTYPEOFGAME, MAXTYPEOFGAME);

		gameField.initArrBy(CLEARARRBYZERO);

		gameField.showFields();

		for (int e = 1; e < ((gameField.getSizeOfArr() * gameField.getSizeOfArr()) + 1); e++) {

			if ((e % 2) == 0) {
				
				valueForField = 1;
				
				if (inputType == 1) {
				
					arr = gameField.getFieldFromRandom();
					
				}	
				
				if (inputType == 2) {
					
					arr = gameField.getFieldForWin(valueForField);
					
				}
				
				if (inputType == 3) {
					
					arr = Dialog.getFieldFromConsole(gameField.getSizeOfArr());
					
				}
				
			} else {
				
				valueForField = -1;
				
				if (inputType == 1) {
					
					arr = gameField.getFieldFromRandom();
					
				}
				
				if (inputType == 2) {
					
					arr = Dialog.getFieldFromConsole(gameField.getSizeOfArr());
					
				}
				
				if (inputType == 3) {
					
					arr = Dialog.getFieldFromConsole(gameField.getSizeOfArr());
					
				}
				
			}

			gameField.setFieldBy(arr[0], arr[1], valueForField);
			
			gameField.showFields();
			
			if (gameField.checkForWin() == true) {
				
				System.out.println("\nSomeone WIN");
				
				System.exit(0);
				
			}

		}

	}

}