package agin.llc1.llc1.observer;

public class UserObserver implements TableObserver {

    private final String userEmail;

    public UserObserver(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String notify(Long tableId) {
        return "Notificare trimisă către " + userEmail + ": Masa " + tableId + " este acum liberă.";
    }
}
