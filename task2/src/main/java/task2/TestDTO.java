package task2;

public class TestDTO {
    public static void main(String[] args) {
        FirstDTO firstDTO = new FirstDTO();
        firstDTO.setField5("field5");

        SecondDTO secondDTO = new SecondDTO();
        secondDTO.setField6(77);

        DTORunner dtoRunner = new DTORunner(firstDTO);
        DTORunner dtoRunner1 = new DTORunner(secondDTO);

        System.out.println(dtoRunner.getUniqueField());
        System.out.println(dtoRunner1.getUniqueField());


    }
}
