import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
        int size = 10;
        System.out.print("Введите модификатор: ");
        int input = new Scanner(System.in).nextInt();
        // число = сумма индекса и модификатора
        ArrayList array = getFilledArray(size, input,
                (Integer::sum));
        System.out.println(array);
        // число = произведение индекса и модификатора
        array = getFilledArray(size, input,
                ((index, modifier) -> index * modifier));
        System.out.println(array);
        // число = для чётного индекса <(разделить на 2) плюс модификатор>,
        // для нечётного <(квадрат индекса) минус модификатор>
        array = getFilledArray(size, input,
                ((index, modifier) -> {
                    if (index % 2 == 0) {
                        return index / 2 + modifier;
                    } else {
                        return index * index - modifier;
                    }
                }));
        System.out.println(array);
        // число = сумма квадратов индекса и модификатора
        array = getFilledArray(size, input,
                ((index, modifier) -> index * index + modifier * modifier));
        System.out.println(array);
        // число = остаток от деления индекса на модификатор
        array = getFilledArray(size, input,
                ((index, modifier) -> index % modifier));
        System.out.println(array);
    }

    public static ArrayList getFilledArray(final int size, final int modifier, final Matrix m) {
        ArrayList<Integer> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(m.process(i, modifier));
        }
        return arrayList;
    }
}
