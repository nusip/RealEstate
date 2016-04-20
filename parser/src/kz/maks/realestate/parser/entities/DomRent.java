package kz.maks.realestate.parser.entities;

import kz.maks.realestate.parser.entities.refs.KakSdayete;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;

@Entity
@Audited
@SequenceGenerator(name = "id_gen", sequenceName = "dom_rent_seq")
public class DomRent extends AbstractDomEntity {
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
