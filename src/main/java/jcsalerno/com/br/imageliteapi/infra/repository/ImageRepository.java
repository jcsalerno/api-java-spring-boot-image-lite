package jcsalerno.com.br.imageliteapi.infra.repository;
import jcsalerno.com.br.imageliteapi.domain.enaums.ImageExtension;
import jcsalerno.com.br.imageliteapi.domain.entity.Image;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {

    default List<Image> findByExtensionAndNameOrTagsLike(ImageExtension extension, String query){
        Specification<Image> conjunction = ((root, query1, criteriaBuilder) -> criteriaBuilder.conjunction());
        Specification<Image> spec = Specification.where(conjunction);

        if(extension != null){
            Specification<Image> extensionEqual = ((root, query1, cb) -> cb.equal(root.get("extension"), extension));
            spec = spec.and(extensionEqual);
        }

        if(StringUtils.hasText(query)){

            Specification<Image> nameLike =((root, query1, cb) -> cb.like(cb.upper(root.get("name")), "%" + query.toUpperCase() + "%"));;
            Specification<Image> tagsLike =((root, query1, cb) -> cb.like(cb.upper(root.get("tags")), "%" + query.toUpperCase() + "%"));;

            Specification<Image> nameOrTagsLike = Specification.anyOf(nameLike, tagsLike);

            spec = spec.and(nameOrTagsLike);
        }
        return findAll();
    }
}
