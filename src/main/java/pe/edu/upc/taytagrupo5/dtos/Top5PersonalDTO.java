package pe.edu.upc.taytagrupo5.dtos;

public class Top5PersonalDTO {
    private String full_name;
    private Double average;

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average, int i) {
        this.average = average;
    }
}
