package task4;

public class FirstDTO extends DTO {
    private String field5;
    private String field6;

    public FirstDTO() {
        field5 = "field5";
        field6 = "field6";
    }

    public void getField5() {
        System.out.println(field5);
    }

    public void getField6() {
        System.out.println(field6);
    }

}
