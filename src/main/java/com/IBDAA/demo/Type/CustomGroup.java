package com.IBDAA.demo.Type;

import com.IBDAA.demo.Models.Candidat;
import com.IBDAA.demo.Models.Groupe;
import com.IBDAA.demo.Models.Sceance;

import javax.persistence.*;
import java.util.List;

public class CustomGroup {

    Groupe groupe;
    List<Candidat> candidats;

    public CustomGroup(Groupe groupe, List<Candidat> candidats) {
        this.groupe = groupe;
        this.candidats = candidats;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public List<Candidat> getCandidats() {
        return candidats;
    }

    public void setCandidats(List<Candidat> candidats) {
        this.candidats = candidats;
    }

    @Override
    public String toString() {
        return "CustomGroup{" +
                "groupe=" + groupe +
                ", candidats=" + candidats +
                '}';
    }
}
