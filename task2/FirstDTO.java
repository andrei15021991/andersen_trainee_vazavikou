package task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FirstDTO extends DTO {
    private String field5;
    private Integer field7;


    public void setField5(String field5) {
        this.field5 = field5;
    }

    public void setField7(Integer field7) {
        this.field7 = field7;
    }

    @Override
    public List<Object> getField() {
        List<Object> objects = new ArrayList<>();
        objects.add(field5);
        objects.add(field7);

        return objects;
    }
}
