package task4;

public class TestDTO {
    public static void main(String[] args) {
        DTORunner dtoRunner = new DTORunner();

        dtoRunner.showUniqueFields(new FirstDTO());
        System.out.println("------------------------------");
        dtoRunner.showUniqueFields(new SecondDTO());

    }
}
