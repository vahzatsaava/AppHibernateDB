package company.view;

import company.controller.PostController;
import company.model.Post;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class PostView implements View<Post> {
    private final Scanner scannerPost = new Scanner(System.in);
    private final PostController postController = new PostController();
    private final WriterView writerView = new WriterView();

    @Override
    public Post create() {
        System.out.println("Enter content");
        String content = scannerPost.next();
        System.out.println("Enter date");
        Date created = generateTime();
        System.out.println("enter updated time");
        Date updated = generateTime();
        return postController.save(new Post(content, created, updated, writerView.create()));
    }

    @Override
    public List<Post> getAll() {
        return postController.getPosts();
    }

    @Override
    public void delete() {
        System.out.println("Enter id number");
        int id = scannerPost.nextInt();
        postController.delete(id);
    }

    @Override
    public Post update() {
        System.out.println("Enter id number");
        int id = scannerPost.nextInt();
        System.out.println("Enter content");
        String content = scannerPost.next();
        System.out.println("Enter date");
        Date created = generateTime();
        System.out.println("enter updated time");
        Date updated = generateTime();
        return postController.save(new Post(id, content, created, updated, writerView.create()));
    }

    @Override
    public Post get() {
        System.out.println("ENter id number");
        int id = scannerPost.nextInt();
        return postController.findById(id);
    }

    @Override
    public void close() {
        scannerPost.close();
    }

    private Date generateTime() {
        String dataFormat = "";
        while (true) {
            System.out.println("Type years");
            String year = scannerPost.next();
            if (year.length() != 4) {
                System.out.println("Wrong values of hours");
                continue;
            }
            System.out.println("Type months");
            String month = scannerPost.next();
            if (month.length() != 2) {
                System.out.println("Wrong values of months");
                continue;
            }
            System.out.println("Type days");
            String day = scannerPost.next();
            if (day.length() != 2) {
                System.out.println("Wrong values of days");
                continue;
            }

            dataFormat = String.format("%s-%s-%s", year, month, day);
            break;
        }

        return Date.valueOf(dataFormat);
    }

}
