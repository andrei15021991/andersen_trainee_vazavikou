package task2;

public class DTORunner {
    private DTO dto;

    public DTORunner(DTO dto){
        this.dto = dto;
    }

    public Object getUniqueField(){
        return dto.getField();
    }


}
