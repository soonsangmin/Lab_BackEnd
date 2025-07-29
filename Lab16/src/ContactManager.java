import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

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

    static void showMenu() {
        System.out.println("\n======== MENU ========");
        System.out.println("1. Hiển thị danh sách liên lạc");
        System.out.println("2. Tìm kiếm liên lạc theo mã liên lạc");
        System.out.println("3. Thêm mới liên lạc");
        System.out.println("4. Sửa thông tin liên lạc");
        System.out.println("5. Xóa thông tin liên lạc");
        System.out.print("=> Mời bạn chọn chức năng [1->5] hoặc nhấn phím khác để thoát: ");
    }

    static void showAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            for (Contact contact : contacts) {
                contact.display();
            }
        }
    }

    static void searchById() {
        System.out.print("Nhập ID liên lạc cần tìm: ");
        int inputId = Integer.parseInt(scanner.nextLine());
        for (Contact contact : contacts) {
            if (contact.getId() == inputId) {
                contact.display();
                return;
            }
        }
        System.out.println("Không tìm thấy liên lạc với ID: " + inputId);
    }

    static void addContact() {
        System.out.print("Nhập ID: ");
        int id = Integer.parseInt(scanner.nextLine());
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

    static void editContact() {
        System.out.print("Nhập ID liên lạc cần sửa: ");
        int inputId = Integer.parseInt(scanner.nextLine());

        for (Contact contact : contacts) {
            if (contact.getId() == inputId) {
                System.out.print("Nhập tên mới: ");
                contact.setName(scanner.nextLine());
                System.out.print("Nhập số điện thoại mới: ");
                contact.setPhone(scanner.nextLine());
                System.out.print("Nhập email mới: ");
                contact.setEmail(scanner.nextLine());
                System.out.print("Nhập địa chỉ mới: ");
                contact.setAddress(scanner.nextLine());
                System.out.println("Đã cập nhật thông tin.");
                return;
            }
        }
        System.out.println("Không tìm thấy liên lạc với ID: " + inputId);
    }

    static void deleteContact() {
        System.out.print("Nhập ID liên lạc cần xóa: ");
        int inputId = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId() == inputId) {
                contacts.remove(i);
                System.out.println("Đã xóa liên lạc.");
                return;
            }
        }
        System.out.println("Không tìm thấy liên lạc với ID: " + inputId);
    }
}
