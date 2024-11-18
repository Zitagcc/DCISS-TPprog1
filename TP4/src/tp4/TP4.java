package tp4;

import java.util.Arrays;

public class TP4 {
	
	public static void main(String[] args) {
		
		int[] tab = {2,3,1,2,3};//nouveauTab(5,2,10);
		
		//changerValeurs(tab,11);
		
		String d = tabEnChaine2(tab);
		
		System.out.println(d);
		/*
		 * for(int i=0;i<tab.length;i++) { System.out.println(tab[i]); }
		 */
		
    }

    public static int[] nouveauTab(int taille, int vMin, int vMax) {
        int[] tab = new int[taille];
        for (int i = 0; i < taille; i++) {
            tab[i] = (int) (Math.random() * (vMax - vMin + 1)) + vMin;
        }
        return tab;
    }

    public static String tabEnChaine(int[] tab) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < tab.length; i++) {
            sb.append(tab[i]);
            if (i < tab.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static String tabEnChaine2(int[] tab) {
    	
    	String str = "[";
    	
		for (int i = 0; i < tab.length; i++) {
			str += tab[i];
			if (i < tab.length - 1) {
				str += ",";
			}
		}
		
		str += "]";
		
		return str;
    }

    public static void changerValeurs(int[] tab, int val) {
        for (int i = 0; i < tab.length; i++) {
            tab[i] = val;
        }
    }

    public void incrValeurs(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            tab[i]++;
        }
    }

    public int sommeValeurs(int[] tab) {
        int sum = 0;
        for (int value : tab) {
            sum += value;
        }
        return sum;
    }

    public double ratioPairs(int[] tab) {
        int countPairs = 0;
        for (int value : tab) {
            if (value % 2 == 0) {
                countPairs++;
            }
        }
        return ((double) countPairs / tab.length) * 100.0;
    }
    
    // public static int maxValue(int[] tab) qui retourne la valeur maximale
    // présente dans tab. On suppose que tab a une taille supérieure ou égale à 1.
    
	public static int maxValue(int[] tab) {
		int max = tab[0];
		for (int i = 1; i < tab.length; i++) {
			if (tab[i] > max) {
				max = tab[i];
			}
		}
		return max;
	}
	
	// public static boolean appartient(int val, int[] tab) qui retourne
	// true si et seulement si val est un élément de tab.
	public static boolean appartient(int val, int[] tab) {
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == val) {
				return true;
			}
		}
		return false;
	}
	
	// public static boolean estTrie(int[] tab) qui retourne true si et
	//seulement si les éléments de tab sont triés dans l'ordre croissant. On suppose que tab a une
	//taille supérieure ou égale à 1.
	
	public static boolean estTrie(int[] tab) {
		for (int i = 1; i < tab.length; i++) {
			if (tab[i] < tab[i - 1]) {
				return false;
			}
		}
		return true;
	}
	
	// public static boolean tousEgaux(int[] tab) qui retourne true si et
	// seulement si les éléments de tab sont tous égaux. On suppose que tab a une taille
	// supérieure ou égale à 1.
	
	public static boolean tousEgaux(int[] tab) {
		for (int i = 1; i < tab.length; i++) {
			if (tab[i] != tab[i - 1]) {
				return false;
			}
		}
		return true;
	}
	
	// public static void inverse(int[] tab) qui inverse l'ordre des éléments dans
	// tab.
	public static void inverse(int[] tab) {
		for (int i = 0; i < tab.length / 2; i++) {
			int temp = tab[i];
			tab[i] = tab[tab.length - 1 - i];
			tab[tab.length - 1 - i] = temp;
		}
	}
}
