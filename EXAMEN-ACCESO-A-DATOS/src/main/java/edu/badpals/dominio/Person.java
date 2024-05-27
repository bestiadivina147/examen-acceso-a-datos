package edu.badpals.dominio;

public enum Person {
    MUGGLE("MUGGLE"), 
    SQUIB("SQUIB"), 
    NOMAJ("NOMAJ"), 
    MUDBLOOD("MUDBLOOD");

    private String nombre;
    private Person(String nombre) {
        this.nombre = nombre;
    }
    public String getPerson(Person person) {
        return this.nombre;
    }
}
