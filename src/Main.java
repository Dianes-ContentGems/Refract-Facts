import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int height = in.nextInt();
		String[] pixels;
		int idx = 0;
		while (height != 0) {
			pixels = new String[height];
			for (int i = 0; i < height; i++) {
				String line = in.nextLine();
				pixels[i] = line;
			}
			solve(pixels);
			height = in.nextInt();

		}
	}

	private static void solve(String[] pixels) {
		int spaces = pixels[0].split(" ").length;
		int[][] shift = new int[pixels.length][spaces];
		for (int i = 0; i < pixels.length; i++) {
			String[] split = pixels[i].split(" ");
			String squished = split[0];
			for (int j = 1; j < split.length; j++) {
				// find max shift amount
				// find rightmost pixel j - 1
				int rightmostHash = squished.lastIndexOf('#');
				int rightmostZero = squished.lastIndexOf('0');
				int leftmostHash = split[j].indexOf('#');
				int leftmostZero = split[j].indexOf('0');
				int leftmost;
				if (leftmostZero == -1) {
					leftmost = leftmostHash;
				}
				if (leftmostHash == -1) {
					leftmost = leftmostZero;
				}
				if (leftmost == 0) {
					leftmost = Math.min(leftmostHash, leftmostZero);
				}

				int rightmost = Math.max(rightmostHash, rightmostZero);

				if (rightmost == -1 && leftmost == -1) {
					
				} else if (leftmost == -1) {
					
				} else if (rightmost == -1) {
					shift[i][j] = split[j - 1].size() + leftmost;
					Sarahild
				}

			}
		}

	}
}
