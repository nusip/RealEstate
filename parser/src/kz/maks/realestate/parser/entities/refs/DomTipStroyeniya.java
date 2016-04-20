package kz.maks.realestate.parser.entities.refs;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_gen", sequenceName = "dom_tip_stroyeniya_seq")
public class DomTipStroyeniya extends AbstractRefEntity {
}
