import java.util.Scanner;

class Mahasiswa {
    private String nama;
    private String nim;
    private double nilai;

    public Mahasiswa(String nama, String nim, double nilai) {
        this.nama = nama;
        this.nim = nim;
        this.nilai = nilai;
    }

    public void tampilkanData() {
        System.out.println("------------------------------------");
        System.out.println("Nama  : " + nama);
        System.out.println("NIM   : " + nim);
        System.out.printf("Nilai : %.2f%n", nilai);
        cekKelulusan();
    }

    public void cekKelulusan() {
        if (nilai >= 60) {
            System.out.println("Status: LULUS");
        } else {
            System.out.println("Status: TIDAK LULUS");
        }
    }
}

/*
 * Jalankan file ini sebagai Main.java.
 * Perintah:
 *   javac Main.java
 *   java Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] daftarNama = {
            "Alip",
            "Kodap",
            "Joko",
            "Wowo",
            "Mahasiswa Tambahan"
        };
        Mahasiswa[] daftarMahasiswa = new Mahasiswa[daftarNama.length];

        System.out.println("====================================");
        System.out.println("     PROGRAM DATA MAHASISWA");
        System.out.println("====================================");
        System.out.println("Jumlah object mahasiswa: " + daftarNama.length);

        for (int i = 0; i < daftarNama.length; i++) {
            System.out.println("\\nData mahasiswa ke-" + (i + 1));
            System.out.println("Nama: " + daftarNama[i]);

            System.out.print("NIM: ");
            String nim = input.nextLine();

            double nilai;
            while (true) {
                System.out.print("Nilai (0-100): ");
                if (input.hasNextDouble()) {
                    nilai = input.nextDouble();
                    input.nextLine();

                    if (nilai >= 0 && nilai <= 100) {
                        break;
                    }
                    System.out.println("Nilai harus berada di antara 0 sampai 100.");
                } else {
                    System.out.println("Input nilai harus berupa angka.");
                    input.nextLine();
                }
            }

            daftarMahasiswa[i] = new Mahasiswa(daftarNama[i], nim, nilai);
        }

        System.out.println("\\n========== HASIL DATA MAHASISWA ==========");
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            System.out.println("\\nMahasiswa ke-" + (i + 1));
            daftarMahasiswa[i].tampilkanData();
        }

        System.out.println("\\nProgram selesai. Terima kasih!");
        input.close();
    }
}
