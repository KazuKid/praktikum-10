import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phone {
    private boolean isOn;
    private int pulsa;
    private List<String> kontak;

    public Phone() {
        isOn = false;
        pulsa = 0;
        kontak = new ArrayList<>();
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Ponsel telah dinyalakan.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Ponsel telah dimatikan.");
    }

    public void checkPower() {
        if (isOn) {
            System.out.println("Ponsel sedang menyala.");
        } else {
            System.out.println("Ponsel sedang mati.");
        }
    }

    public void topUpPulsa(int amount) {
        if (isOn) {
            pulsa += amount;
            System.out.println("Pulsa berhasil diisi sebesar " + amount + ".");
        } else {
            System.out.println("Ponsel sedang mati. Nyalakan ponsel terlebih dahulu.");
        }
    }

    public void checkPulsa() {
        if (isOn) {
            System.out.println("Sisa pulsa Anda adalah " + pulsa + ".");
        } else {
            System.out.println("Ponsel sedang mati. Nyalakan ponsel terlebih dahulu.");
        }
    }

    public void addContact(String name, String number) {
        if (isOn) {
            kontak.add(name + ": " + number);
            System.out.println("Kontak berhasil ditambahkan.");
        } else {
            System.out.println("Ponsel sedang mati. Nyalakan ponsel terlebih dahulu.");
        }
    }

    public void viewContacts() {
        if (isOn) {
            if (kontak.isEmpty()) {
                System.out.println("Kontak kosong.");
            } else {
                System.out.println("Daftar Kontak:");
                for (String contact : kontak) {
                    System.out.println(contact);
                }
            }
        } else {
            System.out.println("Ponsel sedang mati. Nyalakan ponsel terlebih dahulu.");
        }
    }

    public void searchContact(String name) {
        if (isOn) {
            boolean found = false;
            for (String contact : kontak) {
                if (contact.toLowerCase().contains(name.toLowerCase())) {
                    System.out.println("Kontak ditemukan: " + contact);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Kontak dengan nama '" + name + "' tidak ditemukan.");
            }
        } else {
            System.out.println("Ponsel sedang mati. Nyalakan ponsel terlebih dahulu.");
        }
    }

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.turnOn();
        phone.checkPower();

        phone.topUpPulsa(50000);
        phone.checkPulsa();

        phone.addContact("John", "1234567890");
        phone.addContact("Jane", "0987654321");
        phone.viewContacts();

        phone.searchContact("John");
        phone.searchContact("Alice");

        phone.turnOff();
        phone.checkPower();
    }
}
