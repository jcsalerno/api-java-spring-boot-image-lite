package jcsalerno.com.br.imageliteapi.infra.repository;
import jcsalerno.com.br.imageliteapi.domain.enaums.ImageExtension;
import jcsalerno.com.br.imageliteapi.domain.entity.Image;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;
import java.util.List;
import static jcsalerno.com.br.imageliteapi.infra.repository.specs.GenericSpecs.conjunction;
import static jcsalerno.com.br.imageliteapi.infra.repository.specs.ImageSpecs.*;
import static org.springframework.data.jpa.domain.Specification.anyOf;
import static org.springframework.data.jpa.domain.Specification.where;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {

    default List<Image> findByExtensionAndNameOrTagsLike(ImageExtension extension, String query){
        Specification<Image> spec = where(conjunction());

        if(extension != null){
            spec = spec.and(extensionEqual(extension));
        }

        if(StringUtils.hasText(query)){
            spec = spec.and(anyOf(nameLike(query), tagsLike(query)));
        }
        return findAll();
    }
}