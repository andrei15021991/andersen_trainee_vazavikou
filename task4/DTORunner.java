package task4;

public class DTORunner {

    public void showUniqueFields(DTO dto){
        if(dto.getClass().equals(FirstDTO.class)){
            ((FirstDTO) dto).getField5();
            ((FirstDTO) dto).getField6();
        }
        if(dto.getClass().equals(SecondDTO.class)){
            ((SecondDTO) dto).getField7();
        }
    }
}
