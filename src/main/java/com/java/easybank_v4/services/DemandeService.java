package com.java.easybank_v4.services;

import com.java.easybank_v4.Entities.DemanderCredit;
import com.java.easybank_v4.dao.Interfaces.DemandeI;

import java.util.List;
import java.util.Optional;

public class DemandeService {
    private DemandeI demandeI;
    public DemandeService(DemandeI demandeI) {
        this.demandeI = demandeI;
    }
//    public void setDemandeI(DemandeI demandeI){
//        this.demandeI = demandeI;
//    }
    public Optional<DemanderCredit> ajouter(DemanderCredit demande) {
        Optional<DemanderCredit> optdemande=demandeI.ajoute(demande);
        return optdemande;
    }
    public List<DemanderCredit>  afficher() {
        return demandeI.afficher();
    }
    public boolean changerEtat(int demandeId,String etat){
        try {
            if (demandeI.changerEtat(demandeId,etat)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
