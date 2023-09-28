package com.example.tcc;

public class MovimentoOBJ {

    String id, Rua, Numero, Bairro, CEP, PontoRef, Complemento , Leve, Moderado, Severo  ;

    public MovimentoOBJ(String id, String rua, String numero, String bairro, String CEP, String pontoRef, String complemento) {
        this.id = id;
        Rua = rua;
        Numero = numero;
        Bairro = bairro;
        this.CEP = CEP;
        PontoRef = pontoRef;
        Complemento = complemento;
    }

    public MovimentoOBJ(String id, String strRua, String strBairro, String strLeve, String strModerado, String strSevero) {
        this.id = id;
        Rua = strRua;
        Bairro = strBairro;
        Severo = strSevero;
        Leve = strLeve;
        Moderado = strModerado;

    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getPontoRef() {
        return PontoRef;
    }

    public void setPontoRef(String pontoRef) {
        PontoRef = pontoRef;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }
}
