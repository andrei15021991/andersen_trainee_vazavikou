package task;

public class TestDTO {
    public static void main(String[] args) {
        DTORunner dtoRunner = new DTORunner();
        FirstDTO firstDTO = new FirstDTO();

        dtoRunner.initialize(firstDTO);

        System.out.println(firstDTO.getField5());
    }
}
