package com.reto3.com.reto3.CreacionHoteles.modelo.DTOs;

public class CountStatus {
    private int completed;
    private int cancelled;

    public CountStatus(int completed, int cancelled){
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
}
