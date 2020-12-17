package task3;

public class SecondField extends DTO {
    private String field8;

    public SecondField(String fieldName) {
        super(fieldName);

        field8 = "field8";
    }

    @Override
    public Object getUniqueField() {
        if (getFieldName().equals("f8"))
            return field8;

        return null;
    }
}
