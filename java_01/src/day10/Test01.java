package day10;

public class Test01 {

	public static void main(String[] args) {
		System.out.println("java progRamING".equals("java progRamING"));                    // true
		System.out.println("java progRamING".equals("JAVA progRamING"));                    // false
		System.out.println("java progRamING".equalsIgnoreCase("JAVA progRamING"));          // true
		System.out.println("java progRamING".equalsIgnoreCase("JAVA"));                     // false
		System.out.println("java progRamING".equalsIgnoreCase("java"));                     // false
		System.out.println("java progRamING".contains("JAVA"));                             // false
		System.out.println("java progRamING".toLowerCase().contains("JAVA"));               // false
		System.out.println("java progRamING".toLowerCase().contains("JAVA".toLowerCase())); // true

	}

}
