package gameXOv2;

import java.util.Scanner;

public class Dialog {

	private static Scanner scanner;

	public static byte getFromConsoleSizeOfArr(byte minSizeOfArr, byte maxSizeOfArr, byte defSizeOfArr) {
		System.out.println("\nVvedite razmer polya, ot " + minSizeOfArr + " do " + maxSizeOfArr + ":");
		return getVulnFromConsole(minSizeOfArr,maxSizeOfArr);
	}

	public byte getFromConsoleInputType(byte minTypeOfGame, byte maxTypeOfGame) {
		System.out.println("\nViberite rezhim: 1. Random vs Random. 2. Person vs Random. 3. Person vs Person ");
		return getVulnFromConsole(minTypeOfGame, maxTypeOfGame);
	}
	
	public static byte[] getFieldFromConsole(byte sizeOfArr) {
		scanner = new Scanner(System.in);
		byte[] arr = new byte[2];
		while (true) {
			System.out.println("\nVvedite stroku, ot 0 do " + sizeOfArr);
			arr[0] = getVulnFromConsole((byte) 0, sizeOfArr);
			System.out.println("\nVvedite stolbec, ot 0 do " + sizeOfArr);
			arr[1] = getVulnFromConsole((byte) 0, sizeOfArr);
			if (Field.checkForZero(arr[0], arr[1]) == true) {
				return arr;
			} else {
				System.out.println("\nUkazannaya vami yacheika uzhe zanyata");
			}
		}
	}
	
	public static byte getVulnFromConsole(byte minVuln, byte maxVuln) {
		scanner = new Scanner(System.in);
		byte getVuln;
		if (scanner.hasNextByte()) {
			getVuln = scanner.nextByte();
			if ((getVuln >= minVuln) && (getVuln <= maxVuln)) {
				return getVuln;
			} else {
				System.out.println("Ne vhodit v dostupni promezhutok znacheni");
				getVulnFromConsole(minVuln, maxVuln);
			}
		} else {
			System.out.println("Ne podhodit po tipu");
			getVulnFromConsole(minVuln, maxVuln);
		}
		return 1;
	}

}
