package API.REST.ForoAlura.Topico;

public record ActualizarTopico(Long id, String titulo, String mensaje, String fecha, String autor, String curso) {
    public ActualizarTopico(Topico topico){
        this(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFecha(),topico.getAutor(),topico.getCurso());
    }
}
