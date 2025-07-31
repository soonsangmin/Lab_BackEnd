public record Contact(
    int id,
    String name,
    String phone,
    String email,
    String address
) {
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Phone: " + phone +
                ", Email: " + email + ", Address: " + address);
    }
}

