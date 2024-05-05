package cy.olesiabokk.userflowapp.controller;

import cy.olesiabokk.userflowapp.model.entity.User;
import cy.olesiabokk.userflowapp.model.service.util.UserService;
import cy.olesiabokk.userflowapp.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ControllerImpl implements Controller {
    private ArrayList<User.Builder> userList;
    private final UserService userService;
    private final View view;

    public ControllerImpl(ArrayList<User.Builder> arrayList, UserService userService, View view){
        this.userList = arrayList;
        this.userService = userService;
        this.view = view;
    }

    @Override
    public Stream<User.Builder> requestUserListStream() {
        return userList.stream();
    }

    public Stream<User> initializeUserListStream(){
        return userService.initializeUserList(requestUserListStream());
    }

    @Override
    public Stream<User> sortDesc(List<User> sortUserList){
        return userService.sortDescUserList(sortUserList.stream());
    }

    @Override
    public Stream<User> filterEvenIdUsers(List<User> evenUserList) {
        return userService.filterEvenIdUserList(evenUserList.stream());
    }

    @Override
    public Optional<User> checkSameIdAndAgeUserList(List<User> sameIdAgeUserList) {
        return userService.checkSameIdAndAgeUserList(sameIdAgeUserList.stream());
    }

    @Override
    public void printUsersSameIdAge(Optional<User> optional) {
        view.printUsersSameIdAge(optional);
    }

    @Override
    public void printCollection(List<User> userList) {
        view.printCollection(userList);
    }


}
