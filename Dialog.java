package gameXOv2;

import java.util.Scanner;

public class Dialog {

	private static Scanner scanner;

	public static byte getFromConsoleSizeOfArr(byte minSizeOfArr, byte maxSizeOfArr, byte defSizeOfArr) {
		scanner = new Scanner(System.in);
		System.out.println("\nVvedite razmer polya, ot " + minSizeOfArr + " do " + maxSizeOfArr + ":");
		byte vulnFromConsole = scanner.nextByte();
		if ((vulnFromConsole >= minSizeOfArr) && (vulnFromConsole <= maxSizeOfArr)) {
			return vulnFromConsole;
		} else {
			return defSizeOfArr;
		}
	}

	public byte getFromConsoleInputType(byte minTypeOfGame, byte maxTypeOfGame) {
		scanner = new Scanner(System.in);
		System.out.println("\nViberite rezhim: 1. Random vs Random. 2. Person vs Random. 3. Person vs Person ");
		byte vulnFromCons = scanner.nextByte();
		if ((vulnFromCons >= minTypeOfGame) && (vulnFromCons <= maxTypeOfGame)) {
			return vulnFromCons;
		} else {
			return 1;
		}
	}
	
	public static byte[] getFieldFromConsole(byte sizeOfArr) {
		scanner = new Scanner(System.in);
		byte[] arr = new byte[2];
		while (true) {
			System.out.println("\nVvedite stroku, ot 0 do " + sizeOfArr);
			arr[0] = scanner.nextByte();
			System.out.println("\nVvedite stolbec, ot 0 do " + sizeOfArr);
			arr[1] = scanner.nextByte();
			if (((arr[0] > 0) & (arr[1] > 0) & (arr[0] < sizeOfArr) & (arr[1] < sizeOfArr)) && (Field.checkForZero(arr[0], arr[1]) == true)) {
				return arr;
			} else {
				System.out.println("\nUkazannaya vami yacheika uzhe zanyata ili vihodit za pole");
			}
		}
	}

}
