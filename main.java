package main;

import java.util.ArrayList;
import java.util.Scanner;
import grade.GradeMahasiswa;


// Kelas utama untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //untuk menyimpan data mahasiswa
        ArrayList<GradeMahasiswa> mahasiswaList = new ArrayList<>();
        ArrayList<String> namaLulus = new ArrayList<>();
        ArrayList<String> namaTidakLulus = new ArrayList<>();
        ArrayList<String> namaGradeA = new ArrayList<>();
        ArrayList<String> namaGradeB = new ArrayList<>();
        ArrayList<String> namaGradeD = new ArrayList<>();

        // Input jumlah mahasiswa
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = scanner.nextInt();
        scanner.nextLine(); 

        // Input data mahasiswa
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("\nData Mahasiswa ke-" + (i + 1));
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan Nilai: ");
            int nilai = scanner.nextInt();
            scanner.nextLine(); 

            GradeMahasiswa mahasiswa = new GradeMahasiswa(nim, nama, nilai);
            mahasiswaList.add(mahasiswa);
        }

        // Variabel untuk menghitung statistik
        int jumlahLulus = 0;
        int jumlahTidakLulus = 0;
        int jumlahGradeA = 0;
        int jumlahGradeB = 0;
        int jumlahGradeD = 0;
        double totalNilai = 0;

        // Proses setiap mahasiswa
        System.out.println("\nHasil:");
        for (GradeMahasiswa m : mahasiswaList) {
            String grade = m.getGrade();
            System.out.println("NIM : " + m.getNim());
            System.out.println("Nama: " + m.getNama());
            System.out.println("Nilai : " + m.getNilai());
            System.out.println("Grade: " + grade);
            System.out.println("----------------");

            totalNilai += m.getNilai();

            if (m.getNilai() >= 60) {
                jumlahLulus++;
                namaLulus.add(m.getNama());
            } else {
                jumlahTidakLulus++;
                namaTidakLulus.add(m.getNama());
            }

            switch (grade) {
                case "A":
                    jumlahGradeA++;
                    namaGradeA.add(m.getNama());
                    break;
                case "B":
                    jumlahGradeB++;
                    namaGradeB.add(m.getNama());
                    break;
                case "D":
                    jumlahGradeD++;
                    namaGradeD.add(m.getNama());
                    break;
            }
        }

        // Output untuk menampilkan statistik
        System.out.println("Jumlah Mahasiswa: " + jumlahMahasiswa);
        System.out.println("Jumlah Mahasiswa yg Lulus: " + jumlahLulus + " yaitu " + (namaLulus.isEmpty() ? "Tidak ada" : String.join(", ", namaLulus)));
        System.out.println("Jumlah Mahasiswa yg Tidak Lulus: " + jumlahTidakLulus + " yaitu " + (namaTidakLulus.isEmpty() ? "Tidak ada" : String.join(", ", namaTidakLulus)));
        System.out.println("Jumlah Mahasiswa dengan Nilai A: " + jumlahGradeA + " yaitu " + (namaGradeA.isEmpty() ? "Tidak ada" : String.join(", ", namaGradeA)));
        System.out.println("Jumlah Mahasiswa dengan Nilai B: " + jumlahGradeB + " yaitu " + (namaGradeB.isEmpty() ? "Tidak ada" : String.join(", ", namaGradeB)));
        System.out.println("Jumlah Mahasiswa dengan Nilai D: " + jumlahGradeD + " yaitu " + (namaGradeD.isEmpty() ? "Tidak ada" : String.join(", ", namaGradeD)));
        System.out.println("Rata-rata nilai mahasiswa adalah: " + (totalNilai / jumlahMahasiswa));

        scanner.close();
    }
}
