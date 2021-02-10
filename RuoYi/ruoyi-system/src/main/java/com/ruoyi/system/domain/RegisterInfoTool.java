package com.ruoyi.system.domain;

/**
 * @Classname registerInfoTool
 * @Author ZhangGY
 * @Date 2021/1/24 15:47
 **/
public class RegisterInfoTool {

    RegisterInfo registerInfo;
    Antibody     antibody;
    Plasmid      plasmid;
    Cell         cell;
    Microbial microbial;
    Animal animal;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Microbial getMicrobial() {
        return microbial;
    }

    public void setMicrobial(Microbial microbial) {
        this.microbial = microbial;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Plasmid getPlasmid() {
        return plasmid;
    }

    public void setPlasmid(Plasmid plasmid) {
        this.plasmid = plasmid;
    }

    public RegisterInfo getRegisterInfo() {
        return registerInfo;
    }

    public void setRegisterInfo(RegisterInfo registerInfo) {
        this.registerInfo = registerInfo;
    }

    public Antibody getAntibody() {
        return antibody;
    }

    public void setAntibody(Antibody antibody) {
        this.antibody = antibody;
    }
}
