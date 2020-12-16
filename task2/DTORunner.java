package task2;

import java.util.List;

public class DTORunner {
    private DTO dto;

    public DTORunner(DTO dto){
        this.dto = dto;
    }

    public List<Object> getUniqueField(){
        return dto.getField();
    }


}
