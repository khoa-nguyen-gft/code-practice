package challenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Client {

	public static void main(String[] args) {

		System.out.println(Challenge.gcd(18, 153));
	}
}

class Challenge {
	
	public static int gcd(int a, int b) {
		int min = a > b ? b : a;
		
		for (int i = min; i >= 1; i--) {
			if( a % i == 0 && b % i == 0)
				return i;
		}
		
		return 1;
    }
	
	
	  public static boolean rectangleInCircle(int w, int h, int radius) {
		  return Math.pow(w, 2) + Math.pow(h, 2) == Math.pow(2 * radius, 2);
	  }
	  
	  

	public static int primeNumbers(int num) {
		int[] array = IntStream.range(2, num).filter(i ->i%2 != 0).toArray();
		
		System.out.println(Arrays.toString(array));
		
		return 0;
	}
	
	
	public static boolean almostPalindrome(String str) {
		
		int count = 0;
		
		for(int i = 0 ; i <= Math.floor(str.length()/2); i ++) {
			if(str.charAt(i) != str.charAt(str.length() -1 - i)) {
				count++; 
			}
		}
		
		
		return (count == 1);
	}

	public static String rev(int n) {

		List<String> asList = Arrays.asList(String.valueOf(n).replaceAll("-", "").split(""));
		Collections.reverse(asList);

		System.out.println(String.join("", asList));
		return null;
	}

	public static String move(String word) {
		return word.chars().mapToObj(ch -> String.valueOf((char) ((int) ch + 1))).reduce("", (a, b) -> a + b);
	}

	public static int minutesToSeconds(String tm) {

		if (Integer.valueOf(tm.split(":")[1]) >= 60)
			return -1;
		return Stream.of(tm.split(":")).mapToInt(Integer::valueOf).reduce(0, (a, b) -> a * 60 + b);

	}

	public static String textToNum(String phone) {
		return phone.replaceAll("[ABC]", "2").replaceAll("[DEF]", "3").replaceAll("[GHI]", "4").replaceAll("[JKL]", "5")
				.replaceAll("[MNO]", "6").replaceAll("[PQRS]", "7").replaceAll("[TUV]", "8").replaceAll("[WXYZ]", "9");
	}

	public static Object[][] multiply(Object[] items) {

		Object[][] result = new Object[items.length][items.length];

		IntStream.range(0, items.length).forEach(i -> {
			Arrays.fill(result[i], items[i]);
		});

		for (int j = 0; j < result.length; j++) {
			Object[] objects = result[j];
			System.out.println(Arrays.toString(objects));
		}

		return result;
	}

	public static String inatorInator(String inv) {

		boolean match = Arrays.stream(new String[] { "a", "e", "o", "u", "i" })
				.anyMatch(item -> item.equals(String.valueOf(inv.charAt(inv.length() - 1)).toLowerCase()));

		String result = String.format("%s%sinator %d000", inv, match == true ? "-" : "", inv.length());

		System.out.println(result);
		return result;

	}

	public static boolean pagesInBook(int total) {
		return IntStream.range(1, total / 2).filter(i -> i * (i + 1) == total * 2).toArray().length == 1 ? true : false;
	}

	public static boolean checkPerfect(int num) {

		int result = 0;
		int p = 2;

		while (result <= num) {
			if (result == num)
				return true;

			if (result > num)
				return false;

			result = (int) (Math.pow(2, p - 1) * (Math.pow(2, p) - 1));
			p++;
		}

		return false;
	}

	public static double totalDistance(double fuel, double fuelUsage, int passengers, boolean airConditioner) {

		double airFuel = airConditioner == true ? fuel * 0.1 : 0.0;

		double result = (fuel) / ((fuelUsage + fuelUsage * (passengers * 0.05)) * (airConditioner == true ? 1.1 : 1))
				* 100;

		System.out.println("airFuel: " + airFuel);
		System.out.println(result);

		return result;
	}

	public static int emptySq(int step) {
		return (int) Math.pow((step * 2 - 1), 2) - 1;

	}

	public static String toHex(String str) {
		return str.chars().mapToObj(s -> Integer.toHexString((int) s).toUpperCase()).collect(Collectors.joining(" "));
	}

	public static int[] numberSplit(int n) {

		int[] result = null;

		if (n % 2 == 0) {
			result = new int[] { n / 2, n / 2 };
		} else {
			if (n > 0) {
				result = new int[] { (int) Math.floor(n / 2), (int) Math.floor(n / 2) + 1 };
			} else {
				result = new int[] { (int) Math.floor(n / 2) - 1, (int) Math.floor(n / 2) };

			}
		}

		System.out.println(Arrays.toString(result));
		return result;
	}

	public static int[] factorize(int num) {
		return IntStream.range(1, num + 1).filter(i -> num % i == 0).toArray();
	}

	public static Object[] clone(Object[] arr) {

		Object[] result = Arrays.copyOf(arr, arr.length + 1);

		result[result.length - 1] = arr;

		return result;
	}

	public static int quadraticEquation(int a, int b, int c) {
		int result = (int) ((-1 * b) + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
		System.out.println(result);
		return result;
	}

	public static String rps(String s1, String s2) {
		String rock = "rock";
		String paper = "paper";
		String scissors = "scissors";
		String message = "Player %d wins";
		if (s1.equals(s2))
			return "TIE";

		if (paper.equals(s1) && rock.equals(s2) || rock.equals(s1) && scissors.equals(s2)
				|| scissors.equals(s1) && paper.equals(s2)) {
			return String.format(message, 1);
		}

		return String.format(message, 2);

	}

	public static int warOfNumbers(int[] numbers) {

		Arrays.stream(numbers).reduce(0, (a, b) -> {
			System.out.println(b);

			System.out.println(b & 1);
			return 0;
		});

		int even = Arrays.stream(numbers).filter(i -> i % 2 == 0).sum();
		int odd = Arrays.stream(numbers).filter(i -> i % 2 != 0).sum();
		return Math.abs(even - odd);
	}

	public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
		return ((Math.min(Math.min(a, b), c) <= Math.min(w, h)) && (Math.min(Math.max(a, b), c) <= Math.max(w, h)));
	}

	public static String gradePercentage(String userScore, String passScore) {
		String result = Integer.valueOf(userScore.replace("%", "")) >= Integer.valueOf(passScore.replace("%", ""))
				? "PASSED"
				: "FAILED";
		return String.format("You %s the Exam", result);
	}

	public static int solutions(int a, int b, int c) {
		HashSet<Double> result = new HashSet<Double>();

		Double r1 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
		if (!r1.isNaN()) {
			result.add(r1);
		}
		Double r2 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
		if (!r1.isNaN()) {
			result.add(r2);
		}

		System.out.println(result.size());

		return result.size();
	}
}

class LeftShift {
	public static int shiftToLeft(int x, int y) {
		return (int) (x * Math.pow(2, y));
	}
}

class Program {
	public static boolean isInOrder(String str) {
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return (new String(arr)).equals(str);
	}
}

class HighestDigit {
	public static int highestDigit(int n) {

		Stream.of(String.valueOf(n).split("")).mapToInt(Integer::parseInt).max().getAsInt();
		return Arrays.stream(String.valueOf(n).split("")).mapToInt(x -> Integer.valueOf(x).intValue()).max().getAsInt();
	}
}

class SideLengths {
	public static double[] otherSides(int n) {
		return new double[] { 2 * n, n * Math.sqrt(3) };
	}
}

class DirectoryPath {
	public static String getFilename(String path) {
		String[] strings = path.split("/");
		return strings[strings.length - 1];
	}
}