package task2;

import java.util.ArrayList;
import java.util.List;

public class SecondDTO extends DTO{
    private Integer field6;

    public void setField6(Integer field6){
        this.field6 = field6;
    }

    @Override
    public List<Object> getField() {
        List<Object> objects = new ArrayList<>();
        objects.add(field6);

        return objects;
    }
}
