package agin.llc1.llc1.adapter;

public class ExternalCourierService {
    public void sendPackage(Long packageId, String destination) {
        System.out.println("Livrare prin serviciul extern: Comanda " + packageId + " catre " + destination);
    }
}
