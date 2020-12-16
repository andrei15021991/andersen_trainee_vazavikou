package task2;

public class FirstDTO extends DTO {
    private String field5;


    public void setField5(String field5) {
        this.field5 = field5;
    }

    @Override
    public String getField() {
        return field5;
    }
}
