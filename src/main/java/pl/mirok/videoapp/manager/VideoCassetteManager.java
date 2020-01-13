package pl.mirok.videoapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.mirok.videoapp.dao.VideoCassetteRepo;
import pl.mirok.videoapp.dao.entity.VideoCassette;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VideoCassetteManager {

    private VideoCassetteRepo videoCassetteRepo;

    @Autowired
    public VideoCassetteManager(VideoCassetteRepo videoCassetteRepo) {
        this.videoCassetteRepo = videoCassetteRepo;
    }

    public VideoCassette findById(Long id)
    {
        Optional<VideoCassette>  video = videoCassetteRepo.findById(id);
        return video.get();
    }

    public Iterable<VideoCassette> findAll()
    {
        return videoCassetteRepo.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette)
    {
        return videoCassetteRepo.save(videoCassette);
    }

    public void deleteById(Long id)
    {
        videoCassetteRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillToDB()
    {
        videoCassetteRepo.save(new VideoCassette(1L, "Titanic", LocalDate.of(1998, 4, 1)));
        videoCassetteRepo.save(new VideoCassette(2L, "Kiler", LocalDate.of(1988, 3, 21)));
    }
}
