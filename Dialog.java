package gameXOv2;

import java.util.Scanner;

public class Dialog {

	private static Scanner scanner;

	public static byte getFromConsoleSizeOfArr(byte minSizeOfArr, byte maxSizeOfArr, byte defSizeOfArr) {
		return getVulnFromConsole(minSizeOfArr, maxSizeOfArr, "\nVvedite razmer polya, ot " + minSizeOfArr + " do " + maxSizeOfArr + ":");
	}

	public byte getFromConsoleInputType(byte minTypeOfGame, byte maxTypeOfGame) {
		return getVulnFromConsole(minTypeOfGame, maxTypeOfGame,"\nViberite rezhim: 1. Random vs Random. 2. Person vs Computer. 3. Person vs Person ");
	}
	
	public static byte[] getFieldFromConsole(byte sizeOfArr) {
		scanner = new Scanner(System.in);
		byte[] arr = new byte[2];
		while (true) {
			arr[0] = getVulnFromConsole((byte) 0,(byte) (sizeOfArr - 1), "\nVvedite stroku, ot 0 do " + (sizeOfArr - 1));
			arr[1] = getVulnFromConsole((byte) 0,(byte) (sizeOfArr - 1), "\nVvedite stolbec, ot 0 do " + (sizeOfArr - 1));
			if (Field.checkForZero(arr[0], arr[1]) == true) {
				return arr;
			} else { 
				System.out.println("\nUkazannaya vami yacheika uzhe zanyata");
			}
		}
	}
	
	public static byte getVulnFromConsole(byte minVuln, byte maxVuln, String str) {
		scanner = new Scanner(System.in);
		byte getVuln;
		System.out.println(str);
		if (scanner.hasNextByte()) {
			getVuln = scanner.nextByte();
			if ((getVuln >= minVuln) && (getVuln <= maxVuln)) {
				return getVuln;
			} else {
				System.out.println("Ne vhodit v dostupni promezhutok znacheni");
			}
		} else {
			System.out.println("Ne podhodit po tipu");
		}
		return getVulnFromConsole(minVuln, maxVuln, str);
	}

}
