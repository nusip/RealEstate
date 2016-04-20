package kz.maks.realestate.parser.entities;

import kz.maks.realestate.parser.entities.refs.KakSdayete;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Audited
@SequenceGenerator(name = "id_gen", sequenceName = "kvartira_rent_seq")
public class KvartiraRent extends AbstractKvartiraEntity {
    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private KakSdayete kakSdayete;

    public KakSdayete getKakSdayete() {
        return kakSdayete;
    }

    public void setKakSdayete(KakSdayete kakSdayete) {
        this.kakSdayete = kakSdayete;
    }
}
