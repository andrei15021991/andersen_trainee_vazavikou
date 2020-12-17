package task3;

public abstract class DTO {
    private String fieldName;

    public DTO(String fieldName){
        this.fieldName = fieldName;
    }

    public String getFieldName(){
        return fieldName;
    }

    public abstract Object getUniqueField();
}
