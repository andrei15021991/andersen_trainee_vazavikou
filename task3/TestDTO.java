package task3;

public class TestDTO {
    public static void main(String[] args) {
        FirstDTO firstDTO = new FirstDTO("f6");

        DTORunner dtoRunner = new DTORunner();
        System.out.println(dtoRunner.getDTOUniqueField(firstDTO));

    }
}
