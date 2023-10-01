package API.REST.ForoAlura.controller;


import API.REST.ForoAlura.Topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;


@RestController
@RequestMapping("/foroAlura")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void RegistrarTopico(@RequestBody @Valid RegistroTopico registroTopico){
        topicoRepository.save(new Topico(registroTopico));
    }
//    @GetMapping
//    public List<Topico> mostrarTopico(){
//        return topicoRepository.findAll();
//    }
    @GetMapping(path = "/{id}")
    public Optional<Topico> mostrarTopicoById(@PathVariable Long id){

        return  this.topicoRepository.findById(id);
    }
    @GetMapping
    public Page<DatosListadoTopico> mostrarTopico(@PageableDefault(size = 9) Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);

    }


    @DeleteMapping("/{id}")
    @Transactional
    public void deleteTopic(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);

    }
    @PutMapping
    @Transactional
    public void actualizarTopic(@RequestBody @Valid ActualizarTopico actualizarTopico){
        Topico topico = topicoRepository.getReferenceById(actualizarTopico.id());
        topico.actualizar(actualizarTopico);

    }

}
