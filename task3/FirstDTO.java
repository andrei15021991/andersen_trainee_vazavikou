package task3;

public class FirstDTO extends DTO {
    private String field6;
    private String field7;

    public FirstDTO(String fieldName) {
        super(fieldName);

        field6 = "field6";
        field7 = "field7";
    }

    @Override
    public Object getUniqueField() {
        if (getFieldName().equals("f6"))
            return field6;
        if (getUniqueField().equals("f7"))
            return field7;

        return null;
    }
}
