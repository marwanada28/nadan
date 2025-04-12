package grade;

import model.Mahasiswa;

public class GradeMahasiswa extends Mahasiswa {
    public GradeMahasiswa(String nim, String nama, int nilai) {
        super(nim, nama, nilai);
    }

    @Override
    public String getGrade() {
        if (nilai >= 80 && nilai <= 100) {
            return "A";
        } else if (nilai >= 70 && nilai <= 79) {
            return "B";
        } else if (nilai >= 60 && nilai <= 69) {
            return "C";
        } else if (nilai >= 50 && nilai <= 59) {
            return "D";
        } else if (nilai < 50) {
            return "E";
        } else {
            return "Input nilai anda salah";
        }
    }
}
