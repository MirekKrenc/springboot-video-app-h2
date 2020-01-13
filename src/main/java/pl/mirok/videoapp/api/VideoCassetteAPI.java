package pl.mirok.videoapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mirok.videoapp.dao.entity.VideoCassette;
import pl.mirok.videoapp.manager.VideoCassetteManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vhs")
public class VideoCassetteAPI {

//    List<VideoCassette> videoCassettes;
//
//    public VideoCassetteAPI() {
//        this.videoCassettes = new ArrayList<>();
//        videoCassettes.add(new VideoCassette(1L, "Titanic", LocalDate.of(1998, 4, 1)));
//        videoCassettes.add(new VideoCassette(2L, "Kiler", LocalDate.of(1988, 3, 21)));
//
//    }

    private VideoCassetteManager videoCassetteManager;

    @Autowired
    public VideoCassetteAPI(VideoCassetteManager videoCassetteManager) {
        this.videoCassetteManager = videoCassetteManager;
    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getAll()
    {
        return videoCassetteManager.findAll();
    }

    @GetMapping
    public VideoCassette getById(@RequestParam Long id)
    {
        return videoCassetteManager.findById(id);
    }

    @GetMapping("/{id}")
    public VideoCassette getByIdPath(@PathVariable("id") Long id)
    {
        return videoCassetteManager.findById(id);
    }

    @PostMapping
    public VideoCassette addVideo(@RequestBody VideoCassette videoCassette)
    {
        return videoCassetteManager.save(videoCassette);
    }

    @PutMapping
    public VideoCassette updateVideo(@RequestBody VideoCassette videoCassette)
    {
        return videoCassetteManager.save(videoCassette);
    }

    @DeleteMapping("/{index}")
    public void deletVideo(@PathVariable("index") Long id)
    {
        videoCassetteManager.deleteById(id);
    }
}
