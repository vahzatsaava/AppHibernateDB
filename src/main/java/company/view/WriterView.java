package company.view;

import company.controller.WriterController;
import company.model.Writer;

import java.util.List;
import java.util.Scanner;

public class WriterView implements View<Writer> {
    private final Scanner scanner = new Scanner(System.in);
    private final WriterController writerController = new WriterController();

    @Override
    public Writer create() {
        System.out.println("Enter first name");
        String firstName = scanner.next();
        System.out.println("Enter lastName");
        String lastName = scanner.next();

        return writerController.save(new Writer(firstName, lastName));
    }

    @Override
    public List<Writer> getAll() {
        return writerController.getAll();
    }

    @Override
    public void delete() {
        System.out.println("Enter id Number");
        int id = scanner.nextInt();
        writerController.delete(id);
    }

    @Override
    public Writer update() {
        System.out.println("Enter id number");
        int id = scanner.nextInt();
        System.out.println("Enter first name");
        String firstName = scanner.next();
        System.out.println("Enter lastName");
        String lastName = scanner.next();
        return writerController.update(new Writer(id,firstName,lastName));
    }

    @Override
    public Writer get() {
        System.out.println("Enter id number");
        int id = scanner.nextInt();
        return writerController.findByID(id);
    }

    @Override
    public void close() {
        scanner.close();
    }
}
