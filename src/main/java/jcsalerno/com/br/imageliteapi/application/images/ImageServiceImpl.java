package jcsalerno.com.br.imageliteapi.application.images;
import jcsalerno.com.br.imageliteapi.domain.entity.Image;
import jcsalerno.com.br.imageliteapi.domain.service.ImageService;

import jcsalerno.com.br.imageliteapi.infra.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository repository;
    @Override
    @Transactional
    public Image save(Image image) {
        return repository.save(image);
    }
}
