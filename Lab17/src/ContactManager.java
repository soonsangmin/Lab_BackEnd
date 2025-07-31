import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    showAllContacts();
                    break;
                case "2":
                    searchById();
                    break;
                case "3":
                    addContact();
                    break;
                case "4":
                    editContact();
                    break;
                case "5":
                    deleteContact();
                    break;
                default:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    return;
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n======== MENU QUẢN LÝ DANH BẠ ========");
        System.out.println("1. Hiển thị danh sách liên lạc");
        System.out.println("2. Tìm kiếm liên lạc theo mã liên lạc");
        System.out.println("3. Thêm mới liên lạc");
        System.out.println("4. Sửa thông tin liên lạc");
        System.out.println("5. Xóa thông tin liên lạc");
        System.out.print("=> Mời bạn chọn chức năng [1->5] hoặc nhấn phím khác để thoát: ");
    }

    private static void showAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            for (Contact contact : contacts) {
                contact.display();
            }
        }
    }

    private static void searchById() {
        System.out.print("Nhập ID liên lạc cần tìm: ");
        int inputId = parseIntInput();
        for (Contact contact : contacts) {
            if (contact.id() == inputId) {
                contact.display();
                return;
            }
        }
        System.out.println("Không tìm thấy liên lạc với ID: " + inputId);
    }

    private static void addContact() {
        System.out.print("Nhập ID: ");
        int id = parseIntInput();
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();

        contacts.add(new Contact(id, name, phone, email, address));
        System.out.println("Đã thêm liên lạc thành công.");
    }

    private static void editContact() {
        System.out.print("Nhập ID liên lạc cần sửa: ");
        int inputId = parseIntInput();

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.id() == inputId) {
                System.out.print("Nhập tên mới: ");
                String name = scanner.nextLine();
                System.out.print("Nhập số điện thoại mới: ");
                String phone = scanner.nextLine();
                System.out.print("Nhập email mới: ");
                String email = scanner.nextLine();
                System.out.print("Nhập địa chỉ mới: ");
                String address = scanner.nextLine();

                Contact updatedContact = new Contact(inputId, name, phone, email, address);
                contacts.set(i, updatedContact);
                System.out.println("Đã cập nhật thông tin.");
                return;
            }
        }
        System.out.println("Không tìm thấy liên lạc với ID: " + inputId);
    }

    private static void deleteContact() {
        System.out.print("Nhập ID liên lạc cần xóa: ");
        int inputId = parseIntInput();

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).id() == inputId) {
                contacts.remove(i);
                System.out.println("Đã xóa liên lạc.");
                return;
            }
        }
        System.out.println("Không tìm thấy liên lạc với ID: " + inputId);
    }

    private static int parseIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.print("Vui lòng nhập số nguyên hợp lệ: ");
            }
        }
    }
}
