package Models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Formateur extends User{

    @OneToMany(mappedBy = "sceance_formateur",cascade= CascadeType.ALL)
    List<Sceance> sceances;

}
