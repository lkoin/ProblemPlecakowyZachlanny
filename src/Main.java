import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Algorytm plecakowy ogolny");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe rodzajow pakowanych rzeczy");
        int size = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Wpisz kolejny element tablicy wartosci potem tablicy wage");
        int[] valueArray = new int[size];
        int[] weightArray = new int[size];

        for (int i=0;i<size;i++) {
            valueArray[i] = scanner.nextInt();
            weightArray[i] = scanner.nextInt();
        }
        sortArrays(valueArray,weightArray);
        for (int i = 0; i<size;i++) System.out.print(valueArray[i]+",");
        System.out.println();
        for (int i = 0; i<size;i++) System.out.print(weightArray[i]+",");
        System.out.println();
        System.out.println("Podaj wage plecaka");
        int weight = scanner.nextInt();
        int[] numberOfUsedProducts = new int[size];
        int value = packBackpack(valueArray,weightArray,weight,numberOfUsedProducts);
        System.out.println("Wartosc plecaka to: " + value);
        System.out.println("Ilosc kolejnych elementow w plecaku");
        for (int i = 0; i<size;i++) System.out.print(numberOfUsedProducts[i]+",");

    }
    public static int packBackpack(int[] valueArray,int[] weightArray,int weight,int[] numberOfUsedProducts) {
        int size = valueArray.length;
        int result = 0;


        for (int i=0; i < size  ; i++) {
            numberOfUsedProducts[i] = Math.min(weight/weightArray[i],1);
            weight-= numberOfUsedProducts[i]*weightArray[i];
            result += numberOfUsedProducts[i] * valueArray[i];
        }
        return result;
    }

    public static void sortArrays(int[] valueArray,int[]weightArray) {
        int size = valueArray.length;
        int valueTemp;
        int weightTemp;

        for (int i =0; i < size; i++ ) {
            valueTemp = valueArray[i];
            weightTemp = weightArray[i];
            for (int j = i -1;j>=0;j--) {
                if (((double)valueArray[j]/weightArray[j]) < ((double) valueTemp /weightTemp)) {
                    valueArray[j+1] = valueArray[j];
                    weightArray[j+1] = weightArray[j];
                    valueArray[j] = valueTemp;
                    weightArray[j] = weightTemp;
                }
            }
        }
    }
}