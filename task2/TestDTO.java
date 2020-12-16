package task2;

import java.util.List;

public class TestDTO {
    public static void main(String[] args) {
       FirstDTO firstDTO = new FirstDTO();
       firstDTO.setField5("hello world");
       firstDTO.setField7(777);

       DTORunner dtoRunner = new DTORunner(firstDTO);

        List<Object> objects = dtoRunner.getUniqueField();
        objects.forEach(System.out::println);


    }
}
