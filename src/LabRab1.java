import java.util.Scanner;

public class LabRab1 {

    // Узел односвязного списка
    static class Node {
        char data;
        Node next; // свой тип, null или ссылка на следующий узел

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Добавление символа в конец списка
    static Node addLast(Node head, char value) {
        Node newNode = new Node(value);

        if (head == null) {
            return newNode;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        return head;
    }

    // Входит ли символ в набор удаляемых букв
    static boolean contains(String letters, char c) {
        for (int i = 0; i < letters.length(); i++) {
            if (letters.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    // Удаление заданных букв из списка
    static Node removeLetters(Node head, String letters) {

        // Удаляем подходящие элементы из начала списка
        while (head != null && contains(letters, head.data)) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        Node current = head;

        // Обходим оставшийся список
        while (current.next != null) {

            if (contains(letters, current.next.data)) {
                // Исключаем узел из списка
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    // Вывод списка
    static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текст: ");
        String text = scanner.nextLine();

        System.out.print("Введите набор букв для удаления(слитно, без запятых): ");
        String letters = scanner.nextLine();

        Node head = null;

        // Формируем список из символов текста
        for (int i = 0; i < text.length(); i++) {
            head = addLast(head, text.charAt(i));
        }

        head = removeLetters(head, letters);

        System.out.print("Результат: ");
        printList(head);
    }
}
