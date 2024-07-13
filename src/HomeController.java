public class HomeController {
    HomeModel homeModel;

    HomeController() {
        homeModel = new HomeModel();
    }

    boolean validateOption(int option) {
        return option == 1 || option == 2 || option == 3;
    }

    void executeOption(int option) {
        if(option == 1) {
            new HomeView().showBooks(homeModel.getBooks());
        }
    }
}

// HV -> HC -> HM:getBook()
