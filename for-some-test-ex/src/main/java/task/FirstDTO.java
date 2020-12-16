package task;

public class FirstDTO extends DTO{
    private String field5;

    public String getField5(){
        return field5;
    }

    @Override
    public void setUncommonFields() {
        field5 = "some value";
    }
}
