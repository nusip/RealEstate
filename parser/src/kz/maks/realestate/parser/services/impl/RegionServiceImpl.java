package kz.maks.realestate.parser.services.impl;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Service;
import kz.maks.core.back.services.impl.AbstractServiceImpl;
import kz.maks.core.shared.Utils;
import kz.maks.realestate.parser.assemblers.entity.RegionAssembler;
import kz.maks.realestate.parser.assemblers.dto.RegionDtoAssembler;
import kz.maks.realestate.parser.assemblers.parser.RegionEntityAssembler;
import kz.maks.realestate.parser.entities.Region;
import kz.maks.realestate.parser.models.KrishaRegion;
import kz.maks.realestate.parser.services.RegionService;
import kz.maks.realestate.shared.dtos.RegionDto;
import org.hibernate.Criteria;

import java.util.Date;
import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;
import static org.hibernate.criterion.Restrictions.isNull;

@Service
public class RegionServiceImpl extends AbstractServiceImpl implements RegionService {

    @Inject
    private RegionEntityAssembler regionEntityAssembler;

    @Inject
    private RegionDtoAssembler regionDtoAssembler;

    @Inject
    private RegionAssembler regionAssembler;

    @Override
    public Region get(Long id) {
        return db.load(Region.class, id);
    }

    @Override
    public Region get(String krishaId) {
        Region region = (Region) session().createCriteria(Region.class).add(eq("krishaId", krishaId)).uniqueResult();
        return region;
    }

    @Override
    public boolean hasAnyRegion() {
        return !session().createCriteria(Region.class).setMaxResults(1).list().isEmpty();
    }

    @Override
    public Region getRegionByName(String name) {
        Region region = (Region) session().createCriteria(Region.class)
                .add(eq("name", name)).add(eq("deleted", false)).uniqueResult();
        return region;
    }

    @Override
    public Region getRegionByNameAndParent(String name, String parentName) {
        Criteria cri = session().createCriteria(Region.class).add(eq("name", name)).add(eq("deleted", false));
        {
            Criteria parentCri = cri.createCriteria("parent");
            parentCri.add(eq("name", parentName));
        }
        Region region = (Region) cri.uniqueResult();
        return region;
    }

    @Override
    public void saveRootRegions(List<KrishaRegion> regions) {
        saveRegionsInner(regions, null);
    }

    @Override
    public RegionDto getRoot() {
        Region rootRegion = (Region) session().createCriteria(Region.class).add(isNull("parent")).uniqueResult();
        RegionDto regionDto = regionDtoAssembler.assemble(rootRegion, new RegionDto());
        return regionDto;
    }

    private void saveRegionsInner(List<KrishaRegion> regions, Region parent) {
        for (KrishaRegion krishaRegion : regions) {
            Region region = (Region) session().createCriteria(Region.class)
                    .add(eq("krishaId", krishaRegion.getId())).uniqueResult();

            if (region == null) {
                region = new Region();
                region.setDeleted(false);
            }

            region = regionEntityAssembler.assemble(krishaRegion, region);

            db.save(region);

            region.setParent(parent);

            if (parent != null) {
                parent.getChildren().add(region);
            }

            region.setPath(Utils.getTreePath(region));
            region.setUpdatedAt(new Date().getTime());

            saveRegionsInner(krishaRegion.getChildren(), region);
        }
    }

    @Override
    public void saveRootRegion(RegionDto regionDto) {
        saveRegionInner(regionDto, null);
    }

    private void saveRegionInner(RegionDto regionDto, Region parent) {
        Region region = null;

        if (regionDto.getId() == null && regionDto.getKrishaId() != null) {
            region = (Region) session().createCriteria(Region.class)
                    .add(eq("krishaId", regionDto.getKrishaId())).uniqueResult();

            if (region != null)
                regionDto.setId(region.getId());
        }

        if (region == null)
            region = new Region();

        region = regionAssembler.assemble(regionDto, region);

        db.save(region);

        region.setParent(parent);
        region.setPath(Utils.getTreePath(region));

        if (parent != null) {
            parent.getChildren().add(region);
            db.save(parent);
        }

        for (RegionDto childDto : regionDto.getChildren()) {
            saveRegionInner(childDto, region);
        }
    }

}
