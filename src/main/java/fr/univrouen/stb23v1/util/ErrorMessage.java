package fr.univrouen.stb23v1.util;

public class ErrorMessage {
    private Long id;
    private String status;

    public ErrorMessage(Long id2, String status) {
        this.id = id2;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
