package company.view;

import company.controller.LabelController;
import company.model.Label;

import java.util.List;
import java.util.Scanner;

public class LabelView implements View<Label> {
    private final LabelController labelController = new LabelController();
    private final Scanner labelScanner = new Scanner(System.in);

    @Override
    public Label create() {
        System.out.println("Create Label model !");
        String name = labelScanner.next();
        Label label = labelController.save(new Label(name));
        System.out.printf("Created id - %d, Created name - %s", label.getId(), label.getName());
        return label;
    }

    @Override
    public List<Label> getAll() {
        return labelController.getAll();
    }

    @Override
    public void delete() {
        System.out.println("Enter id number ");
        labelController.delete(labelScanner.nextInt());
    }

    @Override
    public Label update() {
        System.out.println("Enter the Label id for update");
        int id = labelScanner.nextInt();
        System.out.println("Enter the Label name for update");
        String name = labelScanner.next();
        return labelController.update(new Label(id, name));
    }

    @Override
    public Label get() {
        System.out.println("Enter id number ");
        Integer id = labelScanner.nextInt();
        return labelController.findById(id);
    }

    @Override
    public void close() {
        labelScanner.close();
    }
}
