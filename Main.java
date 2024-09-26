public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();

        Stream stream1 = new Stream();
        stream1.addGroup(new StudyGroup("Группа 101"));
        stream1.addGroup(new StudyGroup("Группа 102"));

        Stream stream2 = new Stream();
        stream2.addGroup(new StudyGroup("Группа 201"));

        Stream stream3 = new Stream();
        stream3.addGroup(new StudyGroup("Группа 301"));
        stream3.addGroup(new StudyGroup("Группа 302"));
        stream3.addGroup(new StudyGroup("Группа 303"));
        
        controller.addStream(stream1);
        controller.addStream(stream2);
        controller.addStream(stream3);
        
        System.out.println("Перед сортировкой:");
        controller.outStreams();

        controller.sortStreams();

        System.out.println("\nПосле сортировки:");
        controller.outStreams();
    }
}
