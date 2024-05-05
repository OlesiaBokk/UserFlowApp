package cy.olesiabokk.userflowapp.main;

import cy.olesiabokk.userflowapp.controller.ControllerImpl;
import cy.olesiabokk.userflowapp.model.entity.User;
import cy.olesiabokk.userflowapp.model.service.UserServiceImpl;
import cy.olesiabokk.userflowapp.model.service.util.Generator;
import cy.olesiabokk.userflowapp.model.service.util.Randomizer;
import cy.olesiabokk.userflowapp.view.ViewImpl;

import java.util.ArrayList;
import java.util.List;

import static cy.olesiabokk.userflowapp.model.entity.User.newBuilder;

public class Main {
    public static void main(String[] args) {
        ArrayList<User.Builder> userList = createUserList();

        Randomizer randomizer = new Randomizer();
        Generator generator = new Generator(randomizer);
        UserServiceImpl userServiceImpl = new UserServiceImpl(generator);
        ViewImpl viewImpl = new ViewImpl();

        ControllerImpl controller = new ControllerImpl(userList, userServiceImpl, viewImpl);
        System.out.println("Print initialized user list:");
        List<User> initializedUserList = controller.initializeUserListStream().toList();
        controller.printCollection(initializedUserList);

        System.out.println("Print desc userID sorted list:");
        List<User> sortedDescUserList = controller.sortDesc(initializedUserList).toList();
        controller.printCollection(sortedDescUserList);

        System.out.println("Print even userID list from desc sorted list");
        List<User> evenIdUserList = controller.filterEvenIdUsers(sortedDescUserList).toList();
        controller.printCollection(evenIdUserList);

        System.out.println("Print user list having equal ID and Age from even userID list:");
        controller.printUsersSameIdAge(controller.checkSameIdAndAgeUserList(evenIdUserList));
    }

    public static ArrayList<User.Builder> createUserList(){
        ArrayList<User.Builder> userList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            userList.add(newBuilder());
        }
        return userList;
    }

}
