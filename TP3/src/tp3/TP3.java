package tp3;
import java.util.Scanner;

public class TP3 {
	
	
	// Exercice 1 : Lire une chaîne de caractères et l’afficher à l’envers.

	public static void exercice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez une chaîne de caractères : ");
		String input = sc.next();
		String reversed = reverseString(input);
		System.out.println("Chaîne à l'envers : " + reversed);   
		sc.close();
	}
	
	public static String reverseString(String str) {
		StringBuilder reversed = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			reversed.append(str.charAt(i));
		}
		return reversed.toString();
	    
	}
	
	
	// Exercice 2 : Lire une chaîne de caractères qui contient un nombre entier en notation binaire, calculer et afficher
	// sa valeur en notation décimale.
	
	public static void exercice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez une chaîne de caractères en notation binaire : ");
		String binaryString = sc.next();
		int decimalValue = binaryToDecimal(binaryString);
		System.out.println("Valeur en notation décimale : " + decimalValue);  
		sc.close();
	}
	
	public static int binaryToDecimal(String binaryString) {
		int decimalValue = 0;
		int binaryLength = binaryString.length();
		for (int i = 0; i < binaryLength; i++) {
			char c = binaryString.charAt(i);
			System.out.println(c);
			if (c == '1') {
				decimalValue += Math.pow(2, binaryLength - i - 1);
			} else if (c != '0') {
				throw new IllegalArgumentException("La chaîne n'est pas en notation binaire");
			}
		}
		return decimalValue;    
	}
	
	// =====================
	// Exercice 3 : Lire une chaîne de caractères, et changer toutes les lettres minuscules en lettres majuscules, et
	// afficher la chaîne de caractères obtenue.
	
	public static void exercice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez une chaîne de caractères : ");
		String input = sc.next();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c >= 'a' && c <= 'z') {
				input = input.replace(c, (char) (c - 'a' + 'A'));
			}
		}
		System.out.println("Chaîne en majuscules : " + input);
		sc.close();
	}

	// =====================
	// Exercice 4 : Lire une chaîne de caractères, et changer toutes les lettres qu'elle contient de telle sorte que l'on
	// obtienne une alternance de minuscules et de majuscules comme dans cet "ExEmPlE".
	
	public static void exercice4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez une chaîne de caractères : ");
        String input = sc.next();
        String alternatedCaseString = alternateCase(input);
        System.out.println("Chaîne avec alternance minuscules/majuscules : " + alternatedCaseString);
        sc.close();
    }
	
	public static String alternateCase(String str) {
        StringBuilder alternatedCaseString = new StringBuilder();
        boolean toUpperCase = true;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
				if (toUpperCase) {
					alternatedCaseString.append((char) (c - 'a' + 'A'));
				} else {
					alternatedCaseString.append((char) (c - 'A' + 'a'));
				}
				toUpperCase = !toUpperCase;
			} else {
				alternatedCaseString.append(c);
			}
		}
		return alternatedCaseString.toString();
    }
    
	// =====================
	// Exercice 5 : Lire un caractère, puis une chaîne de caractères, et afficher le nombre d’occurrences du caractère
	// dans la chaîne de caractères.
    public static void exercice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un caractère : ");
		char character = sc.next().charAt(0);
		System.out.print("Entrez une chaîne de caractères : ");
		String input = sc.next();
		int occurrences = countOccurrences(input, character);
		System.out.println("Nombre d'occurrences du caractère : " + occurrences);
		sc.close();
    	
    }
    
    public static int countOccurrences(String str, char character) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == character) {
                count++;
            }
        }
        return count;
    }

    // =====================
    // Exercice 6 : Lire un caractère c, puis une chaîne de caractères, et afficher la chaîne de caractères lue après avoir
    // ôté de la chaîne de caractères toutes les occurrences du caractère c.
    
    public static void exercice6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez un caractère : ");
        char character = sc.next().charAt(0);
        System.out.print("Entrez une chaîne de caractères : ");
        String input = sc.next();
        String resultString = removeCharacterOccurrences(input, character);
        System.out.println("Chaîne après suppression des occurrences du caractère : " + resultString);
        sc.close();
    }


    public static String removeCharacterOccurrences(String str, char character) {
        return str.replace(String.valueOf(character), "");
    }
    
    // =====================
    // Exercice 7 : Lire deux chaînes de caractères, et trouver la plus longue sous-chaîne 
    // commune à ces deux chaînes sans tenir compte des majuscules et minuscules et compter le nombre d'occurrences de cette sous-chaîne.
    
	public static void exercice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez une chaîne de caractères : ");
		String input1 = sc.next();
		System.out.print("Entrez une autre chaîne de caractères : ");
		String input2 = sc.next();
		String commonSubstring = findCommonSubstring(input1, input2);
		int occurrences = countOccurrences(input1, commonSubstring);
		System.out.println("Sous-chaîne commune : " + commonSubstring);
		System.out.println("Nombre d'occurrences de la sous-chaîne : " + occurrences);
		sc.close();
	}
	
	// Find the longest common substring between two strings without using contains() and substring() methods
	public static String findCommonSubstring(String str1, String str2) {
		int length1 = str1.length();
		int length2 = str2.length();
		int[][] dp = new int[length1 + 1][length2 + 1];
		int maxLength = 0;
		int endIndex = 0;
		for (int i = 1; i <= length1; i++) {
			for (int j = 1; j <= length2; j++) {
				if (Character.toLowerCase(str1.charAt(i - 1)) == Character.toLowerCase(str2.charAt(j - 1))) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if (dp[i][j] > maxLength) {
						maxLength = dp[i][j];
						endIndex = i;
					}
				}
			}
		}
		return str1.substring(endIndex - maxLength, endIndex);
	}
	
	public static int countOccurrences(String str, String substring) {
		int count = 0;
		int index = 0;
		while ((index = str.toLowerCase().indexOf(substring.toLowerCase(), index)) != -1) {
			count++;
			index += substring.length();
		}
		return count;
	}
	
    
	public static void main(String[] args) {
		//exercice2();
		exercice7();    
	}

}



