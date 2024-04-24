package jcsalerno.com.br.imageliteapi.domain.service;
import jcsalerno.com.br.imageliteapi.domain.entity.Image;
import java.util.Optional;

public interface ImageService {
    Image save(Image image);

    Optional<Image> getById(String id);
}
