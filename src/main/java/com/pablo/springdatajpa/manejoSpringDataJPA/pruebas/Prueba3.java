package com.pablo.springdatajpa.manejoSpringDataJPA.pruebas;

import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity3.Editor;
import com.pablo.springdatajpa.manejoSpringDataJPA.entities.entity3.Revista;
import com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository3.EditorRepository;
import com.pablo.springdatajpa.manejoSpringDataJPA.repositories.repository3.RevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Component
public class Prueba3 implements CommandLineRunner {
    @Autowired
    private EditorRepository editorRepository;
    @Autowired
    private RevistaRepository revistaRepository;
    @Override
    public void run(String... args) throws Exception {
        //Crear Editor
        Editor editor = new Editor();
        editor.setNombre("Analla");

        //Crear Revistas y agragarlas al editor
        Revista revista1 = new Revista();
        revista1.setNombre("Revista deportiva");
        revista1.setEditor(editor);

        Revista revista2 = new Revista();
        revista2.setNombre("Revista educativa");
        revista2.setEditor(editor);
        //Agrega las revistas
        editor.getRevistas().add(revista1);
        editor.getRevistas().add(revista2);
        //Guarda el editor y sus revistas automaticamente
        editorRepository.save(editor);

        //Leer el editor recien guardado y sus revistas
        Optional<Editor> editorGuardado = editorRepository.findById(editor.getId());
        if(editorGuardado.isPresent()){
            Editor editorObtenido = editorGuardado.get();
            System.out.println("Editor obtenido: "+editorObtenido.getNombre());
            editorObtenido.getRevistas().size();

            //Actualizar nombre del editor
            editorObtenido.setNombre("Anaya");
            editorRepository.save(editorObtenido);
            System.out.println("Editor Actualizado: "+ editorObtenido.getNombre());

            //Crear una nueva revista
            Revista revista3 = new Revista();
            revista3.setNombre("Revista informativa");
            revista3.setEditor(editorObtenido);
            revistaRepository.save(revista3);
            System.out.println("Revista creada: "+revista3.getNombre());

            Optional<Revista> revistaOpcional = revistaRepository.findById(revista1.getId());
            if (revistaOpcional.isPresent()){
                Revista revEliminar = revistaOpcional.get();
                revistaRepository.delete(revEliminar);
                System.out.println("Revista eliminada: "+ revEliminar.getNombre());
            }else{
                System.out.println("Revista no encontrada");
            }
        }else{
            System.out.println("Editor no encontrado");
        }

    }
}
