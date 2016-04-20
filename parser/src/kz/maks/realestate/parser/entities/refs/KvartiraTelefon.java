package kz.maks.realestate.parser.entities.refs;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_gen", sequenceName = "kvartira_telefon_seq")
public class KvartiraTelefon extends AbstractRefEntity {
}
