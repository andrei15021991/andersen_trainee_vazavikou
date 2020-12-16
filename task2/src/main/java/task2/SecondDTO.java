package task2;

public class SecondDTO extends DTO{
    private Integer field6;

    public void setField6(Integer field6){
        this.field6 = field6;
    }

    @Override
    public Integer getField() {
        return field6;
    }
}
