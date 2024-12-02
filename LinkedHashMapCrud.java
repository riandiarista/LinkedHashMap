import java.util.*;

public class LinkedHashMapCrud {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat LinkedHashMap untuk menyimpan data
        LinkedHashMap<Integer, String> dataMap = new LinkedHashMap<>();

        while (true) {
            try {
                System.out.println("\n==== MENU ====");
                System.out.println("1. Tambah Data");
                System.out.println("2. Edit Data");
                System.out.println("3. Hapus Data");
                System.out.println("4. Lihat Data");
                System.out.println("5. Cari Data");
                System.out.println("6. Keluar");
                System.out.print("Pilih opsi: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Membersihkan buffer input

                switch (choice) {
                    case 1 -> {
                        try {
                            // Tambah Data
                            System.out.print("Masukkan ID (angka): ");
                            int id = scanner.nextInt();
                            scanner.nextLine(); // Membersihkan buffer input
                            System.out.print("Masukkan Nama: ");
                            String name = scanner.nextLine();

                            // Validasi nama hanya boleh huruf
                            if (!name.matches("[a-zA-Z ]+")) {
                                System.out.println("Mohon input nama dengan benar (hanya huruf).");
                                continue;
                            }

                            if (dataMap.containsKey(id)) {
                                System.out.println("ID sudah ada. Gunakan opsi Edit untuk mengubah data.");
                            } else {
                                dataMap.put(id, name);
                                System.out.println("Data berhasil ditambahkan.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Mohon input data yang sesuai (ID harus angka).");
                            scanner.nextLine(); // Membersihkan input buffer
                        }
                    }

                    case 2 -> {
                        try {
                            // Edit Data
                            System.out.print("Masukkan ID yang ingin diedit: ");
                            int editId = scanner.nextInt();
                            scanner.nextLine(); // Membersihkan buffer input
                            if (dataMap.containsKey(editId)) {
                                System.out.print("Masukkan Nama baru: ");
                                String newName = scanner.nextLine();

                                // Validasi nama hanya boleh huruf
                                if (!newName.matches("[a-zA-Z ]+")) {
                                    System.out.println("Mohon input nama dengan benar (hanya huruf).");
                                    continue;
                                }

                                dataMap.put(editId, newName);
                                System.out.println("Data berhasil diperbarui.");
                            } else {
                                System.out.println("ID tidak ditemukan.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Mohon input data yang sesuai (ID harus angka).");
                            scanner.nextLine(); // Membersihkan input buffer
                        }
                    }

                    case 3 -> {
                        try {
                            // Hapus Data
                            System.out.print("Masukkan ID yang ingin dihapus: ");
                            int deleteId = scanner.nextInt();
                            scanner.nextLine(); // Membersihkan buffer input
                            if (dataMap.containsKey(deleteId)) {
                                dataMap.remove(deleteId);
                                System.out.println("Data berhasil dihapus.");
                            } else {
                                System.out.println("ID tidak ditemukan.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Mohon input data yang sesuai (ID harus angka).");
                            scanner.nextLine(); // Membersihkan input buffer
                        }
                    }

                    case 4 -> {
                        // Lihat Data
                        System.out.println("\n=== Data ===");
                        if (dataMap.isEmpty()) {
                            System.out.println("Tidak ada data.");
                        } else {
                            int no = 1;
                            for (Map.Entry<Integer, String> entry : dataMap.entrySet()) {
                                System.out.println(no + ". ID: " + entry.getKey() + ", Nama: " + entry.getValue());
                                no++;
                            }
                        }
                    }

                    case 5 -> {
                        // Cari Data
                        System.out.println("\n1. Cari berdasarkan ID");
                        System.out.println("2. Cari berdasarkan Nama");
                        System.out.print("Pilih jenis pencarian: ");
                        int searchChoice = scanner.nextInt();
                        scanner.nextLine(); // Membersihkan buffer input

                        switch (searchChoice) {
                            case 1 -> {
                                // Cari berdasarkan ID
                                System.out.print("Masukkan ID yang dicari: ");
                                int searchId = scanner.nextInt();
                                scanner.nextLine(); // Membersihkan buffer input

                                if (dataMap.containsKey(searchId)) {
                                    System.out.println("Data ditemukan: ID: " + searchId + ", Nama: " + dataMap.get(searchId));
                                } else {
                                    System.out.println("Data dengan ID tersebut tidak ditemukan.");
                                }
                            }

                            case 2 -> {
                                // Cari berdasarkan Nama
                                System.out.print("Masukkan Nama yang dicari: ");
                                String searchName = scanner.nextLine();
                                boolean found = false;

                                for (Map.Entry<Integer, String> entry : dataMap.entrySet()) {
                                    if (entry.getValue().equalsIgnoreCase(searchName)) {
                                        System.out.println("Data ditemukan: ID: " + entry.getKey() + ", Nama: " + entry.getValue());
                                        found = true;
                                        break;
                                    }
                                }

                                if (!found) {
                                    System.out.println("Data dengan Nama tersebut tidak ditemukan.");
                                }
                            }

                            default -> System.out.println("Jenis pencarian tidak valid.");
                        }
                    }

                    case 6 -> {
                        // Keluar
                        System.out.println("Keluar dari program. Terima kasih!");
                        scanner.close();
                        return;
                    }

                    default -> System.out.println("Mohon input data yang sesuai (pilihan menu tidak valid).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Mohon input data yang sesuai (pilihan menu harus angka).");
                scanner.nextLine(); // Membersihkan input buffer
            }
        }
    }
}
