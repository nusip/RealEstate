package kz.maks.realestate.parser.entities.refs;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_gen", sequenceName = "kak_sdayete_seq")
public class KakSdayete extends AbstractRefEntity {
}
