package Models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Groupe {

    @OneToMany(mappedBy = "groupe",cascade= CascadeType.ALL)
    List<Candidat> candidats;

    @OneToMany(mappedBy = "groupe", cascade = CascadeType.ALL)
    List<Sceance> sceances;
}
