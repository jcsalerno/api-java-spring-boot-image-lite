package jcsalerno.com.br.imageliteapi.infra.repository;
import jcsalerno.com.br.imageliteapi.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
}
