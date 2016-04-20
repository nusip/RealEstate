package kz.maks.realestate.parser.entities.refs;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_gen", sequenceName = "dom_telefon_seq")
public class DomTelefon extends AbstractRefEntity {
}
